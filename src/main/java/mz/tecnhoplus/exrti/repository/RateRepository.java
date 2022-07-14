package mz.tecnhoplus.exrti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mz.tecnhoplus.exrti.entity.RateEntity;

@Repository
public interface RateRepository extends JpaRepository<RateEntity, Long> {

}
