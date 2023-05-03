/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package franquiaclinicas.controller;

import franquiaclinicas.dao.MedicoDAO;
import franquiaclinicas.dao.PessoaDAO;
import franquiaclinicas.model.Medico;
import franquiaclinicas.model.Pessoa;
import java.time.LocalDateTime;
import java.util.Scanner;
import view.Menus;

/**
 *
 * @author canad
 */
public class AdministrativoController {

    Menus tela = new Menus();

    public AdministrativoController(Pessoa pessoa, PessoaDAO pessoaDAO, MedicoDAO medicoDAO) {
        telaADM(pessoa, pessoaDAO, medicoDAO);
    }

    public void telaADM(Pessoa pessoa, PessoaDAO pessoaDAO, MedicoDAO medicoDAO) {
        Scanner scanner = new Scanner(System.in);
        int opcaoUsuario;
        do {
            opcaoUsuario = tela.MenuAdmnistrativo();
            switch (opcaoUsuario) {

                case 0:

                    break;

                case 1:
                    do {
                        opcaoUsuario = tela.opcaoPessoas();
                        switch (opcaoUsuario) {

                            case 0:

                                break;
                            case 1:
                                //cadastro paciente
                                System.out.println("Digite seu nome:");
                                String nome = scanner.nextLine();
                                System.out.println("Digite seu endereco:");
                                String endereco = scanner.nextLine();
                                System.out.println("Digite seu cpf:");
                                String cpf = scanner.nextLine();
                                System.out.println("Digite seu telefone:");
                                String telefone = scanner.nextLine();
                                String tipoUsuario;
                                tipoUsuario = "Paciente";
                                String Status = "Ativo";
                                System.out.println("Digite seu login:");
                                String login = scanner.nextLine();
                                System.out.println("Digite sua sua senha:");
                                String senha = scanner.nextLine();

                                Pessoa pessoa2 = new Pessoa(nome, endereco, cpf, telefone, login, senha, tipoUsuario, Status, LocalDateTime.now());
                                pessoaDAO.adicionaPessoa(pessoa2);
                                break;

                            case 2:
                                //atualizar dados paciente
                                setaDadosPaciente(pessoa, pessoaDAO);
                                break;

                            case 3:
                                //mudar status do paciente (ativo ou inativo)
                                System.out.println("Digite o nome do paciente que deseja alterar o status:");
                                String nomePaciente = scanner.nextLine();

                                pessoaDAO.alterarStatus(nomePaciente);
                                break;

                            case 4:
                                pessoaDAO.mostrarTodos();
                                break;
                        }
                    } while (opcaoUsuario != 0);
                    break;

                case 2:

                    break;
                
                case 3:
                    
                    break;
            }

        } while (opcaoUsuario != 0);
    }

    public void setaDadosPaciente(Pessoa pessoa, PessoaDAO pessoaDAO) {
        Scanner scanner = new Scanner(System.in);
        int opcaoUsuario;
        do {
            opcaoUsuario = tela.menuAtualizaDadosPaciente();
            switch (opcaoUsuario) {
                case 0:

                    break;

                case 1:
                    System.out.println("Digite o nome do paciente que sera mudado:");
                    String nomeAntigo = scanner.nextLine();
                    System.out.println("Digite o cpf do paciente:");
                    String cpfp = scanner.nextLine();
                    System.out.println("Digite o novo nome do paciente");
                    String novoNome = scanner.nextLine();

                    pessoaDAO.alterarNome(nomeAntigo, novoNome, cpfp);
                    break;

                case 2:

                    System.out.println("Digite o nome do paciente que deseja alterar o telefone:");
                    String nomeP = scanner.nextLine();
                    System.out.println("Digite o novo endereço do paciente");
                    String novoEndereco = scanner.nextLine();

                    pessoaDAO.alterarEndereco(nomeP, novoEndereco);
                    break;

                case 3:

                    System.out.println("Digite o nome do paciente que deseja alterar o telefone:");
                    String nomePaciente = scanner.nextLine();
                    System.out.println("Digite o novo nome do paciente");
                    String novoTelefone = scanner.nextLine();

                    pessoaDAO.alterarTelefone(nomePaciente, novoTelefone);

                    break;

            }
        } while (opcaoUsuario != 0);
    }

}
