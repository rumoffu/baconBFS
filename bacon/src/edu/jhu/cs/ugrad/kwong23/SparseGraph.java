/**
 * Package info.
 */
package edu.jhu.cs.ugrad.kwong23;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class SparseGraph<V, E> implements Graph<V, E>{

    ArrayList<Vertex<V>> Vertices;
    ArrayList<Edge<E>> Edges;

    SparseGraph()
    {
        Vertices = new ArrayList<Vertex<V>>();
        Edges = new ArrayList<Edge<E>>();
    }

    class Vert<V> implements Vertex<V>
    {
        ArrayList<Edge<E>> VEdges;
        V name;
        Object label;
        
        Vert(V v)
        {
            this.name = v;
            this.VEdges = new ArrayList<Edge<E>>();
            this.label = v;
        }

        @Override
        public V get() {
            return this.name;
        }

        @Override
        public void put(V t) {
            this.name = t;
        }
        
        public void addEdge(Edge<E> ej)
        {
            this.VEdges.add(ej);
        }
    }

    
    class Ed<E> implements Edge<E>
    {
        Vertex<V> source;
        Vertex<V> sink;
        E value;
        Object label;
        
        Ed(E e, Vertex<V> from, Vertex<V> to)
        {
            this.value = e;
            this.source = from;
            this.sink = to;
            this.label = e;
        }

        @Override
        public E get() {
            return this.value;
        }

        @Override
        public void put(E t) {
            this.value = t;
            
        }
        
    }
    
    /**
        Insert new vertex.
        @param v Element to insert.
        @return Vertex position created to hold element.
     */
    public Vertex<V> insert(V v) {
        Vert<V> Node = new Vert<V>(v);
        Vertices.add(Node);
        return Node;
    }

    /**
        Insert new edge.
        @param from Vertex position where edge starts.
        @param to Vertex position where edge ends.
        @param e Element to insert.
        @return Edge position created to hold element.
        @throws IllegalArgumentException If vertex positions
            are invalid or if this insertion would create a
            duplicate edge.
     */
    public Edge<E> insert(Vertex<V> from, Vertex<V> to, E e)
            throws IllegalArgumentException {
        Ed<E> edge = new Ed<E>(e, from, to);
        if(Edges.contains(edge))
        {
            throw new IllegalArgumentException("Edge already exists");
        }
        Vert<V> f = (Vert<V>)from;
        f.addEdge(edge);
//        Vert<V> t = (Vert<V>)to;
//        t.addEdge(edge);
        Edges.add(edge);
        return edge;
    }

    /**
        Remove a vertex.
        @param v Vertex position to remove.
        @return Element from destroyed vertex position.
        @throws IllegalArgumentException If vertex position
            is invalid or if vertex still has incident edges.
     */
    public V remove(Vertex<V> v) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        Vert<V> Node = (Vert<V>)v;
        if(!(Node.VEdges.isEmpty()))
        {
            throw new IllegalArgumentException("Vertex still has edges");
        }
        Vertices.remove(Node);
        return Node.name;
    }

    /**
        Remove an edge.
        @param e Edge position to remove.
        @return Element from destroyed edge position.
        @throws IllegalArgumentException If edge position
            is invalid.
     */
    public E remove(Edge<E> e) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        Ed<E> edge = (Ed<E>)e;
        if(!(Edges.contains(edge)))
        {
            throw new IllegalArgumentException("Edge does not exist");
        }
        Edges.remove(edge);
        //remove from VEdges?
        return edge.get();
    }

    /**
        Vertices of graph.
        @return Iterable that can be used to explore the
          vertices of the graph; the remove() method of
          the iterator should not affect the graph.
     */
    public Iterable<Vertex<V>> vertices() {
        // TODO Auto-generated method stub
        return this.Vertices;
    }

    /**
        Edges of graph.
        @return Iterable that can be used to explore the
          edges of the graph; the remove() method of the
          iterator should not affect the graph.
     */
    public Iterable<Edge<E>> edges() {
        // TODO Auto-generated method stub
        return this.Edges;//Edges;
    }

    /**
        Outgoing edges of vertex.
        @param v Vertex position to explore.
        @return Iterable that can be used to explore the
          outgoing edges of the given vertex; the remove()
          method of the iterator should not affect the graph.
        @throws IllegalArgumentException If vertex position
            is invalid.
     */
    public Iterable<Edge<E>> outgoing(Vertex<V> v)
            throws IllegalArgumentException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
        Incoming edges of vertex.
        @param v Vertex position to explore.
        @return Iterable that can be used to explore the
          incoming edges of the given vertex; the remove()
          method of the iterator should not affect the graph.
        @throws IllegalArgumentException If vertex position
            is invalid.
     */
    public Iterable<Edge<E>> incoming(Vertex<V> v)
            throws IllegalArgumentException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
        Start vertex of edge.
        @param e Edge position to explore.
        @return Vertex position edge starts from.
        @throws IllegalArgumentException If edge position
            is invalid.
     */
    public Vertex<V> from(Edge<E> e) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        Ed<E> edge = (Ed<E>)e;
        if(!(Edges.contains(edge)))
        {
            throw new IllegalArgumentException("Edge does not exist");
        }
        return edge.source;
    }

    /**
        End vertex of edge.
        @param e Edge position to explore.
        @return Vertex position edge leads to.
        @throws IllegalArgumentException If edge position
            is invalid.
     */
    public Vertex<V> to(Edge<E> e) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        Ed<E> edge = (Ed<E>)e;
        if(!(Edges.contains(edge)))
        {
            throw new IllegalArgumentException("Edge does not exist");
        }
        return edge.sink;
    }

    /**
        Label vertex with object.
        @param v Vertex position to label.
        @param l Label object.
        @throws IllegalArgumentException If vertex position
            is invalid or label is null.
     */
    public void label(Vertex<V> v, Object l) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        Vert<V> vrtx = (Vert<V>)v;
        if(!(Vertices.contains(vrtx)) || (l == null))
        {
            throw new IllegalArgumentException("Vertex does not exist or null label");
        }
        vrtx.label = l;
    }

    /**
        Label edge with object.
        @param e Edge position to label.
        @param l Label object.
        @throws IllegalArgumentException If edge position
            is invalid or label is null.
     */
    public void label(Edge<E> e, Object l) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        Ed<E> edge = (Ed<E>)e;
        if(!(Edges.contains(edge)) || (l == null))
        {
            throw new IllegalArgumentException("Edge does not exist or null label");
        }
        edge.label = l;
    }

    /**
        Vertex label.
        @param v Vertex position to query.
        @return Label object (or null if none).
        @throws IllegalArgumentException If vertex position
            is invalid.
     */
    public Object label(Vertex<V> v) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        Vert<V> vrtx = (Vert<V>)v;
        if(!(Vertices.contains(vrtx)))
        {
            throw new IllegalArgumentException("Vertex does not exist");
        }
        return vrtx.label;
    }

    /**
        Edge label.
        @param e Edge position to query.
        @return Label object (or null if none).
        @throws IllegalArgumentException If edge position
            is invalid.
     */
    public Object label(Edge<E> e) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        Ed<E> edge = (Ed<E>)e;
        if(!(Edges.contains(edge)))
        {
            throw new IllegalArgumentException("Edge does not exist");
        }
        return edge.label;
    }

    /**
        Clear all labels.
     */
    public void clearLabels() {
        // TODO Auto-generated method stub
        for (int i = 0; i < Vertices.size(); i++) {
            Vert<V> vrtx = (Vert<V>) Vertices.get(i);
            vrtx.label = null;
        }
        for (int i = 0; i < Edges.size(); i++) {
            Ed<E> edge = (Ed<E>) Edges.get(i);
            edge.label = null;
        }
    }
    
    public String toString() {
        String s = "digraph {\n";
        for (int i = 0; i < Vertices.size(); i++) {
            Vert<V> vrtx = (Vert<V>) Vertices.get(i);
            s = s + vrtx.label + ";\n";
        }
        for (int i = 0; i < Edges.size(); i++) {
            Ed<E> edge = (Ed<E>) Edges.get(i);
            Vert<V> src = (Vert<V>) edge.source;
            Vert<V> snk = (Vert<V>) edge.sink;
            s = s + src.label + "->" + snk.label;
            s = s + "[label=" + edge.label + "];\n";
        }
        s = s + "}";
        return s;
    }

}

