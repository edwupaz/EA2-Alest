# Trabalho 2 - ALEST1 - Árvore Binária de Pesquisa

📌 Sobre o Trabalho:
Este repositório contém a implementação de uma Árvore Binária de Pesquisa em Java, desenvolvida para a disciplina de Algoritmos e Estruturas de Dados I.

O projeto lê um conjunto de chaves de um arquivo, constrói a árvore, realiza quatro tipos de caminhamento (pré-ordem, em-ordem, pós-ordem e em largura) e, por fim, executa a busca de uma chave específica. Todos os resultados são salvos em arquivos de texto separados para análise.

📁 Estrutura de Arquivos
Para garantir a clareza e a organização, o projeto segue a estrutura de pastas padrão abaixo. Os arquivos de saída são gerados na pasta saida/.

/
├── .gitignore
├── README.md
├── entrada.txt         <-- Arquivo com os valores de entrada
├── src/
│   ├── App.java        <-- Classe principal que executa a aplicação
│   └── ArvoreBinariaPesquisa.java
└── saida/              <-- Pasta onde os resultados são salvos
    ├── central.txt
    ├── largura.txt
    ├── posordem.txt
    ├── preordem.txt
    └── resultado.txt


---

## ⚙️ Funcionalidades do Projeto

### 1. Leitura e Construção da Árvore
- O programa lê um conjunto de números inteiros a partir do arquivo `entrada.txt`
- Todos os valores, **exceto o último**, são inseridos na árvore na ordem em que aparecem
- O último valor do arquivo é tratado como a **chave de pesquisa**

### 2. Caminhamentos na Árvore
O programa gera quatro arquivos, cada um contendo as chaves visitadas em um tipo de caminhamento:

- **Pré-ordem** (raiz, esquerda, direita) → `saida/preordem.txt`
- **Em ordem (central)** (esquerda, raiz, direita) → `saida/central.txt`
- **Pós-ordem** (esquerda, direita, raiz) → `saida/posordem.txt`
- **Em largura** (nível a nível, BFS) → `saida/largura.txt`

### 3. Pesquisa de Chave
- O programa busca a chave definida na última linha do `entrada.txt`
- Gera o arquivo `saida/resultado.txt`, que contém:
  - As chaves de todos os nós visitados durante a busca (uma por linha)
  - Na última linha, a **quantidade de nós visitados**
  - E uma mensagem indicando se a chave foi **"Achou"** ou **"Não Achou"**

---
