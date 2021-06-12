package ftn.informatika.org.test_app.web.dto;



import org.hibernate.validator.constraints.Length;

public class TakmicenjeDTO {

	private Long id;
	
	private String naziv;
	@Length(max = 50)
	private String mestoOdrz;
	
	private String datPocetka;
	
	private String datZavrsetka;

	private Long formatId;
	
	private String formatTip;
	

	public TakmicenjeDTO() {
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

	public Long getFormatId() {
		return formatId;
	}

	public void setFormatId(Long formatId) {
		this.formatId = formatId;
	}

	public String getFormatTip() {
		return formatTip;
	}

	public void setFormatTip(String formatTip) {
		this.formatTip = formatTip;
	}
	
	

	}
	
	

