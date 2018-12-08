package com.apap.tugasakhir.repository;

import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apap.tugasakhir.model.RujukanRawatJalanModel;

@Repository
public interface RujukanRawatJalanDb extends JpaRepository<RujukanRawatJalanModel, Long> {
	RujukanRawatJalanModel findByidPasienAndTanggalRujuk(long idPasien, Date tanggalRujuk);
	RujukanRawatJalanModel findByTanggalRujuk(Date tanggalRujuk);
	RujukanRawatJalanModel findByIdPasien(long idPasien);
}