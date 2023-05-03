/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package franquiaclinicas.controller;

import franquiaclinicas.dao.ConsultaDAO;
import franquiaclinicas.dao.MedicoDAO;
import static franquiaclinicas.dao.MedicoDAO.medicos;
import franquiaclinicas.dao.PessoaDAO;
import static franquiaclinicas.dao.PessoaDAO.pessoas;
import franquiaclinicas.model.Medico;
import franquiaclinicas.model.Pessoa;
import java.time.LocalDateTime;
import java.util.Scanner;
import view.Menus;

/**
 *
 * @author canad
 */
public class DonoController {

    Menus tela = new Menus();
    Scanner scanner = new Scanner(System.in);

    public DonoController(Pessoa pessoa, PessoaDAO pessoaDAO, MedicoDAO medicoDAO, ConsultaDAO consultaDAO) {
        telaDonoFranquia(pessoa, pessoaDAO, medicoDAO, consultaDAO);
    }

    public void telaDonoFranquia(Pessoa pessoa, PessoaDAO pessoaDAO, MedicoDAO medicoDAO, ConsultaDAO consultaDAO) {

        int opcaoUsuario;
        do {
            opcaoUsuario = tela.MenuDonoFranquia();
            switch (opcaoUsuario) {

                case 0:

                    break;

                case 1://opcoes pessoas
                    opPessoas(pessoa, pessoaDAO);
                    break;

                case 2: //opcoes medico
                    opMedicos(medicoDAO, pessoaDAO);
                    break;

                case 3: //opcoes funcionarios adm

                    break;

                case 4: //ver todas as consultas
                    consultaDAO.mostrarTodasConsultas();
                    break;

                case 5: //ver todos procedimentos

                    break;
            }
        } while (opcaoUsuario != 0);
        System.out.println("Saí do menu");
    }

    public void opMedicos(MedicoDAO medicoDAO, PessoaDAO pessoaDAO) {

        int opcaoUsuario;
        do {
            opcaoUsuario = tela.opcaoMedicos();
            switch (opcaoUsuario) {

                case 0:

                    break;
                case 1:
                    //Adiciona Medico
                    // Recebe a entrada do usuário
                    System.out.println("Informe o ID da pessoa para criar um novo objeto Médico:");
                    long id = Long.parseLong(scanner.nextLine());

                    // Procura o objeto Pessoa com o ID informado
                    Pessoa pessoaSelecionada = null;
                    for (Pessoa pessoa : pessoas) {
                        if (pessoa.getId() == id) {
                            pessoaSelecionada = pessoa;
                            break;
                        }
                    }

                    // Cria um novo objeto Médico a partir do objeto Pessoa selecionado
                    if (pessoaSelecionada != null) {

                        System.out.println("Digite o CRM do medico a ser cadastrado");
                        String CRM = scanner.nextLine();
                        System.out.println("Digite a especialidade do medico a ser cadastrado");
                        String especialidade = scanner.nextLine();
                        System.out.println("Digite o login de medico cadastrado");
                        String loginMedico = scanner.nextLine();
                        System.out.println("Digite a senha do medico a ser cadastrado");
                        String senhaMedico = scanner.nextLine();

                        Pessoa pessoamedico = new Pessoa(pessoaSelecionada.getNome(), pessoaSelecionada.getEndereco(),
                                pessoaSelecionada.getCpf(), pessoaSelecionada.getTelefone(), loginMedico, senhaMedico,
                                "Medico", "Ativo",
                                LocalDateTime.now());

                        pessoaDAO.adicionaPessoa(pessoamedico);

                        Medico novoMedico = new Medico(CRM, especialidade, pessoamedico);

                        // Adiciona o novo objeto Médico ao vetor de objetos Médico
                        medicoDAO.adicionaMedico(novoMedico);

                        System.out.println("Novo Médico criado: " + novoMedico);

                    } else {

                        System.out.println("Pessoa com ID " + id + " não encontrada.");

                    }
                    break;

                case 2:
                    //atualizar dados paciente
                    opcaoUsuario = tela.atualizaDadosMedicos();
                    switch (opcaoUsuario) {
                        case 0:

                            break;

                        case 1:
                            System.out.println("Digite o CRM do medico:");
                            String CRM = scanner.nextLine();
                            System.out.println("Digite o novo CRM do medico:");
                            String novoCRM = scanner.nextLine();

                            medicoDAO.alterarCRM(CRM, novoCRM);

                            break;

                        case 2:

                            System.out.println("Digite o CRM do medico:");
                            String CRM1 = scanner.nextLine();
                            System.out.println("Digite a especialidade do medico:");
                            String novaEspecialidade = scanner.nextLine();

                            medicoDAO.alterarEspecialidade(CRM1, novaEspecialidade);
                            break;

                    }
                    break;

                case 3:
                    medicoDAO.mostrarTodos();
                    break;

                case 4: //buscar medico por crm
                    System.out.println("Digite o CRM do medico:");
                    String CRM2 = scanner.nextLine();

                    medicoDAO.buscaPorCRM(CRM2);
                    break;

            }
        } while (opcaoUsuario != 0);
    }

    public void opPessoas(Pessoa pessoa, PessoaDAO pessoaDAO) {

        int opcaoUsuario;
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
    }

}
