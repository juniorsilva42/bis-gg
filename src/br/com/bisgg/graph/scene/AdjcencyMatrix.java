package br.com.bisgg.graph.scene;

import br.com.bisgg.graph.Edges;
import br.com.bisgg.graph.Graph;

import java.util.List;

public class AdjcencyMatrix extends Graph implements GraphSceneInterface {

    private int[][] matrix;

    public AdjcencyMatrix (int node, List<Edges> edgesOrigin, List<Edges> edgesDestination) {
        super(node, edgesOrigin);
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public void setValue (int i, int j, int value) {
        this.matrix[i][j] = value;
    }


    @Override
    public void getLengthNode(int node) {

    }

    @Override
    public boolean isAdjacent(int node1, int node2) {
        return false;
    }

    @Override
    public void getNodeAdjacency(int node) {

    }

    @Override
    public void getMinorMajorLength() {

    }

    public void show () {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < this.getNode(); i++) {
            for (int j = 0; j < this.getNode(); j++) {
                s.append(this.matrix[i][j]).append(" ");
            }
        }

        System.out.println(s.toString());
    }
}
