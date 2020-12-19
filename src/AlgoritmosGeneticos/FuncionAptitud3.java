package AlgoritmosGeneticos;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

/**
 *
 * @author Javier Erazo
 */
public class FuncionAptitud3 extends FitnessFunction{
    /*(log(2)+log(11-x^2))/(log(5-x))-2*/
    private double fitness;
    
    public static double traslado = 5; //Para evitar caer en valores negativos en Y y fitness no sea negativo
    
    private double maxGen = 3.99;
    public static double valorMaxPositivo = Math.sqrt(11) ; //El decimal se debe a que abajo limitamos la parte decimal
    public static double valorMaxNegativo = -(Math.sqrt(11)); //El decimal se debe a que abajo limitamos la parte decimal
    /*para no tomar valores mayores a 2 y no obtener valores NaN
    delimitadorDominio se restara a todos los valores de X para que no 
    sobrepase el valor de 2*/
    public static double delimitadorDominio = 0.7;
    
    public static double ajuste ;
    
    public FuncionAptitud3(){
        this.fitness = 0;
        
        this.ajuste = calcularFuncion(maxGen - delimitadorDominio) +traslado;
        System.out.println("el fitness quedo es " + this.fitness);
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
        
        for(int j = 1; j <= 2; j++){
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
        if (individuo[0] == 0){
            valorX *= (-1);
        }
      //System.out.println("el valor x = " + valorX + "El valor max positivo" + valorMaxPositivo) ;
        if (Math.abs(valorX) > valorMaxPositivo){
            //System.err.println("Encontramos un intruso -----" + valorX);
            fitness = 0;
        } else {
            fitness = this.ajuste - calcularFuncion(valorX);
        }
        
        
        
        //System.out.println("FITNESS ES  " + fitness + "con x =  " + valorX);
    }
    
    private double calcularFuncion(double x){
        double a = ((Math.log10(2) + Math.log10(11-Math.pow(x, 2)))/(Math.log10(5 - x)))-2;
        //System.out.println("El x es = " + x + " El resultado es " + a );
        return a;
    }
    
    
}
