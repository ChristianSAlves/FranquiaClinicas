/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package franquiaclinicas.controller;

import franquiaclinicas.dao.PessoaDAO;
import java.util.Scanner;
import view.Menus;

/**
 *
 * @author canad
 */
public class PacienteController {

    Menus tela = new Menus();
  

    public PacienteController() {
        telaPaciente();
    }
    
    

    public void telaPaciente() {
        Scanner scanner = new Scanner(System.in);
        int opcaoUsuario;
        do {
            opcaoUsuario = tela.MenuPaciente();
            switch (opcaoUsuario) {

                case 0:

                    break;

                case 1:
                    System.out.println("Consultas");
                    break;

                case 2:
                    System.out.println("Procedimentos");
                    break;

            }

        } while (opcaoUsuario != 0);
    }
}
