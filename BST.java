import java.util.*;
public class BST {

    public BSTNode root;
    private int size=0;

    public BST() {
        root = null;
    }
   
    
    
    public void updateHeight(BSTNode node) {
        if (node == null) {
            return;
        }
        if(node.left==null && node.right==null){
            node.height=1;
        }
        updateHeight(node.left);
        updateHeight(node.right);
        int leftHeight = (node.left == null) ? 0 : node.left.height;
        int rightHeight = (node.right == null) ? 0 : node.right.height;
        

        node.height = Math.max(leftHeight, rightHeight) + 1;

    }
    


    public void insert(int num) {
        System.out.println("insrt "+ num);
        // TO be completed by students
        BSTNode newNode =new BSTNode(num);
        BSTNode temp =root;
        size++;
        if (root==null){
            root=newNode;
            // root.height+=1;
        }
        else{
            while(true){
                if(num>temp.value ){
                    if(temp.right==null){
                        temp.right=newNode;
                        // updateHeight(root);
                        break;
                    }
                    else{
                        // temp.height+=1;
                        temp=temp.right;
                    }
                }
                if(num<temp.value ){
                    if(temp.left==null){
                        temp.left=newNode;
                        // updateHeight(root);
                        break;
                        }
                    else{
                        // temp.height+=1;
                        temp=temp.left;
                    }
                }
            }
    }

    }
   
    private BSTNode h_delete(BSTNode root, int num){
        Boolean a=false;//
        if (root==null) {
            return root;
        }
        if(num>root.value){
            root.right= h_delete(root.right, num);
            // updateHeight(root);

        }
        else if(num<root.value){
            root.left= h_delete(root.left, num);
            // updateHeight(root);

        }
        else{
            int i=0;//
            if(root.right==null){

                return root.left;
            }
            else if(root.left==null){
                return root.right;
            }
            else{
                root.value=left_max(root);
                root.left=h_delete(root.left,root.value);

    
            }
            // updateHeight(root);
        }
        // updateHeight(root);
        BSTNode temp=root;//
       
        return root;
    }
   
    public boolean delete(int num) {
        System.out.println("delete : "+num);
        boolean a=false;
        
        if(search(num)==true){
            root=h_delete(root, num);
            a=true;
            // size--;
            return true;
        }
        else{
            return false;
        }
    }

    private boolean search_button(int num, BSTNode node){
        if(node==null){
            return false;
        }
       
        else if(node.value==num){
            return true;
        }
        else{
            if (num>node.value) {
                return search_button(num, node.right);
            } else {
                return search_button(num, node.left);
            }
        }
        
    }

    public int left_max( BSTNode root){
        BSTNode t=root.left;
        // BSTNode t2=t;
        int val=t.value;
        while(t.right!=null){
            // t2=t;
            t=t.right;
            val=t.value;
        }
     
        return val; 
    }

    private int right_min( BSTNode root){ 
        BSTNode t=root.right;
        // BSTNode t2=t;
        while(t.left!=null){
            // t2=t;
            t=t.left;
        }
        //extra thing
        // t2.left=t.right;
        int val=t.value;
        // t=t.right;
        return val;
    }

    //retun node of search num
    private BSTNode search_node(int num, BSTNode root){
        if(root==null ){
            return root;
        }
        else if(root.value==num){
            return root;
        }
        else{
            if (num>root.value ) {
                return search_node(num, root.right);
            } 
            else  {
                return search_node(num, root.left);
            }
        }
    }


    public boolean search(int num) {
        System.out.println("search : " + num);
        // TO be completed by students
        if(root==null){
            return false;
        }
        return search_button( num, root);
    }

    public ArrayList<Integer> inorder() {
        // TO be completed by students
		ArrayList<Integer> al = new ArrayList<>();
        al=h_inorder(root);
		return al;
    }
   
    private ArrayList<Integer> h_inorder(BSTNode root){
		ArrayList<Integer> al = new ArrayList<>();
        if(root!=null){
        al.addAll(h_inorder(root.left));
        al.add(root.value);
        al.addAll(h_inorder(root.right));
        }
		return al;

    }
   

    
    public ArrayList<Integer> preorder() {
        // TO be completed by students
		ArrayList<Integer> al = new ArrayList<>();
        al=h_preorder(root);
		return al;
    }
    
    private ArrayList<Integer> h_preorder(BSTNode root){
        
		ArrayList<Integer> al = new ArrayList<>();
        if(root!=null){
        
        al.add(root.value);
        al.addAll(h_preorder(root.left));
        al.addAll(h_preorder(root.right));}
		return al;

    }

    public ArrayList<Integer> postorder() {
        // TO be completed by students
        // System.out.print("postorder ");

		ArrayList<Integer> al = new ArrayList<>();

        
        al=h_postorder(root);
		return al;
    }

    private ArrayList<Integer> h_postorder(BSTNode root){
		ArrayList<Integer> al = new ArrayList<>();
        if(root!=null){
        al.addAll(h_postorder(root.left));
        al.addAll(h_postorder(root.right));
        al.add(root.value);
        }
		return al;
    }
    public static void main(String[] args) {

        BST a= new BST();



//         a.insert(16);
//         a.insert(8);
//         a.insert(21);
// a.insert(18);
// a.insert(17);

// System.out.println(a.search_node(16,a.root).height);
// System.out.println(a.search_node(8,a.root).height);
// System.out.println(a.search_node(21,a.root).height);
// System.out.println(a.search_node(18,a.root).height);
// System.out.println(a.search_node(17,a.root).height);




        // a.insertc(3);
        // a.insertc(5);
        // a.insertc(6);
        // a.insertc(8);
        // a.insertc(1);
        // a.insertc(4);
        // a.insertc(7);
        // a.insertc(2);
        // a.deletec(6);

        // a.root.left.right=null;
        // BSTNode temp=a.root.left.right;
        // temp=null;
        // System.out.println("6 : " +a.left_max( a.search_node(5,a.root)));
        // System.out.println("6 : " +a.search_node(6,a.root).right.value);
        // System.out.println("6 : " +a.search_node(6,a.root).left.value);


        // System.out.println("lm: "+ a.root.right.right.value);
        // BSTNode b= a.search_node(8, a.root);
        // a.delete(6);
        // System.out.println(" search value : " +a.search_node(2,a.root).value );

        // a.inor();
        // System.out.println(a.root.right.right.value);




        
        System.out.print("inorder : " + a.inorder()+"\n");
        System.out.print("preorder : " + a.preorder()+"\n");
        System.out.print("postorder : " + a.postorder()+"\n");

        // System.out.println("height 3 : " + a.search_node(3, a.root).height);
        // System.out.println("height  5: " + a.search_node(5, a.root).height);
        // System.out.println("height  6: " + a.search_node(6, a.root).height);


        // a.delete(6);
        // System.out.println("height  7: " + a.search_node(7, a.root).height);
        // System.out.println("height  8: " + a.search_node(8, a.root).height);

        // System.out.print("postorder : " + a.postorder()+"\n");
        // System.out.println(a.root.right.right.left.value);






    }
}