package controller;

import java.util.List;

import DAO.ContaDAO;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;
import view.ContaView;

import java.util.List;

public class ContaController {

    private final ContaView view;
    private final ContaDAO dao;

    public ContaController(ContaView view, ContaDAO dao) {
        this.view = view;
        this.dao = dao;
    }

    public void iniciar() {
        int opcao;
        do {
            opcao = view.mostrarMenuEObterOpcao();

            switch (opcao) {
                case 1 -> cadastrarContaCorrente();
                case 2 -> cadastrarContaPoupanca();
                case 3 -> listarContas();
                case 4 -> atualizarConta();
                case 5 -> excluirConta();
                case 0 -> view.exibirMensagem("Saindo...");
                default -> view.exibirMensagem("Opção inválida!");
            }

            System.out.println();

        } while (opcao != 0);
    }

    private void cadastrarContaCorrente() {
        view.exibirMensagem("== Nova Conta Corrente ==");

        String numero = view.lerString("Número: ");
        String titular = view.lerString("Titular: ");
        double saldo = view.lerDouble("Saldo inicial: ");
        double limite = view.lerDouble("Limite: ");

        ContaCorrente cc = new ContaCorrente(null, numero, titular, saldo, limite);
        dao.salvar(cc);

        view.exibirMensagem("Conta Corrente cadastrada com ID: " + cc.getId());
    }

    private void cadastrarContaPoupanca() {
        view.exibirMensagem("== Nova Conta Poupança ==");

        String numero = view.lerString("Número: ");
        String titular = view.lerString("Titular: ");
        double saldo = view.lerDouble("Saldo inicial: ");
        double taxa = view.lerDouble("Taxa de rendimento (%): ");

        ContaPoupanca cp = new ContaPoupanca(null, numero, titular, saldo, taxa);
        dao.salvar(cp);

        view.exibirMensagem("Conta Poupança cadastrada com ID: " + cp.getId());
    }

    private void listarContas() {
        List<Conta> contas = dao.listarTodos();
        view.exibirContas(contas);
    }

    private void atualizarConta() {
        view.exibirMensagem("== Atualizar Conta ==");
        int id = view.lerInt("Informe o ID da conta: ");

        Conta conta = dao.buscarPorId(id);
        if (conta == null) {
            view.exibirMensagem("Conta não encontrada.");
            return;
        }

        view.exibirConta(conta);

        String novoNumero = view.lerString("Novo número (atual: " + conta.getNumero() + "): ");
        String novoTitular = view.lerString("Novo titular (atual: " + conta.getTitular() + "): ");
        double novoSaldo = view.lerDouble("Novo saldo (atual: " + conta.getSaldo() + "): ");

        conta.setNumero(novoNumero);
        conta.setTitular(novoTitular);
        conta.setSaldo(novoSaldo);

        if (conta instanceof ContaCorrente cc) {
            double novoLimite = view.lerDouble("Novo limite (atual: " + cc.getLimite() + "): ");
            cc.setLimite(novoLimite);
        } else if (conta instanceof ContaPoupanca cp) {
            double novaTaxa = view.lerDouble("Nova taxa (%), atual: " + cp.getTaxaRendimento() + ": ");
            cp.setTaxaRendimento(novaTaxa);
        }

        dao.atualizar(conta);
        view.exibirMensagem("Conta atualizada com sucesso!");
    }

    private void excluirConta() {
        view.exibirMensagem("== Excluir Conta ==");
        int id = view.lerInt("Informe o ID da conta: ");

        Conta conta = dao.buscarPorId(id);
        if (conta == null) {
            view.exibirMensagem("Conta não encontrada.");
            return;
        }

        if (view.confirmarExclusao(conta)) {
            dao.deletar(id);
            view.exibirMensagem("Conta excluída com sucesso!");
        } else {
            view.exibirMensagem("Operação cancelada.");
        }
    }
}