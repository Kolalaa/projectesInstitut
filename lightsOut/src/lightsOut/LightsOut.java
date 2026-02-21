package lightsOut;
import java.util.Scanner;
import java.util.Random;

public class LightsOut {
	static Scanner sc = new Scanner(System.in);
	static String nomJugador = "Nom Jugador";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean sortir = false;
		int [][] taulell = new int [0][0];
		
		while(!sortir)
		{
			//menu
			System.out.println("Menu");
			System.out.println("1.Jugar");
            System.out.println("2.Configuració");
            System.out.println("3.Sortir");			
			
			int opcio = sc.nextInt();
			
			switch (opcio) {
			case 1: {
				jugar(taulell,nomJugador);
				break;
			}
			case 2:{
				//configurar
				taulell = configuracio(taulell);
				break;
			}
			case 3:{
				//sortir del jocç
				sortir = true;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcio);
			}
		}
		
	}



	private static int [][] configuracio(int[][] taulell) {
		// TODO Auto-generated method stub
		boolean sortir = false;
		
		while(!sortir) {
			System.out.println("Que vol fer? :");
			System.out.println("1.Modificar Nom Jugador");
			System.out.println("2.Definir tamany de la Taula");
			System.out.println("3.Sortir de la configuració");
			
			int opcio = sc.nextInt();
			switch (opcio) {
			case 1: {
				System.out.println("Introdueix el nom del jugador: ");
				sc.nextLine();
				nomJugador = sc.nextLine();
				break;
			}
			case 2:{
				//preguntar per files i columnes
				taulell = definirTamanyTaula(taulell);
				//comprovar si es cuadrat, si ho es, seguir.
				break;
			}
			case 3:{
				//sortir del menu de configuracio
				sortir = true;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcio);
			}
		}
		return taulell;
	}



	private static int [][] definirTamanyTaula(int [][] taulell) {
		// TODO Auto-generated method stub
		System.out.println("Introdueix el tamany de les files: ");
		int f = sc.nextInt();
		System.out.println("Introdueix el tamany de les columnes: ");
		int c = sc.nextInt();
		taulell = new int [f][c] ;
		
		System.out.println("Tamany de les files: " + f);
		System.out.println("Tamany de les columnes: " + c);
		
		return taulell;
	}



	private static void jugar(int[][] taulell, String nomJugador) {
		boolean fi = false;
		int nMoviments=0;
		
		InicialitzarTaulell(taulell);
		while(!fi) {
			mostrarTaulell(taulell);
			System.out.println("Hola");
			//Posicio p = seleccionarPosicio();
			//canviarLlums(p,taulell);
			fi = comprovarVictoria(taulell);
			nMoviments++;
		}
	}



	private static boolean comprovarVictoria(int[][] taulell) {
		// TODO Auto-generated method 

		
		return false;
	}
	private static void mostrarTaulell(int[][] taulell) {
		// TODO Auto-generated method stub
		for (int i = 0; i < taulell.length; i++) {
            for (int j = 0; j < taulell[0].length; j++) {
                System.out.print(taulell[i][j] + " ");
            }
            System.out.println();
        }
	}



	private static void InicialitzarTaulell(int[][] taulell) {
		// TODO Auto-generated method stub
		//afegir rand, per a omplir la taula entre 0 i 1.
		Random numRandom = new Random();
		
		for (int i = 0; i < taulell.length; i++) {
            for (int j = 0; j < taulell[0].length; j++) {
               taulell[i][j] = numRandom.nextInt(2);
            }
        }	
	}
	

}
