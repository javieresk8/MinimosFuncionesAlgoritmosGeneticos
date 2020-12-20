
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
 * 
 */
public class Prueba6 {
    
   public void empezar(){
       try {
           Configuration configuracion = new DefaultConfiguration();
           FitnessFunction funcion = new FuncionAptitud6();
           configuracion.setFitnessFunction(funcion);
           /*Se utiliza un bit de signo, 4 bits para la parte entera y 
           7 bits para la parte decimal de dos digitos*/
           Gene[] genes = new Gene[12];
           
           for (int i = 0; i < genes.length; i++){
               genes[i] = new IntegerGene(configuracion, 0, 1); 
           }
           
           Chromosome cromosomaNumero = new Chromosome(configuracion, genes);
           configuracion.setSampleChromosome(cromosomaNumero);
           configuracion.setPopulationSize(5);
           Genotype poblacion = Genotype.randomInitialGenotype(configuracion);
           System.out.println("Poblacion iniciada");
           Mostrar show = new Mostrar();
           
           for(int m = 0; m < 5; m++ ){
                System.out.println("Inicio de la Generacion");
                System.out.println("Generacion " + m);
                show.mostrarTodosIndividuos(poblacion.getChromosomes(), 4);
                poblacion.evolve(10);
                IChromosome mejorIndividuo = poblacion.getFittestChromosome();
                show.mostrarIndividuo(mejorIndividuo, 4);
                double valorY = (mejorIndividuo.getFitnessValue() - FuncionAptitud5.ajuste)* (-1);
                System.out.println("El minimo de la funcion es: " + valorY);
                System.out.println("-----------------------------------Fin Generacion---------------------------");
                System.out.println("Mejor individuo: ");
                show.mostrarIndividuo(poblacion.getFittestChromosome(), 4); //Reajuste
                System.out.println("y = " + valorY);
                
                
                
           }
       } catch (InvalidConfigurationException e) {
           System.err.println("No se pudo ejecutar el AG...");
       }
   }
}
