/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadolibre;

import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author Damian Bruna
 */
public class MercadoLibre  {
    	

	public static byte nroPrimo(int nro) /*Calcula si el nro pasado como parametro es primo o no*/
  	{
		byte p = 1;
		int i = 2;

		while(p == 1 && i<nro)
		{
                    if (nro % i == 0) 
                    {
                        p = 0;
                    }
                    i++;
		}
		return p;
  	}


	public static void main(String[] args) 
	{            
		String auxI; 
                String nroCadena;
                int nroEntero;
		int j;
		byte posPrimo;
                byte posPrimoAux;
                ArrayList listaNros = new ArrayList();

		for (int i=1; i<=1000000; i=i+2) /*Recorre los nros impares*/
		{ 			
			auxI = Integer.toString(i);
			if(auxI.length()>1)
			{
				j=0;
				posPrimo = 1;
                                /*Filtra los nros que tienen digitos que no pueden ser primos*/
				while (j<auxI.length())
				{
                                    if((auxI.substring(j,j+1).equals("0")) || (auxI.substring(j,j+1).equals("2")) || (auxI.substring(j,j+1).equals("4")) || (auxI.substring(j,j+1).equals("6")) || (auxI.substring(j,j+1).equals("8")) || (auxI.substring(j,j+1).equals("5")))
                                    {
                                        posPrimo=0;	
                                    }
                                    j++;
				}
				if(posPrimo == 1)
				{                                                                        
                                    
                                    if(nroPrimo(i) == 1)
                                    {
                                        
                                        posPrimoAux = 1;
                                        /*Rota los nros para determinar si son primos*/
                                        for (j=0; j<auxI.length()-1; j++)
                                        {
                                            nroCadena = auxI.substring(1,auxI.length()) + auxI.substring(0,1);
                                            nroEntero = Integer.parseInt(nroCadena);
                                            if(nroPrimo(nroEntero) == 0)
                                            {
                                                posPrimoAux = 0;
                                            }                
                                        }                                        
                                        if(posPrimoAux == 1)
                                        {
                                            listaNros.add(auxI);
                                        }                                   
                                    }
				}
			}
		}
		  

		int numElementos = listaNros.size();
		System.out.println("La lista tiene "+numElementos+" elementos que son los siguientes:");

                Iterator<String> itera = listaNros.iterator();
                
		while(itera.hasNext())
		{
                    String elemento = itera.next();
                    System.out.println(elemento);
		}
	}
}

