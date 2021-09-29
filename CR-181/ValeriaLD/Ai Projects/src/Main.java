import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        double[][] forme_de_intrare = new double[][]{{3.14, -1.2}, {2.04, -0.5}};
        double[] ponderi = new double[]{0.1, -1.2, 2.4, -0, 5}; // random intervalul [-1; 1]
        double[] forme_de_iesire = new double[]{0.8, 0.4}; // care e clasa corecta, care e corecta si o stiu
        double ajustare = 0;
        double n = 0.05; // rata de invatare


        double suma, y, eroare_medie, y1; // y e ceea ce iese la iesire
        double[] eroare = new double[3];
        int x = 0;

        System.out.println("Exemple: " + Arrays.deepToString(forme_de_intrare));

        DecimalFormat df2 = new DecimalFormat("#.##");
        Random random = new Random();
        double min = -1, max = 1;
        for (int i = 0; i < ponderi.length; i++) {
            double randomValue = min + (max - min) * random.nextDouble();
            ponderi[i] = Double.parseDouble(df2.format(randomValue));
        }

        System.out.println("Ponderi: " + Arrays.toString(ponderi));
        System.out.println("Forme de iesire: " + Arrays.toString(forme_de_iesire) + "\n");

        while (x < 1000) {
            for (int i = 0; i < forme_de_intrare.length; i++) {
                suma = forme_de_intrare[i][0] * ponderi[0] + forme_de_intrare[i][1] * ponderi[1]; //ramine neschimbata
                y = sigmoidActivation(suma); // functia de activare functia sigmoidala sau functia de prag daca < 0, atunci clasa 0, daca e mai mare ca 0 atunci clasa 1
                eroare[i] = forme_de_iesire[i] - y;
                System.out.println("Suma " + (i + 1) + " : " + suma);
                System.out.println("Y" + (i + 1) + ": " + y);
                System.out.println("Eroarea " + (i + 1) + " " + eroare[i] + "\n");

                eroare_medie = Math.pow((eroare[i]), 2) / 2;
                System.out.println("Eroare medie: " + eroare_medie);

                ajustare = -(eroare_medie) * sigmoidDerivate(y) * n ;

                ponderi[0] = ponderi[0] + ajustare * forme_de_intrare[i][0];
                System.out.println("Ponderea 1: " + ponderi[0]);
                ponderi[1] = ponderi[1] + ajustare * forme_de_intrare[i][1];
                System.out.println("Ponderea 2: " + ponderi[1]);
//                ponderi[i] = ponderi[i] + ajustare * forme_de_intrare[i];
//                System.out.println("Ponderea " + (i + 1) + " : " + ponderi[i]);
            }
            x++;
        }
    }
    public static double sigmoidDerivate(double sigmoid) {
        return sigmoid * (1 - sigmoid);
    }

    public static double sigmoidActivation(double suma) {
        return 1 / (1 + Math.exp(-suma));
    }
}