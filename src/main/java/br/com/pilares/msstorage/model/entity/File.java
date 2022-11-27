package br.com.pilares.msstorage.model.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.web.multipart.MultipartFile;

import br.com.pilares.msstorage.model.enums.Artifact;
import br.com.pilares.msstorage.model.enums.Institution;

@Entity
public class File {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "institution_id")
	private Institution institution;
	private String institutionHash;
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "artifact_id")
	private Artifact artifact;
	private String artifactHash;
	private String extension;

	public File(Institution institution, String institutionHash, Artifact artifact, MultipartFile file) {
		this.institution = institution;
		this.institutionHash = institutionHash;
		this.artifact = artifact;
		this.artifactHash = UUID.randomUUID().toString();
		this.extension= file.getContentType();
	}
	
	public File() {
		// TODO Auto-generated constructor stub
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
}