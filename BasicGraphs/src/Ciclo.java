import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Ciclo {
    private boolean[] marked;
    private boolean hasCycle;
    private Set<String> edgeSet;

    public Ciclo(Graph g){
        marked = new boolean[g.V()];
        edgeSet = new HashSet<>();
        hasCycle = false;
        //passa por todos os vertices
        // para garantir que vai encontrar um ciclo em qualquer local
        for (int v = 0; v < g.V(); v++){
            //so chama para vertices ainda nao visitados
            if (!marked[v]){
                System.out.println("Comecando em : " +v);
                dfs(g,v);
            }
            //se achar um ciclo interrompe processo
            if (hasCycle)
                break;
        }
    }

    private void dfs (Graph g, int v){
        if (hasCycle)
            return;
        marked[v] = true;
        for (int w : g.adj(v)){
            //----
            String aux = "";
            if (v > w)
                aux = w + " - " + v;
            else
                aux = v + " - " + w;
            //-----
            if (!marked[w]){
                edgeSet.add(aux);
                dfs(g,w);
            } else{
                if (!edgeSet.contains(aux)){
                    System.out.println("Ciclo em "+ aux);
                    hasCycle = true;
                    return ;
                }
            }
        }
    }

    public boolean hasCycle(){
        return hasCycle;
    }

    public static void main (String[] args){
        In in = new In("tinyG-2.txt");
        //In in = new In("tinyG-semciclo.txt");

        Graph g = new Graph(in);

        Ciclo ciclo = new Ciclo(g);
        if (ciclo.hasCycle()){
            System.out.println("Tem ciclo");
        } else {
            System.out.println("Não tem ciclo");
        }
    }
}
