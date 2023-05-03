/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package franquiaclinicas.controller;

import franquiaclinicas.dao.AdministrativoDAO;
import franquiaclinicas.dao.ConsultaDAO;
import franquiaclinicas.dao.FranquiaDAO;
import franquiaclinicas.dao.MedicoDAO;
import franquiaclinicas.dao.PessoaDAO;
import franquiaclinicas.dao.UnidadeFranquiaDAO;
import franquiaclinicas.model.Pessoa;
import java.time.LocalDateTime;
import java.util.Scanner;
import view.Menus;

/**
 *
 * @author canad
 */
public class LoginController {
    

    PessoaDAO pessoaDAO = new PessoaDAO();
    MedicoDAO medicoDAO = new MedicoDAO(pessoaDAO);
    AdministrativoDAO admDAO = new AdministrativoDAO(pessoaDAO);
    FranquiaDAO franquiaDAO = new FranquiaDAO(pessoaDAO);
    UnidadeFranquiaDAO unidadeDAO = new UnidadeFranquiaDAO(admDAO, franquiaDAO);
    ConsultaDAO consultaDAO = new ConsultaDAO(pessoaDAO, medicoDAO, unidadeDAO);
    Menus tela = new Menus();
    Scanner scanner = new Scanner(System.in);

    public LoginController() {
        telaInicialController(pessoaDAO);
    }

    public void telaInicialController(PessoaDAO pessoaDAO) {

        int opcaoUsuario;
        do {
            opcaoUsuario = tela.TelaInicial();
            switch (opcaoUsuario) {

                case 0:
                    break;

                case 1:
                    Login(pessoaDAO);
                    break;

                case 2:
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

            }
        } while (opcaoUsuario != 0);
        System.out.println("Saí do menu");
    }

    public void Login(PessoaDAO pessoaDAO) {


        System.out.println("Login:");
        String login = scanner.nextLine();
        System.out.println("Senha:");
        String senha = scanner.nextLine();

        Pessoa Login = pessoaDAO.Login(login, senha);
        if (Login != null) {
            BuscaTipoUsuario(Login, pessoaDAO);
        } else {
            System.out.println("Login nao encontrado");
        }
    }

    public Pessoa BuscaTipoUsuario(Pessoa pessoa, PessoaDAO pessoaDAO) {

        if (pessoa.getTipoUsuario().equals("Medico")) {
            System.out.println("Medico");
        }
        if (pessoa.getTipoUsuario().equals("Paciente")) {
            PacienteController p = new PacienteController();
        }
        if (pessoa.getTipoUsuario().equals("Administrativo")) {
            AdministrativoController a = new AdministrativoController(pessoa, pessoaDAO, medicoDAO);
        }
        if (pessoa.getTipoUsuario().equals("Dono Franquia")) {
            DonoController d = new DonoController(pessoa, pessoaDAO, medicoDAO, consultaDAO);
        }
        if (pessoa.getTipoUsuario().equals("Dono Unidade Franquia")) {
            System.out.println("Dono Unidade Franquia");
        }
        return null;

    }

}
