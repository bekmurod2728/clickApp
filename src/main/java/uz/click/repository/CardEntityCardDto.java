package uz.click.repository;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.mapstruct.factory.Mappers;
import uz.click.dto.UserDto;
import uz.click.entity.CardEntity;
import uz.click.entity.UserEntity;

import java.util.List;

@Mapper
public interface CardEntityCardDto {
    CardEntityCardDto INSTANCE = Mappers.getMapper(CardEntityCardDto.class);

//    UserEntity changes(UserDto dto);

    @Mapping(target = "cards", source = "cards")
    UserDto changesDto(UserEntity entity);
    List<String> changesDto(List<CardEntity> cards);

//    @Named("mapToCardEntities")
//    default List<String> mapToCardEntities(List<CardEntity> cards) {
//        return cards.stream().map(CardEntity::getCard_number).collect(Collectors.toList());
//    }
}
