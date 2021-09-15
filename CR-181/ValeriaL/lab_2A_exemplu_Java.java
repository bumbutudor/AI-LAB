import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[][] exemple = new double[][] {{8, 5, 6}, {7, 2, 9}, {3, 0, 1}};
        double[] ponderi = new double[] {0.28, -8.65, 3.5};
        double[] forme_de_iesire = new double[] {10, 10, 4};

        double suma, y, eroare_medie;
        double[] eroare = new double[3];

        System.out.println("Exemple: " + Arrays.deepToString(exemple));
        System.out.println("Ponderi: " + Arrays.toString(ponderi));
        System.out.println("Forme de iesire: " + Arrays.toString(forme_de_iesire) + "\n");

        for (int i = 0; i < exemple.length; i++) {
            suma = exemple[i][0] * ponderi[0] + exemple[i][1] * ponderi[1] + exemple[i][2] * ponderi[2];
            y = 1 / (1 + Math.exp(-suma));
            eroare[i] = forme_de_iesire[i] - y;

            System.out.println("Suma 1: " + suma);
            System.out.println("Y1: " + y);
            System.out.println("Eroare 1: " + eroare[i] + "\n");
        }

        eroare_medie = Math.pow((eroare[0] + eroare[1] + eroare[2]), 2) / 2;
        System.out.println("Eroare medie: " + eroare_medie);
            
    }
}
