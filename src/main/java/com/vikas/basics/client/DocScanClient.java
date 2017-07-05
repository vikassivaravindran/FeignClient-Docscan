package com.vikas.basics.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.vikas.basics.feign.DocScanFeignClient;



@RestController
public class DocScanClient {
	
	@Autowired
	private DocScanFeignClient docScan;
	
	ResponseEntity<String> response = null;
	
	MultipartHttpServletRequest request;
	
	@GetMapping("/test")
	public List<Document> getDocumentsByType(){
		List<Document> docs = docScan.getDocumentsByType("employed");
		docs.stream().forEach(System.out::println);
		return docs;
	}
	
	@PostMapping(value="/post")
	public ResponseEntity<String> uploadaFile() throws IOException{

	File file = new File("C:\\Apps\\Eula.txt");
	FileInputStream fs = new FileInputStream(file);
	MultipartFile multipartFile = new MockMultipartFile("file",file.getName(),"multipart/form",fs);
	response = docScan.uploadaFile(multipartFile);
	return response;
	
	}
}
