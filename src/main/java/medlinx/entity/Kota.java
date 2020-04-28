package medlinx.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="kota")
@Data
public class Kota implements Serializable{
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Max(value=11)
	private int id;
	
	@Column(name="provinsi_id")
	@Max(value=2)
	@NotNull
	private String provinsiId;
	
	@Column(name="name")
	@NotNull
	@Max(value=255)
	private String name;

}
