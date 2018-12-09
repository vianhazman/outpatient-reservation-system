package com.apap.tugasakhir.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PoliRujukanModel implements Serializable {

	    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
		private long id;
		@JsonIgnore
	    private String nama;
}
