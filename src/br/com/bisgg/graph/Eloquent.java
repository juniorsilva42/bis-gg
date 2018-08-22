package br.com.bisgg.graph;

import br.com.bisgg.persistencia.Persistencia;

import java.io.IOException;
import java.util.LinkedList;

public class Eloquent extends Persistencia {

    private final String graph_data_test_1 = "graph_data_test_1";
    private final String graph_data_test_2 = "graph_data_test_2";
    private final String graph_data_test_3 = "graph_data_test_3";
    private final String graph_data_test_4 = "graph_data_test_4";

    public LinkedList<Integer> getGraphData (String file) throws IOException, ClassNotFoundException {

        Object o;
        LinkedList<Integer> graph = null;

        try {
            // Se o arquivo de produtos não é vazio, ele obtem os objetos do mesmo, caso inverso, retorna o valor padrão nulo
            if (!this.isEmpty(file)) {
                o = this.get(file);
                graph = (LinkedList<Integer>) o;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return graph;
    }

    public void readGraphFile (String file) throws IOException, ClassNotFoundException {

        if (!this.isEmpty(file)) {

            try {

                LinkedList<Integer> graph_data = this.getGraphData(file);


            } catch (ClassNotFoundException e) {
                System.out.println(e);
            }
        }
    }
}
