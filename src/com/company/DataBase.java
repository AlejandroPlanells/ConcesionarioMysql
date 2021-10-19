package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBase {
    private final String SERVIDOR = "jdbc:mysql://localhost/";
    private final String BASEDATOS = "concesionario";
    private final String USUARIO = "root";
    private final String PASSWORD = "";

    private Connection conexion = null;

    public DataBase() throws SQLException {
        conexion = DriverManager.getConnection(SERVIDOR+BASEDATOS, USUARIO, PASSWORD);
    }

    public boolean altaCoche(Coches coche) {
        String sql = "insert into coches values (NULL, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, coche.getMatricula());
            ps.setString(2, coche.getMarca());
            ps.setString(3, coche.getModelo());
            ps.setInt(4, coche.getPotencia());
            ps.setFloat(5, coche.getPrecio());

            int numFilas = ps.executeUpdate();

            if (numFilas>0)
                return true;
            else
                return false;

        }catch (SQLException e){
            return false;
        }
    }

    public boolean modificarCoche(Coches coche) {
        String ssql = "update coches set potencia=? where matricula=?;";

        try {
            PreparedStatement ps = conexion.prepareStatement(ssql);
            ps.setInt(1, coche.getPotencia());
            ps.setString(2, coche.getMatricula());
            System.out.println(ps);

            int numModificado = ps.executeUpdate();

            if (numModificado > 0){
                return true;
            }else{
                return false;
            }

        }catch (SQLException e){
            return false;

        }
    }
}
