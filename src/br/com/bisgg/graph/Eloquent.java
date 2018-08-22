package br.com.bisgg.graph;

import br.com.bisgg.persistencia.Persistencia;

import java.io.IOException;
import java.util.LinkedList;

public class Eloquent extends Persistencia {

    private String graph_file;

    public Eloquent (String graphFile) {
        this.graph_file = graphFile;
    }

    private LinkedList<Object> readGraphFile () throws IOException, ClassNotFoundException {

        LinkedList<Object> objects = new LinkedList<>();

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

            LinkedList<Object> graph_data = this.readGraphFile();

            for (int i = 0; i < graph_data.size(); i++)
                System.out.println(graph_data.get(i));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
