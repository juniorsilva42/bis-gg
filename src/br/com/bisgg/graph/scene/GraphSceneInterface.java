package br.com.bisgg.graph.scene;

import java.io.IOException;

public interface GraphSceneInterface {

    /**
     *
     * Procedimento para obter os graus de saída e entrada de um vértice
     * @author Ivanicio Jr
     * @param node, referente a o nó do vértice
     * @return void
     *
     */
    void getLengthNode(int node);

    /**
     *
     * Método para verificar se um n1 é adjcente a um n2
     * @author Ivanicio Jr
     * @param node1, node2
     * @return boolean
     *
     */
    boolean isAdjacent(int node1, int node2);

    /**
     *
     * Procedimento para obter o nós adjacentes a um dado nó
     * @author Ivanicio Jr
     * @param node
     * @return void
     *
     */
    void getNodeAdjacency(int node) throws IOException, ClassNotFoundException;

    /**
     *
     * Procedimento para obter, respectivamente, os vértices de maior e menor grau
     * @author Ivanicio Jr
     * @return void
     *
     */
    void getMinorMajorLength();
}
