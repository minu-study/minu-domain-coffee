package minu.coffee.paymentHistory.repository;

import minu.coffee.paymentHistory.model.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentHistoryRepo extends JpaRepository<PaymentHistory, Long> {
}
