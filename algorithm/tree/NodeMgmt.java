package algorithm.tree;

public class NodeMgmt {
    Node head = null;

    public class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public boolean insertNode(int data) {
        //Case1: Node가 하나도 없을떄
        if (this.head == null) {
            this.head = new Node(data);
        } else {
            //Case2 Node가 하나이상 들어가 있을떄
            Node findNode = this.head;
            while (true) {
                //Case2-1 : 현재 Node의 왼쪽으로 들어가야 할떄
                if (data < findNode.value) {
                    if (findNode.left != null) {
                        findNode = findNode.left;
                    } else {
                        findNode = new Node(data);
                        break;
                    }
                }
                //Case2-2 : 현재 Node의 오른쪽으로 들어가야 할떄
                if (findNode.value < data) {
                    if (findNode.right != null) {
                        findNode = findNode.right;
                    } else {
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
        }
        return true;

    }

    public Node search(int data) {
        //Case1: Node가 하나도 없을떄

        if (this.head == null) {
            return null;
        } else {
            //Case2: Node가 하나 이상 있을떄

            Node findNode = this.head;
            while (findNode != null) {
                if (findNode.value == data) {
                    return findNode;
                } else if (data < findNode.value) {
                    findNode = findNode.left;
                } else {
                    findNode = findNode.right;
                }
            }
            return null;
        }
    }

    public boolean delete(int value) {
        boolean searched  = false;

        Node curParentNode = this.head;
        Node currNode = this.head;

        //코너1: Node가 하나도 없을떄
        if (this.head == null) {
            return false;
        } else {
            //코너2: Node가 하나이고 그 Node가 우리가 찾은 데이터일떄
            if (this.head.value == value && this.head.left == null && this.head.right == null) {
                this.head = null;
                return true;
            }
        }
        while (currNode != null) {
            if (currNode.value == value) {
                searched = true;
                break;
            } else if (value < currNode.value) {
                curParentNode = currNode;
                currNode = currNode.left;
            } else {
                curParentNode = currNode;
                currNode = currNode.right;
            }
        }
        if (searched == false) {
            return false;
        }

        //여기까지 실행되면
        //currNode 에는 해당 데이터를 가지고 있는 Node
        //curParentNode 에는 해당 데이터를 가지고 있는 Node 의 부모 Node

        //Case1 삭제할 Node가 Leaf Node인 경우
        if (currNode.left == null && currNode.right == null) {
            if (value < curParentNode.value) {
                curParentNode.left = null;
                currNode = null;
            } else {
                curParentNode.right = null;
                currNode = null;
            }
            return true;
        } else if (currNode.left !=  null && currNode.right == null) {
            //Case2-1: 삭제할 Node가 Childe Node를 왼쪽에 한개 가지는 경우
            if (value < curParentNode.value) {
                curParentNode.left = currNode.left;
                currNode = null;
            } else {
                curParentNode.right = currNode.left;
                currNode = null;
            }
            return true;
        } else if (currNode.left == null && currNode.right != null) {
            //Case2-1: 삭제할 Node가 Childe Node를 왼쪽에 한개 가지는 경우
            if (value < curParentNode.value) {
                curParentNode.left == currNode.right;
                currNode = null;
                return true;
            } else {
                curParentNode.right = currNode.right;
                currNode = null;
            }
            return true;

        }
    }

    public static void main(String[] args) {

        NodeMgmt myTree = new NodeMgmt();
        myTree.insertNode(2);
        myTree.insertNode(3);
        myTree.insertNode(4);
        myTree.insertNode(6);

        Node testNode = myTree.search(3);
        System.out.println(testNode.value);
        System.out.println(testNode.right.value);
    }
}
