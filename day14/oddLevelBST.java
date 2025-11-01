public class oddLevelBST {
    
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
class Result {
  static void printOdd(Node root) {
    // Write your code here
    if(root == null) return;
    Queue<Node> p = new LinkedList<>();
    p.add(root);   
      int level = 1;
      while(!p.isEmpty()){
          int size=p.size();
          for(int i = 0;i<size;i++){
                Node curr = p.poll();
              if(level %2 != 0){
                  System.out.print(curr.data+" ");
              }
              if(curr.left!=null)p.add(curr.left);
              if(curr.right!=null)p.add(curr.right);
          }
          level++;
      }
  }
}
