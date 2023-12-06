package uz.sarsonbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.sarsonbank.entity.TransactionHistoryEntity;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistoryEntity,Long> {
}
