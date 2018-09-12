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

    public void set (int i, int j, int state) { this.matrix[i-1][j-1] = state; }

    @Override
    public void getLengthNode(int node) {

        int entryPoint = 0, exitPoint = 0;

        for (int i = 0; i < this.getMatrixSize(); i++) {
            if (this.matrix[node - 1][i] == 1)
                exitPoint++;

            if (this.matrix[i][node - 1] == -1 || this.matrix[i][node-1] == 1)
                entryPoint++;
        }

        System.out.println("\nGRAU DO VÉRTICE "+node+":");
        System.out.println("- Grau de entrada: "+entryPoint);
        System.out.println("- Grau de saída: "+exitPoint);
        System.out.println("-----------------------------------");
    }

    @Override
    public boolean isAdjacent(int n1, int n2) {
        return this.matrix[n1-1][n2-1] == 1;
    }

    @Override
    public void getNodeAdjacency(int node) {

    }

    @Override
    public void getMinorMajorLength() {

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
}
