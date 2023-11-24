package classes;

public class OptionsPerson {
    public char[] menu;
    public Boolean rut;
    public Boolean fullName;
    public Boolean faculty;
    public Boolean numberPhone;
    public Boolean email;
    public Boolean address;

    public OptionsPerson() {
        rut = false;
        fullName = false;
        faculty = false;
        numberPhone = false;
        email = false;
        address = false;
        menu = ("*--------------------------------------*\n" +
                "|     Filtro/s a buscar    | Selección |\n" +
                "|--------------------------|-----------|\n" +
                "| > Rut                    |    [ ]    |\n" + // Posicion: 125 [>] - 156 [ ]
                "|   Nombre completo        |    [ ]    |\n" + // Posicion: 166 [>] - 197 [ ]
                "|   Facultad               |    [ ]    |\n" + // Posicion: 207 [>] - 238 [ ]
                "|   Número de teléfono     |    [ ]    |\n" + // Posicion: 248 [>] - 279 [ ]
                "|   Correo electrónico     |    [ ]    |\n" + // Posicion: 289 [>] - 320 [ ]
                "|   Dirección              |    [ ]    |\n" + // Posicion: 330 [>] - 361 [ ]
                "|--------------------------------------|\n" +
                "|               Continuar              |\n" + // Posicion: 425 [>]
                "*--------------------------------------*\n" +
            "> ").toCharArray();
    }
    public int up(int currentPosition) {
        menu[currentPosition] = ' ';
        if (currentPosition == 424) {
            menu[330] = '>';
            return 330;
        } else {
            menu[currentPosition - 41] = '>';
            return currentPosition - 41;
        }
    }
    public int down(int currentPosition) {
        menu[currentPosition] = ' ';
        if (currentPosition == 330) {
            menu[424] = '>';
            return 424;
        } else {
            menu[currentPosition + 41] = '>';
            return currentPosition + 41;
        }
    }
    public void check(int currentPosition) {
        char status = ' ';
        if (menu[currentPosition + 31] == ' ')
            status = 'X';

        menu[currentPosition + 31] = status;

        if (currentPosition == 156)
            rut = (status == 'X');
        else if (currentPosition == 197)
            fullName = (status == 'X');
        else if (currentPosition == 238)
            faculty = (status == 'X');
        else if (currentPosition == 279)
            numberPhone = (status == 'X');
        else if (currentPosition == 320)
            email = (status == 'X');
        else if (currentPosition == 361)
            address = (status == 'X');
    }
}