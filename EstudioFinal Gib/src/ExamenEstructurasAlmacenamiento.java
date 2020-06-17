

import java.net.IDN;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author 6161
 * Programa creado para el examen pr�ctico de "estructuras de almacenamiento"
 */

/**
 * Clase que contiene el m�todo main.
 * Esta clase solicitar� al usuario los alumnos y las notas.
 * Con los datos recogidos, realizar� una serie de operaciones
 * apoy�ndose en otra clase est�tica del mismo archivo.
 * @author 6161
 *
 */
public class ExamenEstructurasAlmacenamiento {
	
	/**
	 * M�todo main de ExamenEstructurasAlmacenamiento
	 * Solicita varios datos al usuario y hace uso de la clase HerramientasApoyo
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Bienvenido al programa Colegio 1.0.");
			System.out.println("Introduce, por favor, una cadena de texto con todos los nombres de los alumnos, por ejemplo: Luis Antonio Mar�a Luisa Bel�n Ana Cristina Juana Jos�");
			
			String nombres = sc.nextLine();
			
			nombres = nombres.trim(); //Se elimnan los blancos de inicio/final y se guarda en la variable nombres
			
			nombres = nombres.toUpperCase(); //Se pone todo el texto en may�sculas y se guarda en la variable nombres.
			
			System.out.println("-------------------------------------------");
			
			if(nombres.indexOf('Z') < 0) { //No se ha encontrado
				System.out.println("La letra Z no se encuentra dentro de los nombres introducidos");
			}
			else {
				System.out.println("La primera letra Z se encuentra en la posici�n "+nombres.indexOf('Z'));
			}
			
			System.out.println("-------------------------------------------");
			
			String arrayNombres[] = nombres.split(" "); //Se divide la cadena en un array cortando los elementos con un espacio
			
			Arrays.sort(arrayNombres); //Se ordena la lista de nombres
			
			//Recogemos las notas en un array. Creamos el array con la misma longitud que el array de nombres
			double arrayNotas[] = new double[arrayNombres.length];
			
			System.out.println("Por favor, introduce las notas de las siguientes personas: ");
			for(int i = 0; i < arrayNombres.length; i++) {
				System.out.println("Nota para "+arrayNombres[i]);
				arrayNotas[i] = sc.nextDouble(); //Se recoge la nota y se almacena en la posici�n correspondiente del array de notas
			}
			System.out.println("Gracias por introducir todas las notas de los alumnos");
			
			System.out.println("-------------------------------------------");
			
			System.out.println("La nota media de los alumnos es "+HerramientasApoyo.calcularMedia(arrayNotas));
			
			System.out.println("-------------------------------------------");
			
			HerramientasApoyo.calcularNotaMax(arrayNotas, arrayNombres);
			
			System.out.println("-------------------------------------------");
			
			String notaMin = HerramientasApoyo.calcularNotaMin(arrayNotas, arrayNombres);
			
			StringBuffer sb = new StringBuffer(notaMin); //Se crea un objeto StringBuffer con la cadena de texto devuelta por el c�lculo de la nota m�nima
			
			sb.reverse(); //Se invierte la cadena. No hace falta guardar el dato como se hace con String porque es un StringBuffer
			sb.append(". Mensaje cifrado para cumplir la protecci�n de datos."); //Se concatena el texto invertido con el texto facilitado
			
			StringTokenizer st = new StringTokenizer(sb.toString()," ,."); //Creamos un StringTokenizer pasando a cadena el objeto StringBuffer
			
			System.out.println("La cadena que contiene la nota m�nima cifrada y dividada en tokens es: ");
			
			HerramientasApoyo.imprimirCadenaCifrada(st); //Llamamos al m�todo para imprimir la cadena
						
			sc.close();
			
		} catch (Exception e) {
			System.out.println("Ha ocurrido un problema");
			e.printStackTrace();
		}
	}

}

/**
 * Clase con m�todos est�ticos para calcular ciertos datos solicitados en el programa
 * @author 6161
 *
 */
class HerramientasApoyo{
	
	/**
	 * El m�todo calcular� la media de las notas facilitadas
	 * @param array
	 * @return
	 */
	static double calcularMedia(double array[]) {
		
		double media = 0;
		
		for(int i = 0; i < array.length; i++) {
			media = media + array[i];
		}
		
		media = media/array.length; //Se divide la suma de todas las notas por el n�mero de notas que hay
		
		return media;
	}
	
	/**
	 * El m�todo comprobar� qu� nota es la m�s alta (array de doubles) en indicar� qu� persona es la que tiene la nota m�s alta
	 * @param notas
	 * @param nombres
	 */
	static void calcularNotaMax(double notas[], String nombres[]) {
		
		double notaMax = 0;
		int indiceDeNotaMax = 0;
		
		for(int i = 0; i < notas.length; i++) {
			if(notaMax < notas[i]) { //La nota que estamos comprobando es mayor que la que tenemos registrada
				notaMax = notas[i];
				indiceDeNotaMax = i; //Almacenamos la posici�n en la que hemos encontrado la nota m�xima
			}
		}
		
		//Una vez que se han comprobado todos los par�metros. Imprimimos el resultado
		System.out.println("La persona que tiene la mayor nota es "+nombres[indiceDeNotaMax]+" con un valor de "+notaMax);
	}
	
	
	/**
	 *  El m�todo comprobar� qu� nota es la m�s baja (array de doubles) en indicar� qu� persona es 
	 *  la que tiene la nota m�s baja. El programa devolver� un String con los siguientes datos: 
	 *  "El alumno xxxx ha sacado yyy, necesita dedicar m�s tiempo al estudio".
	 * @param notas
	 * @param nombres
	 * @return
	 */
	static String calcularNotaMin(double notas[], String nombres[]) {
		
		double notaMin = notas[0]; //Se elige el primer valor
		int indiceDeNotaMin = 0;
		
		for(int i = 0; i < notas.length; i++) {
			if(notaMin > notas[i]) { //La nota que estamos comprobando es menor que la que tenemos registrada
				notaMin = notas[i];
				indiceDeNotaMin = i; //Almacenamos la posici�n en la que hemos encontrado la nota m�nima
			}
		}
		
		return "El alumno "+nombres[indiceDeNotaMin]+" ha sacado "+notas[indiceDeNotaMin]+", necesita dedicar m�s tiempo al estudio";
	}
	
	
	/**
	 * El m�todo recorrer� los elementos del objeto y los ir� imprimiendo por pantalla.
	 * @param elementos
	 */
	static void imprimirCadenaCifrada(StringTokenizer elementos) {
		
		while(elementos.hasMoreTokens()) {
			System.out.println(elementos.nextToken());			
		}
	}
	
}