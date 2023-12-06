package uz.click.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.click.entity.CardEntity;

public interface CardRepository extends JpaRepository<CardEntity,Long> {
}
