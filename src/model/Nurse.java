package model;

public class Nurse extends User {
    private String specialization;

    public Nurse (String name, String email){
        super(name, email);
    }

    @Override
    public void showDataUser() {
        System.out.println("Hospital: Divina Misericordia");
        System.out.println("Departamento: Enfermería");
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
