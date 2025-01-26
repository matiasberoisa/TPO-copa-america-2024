import java.io.IOException;

import conjuntistas.ArbolAVL;
import conjuntistas.TablaHash;
import grafos.GrafoEtiquetado;

public class menu {
    private static GrafoEtiquetado ciudades;
    private static ArbolAVL equipos;
    private static TablaHash partidos;
    private static Carga cargaDatos = new Carga();

    public static void main(String[] args) throws IOException {
        ciudades = cargaDatos.cargaCiudades();
        equipos = cargaDatos.cargaEquipos();
        partidos = cargaDatos.cargaPartidos();
        cargaDatos.cargaRutas(ciudades);
    }
}
