package cuentabancaria;

import java.util.Calendar;

public class CuentaAhorro extends Cuenta {

	
	private double cuotaMantenimiento;
	
	public CuentaAhorro (String nombre, String cuenta, double interes, double saldo, double cuota) { 
		
		super (nombre, cuenta, interes, saldo);
		
		this.cuotaMantenimiento = cuota;
		
	}
	public CuentaAhorro() {
		
	}

	public double getCuotaMantenimiento() {
		return cuotaMantenimiento;
	}

	public void setCuotaMantenimiento(double cuotaMantenimiento) {
		this.cuotaMantenimiento = cuotaMantenimiento;
	}
	
	//Esta es la copia de la cuenta de ahorros.
	public CuentaAhorro(CuentaAhorro copia) {
		
		super(copia.getNombre(),copia.getCuenta(),copia.getInteres(),copia.getSaldo());
		this.cuotaMantenimiento= copia.cuotaMantenimiento;
	}
	
	public void comisiones() {
	if (Calendar.DAY_OF_MONTH== 1 ) {
	this.reintegro(cuotaMantenimiento);	
	}
	}
	
	public double intereses()
	{
	double retornoInteres = 0.0;
	if(Calendar.DAY_OF_MONTH == 1) {
	retornoInteres = this.getSaldo() + this.getSaldo() * this.getInteres();
	}
	return retornoInteres;	
		
	}
	
}
