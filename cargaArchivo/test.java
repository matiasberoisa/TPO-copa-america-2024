import java.io.IOException;
import conjuntistas.TablaHash;
import grafos.GrafoEtiquetado;

public class test {
    @SuppressWarnings({ "unused" })
    public static void main(String[] args) throws IOException {
        GrafoEtiquetado ciudades = new GrafoEtiquetado();
        Carga cargar = new Carga();
        TablaHash mapa = new TablaHash();
        mapa = cargar.cargaPartidos();
        ciudades = cargar.cargaCiudades();
        System.out.println(mapa.listar());
    }
}
