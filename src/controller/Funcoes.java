package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

    public void showFuncoes(int opcao) throws IOException {
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

            case 6:
                System.out.println("---- Gravar Dados ----\n");
                System.out.print("Informe o nome do arquivo: ");
                sc.nextLine();
                String nomeArquivo = sc.nextLine();

                String arquivo = nomeArquivo + ".txt";

                try (BufferedWriter escrita = new BufferedWriter(new FileWriter(arquivo))) {
                    escrita.write("---- Eleitores ----\n");
                    escrita.newLine();
                    for (Eleitores eleitor : eleitores) {
                        escrita.write("Eleitor: " + eleitor.getNome() + "\n");
                        escrita.write("Seção: " + eleitor.getSecao() + "\n");
                        escrita.write("Voto: " + eleitor.getVoto() + "\n");
                        escrita.newLine();
                    }
                    escrita.write("---- Candidatos ----\n");
                    escrita.newLine();
                    for (Candidatos candidato : candidatos) {
                        if (candidato.getPartido() == 00) {
                            escrita.write("Votos Nulos: " + candidato.getVotos());
                            break;
                        }

                        escrita.write("Nome: " + candidato.getNome() + "\n");
                        escrita.write("Partido: " + candidato.getPartido() + "\n");
                        escrita.write("Votos: " + candidato.getVotos() + "\n");
                        escrita.newLine();
                    }

                    System.out.println("Dados gravados com sucesso!\n");
                } catch (IOException e) {
                    System.out.println("Erro ao gravar arquivos!");
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
