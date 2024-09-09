
public class Principal {

	public static void main(String[] args) {
		
		ManipularArchivos ma = new ManipularArchivos();
		
		Valores valores = new Valores();
		
		ma.guardarArchivoAleatorio();
		
		ma.leerArchivoAleatorio(valores);
		
		ma.guardarResultado(valores);
		
		System.out.println("+----------+-------+");
		System.out.println("| Máximo   | "+ String.format("%05d", valores.getMaximo()) + " |");
		System.out.println("+----------+-------+");
		System.out.println("| Minimo   | "+ String.format("%5d", valores.getMinimo()) + " |");
		System.out.println("+----------+-------+");
		System.out.println("| Promedio | "+ String.format("%5d", valores.getPromedio()) + " |");
		System.out.println("+----------+-------+");
		
	}

}
