package com.example.pediatendprimary.stash;

import java.util.ArrayList;

public class Doctor extends User
{
    ArrayList<Patient> patients;
    Patient currentPatient;
    public Doctor(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password, UserType.DOCTOR);
    }

    private void addVisitHistory()
    {

    }

}
