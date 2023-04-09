package PaqC08;


public class Hub {
    private Contenedor[][] Hub;


    public Hub() {
        Hub = new Contenedor[10][12];
    }

    public String toString() {
        String x = new String();
        for (int i = 0; i < Hub.length; i++) {
            for (int j = 0; j < Hub[0].length; j++)
                x = x + "\nFila " + (i + 1) + ", columna " + (j + 1) + ":\n" + Hub[i][j];
        }
        return x;
    }

    public boolean apilar(Contenedor c){
        boolean x =false;//para ver si el contenedor se ha apilado o no
        if (c.getPrioridad()==1){
            for (int i= Hub.length;i>0;i--){
                if (Hub[i-1][0]==null){ //si la posicion tiene un null es que esta "vacia" entonces apilamos el contenedor
                    Hub[i-1][0]=c;
                    x=true;// true si se ha apilado
                    break;}

            }


        }
        if (c.getPrioridad()==2){
            for (int i=Hub.length;i>0;i--){
                if (Hub[i-1][1]==null){
                    Hub[i-1][1]=c;
                    x=true;
                    break;}

            }


        }
        if (c.getPrioridad()==3){
            boolean salir=false; // como estamos en la ultima prioridad si se consigue apilar en este se pondra a true y nos salimos de recorrer el hub
            for (int j=2;j<Hub[0].length;j++){
                for (int i=Hub.length;i>0;i--){

                    if (Hub[i-1][j]==null){Hub[i-1][j]=c;
                        x=true;
                        salir=true;
                        break;}
                }
                if (salir==true) break;
            }
        }
        return x;//devuelve si se ha apilado o no
    }

    public Contenedor desapilar(int col) {//retorna el contenedor desapilado
        for (int i = 0; i < Hub.length; i++) {
            if (Hub[i][col - 1] != null) { // si la columna que pasamos por parametros esta llena
                {
                    Contenedor c = Hub[i][col - 1]; // se desapila el contenedor y se guarda
                    Hub[i][col - 1] = null;// se pone a nulo esa columna
                    return c;//retornamos el contenedor
                }
            }
        }
        return null; // si no se ha conseguido desapilar devuelve null
    }

    public String mostrarDatosContenedor(int NIC) {
        for (int i = 0; i < Hub.length; i++) {
            for (int j = 0; j < Hub[0].length; j++) {
                if (Hub[i][j] != null && Hub[i][j].getNIC() == NIC) {
                    return Hub[i][j].toString();

                }
            }
        }
        return null;
    }

    public Contenedor mostrarContenedor(int NIC) {
        for (int i = 0; i < Hub.length; i++) {
            for (int j = 0; j < Hub[0].length; j++) {
                if (Hub[i][j] != null && Hub[i][j].getNIC() == NIC) {
                    Contenedor c1 = Hub[i][j];

                    return c1;
                }

            }
        }
        return null;
    }

    public int contenedoresPais(String pais) {
        int contador=0;
        for (int i = 0; i < Hub.length; i++) {
            for (int j = 0; j < Hub[0].length; j++) {

                if (Hub[i][j] != null && Hub[i][j].getPais().equals(pais)) {
                    contador=contador +1;
                }
            }


        }
        return contador;
    }
}
