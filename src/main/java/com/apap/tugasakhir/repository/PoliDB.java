package com.apap.tugasakhir.repository;

import com.apap.tugasakhir.model.PoliModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apap.tugasakhir.model.PoliModel;

@Repository
public interface PoliDB extends JpaRepository<PoliModel, Long> {
	PoliModel findById(long id);
	PoliModel findByNama(String nama);
}
