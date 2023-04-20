/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maventp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;



/**
 *
 * @author Familia
 */
public class ListaPronosticos {
    
    private List<Pronostico> pronosticos;
    private String pronosticoCSV;

    public ListaPronosticos(List<Pronostico> pronosticos, String pronosticoCSV) {
        this.pronosticos = pronosticos;
        this.pronosticoCSV = pronosticoCSV;
    }
    
     public ListaPronosticos() {
        this.pronosticos = new ArrayList<Pronostico>();
        this.pronosticoCSV = "pronosticos.csv";
    }

    public List<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(List<Pronostico> pronosticos) {
        this.pronosticos = pronosticos;
    }

    public String getPronosticoCSV() {
        return pronosticoCSV;
    }

    public void setPronosticoCSV(String pronosticoCSV) {
        this.pronosticoCSV = pronosticoCSV;
    }

    @Override
    public String toString() {
        return "ListaPronosticos{" + "pronosticos=" + pronosticos + ", pronosticoCSV=" + pronosticoCSV + '}';
    }
    
    // add y remove elementos
    public void addPronostico(Pronostico pr) {
        this.pronosticos.add(pr);
    }
    public void removePronostico(Pronostico pr) {
        this.pronosticos.remove(pr);
    }
    
    public Pronostico getPronostico (int idPronostico) {
        // Defini un objeto de tipo Equipo en dónde va a ir mi resultado
        // Inicialmente es null, ya que no he encontrado el equipo que 
        // buscaba todavía.
        Pronostico encontrado = null;
        // Recorro la lista de equipos que está cargada
        for (Pronostico eq : this.getPronosticos()) {
            // Para cada equipo obtengo el valor del ID y lo comparo con el que
            // estoy buscando
            if (eq.getIdPronostico() == idPronostico) {
                // Si lo encuentro (son iguales) lo asigno como valor de encontrado
                encontrado = eq;
                // Y hago un break para salir del ciclo ya que no hace falta seguir buscando
                break;
            }
        }
        // Una vez fuera del ciclo retorno el equipo, pueden pasar dos cosas:
        // 1- Lo encontré en el ciclo, entonces encontrado tiene el objeto encontrado
        // 2- No lo encontré en el ciclo, entonces conserva el valor null del principio
        return encontrado;
    }
    
     public String listar() {
        String lista = "";
        for (Pronostico pronostico: pronosticos) {
            lista += "\n" + pronostico;
           // System.out.println ("ENTRO al for " + pronosticos);
        }           
        return lista;
    }
     
    
    
        // cargar desde el archivo
    public void cargarDeArchivo(
            int idParticipante, // id del participante que realizó el pronóstico
            ListaEquipos listaequipos, // lista de equipos
            ListaPartidos listapartidos // lista de partidos
    ) {
        // para cargar todo lo del archivo csv
        String datosPronostico;
        // para los datos individuales de cada linea
        String vectorPronostico[];
        // para el objeto en memoria
        
        int fila = 0;
       
        try { 
            Scanner sc = new Scanner(new File(this.getPronosticoCSV()));
            sc.useDelimiter("\n");   //setea el separador de los datos
                
            while (sc.hasNext()) {
                // levanta los datos de cada linea
                datosPronostico = sc.next();
                // Descomentar si se quiere mostrar cada línea leída desde el archivo
                // System.out.println(datosEquipo);  //muestra los datos levantados 
                fila ++;
                // si es la cabecera la descarto y no se considera para armar el listado
                if (fila == 1)
                    continue;              
                 
                //Proceso auxiliar para convertir los string en vector
                // guarda en un vector los elementos individuales
                vectorPronostico = datosPronostico.split(",");   
                
                // graba el equipo en memoria
                //convertir un string a un entero;
                int readidPronostico = Integer.parseInt(vectorPronostico[0]);
                int readidParticipante = Integer.parseInt(vectorPronostico[1]);
                int readidPartido = Integer.parseInt(vectorPronostico[2]);
                int readidEquipo = Integer.parseInt(vectorPronostico[3]);
                char readResultado = vectorPronostico[4].charAt(1);   
                // crea el objeto en memoria
               // Si coincide el idParticipante con el que estoy queriendo cargar,
                // sigo, si no, salteo el registro y voy al siguiente
                if (readidParticipante == idParticipante) {
                    // Obtener los objetos que necesito para el constructor
                    Partido partido = listapartidos.getPartido(readidPartido);
                    Equipo equipo = listaequipos.getEquipo(readidEquipo);
                    // crea el objeto en memoria
                    Pronostico pronostico = new Pronostico(
                            
                            equipo, // El Equipo que obtuvimos de la lista
                            partido, // El Partido que obtuvimos de la lista
                            readResultado, // El resultado que leimos del archivo
                            readidPronostico); // El id leido del archivo
                    

                    // llama al metodo add para grabar el equipo en la lista en memoria
                    this.addPronostico(pronostico);
                }
            }
            //closes the scanner
        } catch (IOException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
    
    }
   
        // PARA CARGAR TODOS SIN HACER NINGUNA VERIFICACION
     public void cargarDeArchivoTodos(
            ListaEquipos listaequipos, // lista de equipos
            ListaPartidos listapartidos // lista de partidos
    ) {
        // para las lineas del archivo csv
        String datosPronostico;
        // para los datos individuales de cada linea
        String vectorPronostico[];

        int fila = 0;

        try {
            Scanner sc = new Scanner(new File(this.getPronosticoCSV()));
            sc.useDelimiter("\n");   //setea el separador de los datos

            while (sc.hasNext()) {
                // levanta los datos de cada linea
                datosPronostico = sc.next();
                // Descomentar si se quiere mostrar cada línea leída desde el archivo
                // System.out.println(datosPronostico);  //muestra los datos levantados 
                fila++;
                // si es la cabecera la descarto y no se considera para armar el listado
                if (fila == 1) {
                    continue;
                }

                //Proceso auxiliar para convertir los string en vector
                // guarda en un vector los elementos individuales
                vectorPronostico = datosPronostico.split(",");

                // graba el equipo en memoria
                //convertir un string a un entero;
                int readidPronostico = Integer.parseInt(vectorPronostico[0]);
                int readidParticipante = Integer.parseInt(vectorPronostico[1]);
                int readidPartido = Integer.parseInt(vectorPronostico[2]);
                int readidEquipo = Integer.parseInt(vectorPronostico[3]);
                char readResultado = vectorPronostico[4].charAt(1);     // El primer caracter es una comilla delimitadora de campo
                
                // Obtener los objetos que necesito para el constructor
                Partido partido = listapartidos.getPartido(readidPartido);
                Equipo equipo = listaequipos.getEquipo(readidEquipo);
                // crea el objeto en memoria
                Pronostico pronostico = new Pronostico(
                        
                        equipo, // El Equipo que obtuvimos de la lista
                        partido, // El Partido que obtuvimos de la lista
                        readResultado, // El resultado que leimos del archivo,
                        readidPronostico // El id leido del archivo
                );

                // llama al metodo add para grabar el equipo en la lista en memoria
                this.addPronostico(pronostico);

            }
            //closes the scanner
        } catch (IOException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
    }
     
     // CARGAR DESDE LA BASE DE DATOS
     
    public void cargarDeBD (
            int idParticipante, //id del participante que realizo el pronostico
            ListaEquipos listaequipos, // lista de queipos
            ListaPartidos listapartidos // lista de partidos
    ){
             Connection conn = null;
        try {
            // Establecer una conexión
            conn = DriverManager.getConnection("jdbc:sqlite:pronosticos.db");
            // Crear el statement para enviar comandos
            Statement stmt = conn.createStatement();
             
            System.out.println("Consultando datos DE CADA PRONOSTICOS...");
            String sql = "SELECT"
                    + " idPronostico, idParticipante, idPartido, idEquipo, resultado"
                    + " FROM pronosticos"
                    + " WHERE idParticipante = " + idParticipante;
                    
            ResultSet rs = stmt.executeQuery(sql); // ejecutar la consulta y obtener el resulset
           // System.out.println("ANTES DEL WHILE");
           // System.out.println("SQL" + sql);
            
            /* // para saber que envia YO
                System.out.println("datos para el constructor");
               // System.out.println(equipo);
               // System.out.println(partido);
                System.out.println(rs.getString("resultado"));
                System.out.println(rs.getString("idPronostico"));*/
            
            
            while (rs.next()) {
              //  System.out.println("ENTRA AL WHILE");
                //obtener los datos que necesito para el constructor
                Partido partido = listapartidos.getPartido(rs.getInt("idPartido"));
                Equipo equipo = listaequipos.getEquipo(rs.getInt("idEquipo"));
                
               /* // para saber que envia YO
                System.out.println("datos para el constructor");
                System.out.println(equipo);
                System.out.println(partido);
                System.out.println(rs.getString("resultado"));
                System.out.println(rs.getString("idPronostico"));*/
                
                //crea el objeto en memoria
                Pronostico pronostico = new Pronostico(
                        
                        equipo, // el equipo que obtuvimos de la lista
                        partido, // el partido que obtuvimos de la lista
                        //el primer caracter es una comilla delimitadora de campo
                    rs.getString("resultado").charAt(0),// el resultado que leimos de la tabla
                        rs.getInt("idPronostico"));//el id leido de la tabla)
                       
                        
                        
                 
                this.addPronostico(pronostico);
                
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
     
     
     
     
    
}
}
