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

        for (int i = 0; i < this.matrixSize; i++) {
            if (this.matrix[node - 1][i] == 1)
                adjacencyNodes.add(i + 1);
        }

        System.out.print("{");

        for (int j = 0; j < adjacencyNodes.size(); j++) {
            System.out.print(adjacencyNodes.get(j));
            if (!(j == adjacencyNodes.size() - 1)) // Para tirar a vírgula depois do ultimo numero. Estética :)
                System.out.print(", ");
        }

        System.out.print("}");
    }

    @Override
    public void getMinorMajorLength() {

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
