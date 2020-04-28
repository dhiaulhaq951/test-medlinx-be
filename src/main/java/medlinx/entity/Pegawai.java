package medlinx.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "pegawai")
@Data
public class Pegawai implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Max(value = 10)
	@Column(name="id")
	@NotNull
	private int id;
	
	@NotNull
	@Column(name="nama")
	@Max(value=25)
	private String nama;
	
	@Column(name="alamat")
	@Max(value=255)
	private String alamat;
	
	@Column(name="provinsi")
	private int provinsi;
	
	@Column(name="kota")
	private int kota;
	
	@Column(name="telp")
	@Max(value=15)
	private String telp;
	
	@Column(name="hobi")
	@Max(value=255)
	private String hobi;
	
	@Column(name="status")
	@Max(value=11)
	@NotNull
	private int status;
	

}
