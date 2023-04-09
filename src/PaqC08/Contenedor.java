package PaqC08;

public class Contenedor {
    private int NIC;
    private int peso;
    private String pais;
    private boolean controlAduanas;
    private int prioridad;
    private String descripcion;
    private String empresaDeEnvio;
    private String empresaDeEntrega;

    public int getNIC() {
        return NIC;
    }

    public void setNIC(int NIC) {
        this.NIC = NIC;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public boolean getControlAduanas() {
        return controlAduanas;
    }

    public void setControlAduanas(boolean controlAduanas) {
        this.controlAduanas = controlAduanas;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if(descripcion.length() <= 100){
            this.descripcion = descripcion;
        }
    }

    public String getEmpresaDeEnvio() {
        return empresaDeEnvio;
    }

    public void setEmpresaDeEnvio(String empresaDeEnvio) {
        if(empresaDeEnvio.length() <= 20) {
            this.empresaDeEnvio = empresaDeEnvio;
        }
    }

    public String getEmpresaDeEntrega() {
        return empresaDeEntrega;
    }

    public void setEmpresaDeEntrega(String empresaDeEntrega) {
        if(empresaDeEntrega.length() <= 20){
            this.empresaDeEntrega = empresaDeEntrega;
        }
    }

    public Contenedor(int NIC, int peso, String pais, boolean controlAduanas, int prioridad, String descripcion, String empresaDeEnvio, String empresaDeEntrega) {
        this.NIC = NIC;
        this.peso = peso;
        this.pais = pais;
        this.controlAduanas = controlAduanas;
        this.prioridad = prioridad;
        this.descripcion = descripcion;
        this.empresaDeEnvio = empresaDeEnvio;
        this.empresaDeEntrega = empresaDeEntrega;
    }

    public String toString() {
        return  "NIC de contenedor: " + NIC +
                "\nPeso: " + peso +
                "\nPais: " + pais +
                "\nControl de aduanas: " + controlAduanas +
                "\nPrioridad: " + prioridad +
                "\nDescripcion: " + descripcion +
                "\nEmpresa de envio: " + empresaDeEnvio +
                "\nEmpresa de entrega: " + empresaDeEntrega;
    }

}