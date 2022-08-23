package ui;

import model.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

import static ui.UIMenu.*;

public class UIDoctorMenu {

    public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<>();

    public static void showDoctorMenu(){
        int respose = 0;

        do {
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Welcome " + doctorLogged.getName());
            System.out.println("1. Add available appointment");
            System.out.println("2. My Schedule appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            respose = Integer.valueOf(sc.nextLine());

            switch (respose){
                case 1:
                    showAddAvailableAppointsMenu();
                    break;
                case 2:
                    break;
                case 0:
                    showMenu();
                    break;

            }

        }while (respose != 0);

    }
    private static void showAddAvailableAppointsMenu(){
        int response = 0;

        do {
            System.out.println("\n\n");
            System.out.println("::Add available appointment");
            System.out.println(":: Select a month");
            for (int i = 0; i < 3 ; i++) {
                System.out.println(i+1 + ". " + MONTHS[i]);
            }
            System.out.println("0. Return");
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            // response mayor a 0 y menor a 4
            if (response > 0 && response < 4){
                int monthSelected = response;
                System.out.println(monthSelected + ". " + MONTHS[monthSelected - 1]);

                System.out.println("Insert the day available: [dd/mm/yyyy]");
                String date = sc.nextLine();

                System.out.println("Your date is: " + date + "\n1. Correct \n2. Change Date");
                int responseDate = Integer.valueOf(sc.nextLine());
                if (responseDate == 2){
                    showAddAvailableAppointsMenu();
                }

                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("Insert the time available for date " + date + ": [hh:mm]");
                    time = sc.nextLine();
                    System.out.println("Your time is: " + time + "\n1. Correct \n2. Change Time");
                    responseTime = Integer.valueOf(sc.nextLine());
                    if (responseTime == 2){
                        continue;
                    }
                }while (responseTime == 2);

                doctorLogged.addAvailableAppointment(date, time);
                checkDoctorAvailableAppointments(doctorLogged);

            } else if (response ==0) {
                showDoctorMenu();
            }

        }while (response != 0);
    }

    private static void checkDoctorAvailableAppointments(Doctor doctor){
        if (doctor.getAvailableAppointments().size() > 0 && !doctor.getAvailableAppointments().contains(doctor)){
            doctorsAvailableAppointments.add(doctor);
        }
    }
}
