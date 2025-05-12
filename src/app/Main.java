// ===== Package: app =====
package app;

import model.*;
import strategy.*;
import factory.*;
import decorator.*;

import java.util.*;
import java.util.Scanner;
import java.io.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Main {
    private static final String ALUNOS_FILE = "alunos.json";
    private static final String INSTRUTOR_FILE = "instrutor.json";
    private static final String ACADEMIA_FILE = "academia.json";

    public static void salvarAlunos(List<Aluno> alunos) {
        try (Writer writer = new FileWriter(ALUNOS_FILE)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(alunos, writer);
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados dos alunos: " + e.getMessage());
        }
    }

    public static List<Aluno> carregarAlunos() {
        try (Reader reader = new FileReader(ALUNOS_FILE)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, new TypeToken<List<Aluno>>(){}.getType());
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static void salvarInstrutor(Instrutor instrutor) {
        try (Writer writer = new FileWriter(INSTRUTOR_FILE)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(instrutor, writer);
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados do instrutor: " + e.getMessage());
        }
    }

    public static Instrutor carregarInstrutor() {
        try (Reader reader = new FileReader(INSTRUTOR_FILE)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, Instrutor.class);
        } catch (IOException e) {
            return null;
        }
    }

    public static void salvarAcademia(Academia academia) {
        try (Writer writer = new FileWriter(ACADEMIA_FILE)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(academia, writer);
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados da academia: " + e.getMessage());
        }
    }

    public static Academia carregarAcademia() {
        try (Reader reader = new FileReader(ACADEMIA_FILE)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, Academia.class);
        } catch (IOException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Aluno> alunos = carregarAlunos();
        Aluno alunoSelecionado = null;

        Academia academia = carregarAcademia();
        if (academia == null) {
            Endereco enderecoAcademia = new Endereco(1, "Rua Fitness", "100", "", "Centro", "FitCity", "FC", "12345-678");
            academia = Academia.getInstancia();
            academia.cadastrarAcademia(1, "Academia Strong", "ACD123", enderecoAcademia);
            salvarAcademia(academia);
        }

        Instrutor instrutor = carregarInstrutor();
        if (instrutor == null) {
            instrutor = new Instrutor();
            instrutor.setNome("Carlos Personal");
            instrutor.cadastrarInstrutor("Musculação", academia);
            salvarInstrutor(instrutor);
        }

        while (true) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Cadastrar Novo Aluno");
            System.out.println("2. Selecionar Aluno Existente");
            System.out.println("3. Realizar Pagamento");
            System.out.println("4. Exibir Dados do Aluno");
            System.out.println("5. Adicionar Avaliação Física");
            System.out.println("6. Criar Plano de Treino");
            System.out.println("7. Exibir Plano de Treino");
            System.out.println("8. Exibir Exercícios do Plano");
            System.out.println("9. Adicionar Exercício ao Plano");
            System.out.println("10. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    Aluno novoAluno = new Aluno();
                    System.out.print("Nome do aluno: ");
                    novoAluno.setNome(scanner.nextLine());
                    System.out.print("CPF do aluno: ");
                    novoAluno.setCpf(scanner.nextLine());
                    System.out.print("Logradouro: ");
                    String logradouro = scanner.nextLine();
                    System.out.print("Número: ");
                    String numero = scanner.nextLine();
                    System.out.print("Complemento: ");
                    String complemento = scanner.nextLine();
                    System.out.print("Bairro: ");
                    String bairro = scanner.nextLine();
                    System.out.print("Cidade: ");
                    String cidade = scanner.nextLine();
                    System.out.print("UF: ");
                    String uf = scanner.nextLine();
                    System.out.print("CEP: ");
                    String cep = scanner.nextLine();
                    novoAluno.setEndereco(new Endereco(2, logradouro, numero, complemento, bairro, cidade, uf, cep));
                    novoAluno.setPersonalAluno(instrutor);
                    alunos.add(novoAluno);
                    alunoSelecionado = novoAluno;
                    salvarAlunos(alunos);
                    System.out.println("Aluno cadastrado e selecionado com sucesso.");
                    break;
                case 2:
                    if (alunos.isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado.");
                        break;
                    }
                    System.out.println("--- Alunos Cadastrados ---");
                    for (int i = 0; i < alunos.size(); i++) {
                        System.out.println((i + 1) + ". " + alunos.get(i).getNome());
                    }
                    System.out.print("Escolha o número do aluno: ");
                    int index = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (index >= 0 && index < alunos.size()) {
                        alunoSelecionado = alunos.get(index);
                        System.out.println("Aluno selecionado: " + alunoSelecionado.getNome());
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                case 3:
                    if (alunoSelecionado == null) {
                        System.out.println("Nenhum aluno selecionado.");
                        break;
                    }
                    System.out.print("Valor do pagamento: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Forma de pagamento: ");
                    String forma = scanner.nextLine();
                    alunoSelecionado.realizarPagamento(valor, new Date(), forma);
                    salvarAlunos(alunos);
                    System.out.println("Pagamento realizado com sucesso.");
                    break;
                case 4:
                    if (alunoSelecionado == null) {
                        System.out.println("Nenhum aluno selecionado.");
                        break;
                    }
                    System.out.println("--- Dados do aluno com endereço ---");
                    new ExibirDadosComEndereco(alunoSelecionado).exibirDados();
                    break;
                case 5:
                    if (alunoSelecionado == null) {
                        System.out.println("Nenhum aluno selecionado.");
                        break;
                    }
                    AvaliacaoFisica avaliacao = new AvaliacaoFisica();
                    avaliacao.setEstrategia(new CalculoIMCPadrao());
                    System.out.print("Peso: ");
                    avaliacao.setPeso(scanner.nextDouble());
                    System.out.print("Altura: ");
                    avaliacao.setAltura(scanner.nextDouble());
                    scanner.nextLine();
                    alunoSelecionado.adicionarAvaliacaoFisica(avaliacao);
                    salvarAlunos(alunos);
                    System.out.println("Avaliação física adicionada.");
                    break;
                case 6:
                    if (alunoSelecionado == null) {
                        System.out.println("Nenhum aluno selecionado.");
                        break;
                    }
                    PlanoTreinoFactory factory = new PlanoMusculacaoFactory();
                    PlanoTreino plano = factory.criarPlano();
                    alunoSelecionado.adicionarPlanoTreino(plano);
                    salvarAlunos(alunos);
                    System.out.println("Plano de treino criado e adicionado ao aluno.");
                    break;
                case 7:
                    if (alunoSelecionado == null) {
                        System.out.println("Nenhum aluno selecionado.");
                        break;
                    }
                    System.out.println("--- Planos de treino do aluno ---");
                    alunoSelecionado.exibirPlanoTreino();
                    break;
                case 8:
                    if (alunoSelecionado == null) {
                        System.out.println("Nenhum aluno selecionado.");
                        break;
                    }
                    PlanoTreino ultimoPlano = alunoSelecionado.getPlanoTreinoAtual();
                    if (ultimoPlano != null) {
                        System.out.println("--- Exercícios do plano ---");
                        ultimoPlano.getExercicios().forEach(Exercicio::exibirExercicio);
                    } else {
                        System.out.println("Nenhum plano criado ainda.");
                    }
                    break;
                case 9:
                    if (alunoSelecionado == null) {
                        System.out.println("Nenhum aluno selecionado.");
                        break;
                    }
                    PlanoTreino planoAtual = alunoSelecionado.getPlanoTreinoAtual();
                    if (planoAtual == null) {
                        System.out.println("Nenhum plano criado ainda.");
                        break;
                    }
                    System.out.print("Nome do exercício: ");
                    String nomeEx = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String grupo = scanner.nextLine();
                    System.out.print("Duração: ");
                    String duracao = scanner.nextLine();
                    Exercicio exercicio = new Exercicio(nomeEx, grupo, duracao);
                    planoAtual.adicionarExercicio(exercicio);
                    salvarAlunos(alunos);
                    System.out.println("Exercício adicionado ao plano.");
                    break;
                case 10:
                    System.out.println("Salvando dados e encerrando o sistema.");
                    salvarAlunos(alunos);
                    salvarInstrutor(instrutor);
                    salvarAcademia(academia);
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
