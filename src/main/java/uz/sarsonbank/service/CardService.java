package uz.sarsonbank.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.sarsonbank.dto.CardDto;
import uz.sarsonbank.entity.CardEntity;
import uz.sarsonbank.entity.UserEntity;
import uz.sarsonbank.repository.CardRepository;
import uz.sarsonbank.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CardService {
    
    private final UserRepository userRepository;
    private final CardRepository cardRepository;

    public CardService(UserRepository userRepository, CardRepository cardRepository) {
        this.userRepository = userRepository;
        this.cardRepository = cardRepository;
    }

    public ResponseEntity<List<CardDto>> getAll(){
        return ResponseEntity.ok(cardRepository.findAll().stream().map(CardDto::changeToDto).collect(Collectors.toList()));
    }

    public ResponseEntity<CardDto> addCard(CardDto dto){
        Optional<UserEntity> byId = userRepository.findById(dto.getUser_id());
        if (byId.isPresent()) {
            UserEntity user = byId.get();
            CardEntity card = CardDto.changeToEntity(dto);
            card.setUser(user);
            user.addCard(card);
            cardRepository.save(card);
            userRepository.save(user);
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }
    public ResponseEntity<CardDto> deleteById(Long id){
        Optional<CardEntity> byId = cardRepository.findById(id);
        if (byId.isPresent()) {
            cardRepository.deleteById(id);
            return ResponseEntity.ok(CardDto.changeToDto(byId.get()));
        }
        return ResponseEntity.notFound().build();
    }


}
