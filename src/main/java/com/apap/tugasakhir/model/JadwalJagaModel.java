package com.apap.tugasakhir.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.apap.tugasakhir.rest.Staf;

@Entity
@Table(name = "jadwal_jaga")
public class JadwalJagaModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(name = "tanggal", nullable = false)
	private Date tanggal;
	
	@NotNull
	@Column(name = "waktu_mulai", nullable = false)
	private String waktuMulai;
	
	@NotNull
	@Column(name = "waktu_selesai", nullable = false)
	private String waktuSelesai;
	
	@NotNull
	@Column(name = "id_staff", nullable = false)
	private int idStaff;
		
	@Column(name = "staf_lab")
	private Staf stafLab;
	
	@OneToMany(mappedBy="idJadwal", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<PemeriksaanModel> jadwalJagaPemeriksaan;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	public String getWaktuMulai() {
		return waktuMulai;
	}

	public void setWaktuMulai(String waktuMulai) {
		this.waktuMulai = waktuMulai;
	}

	public String getWaktuSelesai() {
		return waktuSelesai;
	}

	public void setWaktuSelesai(String waktuSelesai) {
		this.waktuSelesai = waktuSelesai;
	}
	
	public int getIdStaff() {
		return idStaff;
	}

	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}

	public List<PemeriksaanModel> getJadwalJagaPemeriksaan() {
		return jadwalJagaPemeriksaan;
	}

	public void setJadwalJagaPemeriksaan(List<PemeriksaanModel> jadwalJagaPemeriksaan) {
		this.jadwalJagaPemeriksaan = jadwalJagaPemeriksaan;
	}
	
	public Staf getStafLab() {
		return stafLab;
	}

	public void setStafLab(Staf staf) {
		this.stafLab = staf;
	}

	
}
