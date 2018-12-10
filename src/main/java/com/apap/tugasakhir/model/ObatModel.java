package com.apap.tugasakhir.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "obat")
public class ObatModel implements Serializable {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(max = 255)
	@Column(name = "nama", nullable = false)
	private String nama;
	
	@NotNull
	@Column(name = "jumlah", nullable = false)
	private int jumlah;
	
	@JsonIgnore
	@OneToMany(mappedBy="obat", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<PenangananModel> daftarPenanganan;

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getNama() {
		return nama;
	}
	
	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}

	public int getJumlah() {
		return jumlah;
	}
	
	public void setDaftarPenanganan(List<PenangananModel> daftarPenanganan) {
		this.daftarPenanganan = daftarPenanganan;
	}

	public List<PenangananModel> getDaftarPenanganan() {
		return daftarPenanganan;
	}
}