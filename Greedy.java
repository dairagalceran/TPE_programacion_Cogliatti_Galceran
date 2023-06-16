import java.util.*;
import java.util.ArrayList;

public class Greedy {

    //Solucion
    ArrayList<Arco<Integer>> tunelesDistanciaMinima;
    ArrayList<Arco<Integer>> tuneles;
    int cantidadDeTuneles;
    int costoTunel;
    int contador;

    public Greedy(ArrayList<Arco<Integer>> tuneles, ArrayList<Integer> estacionesSinRepetir){
        this.tuneles = tuneles;
        this.cantidadDeTuneles= tuneles.size();
        this.costoTunel =0;
        this.contador = 0;
    }
    

    public  ArrayList<Arco<Integer>> greedy() {

        ArrayList<Arco<Integer>> tunelesDistanciaMinima = new ArrayList<>();
        // Ordenar los arcos por peso en orden ascendente
        Collections.sort(this.tuneles);

        // Inicializar la estructura de Union-Find
        UnionFind unionFind = new UnionFind(this.cantidadDeTuneles);

        for (Arco<Integer> tunel : this.tuneles) {
            int originRoot = unionFind.find(tunel.getVerticeOrigen());
            int destinationRoot = unionFind.find(tunel.getVerticeDestino());
            contador++;


            if (originRoot != destinationRoot) {
                tunelesDistanciaMinima.add(tunel);
                contador++;
                unionFind.union(originRoot, destinationRoot);
                contador++;
                costoTunel += tunel.getEtiqueta();
            }
        }

        return tunelesDistanciaMinima ;
    }

    public int getCosto(){     
        return this.costoTunel;
    }

    public int getContador(){       
        return this.contador;
    }







    
}
