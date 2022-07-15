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

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author Telmo Jr.
 * @Date : 15-07-2022
 * @Contact: +258 84 20 10 505 Email: Telmo.sigauquejr@gmail.com
 * @Desc : 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblExchangeRate")
public class ExchangeRateEntity {

	@ApiModelProperty(value = "Estado da operacao", hidden = true)
	private String internalStatus = "Success";

	@ApiModelProperty(value = "hora da última atualização unix", hidden = true)
	@Column(name = "time_last_update_unix", nullable = false)
	private Long time_last_update_unix;

	@ApiModelProperty(value = "hora da última atualização utc", hidden = true)
	@Column(name = "time_last_update_utc", nullable = false)
	private Timestamp time_last_update_utc;

	@ApiModelProperty(value = "proxima hora de atualização unix", hidden = true)
	@Column(name = "time_next_update_unix", nullable = false)
	private Long time_next_update_unix;

	@ApiModelProperty(value = "proxima hora de atualização utc", hidden = true)
	@Column(name = "time_next_update_utc", nullable = false)
	private Timestamp time_next_update_utc;

	@ApiModelProperty(value = "tempo eol unix", hidden = true)
	@Column(name = "time_eol_unix", nullable = false)
	private int time_eol_unix;

	@ApiModelProperty(value = "codigo base (Moeda)")
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
