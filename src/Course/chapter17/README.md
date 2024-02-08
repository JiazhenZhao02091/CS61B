# B-Trees

- 二叉搜索树      : BST
- B树 : 每一个节点可以存储多个 key 当存储的值超过限制的时候，就会上移节点中的值
- 自适应二叉搜索树 : 红黑树


# Exercise

- Factual
  - only a, 2-3树意思是每个节点最多有两个值且最多有3个子节点。 
在b中，出现了有3个值的点；
在c中并不是完全平衡的B树，B树要求所有子节点到根节点的距离相同; 
在b树中，一个节点必须具有当前节点中具有值的数量的+1个子节点，在d中21节点并不符合该条件。
- Procedural
  - Problem1: [link](https://www.cs.usfca.edu/~galles/visualization/BTree.html)
  - Problem2: