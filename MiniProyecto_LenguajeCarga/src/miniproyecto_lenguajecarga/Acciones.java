package miniproyecto_lenguajecarga;

import java.util.ArrayList;

public class Acciones {

    int pos;
    int dir;
    int fila, columna;
    ArrayList mapa = new ArrayList();

    public Acciones() {
    }

    public Acciones(int fila, int columna, ArrayList x) {
        this.fila = fila;
        this.columna = columna;
        mapa = x;
    }

    String[][] matriz() {
        int cont = 0;
        String[][] temp = new String[fila][columna];
        String cadenat = "";
        for (int i = 0; i < mapa.size(); i++) {
            cadenat += mapa.get(i);
        }
//        System.out.println(cadenat);

        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
//                System.out.println("L: " + cadenat.charAt(cont));
                temp[i][j] = String.valueOf(cadenat.charAt(cont));
                cont++;
            }
        }

        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                System.out.print("[" + temp[i][j] + "]");
            }
            System.out.println("");
        }
//        direccion(temp);
//        posX(temp);
//        posY(temp);
//        posXO(temp);
//        posYO(temp);
//        posXD(temp);
//        posYD(temp);
        return temp;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    int posX(String[][] x) {
        int posx = 0;
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                if (x[i][j].equals(">") || x[i][j].equals("<") || x[i][j].equals("v") || x[i][j].equals("^")) {
                    posx = i;
                    break;
                }
            }
        }
//        System.out.println(posx);
        return posx;
    }

    int posY(String[][] x) {
        int posy = 0;
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                if (x[i][j].equals(">") || x[i][j].equals("<") || x[i][j].equals("v") || x[i][j].equals("^")) {
                    posy = j;
                    break;
                }
            }
        }
//        System.out.println(posy);
        return posy;
    }

    int direccion(String[][] x) {
        //8 arriba
        //2 abajo
        //4 izquierda
        //6 derecha
        int posy = 0;
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                if (x[i][j].equals(">")) {
                    posy = 6;
                    break;
                } else if (x[i][j].equals("<")) {
                    posy = 4;
                    break;
                } else if (x[i][j].equals("v")) {
                    posy = 2;
                    break;
                } else if (x[i][j].equals("^")) {
                    posy = 8;
                    break;
                }
            }
        }
//        System.out.println("Direccion: " + posy);
        return posy;
    }

    int posXO(String[][] x) {
        int posx = 0;
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                if (x[i][j].equals("O")) {
                    posx = i;
                    break;
                }
            }
        }
//        System.out.println("x: "+posx);
        return posx;
    }

    int posYO(String[][] x) {
        int posy = 0;
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                if (x[i][j].equals("O")) {
                    posy = j;
                    break;
                }
            }
        }
//        System.out.println("Y: "+posy);
        return posy;
    }

    int posXD(String[][] x) {
        int posx = 0;
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                if (x[i][j].equals("D")) {
                    posx = i;
                    break;
                }
            }
        }
//        System.out.println(posx);
        return posx;
    }

    int posYD(String[][] x) {
        int posy = 0;
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                if (x[i][j].equals("D")) {
                    posy = j;
                    break;
                }
            }
        }
//        System.out.println(posy);
        return posy;
    }

    //avanzar
    //girar
    //recivir
    //soltar
}
