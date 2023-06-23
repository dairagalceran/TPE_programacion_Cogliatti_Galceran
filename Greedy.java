import java.util.*;
import java.util.ArrayList;

public class Greedy {

    //Solucion
    ArrayList<Tunel<Integer>> tunelesDistanciaMinima;
    ArrayList<Tunel<Integer>> tuneles;
    ArrayList<Integer> estaciones;
    int costoTunel;
    int time;
    UnionFind unionFind;

    public Greedy(ArrayList<Tunel<Integer>> tuneles, ArrayList<Integer> estaciones){
        this.tuneles = tuneles;
        this.unionFind = new UnionFind(estaciones.size());
        this.estaciones = estaciones;
        this.costoTunel = 0;
        this.time = 0;
        this.greedy();
    }

    public void greedy() {

        // nueva instancia de la colección para no perder la lista original al eliminar elementos
        ArrayList<Tunel<Integer>> candidatos = new ArrayList<>(tuneles);
        // lista solución
        this.tunelesDistanciaMinima = new ArrayList<>();
        // Ordenar los tuneles candidatos por peso en orden ascendente
        Collections.sort(candidatos);

        while ((candidatos.size() != 0) && (unionFind.numberOfSets() != 1)){

            // obtenemos el primer tunel y lo eliminamos de la lista
            Tunel<Integer> tunel = candidatos.get(0);
            candidatos.remove(0);

            this.time ++;

            int estacionOrigen  = tunel.getVerticeOrigen();
            int estacionDestino = tunel.getVerticeDestino();

            int estacionOrigenIndex  = estaciones.indexOf(estacionOrigen);
            int estacionDestinoIndex = estaciones.indexOf(estacionDestino);

            // verifica que no haya redundancia
            if( unionFind.find(estacionOrigenIndex) != unionFind.find(estacionDestinoIndex)){
                this.tunelesDistanciaMinima.add(tunel);
                unionFind.union(estacionOrigenIndex, estacionDestinoIndex);
                costoTunel += tunel.getEtiqueta();
            }
        }
        if (unionFind.numberOfSets() != 1)
            this.tunelesDistanciaMinima = null;
    }

    public ArrayList<Tunel<Integer>> getSolucion(){
        return new ArrayList<>(this.tunelesDistanciaMinima);
    }
    public int getCosto(){
        return this.costoTunel;
    }
    public int getTime(){
        return this.time;
    }

}
