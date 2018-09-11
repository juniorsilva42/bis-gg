package br.com.bisgg.graph.scene;

public class IncidenceMatrix implements GraphSceneInterface {

    private int nodes;
    private int edges;
    private int[][] matrix;
    private int matrixSize;

    public IncidenceMatrix (int nodes, int edges) {
        this.nodes = nodes;
        this.edges = edges;
        this.matrix = new int[nodes][edges];
        this.matrixSize = this.matrix.length;
    }

    public void setState (int i, int j, int state) {
        this.matrix[i-1][j-1] = state;
    }

    public int getMatrixSize () {
        return this.matrixSize;
    }

    public void show () {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < this.getMatrixSize(); i++) {
            for (int j = 0; j < this.getMatrixSize(); j++)
                s.append(this.matrix[i][j]).append(" ");
        }
        System.out.println(s.toString());
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

    }

    @Override
    public void getMinorMajorLength() {

    }
}
