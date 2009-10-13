package dlx;

import java.util.*;
/** Solver using Knuth's dancing links algorithm. it gives a solution 
 * to a tiling problem using the exact cover problem as main idea behind it. 
 * the rows of the network are the different pentominoes while columns are 
 * positions in the grid. solutions are based on a set of rows indicating 
 * which pentominoes and positions gives a full grid.
*/
 
public class DancingLinks<E>
{	/** Defines a node in the network
	 * each with links up/down and left/right using a doubly linked list structure
	 * in both directions plus a pointer to the column head
	 */
	private static class Node<E>
	{
		Node<E> left;
		Node<E> right;
		Node<E> up;
		Node<E> down;
		Header<E> head;
		
		Node(Node<E> l, Node<E> r, Node<E> u, Node<E> d, Header<E> h)
		{
			left = l;
			right = r;
			up = u;
			down = d;
			head = h;
		}
		
		Node()
		{
			this(null, null, null, null, null);
		}		
	}
	/** Header class records the name of the columns plus the number
	 * of rows that are inside this columns. Size is used to later
	 * determine the best column to use.
	*/
	private static class Header<E> extends Node<E>
	{
		E name;
		int size;
		
		Header(E n, int s)
		{
			name = n;
			size = s;
			head = this;
		}
		Header()
		{
			this(null,0);
		}
	}
	/**
	 * head of the table
	 */
	private Header<E> head;
	/**
	 * list of columns
	 */
	private List<Header<E>> cols;
	/**
	 * generic interface for the type expected from column names
	 */
	protected static interface E
	{
	
	}

	public DancingLinks()
	{
		head = new Header<E>(null,0);
		head.left = head;
		head.right = head;
		head.up = head;
		head.down = head;
		cols = new ArrayList<Header<E>>(200);
	}
	/**
	 * adds a column to the network
	 * @param name name of the column
	 * @param primary Is the column required for a solution?
	 */
	public void addCol(E name, boolean primary)
	{
		Header<E> top = new Header<E> (name, 0);
		top.up = top;
		top.down = top;
		
		if(primary)
		{
			Node<E> tail = head.left;
			tail.right = top;
			top.left = tail;
			top.right = head;
			head.left = top;
		}
		else
		{
			top.left = top;
			top.right = top;
		}
		cols.add(top);
	}
	/**
	 * adds a column to the network
	 * @param name name of the column
	 */
	public void addCol(E name)
	{
		addCol(name, true);		
	}
	/**
	 * gets the number of columns
	 * @return the number of columns
	 */
	public int getNumCol()
	{
		return cols.size();
	}
	/**
	 * gets the column name
	 * @param index the index of the column
	 * @return name of column
	 */
	public String getColNam(int index)
	{
		return cols.get(index).name.toString();
	}
	/**
	 * Adds a row to the network
	 * @param values the columns that are involved with this row
	 */
	public void addRow(boolean[] values)
	{
		Node<E> prev = null;
		for(int i =0;i < values.length; i++)
		{
			if(values[i])
			{
				Header<E> top = cols.get(i);
				top.size += 1;
				Node<E> bottom = top.up;
				Node<E> node = new Node<E>(null,null,bottom,top,top);
				bottom.down = node;
				top.up = node;
				if(prev != null)
				{
					Node<E> front = prev.right;
					node.left = prev;
					node.right = front;
					prev.right = node;
					front.left = node;				
				}
				else
				{
					node.left = node;
					node.right = node;
				}
			}
		}
	}
	/**
	 * finds the column with fewest choices
	 * @return column header from best column
	 */
	private Header<E> findBestCol()
	{
		int less = Integer.MAX_VALUE;
		Header<E> result = null;
		Header<E> current = (Header<E>) head.right;
		while(current != head)
		{
			if(current.size < less)
			{
				less = current.size;
				result = current;
			}
			current = (Header<E>)current.right;
		}
		return result;
	}
	/**
	 * hides a column from the network
	 * @param col column to hide
	 */
	private void coverCol(Header<E> col)
	{
		col.right.left = col.left;
		col.left.right = col.right;
		Node<E> row = col.down;
		while(row != col)
		{
			Node<E> node = row.right;
			while(node != row)
			{
				node.down.up = node.up;
				node.up.down = node.down;
				node.head.size -= 1;
				node = node.right;
			}
			row = row.down;
		}
	}
	/**
	 * uncovers a column from the network
	 * @param col column to uncover
	 */
	private void unCoverCol(Header<E> col)
	{
		Node<E> row = col.up;
		while(row != col)
		{
			Node<E> node = row.left;
			while(node != row)
			{
				node.head.size += 1;
				node.down.up = node;
				node.up.down = node;
				node = node.left;
			}
			row = row.up;
		}
		col.right.left = col;
		col.left.right = col;
	}
	/**
	 * gets the name of a row by getting the list of column names that it 
	 * is involved with.
	 * @param row the row to make a name for
	 * @return the list of column names
	 */
	private List<E> getRowNam (Node<E> row)
	{
		List<E> result = new ArrayList<E>();
		result.add(row.head.name);
		Node<E> node = row.right;
		while(node != row)
		{
			result.add(node.head.name);
			node = node.right;
		}
		return result;
	}
	/**
	 * Solver should implement this interface to receive the solutions to their 
	 * problems	 
	 */
	public interface SolutionAcceptor<E>
	{
		/**
		 * A callback to return solutions to the solver
		 * @param value a list of column names that are satisfied by the
		 * selected rows
		 */
		void solution(List<List<E>> value);
	}
	/**
	 * Finds the solution to the puzzel
	 * @param partial a list containing temporal solutions
	 * @param output the acceptor to found solutions
	 * @return number of solutions found
	 */
	private int search(List<Node<E>> partial, SolutionAcceptor<E> output)
	{
		int results =0;
		if(head.right == head)
		{
			List<List<E>> result = new ArrayList<List<E>> (partial.size());
			for(Node<E> row : partial)
			{
				result.add(getRowNam(row));
			}
			output.solution(result);
			results += 1;
		}
		else
		{
			Header<E> col = findBestCol();
			if(col.size>0)
			{
				coverCol(col);
				Node<E> row = col.down;
				while(row != col)
				{
					partial.add(row);
					Node<E> node = row.right;
					while(node != row)
					{
						coverCol(node.head);
						node = node.right;
					}
					results += search(partial, output);
					partial.remove(partial.size() - 1);
					node = row.left;
					while(node != row)
					{
						unCoverCol(node.head);
						node = node.left;
					}
					row = row.down;
				}
				unCoverCol(col);
			}
		}
		return results;
	}
	/**
	 * generates a list of prefixes down to a given depth
	 * @param depth the depth to explore
	 * @param choices an array of length depth to describe a prefix
	 * @param prefixes a working data structure
	 */
	private void searchPrefixes(int depth, int[] choices, List<int[]> prefixes)
	{
		if(depth == 0)
		{
			prefixes.add(choices.clone());
		}
			else
			{
				Header<E> col = findBestCol();
				if(col.size > 0)
				{
					coverCol(col);
					Node<E> row = col.down;
					int rowId = 0;
					while(row != col)
					{
						Node<E> node = row.right;
						while(node != row)
						{
							coverCol(node.head);
							node = node.right;
						}
						choices[choices.length - depth] = rowId;
						searchPrefixes(depth -1, choices, prefixes);
						node = row.left;
						while(node != row)
						{
							unCoverCol(node.head);
							node = node.left;
						}
						row = row.down;
						rowId +=1;
					}
					unCoverCol(col);
				}
			}		
	}
	/**
	 * Generate a list of row choices to cover the first moves
	 * @param depth the length of prefixes to generate
	 * @return a list of integer arrays that list the rows to pick in order
	 */
	public List<int[]> split(int depth)
	{
		int[] choices = new int[depth];
		List<int[]> result = new ArrayList<int[]>(100000);
		searchPrefixes(depth, choices, result);
		return result;
	}
	/**
	 * make one move from a prefix
	 * @param goalRow the row that should be chosen
	 * @return the row that was found
	 */
	private Node<E> advance(int goalRow)
	{
		Header<E> col = findBestCol();
		if(col.size > 0)
		{
			coverCol(col);
			Node<E> row = col.down;
			int id = 0;
			while(row != col)
			{
				if(id == goalRow)
				{
					Node<E> node = row.right;
					while(node != row)
					{
						coverCol(node.head);
						node = node.right;
					}
					return row;
				}
				id += 1;
				row = row.down;
			}
		}
		return null;
	}
	/**
	 * goes back in prefix exploration
	 * @param row
	 */
	private void rollBack(Node<E> row)
	{
		Node<E> node = row.left;
		while(node != row)
		{
			unCoverCol(node.head);
			node = node.left;
		}
		unCoverCol(row.head);		
	}
	/**
	 * given a prefix, finds the solution under it
	 * @param prefix a list of row choices to control where to explore
	 * @param output output of each solution
	 * @return number of solutions
	 */
	public int solve(int[] prefix, SolutionAcceptor<E> output)
	{
		List<Node<E>> choices = new ArrayList<Node<E>>();
		for(int i = 0; i < prefix.length; ++i)
		{
			choices.add(advance(prefix[i]));			
		}
		int result = search(choices, output);
		for(int i = prefix.length - 1; i >= 0; --i)
		{
			rollBack(choices.get(i));
		}
		return result;
	}
	/**
	 * Solves the problem
	 * @param output acceptor to receive answers
	 * @return number of solutions
	 */
	public int solve(SolutionAcceptor<E> output)
	{
		return search(new ArrayList<Node<E>>(), output);
	}
}