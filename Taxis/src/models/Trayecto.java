package models;

import org.joda.time.LocalTime;

public class Trayecto {
	
	private LocalTime iniciotrayecto;
	private LocalTime finaltrayecto;
	private float pago;
	
	public Trayecto(){}
	
	public Trayecto(LocalTime iniciotrayecto, LocalTime finaltrayecto, float pago) {
		super();
		this.iniciotrayecto = iniciotrayecto;
		this.finaltrayecto = finaltrayecto;
		this.pago = pago;
	}



	public LocalTime getIniciotrayecto() {
		return iniciotrayecto;
	}



	public LocalTime getFinaltrayecto() {
		return finaltrayecto;
	}



	public float getPago() {
		return pago;
	}



	public void setIniciotrayecto(LocalTime iniciotrayecto) {
		this.iniciotrayecto = iniciotrayecto;
	}



	public void setFinaltrayecto(LocalTime finaltrayecto) {
		this.finaltrayecto = finaltrayecto;
	}



	public void setPago(float pago) {
		this.pago = pago;
	}



	@Override
	public String toString() {
		return "Trayecto [iniciotrayecto=" + iniciotrayecto + ", finaltrayecto=" + finaltrayecto + ", pago=" + pago
				+ "]";
	}
	
	
	

}
