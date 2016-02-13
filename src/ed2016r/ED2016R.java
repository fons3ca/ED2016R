/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed2016r;

import java.io.IOException;


/**
 *
 * @author n_fon
 */
public class ED2016R {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

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
        
        castleBlack.setConquistada(true);

        //Instanciar os Caminhos / Edges / Alternativas
        Alternativa vaesCastle = new Alternativa("Alternativa 1", 800, 10, 2.2);
        Alternativa vaesCastle2 = new Alternativa("Alternativa 2", 1040, 13, 1.5);
        Alternativa vaesLhaza = new Alternativa("Alternativa 1", 180, 2.3, 1.7);
        Alternativa vaesLhaza2 = new Alternativa("Alternativa 2", 198, 3.0, 0.3);
        Alternativa vaesQohor = new Alternativa("Alternativa 1", 400, 4.5, 0.2);
        Alternativa vaesQohor2 = new Alternativa("Alternativa 2", 520, 5.9, 1.2);
        Alternativa lhazaQohor = new Alternativa("Alternativa 1", 300, 2.5, 0.4);
        Alternativa lhazaQohor2 = new Alternativa("Alternativa 2", 390, 3.3, 2.7);
        Alternativa lhazaPentos = new Alternativa("Alternativa 1", 500, 6.3, 0.3);
        Alternativa lhazaPentos2 = new Alternativa("Alternativa 2", 650, 8.2, 2.8);
        Alternativa qohorPentos = new Alternativa("Alternativa 1", 180, 3.7, 1.7);
        Alternativa qohorPentos2 = new Alternativa("Alternativa 2", 126, 4.8, 0.6);
        Alternativa pentosKings = new Alternativa("Alternativa 1", 160, 3.5, 2.4);
        Alternativa pentosKings2 = new Alternativa("Alternativa 2", 208, 4.6, 0.2);
        Alternativa pentosCrossroads = new Alternativa("Alternativa 1", 200, 3.5, 1.2);
        Alternativa pentosCrossroads2 = new Alternativa("Alternativa 2", 140, 4.6, 2.5);
        Alternativa pentosEyrie = new Alternativa("Alternativa 1", 180, 4.9, 2.5);
        Alternativa pentosEyrie2 = new Alternativa("Alternativa 2", 234, 6.4, 3);
        Alternativa kingsCrossroads = new Alternativa("Alternativa 1", 100, 1.2, 2);
        Alternativa kingsCrossroads2 = new Alternativa("Alternativa 2", 110, 1.6, 1.4);
        Alternativa crossroadsEyrie = new Alternativa("Alternativa 1", 50, 1.1, 0.7);
        Alternativa crossroadsEyrie2 = new Alternativa("Alternativa 2", 65, 1.4, 2.2);
        Alternativa crossroadsWinterfell = new Alternativa("Alternativa 1", 250, 5.5, 1.2);
        Alternativa crossroadsWinterfell2 = new Alternativa("Alternativa 2", 275, 7.2, 0.4);
        Alternativa eyrieWinterfell = new Alternativa("Alternativa 1", 210, 2.8, 2.6);
        Alternativa eyrieWinterfell2 = new Alternativa("Alternativa 2", 231, 3.6, 2.1);
        Alternativa winterfellCastle = new Alternativa("Alternativa 1", 120, 1.9, 0.9);
        Alternativa winterfellCastle2 = new Alternativa("Alternativa 2", 108, 2.5, 3);

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

        GameOfThrones got = new GameOfThrones();
        Criterio crit = new Criterio(-1, -1, -1, -1);
        
        while(true) { // INICIAL MENU
            got.initialMenu();
            got.readOption();
            if (got.getOpt() == 1) { // START GAME MENU
                while(true) {
                    got.startGameMenu();
                    got.readOption();
                    if (got.getOpt() == 1) {
                        while(true) {
                            got.simMenu();
                            got.readOption();
                            if(got.getOpt() == 1) {
                                // LER CIDADES INICIAL E DESTINO
                            } else if(got.getOpt() == 2) {
                                // SHOW PATHS BY MAX TROOPS LOST
                            } else if(got.getOpt() == 3) {
                                // SHOW PATHS BY LOSSES PER COMBAT
                            } else if(got.getOpt() == 4) {
                                // SHOW PATHS BY MAX COMBATS
                            } else if(got.getOpt() == 5) {
                                // SHOW PATHS BY CRITERIA
                                
                            } else if(got.getOpt() == 6) {
                                break;
                            }
                        }
                        // SIMULATE PATH
                        // LER CRITERIOS
                    } else if(got.getOpt() == 2) {
                        // CONQUER 
                    } else if(got.getOpt() == 3) {
                        break;
                    }
                }
            } else if (got.getOpt() == 2) { // EDIT GAME MENU
                while(true) {
                    got.editGameMenu();
                    got.readOption();
                    if(got.getOpt() == 1) {
                        // EDIT CITY
                        while(true) {
                            got.editCityMenu();
                            got.readOption();
                            if(got.getOpt() == 1) {
                                // EDIT CITY NAME
                            } else if(got.getOpt() == 2) {
                                // EDIT CITY DEFENSES
                            } else if(got.getOpt() == 3) {
                                break;
                            }
                        }
                    } else if(got.getOpt() == 2){
                        // EDIT PATH
                        while(true) {
                            got.editPathMenu();
                            got.readOption();
                            if(got.getOpt() == 1) {
                                // EDIT PATH DISTANCE
                            } else if(got.getOpt() == 2) {
                                // EDIT PATH DURATION
                            } else if(got.getOpt() == 3) {
                                // EDIT PATH COST
                            } else if(got.getOpt() == 4) {
                                break;
                            }
                        }
                    } else if(got.getOpt() == 3) {
                        break;
                    }
                }
            } else if (got.getOpt() == 3) { // EXIT GAME
                break;
            }
        }
        //ArrayUnorderedList path = mapa.getMinTroopsPath(castleBlack, theEyrie, tropas);
    }

}
