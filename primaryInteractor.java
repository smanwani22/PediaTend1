package com.example.pediatendprimary.DBHandler;

import com.example.pediatendprimary.stash.Patient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class primaryInteractor {
    public String firstName, lastName, email, password,birthdate;
    public int phone;
    public String content;

    public primaryInteractor(){}
    public Patient readFile(String fn,String ln,String month,String day,String year) throws NoSuchAlgorithmException, FileNotFoundException {
        birthdate = month+day+year;
        String UID = fn + ln + birthdate;

        File patientFile = new File("./databaseFiles/DB_" + UID + ".db");
        Scanner scanner = new Scanner( patientFile);

        if (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            String[] parts = data.split("~~~");
            System.out.println(parts[0]);
            System.out.println(parts[1]);
            System.out.println(parts[2]);
            System.out.println(parts[3]);

            String fetched_UID = parts[0];
            String fetched_firstname = parts[1];
            String fetched_lastname = parts[2];
            int fetched_dob = Integer.parseInt(parts[3]);
            String fetched_email = parts[4];
            String fetched_password = parts[5];
        }
        return new Patient(fn,ln, month, day, year,email ,password);
    }

    public String readFile(String filename) throws NoSuchAlgorithmException, FileNotFoundException {

        String UID = firstName + lastName + birthdate;

        //File filename = new File("./databaseFiles/DB_" + UID + ".db");
        Scanner scanner = new Scanner("./databaseFiles/" + filename);
        String healthdata = "no health data.";
        if (scanner.hasNextLine()) {
            scanner.nextLine();// skip first line of data
            if (scanner.hasNextLine())
                healthdata = scanner.nextLine();
        }
        return healthdata;
    }
    public String[] GetFields(String fn,String ln, int dob) throws NoSuchAlgorithmException, FileNotFoundException {

        String UID = fn + ln + dob;

        File patientFile = new File("./databaseFiles/DB_" + UID + ".db");
        Scanner scanner = new Scanner(patientFile);

        String[] parts = new String[0];
        if (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            parts = data.split("~~~");

//            String fetched_UID = parts[0];
//            String fetched_firstname = parts[1];
//            String fetched_lastname = parts[2];
//            int fetched_dob = Integer.parseInt(parts[3]);
//            String fetched_email = parts[4];
//            String fetched_password = parts[5];
        }

        return parts;
    }

    public void writeToFile(String fn, String ln, int dob, String em, String pw) throws NoSuchAlgorithmException {

        File dbdir = new File("./databaseFiles");
        if (dbdir.exists() && dbdir.isDirectory()) {
            System.out.println("Db directory exists, continuing.");
        } else {
            System.out.println("Db directory does not exist, making one.");
            dbdir.mkdirs();
        }

        String UID = fn+ln+dob;
        try {
            FileWriter writer = new FileWriter("./databaseFiles/DB_" + UID + ".db");
            String sep = "~~~";
            writer.write(UID + sep +  fn + sep + ln + sep + dob + sep + em + sep + pw + "\n");
            writer.close();
        } catch (IOException ex) {
            System.out.println("an error occurred. :(");
            //ex.printStackTrace();
        }
    }
//    public String hash(String firstName, String lastName, int dob) throws NoSuchAlgorithmException {
//        MessageDigest digest = MessageDigest.getInstance("SHA-256");
//        String construct = firstName + lastName + dob;
//        byte[] hashByte = digest.digest(construct.getBytes(StandardCharsets.UTF_8));
////        return Base64.getEncoder().encodeToString(hashByte);
//
//        return firstName++lastName;
//    }
}
