import java.util.*;
import java.util.ArrayList;

public class Greedy {

    //Solucion
    ArrayList<Tunel<Integer>> tunelesDistanciaMinima;
    ArrayList<Tunel<Integer>> tuneles;
    int costoTunel;
    UnionFind unionFind;

    public Greedy(ArrayList<Tunel<Integer>> tuneles){
        this.tuneles = tuneles;    
        this.unionFind = new UnionFind(tuneles.size());
        this.costoTunel = 0;
    }
    

    public  ArrayList<Tunel<Integer>> greedy() {

        ArrayList<Tunel<Integer>> tunelesDistanciaMinima = new ArrayList<>();
        // Ordenar los tuneles por peso en orden ascendente
        Collections.sort(this.tuneles);

        for (Tunel<Integer> tunel : this.tuneles) {
            int originRoot = unionFind.find(tunel.getVerticeOrigen());
            int destinationRoot = unionFind.find(tunel.getVerticeDestino());
            if (originRoot != destinationRoot) {
                tunelesDistanciaMinima.add(tunel);
                Contador.sumar();
                unionFind.union(originRoot, destinationRoot);
                costoTunel += tunel.getEtiqueta();
                Contador.sumar();
            }
        }

        return tunelesDistanciaMinima ;
    }

    public int getCosto(){     
        return this.costoTunel;
    }

}
