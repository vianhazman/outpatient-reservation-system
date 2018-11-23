package com.apap.tugasakhir.repository;

import com.apap.tugasakhir.model.PoliModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoliDB extends JpaRepository<PoliModel, Long>{

}
