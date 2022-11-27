package br.com.pilares.msstorage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pilares.msstorage.model.entity.File;

public interface FileRepository extends JpaRepository<File, Long> {

}
