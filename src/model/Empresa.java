package model;
public class Empresa
{
	private LineaTelefonica[] lineas = new LineaTelefonica[10];
	
	public Empresa(){}
	
	public String addLinea(LineaTelefonica linea)
	{
		String confirmacion="";
		boolean lineaEncontrada=false;
		for(int i=0; i<=lineas.length-1 && lineaEncontrada==false;i++)
		{
			confirmacion="La linea no se agregó. capacidad de lineas agotada";
			if(lineas[i]==null)
			{
				lineas[i]=linea;
				confirmacion="La linea se agregó correctamente";
				lineaEncontrada=true;
			}
		}
		return confirmacion;
	}
	
	public int calcularCostoTotal()
	{
		int costoTotal=0;
		for(int i=0; i<=lineas.length-1;i++)
		{
			if(lineas[i]!=null)
			{
				costoTotal+=lineas[i].calcularCostoLinea();
			}
		}
		return costoTotal;
	}
	
	public String infoTodasLineas()
	{
		String infLineasBasicas="";
		String infLineasCelular="";
		String infLineasVozIP="";
		String cadena="";
		for(int i=0; i<=lineas.length-1;i++)
		{
			if(lineas[i]!=null)
			{
				if(lineas[i] instanceof LineaBasica)
				{
					infLineasBasicas+=("Linea "+lineas[i].getName()+"\n"+((LineaBasica)lineas[i]).infoLinea());
				}
				else if(lineas[i] instanceof LineaCelular)
				{
					infLineasCelular+="Linea "+lineas[i].getName()+"\n"+((LineaCelular)lineas[i]).infoLinea();
				}
				else if(lineas[i] instanceof LineaVozIP)
				{
					infLineasVozIP+="Linea "+lineas[i].getName()+"\n"+((LineaVozIP)lineas[i]).infoLinea();
				}
				else
				{
					cadena="Error";
				}
			}
		}
		if((infLineasBasicas.equals("") && infLineasCelular.equals("")) && (infLineasVozIP.equals("")))
		{
			cadena="No se encontraron Lineas";
		}
		else
		{
			cadena=("\nCosto Total: "+calcularCostoTotal()+"\n\nLineas Básicas: \n\n"+infLineasBasicas+"\n\nLineas Celular: \n\n"+infLineasCelular+"Lineas VozIP: \n\n"+infLineasVozIP);
		}
		return cadena;
	}
	
	public String mostrarLineas()
	{
		String cadena="";
		for(int i=0; i<=lineas.length-1;i++)
		{
			if(lineas[i]!=null)
			{
				cadena+=lineas[i].getName();
			}
		}
		if(cadena.equals(""))
		{
			cadena="No se encontraron Lineas";
		}
		return cadena;
	}
	
	public String addLlamadaALinea(int minutos, String name, int tipoLlamada)
	{
		String confirmacion="No se agregó la llamada";
		for(int i=0; i<=lineas.length-1;i++)
		{
			if(lineas[i]!=null)
			{
				if(lineas[i].getName().equals(name))
				{
					switch(tipoLlamada)
					{
						case 1:
						confirmacion=((LineaBasica)lineas[i]).addLlamadaLocal(minutos);
						break;
						case 2:
						confirmacion=((LineaCelular)lineas[i]).addLlamadaCelular(minutos);
						break;
						case 3:
						confirmacion=((LineaVozIP)lineas[i]).addLlamadaVozIP(minutos);
						break;
					}
				}
			}
		}
		return confirmacion;
	}
	
	public LineaTelefonica buscarLinea(String name)
	{
		int index=-1;
		for(int i=0; i<=lineas.length-1;i++)
		{
			if(lineas[i]!=null)
			{
				if(lineas[i].getName().equals(name))
				{
					index=i;
				}
			}
		}
		return lineas[index];
	}
}