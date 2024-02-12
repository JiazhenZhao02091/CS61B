## priority queues
## Heap(max, min)

- add
- removeSmallest
- getSmallest


使用优先级队列实现堆栈？

这种情况下可以考虑修改优先级队列中的优先级规则，通过对每一个加入的元素根据时间来设置一个递增的
`index`，接着通过该`index`来作为优先级队列中的排列规则，
这样我们就可以通过优先级队列来实现堆栈了
