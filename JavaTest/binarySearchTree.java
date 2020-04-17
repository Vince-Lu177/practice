package practice.practice.JavaTest;

public class binarySearchTree {
    public class Node{
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }

    //根节点为null
    private Node root = null;
    //查找元素
    public Node find(int key){
        //查找key是否在树中存在，如果存在就返回对应Node
        Node cur = root;
        while(cur != null){
            if(key < cur.key){
                //去左子树中找
                cur = cur.left;
            }else if(key > cur.key){
                //去右子树中找
                cur = cur.right;
            }else{
                //相等就是找到了
                return cur;
            }
        }
        //循环结束也没找到
        return null;
    }

    //插入元素
    //二叉搜索树不允许存在相同元素
    //如果发现新插入的key重复，就会插入失败
    //插入成功就返回true
    public boolean insert(int key){
        if(root == null){
            //当前如果为空树，直接让root指向key对应的新节点即可
            root = new Node(key);
            return true;
        }
        Node cur = root;
        Node parent = null;
        //始终指向cur的父节点，和链表插入类似，插入过程需要记录前一个节点
        while(cur != null){
            if(key < cur.key){
                parent = cur;
                cur = cur.left;
            }else if(key > cur.key){
                parent = cur;
                cur = cur.right;
            }else{
                //如果当前树存在的是key，发现相同key就插入失败了
                //如果当前树存的是键值对，发现相同key修改值即可
                return false;
            }
        }
        //循环结束，cur就指向null了，当前元素就就要插入parent的子树位置
        //具体是左子树还是右子树，需要key和parent再进行比较
        if(key < parent.key){
            //插入到parent的左侧
            parent.left = new Node(key);
        }else{
            parent.right = new Node(key);
        }
        return true;
    }
}
