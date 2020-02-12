package simulator.model;

public enum Weather {
	SUNNY(2,2), CLOUDY(3,2), RAINY(10,2), WINDY(15,10), STORM(20,10);
	private int contInterCity, contCity;

	private Weather(int contInterCity, int contCity) {
		this.contInterCity = contInterCity;
		this.contCity = contCity;
	}

	public int getContInterCity() {
		return contInterCity;
	}

	public int getContCity() {
		return contCity;
	}
	
}
