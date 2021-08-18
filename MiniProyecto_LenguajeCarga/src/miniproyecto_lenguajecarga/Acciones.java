package miniproyecto_lenguajecarga;

import java.util.ArrayList;

public class Acciones {

    int fila, columna;
    ArrayList mapa = new ArrayList();
    ArrayList posiciones = new ArrayList();

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

        /*for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                System.out.print("[" + temp[i][j] + "]");
            }
            System.out.println("");
        }*/
//        direccion(temp);
//        posX(temp);
//        posY(temp);
//        posXO(temp);
//        posYO(temp);
//        posXD(temp);
//        posYD(temp);
        return temp;
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
    void avanzar(String[][] x, int posx, int posy, int direc) {

    }

    boolean obstaculo(String[][] x, int posx, int posy, int direc) {
        boolean resp = true;
        switch (direc) {
            case 4:
                if (posx - 1 == -1 || x[posx - 1][posy].equals("X") || x[posx - 1][posy].equals("O") || x[posx - 1][posy].equals("D")) {
                    resp = false;
                }
                break;

            case 8:
                if (posy - 1 == -1 || x[posx][posy - 1].equals("X") || x[posx][posy - 1].equals("O") || x[posx][posy - 1].equals("D")) {
                    resp = false;
                }
                break;

            case 6:
                if (posx + 1 == columna || x[posx + 1][posy].equals("X") || x[posx + 1][posy].equals("O") || x[posx + 1][posy].equals("D")) {
                    resp = false;
                }
                break;

            case 2:
                if (posy + 1 == fila || x[posx][posy + 1].equals("X") || x[posx][posy + 1].equals("O") || x[posx][posy + 1].equals("D")) {
                    resp = false;
                }
                break;

            default:
                resp = true;
                break;
        }
        return resp;
    }
    
    boolean objetivo(String[][] x, int posx, int posy, int direc) {
        boolean resp = true;
        switch (direc) {
            case 4:
                if (x[posx - 1][posy].equals("O")) {
                    resp = true;
                }
                break;

            case 8:
                if (x[posx][posy - 1].equals("O")) {
                    resp = true;
                }
                break;

            case 6:
                if ( x[posx + 1][posy].equals("O")) {
                    resp = true;
                }
                break;

            case 2:
                if (x[posx][posy + 1].equals("O")) {
                    resp = true;
                }
                break;

            default:
                resp = false;
                break;
        }
        return resp;
    }
    
    boolean destino(String[][] x, int posx, int posy, int direc) {
        boolean resp = true;
        switch (direc) {
            case 4:
                if (x[posx - 1][posy].equals("D")) {
                    resp = true;
                }
                break;

            case 8:
                if (x[posx][posy - 1].equals("D")) {
                    resp = true;
                }
                break;

            case 6:
                if ( x[posx + 1][posy].equals("D")) {
                    resp = true;
                }
                break;

            case 2:
                if (x[posx][posy + 1].equals("D")) {
                    resp = true;
                }
                break;

            default:
                resp = false;
                break;
        }
        return resp;
    }

    //girar SOLO LA DERECHA
    String[][] girar(String[][] x, int posx, int posy) {
        String robot = x[posx][posy];
        switch (robot) {
            case ">":
                x[posx][posy] = "v";
                //robot = "v";
                break;

            case "<":
                //robot = "^";
                x[posx][posy] = "^";
                break;

            case "v":
                //robot = "<";
                x[posx][posy] = "<";
                break;

            case "^":
                //robot = ">";
                x[posx][posy] = ">";
                break;
        }
        return x;
    }
    //recibir
    String[][] recibir(String[][] x, int posx, int posy, int direc) {
        switch (direc) {
            case 4:
                if (x[posx - 1][posy].equals("O")) {
                    x[posx - 1][posy]="-";
                }
                break;

            case 8:
                if (x[posx][posy - 1].equals("O")) {
                    x[posx][posy - 1]="-";
                }
                break;

            case 6:
                if ( x[posx + 1][posy].equals("O")) {
                    x[posx + 1][posy]="-";
                }
                break;

            case 2:
                if (x[posx][posy + 1].equals("O")) {
                    x[posx][posy + 1]="-";
                }
                break;
        }
        return x;
    }
    //soltar
    String[][] soltar(String[][] x, int posx, int posy, int direc) {
        switch (direc) {
            case 4:
                if (x[posx - 1][posy].equals("D")) {
                    x[posx - 1][posy]="O";
                }
                break;

            case 8:
                if (x[posx][posy - 1].equals("D")) {
                    x[posx][posy - 1]="O";
                }
                break;

            case 6:
                if ( x[posx + 1][posy].equals("D")) {
                    x[posx + 1][posy]="O";
                }
                break;

            case 2:
                if (x[posx][posy + 1].equals("D")) {
                    x[posx][posy + 1]="O";
                }
                break;
        }
        return x;
    }
}
