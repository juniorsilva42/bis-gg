package br.com.bisgg.tests;

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

            incidenceMatrix.set(a, b, 1);

            if (incidenceMatrix.isAdjacent(a, b) && incidenceMatrix.isAdjacent(b, a))
                incidenceMatrix.set(b, a, -1);
        }

        incidenceMatrix.getNodeAdjacency(4);
    }
}