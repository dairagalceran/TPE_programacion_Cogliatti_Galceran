
public class Arco<T> implements Comparable<Arco<T>>{

	private int verticeOrigen;
	private int verticeDestino;
	private T etiqueta;

	public Arco(int verticeOrigen, int verticeDestino, T etiqueta) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = etiqueta;
	}
	
	/**
	* Complejidad: O(1)	debido a que debe
	* tomar el valor  del arco instanciado.
	*/
	public int getVerticeOrigen() {
		return verticeOrigen;
	}
	
	/**
	* Complejidad: O(1)	debido a que debe
	* tomar el valor del arco instanciado.
	*/
	public int getVerticeDestino() {
		return verticeDestino;
	}
	/**
	* Complejidad: O(1)	debido a que debe
	* tomar el valor del arco instanciado.
	*/
	public T getEtiqueta() {
		return etiqueta;
	}

	

	@Override
	public int compareTo(Arco<T>  o ) {
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
		return  "{ "+ this.getVerticeOrigen() + " , " + this.getVerticeDestino() + " , "+ this.getEtiqueta()+ " }";
	}


}