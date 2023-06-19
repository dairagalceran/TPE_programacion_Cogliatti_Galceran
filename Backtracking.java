import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class Backtracking {

    int distanciaMinima;
    ArrayList<Tunel<Integer>> tunelesDistanciaMinima;
    
    ArrayList<Tunel<Integer>> tuneles;
    ArrayList<Integer> estaciones;

    public Backtracking(ArrayList<Tunel<Integer>> tuneles, ArrayList<Integer> estaciones){
        //Datos entrada
        this.tuneles = tuneles;    
        this.estaciones = new ArrayList<>(estaciones);
        Collections.sort(this.estaciones);

        //Soluciones
        this.tunelesDistanciaMinima = tuneles;
        this.distanciaMinima = this.getCosto(tuneles);
    }

    public ArrayList<Tunel<Integer>> execute() {
        doBacktracking(0, new ArrayList<>());
        return tunelesDistanciaMinima;
    }

    private void doBacktracking(int indiceTunelActual, ArrayList<Tunel<Integer>> solucionTemporal){
        Contador.sumar();
        if(indiceTunelActual == this.tuneles.size() || solucionTemporal.size() == this.estaciones.size() -1 ){
            if(this.esSolucion(solucionTemporal)){
                Integer costo = this.getCosto(solucionTemporal);
                if(costo < this.distanciaMinima){
                    this.tunelesDistanciaMinima = new ArrayList<>(solucionTemporal);
                    this.distanciaMinima = costo;
                }
            }
        } else {
            Tunel<Integer> tunelActual = this.tuneles.get(indiceTunelActual);
            solucionTemporal.add(tunelActual);
            Contador.sumar();
            doBacktracking(indiceTunelActual+1, solucionTemporal);
            solucionTemporal.remove(tunelActual);
            Contador.sumar();      
            doBacktracking(indiceTunelActual+1, solucionTemporal);           
        }       
    }


    private boolean esSolucion(ArrayList<Tunel<Integer>> solucionTemporal){
        Contador.sumar();
        if(solucionTemporal.size() == this.estaciones.size() -1){
            UnionFind unionFind = new UnionFind(tuneles.size());
            for(Tunel<Integer> tunel : solucionTemporal){
                unionFind.union(tunel.getVerticeOrigen(), tunel.getVerticeDestino());
            }
            Integer origenPrimerEstacion = unionFind.find(this.estaciones.get(0));
            for(Integer estacion : this.estaciones){
                Integer origenEstacion = unionFind.find(estacion);
                if(origenEstacion != origenPrimerEstacion){
                    return false;
                }
            }
            return true;
        }
        return false;
    } 

    private Integer getCosto(ArrayList<Tunel<Integer>> solucionTemporal){
        Integer contador= 0;
        Iterator<Tunel<Integer>> iterator = solucionTemporal.iterator();
            while(iterator.hasNext()){
                Tunel<Integer> tunel = iterator.next();
                contador+= tunel.getEtiqueta();
                Contador.sumar();
            }
        return contador;
    }

    public Integer getCosto(){
        return this.getCosto(this.tunelesDistanciaMinima);
    }
    
}