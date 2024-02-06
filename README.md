# CS61b

## 高效编程(`efficient programming`)

### 编程成本

- 花费多久的时间来进行编程？
- 代码有多容易去阅读和修改?
- 代码的可维护性怎么样？（`important`）

### 执行花费

- `Time complexity `：花费多久的时间去执行程序
- `Space complexity`：花费多少的空间去执行程序



```java
1 + 2 + 3 + ... + N = O(N^2)
1 + 2 + 4 + ... + N = O(N)
这里式子2一共有log2(x)项
因为 2^n = N --> n == log2(N)
```

```c++
// case 1
	// O(n^2) = O(n) * O(n)
 	for(int i = 0 ; i < n ;i ++)
 	{
 		for(int j = 0 ; j < n ; j ++){
 			cout << "Hello, world!" << endl;
 		}
 	}
 	// case 2
 	// O(n^2) = 1 + 2 + 3 + 4 + ... + n
 	for(int i = 0 ; i < n ; i ++){
 		for(int j = 0 ; j < i ; j ++){
 			cout << "Hello, world" << endl;
 		}
 	}
 	// case 3
 	// O(N*logN)
 	for(int i = 0 ; i < n ; i *= 2){
 		for(int j = 0 ; j < n ; j ++){
 			cout << "Hello, world" << endl;
 		}
 	}
 	// case 4
 	// O(N) = 1 + 2 + 4 + 8 + ... + n = 2N - 1 = O(N)
	for(int i = 0 ; i < n ; i *= 2){
 		for(int j = 0 ; j < i ; j ++){
 			cout << "Hello, world" << endl;
 		}
 	}
```

