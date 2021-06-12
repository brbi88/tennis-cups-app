package ftn.informatika.org.test_app.web.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Size;

public class PrijavaDTO {

	private Long id;
	
	@Size(min=3)
	private String drzTakmicara;
	
	private String eMail;
	
	private String datPrijave;
	
	private Long takmicenjeId;
	
	private TakmicenjeDTO takmicenje;

	public PrijavaDTO() {
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

	public Long getTakmicenjeId() {
		return takmicenjeId;
	}

	public void setTakmicenjeId(Long takmicenjeId) {
		this.takmicenjeId = takmicenjeId;
	}

	public TakmicenjeDTO getTakmicenje() {
		return takmicenje;
	}

	public void setTakmicenje(TakmicenjeDTO takmicenje) {
		this.takmicenje = takmicenje;
	}

	
	
	
}
