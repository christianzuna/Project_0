package project0;

public class Patient {

    private String ssn; 
    private String fname; 
    private String lname;
    private int age;

    public Patient(String ssn, String fname, String lname, int age) {
        this.ssn = ssn; 
        this.fname = fname;
        this.lname = lname; 
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

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    } 

    @Override
    public String toString() {
        return fname + " " + lname + ", " + age + " -" + ssn.substring(0, 4) + "xx";
    }

}
