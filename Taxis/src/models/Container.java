package models;

public class Container {
	
	static ListaOrdenada<Trayecto>trayectos=new ListaOrdenada<Trayecto>( 
			(Trayecto a,Trayecto b)->b.getIniciotrayecto().compareTo(a.getIniciotrayecto()));

	public static ListaOrdenada<Trayecto> getTrayectos() {
		return trayectos;
	}

	
	
					
			
			
			
			
			

}
