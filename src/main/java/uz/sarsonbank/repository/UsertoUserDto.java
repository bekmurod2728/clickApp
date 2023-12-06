package uz.sarsonbank.repository;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import uz.sarsonbank.dto.CardDto;
import uz.sarsonbank.dto.UserDto;
import uz.sarsonbank.entity.CardEntity;
import uz.sarsonbank.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface UsertoUserDto {
    UsertoUserDto INSTANCE = Mappers.getMapper(UsertoUserDto.class);
@Mapping(target = "user.id",source = "user_id")
    CardEntity changes(CardDto dto);

    @Mapping(target = "user_id",source = "user.id")
    CardDto changesDtp(CardEntity entity);

}
