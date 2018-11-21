package com.apap.tugasakhir.repository;

import com.apap.tugasakhir.model.PasienModel;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PasienDB extends JpaRepository<PasienModel, Long>{

}
