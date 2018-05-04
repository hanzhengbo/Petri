import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.Scanner;

public class GraphInfo {
    public boolean addPlace(Graph graph ,Place place){
        if(graph.placeNum == 10){
            System.out.println("无法添加place，没有充足的空间");
            return false;
        }
        graph.placeArray[graph.placeNum] = place;
        Scanner scanner = new Scanner(System.in);
        int id;
        while(true){
            System.out.println("请输入place所指向的transition Id（输入0则代表结束输入）");

            id = scanner.nextInt();
            while(id > graph.transitionNum ||id < 0){
                System.out.println("输入的id不存在，请重新输入");
                id = scanner.nextInt();
            }
            if(id != 0)
                graph.places[graph.placeNum][id-1] = 1;
            else
                break;
        }
        while (true){
            System.out.println("请输入指向该place的transition Id（输入0则代表结束输入）");
            id = scanner.nextInt();
            while(id > graph.transitionNum || id < 0){
                System.out.println("输入的id不存在，请重新输入");
                id = scanner.nextInt();
            }
            if(id != 0)
                graph.transitions[id-1][graph.placeNum] = 1;
            else
                break;
        }

        graph.placeNum++;
        return true;
    }
    public boolean addTransition(Graph graph,Transition transition){
        if(graph.transitionNum == 10){
            System.out.println("无法添加transition，没有充足的空间");
            return false;
        }
        graph.transitionArray[graph.transitionNum] = transition;
        Scanner scanner = new Scanner(System.in);
        int id;
        while(true){
            System.out.println("请输入transition所指向的place Id（输入0则代表结束输入）");
            id = scanner.nextInt();
            while(id > graph.placeNum ||id < 0){
                System.out.println("输入的id不存在，请重新输入");
                id = scanner.nextInt();
            }
            if(id != 0 )
                graph.transitions[graph.placeNum][id-1] = 1;
            else
                break;
        }
        while(true){
            System.out.println("请输入指向该transition的place Id（输入0则代表结束输入）");
            id = scanner.nextInt();
            while(id > graph.placeNum || id < 0){
                System.out.println("输入的id不存在，请重新输入");
                id = scanner.nextInt();
            }
            if(id!=0)
                graph.places[id-1][graph.transitionNum] = 1;
            else
                break;
        }

        graph.transitionNum++;
        return true;
    }

    public Graph CreatGraph(){
        Graph graph = new Graph();
        Scanner scan=new Scanner(System.in);
        //System.out.println("请输入顶点数：(顶点数为2的倍数)");
        graph.verNum=10;
        int num = graph.verNum;
//        while (num %2 != 0){
//            System.out.println("请重新输入顶点数：(顶点数为2的倍数)");
//            graph.verNum=scan.nextInt();
//            num = graph.verNum;
//        }

        for(int i = 1 ; i <=graph.verNum ; i ++){
            if(i%2 == 1){
                Place place = new Place(i/2+1,(int)(Math.random()*5)+1);
                //place.nextNode = null;
                graph.placeArray[(i-1)/2] = place;
                graph.placeNum++;
            }
            else{
                Transition transition = new Transition(i/2);
                transition.setNextNode(null);
                graph.transitionArray[i/2-1] = transition;
                graph.transitionNum++;
            }
        }
        for(int i = 1 ; i <=graph.verNum/2 ; i++){
            graph.edgeNum++;
            graph.places[i-1][i-1] = 1;
        }
        for(int i = 1 ; i <=graph.verNum/2-1 ; i++){
            graph.edgeNum++;
            graph.transitions[i-1][i] = 1;
        }

        return graph;
    }
    boolean CanFire(Graph graph , int id){
        for(int i = 0 ; i < 10 ; i ++){
            if(graph.places[i][id-1] == 1){
                if(graph.placeArray[i].getToken()<1)
                    return false;
            }
        }
        return true;
    }
    void Fire(Graph graph , int id){
        if(CanFire(graph,id)){
            for(int i = 0 ; i < 10 ; i++){
                if(graph.places[i][id-1] == 1){
                    graph.placeArray[i].setToken(graph.placeArray[i].getToken()-1);
                    for(int j = 0 ; j < 10 ; j ++){
                        if(graph.transitions[id-1][j] ==1)
                            graph.placeArray[j].setToken(graph.placeArray[j].getToken()+1);
                    }
                }

            }
        }
    }
}
