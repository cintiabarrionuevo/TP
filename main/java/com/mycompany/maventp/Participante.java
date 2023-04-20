/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maventp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Participante implements Comparable<Participante> {
    
    private String nombre;
    private ListaPronosticos pronosticos;
    private int idParticipante;

    public Participante(String nombre, ListaPronosticos pronosticos, int idParticipante) {
        this.nombre = nombre;
        this.pronosticos = new ListaPronosticos();
        this.idParticipante = idParticipante;
    }
 public Participante() {
        this.nombre = "";
        this.pronosticos = new ListaPronosticos();
        this.idParticipante = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaPronosticos getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(ListaPronosticos pronosticos) {
        this.pronosticos = pronosticos;
    }

    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    @Override
    public String toString() {
        return "Participante{" + "nombre=" + nombre + ", pronosticos=" + pronosticos + ", idParticipante=" + idParticipante + '}';
    }

    
    
    public int getPuntaje() {
          // Para ver el puntaje debo recorrer los pronosticos y ver el puntaje
        // de cada uno y acumularlo. Debo devolver el total.
        int puntaje = 0;
        
        // el primer mensaje corresponde al atributo pronosticos de parrticipante
        // el segundo mensaje corresponde a la lista que tiene el atributo pronosticos
        // de esa lista se obtiene cada pronostico y se saca el puntaje acumulandolo en 
        // la variable puntaje
        for (Pronostico p : this.getPronosticos().getPronosticos()) {
            
            puntaje += p.puntos();
          /*  int prono =p.getIdPronostico(); // para saber el idpronostico
            System.out.println ("el puntaje es  " + prono);*/
            
        }
       // System.out.println ("el puntaje es  " + puntaje);
        
        
        return puntaje;
    }
   
/* sin la lista
   public int getPuntaje() {
          // Para ver el puntaje debo recorrer los pronosticos y ver el puntaje
        // de cada uno y acumularlo. Debo devolver el total.
        int puntaje = 0;
        ListaPronosticos lista = new ListaPronosticos();
        
        // el primer mensaje corresponde al atributo pronosticos de parrticipante
        // el segundo mensaje corresponde a la lista que tiene el atributo pronosticos
        // de esa lista se obtiene cada pronostico y se saca el puntaje acumulandolo en 
        // la variable puntaje
        for (Pronostico p : lista.getPronosticos()) {
            puntaje += p.puntos();
        }
        return puntaje;
}
    
    
     void cargarPronosticos (ListaEquipos equipos, ListaPartidos partidos) {
        
        ListaPronosticos lista = new ListaPronosticos();
        lista.cargarDeArchivo(this.getIdParticipante(), equipos, partidos);
    }*/ //sin la lista
     
   void cargarPronosticos (ListaEquipos equipos, ListaPartidos partidos) {
        
       // this.pronosticos.cargarDeArchivo(this.getIdParticipante(), equipos, partidos);
        this.pronosticos.cargarDeBD(this.idParticipante, equipos, partidos);
        
      // System.out.println("Mensaje: " + pronosticos);
    }
      
    
      //compara por puntaje
     @Override
      
      public int compareTo(Participante p){
          // devuelve -1 si es menor//0 si es igual//1 si es mayor
          int mipuntaje=this.getPuntaje();
          int otropuntaje=p.getPuntaje();
          if(mipuntaje== otropuntaje)
                  return 0;
          else if(mipuntaje > otropuntaje)
                  return 1;
                  else 
                  return -1;
      }      
      
       
}
              
      
      
    

    

    

   
 

    

    
     
