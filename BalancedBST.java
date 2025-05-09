public class BalancedBST extends BST {

    

    private int height(BSTNode node){
        if(node==null){
            return 0;
        }
        return node.height;
    }

    private int checkbalance(BSTNode node){
        if(node ==null){
            return 0;
        }
        return height(node.left)-height(node.right);
    }

    private BSTNode Left_rotation (BSTNode Node){
        BSTNode t=Node.right;
        BSTNode t2=t.left;

        t.left=Node;
        Node.right=t2;

        Node.height=Math.max(height(Node.left), height(Node.right))+1;
        t.height=Math.max(height(t.left), height(t.right))+1;
        return t;
    }

    private BSTNode right_rotation (BSTNode Node){
        BSTNode t=Node.left;
        BSTNode t2=t.right;

        t.right=Node;
        Node.left=t2;

        Node.height=Math.max(height(Node.left), height(Node.right))+1;
        t.height=Math.max(height(t.left), height(t.right))+1;

        

        return t;
    }




    private BSTNode helper_insert(BSTNode node, int key){
        if(node==null){
            node= new BSTNode(key);
        }

        if(key>node.value){
            node.right=helper_insert(node.right, key);
        }
        else if(key<node.value){
            node.left=helper_insert(node.left, key);
        }
        else {
            return node;
        }
        int balance=0;
        updateHeight(node);
        balance=checkbalance(node);

        return tobalance(node, balance, key);


        // if(balance>1 && node.left.value>key){
        //     return right_rotation(node);
        // }
        // if(balance<(-1) && node.right.value<key){
        //     return Left_rotation(node);
        // }
        // if(balance>1 && node.right.value<key){
        //     node.left=Left_rotation(node.left);
        //     return right_rotation(node.right);
        // }
        // if(balance<(-1) && node.right.value>key){
        //     node.right= right_rotation(node.right);
        //     return Left_rotation(node);
        // }
        // return node;
    }
    private BSTNode tobalance( BSTNode node, int balance,int key){
        if(balance>1 && node.left.value>key){
            return right_rotation(node);
        }
        if(balance<(-1) && node.right.value<key){
            return Left_rotation(node);
        }
        if(balance>1 && node.right.value<key){
            node.left=Left_rotation(node.left);
            return right_rotation(node.right);
        }
        if(balance<(-1) && node.right.value>key){
            node.right= right_rotation(node.right);
            return Left_rotation(node);}

        return node;
    }

    private BSTNode helperDelete(BSTNode node, int key){
        Boolean a=false;//
        if (node==null) {
            return node;
        }
        if(key>node.value){
            node.right= helperDelete(node.right, key);
            updateHeight(node);

        }
        else if(key<node.value){
            node.left= helperDelete(node.left, key);
            updateHeight(node);

        }
        else{
            int i=0;///////////////////////////////////////////////////////////////
            // if(node.left==null && node.right==null){
            //     return 
            // }\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
             if(node.left==null && node.right==null){
                return null;}
            else if(node.right==null){

                return node.left;
            }
            else if(node.left==null){

                return node.right;
            }
            else{
                node.value=left_max(node);
                node.left=helperDelete(node.left,node.value);
                updateHeight(node);
                
    
            }
            int balance=0 ;
            updateHeight(node);
            balance=checkbalance(node);

            return tobalance(node, balance, key);


            // if(balance>1 && node.left.value>key){
            //     return right_rotation(node);
            // }
            // if(balance<(-1) && node.right.value<key){ 
            //     return Left_rotation(node);
            // }
            // if(balance>1 && node.right.value<key){
            //     node.left=Left_rotation(node.left);
            //     return right_rotation(node.right);
            // }
            // if(balance<(-1) && node.right.value>key){
            //     node.right= right_rotation(node.right);
            //     return Left_rotation(node);
            // }
            // return node;


        }
        // updateHeight(node);
        BSTNode temp=node;//
       
        return node;
    }

    

    public void insert(int key){
        // TO be completed by students
        System.out.println("insert " +key);
        if(root==null){
            root=new BSTNode(key);
        }
        else{
            root=helper_insert(root,key);}
    }

    public boolean delete(int key){
        // TO be completed by students
        System.out.println("delete " +key);
        boolean a=false;
        if (root==null){
            return false;
        }
        if(helperDelete(root, key)!=null){
            a=true;
            
        }
        return a;
    }
    public static void main(String[] args) {
        BalancedBST tree =new BalancedBST();
         tree.insert(9);
         tree.insert( 5);
         tree.insert(10);
         tree.insert( 0);
         tree.insert(6);
         tree.insert( 11);
         tree.insert(-1);
         tree.insert( 1);
         tree.insert( 2);

         System.out.println(tree.preorder());
         System.out.println(tree.postorder());

         tree.delete(10);
         System.out.println(tree.preorder());


    }

}
