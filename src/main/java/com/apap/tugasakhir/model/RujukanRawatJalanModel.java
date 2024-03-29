package com.apap.tugasakhir.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.apap.tugasakhir.rest.webService;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "rujukan_rawat_jalan")
public class RujukanRawatJalanModel implements Serializable {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(name = "pasien_id", nullable = false)
	private long idPasien;
	
	@NotNull
	@Size(max = 255)
	@Column(name = "nama", nullable = false)
	private String nama;
	
	@NotNull
	@Column(name = "tanggal_rujuk", nullable = false)
	private Date tanggalRujuk;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jadwal_id", referencedColumnName = "id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private JadwalPoliModel jadwalPoli;
	
	@NotNull
	@Column(name = "status", nullable = false)
	private int status;
	
	@OneToMany(mappedBy="id", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<PenangananModel> daftarPenanganan;

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
	
	public void setPasien(long id) {
		this.idPasien=id;
	}

	public long getPasien() { 
		return idPasien;
	}
	
	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getNama() {
		return nama;
	}
	
	public void setTanggalRujuk(Date tanggalRujuk) {
		this.tanggalRujuk = tanggalRujuk;
	}

	public Date getTanggalRujuk() {
		return tanggalRujuk;
	}
	
	public void setJadwalPoli(JadwalPoliModel jadwalPoli) {
		this.jadwalPoli = jadwalPoli;
	}

	public JadwalPoliModel getJadwalPoli() {
		return jadwalPoli;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}
	
	public void setDaftarPenanganan(List<PenangananModel> daftarPenanganan) {
		this.daftarPenanganan = daftarPenanganan;
	}

	public List<PenangananModel> getDaftarPenanganan() {
		return daftarPenanganan;
	}

	public long getIdPasien() {
		return idPasien;
	}

	public void setIdPasien(long idPasien) {
		this.idPasien = idPasien;
	}
	
}