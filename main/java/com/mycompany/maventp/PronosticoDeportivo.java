/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maventp;

import java.util.Random;
import java.util.Scanner;
import de.vandermeer.asciitable.AsciiTable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * 
 */
public class PronosticoDeportivo {
    private ListaEquipos equipos;
    private ListaPartidos partidos;
    private ListaParticipantes participantes;
    private ListaPronosticos pronosticos;

    public PronosticoDeportivo() {
        equipos = new ListaEquipos();
        partidos = new ListaPartidos();
        participantes = new ListaParticipantes();
        pronosticos = new ListaPronosticos();
    }

    public void play(){
        
        // cargar y listar los equipos
        equipos.cargarDeBD();
    
        System.out.println("Los equipos cargados son: " + equipos.listar());
        
        partidos.cargarDeBD(equipos);
        
       System.out.println("Los partidos cargados son: " + partidos.listar());

       participantes.cargarDeBD();
        // Una vez cargados los participantes, para cada uno de ellos
        // cargar sus pronósticos
        for (Participante p : participantes.getParticipantes()) {
            p.cargarPronosticos(equipos, partidos);
        }
        
      //mostrar listado de participante ordenado por puntaje
     System.out.println ("MOSTRAR QUIEN GANO Y SU PUNTAJE ");
     participantes.listarOrdenadosPorPuntaje();
        
        

        // agregar y/o modificar el codigo que quieran
        System.out.println("Ingrese el ID  de un equipo para buscar: ");
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Equipo equi= equipos.getEquipo(n);
        if(equi != null)
        {
          System.out.println("El EQUIPO ES : " + equi);  
        } else { 
            System.out.println("NO SE ENCONTRO EL EQUIPO : " + n);
        }
        
        
        /// mostrar el aprticipante que gano
        
        
        
        
        
        
        
    }    
}
