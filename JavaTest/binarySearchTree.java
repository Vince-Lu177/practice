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

    //删除成功返回true，删除失败返回false
    //key在树中存在，删除成功
    //key在树中不存在，删除失败
    public boolean remove(int key) {
        //先找到待删除节点的位置，再进行具体的删除
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if (key < cur.key) {
                parent = cur;
                cur = cur.left;
            } else if (key > cur.key) {
                parent = cur;
                cur = cur.right;
            } else {
                //要删除的元素就是cur指向的节点
                removeNode(parent, cur);
            }
        }
        //循环结束，要删除的元素不存在
        return false;
    }

    private void removeNode(Node parent, Node cur) {
        if(cur.left == null){
            //1.要删除的元素没有左子树
            if(cur == root){
                //1.1要删除的元素是根节点
                root = cur.right;
            }else if(cur == parent.left){
                //1.2要删除的元素是父节点的左子树
                parent.left = cur.right;
            }else{
                //1.3要删除的元素是父节点的右子树
                parent.right = cur.right;
            }
        }else if(cur.right == null){
            //2.要删除的元素没有右子树
            if(cur == root){
                //2.1要删除的元素是根节点
                root = cur.left;
            }else if(cur == parent.left){
                //2.2要删除的元素是父节点的左子树
                parent.left = cur.left;
            }else{
                //2.3要删除的元素是父节点的右子树
                parent.right = cur.left;
            }
        }else{
            //3.要删除的元素有两个子树--无法直接删除，需要换个思路进行删除
            //找到左子树的最大值(或者右子树的最小值）--替罪羊，把要删除元素用替罪羊替换，最后删除替罪羊
            //要先找到右子树最小元素(替罪羊)
            Node scapeGoat = cur.right;//替罪羊节点
            Node goatParent = cur;//替罪羊节点的父节点
            while(cur != null){
                goatParent = scapeGoat;
                scapeGoat = cur.left;
            }
            //循环结束，scapeGoat就指向了替罪羊节点
            //把替罪羊节点赋给待删除节点
            cur.key = scapeGoat.key;
            //删除替罪羊节点(替罪羊节点一定没有左子树)
            //此处还需要判断替罪羊节点是父节点的左子树还是右子树
            if(scapeGoat == goatParent.left){
                goatParent.left = scapeGoat.right;
            }else{
                goatParent.right = scapeGoat.right;
            }
        }
    }
}
