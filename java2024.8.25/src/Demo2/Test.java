package Demo2;

public class Test {
    public static void main(String[] args) {
        GraphByMatrix graph = new GraphByMatrix(4, true);
        char[] array = {'A', 'B', 'C', 'D'};
        graph.initialArrayV(array);

        graph.addEdge('A','B',1);
        graph.addEdge('A','D',1);
        graph.addEdge('B','A',1);
        graph.addEdge('B','C',1);
        graph.addEdge('C','B',1);
        graph.addEdge('C','D',1);
        graph.addEdge('D','A',1);
        graph.addEdge('D','C',1);

        System.out.println("getDevOfV:: "+graph.getDeevOfV('A'));
        graph.print();
    }
}
