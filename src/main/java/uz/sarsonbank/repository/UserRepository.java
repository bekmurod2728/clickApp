package uz.sarsonbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.sarsonbank.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByUsername(String username);
}
