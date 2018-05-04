import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GraphInfo graphInfo = new GraphInfo();
        Graph graph = graphInfo.CreatGraph();

        while(true){
            System.out.println("请输入将要进行的操作编号：");
            System.out.println("1.查看place和每个place的token数");
            System.out.println("2.查看transition");
            System.out.println("3.发射transition");
            System.out.println("4.增加place");
            System.out.println("5.增加transition");
            System.out.println("6.退出程序");

            Scanner scanner = new Scanner(System.in);
            int p = scanner.nextInt();
            switch (p){
                case 1:
                    System.out.println("place id    token");
                    for(int i = 0 ; i < 10 ; i ++){
                        if(graph.placeArray[i]!=null){
                            System.out.print("    "+graph.placeArray[i].getPlaceId()+"         ");
                            System.out.println(graph.placeArray[i].getToken());
                        }
                    }
                    break;
                case 2:
                    System.out.println("transition id");
                    for(int i = 0 ; i < 10 ; i ++){
                        if(graph.transitionArray[i]!=null){
                            System.out.println("      "+graph.transitionArray[i].getTransitionId());
                        }
                    }
                    break;
                case 3:
                    System.out.println("请输入要发射的transition id");
                    int id = scanner.nextInt();
                    while(graph.transitionArray[id-1] == null || id > 10){
                        System.out.println("输入的id不存在，请重新输入");
                        id = scanner.nextInt();
                    }

                    if(graphInfo.CanFire(graph,id)){
                        graphInfo.Fire(graph,id);
                        System.out.println("发射成功");
                    }
                    else{
                        System.out.println("发射失败，没有足够的token");
                    }
                    break;
                case 4:
                    System.out.println("请输入place中拥有的token数量");
                    int token = scanner.nextInt();
                    System.out.println("要添加的place的id为"+(graph.placeNum+1)+",持有的token数为"+token);
                    Place place = new Place(graph.placeNum+1 ,token);
                    if(graphInfo.addPlace(graph,place)){
                        System.out.println("添加place成功");
                    }
                    else{
                        System.out.println("无法添加place" + (graph.placeNum+1) + "，请先添加transition");
                    }
                    break;
                case 5:
                    System.out.println("要添加的transition的id为"+(graph.transitionNum+1));
                    Transition transition = new Transition(graph.transitionNum+1);
                    if(graphInfo.addTransition(graph,transition)){
                        System.out.println("添加transition成功");
                    }
                    else{
                        System.out.println("无法添加transition" + (graph.transitionNum+1) + "，请先添加place");
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }

    }
}
