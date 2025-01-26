import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Scanner;

import clasesTPO.Ciudad;
import clasesTPO.Equipo;
import clasesTPO.Partido;
import conjuntistas.ArbolAVL;
import grafos.GrafoEtiquetado;

public class menu {
    private static GrafoEtiquetado ciudades;
    private static ArbolAVL equipos;
    private static HashMap<Integer, Partido> partidos;
    private static Carga cargaDatos = new Carga();
    private static Scanner dato = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        ciudades = cargaDatos.cargaCiudades();
        equipos = cargaDatos.cargaEquipos();
        partidos = cargaDatos.cargaPartidos();
        cargaDatos.cargaRutas(ciudades);
        limpiarLog();
        mostrarMenu();
    }

    public static void mostrarMenu() {
        String opcion = "";
        boolean stop = false;
        do {
            System.out.println("\nIngrese una opcion.");
            mostrarOpciones();
            opcion = dato.next();
            switch (opcion) {
                case "1":
                    verCiudades();
                    break;
                case "2":
                    verEquipos();
                    break;
                case "3":
                    verPartidos();
                    break;
                case "4":
                    consultaEquipos();
                    break;
                case "5":
                    consultaPartidos();
                    break;
                case "6":
                    consultaViajes();
                    break;
                case "7":
                    listadoEquipos();
                    break;
                case "8":
                    mostrarSistema();
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

    public static void verCiudades() {
        String opcion = "", nombreCiudad = "", valorSede = "", valorAlojamiento = "", letra = "";
        boolean sede = false, alojamiento = false, stop = false;
        do {
            System.out.println("1. si desea agregar una ciudad");
            System.out.println("2. si desea eliminar una ciudad");
            System.out.println("3. si desea modificar una ciudad");
            System.out.println("4. para salir");
            opcion = dato.next();
            switch (opcion) {
                case "1": // agregar una ciudad
                    System.out.println("ingrese el nombre de la ciudad:");
                    nombreCiudad = dato.nextLine();
                    nombreCiudad = dato.nextLine().toLowerCase();
                    if (ciudades.existeVertice(nombreCiudad)) {
                        System.out.println("la ciudad " + nombreCiudad + " ya se encuentra cargada");
                    } else {
                        System.out.println("la ciudad " + nombreCiudad + " tiene alojamiento? ingrese S/N");
                        valorAlojamiento = dato.next();
                        if (valorAlojamiento.equals("S")) {
                            alojamiento = true;
                        }
                        System.out.println("la ciudad " + nombreCiudad + " es sede de la copa? ingrese S/N");
                        valorSede = dato.next();
                        if (valorSede.equals("S")) {
                            sede = true;
                        }
                        Ciudad nuCiudad = new Ciudad(nombreCiudad, alojamiento, sede);
                        ciudades.insertarVertice(nuCiudad);
                        System.out.println("la ciudad " + nombreCiudad + " se ha agregado con exito.");
                    }
                    break;
                case "2": // eliminar una ciudad
                    System.out.println("ingrese el nombre de la ciudad:");
                    nombreCiudad = dato.nextLine();
                    nombreCiudad = dato.nextLine().toLowerCase();
                    if (ciudades.existeVertice(nombreCiudad)) {
                        ciudades.eliminarVertice(nombreCiudad);
                        System.out.println("la ciudad " + nombreCiudad + " se ha eliminado con exito.");
                    } else {
                        System.out.println("la ciudad " + nombreCiudad + " NO se encuentra cargada");
                    }
                    break;
                case "3": // modificar una ciudad
                    System.out.println("ingrese el nombre de la ciudad:");
                    nombreCiudad = dato.nextLine();
                    nombreCiudad = dato.nextLine().toLowerCase();
                    Ciudad laCiudad = (Ciudad) ciudades.obtenerVertice(nombreCiudad);
                    if (laCiudad != null) {
                        System.out.println("que desea modificar de la ciudad " + nombreCiudad + "?");
                        System.out.println(
                                "ingrese 1 para modificar la sede, 2 para el alojamiento o 3 para modificar ambos");
                        letra = dato.next();
                        switch (letra) {
                            case "1":
                                laCiudad.cambiarSede();
                                break;
                            case "2":
                                laCiudad.cambiarAlojamiento();
                                break;
                            case "3":
                                laCiudad.cambiarSede();
                                laCiudad.cambiarAlojamiento();
                                break;
                            default:
                                System.out.println("opcion invalida");
                                break;
                        }
                    } else {
                        System.out.println("la ciudad " + nombreCiudad + " NO se encuentra cargada");
                    }
                    break;
                case "4":
                    stop = true;
                    break;
                default:
                    System.out.println("opcion invalida. \ningrese nuevamente.");
                    break;
            }
        } while (!stop);
    }

    public static void verEquipos() {

        String opcion = "", nombrePais = "", apellido = "", grupo = "", letra = "";
        boolean stop = false;
        do {
            System.out.println("1. si desea agregar un equipo");
            System.out.println("2. si desea eliminar un equipo");
            System.out.println("3. si desea modificar un equipo");
            System.out.println("4. para salir");
            opcion = dato.next();
            switch (opcion) {
                case "1": // agregar un equipo
                    System.out.println("ingrese el nombre del pais:");
                    nombrePais = dato.nextLine();
                    nombrePais = dato.nextLine().toUpperCase();
                    if (equipos.pertenece(nombrePais)) {
                        System.out.println("el pais " + nombrePais + " ya se encuentra cargada");
                    } else {
                        System.out.println("ingrese el apellido del tecnico del pais " + nombrePais);
                        apellido = dato.next().toLowerCase();
                        System.out.println("ingrese el grupo A/B/C/D del pais " + nombrePais);
                        grupo = dato.next().toUpperCase();
                        Equipo nuEquipo = new Equipo(nombrePais.toUpperCase(), apellido, grupo);
                        equipos.insertar(nuEquipo);
                    }
                    break;
                case "2": // eliminar un equipo
                    System.out.println("ingrese el nombre del pais:");
                    nombrePais = dato.nextLine();
                    nombrePais = dato.nextLine().toUpperCase();
                    if (equipos.pertenece(nombrePais)) {
                        equipos.eliminar(nombrePais);
                        System.out.println("el pais " + nombrePais + " ha sido eliminado con exito");
                    } else {
                        System.out.println("el pais " + nombrePais + " NO se encuentra cargado");
                    }
                    break;
                case "3": // modificar un equipo
                    System.out.println("ingrese el nombre del pais:");
                    nombrePais = dato.nextLine();
                    nombrePais = dato.nextLine().toUpperCase();
                    Equipo elEquipo = (Equipo) equipos.recuperar(nombrePais);
                    if (elEquipo != null) {
                        System.out.println("que desea modificar del pais " + nombrePais + "?");
                        System.out.println(
                                "ingrese 1 para modificar al tecnico, 2 para el grupo");
                        letra = dato.next();
                        switch (letra) {
                            case "1":
                                System.out.println("ingrese el apellido del tecnico del pais " + nombrePais);
                                apellido = dato.next().toLowerCase();
                                elEquipo.setTecnico(apellido);
                                break;
                            case "2":
                                System.out.println("ingrese el grupo A/B/C/D del pais " + nombrePais);
                                grupo = dato.next().toUpperCase();
                                elEquipo.setGrupo(grupo);
                                break;
                            default:
                                System.out.println("opcion invalida");
                                break;
                        }
                    } else {
                        System.out.println("el pais " + nombrePais + " NO se encuentra cargado");
                    }
                    break;
                case "4":
                    stop = true;
                    break;
                default:
                    System.out.println("opcion invalida. \ningrese nuevamente.");
                    break;
            }
        } while (!stop);
    }

    public static void verPartidos() {
        String eq1 = "", eq2 = "", instancia = "", ciudad = "", estadio = "";
        int golesE1 = 0, golesE2 = 0;
        Equipo equipo1 = null, equipo2 = null;
        System.out.println("ingrese el nombre del equipo 1:");
        eq1 = dato.nextLine();
        eq1 = dato.nextLine().toUpperCase();
        if (equipos.pertenece(eq1)) {
            System.out.println("ingrese el nombre del equipo 2:");
            eq2 = dato.nextLine();
            eq2 = dato.nextLine().toUpperCase();
            if (equipos.pertenece(eq2)) {
                System.out.println("partido entre " + eq1 + " y " + eq2);
                System.out.println("ingrese la instancia del partido");
                instancia = dato.nextLine();
                instancia = dato.nextLine().toUpperCase();
                System.out.println("ingrese la ciudad donde se jugo el partido");
                ciudad = dato.nextLine();
                ciudad = dato.nextLine().toLowerCase();
                System.out.println("ingrese el estadio donde se jugo el partido");
                estadio = dato.nextLine();
                estadio = dato.nextLine().toLowerCase();
                System.out.println("Ingrese la cantidad de goles del equipo 1: " + eq1);
                golesE1 = dato.nextInt();
                System.out.println("Ingrese la cantidad de goles del equipo 2: " + eq2);
                golesE2 = dato.nextInt();
                equipo1 = (Equipo) equipos.recuperar(eq1);
                equipo2 = (Equipo) equipos.recuperar(eq2);
                equipo1.actualizarEquipo(golesE1, golesE2);
                equipo2.actualizarEquipo(golesE2, golesE1);
                Partido nuPartido = new Partido(eq1, eq2, instancia, ciudad, estadio, golesE1, golesE2);
                partidos.put(nuPartido.getClavePartido(), nuPartido);
                System.out.println("El partido fue cargado correctamente");
            } else {
                System.out.println(" el equipo 2 NO se encuentra cargado");
            }
        } else {
            System.out.println(" el equipo 1 NO se encuentra cargado");
        }
    }

    public static void consultaEquipos() {
        String pais = "", opcion = "", min = "", max = "";
        boolean stop = false;
        do {
            System.out.println("1. obtiene el camino de menor tiempo");
            System.out.println("2. obtiene el camino mas corto");
            System.out.println("3. para salir");
            opcion = dato.next();
            switch (opcion) {
                case "1":
                    System.out.println("ingrese el nombre de un pais:");
                    pais = dato.nextLine();
                    pais = dato.nextLine().toUpperCase();
                    if (equipos.pertenece(pais)) {
                        Equipo elEquipo = (Equipo) equipos.recuperar(pais);
                        System.out.println(elEquipo.datosEquipo());
                    } else {
                        System.out.println("el pais " + pais + " NO se encuentra cargado");
                    }
                    break;
                case "2":
                    System.out.println("ingrese la cadena minima de la lista:");
                    min = dato.next();
                    System.out.println("ingrese la cadena maxima de la lista:");
                    max = dato.next();
                    System.out.println(equipos.listarPorRango(min, max));
                    break;
                case "3":
                    stop = true;
                    break;
                default:
                    System.out.println("opcion invalida. \ningrese nuevamente.");
                    break;
            }
        } while (!stop);
    }

    public static void consultaPartidos() {

    }

    public static void consultaViajes() {
        String origen = "", destino = "", opcion = "", ciudadEvitada = "";
        boolean stop = false;
        System.out.println("ingrese la ciudad de origen");
        origen = dato.nextLine();
        origen = dato.nextLine().toLowerCase();
        System.out.println("ingrese la ciudad de destino");
        destino = dato.nextLine();
        destino = dato.nextLine().toLowerCase();
        if (ciudades.existeVertice(origen) && ciudades.existeVertice(destino)) {
            do {
                System.out.println("1. obtiene el camino de menor tiempo");
                System.out.println("2. obtiene el camino mas corto");
                System.out.println("3. obtiene el camino mas corto si pasar por una ciudad");
                System.out.println("4. todos los posibles caminos");
                System.out.println("5. para salir");
                opcion = dato.next();
                switch (opcion) {
                    case "1":
                        System.out.println("camino desde " + origen + " hasta " + destino + " en menor tiempo:");
                        System.out.println(ciudades.caminoMenorTiempo(origen, destino));
                        break;
                    case "2":
                        System.out.println("camino mas corto desde " + origen + " hasta " + destino + ":");
                        System.out.println(ciudades.caminoMasCorto(origen, destino));
                        break;
                    case "3":
                        System.out.println("ingrese la ciudad que desea evitar:");
                        ciudadEvitada = dato.nextLine();
                        ciudadEvitada = dato.nextLine().toLowerCase();
                        System.out.println("camino mas corto desde " + origen + " hasta " + destino + " sin pasar por "
                                + ciudadEvitada + ":");
                        System.out.println(ciudades.caminoMasCortoSinCiudad(origen, destino, ciudadEvitada));
                        break;
                    case "4":
                        System.out.println("todos los posibles caminos desde " + origen + " hasta " + destino + ":");
                        System.out.println(ciudades.todosLosCaminos(origen, destino, null));
                        // filtrar por alojamiento y pasar por ciudad
                        break;
                    case "5":
                        stop = true;
                        break;

                    default:
                        System.out.println("opcion invalida. \ningrese nuevamente.");
                        break;
                }
            } while (!stop);
        } else {
            System.out.println("error. una de las ciudades NO se encuentra cargada");
        }
    }

    public static void listadoEquipos() {

    }

    public static void mostrarSistema() {
        System.out.println(
                "//////////////////////////////////////////////////////////estructura de ciudades//////////////////////////////////////////////////////////");
        System.out.println(ciudades.toString());
        System.out.println(
                "//////////////////////////////////////////////////////////estructura de equipos//////////////////////////////////////////////////////////");
        System.out.println(equipos.toString());
        System.out.println(
                "//////////////////////////////////////////////////////////estructura de partidos//////////////////////////////////////////////////////////");
        System.out.println(partidos.toString());
    }

    public static void limpiarLog() {
        try (Writer w = new FileWriter("log.txt")) {
            w.write("INICIO DEL SISTEMA\r\n");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }
}
