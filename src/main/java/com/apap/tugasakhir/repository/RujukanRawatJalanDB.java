package com.apap.tugasakhir.repository;

import com.apap.tugasakhir.model.RujukanRawatJalanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RujukanRawatJalanDB extends JpaRepository<RujukanRawatJalanModel, Long>{

}
