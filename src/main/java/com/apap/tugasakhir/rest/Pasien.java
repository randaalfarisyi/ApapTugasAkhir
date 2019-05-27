package com.apap.tugasakhir.rest;

import java.io.Serializable;

public class Pasien implements Serializable {
    private int id;
    private String nama;
    private int idPeriksa;

    public int getIdPeriksa() {
        return idPeriksa;
    }

    public void setIdPemeriksaan(int idPeriksa) {
        this.idPeriksa = idPeriksa;
    }

    public int getId() {
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
}