/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maventp;
import com.mycompany.maventp.ListaParticipantes;

/**
 *
 * @author Familia
 */
public class MavenTP {
    public static ListaParticipantes PRODE;
    public static ListaPronosticos PRUEBA;
    public static ListaEquipos PRUEBA2;
    

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println ("MOSTRAR LOS PRONOSTICOS Y QUIEN GANO");
        System.out.println ("Ejecutándose desde:"+System.getProperty("user.dir"));
        
        PRODE = new ListaParticipantes();
        PRODE.listarOrdenadosPorPuntaje();
        PRODE.listar();
        
        PRUEBA2 = new ListaEquipos();
        PRUEBA2.getEquipos();
        
        
        
       
    }
}
