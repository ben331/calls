package ui;
import java.util.Scanner;
import model.Empresa;
import model.LineaTelefonica;
import model.LineaBasica;
import model.LineaCelular;
import model.LineaVozIP;
public class Main
{
	private static Scanner reader = new Scanner(System.in);
	private static Empresa molestar= new Empresa();
	
	public static void main(String[]args)
	{
		int opcion=0;
		int opcion2=0;
		int opcion3=0;
		String nombreLinea="";
		int duracionLlamada=0;
		int tipoLlamada=0;
		
		
		System.out.println("Bienvenido al gestor de gastos");
		do
		{
			System.out.println("\n1.Lineas. \n2.Agregar Lineas \n3.Mostrar informacion de las lineas. \n4.Salir");
			opcion=reader.nextInt();
			
			switch(opcion)
			{
				case 1:
				do
				{
					System.out.println(molestar.mostrarLineas());
					System.out.println("\n1.Agregar llamada, \n2.Salir");
					opcion2=reader.nextInt();
					{
						switch(opcion2)
						{
							case 1:
							System.out.println("\nIngrese el nombre de la linea");
							nombreLinea=reader.next();
							System.out.println("\nIngrese la duración de la llamada");
							duracionLlamada=reader.nextInt();
							if(molestar.buscarLinea(nombreLinea) instanceof LineaBasica)
							{
								System.out.println("\nSe agregará una llamada local");
								molestar.addLlamadaALinea(duracionLlamada, nombreLinea, 1);
							}
							else if(molestar.buscarLinea(nombreLinea) instanceof LineaCelular)
							{
								System.out.println("\n1.Llamada Local. \n2.Llamada Celular");
								tipoLlamada=reader.nextInt();
								molestar.addLlamadaALinea(duracionLlamada, nombreLinea, tipoLlamada);
							}
							else if(molestar.buscarLinea(nombreLinea) instanceof LineaVozIP)
							{
								System.out.println("\n1.Llamada Local. \n2.Llamada Celular \n3.Llamada Larga Distancia");
								tipoLlamada=reader.nextInt();
								molestar.addLlamadaALinea(duracionLlamada, nombreLinea, tipoLlamada);
							}
						}
					}
				}while(opcion2!=2);
				break;
				
				case 2:
				System.out.println("\nEscriba el nombre de la linea a agregar");
				nombreLinea=reader.next();
				System.out.println("\n1.Linea Basica \n2.Linea Celular \n3.LineaVozIP");
				opcion3=reader.nextInt();
				switch(opcion3)
				{
					case 1:
					LineaBasica linea = new LineaBasica(nombreLinea);
					System.out.println(molestar.addLinea(linea));
					break;
					case 2:
					LineaCelular linea2 = new LineaCelular(nombreLinea);
					System.out.println(molestar.addLinea(linea2));
					break;
					case 3:
					LineaVozIP linea3 = new LineaVozIP(nombreLinea);
					System.out.println(molestar.addLinea(linea3));
					break;
				}
				break;
				
				case 3:
				System.out.println(molestar.infoTodasLineas());
				break;
			}
		}
		while(opcion!=4);
	}
}