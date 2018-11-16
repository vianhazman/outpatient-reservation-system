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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "poli_id", referencedColumnName = "id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private PoliModel poli;

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
	
	public void setPoli(PoliModel poli) {
		this.poli = poli;
	}

	public PoliModel getPoli() {
		return poli;
	}
}