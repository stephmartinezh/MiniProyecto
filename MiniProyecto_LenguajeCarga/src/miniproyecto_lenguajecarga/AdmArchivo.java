package miniproyecto_lenguajecarga;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdmArchivo {

    File archivo;
    ArrayList contenidoArchivo = new ArrayList();
    ArrayList cadenaMapa = new ArrayList();
    int fila, columna;

    public AdmArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void leerArchivo() {
        Scanner sc = null;
        try {
            sc = new Scanner(archivo);
            while (sc.hasNext()) {
                contenidoArchivo.add(sc.nextLine());
            }
            /*for (int i = 0; i < contenidoArchivo.size(); i++) {
                System.out.println(contenidoArchivo.get(i));
            }*/
            //System.out.println(contenidoArchivo.get(0));
        } catch (Exception e) {

        }
        sc.close();
    }

    public void separarTam() {
        String tam = "";
        tam = contenidoArchivo.get(0).toString();
        String[] u = tam.split(",");
        columna = Integer.parseInt(u[0]);
        fila = Integer.parseInt(u[1]);
    }

    public void separarMapa() {
        String cadena = "";
        for (int i = 1; i < contenidoArchivo.size(); i++) {
            cadena = contenidoArchivo.get(i).toString();
            cadenaMapa.add(cadena);
        }
    }

    public ArrayList mapa() {
        leerArchivo();
        separarTam();
        separarMapa();
        return cadenaMapa;
        /*char[][] mapa = new char[fila][columna];
        char[] arreglo = new char[25];
        //char[][] temporal = new char[fila][columna];
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                String cadenaTemporal = cadenaMapa.get(j).toString();
                arreglo[j] = cadenaTemporal.charAt(j);
                System.out.println(arreglo[j]);
                /*for (int k = 0; k < cadenaTemporal.length(); k++) {
                    arreglo[k] = cadenaTemporal.charAt(k);
                }
                mapa[i][j] = arreglo[j];
            }
            arreglo = new char[fila];
        }*/
 /*for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                System.out.print("[" + mapa[i][j] + "]");
            }
            System.out.println();
        }*/
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
}
