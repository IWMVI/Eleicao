package view;

import java.util.Scanner;

import controller.Funcoes;

public class Principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Funcoes funcoes = new Funcoes();
        Menu menu = new Menu();

        do {
            menu.showMenu(sc);
            funcoes.showFuncoes(menu.getOpcao());
        } while (menu.getOpcao() != 0);

        sc.close();
    }
}
