import java.util.*;

public class Main {
    public static void main(String args[])
    {

        //Scanner input = new Scanner(System.in);
        //Random randy = new Random();
        //int n = 0;

        //System.out.println("Number of point values");
        //n=input.nextInt();
        Alg Alg = new Alg();
        Alg.createArrayList();
        Alg.createCentroids();
        Alg.PrintList();
        //Alg.PrintCent();
        //Alg.computedistance();
        Alg.createSorted();
        //Alg.clusterAssign();
        //Alg.PrintSorted();
        //Alg.MoveCluster();
        //Alg.PrintCent();
        Alg.nextCheck();

    }
}
