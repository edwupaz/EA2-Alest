import estruturas.ArvoreBinariaPesquisa;
import estruturas.ArvoreBinariaPesquisa.ResultadoPesquisa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {

    private static final String ARQUIVO_ENTRADA = "entrada.txt";
    private static final String ARQUIVO_PREORDEM = "preordem.txt";
    private static final String ARQUIVO_POSORDEM = "posordem.txt";
    private static final String ARQUIVO_CENTRAL = "central.txt";
    private static final String ARQUIVO_LARGURA = "largura.txt";
    private static final String ARQUIVO_RESULTADO_PESQUISA = "resultado.txt";

    public static void main(String[] args) {
        App app = new App();
        app.rodarAplicacao();
    }

    public void rodarAplicacao() {
        System.out.println("Iniciando a aplicação de Arvore Binaria de Pesquisa...");

        List<Integer> chavesParaInserir = new ArrayList<>();
        int chavePesquisa = -1;

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_ENTRADA))) {
            String linha;
            String ultimaLinha = null;

            while ((linha = reader.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    chavesParaInserir.add(Integer.parseInt(linha.trim()));
                    ultimaLinha = linha;
                }
            }

            if (ultimaLinha != null) {
                chavePesquisa = Integer.parseInt(ultimaLinha.trim());
                if (!chavesParaInserir.isEmpty() && chavesParaInserir.get(chavesParaInserir.size() - 1) == chavePesquisa) {
                    chavesParaInserir.remove(chavesParaInserir.size() - 1);
                } else {
                    System.out.println("Aviso: A última linha não foi encontrada como o último elemento inserido na lista de chaves. Verifique o formato do arquivo.");
                }
            } else {
                System.out.println("Erro: O arquivo de entrada está vazio ou não possui chaves.");
                return;
            }

            System.out.println("Arquivo '" + ARQUIVO_ENTRADA + "' lido com sucesso.");
            System.out.println("Chaves para inserção: " + chavesParaInserir);
            System.out.println("Chave para pesquisa: " + chavePesquisa);

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo '" + ARQUIVO_ENTRADA + "': " + e.getMessage());
            return;
        } catch (NumberFormatException e) {
            System.out.println("Erro de formato de número no arquivo '" + ARQUIVO_ENTRADA + "'. Verifique se todas as linhas contêm inteiros válidos.");
            return;
        }

        ArvoreBinariaPesquisa arvore = new ArvoreBinariaPesquisa();
        for (int chave : chavesParaInserir) {
            arvore.adicionar(chave);
        }
        System.out.println("Arvore construída com " + arvore.getTamanho() + " nós.");

        gerarArquivoCaminhamento(arvore.percorrerEmPreOrdem(), ARQUIVO_PREORDEM, "Pré-ordem");
        gerarArquivoCaminhamento(arvore.percorrerEmPosOrdem(), ARQUIVO_POSORDEM, "Pós-ordem");
        gerarArquivoCaminhamento(arvore.percorrerEmOrdemCentral(), ARQUIVO_CENTRAL, "Ordem Central");
        gerarArquivoCaminhamento(arvore.percorrerEmLargura(), ARQUIVO_LARGURA, "Largura");

        ResultadoPesquisa resultadoPesquisa = arvore.pesquisar(chavePesquisa);
        gerarArquivoResultadoPesquisa(resultadoPesquisa, chavePesquisa, ARQUIVO_RESULTADO_PESQUISA);

        System.out.println("Aplicação concluída. Verifique os arquivos de saída gerados.");
    }


    private void gerarArquivoCaminhamento(List<Integer> chaves, String nomeArquivo, String tipoCaminhamento) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (int i = 0; i < chaves.size(); i++) {
                writer.write(String.valueOf(chaves.get(i)));
                if (i < chaves.size() - 1) {
                    writer.newLine();
                }
            }
            System.out.println("Caminhamento em " + tipoCaminhamento + " salvo em '" + nomeArquivo + "'.");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo '" + nomeArquivo + "': " + e.getMessage());
        }
    }

    private void gerarArquivoResultadoPesquisa(ResultadoPesquisa resultado, int chavePesquisada, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (int chave : resultado.chavesVisitadas) {
                writer.write(String.valueOf(chave));
                writer.newLine();
            }

            writer.write("Quantidade de nós visitados: " + resultado.quantidadeVisitados);
            writer.newLine();
            writer.write("Resultado: " + (resultado.encontrado ? "Achou a chave " + chavePesquisada : "Não Achou a chave " + chavePesquisada));
            System.out.println("Resultado da pesquisa salvo em '" + nomeArquivo + "'.");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo '" + nomeArquivo + "': " + e.getMessage());
        }
    }
}