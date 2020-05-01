package medlinx.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import medlinx.test.entity.Provinsi;


@Repository
public interface ProvinsiRepository extends JpaRepository<Provinsi, Integer>{

}
