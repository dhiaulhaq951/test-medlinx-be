package medlinx.test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import medlinx.test.entity.Kota;
import medlinx.test.entity.Pegawai;
import medlinx.test.entity.Provinsi;
import medlinx.test.model.PegawaiModel;
import medlinx.test.repository.KotaRepository;
import medlinx.test.repository.PegawaiRepository;
import medlinx.test.repository.ProvinsiRepository;
import medlinx.test.service.PegawaiService;
@Service
@Transactional
public class PegawaiServiceImpl implements PegawaiService {

	@Autowired
	private ProvinsiRepository provinsiRepository;
	@Autowired
	private KotaRepository kotaRepository;
	@Autowired
	private PegawaiRepository pegawaiRepository;
	
	@Override
	public List<PegawaiModel> search(PegawaiModel search) {
		/**
		 * 
		 * select m from Pegawai m where "
		 +" upper(m.nama) like upper(:nama) " 
		 + "and upper(m.alamat) like upper(:alamat) " 
		 +	"and m.provinsi in :provinsi " 
		 + "and m.kota in :kota " 
		 +"	and m.telp like :telp " 
		 + "and m.hobi like :hobi "
		 +"	and m.status in :status
		 * 
		 * 
		 */
		final String nama = formatSerach(search.getNama());
		final String alamat = formatSerach(search.getAlamat());
		final String telp = formatSerach(search.getTelp());
		final String hobi = formatSerach(search.getHobi());
		List<Provinsi> listPro = provinsiRepository.findAll();
		List<Kota> listKotas = kotaRepository.findAll();
		
		List<Integer> listInPro = new ArrayList<Integer>();
		if(search.getProvinsi() == 0) {
			listInPro = listPro.stream().map(v -> v.getId()).collect(Collectors.toList());
		}else {
			listInPro.add(search.getProvinsi());
		}
		List<Integer> listIntKota = new ArrayList<Integer>();
		if(search.getKota() == 0) {
			listIntKota = listKotas.stream().map(c-> c.getId()).collect(Collectors.toList());
		}else {
			listIntKota.add(search.getKota());
		}
		List<Integer> listStatus = new ArrayList<Integer>();
		if(search.getStatus() ==0) {
			listStatus.add(0);
			listStatus.add(1);;
		}else {
			listStatus.add(search.getStatus());
		}
		
		return pegawaiRepository.
				seacrhByParam(nama, alamat, listInPro, listIntKota, telp, hobi, listStatus)
				.stream().map(p -> {
					return 
							PegawaiModel.builder()
							.id(p.getId())
							.nama(p.getNama())
							.alamat(p.getAlamat())
							.telp(p.getTelp())
							.kota(p.getKota())
							.provinsi(p.getProvinsi())
							.hobi(p.getHobi())
							.status(p.getStatus())
							.build();

							
				}).collect(Collectors.toList());
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		try {
			pegawaiRepository.deleteById(id);
			return 1;
		}catch(Exception e) {
			return 0;	
		}
		
	}

	private String formatSerach(String v) {
		if(v ==null) {
			return "%%";
		}
		return "%"+v+"%";
	}

	@Override
	public int savePegawai(Pegawai pegawai) {
		try {
			System.out.println("p nama " + pegawai.getNama());
			pegawaiRepository.save(pegawai);
			return 1;
		} catch (Exception e) {
			System.out.println("ERROR " + e.getMessage());
			return 0;
		}
	}

	@Override
	public int updatePegawai(Pegawai pegawai) {
		try {
			pegawaiRepository.findById(pegawai.getId()).orElseThrow(()-> new ValidationException("Data tidak ada"));
			pegawaiRepository.save(pegawai);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
}
