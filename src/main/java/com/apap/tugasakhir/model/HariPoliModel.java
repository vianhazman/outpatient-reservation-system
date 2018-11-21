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
@Table(name = "hari_poli")
public class HariPoliModel implements Serializable {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "poli_id", referencedColumnName = "id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private PoliModel poli;
	
	@NotNull
	@Size(max = 255)
	@Column(name = "hari", nullable = false)
	private String hari;
	
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

	public void setHari(String hari) {
		this.hari = hari;
	}

	public String getHari() {
		return hari;
	}
}