package it.fiat.manual.jse.jpa;

public abstract class AbstractDocMake {

	private int id;
	private String brandCode;

	private String description;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "\n FiatMake [brandCode=" + brandCode + ", description="
				+ description + "]";
	}

}
