# [exercise](https://cs61b-2.gitbook.io/cs61b-textbook/16.-adts-and-bsts/16.7-exercises)
- Factual
  - Problem1 : O(N) O(logN)
- Procedural
  - Problem1 : 1 3
  - Problem2 : 4 --> 5
  - Problem3 : O(N), resize the array
- Metacognitive
  - Problem1 :Often in real-world applications, we don't have all our data at once. For example, imagine you're collecting time-based data that you insert into a BST each time a new value is reported. There is no easy way to shuffle your data when you only get one or a few points at a time.
  - Problem2 : 如果该节点具有两个节点，那么就不能保证更换结点之后还能保持`BST`的属性，其子节点中必定存在大于或者小于此节点的节点。
这也是为什么替换的时候选择左子树最右边的点和右子树最左边的点。
