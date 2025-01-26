package clasesTPO;

@SuppressWarnings("rawtypes")
public class Equipo implements Comparable {
    private String nombrePais;
    private String tecnico;
    private String grupoInicial;
    private int puntosTotales;
    private int golesFavor;
    private int golesContra;

    public Equipo(String pa, String tec, String gru) {
        nombrePais = pa;
        tecnico = tec;
        grupoInicial = gru;
        puntosTotales = 0;
        golesFavor = 0;
        golesContra = 0;
    }

    public String getPais() {
        return this.nombrePais;
    }

    public String getTecnico() {
        return this.tecnico;
    }

    public String getGrupo() {
        return this.grupoInicial;
    }

    public void setPais(String nn) {
        nombrePais = nn;
    }

    public void setTecnico(String te) {
        tecnico = te;
    }

    public void setGrupo(String gr) {
        grupoInicial = gr;
    }

    public String toString() {
        return nombrePais + ";" + tecnico + ";" + grupoInicial;
    }

    public int diferenciaDeGoles() {
        return (golesFavor - golesContra);
    }

    public int getPuntos() {
        return this.puntosTotales;
    }

    public void setPuntos(int p) {
        puntosTotales = p;
    }

    public void setGolesAFavor(int F) {
        golesFavor = F;
    }

    public void setGolesEnContra(int c) {
        golesContra = c;
    }

    public boolean equals(Object elem) {

        return nombrePais.equals(elem);
    }

    public void actualizarEquipo(int golFav, int golContra) {
        if (golFav == golContra) {
            puntosTotales++;
        } else {
            if (golFav > golContra) {
                puntosTotales += 3;
            }
        }
        golesFavor = golesFavor + golFav;
        golesContra = golesContra + golContra;
    }

    public int compareTo(Object otroEquipo) {
        int res;
        String cad = otroEquipo.toString();
        res = this.toString().compareTo(cad);
        return res;
    }

    public String datosEquipo() {
        return "equipo: " + nombrePais + "\npuntos totales: " + puntosTotales + "\n goles a favor: " + golesFavor
                + "\n goles en contra: " + golesContra + "\n diferencia de goles: " + diferenciaDeGoles();
    }
}
