package view;

import java.util.Scanner;

public class Menu {

    private int opcao;

    public int getOpcao() {
        return opcao;
    }

    public void showMenu(Scanner sc) {
        System.out.println("---- MENU ----\n");
        System.out.println("01. Cadastrar Eleitor");
        System.out.println("02. Cadastrar Candidato");
        System.out.println("03. Cadastrar Votação");
        System.out.println("04. Atualizar Votação");
        System.out.println("05. Mostrar Resultados");
        System.out.println("06. Gravar Dados");
        System.out.println("00. Finalizar");
        System.out.print("Opção: ");
        this.opcao = sc.nextInt();
        System.out.println("\n--------------\n");
    }

}
