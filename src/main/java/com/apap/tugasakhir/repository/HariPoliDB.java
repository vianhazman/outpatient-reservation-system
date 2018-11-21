package com.apap.tugasakhir.repository;

import com.apap.tugasakhir.model.HariPoliModel;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HariPoliDB extends JpaRepository<HariPoliModel, Long>{

}
