import java.util.ArrayList;

public class Main {

//	private final static String DATASET1 = "/Users/daira/Documents/PROGRAMACIÓN 3/TPFinal_Programacion3/datasets/dataset1.txt"; // Daira
	private final static String DATASET1 = "/Users/tc/Desktop/TUDAI/2023/Programacion 3/TPE_programacion_Cogliatti_Galceran/datasets/dataset1.txt"; // Tomas
//	private final static String DATASET2 = "/Users/daira/Documents/PROGRAMACIÓN 3/TPFinal_Programacion3/datasets/dataset2.txt"; // Daira
	private final static String DATASET2 = "/Users/tc/Desktop/TUDAI/2023/Programacion 3/TPE_programacion_Cogliatti_Galceran/datasets/dataset2.txt"; // Tomas
//	private final static String DATASET3 = "/Users/daira/Documents/PROGRAMACIÓN 3/TPFinal_Programacion3/datasets/dataset3.txt";  // Daira
	private final static String DATASET3 = "/Users/tc/Desktop/TUDAI/2023/Programacion 3/TPE_programacion_Cogliatti_Galceran/datasets/dataset3.txt"; // Tomas



	public static void main(String[] args) {

		String path = DATASET3;
		CSVReader dataSets = new CSVReader(path);
		dataSets.read();

		//obteber tuneles
		ArrayList<Tunel<Integer>> tuneles = dataSets.getTuneles();
		System.out.println(tuneles);


		// obtener estaciones sin repetir
		ArrayList<Integer> estaciones = dataSets.getEstaciones();
		System.out.println(estaciones);

		Contador.reiniciar();
		//instanciar y calcular con greedy el camino mas corto de túneles
		Timer timer = new Timer();
		timer.start();
	    Greedy busquedaGreedy = new Greedy(tuneles);
		ArrayList<Tunel<Integer>> solucionGreedy = busquedaGreedy.greedy();
		double greedyTime = timer.stop();
		System.out.println("Técnica: Greedy");
	 	System.out.println( "Lista de túneles a construir: "+solucionGreedy);
	 	System.out.println("Cantidad de metros totales dataSet3: "+busquedaGreedy.getCosto()+"km.");
		System.out.println("Costo en tiempo de encontrar la solución : "+ greedyTime);
		System.out.println("Costo en operaciones de encontrar la solución : "+ Contador.getContador());
	}
		
}
