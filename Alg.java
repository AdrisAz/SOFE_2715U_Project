import java.nio.file.DirectoryStream;
import java.util.*;


import java.lang.Math;


public class Alg {
    public static int Cent = 5;
    public static int n = 10;
    public ArrayList<Integer>[] al = new ArrayList[n];
    public ArrayList<Double>[] cent = new ArrayList[Cent];
    public ArrayList<ArrayList<Integer>>[] sorted = new ArrayList[Cent];
    public Double[][] dist = new Double[Cent][n];



    public void createArrayList() {

        Random randy = new Random();

        for (int i=0; i<n; i++) {
            al[i] = new ArrayList<Integer>();
            al[i].add(randy.nextInt(51));
            al[i].add(randy.nextInt(51));

        }


    }


    public void PrintList() {

        for (int i=0; i<n; i++) {
            // System.out.println("Data Point " + (i+1) + " is at " + al[i]);

        } //System.out.println("\n");
    }

    public void createCentroids() {
        Random randy = new Random();


        for (int i=0; i<Cent; i++) {
            cent[i] = new ArrayList<Double>();
            cent[i].add(randy.nextInt(51)+randy.nextDouble());
            cent[i].add(randy.nextInt(51)+randy.nextDouble());
        }

    }
    public void createSorted() {
        for (int i=0; i<Cent; i++) {
            sorted[i] = new ArrayList<>();
        }
    }


    public void computedistance()
    {
        double Edistance ,x,y,w,z,temp;
        for (int l=0; l<n; l++)
        {
            // System.out.println("DATA POINT " + (l+1));
            for (int i=0 ; i< Cent; i++)
            {
                x = al[l].get(0);
                y = al[l].get(1);
                w = cent[i].get(0);
                z = cent[i].get(1);

                Edistance = Math.sqrt(Math.pow(x-w,2)+Math.pow(y-z,2));
                dist[i][l] = Edistance;
                //System.out.println("Centroid " + (i+1) + " is " + dist[i][l] + " from the data point");
            }
            //System.out.println("\n");

        }

    }
    public Double[][] getDist(){
        return dist;
    }

    public void clusterAssign() {
        for (int l=0; l<n; l++) {
            //Increments throught number of centroids
            // int t=0;
            int Index =0;
            //sorted[0].add(al[l]);
            //first Value
            double FirstV=dist[0][l];
            for(int x=0;x<Cent-1;x++){
                if (dist[x + 1][l] < FirstV) {
                    FirstV =dist[x+1][l];
                    // System.out.println("Dist[x+1]: "+dist[x+1][l]);
                    // System.out.println("Dist[x]: "+dist[x][l]);
                    Index =x+1;

                }

            }
            //System.out.println("Index: "+Index);
            sorted[Index].add(al[l]);

//            if (dist[0][l] < dist[1][l] && dist[0][l] < dist[2][l] && dist[0][l] < dist[3][l]) {
//                sorted[0].add(al[l]);
//
//            } else if (dist[1][l] < dist[0][l] && dist[1][l] < dist[2][l] && dist[1][l] < dist[3][l]) {
//                sorted[1].add(al[l]);
//
//            } else if (dist[2][l] < dist[1][l] && dist[2][l] < dist[0][l] && dist[2][l] < dist[3][l]) {
//                sorted[2].add(al[l]);
//
//            } else if (dist[3][l] < dist[1][l] && dist[3][l] < dist[2][l] && dist[3][l] < dist[0][l]) {
//                sorted[3].add(al[l]);
//
//            }
        }
    }
    public void MoveCluster(){
        Random randy = new Random();
        EmptyCent();
        for (int i = 0; i < Cent; i++) {
            int temp=0;
            int x=0,y=0;
            if(sorted[i].isEmpty()){
                cent[i].remove(0);
                cent[i].remove(0);
                cent[i].add(randy.nextInt(51)+randy.nextDouble());
                cent[i].add(randy.nextInt(51)+randy.nextDouble());
                break;
            }
            for (int j = 0; j <= n; j++) {

                if(sorted[i].isEmpty()){
                    break;
                }else {
                    y += sorted[i].get(0).get(1);
                    x += sorted[i].get(0).get(0);
                    sorted[i].remove(0);
                    //System.out.println(x + " " + y);
                    temp++;
                }



            }
            double newx=0,newy=0;
            newx=  (double)x/temp;
            newy =(double) y/temp;

            cent[i].add(newx);
            cent[i].add(newy);

        }

    }
    public double last=0;
    public void nextCheck(){
        int four=0;
        double one=0,two=0,three=70;
        while(three !=0) {

            EmptySorted();
            computedistance();

            clusterAssign();
            PrintSorted();
            MoveCluster();
            PrintCent();
            // One is Distance Value for first Iteration
            // System.out.println("Last: "+last);
            one = Value();
            // System.out.println("One: "+one);
            three = one -last;
            //System.out.println("Change: "+three);
            last =one;
            // System.out.println("NEW last: "+last);
            // System.out.println(one);
            // Four Is the Iteration Count
            four++;
            System.out.println("Iteration: "+four);
            System.out.println("------------------------------------------------------------------------");
            System.out.println("\n");
//
//            EmptySorted();
//            computedistance();
//            clusterAssign();
//            PrintSorted();
//            MoveCluster();
//            PrintCent();
//            // Two is distance Value for Second Iteration
//            two = Value();
//            //Three is the difference of the two distance values
//            three =(double) one-two;
//            System.out.println("Distance Change: "+three);
//            four++;
//            System.out.println("Iteration: "+four);
//            System.out.println("------------------------------------------------------------------------");
//            System.out.println("\n");

        }
    }
    // public double getCent(){
    //   return cent;
    // }
    public double Value(){
        double temp2=0,temp;
        for (int i=0;i<Cent;i++) {
            temp =cent[i].get(0);
            //System.out.println("Temp: "+temp);
            temp2 +=  temp;
            temp =cent[i].get(1);
            //System.out.println("Temp2: "+temp);
            temp2 +=  temp;

        }
        return temp2;
    }
    public void EmptySorted(){
        for (int i=0; i<Cent; i++) {

            while(!sorted[i].isEmpty()){
                sorted[i].remove(0);
                //sorted[i].remove(0);
            }
        }
    }


    public void Emptydist(){

    }


    public void PrintSorted(){
        for (int i=0; i<Cent; i++) {

            System.out.println("The Sorted Points are"  + sorted[i]);
        }
        System.out.println("\n");
    }

    public void PrintCent() {

        for (int i=0; i<Cent; i++) {

            System.out.println("Centroid " + (i+1) + " is at " + cent[i]);
        }
        System.out.println("\n");

    }
    public void EmptyCent(){
        for (int i=0; i<Cent; i++) {
            if(sorted[i].isEmpty()){
                break;
            }
            else {
                cent[i].remove(0);
                cent[i].remove(0);
            }
        }
    }



}
