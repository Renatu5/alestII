## BRANCO 
 - todos os vértices NÃO VISITADOS(no começo, todos estarão em branco)
 ---

## CINZA
 - Vértice em processamento
---
## PRETO 
 - Vertices Finalizados
----

Para cada Vertice em V, marca eles de BRANCO;

Para cada vertice em V, se ele for branco, visita ele
 - marca o visitado como CINZA;
 - para cada vertice, adjacentes a V, faça
  - se for CINZA, retorne TRUE
  - se for BRANCO, volta para a recursão(inicio desta função/método)
  - se não houver adjacentes, marque-o como PRETO, e retorna FALSE;