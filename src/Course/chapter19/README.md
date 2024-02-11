Note that if we are trying to add a key-value pair and the key already exists in the hash map, the corresponding value should be updated but no resizing should occur.
<br/>
这句话是不是和哈希冲突矛盾？<br/>还是说单纯只是指插入Map时的特殊情况



<br/>

哈希表`resize`之后，所有的元素都需要重新进行映射，因为映射公式为`hashCode() % array.length()`

<br/>

hashCode 和 equals 方法必须保持一致，否则会出问题

<br/>

不要修改用于用于做key的对象[[slide]](https://docs.google.com/presentation/d/1U_-RQCJB3j9B-k-kY8I4nS-FuxIvO8EgVIrOthx2InU/edit#slide=id.g2165b69ef3f_0_291)

```java
public  void test() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        System.out.println(list.hashCode()); // 32
        list.addFirst(2);
        System.out.println(list.hashCode()); // 1024
    }
```
如上面所示，相同的`list`在对其元素进行变更之后，地址会改变，进而影响到了用地址做哈希的`hashCode()`函数，导致找不到该映射



