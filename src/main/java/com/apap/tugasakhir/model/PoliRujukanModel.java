package com.apap.tugasakhir.model;

import java.io.Serializable;

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
	    private String nama;
}
