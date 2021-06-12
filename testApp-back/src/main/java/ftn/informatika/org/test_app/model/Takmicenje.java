package ftn.informatika.org.test_app.model;

import java.util.ArrayList;
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

@Entity
public class Takmicenje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String naziv;
	
	@Column(nullable = false)
	private String mestoOdrz;
	
	@Column(nullable = false)
	private String datPocetka;
	
	@Column(nullable = false)
	private String datZavrsetka;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Format format;
	
	@OneToMany(mappedBy = "takmicenje", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Prijava> prijave = new ArrayList<>();

	public Takmicenje() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getMestoOdrz() {
		return mestoOdrz;
	}

	public void setMestoOdrz(String mestoOdrz) {
		this.mestoOdrz = mestoOdrz;
	}

	public String getDatPocetka() {
		return datPocetka;
	}

	public void setDatPocetka(String datPocetka) {
		this.datPocetka = datPocetka;
	}

	public String getDatZavrsetka() {
		return datZavrsetka;
	}

	public void setDatZavrsetka(String datZavrsetka) {
		this.datZavrsetka = datZavrsetka;
	}

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	public List<Prijava> getPrijave() {
		return prijave;
	}

	public void setPrijave(List<Prijava> prijave) {
		this.prijave = prijave;
	}
	
	
	
	
	

}
