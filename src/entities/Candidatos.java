package entities;

public class Candidatos {

    private String nome;
    private int numero;
    private int voto;
    private int nulos;

    public Candidatos() {

    }

    public Candidatos(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public int getPartido() {
        return numero;
    }

    public void setVotos() {
        voto++;
    }

    public int getVotos() {
        return voto;
    }

    public void setNulos() {
        nulos++;
    }

    public int getNulos() {
        return nulos;
    }
}
