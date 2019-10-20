package model;
public class LineaBasica extends LineaTelefonica
{
	private final int PRECIOLLOCAL=35;
	private int llamadasLocales=0;
	private int minutosLLocales=0;
	
	public LineaBasica(String nombreLinea)
	{
		super(nombreLinea);
	}
	
	
	public String addLlamadaLocal(int minutos)
	{
		llamadasLocales++;
		minutosLLocales+=minutos;
		return "Llamada agregada";
	}
	
	public int calcularCostoLinea()
	{
		int costoLinea=0;
		costoLinea=PRECIOLLOCAL*minutosLLocales;
		return costoLinea;
	}
	
	public String infoLinea()
	{
		String infoLinea="";
		infoLinea="\n\n\n"+llamadasLocales+" llamadasLocales: "+minutosLLocales+" minutos."+"\nCosto= "+calcularCostoLinea();
		return infoLinea;
	}
}