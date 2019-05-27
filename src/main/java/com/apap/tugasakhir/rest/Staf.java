package com.apap.tugasakhir.rest;


import java.io.Serializable;

public class Staf implements Serializable {
	private int id;
	private String nama;
	private int jenis;

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public int getJenis() {
		return jenis;
	}

	public void setJenis(int jenis) {
		this.jenis = jenis;
	}
	
	
	
}

