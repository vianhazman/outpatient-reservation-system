package com.apap.tugasakhir.wrapper;

import java.sql.Date;

public class PostLaboratoriumWrapper {
 private int id;
 public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getTanggal_pengajuan() {
	return tanggal_pengajuan;
}
public void setTanggal_pengajuan(Date tanggal_pengajuan) {
	this.tanggal_pengajuan = tanggal_pengajuan;
}
public int getPasien() {
	return pasien;
}
public void setPasien(int pasien) {
	this.pasien = pasien;
}
public Date getTanggal_pemeriksaan() {
	return tanggal_pemeriksaan;
}
public void setTanggal_pemeriksaan(Date tanggal_pemeriksaan) {
	this.tanggal_pemeriksaan = tanggal_pemeriksaan;
}
public int getJenis() {
	return jenis;
}
public void setJenis(int jenis) {
	this.jenis = jenis;
}
public int getId_jadwal() {
	return id_jadwal;
}
public void setId_jadwal(int id_jadwal) {
	this.id_jadwal = id_jadwal;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public int getHasil() {
	return hasil;
}
public void setHasil(int hasil) {
	this.hasil = hasil;
}
private Date tanggal_pengajuan;
 private int pasien;
 private Date tanggal_pemeriksaan;
 private int jenis;
 private int id_jadwal;
 private int status;
 private int hasil;
}
