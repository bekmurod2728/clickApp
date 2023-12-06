package uz.click.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.click.dto.TransactionHistoryDto;
import uz.click.service.TransferService;

import java.util.List;


@RestController
@RequestMapping("/history")
public class TransferController {
    private final TransferService service;

    public TransferController(TransferService service) {
        this.service = service;
    }

    @GetMapping("/show")
    public ResponseEntity<List<TransactionHistoryDto>> getAll(){
        return service.getAll();
    }
    @GetMapping("/transfer/{id}/{id2}/{amount}")
    public String transfer(@PathVariable("id") Long sender,@PathVariable("id2") Long reciver,@PathVariable("amount") Double amount){
        return service.transfer(sender,reciver,amount);
    }
}
