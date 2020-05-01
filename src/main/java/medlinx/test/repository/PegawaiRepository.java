package medlinx.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import medlinx.test.entity.Pegawai;

@Repository
public interface PegawaiRepository extends JpaRepository<Pegawai, Integer>{

	@Query(value = "select m from Pegawai m where "
		 +" upper(m.nama) like upper(:nama) " 
		 + "and upper(m.alamat) like upper(:alamat) " 
		 +	"and m.provinsi in :provinsi " 
		 + "and m.kota in :kota " 
		 +"	and m.telp like :telp " 
		 + "and m.hobi like :hobi "
		 +"	and m.status in :status ")
	List<Pegawai> 
	seacrhByParam(String nama, String alamat, List<Integer> provinsi, List<Integer> kota, String telp, String hobi, List<Integer> status);


}
