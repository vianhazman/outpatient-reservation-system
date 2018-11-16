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
@Table(name = "penanganan")
public class PenangananModel implements Serializable {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(name = "id_pasien_rawat_jalan", nullable = false)
	private int idPasienRawatJalan;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rujukan_rawat_jalan_id", referencedColumnName = "id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private RujukanRawatJalanModel rujukanRawatJalan;
	
	@NotNull
	@Size(max = 255)
	@Column(name = "deskripsi", nullable = false)
	private String deskripsi;
	
	@NotNull
	@Column(name = "waktu", nullable = false)
	private Date waktu;
	
	@OneToMany(mappedBy="penanganan", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<ObatModel> daftarObat;
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
	
	public void setIdPasienRawatJalan(int idPasienRawatJalan) {
		this.idPasienRawatJalan = idPasienRawatJalan;
	}

	public int getIdPasienRawatJalan() {
		return idPasienRawatJalan;
	}
	
	public void setWaktu(Date waktu) {
		this.waktu = waktu;
	}

	public Date getWaktu() {
		return waktu;
	}
	
	public void setRujukanRawatJalan(RujukanRawatJalanModel rujukanRawatJalan) {
		this.rujukanRawatJalan = rujukanRawatJalan;
	}

	public RujukanRawatJalanModel getRujukanRawatJalan() {
		return rujukanRawatJalan;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	public String getDeskripsi() {
		return deskripsi;
	}
	
	public void setDaftarObat(List<ObatModel> daftarObat) {
		this.daftarObat = daftarObat;
	}

	public List<ObatModel> getDaftarObat() {
		return daftarObat;
	}
}