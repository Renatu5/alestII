import java.util.LinkedList;
import java.util.List;

public class KruskalMST {
    protected static final String NEWLINE = System.getProperty("line.separator");

    private double totalWeight;
    private List<Edge> edges;
    private EdgeWeightedGraph g;

    public KruskalMST(EdgeWeightedGraph g) {

        this.g = g;
        MinPQ<Edge> pq = new MinPQ<Edge>();
        edges = new LinkedList<>();
        UnionFind uf = new UnionFind();
        totalWeight = 0;

        // Cada vértice é um "conjunto" na estrutura union-find
        for (String v : g.getVerts())
            uf.addSet(v);

        // Insere todas as arestas do grafo original na minheap
        for (Edge e : g.getEdges()) {
            pq.put(e);
        }

        while (!pq.isEmpty()) {
            Edge e = pq.delMin();
            // System.out.println(e);
            String v = uf.find(e.getV());
            String w = uf.find(e.getW());
            // Se o conj. de v for diferente do
            // conj. de w, v e w : sem ciclo!
            if (!v.equals(w)) {
                // Neste caso, une os dois conj.
                // E adiciona a aresta à MST
                uf.union(e.getV(), e.getW());
                edges.add(e);
                totalWeight += e.getWeight();
            }
        }
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public String toDot() {
        StringBuilder sb = new StringBuilder();
        sb.append("graph {" + NEWLINE);
        sb.append("rankdir = LR;" + NEWLINE);
        sb.append("node [shape = circle];" + NEWLINE);
        for (Edge e : getEdges())
            sb.append(String.format("%s -- %s [label=\"%.3f\"]", e.getV(), e.getW(), e.getWeight()) + NEWLINE);
        sb.append("}" + NEWLINE);
        return sb.toString();
    }

    public static void main(String[] args) {
      ///  String filename = "tinyEWG.txt";
        EdgeWeightedGraph g = new EdgeWeightedGraph("tinyEWG.txt");
        KruskalMST k = new KruskalMST(g);
        System.out.println(k.toDot());


        System.out.println("Peso total: " + k.getTotalWeight());
        for (Edge e : k.getEdges()) {
            System.out.println(e);
        }

        System.out.println();
    }
}