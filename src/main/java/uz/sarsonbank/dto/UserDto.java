package uz.sarsonbank.dto;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import uz.sarsonbank.entity.CardEntity;
import uz.sarsonbank.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;


public class UserDto {
    private Long id;
    private String username;
    private Integer age;
    private String password;
    private List<String> cards;


//    public static UserDto changeToDto(UserEntity user){
//        UserDto dto=new UserDto(user.getId(), user.getUsername(),
//                user.getAge(), user.getPassword(),
//                user.getCards().stream().map(CardEntity::getCard_number).collect(Collectors.toList()));
//        return dto;
//    }
//
//    public static UserEntity changeToEntity(UserDto dto){
//        UserEntity user=new UserEntity();
//        user.setAge(dto.getAge());
//        user.setUsername(dto.getUsername());
//        return user;
//    }

    public UserDto() {
    }

    public UserDto(Long id, String username,
                   Integer age, String password,
                   List<String> cards) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.password = password;
        this.cards = cards;
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

    public List<String> getCards() {
        return cards;
    }

    public void setCards(List<String> cards) {
        this.cards = cards;
    }
}
