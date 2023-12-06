package uz.sarsonbank.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.sarsonbank.dto.TransactionHistoryDto;
import uz.sarsonbank.entity.CardEntity;
import uz.sarsonbank.entity.TransactionHistoryEntity;
import uz.sarsonbank.entity.UserEntity;
import uz.sarsonbank.repository.CardRepository;
import uz.sarsonbank.repository.TransactionHistoryRepository;
import uz.sarsonbank.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TransferService {
    private final UserRepository userRepository;
    private final CardRepository cardRepository;
    private final TransactionHistoryRepository historyRepository;

    public TransferService(UserRepository userRepository, CardRepository cardRepository, TransactionHistoryRepository historyRepository) {
        this.userRepository = userRepository;
        this.cardRepository = cardRepository;
        this.historyRepository = historyRepository;
    }

    @Transactional
    public String transfer(Long fromCard,Long toCard,Double amount){
    CardEntity reciverCard = cardRepository.findById(toCard).orElse(null);
    CardEntity senderCard = cardRepository.findById(fromCard).orElse(null);
    if (senderCard==null){
            return "senderCard topilmadi";
        } else if (reciverCard==null) {
            return "reciverCard topilmadi";
        }
        UserEntity senderUser = userRepository.findById(senderCard.getUser().getId()).orElse(null);
        UserEntity reciverUser = userRepository.findById(reciverCard.getUser().getId()).orElse(null);
        if (senderUser.equals(reciverUser)&&senderCard!=null&&reciverUser!=null){
            senderCard.setBalance(senderCard.getBalance()-(amount+amount/200));
            reciverCard.setBalance(reciverCard.getBalance()+(amount+amount/200));
            TransactionHistoryEntity history=new TransactionHistoryEntity();
            history.setAmount(amount);
            history.setSender_card(fromCard);
            history.setReciver_card(toCard);
            history.setCommision(amount/200);
            historyRepository.save(history);
            return "O'z cartalaringiz orasidagi pul o'tkazma\nMuvafaqiyatli yakunlandi";
        } else if (senderCard!=null&&reciverUser!=null) {
            senderCard.setBalance(senderCard.getBalance()-(amount+amount/100));
            reciverCard.setBalance(reciverCard.getBalance()+(amount+amount/100));
            TransactionHistoryEntity history=new TransactionHistoryEntity();
            history.setAmount(amount);
            history.setSender_card(fromCard);
            history.setReciver_card(toCard);
            history.setCommision(amount/100);
            historyRepository.save(history);
            return "Pul o'tkazma\nMuvafaqiyatli yakunlandi";
        }
        return senderCard==null? "senderCard topilmadi":"reciverCard topilmadi";
    }

    public ResponseEntity<List<TransactionHistoryDto>> getAll(){
        return ResponseEntity.ok(historyRepository.findAll().stream().map(e->TransactionHistoryDto.changeToDto(e)).collect(Collectors.toList()));
    }


}
