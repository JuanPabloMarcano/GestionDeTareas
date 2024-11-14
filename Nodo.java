package gestiondetareas;

public class Nodo {
    class nodo{
    int dato;
    nodo siguiente;
    nodo anterior;
    nodo(int tarea){
        this.dato = tarea;
    }
    nodo(int tarea, nodo anteriorerior){
        this.dato = tarea;
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
            aux.siguiente = new nodo(numero, aux);
        }
    }
    
    void eliminar(int tarea){
        aux=L;
        nodo aux2 = null;
        while(aux.siguiente!=null || aux.dato != tarea){
            aux2=aux;
            aux=aux.siguiente;
        }
        if (aux.dato == tarea){
            if (aux.anterior == null) {
                L = L.siguiente;
                L.anterior = null;
            }else if(aux.siguiente == null){
                aux = aux.anterior;
                aux.siguiente = null;
            }else{
                aux.anterior.siguiente = aux.siguiente;
                aux.siguiente.anterior = aux.anterior;
                aux = null;
            }
            System.out.println(tarea + " Eliminado de la lista");
        }else{
            System.out.println("tarea no encontrado en la lista");
        }
    }
  }
}
