package project0;

public class Patient {

    private String fname; 
    private int age;

    public Patient(String fname, int age) {
        this.fname = fname;
        this.age = age; 
    }

    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    } 

}
