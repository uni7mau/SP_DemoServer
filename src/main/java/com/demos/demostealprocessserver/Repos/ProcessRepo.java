package com.demos.demostealprocessserver.Repos;

import com.demos.demostealprocessserver.Models.MyProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProcessRepo extends JpaRepository<MyProcess, Integer> {

}
