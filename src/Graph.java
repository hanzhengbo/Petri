import java.util.Scanner;

public class Graph {
    int[][] places = new int[10][10];
    int[][] transitions = new int[10][10];
    Place[] placeArray = new Place[10];
    Transition[] transitionArray = new Transition[10];
    int verNum;
    int edgeNum;
    int placeNum;
    int transitionNum;


    public int getPlaceNum() {
        return placeNum;
    }

    public void setPlaceNum(int placeNum) {
        this.placeNum = placeNum;
    }

    public int getTransitionNum() {
        return transitionNum;
    }

    public void setTransitionNum(int transitionNum) {
        this.transitionNum = transitionNum;
    }

    public Graph(){
        for(int i = 0 ; i<10 ; i++){
            for(int j = 0 ; j < 10 ; j ++){
                places[i][j] = 0;
                transitions[i][j] = 0;
            }
        }
        int verNum = 0;
        int edgeNum = 0;
    }

    public Graph(Place[] placeArray, Transition[] transitionArray) {
        this.placeArray = placeArray;
        this.transitionArray = transitionArray;
    }
}
