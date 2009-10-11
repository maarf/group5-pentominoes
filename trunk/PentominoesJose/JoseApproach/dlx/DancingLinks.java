package dlx;

import java.util.*;
 
public class DancingLinks<E>
{
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
	private Header<E> head;
	private List<Header<E>> cols;
	
	protected static interface E
	{
		//public E element();
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
	
	public void addCol(E name)
	{
		addCol(name, true);		
	}
	
	public int getNumCol()
	{
		return cols.size();
	}
	
	public String getColNam(int index)
	{
		return cols.get(index).name.toString();
	}
	
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
	
	public interface SolutionAcceptor<E>
	{
		void solution(List<List<E>> value);
	}
	
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
	
	public List<int[]> split(int depth)
	{
		int[] choices = new int[depth];
		List<int[]> result = new ArrayList<int[]>(100000);
		searchPrefixes(depth, choices, result);
		return result;
	}
	
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
	
	public int solve(SolutionAcceptor<E> output)
	{
		return search(new ArrayList<Node<E>>(), output);
	}
}