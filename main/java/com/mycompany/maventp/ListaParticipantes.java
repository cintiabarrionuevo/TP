/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.maventp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ListaParticipantes {
    // atributo
    private List<Participante> participantes;
    private String participantesCSV;

    public ListaParticipantes(List<Participante> participantes, String participantesCSV) {
        this.participantes = participantes;
        this.participantesCSV = participantesCSV;
    }
    
    public ListaParticipantes() {
        this.participantes = new ArrayList<Participante>();
        this.participantesCSV = "participantes.csv";
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public String getParticipantesCSV() {
        return participantesCSV;
    }

    public void setParticipantesCSV(String participantesCSV) {
        this.participantesCSV = participantesCSV;
    }
    
    // add y remove elementos
    public void addParticipante(Participante p) {
        this.participantes.add(p);
    }
    public void removeParticipante(Participante p) {
        this.participantes.remove(p);
    }
    
    /***
     * Este método devuelve un Participante (o null) buscandolo por idParticipante
     * @param idParticipante Identificador del equipo deseado
     * @return Objeto Participante (o null si no se encuentra)
     */
    public Participante getParticipante (int idParticipante) {
        // Defini un objeto de tipo Participante en dónde va a ir mi resultado
        // Inicialmente es null, ya que no he encontrado el equipo que 
        // buscaba todavía.
        Participante encontrado = null;
        //String resultado= "nada";
        // Recorro la lista de participantes que está cargada
        for (Participante eq : this.getParticipantes()) {
            // Para cada equipo obtengo el valor del ID y lo comparo con el que
            // estoy buscando
            if (eq.getIdParticipante() == idParticipante) {
                // Si lo encuentro (son iguales) lo asigno como valor de encontrado
                encontrado = eq;
              //  resultado= "ok";
                // Y hago un break para salir del ciclo ya que no hace falta seguir buscando
                break;
            }
        }
        // Una vez fuera del ciclo retorno el Participante, pueden pasar dos cosas:
        // 1- Lo encontré en el ciclo, entonces encontrado tiene el objeto encontrado
        // 2- No lo encontré en el ciclo, entonces conserva el valor null del principio
        return encontrado;
    }

    @Override
    public String toString() {
        return "ListaParticipantes{" + "participantes=" + participantes + '}';
    }

    public String listar() {
        String lista = "";
        for (Participante participante: participantes) {
            lista += "\n" + participante;
          //   System.out.println ("ENTRO al for " + participante);
        }           
        return lista;
    }
    
    // cargar desde el archivo
    public void cargarDeArchivo() {
        // para las lineas del archivo csv
        String datosParticipante;
        // para los datos individuales de cada linea
        String vectorParticipante[];
        // para el objeto en memoria
        Participante participante;
        int fila = 0;
       
        try { 
            Scanner sc = new Scanner(new File(this.getParticipantesCSV()));
            sc.useDelimiter("\n");   //setea el separador de los datos
                
            while (sc.hasNext()) {
                // levanta los datos de cada linea
                datosParticipante = sc.next();
                // Descomentar si se quiere mostrar cada línea leída desde el archivo
                // System.out.println(datosParticipante);  //muestra los datos levantados 
                fila ++;
                // si es la cabecera la descarto y no se considera para armar el listado
                if (fila == 1)
                    continue;              
                 
                //Proceso auxiliar para convertir los string en vector
                // guarda en un vector los elementos individuales
                vectorParticipante = datosParticipante.split(",");   
                
                // graba el equipo en memoria
                //convertir un string a un entero;
                int idParticipante = Integer.parseInt(vectorParticipante[0]);
                String nombre = vectorParticipante[1];
                ListaPronosticos pronosticos = new ListaPronosticos();
                
                
                // crea el objeto en memoria
                participante = new Participante(nombre,pronosticos, idParticipante);
                System.out.println ("ENTRO " + participante);
                
                // llama al metodo add para grabar el equipo en la lista en memoria
                this.addParticipante(participante);
            }
            //closes the scanner
        } catch (IOException ex) {
                System.out.println("Mensaje: " + ex.getMessage());
        }       
    }
    
    
    //ordenar por puntaje
    //mostrar la lista
    public List<Participante> getOrdenadosPorPuntaje(){
        //genera una copia de la lista, para no modificar el contenido original
        List<Participante> ordenados = new ArrayList<Participante> ();
        ordenados.addAll(participantes);
        
        //obtener la lista de mayor a menor
        Collections.sort(ordenados, Collections.reverseOrder());
        return ordenados;
    }
    public String listarOrdenadosPorPuntaje(){
      //  System.out.println ("ENTRO  en listarOrdenadosPorPuntaje");
        
        List<Participante> ordenados = this.getOrdenadosPorPuntaje();
        String lista="";
        //System.out.println("\n  Nombre del Participante Puntaje del Participante \n");
        for(Participante participante : ordenados)
        {
           // System.out.println("DATOS DEL FOR EN ORDENADOS " + ordenados);
            lista += "\n" + participante.getNombre() + " " + participante.getPuntaje();
           
            System.out.println("\n" + participante.getNombre() + " " + participante.getPuntaje()+ "\n");
              }
            return lista;
    
}
    
    
    // CARGAR DESDE LA BASE DE DATOS 
    
    
     
    public void cargarDeBD ()
         /*String nombre,
         int idParticipante 
          )*/
    {   
    
             Connection conn = null;
        try {
            // Establecer una conexión
            System.out.println("Establecer una conexión");
            conn = DriverManager.getConnection("jdbc:sqlite:pronosticos.db");
            // Crear el statement para enviar comandos
           // System.out.println(" DESPUES DE Establecer una conexión" + conn);
            Statement stmt = conn.createStatement();

            System.out.println("Consultando datos DE PARTICIPANTES...");
            String sql = "SELECT"
                    + " Nombre, idParticipante"
                    + " FROM participantes";
           
                   
                    
            ResultSet rs = stmt.executeQuery(sql); // ejecutar la consulta y obtener el resulset
            
            while (rs.next()) {
              
                
                //crea el objeto en memoria 
                ListaPronosticos milista =  new ListaPronosticos();
                Participante participante = new Participante(
                        
                        rs.getString("Nombre"), 
                        milista,
                        rs.getInt("idParticipante") 
                        );
                       
                        
                        
                
                this.addParticipante(participante);
               // System.out.println("se cargo " + participante);
            }
            }catch (SQLException e) {
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
     
     System.out.println("finalizo ok ListaParticipantes" );
}
  
    }





