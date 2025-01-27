/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesTPO;

@SuppressWarnings("rawtypes")
public class EquipoGoles implements Comparable {

    private Equipo equipo;

    // -------------------------------------- CONSTRUCTOR
    // -------------------------------------------------------------------------------------------------------------------------------------------------//
    public EquipoGoles(Equipo unEquipo) {
        equipo = unEquipo;
    }

    // -------------------------------------- GET Y SET
    // -------------------------------------------------------------------------------------------------------------------------------------------------//

    public Equipo getEquipo() {
        return equipo;
    }
    // -------------------------------------- PROPIOS
    // -------------------------------------------------------------------------------------------------------------------------------------------------//

    public boolean equals(Object elem) {
        return equipo.equals(elem);
    }

    public String toString() {
        return this.equipo.getPais() + ", goles a favor: " + this.equipo.getGolesAFavor();
    }

    // -------------------------------------- COMPARE TO
    // -------------------------------------------------------------------------------------------------------------------------------------------------//

    public int compareTo(Object otroEquipo) {
        Integer aux = this.equipo.getGolesAFavor();
        EquipoGoles otro = (EquipoGoles) otroEquipo;
        Integer aux2 = otro.getEquipo().getGolesAFavor();
        return aux.compareTo(aux2);
    }

}
