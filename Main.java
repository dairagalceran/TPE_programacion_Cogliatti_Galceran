import java.util.ArrayList;

public class Main {

	private final static String DATASET1 = "/Users/daira/Documents/PROGRAMACIÓN 3/TPFinal_Programacion3/datasets/dataset1.txt";
	private final static String DATASET2 = "/Users/daira/Documents/PROGRAMACIÓN 3/TPFinal_Programacion3/datasets/dataset2.txt";
	private final static String DATASET3 = "/Users/daira/Documents/PROGRAMACIÓN 3/TPFinal_Programacion3/datasets/dataset3.txt";



	public static void main(String[] args) {

		String path = DATASET3;
		CSVReader dataSets = new CSVReader(path);
		dataSets.read();
		ArrayList<Arco<Integer>> tuneles = dataSets.getTuneles();
		System.out.println(tuneles);


		// obtener estaciones sin repetir
		ArrayList<Integer> estaciones = dataSets.getEstaciones();
		System.out.println(estaciones);

	 Greedy busquedaGreedy = new Greedy(tuneles, estaciones);
	 System.out.println( "main greedy()"+busquedaGreedy.greedy());
	 System.out.println("Costo tunel dataSet3: "+busquedaGreedy.getCosto());
	}
		

}
