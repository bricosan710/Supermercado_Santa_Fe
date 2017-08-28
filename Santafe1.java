
import java.util.Scanner;
import java.util.*;


public class Santafe1
{
        public static void main(String args[]) {
            //por cada venta se le preguntara al vendedor la siguiente información:
        //Monto total de la venta.
        //Tipo de venta (1 si es de contado, 2 si es por tarjeta de credito y 3 si es por cuotas)
            
            //Comisión del 5% si es de contado.
        //Comisión del 3% si es con tarjeta de crédito.
        //Comisión del 2% si es por cuotas.
            
            //Programa que lea un número determinando de ventas y calcular y mostrar al FINAL la siguiente información:
        //Monto total de ventas. 
        //Monto total de ventas realizadas por tarjeta de crédito.
        //Monto total de ventas realizadas a cuotas.
        //Monto total de ventas realizadas de contados.
        //Monto total de todas las comisiones.
       
        int MontoVenta = 0;
        int Contado = 0;
        int Credito = 0;
        int Cuotas = 0;
        int NumeroCuotas;
        int VentaN;
        int TotalVentas = 0;
        int TotalVentasCredito = 0;
        int TotalVentasContados = 0;
        int TotalVentasCuotas = 0;
        double TotalComisiones;
        int respuesta= 0;
        int i = 0;
        int n;
        
        
        Scanner teclado = new Scanner(System.in);
          
        List<Venta> listaVentas = new ArrayList();
                
         while(respuesta != 2){
           System.out.println("Venta: " + (i+1));
           System.out.print("Monto total de venta: ");
           MontoVenta = teclado.nextInt();
           System.out.println("Medio de pago: ");
           System.out.println("1. Contado ");
           System.out.println("2. Crédito ");
           System.out.println("3. Cuotas ");   
           
           System.out.print("Elige una opción del menu :");
           n = teclado.nextInt();
                    
            
           switch (n)
           {
               case 1:
               System.out.println("Has elegido la opción 1");
               break;
               case 2:
               System.out.println("Has elegido la opción 2");
               break;
               case 3:
               System.out.println("Has elegido la opción 3");
               break;
               default:
               System.out.println("Has elegido la opción 4");
               break;
            }
            
            if(n == 3){
                System.out.println(" Número de cuotas que desea dividir? ");
                NumeroCuotas = teclado.nextInt();
            }
            else{
                NumeroCuotas = 0;
            }
             
            Venta ventaX = new Venta();
            
            ventaX.set(MontoVenta, n, NumeroCuotas);
            i = i+1;
            listaVentas.add(ventaX);
            
            System.out.println("¿Desea registrar nueva venta (S=1/N=2)? ");
            boolean seguir = false;
            
            while(seguir == false){
            respuesta = teclado.nextInt();
            if (respuesta == 1 || respuesta == 2 ){
            seguir = true;
            }
           }
        }
            
        
        
            for(Venta ventaX: listaVentas){
            TotalVentas=TotalVentas+ventaX.Monto;
                if (ventaX.Tipo ==1){
                TotalVentasContados = TotalVentasContados+ventaX.Monto;
                }
                if (ventaX.Tipo ==2){
                TotalVentasCredito = TotalVentasCredito+ventaX.Monto;
                }
                if (ventaX.Tipo ==3){
                TotalVentasCuotas = TotalVentasCuotas+ventaX.Monto;
                }
            }
                System.out.println("Numero de ventas: " + i);
                System.out.println("Total ventas: " + TotalVentas);
                System.out.println("TotalVentasContados: " + TotalVentasContados);
                System.out.println("TotalVentasCredito: " + TotalVentasCredito);
                System.out.println("TotalVentasCuotas: " + TotalVentasCuotas);
                double comi = hallarcomision(listaVentas);
                System.out.println("TotalComisiones: " + comi);
      }
      
      public static double hallarcomision(List<Venta> TotalVentas) {
       
         double Comisiones = 0;
       
         for(Venta ventasX: TotalVentas){
            
                if (ventasX.Tipo ==1){
                Comisiones = Comisiones+(ventasX.Monto * 0.05);
                }
                if (ventasX.Tipo ==2){
                Comisiones = Comisiones+(ventasX.Monto * 0.03);
                }
                if (ventasX.Tipo ==3){
                Comisiones = Comisiones+(ventasX.Monto * 0.02);
                }
            }
        
            return Comisiones;
        
        
      }
          
      }
         
      




