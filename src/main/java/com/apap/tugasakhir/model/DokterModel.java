package com.apap.tugasakhir.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "dokter")
public class DokterModel implements Serializable {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(max = 255)
	@Column(name = "nama", nullable = false)
	private String nama;
	
	@OneToMany(mappedBy="dokter", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<JadwalPoliModel> daftarJadwalPoli;

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
	
	public void setDaftarJadwalPoli(List<JadwalPoliModel> daftarJadwalPoli) {
		this.daftarJadwalPoli = daftarJadwalPoli;
	}

	public List<JadwalPoliModel> getDaftarJadwalPoli() {
		return daftarJadwalPoli;
	}
}