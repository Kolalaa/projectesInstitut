package EnfonsarFlota;
import java.util.Scanner;
import java.util.Random;

public class enfonsarFlota {

    static int MIDA = 10;
    static int SUBMARINS = 8;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int[][] taulerMaquina = new int[MIDA][MIDA]; // On estan els submarins
        int[][] taulerJugador = new int[MIDA][MIDA]; // El que veu el jugador

        colocarSubmarins(taulerMaquina, rand);

        int enfonsats = 0;
        int torns = 0;

        while (enfonsats < SUBMARINS) {

            mostrarTauler(taulerJugador);

            System.out.print("Introdueix coordenada (ex: 1,a): ");
            String entrada = sc.nextLine();

            int fila = obtenirFila(entrada);
            int col = obtenirColumna(entrada);

            if (fila == -1 || col == -1) {
                System.out.println("Format incorrecte.");
                continue;
            }

            if (taulerJugador[fila][col] != 0) {
                System.out.println("Ja has tirat aquí.");
                continue;
            }

            torns++;

            if (taulerMaquina[fila][col] == 1) {
                System.out.println("ENFONSAT!");
                taulerJugador[fila][col] = 2;
                taulerMaquina[fila][col] = -1;
                enfonsats++;
            } else {
                System.out.println("AIGUA!");
                taulerJugador[fila][col] = 1;
            }
        }

        System.out.println("Has guanyat en " + torns + " torns!");
    }
    // Col·locar submarins aleatoris
    static void colocarSubmarins(int[][] tauler, Random rand) {

        int posats = 0;

        while (posats < SUBMARINS) {

            int f = rand.nextInt(MIDA);
            int c = rand.nextInt(MIDA);

            if (potColocar(tauler, f, c)) {
                tauler[f][c] = 1;
                posats++;
            }
        }
    }


    // Comprova si pot col·locar
    static boolean potColocar(int[][] tauler, int f, int c) {

        for (int i = f - 1; i <= f + 1; i++) {
            for (int j = c - 1; j <= c + 1; j++) {

                if (i >= 0 && i < MIDA && j >= 0 && j < MIDA) {
                    if (tauler[i][j] == 1) return false;
                }
            }
        }

        return true;
    }

    // Mostrar tauler jugador
    // 0 = desconegut
    // 1 = aigua
    // 2 = enfonsat

    static void mostrarTauler(int[][] tauler) {

        System.out.print("  ");
        for (char l = 'a'; l <= 'j'; l++) {
            System.out.print(l + " ");
        }
        System.out.println();

        for (int i = 0; i < MIDA; i++) {
            System.out.print((i + 1) + " ");

            for (int j = 0; j < MIDA; j++) {
                System.out.print(tauler[i][j] + " ");
            }

            System.out.println();
        }
    }

    static int obtenirFila(String entrada) {
        try {
            String[] parts = entrada.split(",");
            return Integer.parseInt(parts[0]) - 1;
        } catch (Exception e) {
            return -1;
        }
    }

    static int obtenirColumna(String entrada) {
        try {
            String[] parts = entrada.split(",");
            char lletra = parts[1].toLowerCase().charAt(0);
            return lletra - 'a';
        } catch (Exception e) {
            return -1;
        }
    }
}
