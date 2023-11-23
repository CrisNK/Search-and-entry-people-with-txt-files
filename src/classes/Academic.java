package classes;
public class Academic extends Person {
    private String departament;
    private String researchArea;
    private int yearsInService;

    public Academic() {
        super("", "", "", "", "", "");
        this.departament = "";
        this.faculty = "";
        this.researchArea = "";
        this.yearsInService = 0;
    }
    public Academic(Person person) {
        super(person.getRut(), person.getFullName(), person.getFaculty(), person.getNumberPhone(), person.getEmail(),
            person.getAddress());
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }
    public void setResearchArea(String researchArea) {
        this.researchArea = researchArea;
    }
    public void setYearsInService(int yearsInService) {
        this.yearsInService = yearsInService;
    }

    public String getDepartament() {
        return departament;
    }
    public String getResearchArea() {
        return researchArea;
    }
    public int getYearsInService() {
        return yearsInService;
    }
}