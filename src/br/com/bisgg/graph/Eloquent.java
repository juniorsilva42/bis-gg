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

        try {

            LinkedList<String> graph_data = this.readGraphFile();
            int countLine = 0;

            int nodes = 0, edges = 0;
            boolean errorInEspecification = false;

            for (int i = 0; i < graph_data.size(); i++) {
                countLine++;

                /*
                *
                * Verifica se o grafo contém o número de nós e arestas, respectivamente, na primeira e segunda linha do arquivo.
                *
                * */
                if (graph_data.get(0).isEmpty() || graph_data.get(1).isEmpty() || (graph_data.get(0).split(" ").length >= 2 || graph_data.get(1).split(" ").length >= 2)) {
                    System.out.println("\bImpossível gerar o grafo.\nHá um erro nas especificações básicas de (V, A) nas duas primeiras linhas do arquivo.");
                    break;
                } else {
                    // Pega os nós e as arestas do grafo. Respectivamente na primeira e segunda linha
                    nodes = Integer.parseInt(graph_data.get(0).trim());
                    edges = Integer.parseInt(graph_data.get(1).trim());
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

                        System.out.println(node_origin + " - " + node_destination);
                    }

                    if (error)
                        System.out.println("\bImpossível gerar o grafo.\nHá um erro na adjacência de posição "+indexOfError+" do arquivo.\n=> G("+graph_data.get(i)+", ?)");
                }

                Graph graph = new Graph(nodes, edges);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
