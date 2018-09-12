package br.com.bisgg.tests;

import br.com.bisgg.graph.Graph;
import br.com.bisgg.graph.scene.AdjacencyMatrix;

import java.io.IOException;
import java.util.List;

public class AdjacencyMatrixTests {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Graph graph = new Graph("graph_data_3");
        List<String> rowsInEdges = graph.createEdges();

        // Instanciando o teste da Matriz de Adjacência
        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(graph.getNodes());

        // Fomentando a matriz com os dados do arquivo vindo da super classe Grafo
        for (int i = 0; i < rowsInEdges.size(); i++) {
            int a = Integer.parseInt(rowsInEdges.get(i).split(" ")[0]);
            int b = Integer.parseInt(rowsInEdges.get(i).split(" ")[1]);

            adjacencyMatrix.setState(a, b, 1); // seta o estado de cada aresta conexa do grafo para 1. Padrão desconexo 0
        }

        System.out.println("\nGrafo 2 - Entrada 2:");
        System.out.println("- N° de vértices: "+graph.getNodes());
        System.out.println("- N° de arestas: "+graph.getEdges());
        System.out.println("===================================");

        // Obtem os vértices incidentes sobre o nó 2
        adjacencyMatrix.getLengthNode(7);

        // Verificando se os vértices 2 e 8 são adjacentes
        if (adjacencyMatrix.isAdjacent(2, 4)) {
            System.out.println("\nOs vértices 2 e 4 são adjacentes.");
            System.out.println("-----------------------------------");
        } else {
            System.out.println("\nOs vértices 2 e 4 não são adjacentes.");
            System.out.println("-----------------------------------");
        }

        // Verificando se os vértices 2 e 8 são adjacentes
        if (adjacencyMatrix.isAdjacent(2, 3)) {
            System.out.println("\nOs vértices 2 e 3 são adjacentes.");
            System.out.println("-----------------------------------");
        } else {
            System.out.println("\nOs vértices 2 e 3 não são adjacentes.");
            System.out.println("-----------------------------------");
        }

        // Listar os vértices adjacentes a um dado nó
        //adjacencyMatrix.getNodeAdjacency(39);

        adjacencyMatrix.getNodesAdjacenciesSimultaneously(35, 40);


        // Lista a matriz de adjacência
        // adjacencyMatrix.show();
    }
}
