package mz.tecnhoplus.exrti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mz.tecnhoplus.exrti.entity.ExchangeRateEntity;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRateEntity, Long> {

}
