package br.com.bisgg.graph.scene;

public class AdjacencyMatrix implements GraphSceneInterface {

    private int nodes;
    private int[][] matrix;

    public AdjacencyMatrix(int nodes) {
        this.nodes = nodes;
        this.matrix = new int[nodes][nodes];
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
        System.out.print("\n");
        System.out.println(s.toString());
    }


}
