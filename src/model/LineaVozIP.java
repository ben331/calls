package model;
public class LineaVozIP extends LineaCelular
{
	private int precioLVozIP=80;
	private int llamadasVozIP=0;
	private int minutosLVozIP=0;
	
	public LineaVozIP(String nombreLinea)
	{
		super(nombreLinea);
		super.setPrecioCelular(7);
	}
	
	public String addLlamadaVozIP (int minutos)
	{
		llamadasVozIP++;
		minutosLVozIP+=minutos;
		return "Llamada agregada";
	}
	
	@Override
	public int calcularCostoLinea()
	{
		int costoLinea=0;
		costoLinea=super.calcularCostoLinea()+precioLVozIP*minutosLVozIP;
		return costoLinea;
	}
	
	@Override
	public String infoLinea()
	{
		String infoLinea="";
		infoLinea=super.infoLinea()+"\n\n"+llamadasVozIP+" llamadas larga Distancia: "+minutosLVozIP+" minutos."+"\nCosto= "+(calcularCostoLinea()-super.calcularCostoLinea());
		return infoLinea;
	}
}