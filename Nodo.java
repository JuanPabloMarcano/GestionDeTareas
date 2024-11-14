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
    
    class tarea{
        private String titulo; 
        private String descripcion; 
        private String fechaLimite; 
        private String estado; 
        private String asignadoA;
        
        public String getTitulo() {
            return titulo;
        }
        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }
        public String getDescripcion() {
            return descripcion;
        }
        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
        public String getFechaLimite() {
            return fechaLimite;
        }
        public void setFechaLimite(String fechaLimite) {
            this.fechaLimite = fechaLimite;
        }
        public String getEstado() {
            return estado;
        }
        public void setEstado(String estado) {
            this.estado = estado;
        }
        public String getAsignadoA() {
            return asignadoA;
        }
        public void setAsignadoA(String asignadoA) {
            this.asignadoA = asignadoA;
        }
    }
    
    class usuario{
        private String nombre; 
        private String apellido; 
        private String cedula; 
        private String nombreUsuario; 
        private String contraseña; 
        private String tipoUsuario;

        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public String getApellido() {
            return apellido;
        }
        public void setApellido(String apellido) {
            this.apellido = apellido;
        }
        public String getCedula() {
            return cedula;
        }
        public void setCedula(String cedula) {
            this.cedula = cedula;
        }
        public String getNombreUsuario() {
            return nombreUsuario;
        }
        public void setNombreUsuario(String nombreUsuario) {
            this.nombreUsuario = nombreUsuario;
        }
        public String getContraseña() {
            return contraseña;
        }
        public void setContraseña(String contraseña) {
            this.contraseña = contraseña;
        }
        public String getTipoUsuario() {
            return tipoUsuario;
        }
        public void setTipoUsuario(String tipoUsuario) {
            this.tipoUsuario = tipoUsuario;
        }   
    }
}
