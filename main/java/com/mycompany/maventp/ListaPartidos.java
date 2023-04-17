/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maventp;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Familia
 */
public class ListaPartidos {
    
    private List<Partido> partidos;
    private String partidosCSV;

    public ListaPartidos(List<Partido> partidos, String partidosCSV) {
        this.partidos = partidos;
        this.partidosCSV = partidosCSV;
    }
     public ListaPartidos() {
        this.partidos = new ArrayList<Partido>();;
        this.partidosCSV = "partidos.csv";
        
          }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    public String getPartidosCSV() {
        return partidosCSV;
    }

    public void setPartidosCSV(String partidosCSV) {
        this.partidosCSV = partidosCSV;
    }

    @Override
    public String toString() {
        return "ListaPartidos{" + "partidos=" + partidos + ", partidosCSV=" + partidosCSV + '}';
    }
     
     // add y remove elementos
    public void addPartido(Partido p) {
        this.partidos.add(p);
    }
    public void removePartido(Partido p) {
        this.partidos.remove(p);
    }
    
    public Partido getPartido (int idPartido) {
        // Defini un objeto de tipo Partido en dónde va a ir mi resultado
        // Inicialmente es null, ya que no he encontrado el partido que 
        // buscaba todavía.
        Partido encontrado = null;
        // Recorro la lista de partidos que está cargada
        for (Partido parti : this.getPartidos()) {
            // Para cada equipo obtengo el valor del ID y lo comparo con el que
            // estoy buscando
            if (parti.getIdPartido() == idPartido) {
                // Si lo encuentro (son iguales) lo asigno como valor de encontrado
                encontrado = parti;
                // Y hago un break para salir del ciclo ya que no hace falta seguir buscando
                break;
            }
        }
        // Una vez fuera del ciclo retorno el partido, pueden pasar dos cosas:
        // 1- Lo encontré en el ciclo, entonces encontrado tiene el objeto encontrado
        // 2- No lo encontré en el ciclo, entonces conserva el valor null del principio
        return encontrado;
    }
   
    
    public String listar() {
        String lista = "";
        for (Partido partido: partidos) {
            lista += "\n" + partido;
        }           
        return lista;
    }
    
      // cargar desde el archivo
    public void cargarDeArchivo( ListaEquipos listaequipos)
      {
        // para cargar todo lo del archivo csv
        String datosPartido;
        // para los datos individuales de cada linea
        String vectorPartido[];
        // para el objeto en memoria
        Partido partido;
        
        int fila = 0;
       
        try { 
            Scanner sc = new Scanner(new File(this.getPartidosCSV()));
            sc.useDelimiter("\n");   //setea el separador de los datos
                
            while (sc.hasNext()) {
                // levanta los datos de cada linea
                datosPartido = sc.next();
                // Descomentar si se quiere mostrar cada línea leída desde el archivo
                // System.out.println(datosEquipo);  //muestra los datos levantados 
                fila ++;
                // si es la cabecera la descarto y no se considera para armar el listado
                if (fila == 1)
                    continue;              
                 
                //Proceso auxiliar para convertir los string en vector
                // guarda en un vector los elementos individuales
                vectorPartido = datosPartido.split(",");   
                
                // graba el partido en memoria
                //convertir un string a un entero;
                int idPartido = Integer.parseInt(vectorPartido[0]);               
                int golesEqui1 = Integer.parseInt(vectorPartido[3]); 
                int golesEqui2 = Integer.parseInt(vectorPartido[4]);
                
                // busco el equipo por el nro de equipo que tengo en el csv 
                
                int readidEquipo1 = Integer.parseInt(vectorPartido[1]);
                int readidEquipo2 = Integer.parseInt(vectorPartido[2]);
                
                
                    // Obtener los objetos que necesito para el constructor
                    Equipo equi1 = listaequipos.getEquipo(readidEquipo1);
                    
                    Equipo equi2 = listaequipos.getEquipo(readidEquipo2);          
                      
                                             
                          
                // crea el objeto en memoria
                partido = new Partido(equi1, equi2, golesEqui1,golesEqui2,idPartido);
                
                
                // llama al metodo add para grabar el equipo en la lista en memoria
                this.addPartido(partido);
            }
            //closes the scanner
        
        }
        catch (IOException ex) {
                System.out.println("Mensaje: " + ex.getMessage());
        }       

    }
}
