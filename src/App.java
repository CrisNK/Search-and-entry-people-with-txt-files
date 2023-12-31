import classes.Person;
import classes.Student;
import classes.Academic;
import classes.OptionsPerson;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList < Person > people = new ArrayList < > ();
        ArrayList < Student > students = new ArrayList < > ();
        ArrayList < Academic > academics = new ArrayList < > ();

        while (true) {
            people.clear();
            students.clear();
            academics.clear();

            clearTerminal();
            displayMainMenu();
            int option = requestOption("main");

            // Menu principal
            if (option == 1) {
                do {
                    clearTerminal();
                    displayCreationMenu();
                    int optionPerson = requestOption("person");

                    // Menú selectivo de persona/estudiante/académico
                    if (optionPerson == 1) {
                        displayPersonMenu();
                        people.add(personCreated());
                    }
                    if (optionPerson == 2) {
                        displayStudentMenu();
                        students.add(studentCreated());
                        scanner.nextLine(); // Consume el salto de línea del buffer de entrada.
                    }
                    if (optionPerson == 3) {
                        displayAcademicMenu();
                        academics.add(academicCreated());
                        scanner.nextLine(); // Consume el salto de línea del buffer de entrada.
                    }

                    clearTerminal();
                    System.out.print("\tIngreso exitoso\n" + "¿Desea ingresar otra persona?\n" + "> ");
                } while (scanner.next().equals("si"));

                writePeopleInTheFile(people);
                writeStudentsInTheFile(students);
                writeAcademicsInTheFile(academics);
            }
            if (option == 2) {
                clearTerminal();
                displaySearchMenu();

                OptionsPerson optionsPerson = new OptionsPerson();

                int optionSearch = requestOption("search"), currentPosition = 125;
                if (optionSearch == 1) { // Buscar información referente a una persona.
                    scanner.nextLine(); // Consume salto de línea del buffer de entrada
                    while (true) {
                        clearTerminal();
                        System.out.print(optionsPerson.menu);
                        String input = scanner.nextLine();
                        if (input.isEmpty()) { // Si el usuario ingresa sólo un ENTER marca con una 'X'
                            if (currentPosition == 424) {
                                // Programar cuando el usuario le da a BUSCAR
                                break;
                            } else {
                                optionsPerson.check(currentPosition);
                            }
                        } else {
                            char movement = input.charAt(0);
                            if (movement == 'w' && currentPosition >= 166)
                                currentPosition = optionsPerson.up(currentPosition);
                            if (movement == 's' && currentPosition <= 330)
                                currentPosition = optionsPerson.down(currentPosition);
                        }
                    }
                }
                if (optionSearch == 2) { // Buscar información referente a un estudiante.

                }
                if (optionSearch == 3) { // Buscar información referente a un académico.

                }
            }
            if (option == 3)
                System.exit(0);
        }
    }

    public static void clearTerminal() {
        try {
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                // Para Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Para sistemas UNIX, Linux, macOS
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void displayMainMenu() {
        System.out.print(
            "*--------------------------*\n" +
            "|       Menu principal     |\n" +
            "*--------------------------*\n" +
            "| 1. Registrar persona     |\n" +
            "| 2. Buscar informacion    |\n" +
            "| 3. Salir                 |\n" +
            "*--------------------------*\n" +
            "Seleccione una opcion: ");
    }
    public static void displayCreationMenu() {
        System.out.print(
            "*--------------------------*\n" +
            "|     Menu de registro     |\n" +
            "*--------------------------*\n" +
            "| 1. Crear persona         |\n" +
            "| 2. Crear estudiante      |\n" +
            "| 3. Crear académico       |\n" +
            "*--------------------------*\n" +
            "Seleccione una opcion: ");
    }
    public static void displayPersonMenu() {
        clearTerminal();
        System.out.print(
            "*--------------------------*\n" +
            "|       Crear persona      |\n" +
            "*--------------------------*\n");
    }
    public static void displayStudentMenu() {
        clearTerminal();
        System.out.print(
            "*--------------------------*\n" +
            "|     Crear estudiante     |\n" +
            "*--------------------------*\n");
    }
    public static void displayAcademicMenu() {
        clearTerminal();
        System.out.print(
            "*--------------------------*\n" +
            "|      Crear académico     |\n" +
            "*--------------------------*\n");

    }
    public static void displaySearchMenu() {
        System.out.print(
            "*--------------------------*\n" +
            "|   Búsqueda referente a:  |\n" +
            "*--------------------------*\n" +
            "| 1. Persona               |\n" +
            "| 2. Estudiante            |\n" +
            "| 3. Académico             |\n" +
            "*--------------------------*\n" +
            "> ");
    }

    public static int requestOption(String IDMenu) {
        int option;
        do {
            option = scanner.nextInt();
            if (option < 1 || option > 3) {
                clearTerminal();
                System.out.println("La opcion ingresada no es válida.");
                if (IDMenu.equals("main"))
                    displayMainMenu();
                if (IDMenu.equals("person"))
                    displayCreationMenu();
                if (IDMenu.equals("search"))
                    displaySearchMenu();
            }
        } while (option < 1 || option > 3);
        return option;
    }
    public static void selectOptions() {

    }
    public static Person personCreated() {
        scanner.nextLine(); // Consume el salto de línea del buffer de entrada.
        Person person = new Person();

        System.out.print("Rut: ");
        person.setRut(scanner.nextLine());

        System.out.print("Nombre completo: ");
        person.setFullName(scanner.nextLine());

        System.out.print("Facultad: ");
        person.setFaculty(scanner.nextLine());

        System.out.print("Número de teléfono: ");
        person.setNumberPhone(scanner.nextLine());

        System.out.print("Correo eléctronico: ");
        person.setEmail(scanner.nextLine());

        System.out.print("Dirección: ");
        person.setEmail(scanner.nextLine());

        return person;
    }
    public static Student studentCreated() {

        Person person = personCreated();
        Student student = new Student(person);

        System.out.print("Carrera: ");
        student.setDegree(scanner.nextLine());

        System.out.print("Año de ingreso: ");
        student.setAdmissionYear(scanner.nextInt());

        System.out.print("Semestre: ");
        student.setSemester(scanner.nextInt());

        System.out.print("Promedio acumulado: ");
        student.setGradePointAverage(scanner.nextFloat());

        return student;
    }
    public static Academic academicCreated() {
        Person person = personCreated();
        Academic academic = new Academic(person);

        System.out.print("Departamento: ");
        academic.setDepartament(scanner.nextLine());

        System.out.print("Linea de investigación: ");
        academic.setResearchArea(scanner.nextLine());

        System.out.print("Antigüedad: ");
        academic.setYearsInService(scanner.nextInt());

        return academic;
    }

    public static void writePeopleInTheFile(ArrayList < Person > people) {
        try {
            File file = new File("src/database/people.txt");
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Person person: people) {
                bw.write(person.getRut() + " " + person.getFullName() + " " + person.getFaculty() + " " +
                    person.getNumberPhone() + " " + person.getNumberPhone() + " " + person.getEmail() + " " +
                    person.getAddress());
                bw.newLine();
            }

            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeStudentsInTheFile(ArrayList < Student > students) {
        try {
            File file = new File("src/database/students.txt");
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            File file2 = new File("src/database/people.txt");
            FileWriter fw2 = new FileWriter(file2, true);
            BufferedWriter bw2 = new BufferedWriter(fw2);

            for (Student student: students) {
                bw.write(student.getRut() + " " + student.getDegree() + " " + student.getAdmissionYear() + " " +
                    student.getSemester() + " " + student.getGradePointAverage());
                bw.newLine();

                bw2.write(student.getRut() + " " + student.getFullName() + " " + student.getFaculty() + " " +
                    student.getNumberPhone() + " " + student.getEmail() + " " +
                    student.getAddress());
                bw2.newLine();
            }

            bw.close();
            bw2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeAcademicsInTheFile(ArrayList < Academic > academics) {
        try {
            File file = new File("src/database/academics.txt");
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            File file2 = new File("src/database/people.txt");
            FileWriter fw2 = new FileWriter(file2, true);
            BufferedWriter bw2 = new BufferedWriter(fw2);

            for (Academic academic: academics) {
                bw.write(academic.getRut() + " " + academic.getDepartament() + " " + academic.getResearchArea() + " " +
                    academic.getYearsInService());
                bw.newLine();

                bw2.write(academic.getRut() + " " + academic.getFullName() + " " + academic.getFaculty() + " " +
                    academic.getNumberPhone() + " " + " " + academic.getEmail() + " " +
                    academic.getAddress());
                bw2.newLine();
            }

            bw.close();
            bw2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}