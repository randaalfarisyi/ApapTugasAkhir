package com.apap.tugasakhir.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "jenis_pemeriksaan")
public class JenisModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(max = 255)
	@Column(name = "nama", nullable = false)
	private String nama;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_supplies", referencedColumnName = "id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private LabSuppliesModel idSupplies;
	
	@OneToMany(mappedBy="jenis", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<PemeriksaanModel> pemeriksaan;

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

	public LabSuppliesModel getIdSupplies() {
		return idSupplies;
	}

	public void setIdSupplies(LabSuppliesModel idSupplies) {
		this.idSupplies = idSupplies;
	}

	public List<PemeriksaanModel> getPemeriksaan() {
		return pemeriksaan;
	}

	public void setPemeriksaan(List<PemeriksaanModel> pemeriksaan) {
		this.pemeriksaan = pemeriksaan;
	}

	
}
