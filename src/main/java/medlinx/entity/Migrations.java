package medlinx.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="migrations")
@Data
public class Migrations implements Serializable{
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Max(value=10)
	@NotNull
	private int id;
	
	@Column(name="migration")
	@Max(value=255)
	@NotNull
	private String migration;
	
	@Column(name="batch")
	@NotNull
	@Max(value=11)
	private int batch;

}
