package review.tree;

public class PracticeTree {

    Node head = null;

    public class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            left = null;
            right = null;
            this.data = data;
        }
    }


        public boolean insert(int data) {
            //1.노드가 없는경우
            if (this.head == null) {
                this.head = new Node(data);
            } else {


                //2.노드가 하나이상일경우
                Node findNode = this.head;

                while (true) {
                    //2-1 왼쪽으로 들어가야할경우
                    if (data < findNode.data) {
                        if (findNode.left != null) {
                            findNode = findNode.left;
                        } else {
                            findNode = new Node(data);
                            break;
                        }
                        //2-2오른쪽으로 들어가야하는 경우
                    } else {
                        if (findNode.right != null) {
                            findNode = findNode.right;
                        } else {
                            findNode = new Node(data);
                            break;
                        }
                    }
                }
            }
            return true;
        }

    public Node search(int data) {
        //데이터가 없을떄
        if (this.head == null) {
            return null;
        } else {
            //데이터가 하나이상일때

            // 왼쪽으로 가야할떄
            Node findNode = this.head;
            while (findNode != null) {
                if (findNode.data == data) {
                    return findNode;
                } else if (findNode.data > data) {
                    findNode = findNode.left;
                } else {
                    // 오른쪽으로 가야할떄
                    findNode = findNode.right;
                }
            }

            return null;
        }
    }

    public boolean delete(int data) {

        boolean searched = false;

        Node currParentNode = this.head;
        Node currNode = this.head;

        if (this.head == null) {
            // 삭제할 노드가 자식이 없는 경우
            return false;
        } else {
            // 삭제할 노드가 헤드인경우
            if (this.head.left == null && this.head.right == null && this.head.data == data) {
                searched = true;
                this.head = null;
            }

            while (currNode != null) {
                if (currNode.data == data) {
                    searched = true;
                    break;
                } else if (currNode.data > data) {
                    currParentNode = currNode;
                    currNode = currNode.left;
                } else {
                    currParentNode = currNode;
                    currNode = currNode.right;
                }
            }

            if (searched == false) {
                return false;
            }

            // 삭제할노드(currNode)가 리프 노드일경우
            if (currNode.left == null && currNode.right == null) {
                if (data < currParentNode.data) {
                    currParentNode.left = null;
                    currNode = null;
                } else {
                    currParentNode.right = null;
                    currNode = null;
                }
                return true;

                // 삭제할 노드가 자식이 하나인경우 -> 1. 왼쪽에 있는경우 2. 오른쪽에 있는경우
            } else if (currNode.left != null && currNode.right == null) {
                //자식이 왼쪽에 있는경우

                if (data < currParentNode.data) {
                    //삭제할 노드가 부모노드의 왼쪽에 있는경우
                    currParentNode.left = currNode.left;
                    currNode = null;
                } else {
                    // 삭제할 노드가 부모노드의 오른쪽에 있는 경우
                    currParentNode.right = currNode.left;
                    currNode = null;
                }

            } else if (currNode.left == null && currNode.right != null) {
                //자식이 오른쪽에 있는경우

                if (data < currParentNode.data) {
                    currParentNode.left = currNode.right;
                    currNode = null;
                } else {
                    currParentNode.right = currNode.right;
                    currNode = null;
                }
            } else {

                // 삭제할 노드가 자식이 둘다있는 경우  -> 이때는 해결방법을 기억해두자 삭제할 노드의 오른쪽 자식중에서 가장 작은 값을 가지는 노드를
                // 삭제한 노드의 자리에 두고 이때 경우의 수가 또 있는데 ㅋ... -> 가장작은 값을 가지는 자식이 오른쪽에 자식이 있는 경우와 없는경우 ㅋㅋ. ㅅㅂ...

                if (data < currParentNode.data) {
                    //삭제할 currNode가 currParentNode의 왼쪽에 있는 경우

                    Node changeNode = currNode.right;
                    Node changeParentNode = currNode.right;

                    while (changeNode.left != null) {
                        changeParentNode = changeNode;
                        changeNode = changeNode.left;
                    }

                    //여기까지오면 changedNode에는 오른쪽 자식중 가장작은 값을 가진 노드가 들어가있다.
                    //여기서 또 경우의 수가 있는데 chagedNode의 오른쪽 자식이 있는 경우와 없는 경우가 있을 수 있다.
                    if (changeNode.right == null) {
                        changeParentNode.left = null;
                    } else {
                        changeParentNode.left = changeNode.right;
                    }

                    currParentNode.left = changeNode;

                    changeNode.left = currNode.left;
                    changeNode.right = currNode.right;

                    currNode = null;

                } else {
                    //삭제할 currNode가 currParentNode의 오른쪽에 있는 경우


                }
            }


        }



    }




}
