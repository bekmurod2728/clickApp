package uz.click.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.click.entity.TransactionHistoryEntity;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistoryEntity,Long> {
}
