import java.util.ArrayList;

public class ordernacaoTopologica {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;
    private Stack<Integer>ordem;

    public ordernacaoTopologica(Digraph g){
         marked = new boolean[g.V()];
         ordem = new Stack<>();

        for(int s = 0; s < g.V(); s++){
            if(!marked[s])
                dfs(g,s);
        }
    }

    private void dfs (Digraph g, int v){
    //    System.out.println("Entrei em: " + v);
        marked[v] = true;
        for (int w : g.adj(v)){
            if (!marked[w]){
                dfs(g,w);
            }
        }
      //  System.out.println("Terminei: " + v);
      ordem.push(v);
    }

    public boolean hasPathTo (int v){
        return marked[v];
    }

    public ArrayList<Integer> pathTo (int v){
        if (!hasPathTo(v)) {
            return null;
        }
        //ja sei que tem caminho, qual é ?
        //lista popula com vertices que compoem o trajeto
        ArrayList<Integer> path = new ArrayList<>();
        //a cada vertice visitado, insere na lista
        while(v != s){ //enquanto nao chega no verticie inicial, monta o caminho
            path.add(0, v);
        }
        path.add(0, s);
        return path;
    }

    public Iterable<Integer> ordemTopologica(){
            return ordem;
        
    }


    public static void main (String[] args){
//        Graph G = new Graph(4);
//        G.addEdge(0, 1);
//        G.addEdge(1, 2);
//        G.addEdge(0, 3);
    //    StdOut.println(G);
        
        In in = new In("tinyDAG.txt");
        Digraph g = new Digraph(in);
        StdOut.println(g);
        // ordernacaoTopologica dfs = new ordernacaoTopologica(g,0);

        System.out.println("Caminhos existentes:");
        System.out.println("0 : Vértice Inicial");
        for (int v = 1; v < g.V(); v++){
            //se tem caminho para v, ele passa por cada um dos caminhos
        
        }
    }
}
