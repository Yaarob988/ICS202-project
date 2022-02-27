
public class City {
	private String cityName;
	private double decimalLatitude;
	private double decimalLongitude;

	public City(String cityName, double decimalLatitude, double decimalLongitude) {
		this.cityName = cityName;
		this.decimalLatitude = decimalLatitude;
		this.decimalLongitude = decimalLongitude;
	}

	public City(String cityName) {
		this.cityName = cityName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public double getDecimalLatitude() {
		return decimalLatitude;
	}

	public void setDecimalLatitude(double decimalLatitude) {
		this.decimalLatitude = decimalLatitude;
	}

	public double getDecimalLongitude() {
		return decimalLongitude;
	}

	public void setDecimalLongitude(double decimalLongitude) {
		this.decimalLongitude = decimalLongitude;
	}public String toString() {
		return "cityName=" + cityName + "\n decimalLatitude=" + decimalLatitude + "\n decimalLongitude="
				+ decimalLongitude;
	}
	
	
}
