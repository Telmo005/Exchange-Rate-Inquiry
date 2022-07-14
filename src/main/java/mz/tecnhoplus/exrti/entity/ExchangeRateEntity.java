package mz.tecnhoplus.exrti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblExchangeRate")
public class ExchangeRateEntity{
	
	public ExchangeRateEntity(String base_code) {
		super();
		this.base_code = base_code;
	}

	@Id
	@Column(name = "exchangeRate_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "time_last_update_unix", nullable = false)
	private Long time_last_update_unix;

	@Column(name = "time_last_update_utc", nullable = false)
	private String time_last_update_utc;

	@Column(name = "time_next_update_unix", nullable = false)
	private Long time_next_update_unix;

	@Column(name = "time_next_update_utc", nullable = false)
	private String time_next_update_utc;

	@Column(name = "time_eol_unix", nullable = false)
	private int time_eol_unix;

	@Column(name = "base_code", nullable = false)
	private String base_code;
	
	@OneToMany(targetEntity = RateEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(name="rt_fk", referencedColumnName = "exchangeRate_id")
	private List<RateEntity> rateEntity;
	
}
