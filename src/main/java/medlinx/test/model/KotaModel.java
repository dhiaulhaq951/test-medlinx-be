package medlinx.test.model;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class KotaModel {

private int id;

	private String provinsiId;
	private String name;
}
