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

            for (int i = 0; i < graph_data.size(); i++) {
                countLine++;

                // Pega os nós e as arestas do grafo. Respectivamente na primeira e segunda linha
                int nodes = Integer.parseInt(graph_data.get(0).trim());
                int edges = Integer.parseInt(graph_data.get(1).trim());

                if (countLine >= 3 && !(graph_data.get(i).equals("-1 -1"))) {
                    String[] adjacencia = graph_data.get(i).split(" ");

                    // está preenchida a origem e o destino do vértice
                    if (!adjacencia[0].equals(" ") || !adjacencia[1].equals(" ")) {
                        int node_origin = Integer.parseInt(adjacencia[0]);
                        int node_destination = Integer.parseInt(adjacencia[1]);

                        System.out.println(node_origin + " - " + node_destination);
                    } else {
                        System.out.println("Adjcência em " + graph_data.get(i) + " incorreta");
                    }
                }

                Graph graph = new Graph(nodes, edges);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
