package ed2016r;

import ArrayList.ArrayList;
import ArrayList.ArrayUnorderedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class allpaths {
  
static int dim = 9, size = 0; // dim is number of nodes in graph
 // size had been used to keep record of index to remove node from Arraylist
    static boolean[] color = new boolean[dim + 1];      // to remember visit
    static boolean[][] graph;
    static ArrayUnorderedList<Integer> al = new ArrayUnorderedList<Integer>();
 
    public static void main(String[] S) throws IOException {
        

        //Instanciar o Mapa/Jogo
        Map mapa = new Map();
        
        //Instanciar as Cidades
        Cidade vaesDothrak = new Cidade("Vaes Dothrak", 73);//0
        Cidade lhazareen = new Cidade("Lhazareen Village", 64);//1
        Cidade qohor = new Cidade("Qohor", 19);//2
        Cidade pentos = new Cidade("Pentos", 84);//3
        Cidade kingsLanding = new Cidade("King's Landing", 60);//4
        Cidade crossroads = new Cidade("Crossroads Inn", 0);//5
        Cidade theEyrie = new Cidade("The eyrie", 54);//6
        Cidade winterfell = new Cidade("Winterfell", 64);//7
        Cidade castleBlack = new Cidade("Castle Black", 0);//8
        
        //Instanciar os Caminhos / Edges / Alternativas
        Alternativa vaesCastle = new Alternativa(800, 10, 2.2);
        Alternativa vaesCastle2 = new Alternativa(1040, 13, 1.5);
        Alternativa vaesLhaza = new Alternativa(180, 2.3, 1.7);
        Alternativa vaesLhaza2 = new Alternativa(198, 3.0, 0.3);
        Alternativa vaesQohor = new Alternativa(400, 4.5, 0.2);
        Alternativa vaesQohor2 = new Alternativa(520, 5.9, 1.2);
        Alternativa lhazaQohor = new Alternativa(300, 2.5, 0.4);
        Alternativa lhazaQohor2 = new Alternativa(390, 3.3, 2.7);
        Alternativa lhazaPentos = new Alternativa(500, 6.3, 0.3);
        Alternativa lhazaPentos2 = new Alternativa(650, 8.2, 2.8);
        Alternativa qohorPentos = new Alternativa(180, 3.7, 1.7);
        Alternativa qohorPentos2 = new Alternativa(126, 4.8, 0.6);
        Alternativa pentosKings = new Alternativa(160, 3.5, 2.4);
        Alternativa pentosKings2 = new Alternativa(208, 4.6, 0.2);
        Alternativa pentosCrossroads = new Alternativa(200, 3.5, 1.2);
        Alternativa pentosCrossroads2 = new Alternativa(140, 4.6, 2.5);
        Alternativa pentosEyrie = new Alternativa(180, 4.9, 2.5);
        Alternativa pentosEyrie2 = new Alternativa(234, 6.4, 3);
        Alternativa kingsCrossroads = new Alternativa(100, 1.2, 2);
        Alternativa kingsCrossroads2 = new Alternativa(110, 1.6, 1.4);
        Alternativa crossroadsEyrie = new Alternativa(50, 1.1, 0.7);
        Alternativa crossroadsEyrie2 = new Alternativa(65, 1.4, 2.2);
        Alternativa crossroadsWinterfell = new Alternativa(250, 5.5, 1.2);
        Alternativa crossroadsWinterfell2 = new Alternativa(275, 7.2, 0.4);
        Alternativa eyrieWinterfell = new Alternativa(210, 2.8, 2.6);
        Alternativa eyrieWinterfell2 = new Alternativa(231, 3.6, 2.1);
        Alternativa winterfellCastle = new Alternativa(120, 1.9, 0.9);
        Alternativa winterfellCastle2 = new Alternativa(108, 2.5, 3);
        
        //Adicionar as Cidades
        mapa.addVertex(vaesDothrak);//0
        mapa.addVertex(lhazareen);//1
        mapa.addVertex(qohor);//2
        mapa.addVertex(pentos);//3
        mapa.addVertex(kingsLanding);//4
        mapa.addVertex(crossroads);//5
        mapa.addVertex(theEyrie);//6
        mapa.addVertex(winterfell);//7
        mapa.addVertex(castleBlack);//8
        
        //Adicionar os Caminhos / Edges / Alternativas
        mapa.addEdge(vaesDothrak, castleBlack, vaesCastle);
        mapa.addEdge(vaesDothrak, castleBlack, vaesCastle2);
        mapa.addEdge(vaesDothrak, lhazareen, vaesLhaza);
        mapa.addEdge(vaesDothrak, lhazareen, vaesLhaza2);
        mapa.addEdge(vaesDothrak, qohor, vaesQohor);
        mapa.addEdge(vaesDothrak, qohor, vaesQohor2);
        mapa.addEdge(lhazareen, qohor, lhazaQohor);
        mapa.addEdge(lhazareen, qohor, lhazaQohor2);
        mapa.addEdge(lhazareen, pentos, lhazaPentos);
        mapa.addEdge(lhazareen, pentos, lhazaPentos2);
        mapa.addEdge(qohor, pentos, qohorPentos);
        mapa.addEdge(qohor, pentos, qohorPentos2);
        mapa.addEdge(pentos, kingsLanding, pentosKings);
        mapa.addEdge(pentos, kingsLanding, pentosKings2);
        mapa.addEdge(pentos, crossroads, pentosCrossroads);
        mapa.addEdge(pentos, crossroads, pentosCrossroads2);
        mapa.addEdge(pentos, theEyrie, pentosEyrie);
        mapa.addEdge(pentos, theEyrie, pentosEyrie2);
        mapa.addEdge(kingsLanding, crossroads, kingsCrossroads);
        mapa.addEdge(kingsLanding, crossroads, kingsCrossroads2);
        mapa.addEdge(crossroads, theEyrie, crossroadsEyrie);
        mapa.addEdge(crossroads, theEyrie, crossroadsEyrie2);
        mapa.addEdge(crossroads, winterfell, crossroadsWinterfell);
        mapa.addEdge(crossroads, winterfell, crossroadsWinterfell2);
        mapa.addEdge(theEyrie, winterfell, eyrieWinterfell);
        mapa.addEdge(theEyrie, winterfell, eyrieWinterfell2);
        mapa.addEdge(winterfell, castleBlack, winterfellCastle);
        mapa.addEdge(winterfell, castleBlack, winterfellCastle2);   
        
//        graph[0][0]=1;
//        graph[0][1]=1;
//        graph[0][2]=1;
//        graph[0][3]=1;
//        graph[1][0]=1;
//        graph[1][1]=-1;
//        graph[1][2]=-1;
//        graph[1][3]=1;
//        graph[2][0]=1;
//        graph[2][1]=-1;
//        graph[2][2]=1;
//        graph[2][3]=-1;
//        graph[3][0]=1;
//        graph[3][1]=1;
//        graph[3][2]=1;
//        graph[3][3]=1;
//        
        
        graph=mapa.getadj();
        
        
        
        
//         BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
//        for (int I = 1; I <= dim; I++) {
//            String[] s = br.readLine().split(" ");
//            int len = s.length;
//            for (int J = 1; J <= len; J++) {
//                graph[I][J] = Integer.parseInt(s[J - 1]);
//            }
//        }
        Arrays.fill(color, false);      // initially all are unvisited
// 
//        int src = Integer.parseInt(br.readLine());      //Source node
//        int dst = Integer.parseInt(br.readLine());      //Destination node
 
        dfs(2, 3, mapa);  // backtracking
        
    }
 
    static void dfs(int src, int dst, Map mapa) {
        al.addRear(src);
        size++;
        color[src] = true;
        if (src == dst) {       // tests for base condition to stop
            System.out.println("Find destination");
            for (Integer i : al) {
                //     Prints the path
                System.out.print(mapa.getVertices()[i] + "  ");
            }
            System.out.println();
            return;
        }
        for (int I = 0; I < dim; I++) {
            if (graph[src][I] == true) {
                if (color[I] == false) {
                    dfs(I, dst, mapa);        // These lines do
                    color[I] = false;   // main job of backtracking
                    size--;
                    al.removeIndex(size);
                }
            }
        }
    }
}