package estruturas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ArvoreBinariaPesquisa {

    private class Nodo {
        private int chave;
        private Nodo esquerda;
        private Nodo direita;
        private Nodo pai;

        public Nodo(int chave) {
            this.chave = chave;
            this.esquerda = null;
            this.direita = null;
            this.pai = null;
        }
    }

    private Nodo raiz;
    private int tamanho;

    public ArvoreBinariaPesquisa() {
        this.raiz = null;
        this.tamanho = 0;
    }

    public void adicionar(int chave) {
        Nodo novoNodo = new Nodo(chave);
        if (raiz == null) {
            raiz = novoNodo;
        } else {
            adicionarRecursivo(novoNodo, raiz);
        }
        tamanho++;
    }

    private void adicionarRecursivo(Nodo novoNodo, Nodo atual) {
        if (novoNodo.chave <= atual.chave) {
            if (atual.esquerda == null) {
                atual.esquerda = novoNodo;
                novoNodo.pai = atual;
            } else {
                adicionarRecursivo(novoNodo, atual.esquerda);
            }
        } else {
            if (atual.direita == null) {
                atual.direita = novoNodo;
                novoNodo.pai = atual;
            } else {
                adicionarRecursivo(novoNodo, atual.direita);
            }
        }
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    public List<Integer> percorrerEmPreOrdem() {
        List<Integer> resultado = new ArrayList<>();
        percorrerEmPreOrdemRecursivo(raiz, resultado);
        return resultado;
    }

    private void percorrerEmPreOrdemRecursivo(Nodo nodo, List<Integer> resultado) {
        if (nodo != null) {
            resultado.add(nodo.chave);
            percorrerEmPreOrdemRecursivo(nodo.esquerda, resultado);
            percorrerEmPreOrdemRecursivo(nodo.direita, resultado);
        }
    }

    public List<Integer> percorrerEmOrdemCentral() {
        List<Integer> resultado = new ArrayList<>();
        percorrerEmOrdemCentralRecursivo(raiz, resultado);
        return resultado;
    }

    private void percorrerEmOrdemCentralRecursivo(Nodo nodo, List<Integer> resultado) {
        if (nodo != null) {
            percorrerEmOrdemCentralRecursivo(nodo.esquerda, resultado);
            resultado.add(nodo.chave);
            percorrerEmOrdemCentralRecursivo(nodo.direita, resultado);
        }
    }

    public List<Integer> percorrerEmPosOrdem() {
        List<Integer> resultado = new ArrayList<>();
        percorrerEmPosOrdemRecursivo(raiz, resultado);
        return resultado;
    }

    private void percorrerEmPosOrdemRecursivo(Nodo nodo, List<Integer> resultado) {
        if (nodo != null) {
            percorrerEmPosOrdemRecursivo(nodo.esquerda, resultado);
            percorrerEmPosOrdemRecursivo(nodo.direita, resultado);
            resultado.add(nodo.chave);
        }
    }

    public List<Integer> percorrerEmLargura() {
        List<Integer> resultado = new ArrayList<>();
        if (raiz == null) {
            return resultado;
        }

        Queue<Nodo> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            Nodo atual = fila.remove();
            resultado.add(atual.chave);

            if (atual.esquerda != null) {
                fila.add(atual.esquerda);
            }
            if (atual.direita != null) {
                fila.add(atual.direita);
            }
        }
        return resultado;
    }

    public static class ResultadoPesquisa {
        public boolean encontrado;
        public List<Integer> chavesVisitadas;
        public int quantidadeVisitados;

        public ResultadoPesquisa(boolean encontrado, List<Integer> chavesVisitadas, int quantidadeVisitados) {
            this.encontrado = encontrado;
            this.chavesVisitadas = chavesVisitadas;
            this.quantidadeVisitados = quantidadeVisitados;
        }
    }

    public ResultadoPesquisa pesquisar(int chave) {
        List<Integer> chavesVisitadas = new ArrayList<>();
        Nodo resultadoNodo = pesquisarRecursivo(raiz, chave, chavesVisitadas);
        boolean encontrado = (resultadoNodo != null && resultadoNodo.chave == chave);
        return new ResultadoPesquisa(encontrado, chavesVisitadas, chavesVisitadas.size());
    }

    private Nodo pesquisarRecursivo(Nodo atual, int chave, List<Integer> chavesVisitadas) {
        if (atual == null) {
            return null;
        }
        chavesVisitadas.add(atual.chave);

        if (chave == atual.chave) {
            return atual;
        } else if (chave < atual.chave) {
            return pesquisarRecursivo(atual.esquerda, chave, chavesVisitadas);
        } else {
            return pesquisarRecursivo(atual.direita, chave, chavesVisitadas);
        }
    }

    public void imprimirArvore() {
        imprimirArvoreRecusivamente(this.raiz, 0);
    }

    private void imprimirArvoreRecusivamente(Nodo raiz, int nivel) {
        if (raiz == null) return;
        nivel += 5;
        imprimirArvoreRecusivamente(raiz.direita, nivel);
        System.out.print("\n");
        for (int i = 5; i < nivel; i++) System.out.print(" ");
        System.out.print(raiz.chave + "\n");
        for (int i = 5; i < nivel; i++) System.out.print(" ");
        imprimirArvoreRecusivamente(raiz.esquerda, nivel);
    }
}