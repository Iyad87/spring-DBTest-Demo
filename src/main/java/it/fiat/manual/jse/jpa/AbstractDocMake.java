package it.fiat.manual.jse.jpa;

import org.springframework.stereotype.Service;

@Service
public abstract class AbstractDocMake {

	private String brandCode;

	private String description;

	public AbstractDocMake( String brandCode, String description) {
		this.brandCode = brandCode;
		this.description = description;
	}

	public AbstractDocMake() {

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
