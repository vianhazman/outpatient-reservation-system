package com.apap.tugasakhir.repository;

import com.apap.tugasakhir.model.HariPoliModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tugasakhir.model.HariPoliModel;

@Repository
public interface HariPoliDB extends JpaRepository<HariPoliModel, Long> {

		HariPoliModel findById(long id);
		List<HariPoliModel> findByHari(HariPoliModel hari);
}
