package cuentabancaria;

public class Cuenta
{
	private String nombre;
	private String cuenta;
	private double interes;
	private double saldo;
	
	
	public Cuenta(String nombre, String cuenta, double interes, double saldo)
	{
		this.interes = interes;
		ingreso(saldo);
		this.nombre = nombre;
		this.cuenta = cuenta;
	}
	//////////////////////////
	public Cuenta()
	{
	
	}
	//////////////////////////
	public Cuenta(Cuenta copia)
	{
		interes = copia.interes;
		nombre = copia.nombre;
		cuenta = copia.cuenta;
		saldo = copia.saldo;
		
	}
	//////////////////////////
	public String getNombre() 
	{
		return nombre;
	}
	//////////////////////////
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	//////////////////////////
	public String getCuenta() 
	{
		return cuenta;
	}
	//////////////////////////
	public void setCuenta(String cuenta) 
	{
		this.cuenta = cuenta;
	}
	//////////////////////////
	public double getInteres() 
	{
		return interes;
	}
	//////////////////////////
	public void setInteres(double interes) 
	{
		this.interes = interes;
	}
	//////////////////////////
	public double getSaldo() 
	{
		return saldo;
	}
	//////////////////////////
	public void ingreso(double cantidad)
	{
		if(cantidad > 0)
			saldo = saldo + cantidad;
		else
		{
			System.err.println("El ingreso debe ser mayor que 0");
		}
	}
	//////////////////////////
	public void reintegro(double cantidad)
	{
		if(cantidad > saldo)
		{
			System.err.println("El reintegro ha superado el saldo de la cuenta");
		}
		else 
		{
			if(cantidad > 0)
				saldo = saldo - cantidad;
			else
			{
				System.err.println("El reintegro debe ser mayor que 0");
			}
		}
	}
}