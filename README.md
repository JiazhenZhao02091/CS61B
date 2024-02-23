# CS61b

## 主体内容在`src`目录下，包括`lab` `homework` `project`

## 实验对应记录表

- homework
  - 2018spring
    - [homework0 A Java Crash Course](https://sp18.datastructur.es/materials/hw/hw0/hw0)
    - [homework1 Packages, Interfaces, Generics, Exceptions, Iteration](https://sp18.datastructur.es/materials/hw/hw1/hw1)
    - [homework3 Hashing](https://sp18.datastructur.es/materials/hw/hw3/hw3)
    - [homework4 8 Puzzle](https://sp18.datastructur.es/materials/hw/hw4/hw4)
    - [homework5 Seam Carving](https://sp18.datastructur.es/materials/hw/hw5/hw5)
    - [homework6 Boggle](https://sp18.datastructur.es/materials/hw/hw6/hw6)
    - [homework7 Huffman Coding](https://sp18.datastructur.es/materials/hw/hw7/hw7)
  - 2023spring
    - [homework2  Percolation](https://sp23.datastructur.es/materials/hw/hw2/)
- lab
  - 2018spring
    - [lab10 Priority Queues](https://sp18.datastructur.es/materials/lab/lab10/lab10)
    - [lab11 Graph](https://sp18.datastructur.es/materials/lab/lab11/lab11)
    - [lab12 Merge Sort and Quick Sort](https://sp18.datastructur.es/materials/lab/lab12/lab12)
    - [lab13 Radix Sorts](https://sp18.datastructur.es/materials/lab/lab13/lab13)
    - [lab15 HugLife](https://sp18.datastructur.es/materials/lab/lab15/lab15)
  - 2023spring
    - [lab07 BSTMap](https://sp23.datastructur.es/materials/lab/lab07/)
    - [lab08 HashMap](https://sp23.datastructur.es/materials/lab/lab08/)
    - [lab09 Project2B Checkpoint](https://sp23.datastructur.es/materials/lab/lab09/)
    - [lab12 BYOW Introduction(Project3)](https://sp23.datastructur.es/materials/lab/lab12/)
    - [lab13 Getting Started on Project 3, Phase 2](https://sp23.datastructur.es/materials/lab/lab13/)
- project
  - 2018spring
    - [project0](https://sp18.datastructur.es/materials/proj/proj0/proj0)
    - project1
      - project1A, project1B, project1Gold
    - [project3 Bear Maps, version 3.0](https://sp18.datastructur.es/materials/proj/proj3/proj3)
  - 2023spring
    - project2
      - [project2A](https://sp23.datastructur.es/materials/proj/proj2a/)
      - [project2B](https://sp23.datastructur.es/materials/proj/proj2b)
    - [project3 BYOW](https://sp23.datastructur.es/materials/proj/proj3/)


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





