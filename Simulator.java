import java.lang.reflect.Array;
import java.util.ArrayList;

public class Simulator {
    public int piecesOfFood;
    public int timout =0;


    public int population;
    int[] takenpositions;
    
    
    public Simulator(int Startpopulation, int piecesOfFood){
        this.population = Startpopulation;
        this.piecesOfFood = piecesOfFood;
        takenpositions = new int[piecesOfFood];
       
    }
    public void startUp(){
      System.out.println(population);
        for (int i = 0; i < takenpositions.length; i++) {
            takenpositions[i] = 0;

        }
        

        day();

    }
    public void day(){
        for (int i = 0; i < population; i++) {
            int choose = (int)(Math.random()*piecesOfFood);
            if(takenpositions[choose]>1){
                while(takenpositions[choose]>1){
                choose = (int)(Math.random()*piecesOfFood);
                }
                

            }
            takenpositions[choose] ++;
    
        }
        int popchange = 0;
        for (int i = 0; i < piecesOfFood; i++) {
            if(takenpositions[i]==1){
                popchange++;
            }
            if(takenpositions[i]==2){
                popchange--;
            }
            
        }
        population+=popchange;
        if(population>200){timout++;}
        if(timout<50){
        startUp();}
    
    }
    public static void main(String[] args) {
        Simulator s = new Simulator(1, 250);
        s.startUp();
    }
}
