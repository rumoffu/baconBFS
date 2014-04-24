/**
 * Package info.
 */
package edu.jhu.cs.ugrad.kwong23;
import java.util.ArrayList;

/**
 * Stuff.
 * @author KT Wong
 *
 * @param <V>
 * @param <E>
 */
public class SparseGraph2<V, E> implements Graph<V, E> {

	ArrayList<Vertex<V>> Vertices;

	/**
	 * word.
	 * @return word.
	 */
	public final String toString() {
		String word = "";
		for (Vertex<V> v : Vertices) {
			word += v.toString();
		}
		return word;
	}

	/**
	 * nested.
	 * @author KT Wong
	 *
	 * @param <V>
	 */
	class Vert<V> implements Vertex<V> {

		/**
		 * array.
		 */
		private ArrayList<Ed<E>> Vedges;
		V name;
		
		Vert(V v){
			this.Vedges = new ArrayList<Ed<E>>();
			this.name = v;
		}
		
		@Override
		public V get() {
			// TODO Auto-generated method stub
			return this.name;
		}
		@Override
		public void put(V t) {
			// TODO Auto-generated method stub
			this.name = t;
		}
		
		boolean addEdge(Ed<E> edge){
			return this.Vedges.add(edge);
		}
		
		boolean removeEdge(Ed<E> edge){
			return this.Vedges.remove(edge);
		}
		
		public String toString(){
			String word = "";// = this.name.toString();
			for(Ed<E> e : this.Vedges){
				word += e.toString() + " ";
			}
//			return this.name.toString();
			return word;
		}

	}

	/**
	 * mad.
	 * @author KT Wong
	 *
	 * @param <E>
	 */
	class Ed<E> implements Edge<E> {
		/**
		 * wow.
		 */
		private Vert<V> source;
		/**
		 * w.
		 */
		private Vert<V> sink;
		/**
		 * var.
		 */
		private E name;

		/**
		 * stuff.
		 * @param e stuff.
		 * @param from o
		 * @param to a
		 */
		Ed(final E e, final Vert<V> from, final Vert<V> to) {
			this.name = e;
			this.source = from;
			this.sink = to;
		}

		@Override
		public E get() {
			// TODO Auto-generated method stub
			return this.name;
		}
		@Override
		public void put(final E t) {
			// TODO Auto-generated method stub
			this.name = t;
		}

		/**
		 * s.
		 * @return word.
		 */
		public String toString() {
			String word = source.get().toString();
			word += " " + this.name.toString()
					+ " " + sink.get().toString() + "\n";
			return word;
		}

	}
	/**
	 * constructor.
	 */
	public SparseGraph2(){
		this.Vertices = new ArrayList<Vertex<V>>();
	}

	@Override
	public final Vertex<V> insert(final V v) {
		// TODO Auto-generated method stub
		Vert<V> node = new Vert<V>(v);
//		System.out.println("adding " + v.toString());
		Vertices.add(node);
		return node;
	}

	@Override
	public final Edge<E> insert(final Vertex<V> from,
			final Vertex<V> to, final E e)
			throws IllegalArgumentException {

		// TODO Auto-generated method stub
		Ed<E> edge = new Ed<E>(e, (Vert<V>) from, (Vert<V>) to);
		Vert<V> node = (Vert<V>) from;
		node.addEdge(edge);
		return edge;
	}

	@Override
	public final V remove(final Vertex<V> v)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Vert<V> ver = (Vert<V>) v;

		if (!ver.Vedges.isEmpty()) {
			throw new IllegalArgumentException("still has edges");
		}
		if (this.Vertices.contains(v)) {
			V data = v.get();
			this.Vertices.remove(v);

			return data;
		} else {
			throw new IllegalArgumentException("vertex DNE");

			}
	}

	@Override
	public final E remove(final Edge<E> e) throws IllegalArgumentException {
		Ed<E> edge = (Ed<E>) e;
		boolean souWorked = false;
		boolean sinWorked = false;
		souWorked = edge.source.removeEdge(edge);
		sinWorked = edge.sink.removeEdge(edge);

		if (souWorked && sinWorked) {
			E data = e.get();
			return data;
		} else {
			throw new IllegalArgumentException("DNE edge");

		}
	}

	@Override
	public Iterable<Vertex<V>> vertices() {
		return this.Vertices;
	}

	@Override
	public Iterable<Edge<E>> edges() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Edge<E>> outgoing(Vertex<V> v)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Edge<E>> incoming(Vertex<V> v)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vertex<V> from(Edge<E> e) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vertex<V> to(Edge<E> e) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void label(Vertex<V> v, Object l) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void label(Edge<E> e, Object l) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object label(Vertex<V> v) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object label(Edge<E> e) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearLabels() {
		// TODO Auto-generated method stub
		
	}
	

}
