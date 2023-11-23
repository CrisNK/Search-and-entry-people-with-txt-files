package classes;
public class Person {
    protected String rut;
    protected String fullName;
    protected String faculty;
    protected String numberPhone;
    protected String email;
    protected String address;

    public Person() {
        rut = "";
        fullName = "";
        faculty = "";
        numberPhone = "";
        email = "";
        address = "";
    }

    public Person(String rut, String fullName, String faculty, String numberPhone, String email, String address) {
        this.rut = rut;
        this.fullName = fullName;
        this.faculty = faculty;
        this.numberPhone = numberPhone;
        this.email = email;
        this.address = address;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setFaculty(String facultyString) {
        this.faculty = facultyString;
    }
    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getRut() {
        return rut;
    }
    public String getFullName() {
        return fullName;
    }
    public String getFaculty() {
        return faculty;
    }
    public String getNumberPhone() {
        return numberPhone;
    }
    public String getEmail() {
        return email;
    }
    public String getAddress() {
        return address;
    }
}