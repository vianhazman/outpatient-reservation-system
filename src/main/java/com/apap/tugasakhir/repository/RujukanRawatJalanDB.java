package com.apap.tugasakhir.repository;

import com.apap.tugasakhir.model.DokterModel;
import com.apap.tugasakhir.model.RujukanRawatJalanModel;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RujukanRawatJalanDB extends JpaRepository<RujukanRawatJalanModel, Long>{

}
