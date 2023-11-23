package classes;
public class Student extends Person {
    private String degree;
    private int admissionYear;
    private int semester;
    private float gradePointAverage; // GPA

    public Student() {
        super("", "", "", "", "", "");
        this.degree = "";
        this.admissionYear = 0;
        this.semester = 0;
        this.gradePointAverage = 0;
    }
    public Student(Person person) {
        super(person.getRut(), person.getFullName(), person.getFaculty(), person.getNumberPhone(), person.getEmail(),
            person.getAddress());
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
    public void setAdmissionYear(int admissionYear) {
        this.admissionYear = admissionYear;
    }
    public void setSemester(int semester) {
        this.semester = semester;
    }
    public void setGradePointAverage(float gradePointAverage) {
        this.gradePointAverage = gradePointAverage;
    }

    public String getDegree() {
        return degree;
    }
    public int getAdmissionYear() {
        return admissionYear;
    }
    public int getSemester() {
        return semester;
    }
    public float getGradePointAverage() {
        return gradePointAverage;
    }

}