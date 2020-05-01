package medlinx.test.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import medlinx.test.model.ProvinsiModel;
import medlinx.test.repository.ProvinsiRepository;
import medlinx.test.service.ProvinsiService;
@Service
public class ProvinsiServiceImpl implements ProvinsiService {

	@Autowired
	private ProvinsiRepository provinsiRepository;
	@Override
	public List<ProvinsiModel> listProvinsi() {
		// TODO Auto-generated method stub
		return provinsiRepository.findAll().stream().map(p -> ProvinsiModel.builder().id(p.getId()).name(p.getName()).build())
				.collect(Collectors.toList());
	}

}
