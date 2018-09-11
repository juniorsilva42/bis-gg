package br.com.bisgg.graph;

import java.util.List;

public class Edges  {

    private List<String> e1;
    private List<String> e2;
    //private int weigth;

    protected List<String> getE1() {
        return e1;
    }

    protected void setE1(List<String> e1) {
        this.e1 = e1;
    }

    protected List<String> getE2() {
        return e2;
    }

    protected void setE2(List<String> e2) {
        this.e2 = e2;
    }
}
