/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmosGeneticos;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

/**
 *
 * @author Admin
 */
public class FuncionAptitud1 extends FitnessFunction{
    /**(x^2-5x+9)lg(2)+lg(125)-3 = y*/
    private double fitness;
    public static double ajuste = 102.84;
    public FuncionAptitud1(){
        fitness = 0;
    }
    @Override
    protected double evaluate(IChromosome ic) {
        evaluar(ic);
        return fitness;
    }
    
    private void evaluar(IChromosome cromosoma){
        Integer[] individuo = new Integer[cromosoma.size()];
        //System.out.println("El tamano del coromosoma es " + cromosoma.size());
        double valorX;
        String parteEntera = "";
        String parteDecimal = "";
        int valorEntero;
        double valorDecimal;
//        for(int i = 0; i < individuo.length;i++){
//            individuo[i] = (Integer) cromosoma.getGene(i).getAllele();         
//        }
        Integer c1 = (Integer) cromosoma.getGene(0).getAllele();
        Integer c2 = (Integer) cromosoma.getGene(1).getAllele();
        Integer c3 = (Integer) cromosoma.getGene(2).getAllele();
        Integer c4 = (Integer) cromosoma.getGene(3).getAllele();
        Integer c5 = (Integer) cromosoma.getGene(4).getAllele();
        Integer c6 = (Integer) cromosoma.getGene(5).getAllele();
        Integer c7 = (Integer) cromosoma.getGene(6).getAllele();
        Integer c8 = (Integer) cromosoma.getGene(7).getAllele();
        Integer c9 = (Integer) cromosoma.getGene(8).getAllele();
        Integer c10 = (Integer) cromosoma.getGene(9).getAllele();
        Integer c11 = (Integer) cromosoma.getGene(10).getAllele();
        Integer c12 = (Integer) cromosoma.getGene(11).getAllele();
        
        
        //valor+=individuo[0] == 0 ?"-":"";
        parteEntera = c2.toString() + c3.toString() + c4.toString() + c5.toString();
        parteDecimal =   c6.toString() + c7.toString() + c8.toString() + c9.toString()
                 + c10.toString() + c11.toString() + c12.toString();
//        for(int i = 1 ; i <=4 ; i++){
//            parteEntera+= individuo[i].toString();
//        }
        
        valorEntero = Integer.parseInt(parteEntera, 2);
//        System.out.println("La parte entera es:" + valorEntero);
//        for(int i = 5 ; i < individuo.length ; i++  ){
//            parteDecimal+= individuo[i].toString();
//        }
        valorDecimal = Integer.parseInt(parteDecimal, 2);
        /*Ajuste para tener decimales hasta .99*/
        if (valorDecimal>=100){
            valorDecimal -=28;
        }
        valorDecimal/=100;
//        System.out.println("La parte decimal es:" + valorDecimal);
        valorX = valorEntero + valorDecimal;
//        System.out.println("El total es " + valorX);
        if (c1== 0){
            valorX *= (-1);
        }
//        System.out.println("El valor para x en fitness es " + valorX);
        fitness = ajuste -((Math.pow(valorX, 2) - (5 * valorX) + 9)* (Math.log10(2)) + Math.log10(125) -3);
        
       // System.out.println("El valor de fitness resulto  " + fitness + "con x = " + valorX);  
        
       // valor += valorEntero + "," + valorDecimal;
    }
    
}
