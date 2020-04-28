package medlinx.test.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="provinsi")
@Data
public class Provinsi implements Serializable{
	
	@Id
	@Column(name="id")
	@NotNull
	private int id;
	
	@Column(name="name")
	@NotNull
	private String name;

}
