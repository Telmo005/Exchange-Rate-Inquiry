package mz.tecnhoplus.exrti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblRate")
public class RateEntity{

	@Id
	@Column(name = "ccy_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@Column(name = "ccy_name", nullable = false)
	private String currency;

	@Column(name = "ccy_value", nullable = false)
	private String value;
	
}
