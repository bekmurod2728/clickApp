package uz.click.entity;


import javax.persistence.*;
import java.util.Date;


@Entity
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   private String card_number;
   private Date deadline;
   private Double balance;
   @ManyToOne
   private UserEntity user;

    public CardEntity() {
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
