/*
    Cesar  Mazariegos 
    Cristopher Mazariegos Multiplicar  yDividir
    Ana Ordóñez Sumar yResta
    Oscar Muz 
 */

package practica_1_ipc_1;

import java.io.File;
import java.util.Scanner;


public class Practica_1_IPC_1 {
    public static void main(String[] args) {
        int dato = 0;
        boolean estado = true;
        String[][] matriz = new String[26][2];
        do{
            boolean error = true;
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
            } catch (Exception e) {
                error= false;
                System.out.println("\n     |--------------------------------------|");
                System.out.println("     |Error: " +e);
                System.out.println("     |Lo que ha ingresado no es un numero.  |");
                System.out.println("     |--------------------------------------|\n");
            }
            if(error){
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
                                matriz = LeerArchivo(ruta);
                            }
                        }while(ruta.length() == 0);
                        break;
                    case 2:
                        Ver_Matrices(matriz);
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
            }
        }while(estado);
    }
    
    public static String[][] LeerArchivo(String ruta){
        String Cadena="";
        int Filas =0;
        try {
            Scanner input = new Scanner(new File(ruta));
            while (input.hasNextLine()){
                Filas++;
                Cadena = Cadena + input.nextLine() +"\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String Matrices[][] = new String[Filas][2];
        for (int i = 0; i < Filas; i++) {
            String nombre = Cadena.split("\n")[i].split(":")[0];//Nombre de la Matriz
            String matrizAux = Cadena.split("\n")[i].split(":")[1].replace(" ", "");//La matriz
            String[] auxFila = matrizAux.split(";");//Obtego las filas por la separacion de ;
            int contador =0;
            int colum = auxFila[0].split(",").length;
            for (int j = 0; j < auxFila.length; j++) {
                int columAux = auxFila[j].split(",").length;
                if(colum == columAux){
                    contador++;
                }
            }
            if(contador == auxFila.length){
                for (int j = 0; j < 26; j++) {
                    if(Matrices[j][0] != null){
                        if(Matrices[j][0].equals(nombre)){
                            Matrices[j][1] = matrizAux;
                            break;
                        }
                    }else{
                        Matrices[j][0] = nombre;
                        Matrices[j][1] = matrizAux;
                        break;
                    }
                }
            }else{
                System.out.println("La matriz: "+ nombre +". No pudo se ingresada");
            }
        }        
        return Matrices;
    }
    
    public static void Ver_Matrices(String[][] matriz){
        for(int i = 0; i < matriz.length; i++){
            if(matriz[i][0] != null){
                String pintar = "", cadena= "";
                cadena = matriz[i][1];
                String[] auxFilas = cadena.split(";");
                pintar = matriz[i][0] + "\n";
                for (int j = 0; j < auxFilas.length; j++) {
                    String[] auxColumnas = auxFilas[j].split(",");
                    for (int k = 0; k < auxColumnas.length; k++) {
                        pintar += "|"+auxColumnas[k]+"| ";
                    }
                    pintar += "\n";
                }
                System.out.println("Matriz: " + pintar);
            }
        }
    }
}

//C:\Users\cesar.monroy\Desktop\ipc\Prueba.txt