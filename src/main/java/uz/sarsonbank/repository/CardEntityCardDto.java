package uz.sarsonbank.repository;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import uz.sarsonbank.dto.CardDto;
import uz.sarsonbank.dto.UserDto;
import uz.sarsonbank.entity.CardEntity;
import uz.sarsonbank.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

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
