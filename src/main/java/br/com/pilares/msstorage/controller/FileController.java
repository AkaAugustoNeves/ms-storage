package br.com.pilares.msstorage.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.pilares.msstorage.model.enums.Artifact;
import br.com.pilares.msstorage.model.enums.Institution;
import br.com.pilares.msstorage.services.FileService;

@RestController
@RequestMapping("/file")
public class FileController {

	private FileService fileService;
	
	@Autowired
	public FileController(FileService fileService) {
		this.fileService = fileService;
	}
	
	@PostMapping("/{institution}/{institutionHash}/{artifact}")
	public ResponseEntity<?> register(
			@PathVariable Institution institution, 
			@PathVariable String institutionHash, 
			@PathVariable Artifact artifact,
			@RequestBody MultipartFile file
			) throws IOException{
		return fileService.register(institution, institutionHash, artifact, file);
	}
	
}
