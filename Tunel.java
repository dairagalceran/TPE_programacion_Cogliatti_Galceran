
public class Tunel<T> implements Comparable<Tunel<T>>{

	private int verticeOrigen;
	private int verticeDestino;
	private T etiqueta;

	public Tunel(int verticeOrigen, int verticeDestino, T etiqueta) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = etiqueta;
	}
	
	/**
	* Complejidad: O(1)	debido a que debe
	* tomar el valor  del tunel instanciado.
	*/
	public int getVerticeOrigen() {
		return verticeOrigen;
	}
	
	/**
	* Complejidad: O(1)	debido a que debe
	* tomar el valor del tunel instanciado.
	*/
	public int getVerticeDestino() {
		return verticeDestino;
	}
	/**
	* Complejidad: O(1)	debido a que debe
	* tomar el valor del tunel instanciado.
	*/
	public T getEtiqueta() {
		return etiqueta;
	}

	

	@Override
	public int compareTo(Tunel<T>  o ) {
		if ((int) this.getEtiqueta() > (int) o.getEtiqueta()) {
			return 1;
		}else if ((int )this.getEtiqueta() < (int)o.getEtiqueta()){
			return -1;
		}else {
			return 0;
		}
	}
	
    @Override
	public String toString(){
		return  "{E"+ this.getVerticeOrigen() + " - E" + this.getVerticeDestino()+"} ";
	}


}