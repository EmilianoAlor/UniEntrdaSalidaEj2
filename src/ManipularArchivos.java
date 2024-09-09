import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class ManipularArchivos {

	private String rutaArchivo = "Archivos/Archivoaleatorio.txt";
	private String rutaGuardar = "Archivos/Resultado.txt";

	/**
	 * 1. Escribir un archivo de entre 10 mil y 20 mil números enteros aleatorios,
	 * en el rango de 0 a 12000. (La cantidad de números debe ser aleatoria)
	 */
	public void guardarArchivoAleatorio() {

		FileWriter file = null;
		PrintWriter printerWriter = null;

		try {
			file = new FileWriter(rutaArchivo); // Destruye el archivo si existe.

			printerWriter = new PrintWriter(file);

			// Generador de datos random.
			Random random = new Random();

			int cantidadLineas = (random.nextInt(10) + 10) * 1000;

			System.out.println("Cantidad de lineas :" + cantidadLineas);

			for (int i = 0; i < cantidadLineas; i++) {
				printerWriter.println(random.nextInt(12000));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 2. Leer dicho archivo, buscando (a) máximo, (b) mínimo, (c) promedio.
	 * 
	 * @param valores
	 */

	public void leerArchivoAleatorio(Valores valores) {
		Scanner scanner = null;

		try {
			File file = new File(rutaArchivo);

			if (file.exists()) {
				scanner = new Scanner(file);
				// Especifica la configuración regional que se va a utilizar
				scanner.useLocale(Locale.ENGLISH);
				// Para la configuración regional de Argentina, utilizar:
				// arch.useLocale(new Locale("es_AR"));

				while (scanner.hasNextInt()) {
					int valor = scanner.nextInt();

					valores.setAgregar(valor);
				}

			} else
				System.out.println("No se encontrol el archivo:" + this.rutaArchivo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Cerrar el archivo, eso es mucho muy importante
			if (scanner != null)
				scanner.close();
		}
	}

	/**
	 * 3. Escribr un segundo archivo con una tabla de resultados. Ejemplo:
			+----------+-------+
			| Máximo   | 11978 |
			+----------+-------+
			| Mínimo   |     3 |
			+----------+-------+
			| Promedio |  7201 |
			+----------+-------+

	 * @param guardar
	 */
	
	public void guardarResultado(Valores guardar) {

		FileWriter file = null;
		PrintWriter printerWriter = null;

		try {
			file = new FileWriter(rutaGuardar); // Destruye el archivo si existe.

			printerWriter = new PrintWriter(file);

			// Generador de datos random.
			Random random = new Random();

			printerWriter.println("+----------+-------+");
			printerWriter.println("| Máximo   | " + String.format("%05d", guardar.getMaximo()) + " |");
			printerWriter.println("+----------+-------+");
			printerWriter.println("| Minimo   | " + String.format("%5d", guardar.getMinimo()) + " |");
			printerWriter.println("+----------+-------+");
			printerWriter.println("| Promedio | " + String.format("%5d", guardar.getPromedio()) + " |");
			printerWriter.println("+----------+-------+");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
