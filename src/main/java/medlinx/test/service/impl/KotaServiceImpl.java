package medlinx.test.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import medlinx.test.model.KotaModel;
import medlinx.test.repository.KotaRepository;
import medlinx.test.service.KotaService;

@Service
public class KotaServiceImpl implements KotaService{

	
	@Autowired
	private KotaRepository kotaRepository;
	@Override
	public List<KotaModel> listKota() {
		// TODO Auto-generated method stub
		return kotaRepository.findAll().stream()
				.map(m -> KotaModel.builder().id(m.getId()).name(m.getName()).provinsiId(m.getProvinsiId()).build())
				.collect(Collectors.toList());
	}

}
