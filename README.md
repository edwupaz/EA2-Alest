# Trabalho 2 - ALEST1 - Árvore Binária de Pesquisa

## 📌 Sobre o Trabalho:

Este repositório contém a implementação de uma Árvore Binária de Pesquisa em Java, como parte do trabalho 2 da disciplina Algoritmos e Estruturas de Dados I.

Operações Presentes no Trabalho:

- Leitura de um conjunto de chaves inteiras a partir de um arquivo.
- Construção da árvore binária com inserções na ordem fornecida.
- Execução de quatro tipos de caminhamento: pré-ordem, central, pós-ordem e por largura.
- Busca de uma chave específica definida como a última linha do arquivo.
- Geração de arquivos de texto contendo os resultados de cada operação.

---

## ⚙️ Funcionalidades do Projeto:

### 1. Leitura e Construção da Árvore:

- Os dados são lidos a partir do arquivo `entrada.txt`.
- Todos os valores, **exceto o último**, são inseridos na árvore binária na ordem em que aparecem.
- O **último valor** é tratado como a **chave a ser buscada** na árvore.

### 2. Caminhamentos na Árvore:

A aplicação realiza quatro tipos de caminhamento, salvando os resultados em arquivos separados dentro da pasta `saida/`:

- **Pré-ordem** (raiz → esquerda → direita) → `saida/preordem.txt`
- **Central** (esquerda → raiz → direita) → `saida/central.txt`
- **Pós-ordem** (esquerda → direita → raiz) → `saida/posordem.txt`
- **Em largura** (nível por nível) → `saida/largura.txt`

Cada arquivo contém as chaves visitadas, uma por linha.

### 3. Pesquisa de Chave:

- O programa realiza a **busca iterativa** da chave especificada na última linha do `entrada.txt`.
- Gera o arquivo `saida/resultado.txt` contendo:
  - Todas as chaves dos nós visitados durante a busca.
  - Na última linha, o **número total de nós visitados**.
  - Uma mensagem final indicando se a chave foi **"Achou"** ou **"Não Achou"**.

---
