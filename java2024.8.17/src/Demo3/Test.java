package Demo3;

public class Test {
    public static void main(String[] args) {

//        GraphByMatrix graph = new GraphByMatrix(4,false);
//        char[] array = {'A','B','C','D'};
//        graph.initArrayV(array);
//
//        graph.insert('A','B',1);
//        graph.insert('A','D',1);
//        graph.insert('B','A',1);
//        graph.insert('B','C',1);
//        graph.insert('C','B',1);
//        graph.insert('C','D',1);
//        graph.insert('D','A',1);
//        graph.insert('D','C',1);
//
//        System.out.println("getDevOfV:: "+graph.getDevOfV('A'));
//        graph.printGraph();



            GraphByNode graph = new GraphByNode(4,true);
            char[] array = {'A','B','C','D'};
            graph.initArrayV(array);

            graph.insert('A','B',1);
            graph.insert('A','D',1);
            graph.insert('B','A',1);
            graph.insert('B','C',1);
            graph.insert('C','B',1);
            graph.insert('C','D',1);
            graph.insert('D','A',1);
            graph.insert('D','C',1);

            System.out.println("getDevOfV:: "+graph.getDevOfV('A'));
            graph.printGraph();

    }
}
