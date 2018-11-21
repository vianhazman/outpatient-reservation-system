package com.apap.tugasakhir.repository;

import com.apap.tugasakhir.model.JadwalPoliModel;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JadwalPoliDB extends JpaRepository<JadwalPoliModel, Long>{

}
