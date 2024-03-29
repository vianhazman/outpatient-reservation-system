package com.apap.tugasakhir.repository;

import java.sql.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tugasakhir.model.JadwalPoliModel;

@Repository
public interface JadwalPoliDb extends JpaRepository<JadwalPoliModel, Long> {
	JadwalPoliModel findByTanggalAndDokter(Date tanggal, long dokter);
	JadwalPoliModel findById(long id);
}

