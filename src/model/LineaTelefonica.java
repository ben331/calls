package model;
public abstract class LineaTelefonica
{
	private String nombreLinea;
	
	public LineaTelefonica(String nombreLinea)
	{
		this.nombreLinea=nombreLinea;
	}
	
	public String getName()
	{
		return nombreLinea;
	}
	
	public abstract int calcularCostoLinea();
	public abstract String infoLinea();
}