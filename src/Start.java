import br.com.bisgg.graph.Eloquent;
import br.com.bisgg.graph.Node;
import br.com.bisgg.persistencia.Persistencia;

import java.io.IOException;
import java.util.Scanner;

public class Start {

    public static void main (String[] args) throws ClassNotFoundException, IOException {

        //new Start();

        Node n1 = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");
        Node n5 = new Node("5");
        Node n6 = new Node("6");
        Node n7 = new Node("7");
        Node n8 = new Node("8");
        Node n9 = new Node("9");
        Node n10 = new Node("10");



        Eloquent eloquent = new Eloquent("graph_data_test");
        eloquent.getGraphData();
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
