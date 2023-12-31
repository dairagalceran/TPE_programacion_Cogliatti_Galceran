import java.util.ArrayList;

class Backtracking {

    //Solucion
    ArrayList<Tunel<Integer>> tunelesDistanciaMinima;
    ArrayList<Tunel<Integer>> tuneles;
    ArrayList<Integer> estaciones;
    Integer costoMinimo;
    UnionFind unionFind;
    int time;

    public Backtracking(ArrayList<Tunel<Integer>> tuneles, ArrayList<Integer> estaciones) {
        this.tuneles = tuneles;
        this.estaciones = estaciones;
        this.unionFind = new UnionFind(estaciones.size());
        this.costoMinimo = 0;
        this.time = 0;
        this.tunelesDistanciaMinima = new ArrayList<>();
        this.back(new ArrayList<Tunel<Integer>>(), null);
    }

    public void back(ArrayList<Tunel<Integer>> caminoParcial, Integer index){

        this.time++;

        /*
        *   CONDICION DE CORTE
        *       1. Si la cantidad de tubos es = a la cantaidad de estaciones - 1
        *       2. Si el index se encuentra en el final del array de tuneles
        */
        if (caminoParcial.size() == estaciones.size()-1 || (index != null && index == this.tuneles.size()-1)){
            Integer costoCaminoParcial = this.calcDistancia(caminoParcial);
            // verifica que el conjunto de tuneles cumpla con la condición de que el conjunto no sea disjunto
            if (unionFind.numberOfSets() == 1){
                // verifica que la solucion actual mejore a la mejor solucion encotrada hasta ahora
                if(this.tunelesDistanciaMinima.size() == 0 ||  costoCaminoParcial < this.costoMinimo){
                    this.costoMinimo = costoCaminoParcial;
                    this.tunelesDistanciaMinima = new ArrayList<>(caminoParcial);
                }
            }
        }else{

            // muevo el indice
            if(index == null)
                index = 0;
            else
                index ++;

            // obtengo el sigiente tunel
            Tunel<Integer> tunel = tuneles.get(index);

            // obtiene las estaciones de origen y destino
            int estacionOrigen  = tunel.getVerticeOrigen();
            int estacionDestino = tunel.getVerticeDestino();

            // obtiene los indices de las estaciones en el arreglo
            int estacionOrigenIndex  = estaciones.indexOf(estacionOrigen);
            int estacionDestinoIndex = estaciones.indexOf(estacionDestino);

            // PODA #1:
            // si el tunel actual no es redundante prosigue
            if( unionFind.find(estacionOrigenIndex) != unionFind.find(estacionDestinoIndex) &&
            // PODA #2:
            // si el km del camino parcial mas el nuevo arco excede el la mejor solucion acual
            ( this.costoMinimo == 0 || this.costoMinimo > this.calcDistancia(caminoParcial) + tunel.getEtiqueta())){

                // añado el tunel al camino
                caminoParcial.add(tunel);

                // clon de unionFind
                UnionFind unionFindClone = unionFind.clone();

                // efectuo la union de conjunto
                unionFind.union(estacionOrigenIndex, estacionDestinoIndex);

                // llamada recursiva CON EL TUNEL ACTUAL
                this.back(caminoParcial, index);

                // deshacemos los pasos anteriores
                caminoParcial.remove(caminoParcial.size() - 1); // eliminamos el ultimo

                // reestablecemos el clon de unionFind
                unionFind = unionFindClone;
            }

            // PODA #3:
            // si los tuneles del caminoParcial + los tuneles disponebles no son mas o igual que los
            // necesarios para terminar la obra, entonces no puedo prescindir sin ese tnel
            if(((this.tuneles.size() - (index + 1)) + caminoParcial.size()) >= this.estaciones.size() - 1)
                // llamada recursiva SIN EL TUNEL ACTUAL
                this.back(caminoParcial, index);
        }
    }

    public Integer calcDistancia(ArrayList<Tunel<Integer>> tuneles){
        int suma = 0;
        for(Tunel<Integer> tunel : tuneles){
            suma += tunel.getEtiqueta();
        }
        return suma;
    }
    public ArrayList<Tunel<Integer>> getSolucion(){
        return tunelesDistanciaMinima;
    }
    public Integer getCosto(){
        return this.costoMinimo;
    }
    public Integer getTime(){
        return time;
    }

}