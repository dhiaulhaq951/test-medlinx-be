package medlinx.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import medlinx.test.model.KotaModel;
import medlinx.test.service.KotaService;

import java.util.List;
@RestController
@RequestMapping("kota")
public class KotaController {
	@Autowired
	private KotaService kotaService;
	
	@CrossOrigin
	@GetMapping("all")
	public ResponseEntity<List<KotaModel>> listKota(){
		List<KotaModel> list = kotaService.listKota();
		return new ResponseEntity<List<KotaModel>>(list,HttpStatus.OK);
	}
}
