


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Tree<E> {
    private E head;
    ArrayList<Tree<E>> node = new ArrayList<Tree<E>>();
    private Tree<E> parent = null;
    private HashMap<E, Tree<E>> locate = new HashMap<E,Tree<E>>();
    
    public Tree (E head) {
        this.head = head;
        locate.put(head, this);
    }
    
    public void addNode(E root, E node) {
        if (locate.containsKey(root)) {
            locate.get(root).addNode(node);
        }
        else {
            addNode(root).addNode(node);
        }
    }
    
    public Tree<E> addNode(E node) {
        Tree<E> t = new Tree<E>(node);
        t.node.add(t);
        t.parent = this;
        t.locate = this.locate;
        locate.put(node, t);
        return t;
    }
    
    public void add (E gen, E e) {
        addNode(gen, e);
    }
    
    public Tree<E> setAsParent(E parentRoot) {
        Tree<E> t = new Tree(parentRoot);
        t.node.add(this);
        this.parent = t;
        t.locate = this.locate;
        t.locate.put(head, this);
        t.locate.put(parentRoot, t);
        return t;
    }
    
    public E getHead() {
        return head;
    }
    
    public Tree<E> getTree(E element) {
        return locate.get(element);
    }
    
    public Tree<E> getParent() {
        return parent;
    }
    
    public Collection<E> getSuccessors(E root) {
    Collection<E> successors = new ArrayList<E>();
    Tree<E> tree = getTree(root);
    if (null != tree) {
      for (Tree<E> node : tree.node) {
        successors.add(node.head);
      }
    }
    return successors;
  }

  public Collection<Tree<E>> getSubTrees() {
    return node;
  }

  public static <E> Collection<E> getSuccessors(E of, Collection<Tree<E>> in) {
    for (Tree<E> tree : in) {
      if (tree.locate.containsKey(of)) {
        return tree.getSuccessors(of);
      }
    }
    return new ArrayList<E>();
  }
  
  public String toString() {
    return printTree(0);
  }

  private static final int indent = 2;

  private String printTree(int increment) {
    String s = "";
    String inc = "";
    for (int i = 0; i < increment; ++i) {
      inc = inc + " ";
    }
    s = inc + head;
    for (Tree<E> child : node) {
      s += "\n" + child.printTree(increment + indent);
    }
    return s;
  }
  
}
