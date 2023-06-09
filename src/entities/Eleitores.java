package entities;

public class Eleitores {

    private String nome;
    private int secao;
    private int voto;

    public Eleitores() {

    }

    public Eleitores(String nome, int secao) {
        this.nome = nome;
        this.secao = secao;
    }

    public String getNome() {
        return nome;
    }

    public int getSecao() {
        return secao;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }
}
