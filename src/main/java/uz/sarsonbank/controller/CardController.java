package uz.sarsonbank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.sarsonbank.dto.CardDto;
import uz.sarsonbank.service.CardService;

import java.util.List;


@RestController
@RequestMapping("/card")
public class CardController {
    private final CardService service;

    public CardController(CardService service) {
        this.service = service;
    }

    @PostMapping("/show")
    public ResponseEntity<List<CardDto>> getAll(){
        return service.getAll();
    }
    @PostMapping("/add")
    public ResponseEntity<CardDto> add(@RequestBody CardDto dto){
    return service.addCard(dto);
    }

    @DeleteMapping("/delte/{id}")
    public ResponseEntity<CardDto> delete(@PathVariable Long id){
    return service.deleteById(id);
    }
}
