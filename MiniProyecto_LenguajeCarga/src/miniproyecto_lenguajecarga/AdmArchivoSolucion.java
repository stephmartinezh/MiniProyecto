package miniproyecto_lenguajecarga;

import java.io.File;
import static java.lang.Character.isDigit;
import java.util.ArrayList;
import java.util.Scanner;

public class AdmArchivoSolucion {

    File archivo;
    ArrayList contenidoArchivo = new ArrayList();
    ArrayList cadenaResultado = new ArrayList();

    public AdmArchivoSolucion(File archivo) {
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
        if (contenidoArchivo.get(0).toString().charAt(0) == '#') {
            contenidoArchivo.remove(0);
        }
    }

    public ArrayList separar() {
        String temporal = "";
        for (int i = 0; i < contenidoArchivo.size(); i++) {
            String cadena = contenidoArchivo.get(i).toString();
            for (int j = 0; j < cadena.length(); j++) {

                char caracter = cadena.charAt(j);
                if (caracter >= 'a' && caracter <= 'z') {
                    temporal += caracter;
                }
            }
            cadenaResultado.add(temporal);
            temporal = "";
        }
        return cadenaResultado;
    }

}
