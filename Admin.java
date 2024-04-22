package com.example.pediatendprimary.stash;

class Admin extends User
{

    public Admin(String firstName, String lastName, String email, String password, UserType userType) {
        super(firstName, lastName, email, password, userType);
    }

    // The admin can add users of all types, but patients usually sign up themselves
    public int addUser(String email, String pwd, UserType userType)
    {
        // Add the user info. into a file
        return 0;
    }
}
