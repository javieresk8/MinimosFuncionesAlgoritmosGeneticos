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
public class Prueba3 {
    
    public void empezar(){
       
        try {
            Configuration configuracion = new DefaultConfiguration();
            FitnessFunction funcion = new FuncionAptitud3();
            
            configuracion.setFitnessFunction(funcion);
            
            /*Se van a usar q gen de signo, 2 genes para la parte entera y
            7 genes para la parte*/
            Gene[] genes = new Gene[10];
            
            for (int i = 0; i < genes.length; i ++){
                genes[i] = new IntegerGene(configuracion, 0 , 1);
            }
            
            Chromosome cromosoma = new Chromosome(configuracion, genes);
            configuracion.setSampleChromosome(cromosoma);
            
            configuracion.setPopulationSize(7);
            Genotype poblacion = Genotype.randomInitialGenotype(configuracion);
          
            System.out.println("Poblacion iniciada");
            Mostrar show = new Mostrar();
            
            for (int j = 0; j < 5; j ++){
                System.out.println("Inicia la Generacion");
                System.out.println("Generacion " + j);
                show.mostrarTodosIndividuos(poblacion.getChromosomes(), 2);
                poblacion.evolve(10);
                IChromosome mejorIndividuo = poblacion.getFittestChromosome();
                show.mostrarIndividuo(mejorIndividuo, 2);
                double valorY = (mejorIndividuo.getFitnessValue() - FuncionAptitud3.ajuste) * (-1); //Ajuste
                System.out.println("El minimo de la funcion es: " + valorY);
                System.out.println("-----------------------------------Fin Generacion---------------------------");
                System.out.println("Mejor individuo: ");
                show.mostrarIndividuo(poblacion.getFittestChromosome(), 2); //Reajuste
                System.out.println("y = " + valorY);
                
            }
           
            
        } catch (InvalidConfigurationException e) {
           System.err.println("No se pudo ejecutar el AG..." + e);
        }
        
        
    }
    
    
}
