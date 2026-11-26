package View;

import Model.Pessoa;
import Model.Titulacao;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PessoaView {
    private final Scanner teclado = new Scanner(System.in);

    public int mostrarMenu() {
        mostrarMensagem("\n--- SISTEMA ACADÊMICO ---");
        mostrarMensagem("1 - Cadastrar aluno");
        mostrarMensagem("2 - Cadastrar professor");
        mostrarMensagem("3 - Listar pessoas");
        mostrarMensagem("0 - Sair");

        return lerInteiro("Escolha uma opção: ");
    }

    public String lerCampo(String mensagem) {
        System.out.print(mensagem);
        return teclado.nextLine().trim();
    }

    public int lerInteiro(String mensagem) {
        while (true) {
            String entrada = lerCampo(mensagem);

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                mostrarMensagem("Digite um número inteiro.");
            }
        }
    }

    public Date lerData(String campo) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);

        while (true) {
            String entrada = lerCampo(campo + " (dd/MM/aaaa): ");
            ParsePosition posicao = new ParsePosition(0);
            Date data = formato.parse(entrada, posicao);

            if (entrada.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")
                    && data != null && posicao.getIndex() == entrada.length()) {
                return data;
            }

            mostrarMensagem("Digite uma data válida no formato dd/MM/aaaa.");
        }
    }

    public Titulacao lerTitulacao() {
        Titulacao[] opcoes = Titulacao.values();

        mostrarMensagem("\nTitulação do professor");
        for (int i = 0; i < opcoes.length; i++) {
            mostrarMensagem((i + 1) + " - " + opcoes[i].getDescricao());
        }

        while (true) {
            int escolha = lerInteiro("Escolha a titulação: ");

            if (escolha >= 1 && escolha <= opcoes.length) {
                return opcoes[escolha - 1];
            }

            mostrarMensagem("Escolha uma das opções do menu de titulação.");
        }
    }

    public void mostrarPessoas(List<Pessoa> pessoas) {
        mostrarMensagem("\n--- PESSOAS CADASTRADAS ---");

        if (pessoas.isEmpty()) {
            mostrarMensagem("Nenhuma pessoa cadastrada.");
            return;
        }

        for (Pessoa pessoa : pessoas) {
            mostrarMensagem(pessoa.getDescricao());
        }
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}