import java.io.IOException;
import java.util.HashMap;

import clasesTPO.Partido;
import conjuntistas.ArbolAVL;
import grafos.GrafoEtiquetado;

public class test {
    public static void main(String[] args) throws IOException {
        GrafoEtiquetado ciudades = new GrafoEtiquetado();
        Carga cargar = new Carga();
        HashMap<Integer, Partido> mapa = new HashMap<Integer, Partido>();
        ArbolAVL equipos = new ArbolAVL();
        mapa = cargar.cargaPartidos();
        ciudades = cargar.cargaCiudades();
        cargar.cargaRutas(ciudades);
        equipos = cargar.cargaEquipos();
        System.out.println(equipos.toString());
    }
}
