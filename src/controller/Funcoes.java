package controller;

import java.util.Random;
import java.util.Scanner;

import entities.Candidatos;
import entities.Eleitores;

public class Funcoes {

    Scanner sc = new Scanner(System.in);
    Eleitores[] eleitores = new Eleitores[3];
    Eleitores[] eleitor = eleitores;
    Candidatos[] candidatos = new Candidatos[2];
    Candidatos[] candidato = candidatos;

    public void showFuncoes(int opcao) {
        switch (opcao) {

            default:
                System.out.println("\nOpção inválida!\n");
                System.out.println("--------------\n");
                break;

            case 0:
                System.out.println("\nFinalizado!\n");
                System.out.println("--------------\n");
                break;

            case 1:

                System.out.println("---- Cadastro Eleitor ----\n");

                for (int i = 0; i < eleitores.length; i++) {
                    System.out.print("Informe o nome do eleitor: ");
                    String nome = sc.nextLine();

                    Random random = new Random();
                    int secao = random.nextInt(10) + 10;
                    System.out.println("Seção: " + secao + "\n");

                    eleitor[i] = new Eleitores(nome, secao);
                    System.out.println("--------------\n");
                }
                break;

            case 2:
                System.out.println("---- Cadastro Candidato ----\n");
                for (int i = 0; i < candidatos.length; i++) {
                    System.out.print("Informe o nome do candidato: ");
                    String nome = sc.nextLine();

                    System.out.print("Informe o partido: ");
                    int partido = sc.nextInt();
                    sc.nextLine();
                    System.out.println();
                    candidato[i] = new Candidatos(nome, partido);
                }
                break;

            case 3:
                System.out.println("---- Cadastro Votação ----\n");
                for (Eleitores eleitores : eleitor) {
                    System.out.println("Nome: " + eleitores.getNome());
                    System.out.println("Seção: " + eleitores.getSecao());
                    System.out.print("Informe seu voto: ");
                    opcoes();
                    int voto = sc.nextInt();
                    eleitores.setVoto(voto);
                    System.out.println();
                }
                System.out.println("--------------\n");
                break;
        }
    }

    private void opcoes() {
        for (Candidatos candidatos : candidato) {
            System.out.println("Candidato: " + candidatos.getNome());
            System.out.println("Partido: " + candidatos.getPartido());
        }
    }
}
