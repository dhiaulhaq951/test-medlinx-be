package medlinx.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import medlinx.test.model.ProvinsiModel;
import medlinx.test.service.ProvinsiService;

import java.util.List;;
@RestController
@RequestMapping("provinsi")
public class ProvinsiController {

	@Autowired
	private ProvinsiService provinsiService;
	@CrossOrigin
	@GetMapping("all")
	public ResponseEntity<List<ProvinsiModel>> listProvinsi(){
		List<ProvinsiModel> list = provinsiService.listProvinsi();
		
		return new ResponseEntity<List<ProvinsiModel>>(list,HttpStatus.OK);
		
		
	}
}
