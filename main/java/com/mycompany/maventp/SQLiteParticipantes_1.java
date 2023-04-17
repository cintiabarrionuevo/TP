/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 
package com.mycompany.maventp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Familia
 
public class SQLiteParticipantes_1 {
    
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Establecer una conexión
            conn = DriverManager.getConnection("jdbc:sqlite:database.db");
            // Crear la base de datos
            Statement stmt = conn.createStatement();
            String insert;
            // Crear la tabla de participantes
            System.out.println("Creando y cargando la base de datos...");
            stmt.executeUpdate("drop table if exists equipos");
            stmt.executeUpdate("create table participantes (idParticipante integer, Nombre string, idPronostico integer");
            // Cargar la tabla de participantes
            insert = "insert into participantes (idParticipante,Nombre, idPronostico) values (?,?,?)";
            PreparedStatement pInsert = conn.prepareStatement(insert);
            for (int i = 1; i < 11; i++) {
                pInsert.setInt(1, i);
                pInsert.setString(2, "Participante ");
                pInsert.setString(3, "Nombre del participante ");
                pInsert.setString(1,"idPronostico");
                pInsert.executeUpdate();
            }
            System.out.println("Base de datos creada y cargada exitosamente.");

            System.out.println("Consultando datos...");
            String sql = "SELECT idParticipante, Nombre, idPronostico FROM participantes";
            ResultSet rs = stmt.executeQuery(sql); // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("idParticipante") + "\t"
                        + rs.getString("Nombre") + "\t"
                + rs.getInt("idPronostico") + "\t");
                       
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // conn close failed.
                System.out.println(e.getMessage());
            }
        }
    }
    
    
}*/
