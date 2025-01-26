import java.io.IOException;

import grafos.GrafoEtiquetado;

public class test {
    public static void main(String[] args) throws IOException {
        GrafoEtiquetado ciudades = new GrafoEtiquetado();
        Carga cargar = new Carga();
        cargar.escribirPartidos();
    }
}
