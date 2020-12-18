package AlgoritmosGeneticos;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

/**
 *
 * @author Javier Erazo
 */
public class Prueba1 {
    
    public void empezar(){
        try {
            Configuration configuracion = new DefaultConfiguration();
            FitnessFunction myFunc = new FuncionAptitud1();
            configuracion.setFitnessFunction(myFunc);
            /*Vamos a aceptar reales; 4 bits para la parte entera
            7 bits para la parte decimal, 1 bit de signo y la coma representado por el cero*/
            Gene[] genes = new Gene[12];
            genes[0] = new IntegerGene(configuracion, 0, 1); //Signo
            genes[1] = new IntegerGene(configuracion, 0, 1);//Entera
            genes[2] = new IntegerGene(configuracion, 0, 1);
            genes[3] = new IntegerGene(configuracion, 0, 1);
            genes[4] = new IntegerGene(configuracion, 0, 1);
            genes[5] = new IntegerGene(configuracion, 0, 1);//Parte Decimal
            genes[6] = new IntegerGene(configuracion, 0, 1);
            genes[7] = new IntegerGene(configuracion, 0, 1);
            genes[8] = new IntegerGene(configuracion, 0, 1);
            genes[9] = new IntegerGene(configuracion, 0, 1);
            genes[10] = new IntegerGene(configuracion, 0, 1);
            genes[11] = new IntegerGene(configuracion, 0, 1);
           
          
            
//            for (int i = 0; i<= 4; i++){
//                genes[i] = new IntegerGene(configuracion, 0, 1);
//            }
//            genes[5] = new IntegerGene(configuracion, 0, 0);
//            for (int i = 6; i< genes.length; i++){
//                genes[i] = new IntegerGene(configuracion, 0, 1);
//            }
            Chromosome cromosomaNumero = new Chromosome(configuracion, genes);
            configuracion.setSampleChromosome(cromosomaNumero);
            configuracion.setPopulationSize(7);
            Genotype poblacion = Genotype.randomInitialGenotype(configuracion);
            System.err.println("Poblacion iniciada");
            Mostrar show = new Mostrar();
            
            for(int m = 0; m < 5; m++){
                System.out.println("-------------------Inicio generacion-------------------");
                System.out.println("Iteracion #" + m);
                show.mostrarTodosIndividuos(poblacion.getChromosomes(), 4);
                poblacion.evolve(12);
                IChromosome mejorIndividuo = poblacion.getFittestChromosome();
                show.mostrarIndividuo(mejorIndividuo,4);
                double valorY =  ( (mejorIndividuo.getFitnessValue())-FuncionAptitud1.ajuste)*(-1);//Ajustamos el valor de y
                System.out.println("El minimo de la funcion es: " + valorY); 
                System.out.println("-----------------------------------Fin Generacion---------------------------");
                System.out.println("Mejor individuo: ");
                show.mostrarIndividuo(poblacion.getFittestChromosome(),4); //mejor individuo obtenido
                System.out.println("y = " + valorY);
            }  
        } catch (InvalidConfigurationException e) {
            System.out.println("No se pudo ejecutar el AG");
        }
        
        
        
    }
    
}
