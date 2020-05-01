package medlinx.test.service;
import java.util.List;

import medlinx.test.model.PegawaiModel;

public interface PegawaiService {

	List<PegawaiModel> search(PegawaiModel search);
	int delete(Integer id);
}
