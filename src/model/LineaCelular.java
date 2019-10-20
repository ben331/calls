package model;
public class LineaCelular extends LineaBasica
{
	private int precioLCelular=10;
	private int llamadasCelular=0;
	private int minutosLCelular=0;
	
	public LineaCelular(String nombreLinea)
	{
		super(nombreLinea);
	}
	
	public void setPrecioCelular(int precioCelular)
	{
		this.precioLCelular=precioCelular;
	}
	
	public String addLlamadaCelular (int minutos)
	{
		llamadasCelular++;
		minutosLCelular+=minutos;
		return "Llamada agregada";
	}
	
	@Override
	public int calcularCostoLinea()
	{
		int costoLinea=0;
		costoLinea=super.calcularCostoLinea()+precioLCelular*minutosLCelular;
		return costoLinea;
	}
	
	@Override
	public String infoLinea()
	{
		String infoLinea="";
		infoLinea=super.infoLinea()+"\n\n"+llamadasCelular+" llamadas Celulares: "+minutosLCelular+" minutos."+"\nCosto= "+(calcularCostoLinea()-super.calcularCostoLinea());
		return infoLinea;
	}
}