public class AVLinsertion{
    public static class Node{

        Node right;
        Node left;
        int data;
        int height;
        Node(Integer data){
            this.data = data;
        }

    }
    public static Integer DiffHeight(Node LeftRoot, Node RightRoot){
        Integer difference = (LeftRoot == null ? 0 : LeftRoot.height) - (RightRoot == null ? 0 : RightRoot.height);
        return difference;

    }

    public static void setHeight(Node root){

        if(root == null) return;

        root.height = 1 + Math.max(root.left == null ? 0 : root.left.height, root.right == null ? 0 : root.right.height);

    }

    public static Node Insert(Node root, Integer data){

        if(root == null) return new Node(data);

        if(root.data < data){
            root.right = Insert(root.right, data);
        }
        else{
            root.left = Insert(root.left, data);
        }

        Integer balance = DiffHeight(root.left, root.right);

        if(balance > 1){ // LeftHeavy Case
            if(GetHeight(root.left.left) >= GetHeight(root.left.right)){ //L-L case
                root = RightRotation(root);

            }
            else{
                root.left =  LeftRotation(root.left);
                root = RightRotation(root);

            }

        }
        else if(balance < -1){ //RightHeavy Case
            if(GetHeight(root.right.right) >= GetHeight(root.right.left)){
                root = LeftRotation(root);
            }
            else{
                root.right = RightRotation(root.right);
                root = LeftRotation(root);
            }

        }

        setHeight(root);

        return root;

    }

    private static Node RightRotation(Node root) {
        Node temp = root.left;
        root.left = temp.right;

        temp.right = root;
        setHeight(root);
        setHeight(temp);

        return temp;

    }

    private static Node LeftRotation(Node root) {
        Node temp = root.right;
        root.right = temp.left;

        temp.left = root;

        setHeight(root);
        setHeight(temp);
        return temp;

    }

    private static int GetHeight(Node root) {
        if(root == null) return 0;
        return root.height;
    }

    public static void Inorder(Node root){
        if(root == null) return;

        Inorder(root.left);

        System.out.print(root.data + " ");

        Inorder(root.right);

    }


    public static void main(String[] main){

        Node root = Insert(null, 25);


        root = Insert(root, 35);
        root = Insert(root, 75);
        root = Insert(root, 95);
        root = Insert(root, 12);
        root = Insert(root, 126);
        root = Insert(root, 87);
        root = Insert(root, 909);
        root = Insert(root, 56);
        root = Insert(root, 78);

        Inorder(root);



    }



}
