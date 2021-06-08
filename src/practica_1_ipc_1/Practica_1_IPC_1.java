/*
    Cesar  Mazariegos 
    Cristopher Mazariegos Multiplicar  yDividir
    Ana Ordóñez Sumar yResta
    Oscar Muz 
 */

package practica_1_ipc_1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import static practica_1_ipc_1.Funciones_Cesar.*;

public class Practica_1_IPC_1 {
    public static void main(String[] args) {
        int dato = 0;
        String strRepote ="<h1>Reporte</h1>";
        boolean estado = true;
        String[][] matriz = new String[27][2];
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
                        + "*11) Generar Reporte          *\n"
                        + "*12) Salir                    *\n"
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
                        String SMA, strMA;
                        String SMB, strMB;
                        do{
                            SMA = "";
                            scanner = new Scanner(System.in);
                            System.out.print("--> Ingrese la matriz 1: ");
                            SMA = scanner.nextLine();
                            strMA = ValidarMatriz(matriz, SMA); 
                        }while(strMA.length() == 0);
                        do{
                            SMB = "";
                            scanner = new Scanner(System.in);
                            System.out.print("--> Ingrese la matriz 2: ");
                            SMB = scanner.nextLine();
                            strMB = ValidarMatriz(matriz, SMB); 
                        }while(strMB.length() == 0);
                        String strMSR[] = Suma_Matrices(strMA,strMB);
                        strRepote+="\n"+strMSR[2].replace("Index_1", SMA).replace("Index_2", SMB)+"<hr>";
                        System.out.println(strMSR[0].replace("Index_1", SMA).replace("Index_2", SMB));
                        if(strMSR[1].length() != 0){
                            matriz[26][0] ="R";
                            matriz[26][1] = strMSR[1];
                        }
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        String strMTR;
                        String indice;
                        do{
                            indice = "";
                            scanner = new Scanner(System.in);
                            System.out.print("--> Ingrese la matriz: ");
                            indice = scanner.nextLine();
                            strMTR = ValidarMatriz(matriz, indice); 
                        }while(strMTR.length() == 0);
                        String strMCRT[] = Mtriz_transpuesta(strMTR);
                        System.out.println(strMCRT[0].replace("Index", indice));
                        strRepote+= "\n"+strMCRT[2].replace("Index", indice)+"<hr>";
                        if(strMCRT[1].length()!=0){
                            matriz[26][0] = "R";
                            matriz[26][1] = strMCRT[1];
                        }
                        break;
                    case 8:
                        String strMIR;
                        String index;
                        do{
                            index ="";
                            scanner = new Scanner(System.in);
                            System.out.print("--> Ingrese la matriz: ");
                            index = scanner.nextLine();
                            strMIR = ValidarMatriz(matriz, index); 
                        }while(strMIR.length() == 0);
                        String[] strMCIR =MatrizInversa(strMIR);
                        System.out.println(strMCIR[0].replace("Index", index));
                        strRepote+= strMCIR[2].replace("Index", index);
                        if(strMCIR[1].length() != 0){
                            matriz[26][0] = "R";
                            matriz[26][1] = strMCIR[1];
                        }
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        String ArcchivoHTML = ""
                                + "<!DOCTYPE html>\n" +"<html lang=\"en\">\n" +"<head>\n"
                                + "<meta charset=\"UTF-8\">\n"
                                + "<meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
                                    "<meta http-equiv='X-AU-Compatible' content='ie=edge'>\n" +
                                    "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x\" crossorigin=\"anonymous\">\n" +
                                    "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4\" crossorigin=\"anonymous\"></script>\n" +
                                    "<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.0/css/all.css\" integrity=\"sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ\" crossorigin=\"anonymous\"/>\n" +
                                    "<title>Reporte</title>" +
                                "</head>\n" +
                                "<body class=\"bg-light mb-3 container-fluid\">"
                                + ""+strRepote+""
                                + "</body>\n" +
                                "</html>";
                        File f = new File("Reporte.html");
                        if(!f.exists()){
                            try {
                                f.createNewFile();
                            } catch (IOException e) {
                                System.out.println(e);
                            }
                        }
                        try {
                            FileWriter file = new FileWriter(f);
                            BufferedWriter bw = new BufferedWriter(file);
                            bw.write(ArcchivoHTML);
                            bw.close();
                            System.out.println("Se a genereado el reporte");
                        } catch (Exception e) {
                        }
                        break;
                    case 12:
                        estado = false;
                        System.out.println("\n\t\t"
                                + "*******************************\n\t\t"
                                + "**Gracias Por Participar     **\n\t\t"
                                + "*******************************\n");
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
            System.out.println(e);
        }
        String Matrices[][] = new String[27][2];
        if(Cadena.length() != 0){
            for (int i = 0; i < Filas; i++) {
                String nombre = Cadena.split("\n")[i].split(":")[0].trim();//Nombre de la Matriz
                String matrizAux = Cadena.split("\n")[i].split(":")[1].replace(" ", "");//La matriz
                String[] auxFila = matrizAux.split(";");//Obtego las filas por la separacion de ;
                int contador =0;
                int colum = auxFila[0].split(",").length;//Obtengo la cantidad de columnas del primera fila
                //Para comparar que sea una matriz de n*n
                for (int j = 0; j < auxFila.length; j++) {//Recoro la matriz
                    int columAux = auxFila[j].split(",").length;//Obtengo la contidad de columnas conforme se mueve en las filas
                    if(colum == columAux){//Compara la contidad de comlumnas de *colum* con *columAux*
                        contador++;
                    }
                }
                if(contador == auxFila.length){//Comparar que contador sea igual que las filas
                    //Iniciamos a buscar en el vector si ya existe el valor
                    if(!nombre.equalsIgnoreCase("r")){
                        for (int j = 0; j < 26; j++) {
                            if(Matrices[j][0] != null){//Comparar si no esta vacio
                                if(Matrices[j][0].equals(nombre)){//Comparamos si es el mismo nombre
                                    Matrices[j][1] = matrizAux;
                                    break;
                                }
                            }else{//Dado caso que si este vacio, lo almacenamos
                                Matrices[j][0] = nombre;
                                Matrices[j][1] = matrizAux;
                                break;
                            }
                        }
                    }else{
                        Matrices[26][0] = nombre;
                        Matrices[26][1] = matrizAux;
                    }
                }else{
                    System.out.println("La matriz: "+ nombre +". No pudo se ingresada");
                }
            }
        }else{
            System.out.println("El archivo esta vacio.");
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
    
    public static String ValidarMatriz(String[][] matriz, String i){
        for (int j = 0; j < matriz.length; j++) {
            if(matriz[j][0] != null && matriz[j][0].equals(i)){
               return matriz[j][1];
            }
        }
        System.out.println("La matriz no existe.");
        return "";
    }
}

//C:\Users\cesar.monroy\Desktop\ipc\Prueba.txt