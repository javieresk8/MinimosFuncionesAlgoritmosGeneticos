package AlgoritmosGeneticos;
import org.jgap.FitnessFunction;
import org.jgap.IChromosome;
/**
 *
 * @author Javier Erazo
 */
public class FuncionAptitud4 extends FitnessFunction {
 /*(x^2-4x+7)log(5)+log(16)-4*/
    private double fitness;
    //public static double traslado = 1; //Para evitar caer en valores negativos en Y y fitness no sea negativo
    public static double valorMax  ; 
    /*para no tomar valores mayores a 2 y no obtener valores NaN
    delimitadorDominio se restara a todos los valores de X para que no 
    sobrepase el valor de 2*/
   // public static double delimitadorDominio = ;
    
    public static double ajuste;
    
    public FuncionAptitud4(){
        this.fitness = 0;
        this.ajuste = calcularFuncion(15.99) ;
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
       // valorX -=  delimitadorDominio;//Ajustamos para evitar valores fuera del Dom de la funcion
//        System.err.println("Luego de la resta es " + valorX);
//        System.out.println("El delimitador de dom es  " + delimitadorDominio);
        
        fitness = ajuste - calcularFuncion(valorX);
        if (fitness < 0){
            fitness = 0;
        }
       // System.out.println("El valor de fitness resulto  " + fitness + "con x = " + valorX);  
       
        
    }
    
    private double calcularFuncion(double x ){
        return ( (Math.pow(x, 2) - (4 * x) + 7) * Math.log10(5) + Math.log10(16) - 4 );
    }
    
}
