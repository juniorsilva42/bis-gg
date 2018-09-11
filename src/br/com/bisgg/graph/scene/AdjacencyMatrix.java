package br.com.bisgg.graph.scene;
import br.com.bisgg.graph.Graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrix implements GraphSceneInterface {

    private int nodes;
    private int[][] matrix;
    private int matrixSize;

    public AdjacencyMatrix(int nodes) {
        this.nodes = nodes;
        this.matrix = new int[nodes][nodes];
        this.matrixSize = this.matrix.length;
    }

    public void setState (int i, int j, int state) {
        this.matrix[i-1][j-1] = state;
    }

    @Override
    public void getLengthNode(int node) {
        int entryPoint = 0, exitPoint = 0;

        for (int i = 0; i < this.matrixSize; i++) {
            if (this.matrix[node - 1][i] == 1)
                exitPoint += 1;
            else if (this.matrix[i][node - 1] == 1)
                entryPoint += 1;
        }

        System.out.println("\nGRAU DO VÉRTICE "+node+":");
        System.out.println("- Grau de entrada: "+entryPoint);
        System.out.println("- Grau de saída: "+exitPoint);
        System.out.println("-----------------------------------");
    }

    @Override
    public boolean isAdjacent(int n1, int n2) {
        if (this.matrix[n1-1][n2-1] == 1)
            return true;

        return false;
    }

    @Override
    public void getNodeAdjacency(int node) {

        ArrayList<Integer> adjacencyNodes = new ArrayList<>();

        for (int i = 0; i < matrixSize; i++) {
            if (this.matrix[node - 1][i] == 1)
                adjacencyNodes.add(i + 1);
        }

        if (adjacencyNodes.size() != 0) {
            System.out.print("\nO conjunto de adjacências de α("+node+") = {");
            for (int j = 0; j < adjacencyNodes.size(); j++) {
                System.out.print(adjacencyNodes.get(j));
                if (!(j == adjacencyNodes.size() - 1)) // Para tirar a vírgula depois do ultimo numero. Estética :)
                    System.out.print(", ");
            }
            System.out.print("}");
            System.out.println("\n-----------------------------------");
        } else {
            System.out.println("\nO conjunto de adjacências de α("+node+") é nulo. {∅}");
            System.out.println("-----------------------------------");
        }

    }

    @Override
    public void getMinorMajorLength() throws IOException, ClassNotFoundException {
        Graph graph = new Graph("graph_data_1");
        List<String> edges = graph.createEdges();

        List<Integer> graus = new ArrayList<>();

        int nodeOrigin = 0;
        int j = 1;

        System.out.println("\n\n");

        int entryPoint = 0, exitPoint = 0;

        for (int i = 1; i < edges.size(); i++) {
            nodeOrigin = Integer.parseInt(edges.get(i).split(" ")[0]);

            if (this.matrix[nodeOrigin - 1][j-1] == 1)
                exitPoint += 1;

            j++;
        }
    }

    public void show () {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++)
                s.append(this.matrix[i][j]).append(" ");
        }
        System.out.println(s.toString());
    }


}
