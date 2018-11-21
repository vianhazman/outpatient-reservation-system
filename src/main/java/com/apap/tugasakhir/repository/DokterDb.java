package com.apap.tugasakhir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tugasakhir.model.DokterModel;

@Repository
public interface DokterDb extends JpaRepository<DokterModel, Long>{

}
