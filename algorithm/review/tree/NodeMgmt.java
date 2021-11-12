package review.tree;

public class NodeMgmt {

    Node head = null;
    public class Node {
        Node left;
        Node right;
        int value;

        public Node(int data) {
            this.value = data;
            this.left = null;
            this.right = null;
        }
    }

    public boolean insert(int data) {
        if (this.head == null) {
            this.head = new Node(data);
        } else {
            // 노드가 하나라도 있을떄
            Node findNode = this.head;
            while (true) {
                //왼쪽으로 가야할떄
                if (data < findNode.value) {
                    if (findNode != null) {
                        findNode = findNode.left;
                    } else {
                        findNode = new Node(data);
                        break;
                    }
                } else {
                    // 오른쪽으로 가야할때
                    if (findNode != null) {
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
        // 노드가 하나도 없을떄
        if (this.head == null) {
            return null;
        } else {
            //노드가 하나이상일떼
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
        boolean searched = false;

        Node currParentNode = this.head;
        Node currNode = this.head;

        //노드가 하나도 없을떄
        if (this.head == null) {
            return false;
        } else {
            //노드가 하나만 있고 해당 노드가 삭제할 노드일경우
            if (this.head.value == value && this.head.left == null && this.head.right == null) {
                this.head = null;
                return true;
            }

            while (currNode != null) {
                if (currNode.value == value) {
                    searched = true;
                    break;
                } else if (value < currNode.value) {
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

            //여기까지 실행되면
            //currNode에는 삭제할데이터를 가지고 있는 노드
            //currParentNode는 삭제할 데이터를 가지고 있는노드의 (currNode)의 부모 노드

            //삭제할노드(currNode)가 리프노드일경우
            if (currNode.left == null && currNode.right == null) {
                if (value < currNode.value) {
                    currParentNode.left = null;
                    currNode = null;
                } else {
                    currParentNode.right = null;
                    currNode = null;
                }
                return true;
            }

            // 삭제할노드의 자식이 하나일경우
            // parent 의 왼쪽에 있고 currNode의 자식이 왼쪽 혹은 오른쪽 2개
            // parent 의 오른쪽에 있고 currNode의 자식이 왼쪽 혹은 오른쪽 2개

            else if (currNode.left != null && currNode.right == null) {
                // 자식이 왼쪽에 있는경우
                if (value < currParentNode.value) {
                    currParentNode.left = currNode.left;
                    currNode = null;
                } else {
                    currParentNode.right = currNode.left;
                    currNode = null;
                }
                return true;

            } else if (currNode.left == null && currNode.right != null) {
                // 자식이 오르쪽에 있는 경우
                if (value < currParentNode.value) {
                    currParentNode.left = currNode.right;
                    currNode = null;
                } else {
                    currParentNode.right = currNode.right;
                    currNode = null;
                }
                return true;
            }

            else {
                // 삭제할 노드의 자식이 둘다 있는 경우
                // 삭제할노드가 부모노드의 왼쪽에 있을 경우
                if (value < currParentNode.value) {

                    Node changeNode = currNode.right;
                    Node changeParentNode = currNode.right;

                    while (changeNode.left != null) {
                        changeParentNode = changeNode;
                        changeNode = changeNode.left;
                    }

                    //여기까지 실행되면 삭제할노드(currNode)의 오른쪽자식중 가장왼쪽에 있는 노드(가장작은값)ddl
                    //changeNode에 들어가있고 그의 부모는 changeParentNode

                    if (changeNode.right != null) {
                        changeParentNode.left = changeNode.right;
                    } else {
                        // 자식이 없을떄
                        changeParentNode.left = null;
                    }

                    currParentNode.left = changeNode;

                    changeNode.right = currNode.right;
                    changeNode.left = currNode.left;




                } else {
                    // 삭제할 노드가 부모노드의 오른쪽에 있을 경우

                    Node changeNode = currNode.right;
                    Node changeParentNode = currNode.right;

                    while (changeNode.left != null) {
                        changeParentNode = changeNode;
                        changeNode = changeNode.left;
                    }

                    if (changeNode.right != null) {
                        changeParentNode.left = changeNode.right;
                    } else {
                        changeParentNode.left = null;
                    }

                    currParentNode.right = changeNode;

                    changeNode.left = currNode.left;
                    changeNode.right = currNode.right;

                    currNode = null;
                }
                return true;

            }
        }

    }
}
