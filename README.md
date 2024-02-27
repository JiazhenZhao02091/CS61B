# CS61B introduction
主体内容在`src`目录下，包括`lab` `homework` `project`

**`2018spring`课程后半部分没有`gitbook read material`，
所以后半部分作者有些是使用了`CS61B2023Spring`版本。
同时由于各个作业、实验等内容不同，作者也将主要做的`homework,lab,project`等列在了下面**

- homework
  - 2018spring
    - [x] [homework0 A Java Crash Course](https://sp18.datastructur.es/materials/hw/hw0/hw0)
    - [x] [homework1 Packages, Interfaces, Generics, Exceptions, Iteration](https://sp18.datastructur.es/materials/hw/hw1/hw1)
    - [x] [homework2  Percolation](https://sp18.datastructur.es/materials/hw/hw2/hw2)
    - [x] [homework3 Hashing](https://sp18.datastructur.es/materials/hw/hw3/hw3)
    - [homework4 8 Puzzle](https://sp18.datastructur.es/materials/hw/hw4/hw4)
    - [homework5 Seam Carving](https://sp18.datastructur.es/materials/hw/hw5/hw5)
    - [homework6 Boggle](https://sp18.datastructur.es/materials/hw/hw6/hw6)
    - [homework7 Huffman Coding](https://sp18.datastructur.es/materials/hw/hw7/hw7)
  - 2023spring
    - [x] [homework0  A Java Crash Course ](https://sp23.datastructur.es/materials/hw/hw0b/) 
    - [x] [homework2  Percolation](https://sp23.datastructur.es/materials/hw/hw2/)
- lab
  - 2018spring
    - [x] [lab01 javac, java, git](https://sp18.datastructur.es/materials/lab/lab1/lab1)
    - [x] [Lab 2 setup: Setting Up IntelliJ](https://sp18.datastructur.es/materials/lab/lab2setup/lab2setup)
    - [x] [Lab 3: Unit Testing with JUnit, Debugging](https://sp18.datastructur.es/materials/lab/lab3/lab3)
    - [x] [Lab 5: Getting Started on Project 2](https://sp18.datastructur.es/materials/lab/lab5/lab5)
    - [x] [Lab 6: Getting Started on Project 2, Phase 2]()
    - [x] [lab10 Priority Queues](https://sp18.datastructur.es/materials/lab/lab10/lab10)
    - [lab11 Graph](https://sp18.datastructur.es/materials/lab/lab11/lab11)
    - [lab12 Merge Sort and Quick Sort](https://sp18.datastructur.es/materials/lab/lab12/lab12)
    - [lab13 Radix Sorts](https://sp18.datastructur.es/materials/lab/lab13/lab13)
    - [lab15 HugLife](https://sp18.datastructur.es/materials/lab/lab15/lab15)
  - 2023spring
    - [x] [lab02 Debugging](https://sp23.datastructur.es/materials/lab/lab02/)
    - [x] [lab03 Timing](https://sp23.datastructur.es/materials/lab/lab03/) 
    - [Lab 05: Advanced Git and Debugging](https://sp23.datastructur.es/materials/lab/lab05/)
    - [x] [lab07 BSTMap](https://sp23.datastructur.es/materials/lab/lab07/)
    - [x] [lab08 HashMap](https://sp23.datastructur.es/materials/lab/lab08/)
    - [lab09 Project2B Checkpoint](https://sp23.datastructur.es/materials/lab/lab09/)
    - [lab12 BYOW Introduction(Project3)](https://sp23.datastructur.es/materials/lab/lab12/)
    - [lab13 Getting Started on Project 3, Phase 2](https://sp23.datastructur.es/materials/lab/lab13/)
- project
  - 2018spring
    - [x] [project0](https://sp18.datastructur.es/materials/proj/proj0/proj0)
    - [x] project1
      - [x] [project1A](https://sp18.datastructur.es/materials/proj/proj1a/proj1a)
      - [x] [project1B](https://sp18.datastructur.es/materials/proj/proj1b/proj1b)
      - [x] [project1Gold](https://sp18.datastructur.es/materials/proj/proj1gold/proj1gold)
    - [project3 Bear Maps, version 3.0](https://sp18.datastructur.es/materials/proj/proj3/proj3)
  - 2023spring
    - [project0 Awakening of Azathoth](https://sp23.datastructur.es/materials/proj/proj0/#evilchooser-constructors-and-methods) 
    - [x] [project1](https://sp23.datastructur.es/materials/proj/proj1a/)
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





