import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Scanner;

import clasesTPO.Partido;
import conjuntistas.ArbolAVL;
import grafos.GrafoEtiquetado;

public class menu {
    private static GrafoEtiquetado ciudades;
    private static ArbolAVL equipos;
    @SuppressWarnings("unused")
    private static HashMap<Integer, Partido> partidos;
    private static Carga cargaDatos = new Carga();

    public static void main(String[] args) throws IOException {
        ciudades = cargaDatos.cargaCiudades();
        equipos = cargaDatos.cargaEquipos();
        partidos = cargaDatos.cargaPartidos();
        cargaDatos.cargaRutas(ciudades);
        limpiarLog();
        mostrarMenu();
    }

    @SuppressWarnings("resource")
    public static void mostrarMenu() {
        Scanner dato = new Scanner(System.in);
        String opcion = "";
        boolean stop = false;
        do {
            System.out.println("\nIngrese una opcion.");
            mostrarOpciones();
            opcion = dato.next();
            switch (opcion) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":

                    break;
                case "7":

                    break;
                case "8":

                    break;
                case "0":
                    stop = true;
                    break;
                default:
                    System.out.println("opcion invalida. \ningrese nuevamente.");
                    break;
            }
        } while (!stop);
    }

    public static void mostrarOpciones() {
        System.out.println("1. si desea modificar ciudades");
        System.out.println("2. si desea modificar equipos");
        System.out.println("3. si desea dar de alta partidos");
        System.out.println("4. si desea realizar consultas sobre los equipos");
        System.out.println("5. si desea realizar consultas sobre los partidos");
        System.out.println("6. si desea realizar consultas sobre viajes");
        System.out.println("7. si desea ver los equipos ordenados por cantidad de goles a favor");
        System.out.println("8. si desea ver las estructuras del sistema");
        System.out.println("0. si desea finalizar");
    }

    public static void limpiarLog() {
        try (Writer w = new FileWriter("log.txt")) {
            w.write("INICIO DEL SISTEMA\r\n");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }
}
