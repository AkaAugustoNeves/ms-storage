package br.com.pilares.msstorage.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.pilares.msstorage.model.dto.FileDTO;
import br.com.pilares.msstorage.model.entity.File;
import br.com.pilares.msstorage.model.enums.Artifact;
import br.com.pilares.msstorage.model.enums.Institution;
import br.com.pilares.msstorage.repositories.FileRepository;

@Service
public class FileService {
	
	@Value("${base_path}")
	private String basePath;
	
	private FileRepository fileRepository;
	
	@Autowired
	public FileService(FileRepository fileRepository) {
		this.fileRepository = fileRepository;
	}
	
	public ResponseEntity<?> register(Institution institution, String institutionHash, Artifact artifact, MultipartFile file) throws IOException{
		File fileSave = fileRepository.save(new File(institution, institutionHash, artifact, file));
		move(fileSave, file);
		return ResponseEntity.status(HttpStatus.OK).body(new FileDTO(fileSave));
	}
	
	private boolean move(File fileSaved, MultipartFile file) throws IOException {
		byte[] bytes = file.getBytes();
		if(!verifyFolderInstitution(fileSaved.getInstitution().toString())) {
			createFolderInstitution(fileSaved.getInstitution().toString());
		}
		
		if(!verifyFolderInstitutionHash(fileSaved.getInstitution().toString(), fileSaved.getInstitutionHash())) {
			createFolderInstitutionHash(fileSaved.getInstitution().toString(), fileSaved.getInstitutionHash());
		}
		if(!verifyFolderArtifact(fileSaved.getInstitution().toString(), fileSaved.getInstitutionHash(), fileSaved.getArtifact())) {
			createFolderArtifact(fileSaved.getInstitution().toString(), fileSaved.getInstitutionHash(), fileSaved.getArtifact());
		}
		Files.write(Paths.get(getPath(fileSaved)), bytes);
		return true;
	}
		
	
	private boolean verifyFolderInstitution(String institution) {
		return new java.io.File(basePath+institution).exists();
	}
	
	private boolean createFolderInstitution(String institution) {
		new java.io.File(basePath+institution).mkdir();
		return true;
	}
	
	private boolean verifyFolderInstitutionHash(String institution, String institutionHash) {
		return new java.io.File(basePath+institution+"\\"+institutionHash).exists();
	}
	
	private boolean createFolderInstitutionHash(String institution, String institutionHash) {
		new java.io.File(basePath+institution+"\\"+institutionHash).mkdir();
		return true;
	}
	
	private boolean verifyFolderArtifact(String institution,String institutionHash, Artifact artifact) {
		return new java.io.File(basePath+institution+"\\"+institutionHash+"\\"+artifact).exists();
	}
	
	private boolean createFolderArtifact(String institution, String institutionHash, Artifact artifact) {
		new java.io.File(basePath+institution+"\\"+institutionHash+"\\"+artifact).mkdir();
		return true;
	}
	
	private String getPath(File file) {
		return basePath+file.getInstitution()+"\\"+file.getInstitutionHash()+"\\"+file.getArtifact()+"\\"+file.getArtifactHash()+getExtension(file.getExtension());
	}
	
	private String getExtension(String extension) {
		return "."+extension.substring(extension.indexOf("/")+1);
	}
	
}
