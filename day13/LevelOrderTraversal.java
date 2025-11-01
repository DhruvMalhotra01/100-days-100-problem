import java.util.*;
class Node
{
  int data; // data used as key value
  Node left;
  Node right;
  public Node()
  {
    data=0;
  }
  public Node(int d)
  {
    data=d;
  }
}

class LevelOrderTraversal
{
  static void inOrder(Node root)
  {
    if (root != null)
    {
      inOrder(root.left);
      System.out.print(root.data + " ");
      inOrder(root.right);
    }
  }
  
  static Node buildTree(int arr[], int n)
  {
    if (n <= 0 || arr[0] == -1) return null;
    Node root = new Node(arr[0]);
    Queue<Node> q = new LinkedList<Node>();
    q.add(root);
    
    int i = 1;
    while (i < n && q.size() > 0)
    {
      Node parent = q.peek();
      q.remove();

      // If left child exists
      if (arr[i] != -1)
      {
        parent.left = new Node(arr[i]);
        q.add(parent.left);
      }
      i++;

      // If right child exists
      if (i < n && arr[i] != -1)
      {
        parent.right = new Node(arr[i]);
        q.add(parent.right);
      }
      i++;
    }
    return root;
  }
  /* 
 *  class Node {
 *    int data;
 *    Node left; 
 *    Node right;
 *    public Node() {
 *      data = 0;
 *    }
 *    public Node(int d)  {
 *      data = d;
 *    }
 *  }
 *
 *  The above class defines a tree node.
 */
static void printLevelWise(Node root) {
    if(root==null)return;
    Queue<Node>q=new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()){
        int size=q.size();
        for(int i=0;i<size;i++){ 
            Node curr=q.poll();
            if(i!=size-1){
                System.out.print(curr.data+" ");
            }
            else{
                System.out.print(curr.data);
            }
            if(curr.left!=null)q.add(curr.left);
            if(curr.right!=null)q.add(curr.right);
        }
        System.out.println("");
    }
  // Write your code here
}

public static void main(String[] args)
  {
    int n, i;
    Scanner s=new Scanner(System.in);
    n = Integer.parseInt(s.nextLine().trim());
    int a[]=new int[n];
    for(i=0;i<n;i++)
      a[i] = s.nextInt();
    Node root = null;
    if(n!=0)
      root = buildTree(a, n);
    printLevelWise(root);
  }
}
