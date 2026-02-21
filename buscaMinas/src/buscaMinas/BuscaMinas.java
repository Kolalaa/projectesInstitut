package buscaMinas;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class BuscaMinas {
	static Scanner sc = new Scanner(System.in);
	static int [][] mines = new int [0][0];
	static int [][] camp = new int [0][0];
	static int files = 0;
	static int columnes = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//añadir sc.nextint para las variables, camp logic de mines i camp que es veura.
		crearTablas();
		emplenarTables();
		boolean guanyat = false;
		boolean perdut = false;
		while(!guanyat && !perdut) {
			mostrarTaula();
			perdut = destaparMina();
		}
		
		
	}

	private static boolean destaparMina() {
		// TODO Auto-generated method stub
		System.out.println("Introdueix la coordenadas que quieres destapar:  (0 N)");
		int desFila = sc.nextInt();
		int desColum = sc.nextInt();
		
		if(mines[desFila][desColum] == 1) {
			System.out.println("Has perdut!");
			return true;
		}else {
			destapar();
			return false;
		}
		
	
	}

	private static void destapar() {
		// TODO Auto-generated method stub
		//cuando para? 4
		//cuando encuentra algo que no sea 0
		//mina
		//se sale de la tabla
		
		
		while() {
			
		}
	}

	private static void mostrarTaula() {
		// TODO Auto-generated method stub
		for (int i = 0; i < camp.length; i++) {
			for (int j = 0; j < camp[0].length; j++) {
				System.out.print(camp[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void emplenarTables() {
		// TODO Auto-generated method stub
		//crear arraylist con el numero de minas, hacer un shuffle, y añadir uno a uno a la matriz
		
				
				ArrayList<Integer> lista = new ArrayList<>();
				//añadir minas del 20% de casillas
				int casillasTotales = files * columnes;
				
				double contadorMinas = casillasTotales * 0.2;
				
				for (int i = 0; i < contadorMinas; i++) {
					lista.add(1);
				}
				for (int i = 0; i < casillasTotales - contadorMinas; i++) {
					lista.add(0);
				}
				
				Collections.shuffle(lista);
				int index = 0;
				
				for (int i = 0; i < mines.length; i++) {
					for (int j = 0; j < mines[0].length; j++) {
						mines [i][j] = lista.get(index);
						index++;
					}
				}
	}

	private static void crearTablas() {
		// TODO Auto-generated method stub
		
		System.out.println("Introdueix el numero de files que vols: ");
		files = sc.nextInt();
		System.out.println("Introdueix el numero de columnes que vols: ");
		columnes = sc.nextInt();
		
		mines = new int [files][columnes];
		
		camp = new int [files][columnes];
	}

}
