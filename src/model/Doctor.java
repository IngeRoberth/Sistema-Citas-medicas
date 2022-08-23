package model;

import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {
    private String specialization;
    private ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();

    public Doctor(String name, String email, String specialization) {
        super(name, email);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void addAvailableAppointment(String date, String time) {

        availableAppointments.add(new AvailableAppointment(date, time));
    }

    public ArrayList<AvailableAppointment> getAvailableAppointments() {
        return availableAppointments;
    }
    @Override
    public String toString() {
        return super.toString()  + "specialization=" + specialization + ", availableAppointments=" + availableAppointments.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("Hospital: Cruzeiro");
        System.out.println("Departamento: Pediatria");
    }

    public static class  AvailableAppointment {
        private int id;
        private String date;
        private String time;

        public AvailableAppointment(String date, String time) {
            this.date = date;
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "AvailableAppointment: " + ", date=" + date + ", time=" + time;
        }
    }

}

