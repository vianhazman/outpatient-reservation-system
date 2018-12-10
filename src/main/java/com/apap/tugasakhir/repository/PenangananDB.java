package com.apap.tugasakhir.repository;

import com.apap.tugasakhir.model.PenangananModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenangananDB extends JpaRepository<PenangananModel, Long>{
	
}
