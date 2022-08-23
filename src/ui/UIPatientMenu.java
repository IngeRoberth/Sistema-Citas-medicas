package ui;

import model.Doctor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import static ui.UIDoctorMenu.doctorsAvailableAppointments;
import static ui.UIMenu.patientLogged;
import static ui.UIMenu.showMenu;

public class UIPatientMenu {

    public static void showPatientMenu(){
        int respose = 0;

        do{
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome " + patientLogged.getName());
            System.out.println("1. Book an appointment");
            System.out.println("2. My Appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            respose = Integer.valueOf(sc.nextLine());

            switch (respose){
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyAppointments();
                    break;
                case 0:
                    showMenu();
                    break;

            }

        }while(respose != 0);
    }

    private static void showBookAppointmentMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("::Book an appointment");
            System.out.println(":: Select date");

            //Numeracion de la lista de fechas
            //Indice fecha seleccionada
            Map<Integer, Map<Integer, Doctor>> doctos = new TreeMap<>();
            int index = 0;
            for (int i = 0; i < doctorsAvailableAppointments.size() ; i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments = doctorsAvailableAppointments.get(i).getAvailableAppointments();

                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();
                for (int j = 0; j < availableAppointments.size() ; j++) {
                    index++;
                    System.out.println(index + ". " + availableAppointments.get(j).getDate());
                    doctorAppointments.put(Integer.valueOf(j), doctorsAvailableAppointments.get(i));
                    doctos.put(Integer.valueOf(index), doctorAppointments);
                }
            }

            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());

            Map<Integer, Doctor> doctorAvailableSelected = doctos.get(responseDateSelected);
            Integer indexDate =0;
            Doctor doctorSelected = new Doctor("","","");

            for (Map.Entry<Integer, Doctor> doc:doctorAvailableSelected.entrySet()) {
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }
            System.out.println(doctorSelected.getName() + ". Date: " + doctorSelected.getAvailableAppointments().get(indexDate).getDate() + ". Time: " + doctorSelected.getAvailableAppointments().get(indexDate).getTime());

            System.out.println("Confirm appointment? \n1. Yes \n2. Change Data");

            response = Integer.valueOf(sc.nextLine());

            if (response == 1){
                patientLogged.addAppointmentsDoctors(
                        doctorSelected ,
                        doctorSelected.getAvailableAppointments().get(indexDate),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime()
                        );
                showPatientMenu();
            }


        }while (response != 0);
    }

    private static void showPatientMyAppointments(){
        int response = 0;

        do {
            System.out.println("\n\n");
            System.out.println("::My appointments");
            if (patientLogged.getAppointmentsDoctors().size() == 0){
                System.out.println("Don't have appointments");
                break;
            }else{
                for (int i = 0; i < patientLogged.getAppointmentsDoctors().size(); i++) {
                    System.out.println(i + ". " + patientLogged.getAppointmentsDoctors().get(i).getDoctor().getName() + ". Date: " + patientLogged.getAppointmentsDoctors().get(i).getDate() + ". Time: " + patientLogged.getAppointmentsDoctors().get(i).getTime());
                }
            }
            System.out.println("0. Return");
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            if (response == 0){
                showPatientMenu();
            }
        }while (response != 0);
    }
}
