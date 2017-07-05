package com.vikas.basics.feign;

import java.io.IOException;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.vikas.basics.client.Document;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

@org.springframework.cloud.netflix.feign.FeignClient(name = "docscan", url = "http://localhost:9071/docscan")
public interface DocScanFeignClient {
	@RequestMapping(value = "/getDoctypes", method = RequestMethod.GET)
	public List<Document> getDocumentsByType(@RequestParam(value = "custType") String customerType);

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ResponseEntity<String> uploadaFile(MultipartFile file) throws IOException;

	@Configuration
	public class MultipartSupportConfig {

		@Bean
		@Primary
		@Scope("prototype")
		public Encoder feignFormEncoder() {
			return new SpringFormEncoder();
		}
	}
}
