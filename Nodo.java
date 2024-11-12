package gestiondetareas;

public class Nodo {
    class nodo{
    int dato;
    nodo siguiente;
    nodo anterior;
    nodo(int valor){
        this.dato = valor;
    }
    nodo(int valor, nodo anteriorerior){
        this.dato = valor;
        this.anterior = anteriorerior;
    }
}

    class lista{
        nodo L,aux,aux2,L2;

        void insertar(int numero){
        if (L == null) {
            L = new nodo(numero);
        }else{
            aux = L;
            while (aux.siguiente != null)
                aux= aux.siguiente;
            /*aux.siguient = new nodo(numero);
            aux2 = aux;
            aux = aux.siguient;
            aux.anterior = aux2;*/
            aux.siguiente = new nodo(numero, aux);
        }
    }
    
    void eliminar(int valor){
        aux=L;
        nodo aux2 = null;
        while(aux.siguiente!=null || aux.dato != valor){
            aux2=aux;
            aux=aux.siguiente;
        }
        if (aux.dato == valor){
            if (aux.anterior == null) {
                L = L.siguiente;
                L.anterior = null;
            }else if(aux.siguiente == null){
                aux = aux.anterior;
                aux.siguiente = null;
            }else{
                /*
                nodo aux3 = aux.siguient;
                aux2.siguient = aux.siguient;
                aux3.anterior = aux2;
                */
                aux.anterior.siguiente = aux.siguiente;
                aux.siguiente.anterior = aux.anterior;
                aux = null;
            }
            System.out.println(valor + " Eliminado de la lista");
        }else{
            System.out.println("valor no encontrado en la lista");
        }
    }
   void sumar(){
       aux = L;
       int sum=0;
       while (aux.siguiente != null){
           sum+=aux.dato;
           aux=aux.siguiente;
       }
       System.out.println("La suma de todos los elementos de la lista es: " + sum);
   }
}
}
