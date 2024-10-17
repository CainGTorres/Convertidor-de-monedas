package Ejecutable;
import com.gabic.convertidordemonedas.convertidor.ConsultaDeApi;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {
  public static void main(String[] args) {
    

        double moneda;
        Scanner lectura = new Scanner(System.in);
        boolean menu = true;
        int  opcion;

        ConsultaDeApi consulta = new ConsultaDeApi();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create(); 

        while (menu){
  FileWriter escrituraArchivo = null;
            try{
              try{
                System.out.println(consulta.menu()); //muestro menu
                opcion = lectura.nextInt();
             
              }catch (InputMismatchException  e ) { //en caso de que ingrese un tipo de dato incorrecto
                System.out.println("Error: dato ingresado no valido. INGRESE OPCION CORRECTA: ");
                lectura.next();//limpio buffer
                opcion = lectura.nextInt();
              }
              FileWriter escrituraArchivotxt = null;
              try {
                escrituraArchivotxt = new FileWriter("Historial conversiones.txt",true);
              } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
              }
                escrituraArchivo = new FileWriter("HistorialConversiones.json",true); //creo el archivo donde voy a escribir
                LocalDateTime ahora = LocalDateTime.now();
                String hora = "Hora: " + ahora.getHour() + " : " + ahora.getMinute();
                String fecha = ahora.getDayOfMonth() + "/"+ahora.getMonthValue()+"/"+ahora.getYear();
                String consulta1; //guarda la informacion de la consulta
                switch(opcion) {
                  case 1 -> {
                      System.out.println("DÃ“LAR A PESO ARGERTINO--------------");
                      System.out.println("ingrese cantidad de dÃ³lares a convertir \n-> ");
                      moneda = lectura.nextDouble();

                    consulta1 = consulta.buscaDivisas("USD", "ARS", moneda).toString();
                    System.out.println(consulta1);
                    escrituraArchivotxt.write(fecha+"--"+hora + "\nCantidad a cambiar: $" + moneda +", " +  consulta1 + "\n\n");
                    escrituraArchivo.write(gson.toJson(fecha+"--"+hora + "\nCantidad a cambiar: $" + moneda +", " +  consulta1 + "\n\n"));
                    escrituraArchivotxt.close();
                    escrituraArchivo.close();
      }
                  case 2 -> {
                      System.out.println("PESO ARGERTINO A DÃ“LAR--------------");
                      System.out.println("ingrese cantidad de pesos argentinos a convertir en dÃ³lares: ");
                      moneda = lectura.nextDouble();
                    consulta1 = consulta.buscaDivisas("ARS", "USD", moneda).toString();
                    System.out.println(consulta1); //retorno funcion que realiza la conversion
                    escrituraArchivotxt.write(fecha+"--"+hora + "\nCantidad a cambiar: $" + moneda +", " +  consulta1 + "\n\n");
                    escrituraArchivo.write(gson.toJson(fecha+"--"+hora + "\nCantidad a cambiar: $" + moneda +", " +  consulta1 + "\n\n"));
                    escrituraArchivotxt.close();
                    escrituraArchivo.close();
      }
                    
                  case 3 -> {
                      System.out.println("DÃ“LAR A REAL BRASILERO--------------");
                      System.out.println("ingrese cantidad de dÃ³lares a convertir \n-> ");
                      moneda = lectura.nextDouble();
                    consulta1=consulta.buscaDivisas("USD", "BRL", moneda).toString();
                    System.out.println(consulta1); //retorno funcion que realiza la conversion
                    escrituraArchivotxt.write(fecha+"--"+hora + "\nCantidad a cambiar: $" + moneda +", " +  consulta1 + "\n\n");
                    escrituraArchivo.write(gson.toJson(fecha+"--"+hora + "\nCantidad a cambiar: $" + moneda +", " +  consulta1 + "\n\n"));
                    escrituraArchivotxt.close();
                    escrituraArchivo.close();
      }
                    
                  case 4 -> {
                      System.out.println("REAL BRASILERO A DOLAR--------------");
                      System.out.println("ingrese cantidad de Reales a convertir \n-> ");
                      moneda = lectura.nextDouble();
                    consulta1 = consulta.buscaDivisas("BRL", "USD", moneda).toString();
                    System.out.println(consulta1);
                    escrituraArchivotxt.write(fecha+"--"+hora + "\nCantidad a cambiar: $" + moneda +", " +  consulta1 + "\n\n");
                    escrituraArchivo.write(gson.toJson(fecha+"--"+hora + "\nCantidad a cambiar: $" + moneda +", " +  consulta1 + "\n\n"));
                    escrituraArchivotxt.close();
                    escrituraArchivo.close();
      }
                    
                  case 5 -> {
                    
                      System.out.println("DÃ“LAR A PESO COLOMBIANO--------------");
                      System.out.println("ingrese cantidad de DÃ³lares a convertir \n-> ");moneda = lectura.nextDouble();consulta1 = consulta.buscaDivisas("USD", "COP", moneda).toString();
                    System.out.println(consulta1); //retorno funcion que realiza la conversion
                    escrituraArchivotxt.write(fecha+"--"+hora + "\nCantidad a cambiar: $" + moneda +", " +  consulta1 + "\n\n");
                    escrituraArchivo.write(gson.toJson(fecha+"--"+hora + "\nCantidad a cambiar: $" + moneda +", " +  consulta1 + "\n\n"));
                    escrituraArchivotxt.close();
                    escrituraArchivo.close();
      }
                    
                  case 6 -> {
                      System.out.println("PESO COLOMBIANO A DÃ“LAR--------------");
                      System.out.println("ingrese cantidad de pesos colombianos a convertir \n-> ");
                      moneda = lectura.nextDouble();
                    consulta1 = consulta.buscaDivisas("COP", "USD", moneda).toString();
                    System.out.println(consulta1); //retorno funcion que realiza la conversion
                    escrituraArchivotxt.write(fecha+"--"+hora + "\nCantidad a cambiar: $" + moneda +", " +  consulta1 + "\n\n");
                    escrituraArchivo.write(gson.toJson(fecha+"--"+hora + "\nCantidad a cambiar: $" + moneda +", " +  consulta1 + "\n\n"));
                    escrituraArchivotxt.close();
                    escrituraArchivo.close();
      }
                    
                  case 9 -> {
                    System.out.println("---------------------------------------------------------------");
                    System.out.println("--------------SALIDA | JEO CONVERSOR DE MONEDAS---------------");
                    System.out.println("---------------------------------------------------------------");
                    menu = false;
      }
                }
            }catch (IOException  ex ) {                 Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
      try {
        escrituraArchivo.close();
      } catch (IOException ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
        }
      
    }
    }


