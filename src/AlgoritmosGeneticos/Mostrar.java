/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmosGeneticos;

import org.jgap.IChromosome;

/**
 *
 * @author Admin
 */
public class Mostrar {
    Integer [] individuo;
      /*1 y 2 pasan 4, la 3 pasa 2 */
    /*Se le pasa un entero que indica la cantidad de bits asignados para la parte entera */
    public void mostrarIndividuo(IChromosome ind, int bitsEntero){
        individuo = new Integer[ind.size()];
        String valor = "";
        String parteEntera = "";
        String parteDecimal = "";
        int valorEntero;
        int valorDecimal;
        for(int i = 0; i < individuo.length;i++){
            individuo[i] = (Integer) ind.getGene(i).getAllele();         
        }
        
        valor+=individuo[0] == 0 ?"-":"";
        
        for(int i = 1 ; i <= bitsEntero ; i++  ){
            parteEntera+= individuo[i].toString();
        }
        valorEntero = Integer.parseInt(parteEntera, 2);
        for(int i = bitsEntero+1 ; i < individuo.length ; i++  ){
            parteDecimal += individuo[i].toString();
        }
        valorDecimal = Integer.parseInt(parteDecimal, 2);
        valor += valorEntero + "," + valorDecimal;
        System.out.println("x = " + valor);
        
        
    }
    
    public void mostrarTodosIndividuos(IChromosome[] ind, int bitsEntero){
        for (IChromosome cromosoma: ind){
            mostrarIndividuo(cromosoma, bitsEntero);
        }
        
    }
    

}
