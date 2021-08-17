package miniproyecto_lenguajecarga;

import java.io.File;
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

    public String[][] mapa() {
        leerArchivo();
        separarTam();
        separarMapa();

        int cont = 0;
        String[][] temp = new String[columna][fila];
        String cadenat = "";
        for (int i = 0; i < cadenaMapa.size(); i++) {
            cadenat += cadenaMapa.get(i);
        }

        for (int i = 0; i < columna; i++) {
            for (int j = 0; j < fila; j++) {
                temp[i][j] = String.valueOf(cadenat.charAt(cont));
                cont++;
            }
        }
        return temp;
    }

    public ArrayList getCadenaMapa(){
        return cadenaMapa;
    }
    
    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
}
