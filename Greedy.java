import java.util.*;
import java.util.ArrayList;

public class Greedy {

    //Solucion
    ArrayList<Tunel<Integer>> tunelesDistanciaMinima;
    ArrayList<Tunel<Integer>> tuneles;
    int costoTunel;
    int time;
    UnionFind unionFind;

    public Greedy(ArrayList<Tunel<Integer>> tuneles){
        this.tuneles = tuneles;
        this.unionFind = new UnionFind(tuneles.size());
        this.costoTunel = 0;
        this.time = 0;
    }


    public ArrayList<Tunel<Integer>> greedy() {

        // nueva instancia de la colección para no perder la lista original
        ArrayList<Tunel<Integer>> candidatos = new ArrayList<>(tuneles);
        // lista solución
        ArrayList<Tunel<Integer>> tunelesDistanciaMinima = new ArrayList<>();
        // Ordenar los tuneles candidatos por peso en orden ascendente
        Collections.sort(candidatos);

        while (!candidatos.size() == 0 && this.esSolucion(tunelesDistanciaMinima)){
            Tunel<T> tunel = candidatos.get(0);
            candidatos
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
