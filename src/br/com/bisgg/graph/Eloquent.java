package br.com.bisgg.graph;

import br.com.bisgg.persistencia.Persistencia;

import java.io.IOException;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Eloquent extends Persistencia {

    private String graph_file;

    public Eloquent (String graphFile) {
        this.graph_file = graphFile;
    }

    private LinkedList<String> readGraphFile () throws IOException, ClassNotFoundException {

        LinkedList<String> objects = new LinkedList<>();

        try {
            // Se o arquivo de dados do grafo não é vazio, ele obtem os objetos, caso inverso, retorna o valor padrão nulo
            if (!this.isEmpty(this.graph_file))
                objects = this.get(this.graph_file);

        } catch (IOException e) {
            e.printStackTrace();
        }

       return objects;
    }

    public void getGraphData () throws IOException, ClassNotFoundException {
        try {

            LinkedList<String> graph_data = this.readGraphFile();
            List<String> rows = graph_data.stream().filter(line -> line.split("\\s+").length == 2).collect(Collectors.toList());
            int graphSize = rows.size();

            int nodes = 0, edges = 0;
            int currentLine = 0;

            // System.out.println(rows.get(0).split(" ")[1]);

            for (int i = 0; i < graphSize; i++) {
                currentLine++;

                /*
                *
                * Verifica se o grafo contém o número de nós e arestas, respectivamente, na primeira e segunda linha do arquivo.
                *
                * Primeiro fragmento: verifica se a posição que é pra está o nó/aresta está vazia;
                * Segundo fragmento: verifica a quantidade de caracteres (retirando o espaço) que existe na linha, se for maior
                  igual a 2 significa que aquela informação tende a ser de uma adjacência (V, A) origem/destino;
                *
                *
                * */
                if (graph_data.get(0).isEmpty() || graph_data.get(0).split(" ").length >= 2) {
                    System.out.println("\bImpossível gerar o grafo.\nHá um erro nas especificações básicas de (V, A) nas duas primeiras linhas do arquivo.");
                    break;
                } else {
                    // Obtém a quantidade de nós e arestas do grafo
                    nodes = Integer.parseInt(graph_data.get(0));
                    edges = graph_data.size() - 2;
                }

                /*
                *
                * Verifica se a linha atual é uma linha que contém informações sobre adjacência do tipo 1 2;
                * A especificação mínima é estar, pelo menos, na segunda linha e ela ser diferente de -1 -1, onde identifica ser o fim do arquivo
                * */
                if (currentLine >= 2 && !(rows.get(i).equals("-1 -1"))) {

                    boolean error = false;
                    int indexOfError = 0;
                    int lineOfError = 0;


                    if (rows.get(i).split(" ").length <= 1) {
                        indexOfError = i - 1;
                        lineOfError = i;
                        error = true;
                    } else {

                        /*
                        *
                        * todo:
                        *   - Adicionar cada linha de cada vértice de origem/destino em uma fila;
                        *   - Desinfileirar cada elemento da fila paralelamente e passar pro objeto de nós;
                        * */
                    }

                   if (error) System.out.println("\bImpossível gerar o grafo.\nHá um erro na adjacência da posição " + indexOfError + " do arquivo.\n=> G(" + graph_data.get(lineOfError) + ", ?)");
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
