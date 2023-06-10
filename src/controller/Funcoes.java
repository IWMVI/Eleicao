package controller;

import java.util.Random;
import java.util.Scanner;

import entities.Candidatos;
import entities.Eleitores;

public class Funcoes {

    Scanner sc = new Scanner(System.in);
    Eleitores[] eleitores = new Eleitores[5];
    Eleitores[] eleitor = eleitores;
    Candidatos[] candidatos = new Candidatos[3];
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
                    if (i == candidatos.length - 1) {
                        candidatos[i] = new Candidatos("Nulo", 00);
                        break;
                    }
                    System.out.print("Informe o nome do candidato: ");
                    String nome = sc.nextLine();

                    System.out.print("Informe o partido: ");
                    int partido = sc.nextInt();
                    sc.nextLine();
                    System.out.println();
                    candidato[i] = new Candidatos(nome, partido);
                    System.out.println("--------------\n");
                }
                break;

            case 3:
                System.out.println("---- Cadastro Votação ----\n");
                for (Eleitores eleitor : eleitores) {
                    System.out.println("Nome: " + eleitor.getNome());
                    System.out.println("Seção: " + eleitor.getSecao());
                    opcoes();
                    System.out.println();
                    System.out.print("Informe seu voto: ");
                    int voto = sc.nextInt();
                    while (voto != 0 && voto != candidato[0].getPartido() && voto != candidato[1].getPartido()) {
                        System.out.println("Voto inválido!");
                        System.out.print("Informe seu voto: ");
                        voto = sc.nextInt();
                    }
                    eleitor.setVoto(voto);
                    System.out.println("\n--------------\n");
                }
                System.out.println("--------------\n");
                break;

            case 4:
                System.out.println("---- Atualizar Votação ----\n");

                Candidatos nulo = new Candidatos();
                for (int i = 0; i < eleitores.length; i++) {
                    for (int j = 0; j < candidatos.length; j++) {
                        if (candidato[j].getPartido() == eleitores[i].getVoto()) {
                            candidato[j].setVotos();
                        }
                    }
                }

                System.out.println("Votação atualizada!\n");
                System.out.println("--------------\n");
                break;

            case 5:
                System.out.println("---- Resultados ----\n");
                for (Candidatos candidatos : candidato) {
                    if (candidatos.getPartido() == 00) {
                        System.out.println("Votos Nulos: " + candidatos.getVotos());
                        break;
                    }
                    System.out.println("Nome: " + candidatos.getNome());
                    System.out.println("Partido: " + candidatos.getPartido());
                    System.out.println("Votos: " + candidatos.getVotos());
                    System.out.println();
                }
                
                System.out.println("\n--------------\n");
                break;
        }
    }

    public void opcoes() {

        System.out.println();
        for (Candidatos candidatos : candidato) {
            System.out.println(candidatos.getPartido() + " - " + candidatos.getNome());
            System.out.println();
        }
    }
}
