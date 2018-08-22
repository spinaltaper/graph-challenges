package whiteboard.classes;
import java.util.*;

public class AdjacencyListGraph<E> implements Graph<E> {
    Set<Node<E>> nodes = new HashSet<Node<E>>();
    Set<Edge<E>> edges = new HashSet<Edge<E>>();

    public AdjacencyListGraph() {
    }

    public Set<Node<E>> getNodes() {
        return this.nodes;
    }

    public Set<Edge<E>> getEdges() {
        return this.edges;
    }

    @Override
    public void addNode(Node<E> node) {
        this.nodes.add(node);
    }

    @Override
    public void addEdge(Node<E> start, Node<E> end) {
        addEdge(start,end,0);
    }

    @Override
    public void addEdge(Node<E> start, Node<E> end, int cost) {
        this.edges.add(new Edge<>(start,end,cost));
    }

    @Override
    public void addTwoWayEdge(Node<E> start, Node<E> end) {
        addTwoWayEdge(start,end,0);
    }

    @Override
    public void addTwoWayEdge(Node<E> start, Node<E> end, int cost) {
        addEdge(start,end,cost);
        addEdge(end,start,cost);
    }

    @Override
    public Set<Node<E>> getNeighbors(Node<E> node) {
        Set<Node<E>> returnSet = new HashSet<>();
        for(Edge currEdge: getEdges()){
            if(node==currEdge.getEnd()){
                returnSet.add(currEdge.getStart());
            }
            if(node==currEdge.getStart()){
                returnSet.add(currEdge.getEnd());
            }
        }
        return returnSet;
    }

    @Override
    public boolean isConnected(Node<E> start, Node<E> end) {
        try {
            for (Edge currEdge : getEdges()) {
                if (end == currEdge.getEnd()) {
                    if (start == currEdge.getStart()) {
                        return true;
                    }
                }
            }
            return false;
        } catch{

        }
    }

    @Override
    public Edge<E> getEdge(Node<E> start, Node<E> end) {
        for(Edge currEdge: getEdges()){
            if(end==currEdge.getEnd()){
                if(start==currEdge.getStart()){
                    return currEdge;
                }
            }
        }
        return null;
    }

    private void checkNodesExists(Node<E> node1, Node<E> node2) {
    }

    // leverage method overloading and use plural naming even for the single node check
    // because it's way easier to write the same method name everywhere than to remember to
    // write either "node" vs "nodes" in "checkNodeExists" or "checkNodesExists"
    private void checkNodesExists(Node<E> node) {
    }
}
