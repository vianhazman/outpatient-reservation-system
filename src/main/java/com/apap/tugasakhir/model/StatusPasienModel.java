package com.apap.tugasakhir.model;

import java.io.Serializable;

public class StatusPasienModel implements Serializable {

	private long id;
    private String jenis;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getJenis() {
		return jenis;
	}
	public void setJenis(String jenis) {
		this.jenis = jenis;
	}
	
	public String toString() {
		return jenis;
	}
}
