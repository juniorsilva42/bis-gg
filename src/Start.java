import br.com.bisgg.graph.Graph;
import br.com.bisgg.graph.scene.AdjacencyMatrix;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Start {

    public static void main (String... args) throws ClassNotFoundException, IOException {

        Graph graph = new Graph("graph_data_1");
        List<String> rowsInEdges = graph.createEdges();

        int nodes = graph.getNodes();
        int edges = graph.getEdges();

        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(nodes);

        for (int i = 0; i < edges; i++) {
            int a = Integer.parseInt(rowsInEdges.get(i).split(" ")[0]);
            int b = Integer.parseInt(rowsInEdges.get(i).split(" ")[1]);
            adjacencyMatrix.setState(a, b, 1);
        }

        // Verificando se os vértices 2 e 8 são adjacentes
        System.out.println(adjacencyMatrix.isAdjacent(1, 4));

        adjacencyMatrix.getNodeAdjacency(2);

        // adjacencyList.getLengthNode(n1);
        // adjacencyList.getMinorMajorLength();
    }

    public Start() throws ClassNotFoundException {

        int opcao;
        Scanner in = new Scanner(System.in);

        while (true) {

            System.out.println("\nDigite uma opção correspondente de menu acima: ");
            opcao = in.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\nCaso 1");
                    break;

                case 2:
                    System.out.println("\nCaso 2");
                    break;

                case 3:
                    System.out.println("\nCaso 3");
                    break;

                case 4:
                    System.out.println("\nFinalizando...");
                    System.out.println("Programado finalizado. Bye! Bye!\n");
                    return;

                default:
                    System.out.println("\nOpção inválida!");
            }

        }
    }
}
