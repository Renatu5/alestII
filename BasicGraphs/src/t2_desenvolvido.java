import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class t2_desenvolvido {
    public static void main(String[] args) {
        File file = new File("./casos2/c2a.txt");
        // try {
        // Scanner sc = new Scanner(file);
        // String[] lista = new String[(int) file.length()];
        // int linhas = 0;
        // int colunas = 0;
        // int count = 0;
        // while (sc.hasNextLine()) {
        // String line = sc.nextLine();
        // if (count == 1) {
        // linhas = Integer.parseInt(line.split(" ")[0]);
        // colunas = Integer.parseInt(line.split(" ")[1]);
        // count++;
        // } else{

        // }
        // }
        // System.out.println(linhas);
        // System.out.println(colunas);
        // CaminhamentoLargura teste = new CaminhamentoLargura(null, 0);

        // sc.close();
        // } catch (FileNotFoundException err) {

        // }
        try (FileReader leitor = new FileReader(file)) {
            int caractere;
            Scanner sc = new Scanner(file);
            int linhas = sc.nextInt();
            int colunas = sc.nextInt();
            Graph testGraph = new Graph((linhas * colunas) /2);
            leitor.skip(5);
            while ((caractere = leitor.read()) != -1) {
                if (caractere == 10)
                    caractere = leitor.read();
                int v1 = caractere;
                int v2 = (caractere = leitor.read());
                if (v1 == -1 || v2 == -1)
                    break;
                System.out.println("valor de v1: " + v1);
                // System.out.println("valor de v2: " + v2);
                if( v1 != v2){
                    // v1 = v1 == 83 ? 97 : v1;
                    if(v2 - v1 <= 0 || v2 - v1 == 1 || v1 == 83)
                    testGraph.addEdge(v1, v2);
                }
                // AQUI PRINTA OS CARACTERES, CONVERTENDO DE ASCII PARA CHAR

                    // System.out.print((char) caractere);

                // COMPARAVA OS CARACTERES QUE ERAM INT, COM SEUS RESPECTIVOS VALORES EM CHAR
                
                    // System.out.println((char) caractere + " " + (char) str1);
                    // System.out.println(caractere + " "/* + str1*/);
            }
            // CRIA UM BFS COM O GRAFO GERADO, COMEÇANDO NO CHAR 83(S)
                CaminhamentoLargura caminhamento = new CaminhamentoLargura(testGraph, 83);
            //fala a distancia(distTO) para a letra 122(z)
                System.out.println(caminhamento.distTo(122));
            //devolve o grafo formatado para o site de visualizar grafos
             // https://dreampuf.github.io/GraphvizOnline/
                System.out.println(testGraph.toDot());
                System.out.println(testGraph.E());
                System.out.println(testGraph.V());
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
