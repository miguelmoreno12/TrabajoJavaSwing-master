package PaqC08;

import Contenedores.MiPanel;



public class Main {
    public static void main(String[] args) {
        new MiPanel();
        Hub H = new Hub();
        Contenedor C1 = new Contenedor(54455,250,"España",true,1,"Sí","Empresa1","Empresa2");
        Contenedor C2 = new Contenedor(54452,250,"Irlanda",true,1,"Sí","Empresa1","Empresa2");
        Contenedor C3 = new Contenedor(54453,250,"Alemania",true,1,"Sí","Empresa1","Empresa2");

        H.apilar(C1);
        H.apilar(C2);
        H.apilar(C3);
        H.desapilar(1);
        //System.out.println(C1.toString());
        System.out.println(H.toString());
        System.out.println(H.mostrarDatosContenedor(54452));

    }
}