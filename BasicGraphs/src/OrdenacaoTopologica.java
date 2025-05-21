import java.util.ArrayList;

public class OrdenacaoTopologica {
    // vetor auxiliar: markedTo
    private boolean[] marked;

    //pilha para ordem
    private Stack<Integer> ordem;

    //metodos
        //construtor
        //dfs

    OrdenacaoTopologica(Digraph g){
        marked = new boolean[g.V()];

        //inicializa pilha
        ordem = new Stack<>();

        // como chamar dfs ? deve passar por todos
        for (int s = 0; s <g.V(); s++){
            //se ainda nao foi visitado, visita
            if (!marked[s])
                dfs(g, s);
        }
    }
    public void dfs(Digraph g, int v){
        //entrou:
        System.out.println("Entrei em: " + v);
         //marcou
        marked[v] = true;
        for (int w : g.adj(v)){
            //System.out.println("Adjacentes: " + w);
            if (!marked[w]){
               dfs(g,w);
            }
        }
        System.out.println("Terminei: " + v);
        ordem.push(v);
    }

    public Iterable<Integer> ordemTopo() {
        return ordem;
    }

    public static void main (String[] args) {

        String fileName = "tinyDAG.txt";
        In in = new In(fileName);
        Digraph g = new Digraph(in);
        StdOut.println(g);
        StdOut.println(g.toDot());
        OrdenacaoTopologica ot = new OrdenacaoTopologica(g);
        System.out.println("Ordem Topológica");
        for (int v : ot.ordemTopo()){
            System.out.println(v);
        }
    }
}
