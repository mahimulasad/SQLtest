package test;


public class Intensity {

	private double anger;
	private double disgust;
	private double fear;
	private double guilt;
	private double interest;
	private double joy;
	private double sadness;
	private double shame;
	private double surprise;

	public Intensity() {

		anger = disgust = fear = guilt = interest = joy = sadness = shame = surprise = 0.0;

	}
	
	public Intensity(double anger, double disgust, double fear, double guilt,
			double interest, double joy, double sadness, double shame,
			double surprise) {

		this.anger = anger;
		this.disgust = disgust;
		this.fear = fear;
		this.guilt = guilt;
		this.interest = interest;
		this.joy = joy;
		this.sadness = sadness;
		this.shame = shame;
		this.surprise = surprise;

	}

	public double getAnger() {
		return anger;
	}

	public void setAnger(double anger) {
		this.anger = anger;
	}

	public double getDisgust() {
		return disgust;
	}

	public void setDisgust(double disgust) {
		this.disgust = disgust;
	}

	public double getFear() {
		return fear;
	}

	public void setFear(double fear) {
		this.fear = fear;
	}

	public double getGuilt() {
		return guilt;
	}

	public void setGuilt(double guilt) {
		this.guilt = guilt;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public double getJoy() {
		return joy;
	}

	public void setJoy(double joy) {
		this.joy = joy;
	}

	public double getSadness() {
		return sadness;
	}

	public void setSadness(double sadness) {
		this.sadness = sadness;
	}

	public double getShame() {
		return shame;
	}

	public void setShame(double shame) {
		this.shame = shame;
	}

	public double getSurprise() {
		return surprise;
	}

	public void setSurprise(double surprise) {
		this.surprise = surprise;
	}
	
	
}
