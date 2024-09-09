
public class Valores {
	private int maximo = 0;
	private int minimo = 999999;
	private int suma = 0;
	private int cantidad = 0;

	public int getMaximo() {
		return maximo;
	}

	public int getMinimo() {
		return minimo;
	}

	public int getSuma() {
		return suma;
	}

	public int getPromedio() {
		return suma / cantidad;
	}

	public void setAgregar(int valor) {
		this.suma = this.suma + valor;
		this.cantidad++;

		if (this.minimo > valor)
			this.minimo = valor;

		if (this.maximo < valor)
			this.maximo = valor;

	}

	public int getCantidad() {
		return cantidad;
	}

}
