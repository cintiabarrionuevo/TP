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
    public static ListaParticipantes PRUEBA1;
    
    public static ListaEquipos PRUEBA2;
    public static ListaPartidos PRUEBA3;
    public static PronosticoDeportivo PRODE1;    
    public static ListaPronosticos PRUEBA4;
    public static Participante participante;
    public static Pronostico pronostico;
    
    

    public static void main(String[] args) {
       // System.out.println("Hello World!");
        System.out.println ("MOSTRANDO CARGAS DESDE LA BASE DE DATOS");
        System.out.println ("Ejecutándose desde:"+System.getProperty("user.dir"));
        
        
         PRODE1 = new PronosticoDeportivo();

        PRODE1.play();
       /*
        // carga de equipos
       PRUEBA2 = new ListaEquipos();
       PRUEBA2.cargarDeBD();
      /// PRUEBA2.listar();
      
        //carga los partidos 
      PRUEBA3 = new ListaPartidos() ;
     PRUEBA3.cargarDeBD(PRUEBA2);
    // PRUEBA3.listar();
      
        //carga de participantes
       PRUEBA1 = new ListaParticipantes();
        PRUEBA1.cargarDeBD();
      ///PRUEBA1.listar(); 
        
       
     
   
     
     participante = new Participante();
      participante.cargarPronosticos(PRUEBA2, PRUEBA3);
     
     //PRUEBA4 = new ListaPronosticos();
     //PRUEBA4.cargarDeBD(0, PRUEBA2, PRUEBA3);
     //PRUEBA4.listar();
     
     
     pronostico = new Pronostico();
     pronostico.puntos();
    // participante.getPuntaje();
    
   // PRUEBA1.getOrdenadosPorPuntaje();
   //    PRUEBA1.listarOrdenadosPorPuntaje();
        ///PRODE.listar();
        
       */
       

        
        
        
       
    }
}
