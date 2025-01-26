import java.io.IOException;
import java.util.ArrayList;

import clasesTPO.Partido;
import conjuntistas.TablaHash;
import grafos.GrafoEtiquetado;

public class test {
    @SuppressWarnings({ "unused" })
    public static void main(String[] args) throws IOException {
        GrafoEtiquetado ciudades = new GrafoEtiquetado();
        Carga cargar = new Carga();
        ArrayList<Partido> mapa = new ArrayList<>();
        mapa = cargar.cargaPartidos();
        ciudades = cargar.cargaCiudades();
    }
}
