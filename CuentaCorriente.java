package cuentabancaria;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CuentaCorriente extends Cuenta{ 

private int transacciones=0;
private double importePorTrans;
private int transExentas;

//Este es el constructor de cuenta corriente con los atributos de Cuenta + los suyos propios

public CuentaCorriente (String nombre, String cuenta, double interes, double saldo, double importeporTrans, int transExentas ) {
super (nombre, cuenta, interes, saldo);
this.importePorTrans= importeporTrans;
this.transExentas= transExentas;
}

public double getImportePorTrans() {
	return importePorTrans;
}

public void setImportePorTrans(double importePorTrans) {
	this.importePorTrans = importePorTrans;
}

public int getTransExentas() {
	return transExentas;
}

public void setTransExentas(int transExentas) {
	this.transExentas = transExentas;
}

public void decrementarTransacciones() {
	this.transacciones--;
}

public void ingreso(double cantidad) {
super.ingreso(cantidad);
this.transacciones++;

	
}

public void reintegro(double cantidad) {
this.transacciones++;
super.reintegro(cantidad);
	
}

public void comisiones() {
int trans_a_cobrar= this.transacciones - this.transExentas;

GregorianCalendar fecha = new GregorianCalendar();

if(fecha.get(Calendar.DAY_OF_MONTH) == 1) {
	
	if(trans_a_cobrar > 0) {
	
		super.reintegro(trans_a_cobrar * this.importePorTrans);
		
	}
	
	this.transacciones = 0;
	
}
}


public double intereses() {
	
	GregorianCalendar fecha = new GregorianCalendar();
	
	double intereses = 0.0;
	
	if(fecha.get(Calendar.DAY_OF_MONTH) == 1) {
		
		if(this.getSaldo() > 1800) {
			
			intereses = (1800*0.005 + (this.getSaldo()-1800)*(this.getInteres()/100))/12;
			
		}else {
			
			intereses = (this.getSaldo()*0.005)/12;
			
		}
		
		super.ingreso(intereses);
		
	}

	return intereses;
}
}