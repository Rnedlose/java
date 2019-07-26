package com.insurance;

public class CalcBmi {

	private double weight, height, bmi;

	private String bmiCategory, insPremCate;

	public CalcBmi(double weight, double height) { // Constructor
		super();

		this.weight = weight;
		this.height = height;
	}

	public void setBmi() { // Uses information to determine bmi, bmi category, and insurance premium
							// category
		this.bmi = (this.weight * 703) / (this.height * this.height);

		if (this.bmi < 18.5) {
			this.bmiCategory = "Underweight.";
			this.insPremCate = "Low.";
		}

		else if (this.bmi >= 18.5 & this.bmi < 25) {
			this.bmiCategory = "Normalweight.";
			this.insPremCate = "Low.";
		}

		else if (this.bmi >= 25 & this.bmi < 29.9) {
			this.bmiCategory = "Overweight.";
			this.insPremCate = "High.";
		}

		else {
			this.bmiCategory = "Obese";
			this.insPremCate = "Highest.";
		}
	}

	// Getters only. Setters not necessary for this program we are setting
	// everything within the constructor

	public double getWeight() {
		return weight;
	}

	public double getHeight() {
		return height;
	}

	public double getBmi() {
		return bmi;
	}

	public String getBmiCategory() {
		return bmiCategory;
	}

	public String getInsPremCate() {
		return insPremCate;
	}

}
