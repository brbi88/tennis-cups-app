package ftn.informatika.org.test_app.web.dto;


public class FormatDTO {
	
	
	private Long id;
	
	private String tipTakmicenja;
	
	private int brUcesnika;

	public FormatDTO() {
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
	
	

}
