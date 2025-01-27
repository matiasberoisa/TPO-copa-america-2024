
import java.io.*;

import java.util.HashMap;
import java.util.StringTokenizer;

import clasesTPO.*;
import conjuntistas.ArbolAVL;
import grafos.GrafoEtiquetado;

public class Carga {
    private GrafoEtiquetado ciudades = new GrafoEtiquetado();
    private ArbolAVL equipos = new ArbolAVL();
    private HashMap<Integer, Partido> mapa = new HashMap<Integer, Partido>();
    private FileReader archivoLectura;
    private BufferedReader lector;
    private StringTokenizer split;

    public GrafoEtiquetado cargaCiudades() throws IOException {
        archivoLectura = new FileReader(
                "C:\\Users\\mbero\\Downloads\\TPs\\EstructuraDeDatos\\estructuras\\estructuras\\listas\\ListaCiudades.txt");
        lector = new BufferedReader(archivoLectura);
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
                            if (valor.equalsIgnoreCase("true")) {
                                alojamiento = true;
                            }
                            break;
                    }
                } else {
                    if (valor.equalsIgnoreCase("true")) {
                        sedeCopa = true;
                    }
                }
            }

            Ciudad ciudad = new Ciudad(nombreCiudad.toLowerCase(), alojamiento, sedeCopa);
            ciudades.insertarVertice(ciudad);
        }
        return ciudades;

    }

    public ArbolAVL cargaEquipos() throws IOException {
        archivoLectura = new FileReader(
                "C:\\Users\\mbero\\Downloads\\TPs\\EstructuraDeDatos\\estructuras\\estructuras\\listas\\ListaEquipos.txt");
        lector = new BufferedReader(archivoLectura);
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

            Equipo equipo = new Equipo(nombrePais.toUpperCase(), director.toLowerCase(), grupo.toUpperCase());
            equipos.insertar(equipo);
        }
        return equipos;

    }

    public HashMap<Integer, Partido> cargaPartidos() throws IOException {
        archivoLectura = new FileReader(
                "C:\\Users\\mbero\\Downloads\\TPs\\TPO-copa-america-2024\\cargaArchivo\\clasesTPO\\archivos\\listaPartidos.txt");
        lector = new BufferedReader(archivoLectura);
        String linea, eq1 = "", eq2 = "", instancia = "", ciudad = "", estadio = "", valor = "";
        int golE1 = 0, golE2 = 0;
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
            Partido partido = new Partido(eq1.toUpperCase(), eq2.toUpperCase(), instancia, ciudad, estadio, golE1,
                    golE2);
            mapa.put(partido.getClavePartido(), partido);
            Equipo equipo1 = (Equipo) equipos.recuperar(new Equipo(eq1.toUpperCase()));
            Equipo equipo2 = (Equipo) equipos.recuperar(new Equipo(eq2.toUpperCase()));
            equipo1.actualizarEquipo(golE1, golE2);
            equipo2.actualizarEquipo(golE2, golE1);

        }
        return mapa;

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
            ciudades.insertarArco(origen.toLowerCase(), destino.toLowerCase(), tiempoEstimado);
        }

    }
    // usar el fileWritter para cargar el archivo LOG.txt
}
