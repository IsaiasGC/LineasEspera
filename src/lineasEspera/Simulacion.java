/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineasEspera;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;


/**
 *
 * @author Isaias
 */
public class Simulacion implements ActionListener{
    
    private final Interfaz interfaz;
    private int dias;//Los dias que se simularan
    
    public Simulacion(){
        interfaz=new Interfaz(this);
        interfaz.setVisible(true);
        reiniciarDatos();
    }
    public void simular(){
        reiniciarSimulacion();
        
        String cadena="\n\n";
        cadena+="Dia\tTina\tPeso\tPeso Acumulado\tMonto por pasar\n";
        
        
        setEstadisticas(cadena);
    }
    public double getPesoTina(){
        double num=Math.random();
        double peso;
        if(num<0.5)
            peso=190+Math.sqrt(800*num);
        else
            peso=230+Math.sqrt(800*(1-num));
        
        return peso;
    }
    public void reiniciarSimulacion(){
    }
    public void reiniciarDatos(){
        dias=3;
        interfaz.setDatos(dias);
    }
    public void setEstadisticas(String cadena){
        interfaz.setEstadisticas(cadena);
    }
    public void borrar(){
        reiniciarDatos();
        interfaz.setEstadisticas("");
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Simulacion();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("jugar")){
            simular();
        }else{
            if(e.getActionCommand().equals("cambiar")){
                interfaz.cambiar();
            }else{
                if(e.getActionCommand().equals("guardar")){
                    int v,w,x,y,z;
                    v=interfaz.getPersonas();
                    if(v!=-1){
                        dias=v;
                        interfaz.guardar();
                    }
                }else{
                    borrar();
                }
            }   
        }
    }
    
}
