package uz.ecommerce.shoes.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Component
public class FileService {

    @Value("${file.upload.path}")
    private String uploadPath;

    @Value("${file.upload.base-url}")
    private String baseUrl;

    public List<String> uploadFiles(List<MultipartFile> files) {
        try {
            // check directory if not exist then create
            checkAndCreateDirectory();

            List<String> fileUrls = new ArrayList<>();

            for (MultipartFile file : files) {
                String uniqueFileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
                String filePath = uploadPath + File.separator + uniqueFileName;
                File destination = new File(filePath);
                file.transferTo(destination);
                fileUrls.add(baseUrl + "/files/" + uniqueFileName);
            }

            return fileUrls;
        } catch (IOException e) {
            throw new RuntimeException("File is not download: " + e.getMessage());
        }
    }

    public void deleteFiles(List<String> fileUrls) {
        try {
            List<String> fileNames = extractFileNameFromPath(fileUrls);
            for (String fileName : fileNames) {
                Path filePath = new File(uploadPath + File.separator + fileName).toPath();
                Files.delete(filePath);
            }
        } catch (IOException e) {
            throw new RuntimeException("File is not delete: " + e.getMessage());
        }
    }

    private List<String> extractFileNameFromPath(List<String> fileUrls) {
        try{
            List<String> decodedFileNames = new ArrayList<>();
            for (String fileUrl : fileUrls) {
                String decodedFileName = URLDecoder.decode(fileUrl, StandardCharsets.UTF_8);
                decodedFileNames.add(decodedFileName.substring(decodedFileName.lastIndexOf("/") + 1));
            }
            return decodedFileNames;
        }catch (Exception e){
            throw new RuntimeException("Error get file name: " + e.getMessage());
        }
    }


    private void checkAndCreateDirectory() {
        File directory = new File(uploadPath);
        if (!directory.exists()) {
            if (!directory.mkdirs()) {
                throw new RuntimeException("Could not create upload directory: " + uploadPath);
            }
        }
    }
}
