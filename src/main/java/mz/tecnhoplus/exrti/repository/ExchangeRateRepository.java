package mz.tecnhoplus.exrti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mz.tecnhoplus.exrti.entity.ExchangeRateEntity;
/**
 * @author Telmo Jr.
 * @Date : 15-07-2022
 * @Contact: +258 84 20 10 505 Email: Telmo.sigauquejr@gmail.com
 * @Desc :
 *  
 */
@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRateEntity, String> {

}
