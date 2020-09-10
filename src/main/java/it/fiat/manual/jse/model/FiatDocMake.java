package it.fiat.manual.jse.model;


import javax.persistence.*;

@Entity
@Table(name = "make")
public class FiatDocMake {

	@Id
	@Column(name = "ID")
	private String brandCode;

	@Column(name = "NAME")
	private String description;

	public FiatDocMake(String brandCode, String description) {
		this.brandCode = brandCode;
		this.description = description;
	}

	public FiatDocMake() {
	}

	// Property accessors

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public String getBrandCode() {
		return brandCode;
	}


	@Override
	public String toString() {
		return "\n FiatMake [brandCode=" + brandCode + ", description="
				+ description + "]";
	}

}
