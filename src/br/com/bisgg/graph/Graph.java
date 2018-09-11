package br.com.bisgg.graph;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Graph extends Edges {

    private List<Edges> edgesOrigin;
    private List<Edges> edgesDestination;
    private String graphFile;
    private int nodes;
    private int edges;

    public Graph (String graphFile) {
        this.graphFile = graphFile;
    }

    public void createGraph () throws IOException, ClassNotFoundException {
        int j = 0;

        List<String> graphMainData = this.createEdges();
        int size = graphMainData.size();

        while (j < size) {

            this.setE1(Collections.singletonList(graphMainData.get(j).split(" ")[0]));
            this.setE2(Collections.singletonList(graphMainData.get(j).split(" ")[1]));

            System.out.print(this.getE1()+" -> "+this.getE2()+"\n");
            j++;
        }
    }

    public List<String> createEdges () throws IOException, ClassNotFoundException {

        Eloquent eloquent = new Eloquent(this.graphFile);
        LinkedList<String> graph_data = eloquent.readGraphFile();

        List<String> rows = graph_data.stream().filter(line -> line.split(" ").length == 2 && !line.equals("-1 -1")).collect(Collectors.toList());
        int graphSize = rows.size();

        int nodes = 0, edges = 0;

        // Inicializa uma variável de controle de erro. Começa com a hipótese de um grafo válido, caso valor false há erro nas especificações das arestas
        int i = 0, j = 0;
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
                i++;
            }
        }

        if (!state)
            System.out.println("\bImpossível gerar o grafo.\nHá um erro na adjacência da posição " + indexOfError + " do arquivo.\n=> G(" + graph_data.get(lineOfError) + ", ?)");

        // Seta a quantidade de nós e arestas do grafo
        this.setNodes(nodes);
        this.setEdges(edges);

        return rows;
    }

    public int getNodes() {
        return nodes;
    }

    public void setNodes(int nodes) {
        this.nodes = nodes;
    }

    public int getEdges() {
        return edges;
    }

    public void setEdges(int edges) {
        this.edges = edges;
    }
}
