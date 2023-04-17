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
 
public class SQLiteParticipantes_2 {
    
     public static void main(String[] args) {
        Connection conn = null;
        try {
            // Establecer una conexión
            conn = DriverManager.getConnection("jdbc:sqlite:database.db");
            // Crear la base de datos
            Statement stmt = conn.createStatement();

            System.out.println("Consultando datos...");
            String sql = "SELECT idParticipante, Nombre FROM participantes";
            ResultSet rs = stmt.executeQuery(sql); // loop through the result set
            System.out.println("Cargando los datos en ListaParticipantes...");
            ListaParticipantes lista = new ListaParticipantes();
            while (rs.next()) {
                Participante par = new Participante(                        
                        rs.getString("Nombre"),
                        rs.getInt("idPronostico"),
                        rs.getInt("idParticipante")
                );
                lista.addParticipante(par);
            }
            System.out.println("Mostrando los OBJETOS de ListaEquipos...");
            System.out.println(lista.listar());
            
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
