
import java.io.*;
import java.util.StringTokenizer;

import clasesTPO.*;
import conjuntistas.ArbolAVL;
import grafos.GrafoEtiquetado;

public class Carga {
    private FileReader archivoLectura;
    private BufferedReader lector;
    private FileWriter archivoEscritura;
    private BufferedWriter escritor;
    private StringTokenizer split;

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
            ciudades.insertarVertice(ciudad);
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
            equipos.insertar(equipo);
        }
        return equipos;

    }

    public Partido[] cargaPartidos(int cant) throws IOException {
        archivoLectura = new FileReader(
                "C:\\Users\\mbero\\Downloads\\TPs\\EstructuraDeDatos\\estructuras\\estructuras\\listas\\ListaPartidos.txt");
        lector = new BufferedReader(archivoLectura);
        Partido[] partidos = new Partido[cant];
        String linea, eq1 = "", eq2 = "", instancia = "", ciudad = "", estadio = "", valor = "";
        int i = 0, golE1 = 0, golE2 = 0;
        while ((linea = lector.readLine()) != null) {
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
            partidos[i] = partido;
            i++;
        }
        return partidos;

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
            ciudades.insertarArco(origen, destino, tiempoEstimado);
        }

    }
    // usar el fileWritter para cargar los puntos, goles a favor y en contra

}
