package ftn.informatika.org.test_app.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Prijava {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String drzTakmicara;
	
	@Column(nullable = false, unique = true)
	private String eMail;
	
	@Column(nullable = false)
	private String datPrijave;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Takmicenje takmicenje;

	public Prijava() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDrzTakmicara() {
		return drzTakmicara;
	}

	public void setDrzTakmicara(String drzTakmicara) {
		this.drzTakmicara = drzTakmicara;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getDatPrijave() {
		return datPrijave;
	}

	public void setDatPrijave(String datPrijave) {
		this.datPrijave = datPrijave;
	}

	public Takmicenje getTakmicenje() {
		return takmicenje;
	}

	public void setTakmicenje(Takmicenje takmicenje) {
		this.takmicenje = takmicenje;
	}
	
	

}
