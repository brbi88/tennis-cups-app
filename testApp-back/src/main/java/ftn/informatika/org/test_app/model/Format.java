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
import javax.persistence.OneToMany;


@Entity
public class Format {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String tipTakmicenja;
	
	@Column
	private int brUcesnika;
	
	@OneToMany(mappedBy = "format", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Takmicenje> takmicenja = new ArrayList<>();

	public Format() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipTakmicenja() {
		return tipTakmicenja;
	}

	public void setTipTakmicenja(String tipTakmicenja) {
		this.tipTakmicenja = tipTakmicenja;
	}

	public int getBrUcesnika() {
		return brUcesnika;
	}

	public void setBrUcesnika(int brUcesnika) {
		this.brUcesnika = brUcesnika;
	}

	public List<Takmicenje> getTakmicenja() {
		return takmicenja;
	}

	public void setTakmicenja(List<Takmicenje> takmicenja) {
		this.takmicenja = takmicenja;
	}
	
	
	
	
	

}
