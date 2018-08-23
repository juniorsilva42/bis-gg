package br.com.bisgg.graph;

import br.com.bisgg.persistencia.Persistencia;

import java.io.IOException;
import java.util.LinkedList;

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

    public void getGraphData () throws IOException, ClassNotFoundException {

        LinkedList<Object> retorna = null;

        try {

            LinkedList<String> graph_data = this.readGraphFile();

            int nodes = 0, edges = 0;
            int countLine = 0;

            for (int i = 0; i < graph_data.size(); i++) {
                countLine++;

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
                    System.out.println("\bImpossível gerar o grafo.\nHá um erro nas especificações básicas de (V, A) nas duas primeiras linhas do arquivo.");
                    break;
                } else {
                    nodes = Integer.parseInt(graph_data.get(0));
                    edges = graph_data.size() - 2;
                }

                if (countLine >= 3 && !(graph_data.get(i).equals("-1 -1"))) {

                    String[] adjacencia;
                    adjacencia = graph_data.get(i).split("\\s+");

                    boolean error = false;
                    int indexOfError = 0;
                    int lineOfError = 0;

                    if (adjacencia.length <= 1) {
                        indexOfError = i - 1;
                        lineOfError = i;
                        error = true;
                    } else {
                        int node_origin = Integer.parseInt(adjacencia[0]);
                        int node_destination = Integer.parseInt(adjacencia[1]);

                        // Cria a instância da classe mãe e fomenta as informações principais do Grafo
                        Graph graph = new Graph(nodes, edges);
                    }

                    if (error)
                        System.out.println("\bImpossível gerar o grafo.\nHá um erro na adjacência da posição " + indexOfError + " do arquivo.\n=> G(" + graph_data.get(lineOfError) + ", ?)");
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
