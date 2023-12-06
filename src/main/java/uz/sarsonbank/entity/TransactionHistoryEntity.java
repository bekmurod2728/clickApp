package uz.sarsonbank.entity;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class TransactionHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   @CreationTimestamp
   private Date date;
   private Double amount;
   private Long sender_card;
   private Long reciver_card;
   private Double commision;


    public TransactionHistoryEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getSender_card() {
        return sender_card;
    }

    public void setSender_card(Long sender_card) {
        this.sender_card = sender_card;
    }

    public Long getReciver_card() {
        return reciver_card;
    }

    public void setReciver_card(Long reciver_card) {
        this.reciver_card = reciver_card;
    }

    public Double getCommision() {
        return commision;
    }

    public void setCommision(Double commision) {
        this.commision = commision;
    }

    public TransactionHistoryEntity(Long id, Date date, Double amount, Long sender_card, Long reciver_card, Double commision) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.sender_card = sender_card;
        this.reciver_card = reciver_card;
        this.commision = commision;
    }
}
