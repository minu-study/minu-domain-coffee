package minu.coffee.pointHistory.repository;

import minu.coffee.pointHistory.model.PointHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointHistoryRepo extends JpaRepository<PointHistory, Long> {
}
