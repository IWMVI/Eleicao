package controller;

import java.util.Random;
import java.util.Scanner;

import entities.Eleitores;

public class Funcoes {

    Scanner sc = new Scanner(System.in);
    Eleitores[] eleitores = new Eleitores[3];
    Eleitores[] eleitor = eleitores;

    public void showFuncoes(int opcao) {
        switch (opcao) {

            default:
                System.out.println("Opção inválida!\n");
                System.out.println("--------------\n");
                break;

            case 0:
                System.out.println("Finalizado!\n");
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
                }
                break;
        }
    }
}
