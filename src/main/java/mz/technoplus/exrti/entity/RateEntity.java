package mz.technoplus.exrti.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 *  
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblRate")
public class RateEntity {

	
	@Id
	@Column(name = "ccy_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int Id;

	@ApiModelProperty(value = "moeda")
	@Column(name = "ccy_name", nullable = false)
	private String currency;

	@ApiModelProperty(value = "valor")
	@Column(name = "ccy_value", nullable = false)
	private Double value;

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
