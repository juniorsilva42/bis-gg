import br.com.bisgg.graph.Graph;
import br.com.bisgg.graph.scene.AdjacencyMatrix;
import br.com.bisgg.graph.scene.IncidenceMatrix;
import br.com.bisgg.util.Helpers;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Start {


    public static void main (String... args) throws ClassNotFoundException, IOException {

        // Instancia a classe mãe do sistema passando como parâmetro o arquivo que é pra ser gerado o grafo
        new Start("graph_data_1");
    }

    public Start(String graphFileName) throws ClassNotFoundException, IOException {

        // Instancia a super classe Graph passando como parâmetro o arquivo que é pra ser gerado o grafo
        Graph graph = new Graph(graphFileName);
        List<String> edgesInRows = graph.createEdges(); // obtem a lista de arestas do grafo

        int opcao;
        Scanner in = new Scanner(System.in);

        // Exibição do menu principal
        Helpers.screenHomeStart();

        while (true) {

            System.out.println("\nDigite uma opção correspondente de menu acima: ");
            opcao = in.nextInt();

            switch (opcao) {
                case 1:

                    // Instanciando o teste da Matriz de Adjacência
                    // Como parâmetro principal sendo o número de nós do arquivo corrente do grafo, advindo da classe Graph
                    AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(graph.getNodes());

                    // Percorre todas as arestas e fomenta a matriz com os dados, vindo da super classe Graph
                    for (int i = 0; i < edgesInRows.size(); i++) {
                        int origin = Integer.parseInt(edgesInRows.get(i).split(" ")[0]);
                        int destination = Integer.parseInt(edgesInRows.get(i).split(" ")[1]);

                        // seta o estado de cada aresta conexa do grafo para 1. Padrão desconexo 0
                        adjacencyMatrix.setState(origin, destination, 1);
                    }

                    System.out.println("\nGrafo gerado com sucesso!\n");

                    System.out.println("Informações básicas:");
                    System.out.println("- N° de vértices: "+graph.getNodes());
                    System.out.println("- N° de arestas: "+graph.getEdges());
                    System.out.println("===================================");

                    // Obtem os vértices incidentes sobre o nó 3
                    adjacencyMatrix.getLengthNode(3);

                    // Verificando se os vértices 2 e 4 são adjacentes
                    adjacencyMatrix.isAdjacentWithFullReturn(2, 4);

                    // Verificando se os vértices 2 e 3 são adjacentes
                    adjacencyMatrix.isAdjacentWithFullReturn(2, 3);

                    // Obtém o conjunto de adjacências do vértice 5
                    adjacencyMatrix.getNodeAdjacency(5);

                    break;

                case 2:

                    // Instanciando o teste da Matriz de Incidência
                    // Como parâmetro principal sendo o número de nós do arquivo corrente e n° de arestas
                    IncidenceMatrix incidenceMatrix = new IncidenceMatrix(graph.getNodes(), graph.getEdges());

                    // Percorre todas as arestas e fomenta a matriz com os dados, vindo da super classe Graph
                    for (int i = 0; i < edgesInRows.size(); i++) {
                        int origin = Integer.parseInt(edgesInRows.get(i).split(" ")[0]);
                        int destination = Integer.parseInt(edgesInRows.get(i).split(" ")[1]);

                        incidenceMatrix.set(origin, destination, 1);

                        /*
                         * Se existe uma adjacência entre a aresta de origem e destino, ao mesmo tempo que existe entre a aresta de destino e origem, isso
                           significa que na aresta corrente tanto existe um ida como uma volta, onde a ida é setada com o valor 1 e a volta com o valor
                           -1
                         *
                        */
                        if (incidenceMatrix.isAdjacent(origin, destination) && incidenceMatrix.isAdjacent(destination, origin))
                            incidenceMatrix.set(destination, origin, -1);
                    }

                    // Obtem os vértices incidentes sobre o nó 3
                    incidenceMatrix.getLengthNode(3);

                    // Verificando se os vértices 2 e 8 são adjacentes
                    incidenceMatrix.isAdjacentWithFullReturn(2, 4);

                    // Verificando se os vértices 2 e 3 são adjacentes
                    incidenceMatrix.isAdjacentWithFullReturn(2, 3);

                    // Obtém o conjunto de adjacências do vértice 5
                    incidenceMatrix.getNodeAdjacency(5);

                    break;

                case 3:
                    System.out.println("\nFinalizando...");
                    System.out.println("Programado finalizado. Bye! Bye!\n");
                    return;

                default:
                    System.out.println("\nOpção inválida!");
            }

        }
    }
}
