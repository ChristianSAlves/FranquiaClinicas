/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package franquiaclinicas.controller;

import java.util.Scanner;
import view.Menus;

/**
 *
 * @author canad
 */
public class MedicoController {

    Menus tela = new Menus();
    Scanner scanner = new Scanner(System.in);

    public MedicoController() {

    }

    public void telaMedico() {

    int opcaoUsuario;
  
        do {
            opcaoUsuario = tela.MenuMedicoFranquia();
        switch (opcaoUsuario) {
            
            case 0:
                
                break;
            
            case 1:

                break;
                
            case 2:
                
                break;
                
            case 3:
                
                break;

        }

    }
    while(opcaoUsuario != 0); 
    }
}
