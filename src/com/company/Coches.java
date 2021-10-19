package com.company;

public class Coches {
    private String matricula;
    private String marca;
    private String modelo;
    private int potencia;
    private float precio;

    public Coches() {
        matricula = "POR DEFINIR";
        marca = "";
        modelo = "";
        potencia = 0;
        precio = 0;
    }

    /**
     * Si se usa el constructor vacio matricula vale "POR DEFINIR" permitiendo solo en esta caso su porterior modificacion
     *
     */

    public Coches(String matricula, String marca, String modelo, int potencia, float precio) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.precio = precio;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        if (this.matricula.equals("POR DEFINIR"))
            this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Coches{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", potencia=" + potencia +
                ", precio=" + precio +
                '}';
    }
}
