package uz.sarsonbank.dto;


import uz.sarsonbank.entity.CardEntity;

import java.util.Date;


public class CardDto {
   private Long id;
   private String card_number;
   private Date deadline;
   private Double balance;
   private Long user_id;

    public static CardDto changeToDto(CardEntity card){
        CardDto dto=new CardDto();
        dto.setBalance(card.getBalance());
        dto.setCard_number(card.getCard_number());
        dto.setDeadline(card.getDeadline());
        dto.setUser_id(card.getUser().getId());
        return dto;
    }

    public static CardEntity changeToEntity(CardDto dto){
        CardEntity card=new CardEntity();
        card.setCard_number(dto.getCard_number());
        card.setBalance(dto.getBalance());
        card.setDeadline(dto.getDeadline());
        return card;
    }

    public CardDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public CardDto(Long id, String card_number, Date deadline, Double balance, Long user_id) {
        this.id = id;
        this.card_number = card_number;
        this.deadline = deadline;
        this.balance = balance;
        this.user_id = user_id;
    }
}
