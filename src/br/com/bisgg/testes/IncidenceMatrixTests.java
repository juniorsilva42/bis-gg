package br.com.bisgg.testes;

import br.com.bisgg.graph.Graph;
import br.com.bisgg.graph.scene.IncidenceMatrix;

import java.io.IOException;
import java.util.List;

public class IncidenceMatrixTests {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Graph graph = new Graph("graph_data_1");
        List<String> rowsInEdges = graph.createEdges();

        IncidenceMatrix incidenceMatrix = new IncidenceMatrix(graph.getNodes(), graph.getEdges());

        // Fomentando a matriz com os dados do arquivo vindo da super classe Grafo
        for (int i = 0; i < rowsInEdges.size(); i++) {
            int a = Integer.parseInt(rowsInEdges.get(i).split(" ")[0]);
            int b = Integer.parseInt(rowsInEdges.get(i).split(" ")[1]);

            incidenceMatrix.setState(a, b, 1);

            if (incidenceMatrix.isAdjacent(b, a))
                incidenceMatrix.setState(a, b, -1); // seta o estado de cada aresta conexa do grafo para 1. Padrão de volta -1
        }

        incidenceMatrix.show();

    }
}