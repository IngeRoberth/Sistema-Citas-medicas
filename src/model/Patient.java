package model;

import java.util.ArrayList;

public class Patient extends User {
    private  String birthday;
    private  double weight;
    private  double height;
    private  String blood;

    private ArrayList<AppointmentDoctor> appointmentsDoctors = new ArrayList<>();
    private ArrayList<AppointmentNurse> appointmentsNurses = new ArrayList<>();


    public Patient(String name, String email){
        super(name, email);
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getWeight() {
        return weight + " kg";
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height + " m";
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public ArrayList<AppointmentDoctor> getAppointmentsDoctors() {
        return appointmentsDoctors;
    }

    public void addAppointmentsDoctors(Doctor doctor, Doctor.AvailableAppointment date, String time) {
        AppointmentDoctor appointmentDoctor = new AppointmentDoctor(this, doctor);
        /*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");*/
       /* try {
            Date dateC = dateFormat.parse(date);
            appointmentDoctor.schedule(dateC, time);
            appointmentsDoctors.add(appointmentDoctor);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        appointmentDoctor.schedule(String.valueOf(date), time);
        appointmentsDoctors.add(appointmentDoctor);
    }

    public ArrayList<AppointmentNurse> getAppointmentsNurses() {
        return appointmentsNurses;
    }

    public void setAppointmentsNurses(ArrayList<AppointmentNurse> appointmentsNurses) {
        this.appointmentsNurses = appointmentsNurses;
    }

    @Override
    public String toString() {
        return super.toString() + "model.Patient: " + "birthday=" + birthday + ", weight=" + getWeight() + ", height=" + getHeight() + ", blood=" + blood + '}';
    }

    @Override
    public void showDataUser() {
        System.out.println("Patient: " + "birthday=" + birthday + ", weight=" + getWeight() + ", height=" + getHeight() + ", blood=" + blood);
    }
}
