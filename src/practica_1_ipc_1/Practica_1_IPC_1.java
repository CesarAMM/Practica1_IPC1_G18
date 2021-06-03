/*
    Cesar  Mazariegos 03/06/2021: modificaciones en el main para el menu
    Cristopher Mazariegos 
    Ana Ordóñez 02/06/20211
    Oscar Muz 
 */

//Modificiacion de git de prueba
//Modificiacion de git de prueba
//Modificiacion de git de prueba
//Modificiacion de git de prueba
//Modificiacion de git de prueba
//Modificiacion de git de prueba
//Modificiacion de git de prueba
package practica_1_ipc_1;

import java.io.File;
import java.util.Scanner;


public class Practica_1_IPC_1 {

    public static void main(String[] args) {
        int dato = 0;
        boolean estado = true;
        do{
            Scanner scanner;
            System.out.println(""
                        + "*******************************\n"
                        + "*1) Ingrese Archivo           *\n"
                        + "*2) Ver Matrices              *\n"
                        + "*3) Sumar Matrices            *\n"
                        + "*4) Resta de Matrices         *\n"
                        + "*5) Multiplicar Matrices      *\n"
                        + "*6) Dividir Matrices          *\n"
                        + "*7) Traspuesta de Matriz      *\n"
                        + "*8) Matriz Inversa            *\n"
                        + "*9) Potencia de una matriz    *\n"
                        + "*10) Determinate de una matriz*\n"
                        + "*11) Salir                    *\n"
                        + "*******************************\n");
            try {
                scanner = new Scanner(System.in);
                System.out.print("--> Ingrese un digito: ");
                dato = scanner.nextInt();
                switch(dato){
                    case 1:
                        String ruta = "";
                        do{
                            scanner = new Scanner(System.in);
                            System.out.print("----> Ingrese la ruta del archivo: ");
                            ruta = scanner.nextLine();
                            if(ruta.length() == 0){
                                System.out.println(""
                                        + "\n     |-----------------------|"
                                        + "\n     | No has ingresado nada |"
                                        + "\n     |-----------------------|");
                            }else{
                                LeerArchivo(ruta);
                            }
                        }while(ruta.length() == 0);
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        break;
                    default:
                        System.out.println("Has ingresado: " + dato + ", Es un rango incorrecto.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("\n     |--------------------------------------|");
                System.out.println("     |Error: " +e);
                System.out.println("     |Lo que ha ingresado no es un numero.  |");
                System.out.println("     |--------------------------------------|\n");
            }
        }while(estado);
    }
    
    public static void LeerArchivo(String ruta){
        try {
            Scanner input = new Scanner(new File(ruta));
            while (input.hasNextLine()){
                String line = input.nextLine();
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
