package medlinx.test.model;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class ProvinsiModel {

	private int id;

	private String name;
}

