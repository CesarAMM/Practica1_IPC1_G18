
package practica_1_ipc_1;
public class Funciones_Cesar {
    
    public static String[] Mtriz_transpuesta(String strMatriz){
        String Matriz [][] = new String[strMatriz.split(";").length][strMatriz.split(";")[0].split(",").length];
        String MatrizTraspuerta [][] = new String[strMatriz.split(";")[0].split(",").length][strMatriz.split(";").length];
        String[] filas = strMatriz.split(";");
        String formatoHTML=""
                + "<div class='row pt-2'>"
                +"<h3>Matriz: 'Index' Calculo de la transpuesta</h3>"
                +"</div>"
                +"<div class='row'>"
                    + "<div class='col-6'>"
                +"<small>Matriz 'Index'</small>"
                        + "<table class='table table-striped table-bordered text-center fw-bold'>"
                                + "<tbody>"
                                + "tblMatriz_1"
                                + "</tbody>"
                            +"</table>"
                    + "</div>"
                    +"<div class='col-6'>"
                    +"Matriz transpuesta de 'Index'"
                        + "<table class='table table-striped table-bordered text-center fw-bold'>"
                                + "<tbody>"
                                + "tblMatriz_2"
                                + "</tbody>"
                            +"</table>"
                    + "</div>"
                + "</div>";
        String strTrTable_1 ="", strTrtable_2 ="";
        for (int i = 0; i < filas.length; i++) {
            for (int j = 0; j < filas[0].split(",").length; j++) {
                Matriz[i][j] = filas[i].split(",")[j];
            }
        }
        for (int i = 0; i < Matriz.length; i++) {
            for (int j = 0; j < Matriz[0].length; j++) {
                MatrizTraspuerta[j][i] = Matriz[i][j];
            }
        }

        String pintar="\nMatriz 'Index'\n";
        for (int i = 0; i < Matriz.length; i++) {
            strTrTable_1+= "<tr>";
            for (int j = 0; j < Matriz[0].length; j++) {
                strTrTable_1+= "<td>"+Matriz[i][j]+"</td>";
                pintar += "["+Matriz[i][j]+"]";
            }
            strTrTable_1+= "</tr>";
            pintar+= "\n";
        }
        pintar+= "\nMatriz Traspuesta de 'Index'\n\n";
        for (int i = 0; i < MatrizTraspuerta.length; i++) {
            strTrtable_2+= "<tr>";
            for (int j = 0; j < MatrizTraspuerta[0].length; j++) {
                strTrtable_2+= "<td>"+MatrizTraspuerta[i][j]+"</td>";
                pintar += "["+MatrizTraspuerta[i][j]+"]";
            }
            strTrtable_2+="</tr>";
            pintar+= "\n";
        }
        String[] datos = {pintar, CadenaMatriz(MatrizTraspuerta),formatoHTML.replace("tblMatriz_1", strTrTable_1).replace("tblMatriz_2", strTrtable_2)};
        return datos;
    }
    
    public static String[] MatrizInversa(String strMatriz){
        float [][] MA = new float[strMatriz.split(";").length][strMatriz.split(";")[0].split(",").length];
        float [][] MI = new float [strMatriz.split(";").length][strMatriz.split(";")[0].split(",").length];
        String dato[] ={"La matriz que ingreso no cuenta con las caracteristicas de nxn != "+strMatriz.split(";").length+""+strMatriz.split(";")[0].split(",").length+".",""};
        String strTable_1 ="", strTable_2="", strTable_3="", strTable_4 = "",strLista="", strFormatHtml = ""
                + "<div class='row pt-2'>"
                +"<h3>Matriz: 'Index' Calulo de la Invesa</h3>"
                +"</div>"
                +"<div class='row'>"
                    + "<div class='col-5'>"
                        +"<small>Matriz 'Index'</small>"
                        + "<table class='table table-striped table-bordered text-center fw-bold'>"
                                + "<tbody>"
                                + "tblMatriz_1"
                                + "</tbody>"
                            +"</table>"
                    + "</div>"
                    +"<div class='col-5'>"
                    +"Matriz Identidad de 'Index'"
                        + "<table class='table table-striped table-bordered text-center fw-bold'>"
                                + "<tbody>"
                                    + "tblMatriz_2"
                                + "</tbody>"
                            +"</table>"
                    + "</div>" 
                + "</div>"
                +"<div class='row'>"
                    + "<div class='col-5'>"
                        +"<small>Matriz Identidad</small>"
                        + "<table class='table table-striped table-bordered text-center fw-bold'>"
                                + "<tbody>"
                                + "tblMatriz_3"
                                + "</tbody>"
                            +"</table>"
                    + "</div>"
                    +"<div class='col-5'>"
                    +"<small>Matriz Inversa de la matriz 'Index'</small>"
                        + "<table class='table table-striped table-bordered text-center fw-bold'>"
                                + "<tbody>"
                                    + "tblMatriz_4"
                                + "</tbody>"
                            +"</table>"
                    + "</div>" 
                + "</div>"
                + "<div class='row'>"
                    +"<div class='col-6'>"
                        +"IndexProcedimiento"
                    + "</div>"
                + "</div>";
        if(MA.length == MA[0].length){
            //LLenado de las matrices
            for (int i = 0; i < MA.length; i++) {
                strTable_1 += "<tr>";
                strTable_2 += "<tr>";
                for (int j = 0; j < MA[0].length; j++) {
                    MA[i][j] = Float.parseFloat(strMatriz.split(";")[i].split(",")[j] );
                    strTable_1 += "<td>"+MA[i][j]+"<td>";
                    if(i == j){
                        MI[i][j] =1;
                        strTable_2 += "<td>"+MI[i][j]+"<td>";
                    }else{
                        MI[i][j] =0;
                        strTable_2 += "<td>"+MI[i][j]+"<td>";
                    }
                }
                strTable_1 += "</tr>";
                strTable_2 += "</tr>";
            }
            String pintar_1 ="", pintar_2="", pg="", strMA= "Matriz 'Index':\n", strMI="Matriz Identidad:\n";
            for (int i = 0; i < MA.length; i++) {
                for (int j = 0; j < MA.length; j++) {
                    strMA += "["+MA[i][j]+"]";
                    strMI += "["+MI[i][j]+"]";
                }
                strMA += "\n";
                strMI += "\n";
            }
            pg += strMA +"\n"+strMI + "\nInicio del Procedimiento:\n";
            float index =0, Aux=0;
            for (int i = 0; i < MA.length; i++) {
                index = MA[i][i];
                pintar_1= "En la fila "+(i+1)+": Matriz 'Index':('Index'/"+index+"') -> ";
                pintar_2= "En la fila "+(i+1)+": Matriz Identidad: (I/"+index+") -> ";
                for (int j = 0; j < MA.length; j++) {
                    pintar_1 += "["+String.format("%.2f", MA[i][j])+"/"+String.format("%.2f", index)+"]";
                    pintar_2 += "["+String.format("%.2f", MI[i][j])+"/"+String.format("%.2f", index)+"]";
                    MI[i][j]= MI[i][j]/index;
                    MA[i][j]= MA[i][j]/index;
                }
                pg += pintar_1 +"\n"+ pintar_2+ "\n";
                for (int j = 0; j < MA.length; j++) {
                    if(i != j){
                        Aux = MA[j][i];
                        pintar_1= "En la fila "+(j+1)+": Matriz 'Index':('Index'-("+String.format("%.2f", Aux)+"*'Index')) -> ";
                        pintar_2= "En la fila "+(j+1)+": Matriz Identidad: (I-("+String.format("%.2f", Aux)+")) -> ";
                        for (int k = 0; k < MA.length; k++) {
                            pintar_1 += "["+String.format("%.2f", MA[j][k])+"-("+String.format("%.2f", Aux)+" * "+String.format("%.2f", MA[i][k])+")]";
                            pintar_2 += "["+String.format("%.2f", MI[j][k])+"-("+String.format("%.2f", Aux)+" * "+String.format("%.2f", MI[i][k])+")]";
                            MA[j][k] = MA[j][k]-Aux*MA[i][k];
                            MI[j][k] = MI[j][k]-Aux*MI[i][k];
                        }
                        pg += pintar_1 +"\n"+ pintar_2+ "\n";
                    }
                }
            }
            strMA = "Matriz Identidad: \n";
            strMI = "Matriz 'Index' Invertida: \n";
            for (int i = 0; i < MA.length; i++) {
                for (int j = 0; j < MA.length; j++) {
                    strMA += "["+String.format("%.2f", MA[i][j])+"]";
                    strMI += "["+String.format("%.2f", MI[i][j])+"]";
                }
                strMA += "\n";
                strMI += "\n";
            }
            pg +="\n"+ strMA +"\n"+strMI+ "\n";
            String[][] strMinversa = new String[MI.length][MI.length];
            for (int i = 0; i < MI.length; i++) {
                for (int j = 0; j < MI.length; j++) {
                    strMinversa[i][j] = String.format("%.2f", MI[i][j]).replace(",", ".");
                }
            }
            dato[0] =pg;
            dato[1] = CadenaMatriz(strMinversa);
            return dato;
        }
        return dato; 
    }
    
    public static String[] Suma_Matrices(String strMatriz_A, String strMatriz_B){
        int fB = strMatriz_B.split(";").length;
        int cB = strMatriz_B.split(";")[0].split(",").length;
        int fA = strMatriz_A.split(";").length;
        int cA = strMatriz_A.split(";")[0].split(",").length;
        String strMR ="Suma de Matrices: 'Index_1' + 'Index_2':\n";
        String[] datos = {"",""};
        if(fB == fA && cA == cB){
            float[][] MR = new float[fB][cB];
            for (int i = 0; i < fA; i++) {
                for (int j = 0; j < cA; j++) {
                    float auxA =Float.parseFloat(strMatriz_A.split(";")[i].split(",")[j]);
                    float auxB =Float.parseFloat(strMatriz_B.split(";")[i].split(",")[j]);
                    MR[i][j] = auxA +auxB;
                    if(j == 0){
                        strMR += "[|"+strMatriz_A.split(";")[i].split(",")[j]+"|";
                    }else if (j > 0 && j < cB-1){
                        strMR += "|"+strMatriz_A.split(";")[i].split(",")[j]+"|";
                    }else if (j == cB-1){
                        strMR += "|"+strMatriz_A.split(";")[i].split(",")[j]+"|]";
                    }
                }
                if(cB%2==0 && ((cB-1)/2)==i){
                    strMR+="+";
                }else if(((cB-1)/2)==i){
                    strMR+="+";
                }
                for (int j = 0; j < fA; j++) {
                    if(j == 0){
                        strMR += "\t[|"+strMatriz_B.split(";")[i].split(",")[j]+"|";
                    }else if (j > 0 && j < cB-1){
                        strMR += "|"+strMatriz_B.split(";")[i].split(",")[j]+"|";
                    }else if (j == cB-1){
                        strMR += "|"+strMatriz_B.split(";")[i].split(",")[j]+"|]";
                    }
                }
                if(cB%2==0 && ((cB-1)/2)==i){
                    strMR+="=";
                }else if(((cB-1)/2)==i){
                    strMR+="=";
                }
                for (int j = 0; j < fA; j++) {
                    if(j == 0){
                        strMR += "\t[|"+strMatriz_A.split(";")[i].split(",")[j]+"+"+strMatriz_B.split(";")[i].split(",")[j]+"|";
                    }else if (j > 0 && j < cB-1){
                        strMR += "|"+strMatriz_A.split(";")[i].split(",")[j]+"+"+strMatriz_B.split(";")[i].split(",")[j]+"|";
                    }else if (j == cB-1){
                        strMR += "|"+strMatriz_A.split(";")[i].split(",")[j]+"+"+strMatriz_B.split(";")[i].split(",")[j]+"|]";
                    }
                }
                if(cB%2==0 && ((cB-1)/2)==i){
                    strMR+="=";
                }else if(((cB-1)/2)==i){
                    strMR+="=";
                }
                for (int j = 0; j < fA; j++) {
                    if(j == 0){
                        strMR += "\t[|"+MR[i][j]+"|";
                    }else if (j > 0 && j < cB-1){
                        strMR += "|"+MR[i][j]+"|";
                    }else if (j == cB-1){
                        strMR += "|"+MR[i][j]+"|]\n";
                    }
                }
            }
            datos[0] = strMR;
            String[][] strMS = new String[fA][cA];
            for (int i = 0; i < fA; i++) {
                for (int j = 0; j < cA; j++) {
                    strMS[i][j] = String.format("%.2f", MR[i][j]).replace(",", ".");
                }
            }
            datos[1] = CadenaMatriz(strMS);
            return datos;
        }else{
            datos[0] ="No se realiza operacion." +
                    "\n'Index_1' Filas=" + fA +" Columnas=" +cA +
                    "\n'Index_2' Filas="+fB+" Columnas="+cB; 
            return datos;
        }
    }
    
    public static String CadenaMatriz(String[][] matriz){
        String strMA="";
        for(int i = 0; i< matriz.length; i++){
            for (int j = 0; j < matriz[0].length; j++) {
                if(j < (matriz[0].length - 1)){
                    strMA+= matriz[i][j] +",";
                }else if(i < (matriz.length -1)){
                    strMA+= matriz[i][j]+";";
                }else{
                    strMA+= matriz[i][j];
                }
            }
        }
        return strMA;
    }  
    
    public static void PintarMatriz(float[][] intMatriz){
        for(int i = 0; i < intMatriz.length; i++){
                for (int j = 0; j < intMatriz[0].length; j++) {
                    System.out.print("["+intMatriz[i][j]+"]");
                }
                System.out.println("");
            }
    }
}
