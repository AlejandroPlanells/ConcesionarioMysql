package com.company;

import java.sql.SQLException;
import java.util.Scanner;

public class LogicaNegocio {
    private Scanner sc;
    private DataBase db;

    public LogicaNegocio(){
        sc = new Scanner(System.in);

        try{
            db = new DataBase();
        }catch(SQLException e){
            System.out.println("Ha fallado el acceso a la base de datos");
        }

    }

    public void mostrarMenu(){
        int opcion;

        do {
            System.out.println("CONCESIONARIO");
            System.out.println("--------------------------------------------");
            System.out.println("1. Alta de coche");
            System.out.println("2. Modificar datos de coche");
            System.out.println("3. Borrar coche por matricula");
            System.out.println("4. Borrar coches por marca");
            System.out.println("5. Consultar coche por matricula");
            System.out.println("6. Consultar coches por modelo");
            System.out.println("7. Salir de la aplicación");
            System.out.println("--------------------------------------------");
            System.out.print("Elige la opción:");

            opcion = sc.nextInt();

            switch (opcion){
                case 1: agregarCoche(); break;

                case 2: modificarCoche(); break;
                /*
                case 3: borrarCochePorMatricula(); break;
                case 4: borrarCochesPorMarca(); break;
                case 5: consultarCochePorMatricula(); break;
                case 6: consultarCochePorModelo(); break;

                 */
            }
        }while (opcion != 7);
        System.out.println("Programa finalizado");
    }

    private void modificarCoche() {
        String matricula = "ABC";
        int potencia = 900;


        Coches coche;
        System.out.println("El usuario indica especifica los datos del coche a modificar.");


        coche = new Coches("ABC","Citroen","C4",900,12034.4f);

        boolean modificacionCorrecta = db.modificarCoche(coche);

        if (modificacionCorrecta)
            System.out.println("El coche se ha modificado en la base de datos correctamente");
        else
            System.out.println("Se ha producido un error al insertar el coche en la base de datos");


    }

    private void agregarCoche() {
        Coches coche;
        System.out.println("El usuario indica especifica todos los datos del coche a dar de alta.");

        //Tenemos los datos de los coches cada uno en una variable (Matricula, marca, modelo, modelo, potencia, precio)
        coche = new Coches("FJAD192", "Citroen", "C4", 12, 12034.4f);
        boolean altaCorrecta = db.altaCoche(coche);

        if (altaCorrecta)
            System.out.println("El coche se ha insertado en la base de datos correctamente");
        else
            System.out.println("Se ha producido un error al insertar el coche en la base de datos");
    }
}

