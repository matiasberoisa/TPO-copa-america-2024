
import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import clasesTPO.*;
import conjuntistas.ArbolAVL;
import conjuntistas.TablaHash;
import grafos.GrafoEtiquetado;

public class Carga {
    private FileReader archivoLectura;
    private BufferedReader lector;
    private FileWriter archivoEscritura;
    private StringTokenizer split;
    private Scanner dato = new Scanner(System.in);
    private ArrayList<Ciudad> arregloCiudades = new ArrayList<Ciudad>();
    private ArrayList<Equipo> arregloEquipos = new ArrayList<Equipo>();
    private ArrayList<Partido> arregloPartidos = new ArrayList<Partido>();
    private ArrayList<Ruta> arregloRutas = new ArrayList<Ruta>();

    // quitar el parametro CANT de cada metodo y retornar una estructura
    public GrafoEtiquetado cargaCiudades() throws IOException {
        archivoLectura = new FileReader(
                "C:\\Users\\mbero\\Downloads\\TPs\\EstructuraDeDatos\\estructuras\\estructuras\\listas\\ListaCiudades.txt");
        lector = new BufferedReader(archivoLectura);
        GrafoEtiquetado ciudades = new GrafoEtiquetado();
        String linea, valor, nombreCiudad = "";
        boolean alojamiento = false, sedeCopa = false;
        while ((linea = lector.readLine()) != null) {
            split = new StringTokenizer(linea, ";");
            for (int j = 0; j < 3; j++) {
                valor = (String) split.nextElement();
                if (split.hasMoreElements()) {
                    switch (j) {
                        case 0:
                            nombreCiudad = valor;
                            break;
                        case 1:
                            if (valor.equals("TRUE")) {
                                alojamiento = true;
                            } else {
                                alojamiento = false;
                            }
                            break;
                    }
                } else {
                    if (valor.equals("TRUE")) {
                        sedeCopa = true;
                    } else {
                        sedeCopa = false;
                    }
                }
            }

            Ciudad ciudad = new Ciudad(nombreCiudad, alojamiento, sedeCopa);
            arregloCiudades.add(ciudad);
            ciudades.insertarVertice(nombreCiudad);
        }
        return ciudades;

    }

    public ArbolAVL cargaEquipos() throws IOException {
        archivoLectura = new FileReader(
                "C:\\Users\\mbero\\Downloads\\TPs\\EstructuraDeDatos\\estructuras\\estructuras\\listas\\ListaEquipos.txt");
        lector = new BufferedReader(archivoLectura);
        ArbolAVL equipos = new ArbolAVL();
        String linea, valor, nombrePais = "", director = "", grupo = "";
        while ((linea = lector.readLine()) != null) {
            split = new StringTokenizer(linea, ";");

            for (int j = 0; j < 3; j++) {
                valor = (String) split.nextElement();
                if (split.hasMoreElements()) {
                    switch (j) {
                        case 0:
                            nombrePais = valor;
                            break;
                        case 1:
                            director = valor;
                            break;
                    }
                } else {
                    grupo = valor;
                }
            }

            Equipo equipo = new Equipo(nombrePais, director, grupo);
            arregloEquipos.add(equipo);
            equipos.insertar(nombrePais);
        }
        return equipos;

    }

    public ArrayList<Partido> cargaPartidos() throws IOException {
        archivoLectura = new FileReader(
                "C:\\Users\\mbero\\Downloads\\TPs\\EstructuraDeDatos\\estructuras\\estructuras\\listas\\listaPartidos.txt");
        lector = new BufferedReader(archivoLectura);
        TablaHash mapa = new TablaHash();
        String linea, eq1 = "", eq2 = "", instancia = "", ciudad = "", estadio = "", valor = "";
        int golE1 = 0, golE2 = 0;
        while ((linea = lector.readLine()) != null) {
            System.out.println(linea);
            split = new StringTokenizer(linea, ";");
            for (int j = 0; j < 7; j++) {
                valor = (String) split.nextElement();
                if (split.hasMoreElements()) {
                    switch (j) {
                        case 0:
                            eq1 = valor;
                            break;
                        case 1:
                            eq2 = valor;
                            break;
                        case 2:
                            instancia = valor;
                            break;
                        case 3:
                            ciudad = valor;
                            break;
                        case 4:
                            estadio = valor;
                            break;
                        case 5:
                            golE1 = Integer.parseInt(valor);
                            break;
                    }
                } else {
                    golE2 = Integer.parseInt(valor);
                }
            }
            Partido partido = new Partido(eq1, eq2, instancia, ciudad, estadio, golE1, golE2);
            arregloPartidos.add(partido);
            mapa.insertar(partido);
        }
        return arregloPartidos;

    }

    public void cargaRutas(GrafoEtiquetado ciudades) throws IOException {
        archivoLectura = new FileReader(
                "C:\\Users\\mbero\\Downloads\\TPs\\EstructuraDeDatos\\estructuras\\estructuras\\listas\\ListaRutas.txt");
        lector = new BufferedReader(archivoLectura);
        String linea, valor, origen = "", destino = "";
        int tiempoEstimado = 0;
        while ((linea = lector.readLine()) != null) {
            split = new StringTokenizer(linea, ";");
            for (int j = 0; j < 3; j++) {
                valor = (String) split.nextElement();
                if (split.hasMoreElements()) {
                    switch (j) {
                        case 0:
                            origen = valor;
                            break;
                        case 1:
                            destino = valor;
                    }
                } else {
                    tiempoEstimado = Integer.parseInt(valor);
                }
            }
            Ruta ruta = new Ruta(origen, destino, tiempoEstimado);
            ciudades.insertarArco(origen, destino, tiempoEstimado);
            arregloRutas.add(ruta);
        }

    }
    // usar el fileWritter para cargar el archivo LOG.txt

    public void escribirPartidos() throws IOException {
        archivoEscritura = new FileWriter(
                "LOG.txt");
        String linea = "", eq1 = "", eq2 = "", instancia = "", ciudad = "", estadio = "";
        int golE1 = 0, golE2 = 0;
        System.out.println("escriba el equipo 1");
        eq1 = dato.nextLine();
        System.out.println("escriba el equipo 2");
        eq2 = dato.nextLine();
        System.out.println("escriba la instancia del partido");
        instancia = dato.nextLine();
        System.out.println("escriba la ciudad donde se jugo el partido");
        ciudad = dato.nextLine();
        System.out.println("escriba el estadio donde se jugo el partido");
        estadio = dato.nextLine();
        System.out.println("escriba los goles del equipo 1");
        golE1 = dato.nextInt();
        System.out.println("escriba los goles del equipo 2");
        golE2 = dato.nextInt();
        linea = eq1 + ";" + eq2 + ";" + instancia + ";" + ciudad + ";" + estadio + ";" + golE1 + ";" + golE2;
        System.out.println(linea);
        archivoEscritura.write(linea + "\n");
        archivoEscritura.close();
    }
}
