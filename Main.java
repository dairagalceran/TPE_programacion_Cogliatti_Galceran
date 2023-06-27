import java.util.ArrayList;

public class Main {

//	private final static String DATASET = "/Users/daira/Documents/PROGRAMACIÓN 3/TPFinal_Programacion3/datasets/dataset2.txt"; // Daira
	private final static String DATASET = "/Users/tc/Desktop/TUDAI/2023/Programacion 3/TPE_programacion_Cogliatti_Galceran/datasets/"; // Tomas

	public static void main(String[] args) {

		String numberSet = "dataset3." +
				"";
		String path = DATASET+numberSet+".txt";

		CSVReader dataSets = new CSVReader(path);
		dataSets.read();

		//obteber tuneles
		ArrayList<Tunel<Integer>> tuneles = dataSets.getTuneles();
		System.out.println(tuneles);

		// obtener estaciones sin repetir
		ArrayList<Integer> estaciones = dataSets.getEstaciones();
		System.out.println(estaciones);

		// instanciar y calcular con greedy el camino mas corto de túneles

	    Greedy busquedaGreedy = new Greedy(tuneles, estaciones);
		ArrayList<Tunel<Integer>> solucionGreedy = busquedaGreedy.getSolucion();

		System.out.println("Técnica: Greedy");
	 	System.out.println("Lista de túneles a construir: "+solucionGreedy);
	 	System.out.println("Cantidad de metros totales "+numberSet+": "+busquedaGreedy.getCosto()+"km.");
		System.out.println("Costo operacional: "+ busquedaGreedy.getTime());

		//instanciar y calcular con backtracking el camino mas corto de túneles
		Backtracking busquedaBack = new Backtracking(tuneles, estaciones);
		ArrayList<Tunel<Integer>> solucionBack = busquedaBack.getSolucion();

		System.out.println("Técnica: Backtracking");
		System.out.println("Lista de túneles a construir: "+solucionBack);
		System.out.println("Cantidad de metros totales "+numberSet+": "+busquedaBack.getCosto()+"km.");
		System.out.println("Costo operacional: "+ busquedaBack.getTime());
	}
}
