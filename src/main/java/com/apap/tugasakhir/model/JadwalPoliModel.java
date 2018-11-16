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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dokter_id", referencedColumnName = "id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private DokterModel dokter;
	
	@OneToMany(mappedBy="jadwal_poli", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<RujukanRawatJalanModel> daftarRujukanRawatJalan;

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
	
	public Time getJamMulai() {
		return jamMulai;
	}

	public void setJamMulai(Time jamMulai) {
		this.jamMulai = jamMulai;
	}

	public Time getJamSelesai() {
		return jamSelesai;
	}

	public void setJamSelesai(Time jamSelesai) {
		this.jamSelesai = jamSelesai;
	}
	
	public void setDokter(DokterModel dokter) {
		this.dokter = dokter;
	}

	public DokterModel getDokter() {
		return dokter;
	}
	
	public void setDaftarRujukanRawatJalan(List<RujukanRawatJalanModel> daftarRujukanRawatJalan) {
		this.daftarRujukanRawatJalan = daftarRujukanRawatJalan;
	}

	public List<RujukanRawatJalanModel> getDaftarRujukanRawatJalan() {
		return daftarRujukanRawatJalan;
	}
}