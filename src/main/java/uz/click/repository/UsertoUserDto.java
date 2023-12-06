package uz.click.repository;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import uz.click.dto.CardDto;
import uz.click.entity.CardEntity;

@Mapper
public interface UsertoUserDto {
    UsertoUserDto INSTANCE = Mappers.getMapper(UsertoUserDto.class);
@Mapping(target = "user.id",source = "user_id")
    CardEntity changes(CardDto dto);

    @Mapping(target = "user_id",source = "user.id")
    CardDto changesDtp(CardEntity entity);

}
