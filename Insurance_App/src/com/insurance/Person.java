package com.insurance;

import java.util.Random;

public class Person implements Patient {

	private String firstName, lastName, birthdate, contactFirst, contactLast;
	private double weight, height;
	private int patientID;

	Random rnd = new Random();

	public Person(String firstName, String lastName, String contactFirst, String contactLast, String birthdate,
			double weight, double height) {
		super();

		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.weight = weight;
		this.height = height;
		this.contactFirst = contactFirst;
		this.contactLast = contactLast;
	}

	// Getters to access our private variables. Constructor sets the values of the
	// variables, so no need for setters.
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public double getWeight() {
		return weight;
	}

	public double getHeight() {
		return height;
	}

	public int setPatientID() {
		patientID = rnd.nextInt(999999999 - 100000000) + 100000000;
		return this.patientID;
	}

	public String setEmergencyContact() {

		return this.contactFirst + " " + this.contactLast;
	}

}
