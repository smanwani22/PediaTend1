package com.example.pediatendprimary.stash;

import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Patient extends User
{

    // most recent vitals
    private double bodyTemp, weight;
    private int height, bloodPressure;

    private int birthYear, birthMonth, birthDay;

    private String immunizations, healthConcerns, prescriptions;

    private ArrayList<VisitHistory> pastVisits = new ArrayList<VisitHistory>();

    public Patient() {
        super();
    }
    public Patient(String firstName, String lastName, String day, String month, String year, String email, String password)
    {
        super(firstName, lastName, email, password, UserType.PATIENT);
    }
    public String getAge(int day, int month, int year)
    {
        String age, holdYears, holdMonths;
        LocalDate ageDate = LocalDate.of(year, month, day);
        LocalDate todayDate = LocalDate.now();
        Period calcPeriod = Period.between(ageDate, todayDate);
        holdYears = Integer.toString(calcPeriod.getYears());
        holdMonths = Integer.toString(calcPeriod.getMonths());
        age = holdYears + " years" + holdMonths + " months";
        return age;
    }

    public boolean checkAge(int day, int month, int year){
        boolean checker = false;
        LocalDate ageDate = LocalDate.of(year, month, day);
        LocalDate todayDate = LocalDate.now();
        Period calcPeriod = Period.between(ageDate, todayDate);
        if(calcPeriod.getYears() >= 12){
            checker = true;
        }
        return checker;
    }

    public double getBodyTemp() {
        return bodyTemp;
    }

    public void setBodyTemp(double bodyTemp) {
        this.bodyTemp = bodyTemp;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getImmunizations() {
        return immunizations;
    }

    public void setImmunizations(String immunizations) {
        this.immunizations = immunizations;
    }

    public String getHealthConcerns() {
        return healthConcerns;
    }

    public void setHealthConcerns(String healthConcerns) {
        this.healthConcerns = healthConcerns;
    }

    public String getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(String prescriptions) {
        this.prescriptions = prescriptions;
    }

    public ArrayList<VisitHistory> getPastVisits() {
        return pastVisits;
    }

    public void setPastVisits(ArrayList<VisitHistory> pastVisits) {
        this.pastVisits = pastVisits;
    }
}