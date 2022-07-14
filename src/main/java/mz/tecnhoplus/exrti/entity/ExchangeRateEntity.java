package mz.tecnhoplus.exrti.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblExchangeRate")
public class ExchangeRateEntity {

	private String internalStatus = "Success";

	@Column(name = "time_last_update_unix", nullable = false)
	private Long time_last_update_unix;

	@Column(name = "time_last_update_utc", nullable = false)
	private Timestamp time_last_update_utc;

	@Column(name = "time_next_update_unix", nullable = false)
	private Long time_next_update_unix;

	@Column(name = "time_next_update_utc", nullable = false)
	private Timestamp time_next_update_utc;

	@Column(name = "time_eol_unix", nullable = false)
	private int time_eol_unix;

	@Id
	@Column(name = "base_code", nullable = false)
	private String base_code;

	@OneToMany(targetEntity = RateEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "rt_fk", referencedColumnName = "base_code")
	private List<RateEntity> rateEntity;

	@JsonIgnore
	@Column(name = "createdOn")
	private Timestamp createdOn;

	@JsonIgnore
	@Column(name = "updateOn")
	private Timestamp updateOn;

	@JsonIgnore
	@Column(name = "removeOn")
	private Timestamp removeOn;

}
