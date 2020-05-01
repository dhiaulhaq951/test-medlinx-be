package medlinx.test.model;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Builder
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class PegawaiModel {

private int id;

	private String nama;

	private String alamat;
	
	private int provinsi;
	
	private int kota;

	private String telp;
	

	private String hobi;
	
	private int status;
	
}
