package uz.sarsonbank.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uz.sarsonbank.dto.ApplicationUserRole;
import uz.sarsonbank.dto.UserDto;
import uz.sarsonbank.entity.UserEntity;
import uz.sarsonbank.repository.CardEntityCardDto;
import uz.sarsonbank.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserService implements UserDetailsService {
    private final CardEntityCardDto dto;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(@Qualifier("cardEntityCardDto") CardEntityCardDto dto,
                       UserRepository userRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.dto = dto;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }

    public ResponseEntity<List<UserDto>> getAll(){
        return ResponseEntity.ok(userRepository.findAll().stream()
                .map(this.dto::changesDto).collect(Collectors.toList()));
    }

//    public ResponseEntity<UserDto> addUser(UserDto dto){
//        UserEntity user = this.dto.changes(dto);
//        user.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
//        user.setRole(ApplicationUserRole.ADMIN);
//        userRepository.save(user);
//        return ResponseEntity.ok(dto);
//    }
    public ResponseEntity<UserDto> deleteById(Long id){
        Optional<UserEntity> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.ok(this.dto.changesDto(byId.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("UserDatial");
        UserEntity user=userRepository.findByUsername(username).orElse(null);

        return new User(
                user.getUsername(),
                user.getPassword(),
                user.getRole().getGrantedAuthority()

        );
    }
}
