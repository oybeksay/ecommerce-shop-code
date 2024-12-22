package uz.ecommerce.shoes.mapper;

import org.mapstruct.Mapper;
import uz.ecommerce.shoes.dto.FeedbackDto;
import uz.ecommerce.shoes.entity.Feedback;

@Mapper(componentModel = "spring")
public interface FeedbackMapper {

    Feedback toEntity(FeedbackDto feedBackDto);

}
