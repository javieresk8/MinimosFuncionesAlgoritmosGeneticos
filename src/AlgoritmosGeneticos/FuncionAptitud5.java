
package AlgoritmosGeneticos;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

/**
 *
 * @author Javier Erazo
 */
public class FuncionAptitud5 extends FitnessFunction{
    /*log(2^(2-x))^(2+x)+log(1250)-4*/
    private double fitness;
    public static double valorMax = 15.99; //El decimal se debe a que abajo limitamos la parte decimal
    
    
    public static double ajuste;
    
    public FuncionAptitud5(){
        this.fitness = 0;
        this.ajuste = calcularFuncion(valorMax);
    }

    @Override
    protected double evaluate(IChromosome ic) {
        evaluar(ic);
        return fitness;
    }
    
    private void evaluar(IChromosome ic){
        Integer individuo[] = new Integer[ic.size()];
        double valorX, valorDecimal;
        String parteEntera="", parteDecimal = "";
        int valorEntero;
        for (int i = 0; i < individuo.length; i++){
            individuo[i] = (Integer) ic.getGene(i).getAllele();
            
        }
        
        for(int j = 1; j < 5; j++){
            parteEntera+=individuo[j].toString();
        }
        valorEntero = Integer.parseInt(parteEntera, 2);
        
        for(int k = 5; k < individuo.length; k++){
            parteDecimal+=individuo[k].toString();
        }
        valorDecimal = Integer.parseInt(parteDecimal, 2);
        if (valorDecimal >= 100){
            valorDecimal -= 28;
        }
        valorDecimal /= 100;
        valorX = (valorEntero + valorDecimal) ; 
        //System.err.println("el vlaor de x salio " + valorX);
        if (individuo[0] == 0){
            valorX *= (-1);
        }
        
        if (valorX < 1){
            valorX =1;
        }
       // valorX -=  delimitadorDominio;//Ajustamos para evitar valores fuera del Dom de la funcion
//        System.err.println("Luego de la resta es " + valorX);
//        System.out.println("El delimitador de dom es  " + delimitadorDominio);
        
        fitness = ajuste - calcularFuncion(valorX);
        if(fitness < 0){
            fitness = 0;
        }
       // System.out.println("El valor de fitness resulto  " + fitness + "con x = " + valorX);  
       
        
    }
    
    private double calcularFuncion(double x ){
        return ( Math.log10(x + Math.sqrt(Math.pow(x, 2)-1)) + Math.log10(x - Math.sqrt(Math.pow(x, 2)-1)));
    }
    
}
