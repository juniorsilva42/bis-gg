import br.com.bisgg.graph.Eloquent;
import br.com.bisgg.graph.Graph;

import java.io.IOException;
import java.util.Scanner;

public class Start {

    public static void main (String[] args) throws ClassNotFoundException, IOException {

        Eloquent eloquent = new Eloquent("graph_data_test");
        eloquent.getGraphData();

        System.out.println(Graph.getEdges());
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
