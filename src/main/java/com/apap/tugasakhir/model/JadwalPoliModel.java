package com.apap.tugasakhir.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "jadwal_poli")
public class JadwalPoliModel implements Serializable {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "poli_id", referencedColumnName = "id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private PoliModel poli;
	
	@NotNull
	@Column(name = "tanggal", nullable = false)
	private Date tanggal;
	
	@NotNull
	@Column(name = "jam_mulai", nullable = false)
	private Time jamMulai;
	
	@NotNull
	@Column(name = "jam_selesai", nullable = false)
	private Time jamSelesai;

	@NotNull
	@Column(name = "dokter_id", nullable = false)
	private long dokter;
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
	
	public void setPoli(PoliModel poli) {
		this.poli = poli;
	}

	public PoliModel getPoli() {
		return poli;
	}
	
	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	public Date getTanggal() {
		return tanggal;
	}
	
	public String getJamMulai() {		
		return jamMulai.toString().substring(0, 5);
	}

	public void setJamMulai(String jamMulai) {
		jamMulai = jamMulai+":00";
		this.jamMulai =Time.valueOf(jamMulai);
	}

	public String getJamSelesai() {
		return jamSelesai.toString().substring(0, 5);
	}

	public void setJamSelesai(String jamSelesai) {
		jamSelesai = jamSelesai+":00";
		this.jamSelesai = Time.valueOf(jamSelesai);
	}
	
	public void setDokter(long id) {
		this.dokter = id;
	}

	public long getDokter() {
		return dokter;
	}
	
}