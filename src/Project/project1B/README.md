### 实验总结 
在本次实验`project1b`中，可以发现编写代码的抽象思想
- 在`Palindrome`中进行判别回文字符串，同时为了适配不同的规则，引入了`CharsetComparator`来进行配置不同的规则
- 因为`Comparator`是接口类，它只制定了`equals`函数
- 所有继承`Comparator`的类，都需要实现该函数，也就由此创建了不同的形态

```java
CharacterComparator offByN = new OffByN();
```

这里就可以使用多态的方法，一切都是用接口类，只有到具体的业务环境是才会使用具体的继承实现类。
