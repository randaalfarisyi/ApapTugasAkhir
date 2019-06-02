package com.apap.tugasakhir.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="kebutuhan_reagen")
public class KebutuhanReagenModel implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nama", nullable = false)
	private String nama;
	
	@JoinColumn(name="id_reagen",referencedColumnName="id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Optional<LabSuppliesModel> idReagen;
	
	@Column(name = "jumlah", nullable = false)
	private int jumlah;
	
	@NotNull
	@Column(name="status", nullable = false)
	private int status = 1;
	
	@Column(name="tanggal_update")
	private Date tanggalUpdate;

	public Date getTanggalUpdate() {
		return tanggalUpdate;
	}

	public void setTanggalUpdate(Date tanggalUpdate) {
		this.tanggalUpdate = tanggalUpdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Optional<LabSuppliesModel> getIdReagen() {
		return idReagen;
	}

	public void setIdReagen(Optional<LabSuppliesModel> archive) {
		this.idReagen = archive;
	}

	public int getJumlah() {
		return jumlah;
	}

	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
