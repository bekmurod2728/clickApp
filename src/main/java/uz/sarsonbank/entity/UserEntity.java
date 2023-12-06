package uz.sarsonbank.entity;


import uz.sarsonbank.dto.ApplicationUserRole;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   private String username;
   private Integer age;
   private String password;

   @OneToMany(mappedBy = "user")
   private List<CardEntity> cards=new ArrayList<>();

    private ApplicationUserRole role;

    public void addCard(CardEntity card){
        cards.add(card);
    }

    public UserEntity() {
    }

    public ApplicationUserRole getRole() {
        return role;
    }

    public void setRole(ApplicationUserRole role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CardEntity> getCards() {
        return cards;
    }

    public void setCards(List<CardEntity> cards) {
        this.cards = cards;
    }

    public UserEntity(Long id, String username, Integer age, String password, List<CardEntity> cards) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.password = password;
        this.cards = cards;
    }
}
