package enums;

public enum BrowserType {

	FIREFOX("firefox"),
	CHROME("chrome"),
	IE("internet_explorer"),
	SAFARI("safari");

	private String value;

	BrowserType(String value){
		this.value = value;
	}

	public String getBrowserName() {
		return this.value;
	}


}
