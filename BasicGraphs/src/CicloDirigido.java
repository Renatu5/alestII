import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CicloDirigido {
    private enum Status {
        WHITE, GRAY, BLACK
    }
    private Status[] marked;
    private boolean hasCycle;

    public CicloDirigido(Digraph g){
        marked = new Status[g.V()]; //inicliaza com white
        for (int v = 0; v<g.V(); v++)
            marked[v] = Status.WHITE;

        hasCycle = false;

        for (int v = 0; v < g.V(); v++){
            if (marked[v] == Status.WHITE){
                System.out.println("Comecando em : " +v);
                if (dfs(g,v)){
                    hasCycle = true;
                    return;
                }
            }
        }
    }
    private boolean dfs (Digraph g, int v){
        System.out.println("Entrei em: " +v);
        marked[v] = Status.GRAY;
        for (int w : g.adj(v)){
            System.out.println("Adjacente em : " +w);
            if (marked[w] == Status.GRAY) {
                return true;
            } else if (marked[w] == Status.WHITE) {
                    if (dfs(g, w)){
                        return true;
                    }
                }
        }
        marked[v] = Status.BLACK;
        System.out.println("Terminei: " + v);
        return false;
    }

    public boolean hasCycle(){
        return hasCycle;
    }

    public static void main (String[] args){
        In in = new In("tinyDG-2.txt");
        Digraph g = new Digraph(in);
        StdOut.println(g);

        CicloDirigido ciclo = new CicloDirigido(g);
        if (ciclo.hasCycle()){
            System.out.println("Tem ciclo");
        } else {
            System.out.println("Não tem ciclo");
        }
    }
}
