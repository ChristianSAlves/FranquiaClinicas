/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Scanner;

/**
 *
 * @author Christian
 */
public final class Menus {

     Scanner scanner = new Scanner(System.in);
    
    public int TelaInicial() {
       
        StringBuilder builder = new StringBuilder("");

        builder.append("MENU INICIAL\n\n");
        builder.append("\n1 - Logar");
        builder.append("\n2 - Cadastrar pessoa");
        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    public int MenuDonoFranquia() {

        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder("");

        builder.append("MENU DONO FRANQUIA\n\n");
        builder.append("\n1 - Opções para pessoas");
        builder.append("\n2 - Opções para medicos");
        builder.append("\n3 - Opções para funcionarios administrativos");
        builder.append("\n4 - Ver todas as consultas");
        builder.append("\n5 - Ver todos os procedimentos");
        builder.append("\n6 - Gerar relatório da franquia");
        builder.append("\n0 - Deslogar");
        builder.append("\nQual sua opção ? R: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    public int MenuMedicoFranquia() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder("");

        builder.append("MENU MEDICO\n\n");
        builder.append("\n1 - Alterar status da consulta");
        builder.append("\n2 - Alterar status do procedimento \n");
        builder.append("\n0 - Sair do programa\n");
        builder.append("\nQual sua opção ? R: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    public int MenuPaciente() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder("");

        builder.append("MENU PACIENTE\n\n");
        builder.append("\n1 - Visualizar consultas");
        builder.append("\n2 - Visualizar procedimento");
        builder.append("\nQual sua opção ? R: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    public int MenuAdmnistrativo() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder("");

        builder.append("MENU ADMINISTRATIVO\n\n");
        builder.append("\n1 - Opçoes pessoas");
        builder.append("\n2 - Opçoes medicos");
        builder.append("\n3 - Marcar consulta");
        builder.append("\n4 - Alterar status da consulta");
        builder.append("\n5 - Marcar procedimento");
        builder.append("\n6 - Alterar status do procedimento \n");
        builder.append("\n0 - Sair do programa\n");
        builder.append("\nQual sua opção ? R: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    public int opcaoPessoas() {

        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder("");

        builder.append("OPÇOES PESSOAS\n\n");
        builder.append("\n1 - Cadastrar paciente");
        builder.append("\n2 - Atualizar dados do paciente");
        builder.append("\n3 - Mudar status do paciente");
        builder.append("\n4 - Mostrar todos pacientes");
        builder.append("\n5 - Buscar paciente pelo nome");
        builder.append("\n6 - Buscar paciente pelo cpf");
        builder.append("\n0 - Sair");
        builder.append("\nQual sua opção ? R: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    public int menuAtualizaDadosPaciente() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder("");

        builder.append("Atualizar dados\n\n");
        builder.append("\n1 - Alterar nome");
        builder.append("\n2 - Alterar endereço");
        builder.append("\n3 - Alterar telefone");
        builder.append("\n0 - Sair");
        builder.append("\nQual sua opção ? R: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }
    
    public int opcaoMedicos() {

        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder("");

        builder.append("Opcoes medicos\n\n");
        builder.append("\n1 - Cadastrar Medico");
        builder.append("\n2 - Atualizar dados do medico");
        builder.append("\n3 - Mostrar todos medicos");
        builder.append("\n4 - Buscar medico pelo crm");
        builder.append("\n0 - Sair");
        builder.append("\nQual sua opção ? R: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }
    
    public int atualizaDadosMedicos(){
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder("");

        builder.append("Opcoes medicos\n\n");
        builder.append("\n1 - Alterar CRM");
        builder.append("\n2 - Alterar Especialidade");
        builder.append("\n0 - Sair");
        builder.append("\nQual sua opção ? R: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

}
