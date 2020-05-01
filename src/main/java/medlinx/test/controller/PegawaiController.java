package medlinx.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import medlinx.test.model.BaseModel;
import medlinx.test.model.PegawaiModel;
import medlinx.test.service.PegawaiService;



@RestController
@RequestMapping("employee")
public class PegawaiController {

	@Autowired
	private PegawaiService pegawaiService;
	
	 @CrossOrigin
	 @PostMapping("search")
		public ResponseEntity<List<PegawaiModel>> search(@RequestBody PegawaiModel search) {
		  List<PegawaiModel> list = pegawaiService.search(search);
		  return new ResponseEntity<List<PegawaiModel>>(list,HttpStatus.OK);
		}
	 
	 @GetMapping("delete/{id}")
	 public ResponseEntity<BaseModel> delete(@PathVariable("id") Integer id) {
		 int o = pegawaiService.delete(id);
		 if(o == 1) {
			 
			 return new ResponseEntity<BaseModel>(
					 BaseModel.builder()
					 .status(200)
					 .message("OK").build()
					 ,HttpStatus.OK);
		 }else {
			 return new ResponseEntity<BaseModel>(BaseModel.builder()
					 .status(400)
					 .message("GAGAL_SAVE").build(),HttpStatus.OK);
		 }
		 
		 
		 
		}
}
