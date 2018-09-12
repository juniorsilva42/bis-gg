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

        for (int i = 0; i < this.getMatrixSize(); i++) {
            if (this.matrix[node - 1][i] == 1)
                exitPoint += 1;

            if (this.matrix[i][node - 1] == 1)
                entryPoint += 1;
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

        ArrayList<Integer> adjacencyNodes = new ArrayList<>();

        for (int i = 0; i < matrixSize; i++) {
            if (this.matrix[node - 1][i] == 1 || this.matrix[i][node-1] == 1)
                adjacencyNodes.add(i + 1);
        }

        if (adjacencyNodes.size() != 0) {
            System.out.print("\nO conjunto de adjacências de αv("+node+") = {");

            for (int j = 0; j < adjacencyNodes.size(); j++) {
                System.out.print(adjacencyNodes.get(j));

                if (!(j == adjacencyNodes.size() - 1)) // Para tirar a vírgula depois do ultimo numero. Estética :)
                    System.out.print(", ");
            }

            System.out.print("}");
            System.out.println("\n-----------------------------------");
        } else {
            System.out.println("\nO conjunto de adjacências de αv("+node+") é nulo. {∅}");
            System.out.println("-----------------------------------");
        }

    }

    public void getNodesAdjacenciesSimultaneously (int node1, int node2) {

        ArrayList<Integer> adjacencyNodes = new ArrayList<>();

        int control_n1 = 0, control_n2 = 0;
        boolean controlError = false;

        for (int i = 0; i < matrixSize; i++) {
            if (this.matrix[node1 - 1][i] == 1 || this.matrix[i][node1-1] == 1) {
                adjacencyNodes.add(i + 1);
                control_n1++; // controla quantas adjacências há no primeiro nó
            }

            if (this.matrix[node2 - 1][i] == 1 || this.matrix[i][node2-1] == 1) {
                adjacencyNodes.add(i + 1);
                control_n2++; // controla quantas adjacências há no segundo nó
            }
        }

        if (adjacencyNodes.size() != 0) {

            if (control_n1 >= 1 && control_n2 >= 1) {
                System.out.print("\nO conjunto de adjacências de αv("+node1+") simultaneamente a αv("+node2+") = {");

                for (int j = 0; j < adjacencyNodes.size(); j++) {
                    System.out.print(adjacencyNodes.get(j));

                    if (!(j == adjacencyNodes.size() - 1)) // Para tirar a vírgula depois do ultimo numero. Estética :)
                        System.out.print(", ");
                }
                System.out.print("}");
                System.out.println("\n-----------------------------------");
            } else controlError = true;
        }

        if (controlError)
            System.out.println("\nO conjunto de adjacências simultâneas de αv("+node1+") e αv("+node2+") é nulo. {∅}");
    }

    public void show () {
        StringBuilder s = new StringBuilder();
        System.out.print("\n[ ");
        for (int i = 0; i < this.getMatrixSize(); i++) {
            for (int j = 0; j < this.getMatrixSize(); j++)
                s.append(this.matrix[i][j]).append(" ");
        }
        System.out.println(s.toString()+"]");
    }

    public int getMatrixSize () {
        return this.matrixSize;
    }
}
