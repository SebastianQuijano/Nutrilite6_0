/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

/**
 *
 * @author Erick
 */
public class ListaPreguntas {
    
    private static String[] estiloDeVida;
    private static String[] habitosAlimenticios;
    private static int[][] respuestasCicloDeVida;
    private static int[][] respuestasEstiloDeVida;
    private static int[][] respuestasHabitosAlimenticios;
    private static int[] respuestasCuestionario;
    
    public static String[] getEstiloDeVida(char sexo, int edad) {
        if (estiloDeVida == null)
            llenarEstiloDeVida();
        String[] listaAux;
        int count = 0;
        switch (definirCicloDeVida(sexo, edad)){
            case 1:
                listaAux = new String[15];
                for (int i = 0; i < 25; i++) {
                    if ((i != 1) && (i != 3) && (i != 5) && (i != 6) && (i != 11) && (i != 15) && (i != 16) && (i != 18) && (i != 19) && (i != 20)) {
                        listaAux[count] = estiloDeVida[i];
                        count++;
                    }
                }
                break;
            case 2:
                listaAux = new String[21];
                for (int i = 0; i < 25; i++) {
                    if ((i != 5) && (i != 6) && (i != 15) && (i != 16)) {
                        listaAux[count] = estiloDeVida[i];
                        count++;
                    }
                }
                break;
            case 3:
                listaAux = new String[23];
                for (int i = 0; i < 25; i++) {
                    if ((i != 2) && (i != 16)) {
                        listaAux[count] = estiloDeVida[i];
                        count++;
                    }
                }
                break;
            case 4:
                listaAux = new String[20];
                for (int i = 0; i < 25; i++) {
                    if ((i != 1) && (i != 2) && (i != 3) && (i != 5) && (i != 16)) {
                        listaAux[count] = estiloDeVida[i];
                        count++;
                    }
                }
                break;
            case 5:
                listaAux = new String[23];
                for (int i = 0; i < 25; i++) {
                    if ((i != 2) && (i != 16)) {
                        listaAux[count] = estiloDeVida[i];
                        count++;
                    }
                }
                break;
            case 6:
                listaAux = new String[20];
                for (int i = 0; i < 25; i++) {
                    if ((i != 1) && (i != 2) && (i != 3) && (i != 5) && (i != 16)) {
                        listaAux[count] = estiloDeVida[i];
                        count++;
                    }
                }
                break;
            case 7:
                listaAux = new String[24];
                for (int i = 0; i < 25; i++) {
                    if ((i != 2)) {
                        listaAux[count] = estiloDeVida[i];
                        count++;
                    }
                }
                break;
            case 8:
                listaAux = new String[20];
                for (int i = 0; i < 25; i++) {
                    if ((i != 1) && (i != 2) && (i != 3) && (i != 5) && (i != 16)) {
                        listaAux[count] = estiloDeVida[i];
                        count++;
                    }
                }
                break;
            case 9:
                listaAux = new String[24];
                for (int i = 0; i < 25; i++) {
                    if ((i != 2)) {
                        listaAux[count] = estiloDeVida[i];
                        count++;
                    }
                }
                break;
            default:
                listaAux = new String[20];
                for (int i = 0; i < 25; i++) {
                    if ((i != 1) && (i != 2) && (i != 3) && (i != 5) && (i != 16)) {
                        listaAux[count] = estiloDeVida[i];
                        count++;
                    }
                }
                break;
        }
        return listaAux;
    }
    
    public static String[] getHabitosAlimenticios() {
        if (habitosAlimenticios == null)
            llenarHabitosAlimenticios();
        return habitosAlimenticios;
    }
    
    public static int[] getRespuestasCicloDeVida(char sexo, int edad) {
        if (respuestasCicloDeVida == null)
            llenarRespuestasCicloDeVida();
        
        switch (definirCicloDeVida(sexo, edad)) {
            case 1:
                return respuestasCicloDeVida[0];
            case 2:
                return respuestasCicloDeVida[1];
            case 3:
                return respuestasCicloDeVida[2];
            case 4:
                return respuestasCicloDeVida[3];
            case 5:
                return respuestasCicloDeVida[4];
            case 6:
                return respuestasCicloDeVida[5];
            case 7:
                return respuestasCicloDeVida[6];
            case 8:
                return respuestasCicloDeVida[7];
            default:
                return respuestasCicloDeVida[8];
        }
    }
    
    public static int[][] getRespuestasEstiloDeVida() {
        if (respuestasEstiloDeVida == null)
            llenarRespuestasEstiloDeVida();
        return respuestasEstiloDeVida;
    }
    
    public static int[][] getRespuestasHabitosAlimenticios() {
        if (respuestasHabitosAlimenticios == null)
            llenarRespuestasHabitosAlimenticios();
        return respuestasHabitosAlimenticios;
    }
    
    public static int[] getRespuestasCuestionario() {
        return respuestasCuestionario;
    }
    
    public static void marcarRespuestasCuestionario(int index) {
        if (respuestasCuestionario == null)
            vaciarRespuestasCuestionario();
        respuestasCuestionario[index-1]++;
    }
    
    private static void llenarEstiloDeVida() {
        estiloDeVida = new String[25];
        
        estiloDeVida[0] = "Se ha sometido a mas de dos programas de control de calorias en los ultimos dos meses";
        estiloDeVida[1] = "Planea embarazarse o está embarazada";
        estiloDeVida[2] = "Esta lactando";
        estiloDeVida[3] = "Usa anticonceptivos orales y ha tenido SPM";
        estiloDeVida[4] = "Se encuentra en recuperacion post-operatoria";
        estiloDeVida[5] = "Usa dispositivo intrauterino";
        estiloDeVida[6] = "Hace ejercicio en el gimnasio minimo 4 veces por semana";
        estiloDeVida[7] = "Es vegetariano (no consume carnes, huevos, lacteos)";
        estiloDeVida[8] = "Tiene problemas al masticar y/o digerir alimentos";
        estiloDeVida[9] = "Fuma, vive con un fumador o en una ciudad contaminada";
        estiloDeVida[10] = "Acostumbra a correr, nadar, escaladora y caminadora 4 veces a la semana";
        estiloDeVida[11] = "Frecuentemente le cuesta trabajo concentrarse o recordar cosas";
        estiloDeVida[12] = "Tiene problemas para dormir";
        estiloDeVida[13] = "Toma medicamentos de forma regular";
        estiloDeVida[14] = "No consume suficiente fibra como para tener una buena digestion";
        estiloDeVida[15] = "Toma de una a dos copas de alcohol al dia";
        estiloDeVida[16] = "Se encuentra en la etapa de la menopausia";
        estiloDeVida[17] = "Le gustaria llevar a cabo un programa de control de calorias";
        estiloDeVida[18] = "Esta sometido a altos niveles de estres";
        estiloDeVida[19] = "Trabaja mas de 8 horas al dia";
        estiloDeVida[20] = "Duerme menos de 8 horas al dia";
        estiloDeVida[21] = "Consume frecuentemente cafe, refresco ed cola, chocolate y te";
        estiloDeVida[22] = "Suele consumir alimentos frios, capeados, y/o empanizados mas de 2 veces a la semana";
        estiloDeVida[23] = "Constantemente siente cansancio";
        estiloDeVida[24] = "Consume comida rapida por lo menos 2 veces por semana";
    }
    
    private static void llenarHabitosAlimenticios() {
        habitosAlimenticios = new String[27];
        
        habitosAlimenticios[0] = "Una taza de leche, yogurt o jocoque";
        habitosAlimenticios[1] = "Una taza de avena o cereal integral (cereal de caja)";
        habitosAlimenticios[2] = "Una o dos rebanadas de pan integral o tortilla de maiz";
        habitosAlimenticios[3] = "Un huevo y/o tocino y/o jamon y/o salchicha";
        habitosAlimenticios[4] = "Una taza de jugo natural (naranja, toronja, zanahoria, etc)";
        habitosAlimenticios[5] = "Una o dos tazas de frutas color anaranjado y/o rojo";
        habitosAlimenticios[6] = "Una o dos frutas a media mañana con cascara (manzana, pera, guayaba)";
        habitosAlimenticios[7] = "Galletas y cafe con azucar";
        habitosAlimenticios[8] = "Un plato de sopa o crema de verduras";
        habitosAlimenticios[9] = "Una taza de arroz, pasta o papas con cascara";
        habitosAlimenticios[10] = "Una taza de frijol, haba, lenteja, chicharo, soya o garbanzo";
        habitosAlimenticios[11] = "Mas de 90gr. de carne roja, cerdo, pollo con piel, visceras (menudencias)";
        habitosAlimenticios[12] = "Por lo menos 90gr. de carne magra, pescado o mariscos (la palma de su mano)";
        habitosAlimenticios[13] = "Acompaña el plato principal con verduras cocidas (color intenso)";
        habitosAlimenticios[14] = "Dos puños de cacahuate, nueces, almendras o aceite de maiz, girasol";
        habitosAlimenticios[15] = "Un puño de fruta seca, charal o sardinas";
        habitosAlimenticios[16] = "Un plato promedio de verduras frescas de diferentes colores";
        habitosAlimenticios[17] = "Una o dos frutas citricas o de color intenso";
        habitosAlimenticios[18] = "Pastel, flan, gelatina, caramelos";
        habitosAlimenticios[19] = "Dos latas de refresco de cola al dia";
        habitosAlimenticios[20] = "Una o dos tortillas de maiz o pan integral";
        habitosAlimenticios[21] = "60gr. de queso fresco panela, requeson, etc";
        habitosAlimenticios[22] = "Una o dos tazas de yogurt o leche";
        habitosAlimenticios[23] = "Una o dos piezas de pan dulce, pastel o galletas dulces";
        habitosAlimenticios[24] = "Es intolerante a la leche o lacteos";
        habitosAlimenticios[25] = "Acostumbra alimentarse con cuatro comidas rapidas a la semana";
        habitosAlimenticios[26] = "Omite por lo menos cuatro comidas a la semana";
    }
    
    private static void llenarRespuestasCicloDeVida() {
        respuestasCicloDeVida = new int[9][];
        
        respuestasCicloDeVida[0] = new int[10];
        respuestasCicloDeVida [0][0] = 1;
        respuestasCicloDeVida [0][1] = 3;
        respuestasCicloDeVida [0][2] = 4;
        respuestasCicloDeVida [0][3] = 5;
        respuestasCicloDeVida [0][4] = 6;
        respuestasCicloDeVida [0][5] = 9;
        respuestasCicloDeVida [0][6] = 12;
        respuestasCicloDeVida [0][7] = 14;
        respuestasCicloDeVida [0][8] = 18;
        respuestasCicloDeVida [0][9] = 23;
        respuestasCicloDeVida[1] = new int[11];
        respuestasCicloDeVida [1][0] = 1;
        respuestasCicloDeVida [1][1] = 3;
        respuestasCicloDeVida [1][2] = 4;
        respuestasCicloDeVida [1][3] = 5;
        respuestasCicloDeVida [1][4] = 6;
        respuestasCicloDeVida [1][5] = 7;
        respuestasCicloDeVida [1][6] = 12;
        respuestasCicloDeVida [1][7] = 14;
        respuestasCicloDeVida [1][8] = 18;
        respuestasCicloDeVida [1][9] = 19;
        respuestasCicloDeVida [1][10] = 23;
        respuestasCicloDeVida[2] = new int[13];
        respuestasCicloDeVida [2][0] = 1;
        respuestasCicloDeVida [2][1] = 2;
        respuestasCicloDeVida [2][2] = 3;
        respuestasCicloDeVida [2][3] = 6;
        respuestasCicloDeVida [2][4] = 7;
        respuestasCicloDeVida [2][5] = 8;
        respuestasCicloDeVida [2][6] = 11;
        respuestasCicloDeVida [2][7] = 12;
        respuestasCicloDeVida [2][8] = 13;
        respuestasCicloDeVida [2][9] = 14;
        respuestasCicloDeVida [2][10] = 17;
        respuestasCicloDeVida [2][11] = 18;
        respuestasCicloDeVida [2][12] = 23;
        respuestasCicloDeVida[3] = new int[12];
        respuestasCicloDeVida [3][0] = 2;
        respuestasCicloDeVida [3][1] = 3;
        respuestasCicloDeVida [3][2] = 6;
        respuestasCicloDeVida [3][3] = 7;
        respuestasCicloDeVida [3][4] = 8;
        respuestasCicloDeVida [3][5] = 11;
        respuestasCicloDeVida [3][6] = 12;
        respuestasCicloDeVida [3][7] = 13;
        respuestasCicloDeVida [3][8] = 14;
        respuestasCicloDeVida [3][9] = 17;
        respuestasCicloDeVida [3][10] = 18;
        respuestasCicloDeVida [3][11] = 23;
        respuestasCicloDeVida[4] = new int[11];
        respuestasCicloDeVida [4][0] = 2;
        respuestasCicloDeVida [4][1] = 6;
        respuestasCicloDeVida [4][2] = 8;
        respuestasCicloDeVida [4][3] = 11;
        respuestasCicloDeVida [4][4] = 12;
        respuestasCicloDeVida [4][5] = 13;
        respuestasCicloDeVida [4][6] = 17;
        respuestasCicloDeVida [4][7] = 19;
        respuestasCicloDeVida [4][8] = 21;
        respuestasCicloDeVida [4][9] = 22;
        respuestasCicloDeVida [4][10] = 23;
        respuestasCicloDeVida[5] = new int[12];
        respuestasCicloDeVida [5][0] = 2;
        respuestasCicloDeVida [5][1] = 3;
        respuestasCicloDeVida [5][2] = 5;
        respuestasCicloDeVida [5][3] = 6;
        respuestasCicloDeVida [5][4] = 7;
        respuestasCicloDeVida [5][5] = 8;
        respuestasCicloDeVida [5][6] = 17;
        respuestasCicloDeVida [5][7] = 18;
        respuestasCicloDeVida [5][8] = 19;
        respuestasCicloDeVida [5][9] = 20;
        respuestasCicloDeVida [5][10] = 22;
        respuestasCicloDeVida [5][11] = 23;
        respuestasCicloDeVida[6] = new int[18];
        respuestasCicloDeVida [6][0] = 1;
        respuestasCicloDeVida [6][1] = 2;
        respuestasCicloDeVida [6][2] = 3;
        respuestasCicloDeVida [6][3] = 6;
        respuestasCicloDeVida [6][4] = 7;
        respuestasCicloDeVida [6][5] = 8;
        respuestasCicloDeVida [6][6] = 9;
        respuestasCicloDeVida [6][7] = 11;
        respuestasCicloDeVida [6][8] = 12;
        respuestasCicloDeVida [6][9] = 13;
        respuestasCicloDeVida [6][10] = 14;
        respuestasCicloDeVida [6][11] = 17;
        respuestasCicloDeVida [6][12] = 18;
        respuestasCicloDeVida [6][13] = 19;
        respuestasCicloDeVida [6][14] = 20;
        respuestasCicloDeVida [6][15] = 21;
        respuestasCicloDeVida [6][16] = 22;
        respuestasCicloDeVida [6][17] = 23;
        respuestasCicloDeVida[7] = new int[10];
        respuestasCicloDeVida [7][0] = 1;
        respuestasCicloDeVida [7][1] = 3;
        respuestasCicloDeVida [7][2] = 5;
        respuestasCicloDeVida [7][3] = 6;
        respuestasCicloDeVida [7][4] = 7;
        respuestasCicloDeVida [7][5] = 8;
        respuestasCicloDeVida [7][6] = 17;
        respuestasCicloDeVida [7][7] = 19;
        respuestasCicloDeVida [7][8] = 20;
        respuestasCicloDeVida [7][9] = 23;
        respuestasCicloDeVida[8] = new int[14];
        respuestasCicloDeVida [8][0] = 2;
        respuestasCicloDeVida [8][1] = 5;
        respuestasCicloDeVida [8][2] = 6;
        respuestasCicloDeVida [8][3] = 9;
        respuestasCicloDeVida [8][4] = 11;
        respuestasCicloDeVida [8][5] = 12;
        respuestasCicloDeVida [8][6] = 13;
        respuestasCicloDeVida [8][7] = 14;
        respuestasCicloDeVida [8][8] = 17;
        respuestasCicloDeVida [8][9] = 18;
        respuestasCicloDeVida [8][10] = 19;
        respuestasCicloDeVida [8][11] = 20;
        respuestasCicloDeVida [8][12] = 21;
        respuestasCicloDeVida [8][13] = 23;
    }
    
    private static void llenarRespuestasEstiloDeVida() {
        respuestasEstiloDeVida = new int[25][];
        
        respuestasEstiloDeVida[0] = new int[6];
        respuestasEstiloDeVida [0][0] = 6;
        respuestasEstiloDeVida [0][1] = 8;
        respuestasEstiloDeVida [0][2] = 12;
        respuestasEstiloDeVida [0][3] = 17;
        respuestasEstiloDeVida [0][4] = 18;
        respuestasEstiloDeVida [0][5] = 23;
        respuestasEstiloDeVida[1] = new int[12];
        respuestasEstiloDeVida [1][0] = 2;
        respuestasEstiloDeVida [1][1] = 3;
        respuestasEstiloDeVida [1][2] = 5;
        respuestasEstiloDeVida [1][3] = 6;
        respuestasEstiloDeVida [1][4] = 8;
        respuestasEstiloDeVida [1][5] = 11;
        respuestasEstiloDeVida [1][6] = 12;
        respuestasEstiloDeVida [1][7] = 13;
        respuestasEstiloDeVida [1][8] = 14;
        respuestasEstiloDeVida [1][9] = 17;
        respuestasEstiloDeVida [1][10] = 18;
        respuestasEstiloDeVida [1][11] = 23;
        respuestasEstiloDeVida[2] = new int[10];
        respuestasEstiloDeVida [2][0] = 1;
        respuestasEstiloDeVida [2][1] = 2;
        respuestasEstiloDeVida [2][2] = 5;
        respuestasEstiloDeVida [2][3] = 6;
        respuestasEstiloDeVida [2][4] = 11;
        respuestasEstiloDeVida [2][5] = 12;
        respuestasEstiloDeVida [2][6] = 13;
        respuestasEstiloDeVida [2][7] = 14;
        respuestasEstiloDeVida [2][8] = 17;
        respuestasEstiloDeVida [2][9] = 18;
        respuestasEstiloDeVida[3] = new int[11];
        respuestasEstiloDeVida [3][0] = 2;
        respuestasEstiloDeVida [3][1] = 10;
        respuestasEstiloDeVida [3][2] = 11;
        respuestasEstiloDeVida [3][3] = 12;
        respuestasEstiloDeVida [3][4] = 13;
        respuestasEstiloDeVida [3][5] = 14;
        respuestasEstiloDeVida [3][6] = 17;
        respuestasEstiloDeVida [3][7] = 18;
        respuestasEstiloDeVida [3][8] = 19;
        respuestasEstiloDeVida [3][9] = 20;
        respuestasEstiloDeVida [3][10] = 21;
        respuestasEstiloDeVida[4] = new int[7];
        respuestasEstiloDeVida [4][0] = 3;
        respuestasEstiloDeVida [4][1] = 5;
        respuestasEstiloDeVida [4][2] = 6;
        respuestasEstiloDeVida [4][3] = 7;
        respuestasEstiloDeVida [4][4] = 12;
        respuestasEstiloDeVida [4][5] = 14;
        respuestasEstiloDeVida [4][6] = 23;
        respuestasEstiloDeVida[5] = new int[3];
        respuestasEstiloDeVida [5][0] = 8;
        respuestasEstiloDeVida [5][1] = 12;
        respuestasEstiloDeVida [5][2] = 23;
        respuestasEstiloDeVida[6] = new int[4];
        respuestasEstiloDeVida [6][0] = 6;
        respuestasEstiloDeVida [6][1] = 14;
        respuestasEstiloDeVida [6][2] = 17;
        respuestasEstiloDeVida [6][3] = 23;
        respuestasEstiloDeVida[7] = new int[7];
        respuestasEstiloDeVida [7][0] = 2;
        respuestasEstiloDeVida [7][1] = 6;
        respuestasEstiloDeVida [7][2] = 8;
        respuestasEstiloDeVida [7][3] = 11;
        respuestasEstiloDeVida [7][4] = 12;
        respuestasEstiloDeVida [7][5] = 14;
        respuestasEstiloDeVida [7][6] = 17;
        respuestasEstiloDeVida[8] = new int[2];
        respuestasEstiloDeVida [8][0] = 6;
        respuestasEstiloDeVida [8][1] = 14;
        respuestasEstiloDeVida[9] = new int[7];
        respuestasEstiloDeVida [9][0] = 3;
        respuestasEstiloDeVida [9][1] = 5;
        respuestasEstiloDeVida [9][2] = 6;
        respuestasEstiloDeVida [9][3] = 7;
        respuestasEstiloDeVida [9][4] = 17;
        respuestasEstiloDeVida [9][5] = 20;
        respuestasEstiloDeVida [9][6] = 23;
        respuestasEstiloDeVida[10] = new int[7];
        respuestasEstiloDeVida [10][0] = 3;
        respuestasEstiloDeVida [10][1] = 5;
        respuestasEstiloDeVida [10][2] = 7;
        respuestasEstiloDeVida [10][3] = 14;
        respuestasEstiloDeVida [10][4] = 18;
        respuestasEstiloDeVida [10][5] = 20;
        respuestasEstiloDeVida [10][6] = 23;
        respuestasEstiloDeVida[11] = new int[4];
        respuestasEstiloDeVida [11][0] = 2;
        respuestasEstiloDeVida [11][1] = 17;
        respuestasEstiloDeVida [11][2] = 19;
        respuestasEstiloDeVida [11][3] = 23;
        respuestasEstiloDeVida[12] = new int[3];
        respuestasEstiloDeVida [12][0] = 2;
        respuestasEstiloDeVida [12][1] = 11;
        respuestasEstiloDeVida [12][2] = 17;
        respuestasEstiloDeVida[13] = new int[4];
        respuestasEstiloDeVida [13][0] = 2;
        respuestasEstiloDeVida [13][1] = 6;
        respuestasEstiloDeVida [13][2] = 18;
        respuestasEstiloDeVida [13][3] = 23;
        respuestasEstiloDeVida[14] = new int[1];
        respuestasEstiloDeVida [14][0] = 13;
        respuestasEstiloDeVida[15] = new int[3];
        respuestasEstiloDeVida [15][0] = 2;
        respuestasEstiloDeVida [15][1] = 6;
        respuestasEstiloDeVida [15][2] = 18;
        respuestasEstiloDeVida[16] = new int[6];
        respuestasEstiloDeVida [16][0] = 2;
        respuestasEstiloDeVida [16][1] = 11;
        respuestasEstiloDeVida [16][2] = 14;
        respuestasEstiloDeVida [16][3] = 17;
        respuestasEstiloDeVida [16][4] = 21;
        respuestasEstiloDeVida [16][5] = 23;
        respuestasEstiloDeVida[17] = new int[2];
        respuestasEstiloDeVida [17][0] = 6;
        respuestasEstiloDeVida [17][1] = 22;
        respuestasEstiloDeVida[18] = new int[5];
        respuestasEstiloDeVida [18][0] = 2;
        respuestasEstiloDeVida [18][1] = 3;
        respuestasEstiloDeVida [18][2] = 6;
        respuestasEstiloDeVida [18][3] = 11;
        respuestasEstiloDeVida [18][4] = 17;
        respuestasEstiloDeVida[19] = new int[10];
        respuestasEstiloDeVida [19][0] = 1;
        respuestasEstiloDeVida [19][1] = 2;
        respuestasEstiloDeVida [19][2] = 3;
        respuestasEstiloDeVida [19][3] = 5;
        respuestasEstiloDeVida [19][4] = 6;
        respuestasEstiloDeVida [19][5] = 7;
        respuestasEstiloDeVida [19][6] = 8;
        respuestasEstiloDeVida [19][7] = 12;
        respuestasEstiloDeVida [19][8] = 18;
        respuestasEstiloDeVida [19][9] = 23;
        respuestasEstiloDeVida[20] = new int[10];
        respuestasEstiloDeVida [20][0] = 1;
        respuestasEstiloDeVida [20][1] = 2;
        respuestasEstiloDeVida [20][2] = 3;
        respuestasEstiloDeVida [20][3] = 5;
        respuestasEstiloDeVida [20][4] = 6;
        respuestasEstiloDeVida [20][5] = 7;
        respuestasEstiloDeVida [20][6] = 8;
        respuestasEstiloDeVida [20][7] = 12;
        respuestasEstiloDeVida [20][8] = 18;
        respuestasEstiloDeVida [20][9] = 23;
        respuestasEstiloDeVida[21] = new int[5];
        respuestasEstiloDeVida [21][0] = 6;
        respuestasEstiloDeVida [21][1] = 11;
        respuestasEstiloDeVida [21][2] = 12;
        respuestasEstiloDeVida [21][3] = 18;
        respuestasEstiloDeVida [21][4] = 23;
        respuestasEstiloDeVida[22] = new int[2];
        respuestasEstiloDeVida [22][0] = 17;
        respuestasEstiloDeVida [22][1] = 19;
        respuestasEstiloDeVida[23] = new int[4];
        respuestasEstiloDeVida [23][0] = 2;
        respuestasEstiloDeVida [23][1] = 6;
        respuestasEstiloDeVida [23][2] = 17;
        respuestasEstiloDeVida [23][3] = 23;
        respuestasEstiloDeVida[24] = new int[4];
        respuestasEstiloDeVida [24][0] = 6;
        respuestasEstiloDeVida [24][1] = 17;
        respuestasEstiloDeVida [24][2] = 19;
        respuestasEstiloDeVida [24][3] = 23;
    }
    
    private static void llenarRespuestasHabitosAlimenticios() {
        respuestasHabitosAlimenticios = new int[27][];
        
        respuestasHabitosAlimenticios[0] = new int[7];
        respuestasHabitosAlimenticios [0][0] = 1;
        respuestasHabitosAlimenticios [0][1] = 2;
        respuestasHabitosAlimenticios [0][2] = 4;
        respuestasHabitosAlimenticios [0][3] = 8;
        respuestasHabitosAlimenticios [0][4] = 10;
        respuestasHabitosAlimenticios [0][5] = 11;
        respuestasHabitosAlimenticios [0][6] = 0;
        respuestasHabitosAlimenticios[1] = new int[5];
        respuestasHabitosAlimenticios [1][0] = 2;
        respuestasHabitosAlimenticios [1][1] = 9;
        respuestasHabitosAlimenticios [1][2] = 10;
        respuestasHabitosAlimenticios [1][3] = 13;
        respuestasHabitosAlimenticios [1][4] = 0;
        respuestasHabitosAlimenticios[2] = new int[5];
        respuestasHabitosAlimenticios [2][0] = 2;
        respuestasHabitosAlimenticios [2][1] = 9;
        respuestasHabitosAlimenticios [2][2] = 10;
        respuestasHabitosAlimenticios [2][3] = 13;
        respuestasHabitosAlimenticios [2][4] = 0;
        respuestasHabitosAlimenticios[3] = new int[3];
        respuestasHabitosAlimenticios [3][0] = 17;
        respuestasHabitosAlimenticios [3][1] = 19;
        respuestasHabitosAlimenticios [3][2] = 1;
        respuestasHabitosAlimenticios[4] = new int[7];
        respuestasHabitosAlimenticios [4][0] = 3;
        respuestasHabitosAlimenticios [4][1] = 6;
        respuestasHabitosAlimenticios [4][2] = 7;
        respuestasHabitosAlimenticios [4][3] = 13;
        respuestasHabitosAlimenticios [4][4] = 18;
        respuestasHabitosAlimenticios [4][5] = 23;
        respuestasHabitosAlimenticios [4][6] = 0;
        respuestasHabitosAlimenticios[5] = new int[7];
        respuestasHabitosAlimenticios [5][0] = 3;
        respuestasHabitosAlimenticios [5][1] = 6;
        respuestasHabitosAlimenticios [5][2] = 7;
        respuestasHabitosAlimenticios [5][3] = 13;
        respuestasHabitosAlimenticios [5][4] = 18;
        respuestasHabitosAlimenticios [5][5] = 23;
        respuestasHabitosAlimenticios [5][6] = 0;
        respuestasHabitosAlimenticios[6] = new int[6];
        respuestasHabitosAlimenticios [6][0] = 3;
        respuestasHabitosAlimenticios [6][1] = 7;
        respuestasHabitosAlimenticios [6][2] = 13;
        respuestasHabitosAlimenticios [6][3] = 18;
        respuestasHabitosAlimenticios [6][4] = 23;
        respuestasHabitosAlimenticios [6][5] = 0;
        respuestasHabitosAlimenticios[7] = new int[4];
        respuestasHabitosAlimenticios [7][0] = 11;
        respuestasHabitosAlimenticios [7][1] = 12;
        respuestasHabitosAlimenticios [7][2] = 18;
        respuestasHabitosAlimenticios [7][3] = 1;
        respuestasHabitosAlimenticios[8] = new int[7];
        respuestasHabitosAlimenticios [8][0] = 1;
        respuestasHabitosAlimenticios [8][1] = 7;
        respuestasHabitosAlimenticios [8][2] = 8;
        respuestasHabitosAlimenticios [8][3] = 13;
        respuestasHabitosAlimenticios [8][4] = 18;
        respuestasHabitosAlimenticios [8][5] = 23;
        respuestasHabitosAlimenticios [8][6] = 0;
        respuestasHabitosAlimenticios[9] = new int[5];
        respuestasHabitosAlimenticios [9][0] = 2;
        respuestasHabitosAlimenticios [9][1] = 9;
        respuestasHabitosAlimenticios [9][2] = 10;
        respuestasHabitosAlimenticios [9][3] = 13;
        respuestasHabitosAlimenticios [9][4] = 0;
        respuestasHabitosAlimenticios[10] = new int[7];
        respuestasHabitosAlimenticios [10][0] = 8;
        respuestasHabitosAlimenticios [10][1] = 12;
        respuestasHabitosAlimenticios [10][2] = 13;
        respuestasHabitosAlimenticios [10][3] = 14;
        respuestasHabitosAlimenticios [10][4] = 18;
        respuestasHabitosAlimenticios [10][5] = 23;
        respuestasHabitosAlimenticios [10][6] = 0;
        respuestasHabitosAlimenticios[11] = new int[4];
        respuestasHabitosAlimenticios [11][0] = 17;
        respuestasHabitosAlimenticios [11][1] = 19;
        respuestasHabitosAlimenticios [11][2] = 23;
        respuestasHabitosAlimenticios [11][3] = 1;
        respuestasHabitosAlimenticios[12] = new int[4];
        respuestasHabitosAlimenticios [12][0] = 14;
        respuestasHabitosAlimenticios [12][1] = 17;
        respuestasHabitosAlimenticios [12][2] = 18;
        respuestasHabitosAlimenticios [12][3] = 0;
        respuestasHabitosAlimenticios[13] = new int[10];
        respuestasHabitosAlimenticios [13][0] = 1;
        respuestasHabitosAlimenticios [13][1] = 6;
        respuestasHabitosAlimenticios [13][2] = 7;
        respuestasHabitosAlimenticios [13][3] = 8;
        respuestasHabitosAlimenticios [13][4] = 11;
        respuestasHabitosAlimenticios [13][5] = 12;
        respuestasHabitosAlimenticios [13][6] = 13;
        respuestasHabitosAlimenticios [13][7] = 18;
        respuestasHabitosAlimenticios [13][8] = 23;
        respuestasHabitosAlimenticios [13][9] = 0;
        respuestasHabitosAlimenticios[14] = new int[5];
        respuestasHabitosAlimenticios [14][0] = 4;
        respuestasHabitosAlimenticios [14][1] = 5;
        respuestasHabitosAlimenticios [14][2] = 17;
        respuestasHabitosAlimenticios [14][3] = 19;
        respuestasHabitosAlimenticios [14][4] = 0;
        respuestasHabitosAlimenticios[15] = new int[5];
        respuestasHabitosAlimenticios [15][0] = 11;
        respuestasHabitosAlimenticios [15][1] = 12;
        respuestasHabitosAlimenticios [15][2] = 17;
        respuestasHabitosAlimenticios [15][3] = 18;
        respuestasHabitosAlimenticios [15][4] = 0;
        respuestasHabitosAlimenticios[16] = new int[9];
        respuestasHabitosAlimenticios [16][0] = 1;
        respuestasHabitosAlimenticios [16][1] = 3;
        respuestasHabitosAlimenticios [16][2] = 6;
        respuestasHabitosAlimenticios [16][3] = 8;
        respuestasHabitosAlimenticios [16][4] = 12;
        respuestasHabitosAlimenticios [16][5] = 13;
        respuestasHabitosAlimenticios [16][6] = 18;
        respuestasHabitosAlimenticios [16][7] = 23;
        respuestasHabitosAlimenticios [16][8] = 0;
        respuestasHabitosAlimenticios[17] = new int[9];
        respuestasHabitosAlimenticios [17][0] = 1;
        respuestasHabitosAlimenticios [17][1] = 3;
        respuestasHabitosAlimenticios [17][2] = 6;
        respuestasHabitosAlimenticios [17][3] = 7;
        respuestasHabitosAlimenticios [17][4] = 12;
        respuestasHabitosAlimenticios [17][5] = 13;
        respuestasHabitosAlimenticios [17][6] = 18;
        respuestasHabitosAlimenticios [17][7] = 23;
        respuestasHabitosAlimenticios [17][8] = 0;
        respuestasHabitosAlimenticios[18] = new int[6];
        respuestasHabitosAlimenticios [18][0] = 6;
        respuestasHabitosAlimenticios [18][1] = 17;
        respuestasHabitosAlimenticios [18][2] = 18;
        respuestasHabitosAlimenticios [18][3] = 22;
        respuestasHabitosAlimenticios [18][4] = 23;
        respuestasHabitosAlimenticios [18][5] = 1;
        respuestasHabitosAlimenticios[19] = new int[4];
        respuestasHabitosAlimenticios [19][0] = 11;
        respuestasHabitosAlimenticios [19][1] = 12;
        respuestasHabitosAlimenticios [19][2] = 18;
        respuestasHabitosAlimenticios [19][3] = 1;
        respuestasHabitosAlimenticios[20] = new int[6];
        respuestasHabitosAlimenticios [20][0] = 2;
        respuestasHabitosAlimenticios [20][1] = 9;
        respuestasHabitosAlimenticios [20][2] = 10;
        respuestasHabitosAlimenticios [20][3] = 11;
        respuestasHabitosAlimenticios [20][4] = 13;
        respuestasHabitosAlimenticios [20][5] = 0;
        respuestasHabitosAlimenticios[21] = new int[4];
        respuestasHabitosAlimenticios [21][0] = 4;
        respuestasHabitosAlimenticios [21][1] = 11;
        respuestasHabitosAlimenticios [21][2] = 14;
        respuestasHabitosAlimenticios [21][3] = 0;
        respuestasHabitosAlimenticios[22] = new int[6];
        respuestasHabitosAlimenticios [22][0] = 2;
        respuestasHabitosAlimenticios [22][1] = 4;
        respuestasHabitosAlimenticios [22][2] = 10;
        respuestasHabitosAlimenticios [22][3] = 11;
        respuestasHabitosAlimenticios [22][4] = 14;
        respuestasHabitosAlimenticios [22][5] = 0;
        respuestasHabitosAlimenticios[23] = new int[4];
        respuestasHabitosAlimenticios [23][0] = 6;
        respuestasHabitosAlimenticios [23][1] = 22;
        respuestasHabitosAlimenticios [23][2] = 23;
        respuestasHabitosAlimenticios [23][3] = 1;
        respuestasHabitosAlimenticios[24] = new int[5];
        respuestasHabitosAlimenticios [24][0] = 4;
        respuestasHabitosAlimenticios [24][1] = 11;
        respuestasHabitosAlimenticios [24][2] = 14;
        respuestasHabitosAlimenticios [24][3] = 18;
        respuestasHabitosAlimenticios [24][4] = 1;
        respuestasHabitosAlimenticios[25] = new int[13];
        respuestasHabitosAlimenticios [25][0] = 1;
        respuestasHabitosAlimenticios [25][1] = 2;
        respuestasHabitosAlimenticios [25][2] = 5;
        respuestasHabitosAlimenticios [25][3] = 6;
        respuestasHabitosAlimenticios [25][4] = 7;
        respuestasHabitosAlimenticios [25][5] = 9;
        respuestasHabitosAlimenticios [25][6] = 10;
        respuestasHabitosAlimenticios [25][7] = 12;
        respuestasHabitosAlimenticios [25][8] = 13;
        respuestasHabitosAlimenticios [25][9] = 17;
        respuestasHabitosAlimenticios [25][10] = 18;
        respuestasHabitosAlimenticios [25][11] = 23;
        respuestasHabitosAlimenticios [25][12] = 1;
        respuestasHabitosAlimenticios[26] = new int[12];
        respuestasHabitosAlimenticios [26][0] = 2;
        respuestasHabitosAlimenticios [26][1] = 4;
        respuestasHabitosAlimenticios [26][2] = 5;
        respuestasHabitosAlimenticios [26][3] = 6;
        respuestasHabitosAlimenticios [26][4] = 7;
        respuestasHabitosAlimenticios [26][5] = 9;
        respuestasHabitosAlimenticios [26][6] = 10;
        respuestasHabitosAlimenticios [26][7] = 12;
        respuestasHabitosAlimenticios [26][8] = 13;
        respuestasHabitosAlimenticios [26][9] = 14;
        respuestasHabitosAlimenticios [26][10] = 23;
        respuestasHabitosAlimenticios [26][11] = 1;
    }
    
    public static void vaciarRespuestasCuestionario() {
        respuestasCuestionario = new int[23];
        for (int i = 0; i < 23; i++) {
            respuestasCuestionario[i] = 0;
        }
    }
    
    private static int definirCicloDeVida(char sexo, int edad) {
        int x;
        if (edad <= 5)
            x = 1;
        else if (edad <= 11)
            x = 2;
        else if ((sexo == 'f') || (sexo == 'F')) {
            if (edad <= 18)
                x = 3;
            else if (edad <= 30)
                x = 5;
            else if (edad <= 45)
                x = 7;
            else 
                x = 9;
        } else {
            if (edad <= 18)
                x = 4;
            else if (edad <= 35)
                x = 6;
            else if (edad <= 65)
                x = 8;
            else
                x = 10;
        }
        return x;
    }
    
}
