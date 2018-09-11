package br.com.bisgg.graph;

import br.com.bisgg.persistencia.Persistencia;

import java.io.IOException;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Eloquent extends Persistencia {

    private String graph_file;

    public Eloquent (String graphFile) {
        this.graph_file = graphFile;
    }

    private LinkedList<String> readGraphFile () throws IOException, ClassNotFoundException {

        LinkedList<String> objects = new LinkedList<>();

        try {
            // Se o arquivo de dados do grafo não é vazio, ele obtem os objetos, caso inverso, retorna o valor padrão nulo
            if (!this.isEmpty(this.graph_file))
                objects = this.get(this.graph_file);

        } catch (IOException e) {
            e.printStackTrace();
        }

       return objects;
    }

    public List<String> getGraphData () throws IOException, ClassNotFoundException {

        LinkedList<String> graph_data = this.readGraphFile();

        List<String> rows = graph_data.stream().filter(line -> line.split(" ").length == 2 && !line.equals("-1 -1")).collect(Collectors.toList());
        int graphSize = rows.size();

        int nodes = 0, edges = 0;

        // Inicializa uma variável de controle de erro. Começa com a hipótese de um grafo válido, caso valor false há erro nas especificações das arestas
        int i = 0;
        int indexOfError = 0;
        int lineOfError = 0;

        boolean state = true;

         /*
            *
            * Verifica se o grafo contém o número de nós e arestas, respectivamente, na primeira e segunda linha do arquivo.
            *
            * Primeiro fragmento: verifica se a posição que é pra está o nó/aresta está vazia;
            * Segundo fragmento: verifica a quantidade de caracteres (retirando o espaço) que existe na linha, se for maior
              igual a 2 significa que aquela informação tende a ser de uma adjacência (V, A) origem/destino;
            *
            *
            * */
        if (graph_data.get(0).isEmpty() || graph_data.get(0).split(" ").length >= 2) {
            System.out.println("\bImpossível gerar o grafo.\nHá um erro nas especificações básicas de (V, A) na primeira linha do arquivo.");
        } else {

            // Obtém a quantidade de nós e arestas do grafo
            nodes = Integer.parseInt(graph_data.get(0));
            edges = graph_data.size() - 2;

            while (i < graphSize) {
                /*
                 *
                 * Verifica se a linha atual é uma linha que contém informações sobre adjacência do tipo 1 2;
                 * A especificação mínima é estar, pelo menos, na segunda linha e ela ser diferente de -1 -1, onde identifica ser o fim do arquivo
                 * */
                if (!(rows.get(i).equals("-1 -1"))) {

                    /*
                     *
                     * Erro nas especificações das arestas
                     *
                     * Se o número de arestas (tamanho da lista) for menor que o numero de arestas esperadas dentro das ligações do arquivo,
                       retorna um erro, pois em algum momento a expressão lambda decidiu, por meio das especificações
                       da condição, não filtrar aquele item sem um vértice de destino e/ou origem, logo, para a condição ser satisfeita, o número de arestas
                       esperada no tamanho da lista de GraphData deve ser do tamanho da lista de Rows, onde as mesmas foram filtradas;
                     *
                     * */
                    if (rows.size() < edges) {
                        indexOfError = i - 1;
                        lineOfError = i;
                        state = false;
                    }
                }

                i++;
            }
        }

        if (!state)
            System.out.println("\bImpossível gerar o grafo.\nHá um erro na adjacência da posição " + indexOfError + " do arquivo.\n=> G(" + graph_data.get(lineOfError) + ", ?)");

       return rows;
    }
}
