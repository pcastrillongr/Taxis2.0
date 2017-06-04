package models;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

public class Tiempo  {
	
    private static Timer timer = new Timer(); 
    private static int minutos=0;
    static JLabel lbltiempoaux;
    static JLabel lblprecioaux;
    private static float precio=0;
  
    
    
    
    //Clase interna que funciona como contador
   static class Contador extends TimerTask {
        public void run() {
        	
        	if(new LocalDate().getDayOfWeek()==6||new LocalDate().getDayOfWeek()==7){
            minutos++;
            
            
            lbltiempoaux.setText(String.format("%d minutos", minutos));
        
           
            
            	
            	precio=(float) (minutos*0.26);
            	
            	
            	lblprecioaux.setText(String.valueOf(precio));}
            	
            	
            	
            
        
        else{
        	minutos++;
            
            
            lbltiempoaux.setText(String.format("%d minutos", minutos));
        
           
            
            	
            	precio=(float) (minutos*0.18);
            	
            	
            	lblprecioaux.setText(String.valueOf(precio));}
        }
        
    }


    //Crea un timer, inicia segundos a 0 y comienza a contar
    public void Contar(JLabel lbltiempo2, JLabel lblprecio2)
    {
        minutos=0;
        timer = new Timer();
        timer.schedule(new Contador(), 0, 60000);
        lblprecioaux=lblprecio2;
        lbltiempoaux=lbltiempo2;
       
        
        
    }
    //Detiene el contador
    public void Detener() {
        timer.cancel();
    }
    //Metodo que retorna los segundos transcurridos
    public double getMin()
    {
        return minutos;
    }
    
    public int getSegundos()
    {
        return minutos*60;
    }
}