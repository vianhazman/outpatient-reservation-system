package com.apap.tugasakhir.repository;

import com.apap.tugasakhir.model.ObatModel;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObatDB extends JpaRepository<ObatModel, Long>{

}
