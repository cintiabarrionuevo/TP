/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maventp;

public class Pronostico{
    private char resultado;
    private Equipo equipo;
    private Partido partido;
    private int idPronostico;

    public Pronostico( Equipo equipo, Partido partido,char resultado, int idPronostico) {
        this.resultado = resultado;
        this.equipo = equipo;
        this.partido = partido;
        this.idPronostico = idPronostico;
    }

    
    
    public Pronostico() {
        this.resultado = 0;
        this.equipo = new Equipo();
        this.partido = new Partido();
        this.idPronostico = 0;
    }

    public char getResultado() {
        return resultado;
    }

    public void setResultado(char resultado) {
        this.resultado = resultado;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

   public int getIdPronostico() {
        return idPronostico;
    }

    public void setIdPronostico(int idPronostico) {
        this.idPronostico = idPronostico;
    }
     @Override
    public String toString() {
        return "Pronostico{" + "resultado=" + resultado + ", equipo=" + equipo + ", partido=" + partido + ", idPronostico=" + idPronostico + '}';
    }
    
    public int puntos(){
           // devolver el punto segun G/P/E
           int pa1 = 0;
           int pa2 = 0;
           
          // pa1 = partido.getGolesEquipo1();
          // pa2 = partido.getGolesEquipo2();
                   
           if(pa1 < pa2){
              // System.out.println ("GolesEquipo1  " + pa1);
             //  System.out.println ("GolesEquipo2  " + pa2);
               
               if(equipo == partido.getEquipo2()){
                   if(resultado == 'G'){ return 1; 
               
                   }else { return 0;}
               
            }
           }
               if(pa1 > pa2){
                           if(equipo == partido.getEquipo1()){
                                 if(resultado == 'G'){return 1; }
                                 else{ return 0;   }            
                           }
               }
                 if(resultado == 'E')
                 {
                          return 1;} 
                    else{ return 0;}  
                    }

   
    
           
    }
    
        
    


               
               
               
           
           
           
           
           
           
          

   



    
    
 

    
            
      
