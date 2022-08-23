package ui;

import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

import static ui.UIDoctorMenu.showDoctorMenu;
import static ui.UIPatientMenu.showPatientMenu;

public class UIMenu {
      public static final String[] MONTHS = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
      public static Doctor doctorLogged;
      public static Patient patientLogged;
      public static void showMenu(){
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("Doctor");
                    response = 0;
                    authUser(1);
                    break;
                case 2:
                    response = 0;
                    authUser(2);
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response != 0);
    }

      private static void authUser(int userType){
          //userType 1 = doctor, 2 = patient

          ArrayList<Doctor> doctors = new ArrayList<>();
          doctors.add(new Doctor("John Doe", "john@mail.com", "Cardiology"));
          doctors.add(new Doctor("Robert", "roberth@mail.com", "Pediatrics"));

          ArrayList<Patient> patients = new ArrayList<>();
          patients.add(new Patient("Danilo", "danilo@mail.com"));
          patients.add(new Patient("Juan", "juan@mail.com"));
          patients.add(new Patient("Maria", "maria@mail.com"));

          boolean emailCorrect = false;

          do{
              System.out.println("Introduce your email");
              Scanner sc = new Scanner(System.in);
              String email = sc.nextLine();
              if (userType == 1){
                    for (Doctor doctor: doctors){
                        if (doctor.getEmail().equals(email)){
                            emailCorrect = true;
                            doctorLogged = doctor;
                            showDoctorMenu();

                        }
                    }
              }
              if (userType == 2){
                    for (Patient patient: patients){
                        if (patient.getEmail().equals(email)){
                            emailCorrect = true;
                            patientLogged = patient;
                            showPatientMenu();
                        }
                    }
              }

          }while(!emailCorrect);
      }
      /*public static void showPatientMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome " + patientLogged.getName());
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    for (int i = 0; i < 3 ; i++) {
                        System.out.println(i+1 + ". " + MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        }while (response != 0);
    }*/
}
