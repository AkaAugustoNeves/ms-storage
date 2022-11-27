package br.com.pilares.msstorage.model.dto;

import br.com.pilares.msstorage.model.entity.File;
import br.com.pilares.msstorage.model.enums.Artifact;
import br.com.pilares.msstorage.model.enums.Institution;

public class FileDTO {

	private Institution institution;
	private String institutionHash;
	private Artifact artifact;
	private String artifactHash;
	private String extension;
	private String path;
	
	public FileDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public FileDTO(File file) {
		this.institution= file.getInstitution();
		this.institutionHash = file.getInstitutionHash();
		this.artifact = file.getArtifact();
		this.artifactHash = file.getArtifactHash();
		this.extension = file.getExtension();
		this.path = getPathable(file);
	}

	private String getPathable(File file) {
		return "/"+
				file.getInstitution()+"/"+
				file.getInstitutionHash()+"/"+
				file.getArtifact()+"/"+
				file.getArtifactHash()+
				getExtensionPath(file.getExtension());
	}
	
	private String getExtensionPath(String extension) {
		return "."+extension.substring(extension.indexOf("/")+1, extension.length());
	}
	
	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public String getInstitutionHash() {
		return institutionHash;
	}

	public void setInstitutionHash(String institutionHash) {
		this.institutionHash = institutionHash;
	}

	public Artifact getArtifact() {
		return artifact;
	}

	public void setArtifact(Artifact artifact) {
		this.artifact = artifact;
	}

	public String getArtifactHash() {
		return artifactHash;
	}

	public void setArtifactHash(String artifactHash) {
		this.artifactHash = artifactHash;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
