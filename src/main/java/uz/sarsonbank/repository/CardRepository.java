package uz.sarsonbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.sarsonbank.entity.CardEntity;
import uz.sarsonbank.entity.UserEntity;

public interface CardRepository extends JpaRepository<CardEntity,Long> {
}
