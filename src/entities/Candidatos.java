package entities;

public class Candidatos {

    private String nome;
    private int numero;
    private int cont;

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

    public void setVoto() {

    }

    public int getVotos() {
        return cont;
    }
}
