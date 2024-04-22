package com.example.pediatendprimary.stash;

import java.util.ArrayList;

public class Nurse extends User
{
    ArrayList<Patient> patients;
    Patient currentPatient;
    public Nurse(String firstName, String lastName, String email, String password, UserType userType)
    {
        super(firstName, lastName, email, password, userType);
    }

    public void enterVitals()
    {

    }
}
