package medlinx.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medlinx.test.entity.Kota;


@Repository
public interface KotaRepository  extends JpaRepository<Kota, Integer>{

}
