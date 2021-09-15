import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        double[][] exemple = new double[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        double[] ponderi = new double[3]; // random intervalul [-1; 1]
        double[] forme_de_iesire = new double[] {0, 1, 0}; // care e clasa corecta, care e corecta si o stiu

        double suma, y, eroare_medie, y1; // y e ceea ce iese la iesire
        double[] eroare = new double[3];

        System.out.println("Exemple: " + Arrays.deepToString(exemple));

        DecimalFormat df2 = new DecimalFormat("#.##");
        Random random = new Random();
        double min = -1, max = 1;
        for (int i = 0; i < ponderi.length; i++) {
            double randomValue = min + (max - min) * random.nextDouble();
            ponderi[i] = Double.parseDouble(df2.format(randomValue));
        }

        System.out.println("Ponderi: " + Arrays.toString(ponderi));
        System.out.println("Forme de iesire: " + Arrays.toString(forme_de_iesire) + "\n");



        for (int i = 0; i < exemple.length; i++) {
            suma = exemple[i][0] * ponderi[0] + exemple[i][1] * ponderi[1] + exemple[i][2] * ponderi[2]; //ramine neschimbata
            y = 1 / (1 + Math.exp(-suma)); // functia de activare functia sigmoidala sau functia de prag daca < 0, atunci clasa 0, daca e mai mare ca 0 atunci clasa 1
            eroare[i] = forme_de_iesire[i] - y;

            System.out.println("Suma 1: " + suma);
            System.out.println("Y1: " + y);
            System.out.println("Eroare 1: " + eroare[i] + "\n");
        }

        eroare_medie = Math.pow((eroare[0] + eroare[1] + eroare[2]), 2) / 2;
        System.out.println("Eroare medie: " + eroare_medie);

    }
}
