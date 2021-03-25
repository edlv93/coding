## 树

### 基本概念

- 树有多个节点(node)，用以储存元素
- 节点之间的连线称为边(edge)
- 边的上端节点称为父节点
- 下端称为子节点
- 树的深度(depth)是从根节点开始（其深度为1）自顶向下逐层累加的
- 高度的定义为：从结点x向下到某个叶结点**最长简单路径**中**边的条数**
- 深度是从根节点往下

### 二叉树

常见的二叉树：完全二叉树，满二叉树，二叉搜索树，二叉堆，AVL 树，红黑树，哈夫曼树

- 完全二叉树：若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边（效率高）

- 满二叉树：除最后一层无任何子节点外，每一层上的所有结点都有两个子结点的二叉树

- 二叉搜索树（二叉排序树，二叉查找树）

  - 树中每个节点最多有两个子树，通常称为左子树和右子树
  - 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值
  - 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值
  - 它的左右子树仍然是一棵二叉搜索树 (recursive)

- 平衡树(B树)

  - 排序方式：所有节点关键字是按递增次序排列，并遵循左小右大原则；
  - 子节点数：1<非叶节点的子节点数<=M ，且M>=2，空树除外（注：M阶代表一个树节点最多有多少个查找路径，M=M路,当M=2则是2叉树,M=3则是3叉）
  - 关键字数：ceil(m/2)-1<=枝节点的关键字数量<=M-1个（注：ceil()是个朝正无穷方向取整的函数 如ceil(1.1)结果为2);
  - 所有叶子节点均在同一层、叶子节点除了包含了关键字和关键字记录的指针外也有指向其子节点的指针只不过其指针地址都为null对应下图最后一层节点的空格子

- B+树

  - 特点

    - B+树的**非叶子**节点不保存关键字记录的指针，只进行数据索引（**非叶子**节点所能保存的关键字大大增加）
    - B+树**叶子**节点保存父节点的所有关键字记录的指针，数据地址必须要到叶子节点才能获取到（每次数据查询的次数都一样）
    - B+树叶子节点的关键字从小到大有序排列，左边结尾数据都会保存右边节点开始数据的指针
    - 非叶子节点的子节点数=关键字数（两种实现，或：非叶节点的关键字数=子节点数-1。Mysql 的B+树是第一种）

  - 与红黑树的比较（访问磁盘数据有更高的性能）

    - B+ 树有更低的树高

    - 磁盘访问原理：操作系统一般将内存和磁盘分割成固定大小的块，每一块称为一页，内存与磁盘以页为单位交换数据。数据库系统将索引的一个节点的大小设置为页的大小，使得一次 I/O 就能完全载入一个节点。

      如果数据不在同一个磁盘块上，那么通常需要移动制动手臂进行寻道，而制动手臂因为其物理结构导致了移动效率低下，从而增加磁盘数据读取时间。B+ 树相对于红黑树有更低的树高，进行寻道的次数与树高成正比，在同一个磁盘块上进行访问只需要很短的磁盘旋转时间，所以 B+ 树更适合磁盘数据的读取

    - 为了减少磁盘 I/O 操作，磁盘往往不是严格按需读取，而是每次都会预读。预读过程中，磁盘进行顺序读取，顺序读取不需要进行磁盘寻道，并且只需要很短的磁盘旋转时间，速度会非常快。并且可以利用预读特性，相邻的节点也能够被预先载入

- 平衡二叉树（AVL 树）：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树

- 红黑树

  - **黑色完美平衡**：任意一个结点到到每个叶子结点的路径都包含数量相同的黑结点

## Linux

### VIM 三个模式

	- 一般指令模式（默认模式）
	- 编辑模式
	- 指令列模式

### 文件属性

- 用户分为三种
  - 文件拥有者
  - 群组
  - 其它人
- 文件类型
  - d：目录
  - -：文件
  - l：链接文件
- 文件权限：
  - 三位一组
  - 对文件拥有者、所属群组以及其它人的文件权限
  - 3 位分别为 r、w、x 权限，表示可读、可写、可执行
- 文件时间
  - modification time (mtime)：文件的内容更新就会更新；
  - status time (ctime)：文件的状态（权限、属性）更新就会更新；
  - access time (atime)：读取文件时就会更新。
- 修改权限
  - chmod
  - 左到右每个位的权值为 4、2、1
- 默认权限
  - 文件默认权限666
  - 目录默认权限777

### 链接

- 实体链接：在目录下创建一个条目，记录着文件名与 inode 编号，这个 inode 就是源文件的 inode。
- 符号链接：文件保存着源文件所在的绝对路径，在读取时会定位到源文件上，可以理解为 Windows 的快捷方式
- ln创建链接：默认是实体链接，加 -s 为符号链接

![image-20210315153144493](/Users/lv/Library/Application Support/typora-user-images/image-20210315153144493.png)

### 获取文件内容

- cat、tac(从最后一行打印)
- more（一页一页打印）、less（增加向前翻页）
- head（前n行）、tail（后几行）

### 数据流重定向

- 一个箭头的表示以覆盖的方式重定向，而有两个箭头的表示以追加的方式重定向
- 输出重定向到 /dev/null（扔进垃圾箱）

### 排序指令（sort）

```shell
$ sort [-fbMnrtuk] [file or stdin]
-f ：忽略大小写
-b ：忽略最前面的空格
-M ：以月份的名字来排序，例如 JAN，DEC
-n ：使用数字
-r ：反向排序
-u ：相当于 unique，重复的内容只出现一次
-t ：分隔符，默认为 tab
-k ：指定排序的区间

$ uniq [-ic](可以将重复的数据只取一个)
-i ：忽略大小写
-c ：进行计数
```

### 正则表达式(grep)

```shell
$ grep [-acinv] [--color=auto] 搜寻字符串 filename
-c ： 统计匹配到行的个数
-i ： 忽略大小写
-n ： 输出行号
-v ： 反向选择，也就是显示出没有 搜寻字符串 内容的那一行
--color=auto ：找到的关键字加颜色显示
```

### 查看进程

- ps -l 查看自己的进程
- ps aux 查看系统所有进程
- pstree 查看进程数



## Java

### 基本数据类型

- 整型：byte(8)、short(16)、int(32)、long(64)
- 浮点型：float(32)、double(64)
- 布尔型：boolean(8)
- 字符型：char(16)
- 只能向上转型
-  += 或者 ++ 运算符会执行隐式类型转换

### 异常处理

![image-20210316103655281](/Users/lv/Library/Application Support/typora-user-images/image-20210316103655281.png)

#### 三种类型的异常

- **检查性异常：**最具代表的检查性异常是用户错误或问题引起的异常，这是程序员无法预见的。例如要打开一个不存在文件时，一个异常就发生了，这些异常在编译时不能被简单地忽略。
- **运行时异常：** 运行时异常是可能被程序员避免的异常。与检查性异常相反，运行时异常可以在编译时被忽略。
- **错误：** 错误不是异常，而是脱离程序员控制的问题。错误在代码中通常被忽略。例如，当栈溢出时，一个错误就发生了，它们在编译也检查不到的。

#### 关键字

- try/catch：捕获异常，catch可以多重捕获（直到异常被捕获或者通过所有的 catch 块）
- throws/throw：方法使用 throws 关键字来声明（一个方法没有捕获到一个检查性异常），throw 关键字抛出一个异常
- finally：在 try 代码块后面执行的代码块

#### 自定义异常

- 所有异常都必须是 Throwable 的子类。
- 自定义检查性异常类，需要继承 Exception 类。
- 自定义运行时异常类，那么需要继承 RuntimeException 类。

### hashMap

- 底层数据结构，JDK 1.8 是**数组 + 链表 + 红黑树**，JDK 1.7 无红黑树。
- 初始容量为 **16**，通过 tableSizeFor 保证容量为 2 的幂次方。寻址方式，高位异或，**(n-1)&h** 取模，优化速度。
- 扩容机制，当元素数量大于容量 x 负载因子 0.75 时，容量扩大为原来的 2 倍，新建一个数组，然后转移到新数组。
- 基于 Map 实现。
- 线程不安全。
- key的hashCode()做hash，然后再计算index(高位运算和取模运算)
- 指针数组，value为链表，长度大于 8 时，转化为红黑树（1.8），优化查询效率。
  - 当 HashMap 中有大量的元素都存放到同一个桶中时，这个时候 HashMap 就相当于一个单链表，遍历时间复杂度就是 O(n)
  - 转换为红黑树：时间复杂度为 O(logn)
- 当限制n为2的幂次方时，**(n-1)&h**和h%n结果一致，但效率高了很多倍

![image-20210310173600017](/Users/lv/Library/Application Support/typora-user-images/image-20210310173600017.png)

![image-20210310174131957](/Users/lv/Library/Application Support/typora-user-images/image-20210310174131957.png)

### ConcurrentHashMap的实现原理

- 采用了数组+链表+红黑树的实现方式来设计
- ConcurrentHashMap的主干是个Segment数组
  - Segment继承了ReentrantLock，重入锁
  - Segment类似于HashMap，一个Segment维护着一个HashEntry数组
- 分段锁
- 内部大量采用CAS操作
  - 比较交换
  - 乐观锁
  - 包含三个操作数 —— 内存位置（V）、预期原值（A）和新值(B)
- 链表：保存key，value及key的hash值的数据结构，value和next都用volatile修饰

### final关键字

- 修饰类不能被继承
- 修饰方法：不能被重写
- 修饰变量：基本数据类型不能被修改；引用类型初始化后不能指向另一个对象

### String实现

- 属性value：char[]
- String不可变：
  - 实现字符串池（String pool）
  - 多线程安全
  - 避免安全问题
  - 加快字符串处理速度（hashMap的key方便计算hashcode）
- Equals:
  - this == anObject
  - anObject instanceof String
  - 比较value属性
  - 重写hashCode方法

### clone

- clone() 是 Object 的 protected 方法，不是 public，一个类不显式去重写 clone()，其它类就不能直接去调用该类实例的 clone() 方法。
- Cloneable 接口规定：一个类没有实现 Cloneable 接口又调用了 clone() 方法，就会抛出 CloneNotSupportedException
- 浅拷贝：拷贝对象和原始对象的引用类型引用同一个对象
- 深拷贝：拷贝对象和原始对象的引用类型引用不同对象
- 使用 clone() 方法来拷贝一个对象即复杂又有风险，它会抛出异常，并且还需要类型转换。可以使用拷贝构造函数或者拷贝工厂来拷贝一个对象

### volatile

- 在多线程环境下，保证变量的可见性。使用了 volatile 修饰变量后，**在变量修改后会立即同步到主存中，每次用这个变量前会从主存刷新。**
- 禁止 JVM 指令重排序。

![image-20210311142812437](/Users/lv/Library/Application Support/typora-user-images/image-20210311142812437.png)

### synchronized

- 三种应用方式：
  - 修饰实例方法，作用于当前实例加锁，进入同步代码前要获得当前实例的锁
  - 修饰静态方法，作用于当前类对象加锁，进入同步代码前要获得当前类对象的锁
  - 修饰代码块，指定加锁对象，对给定对象加锁，进入同步代码库前要获得给定对象的锁。

### 偏向锁，自旋锁，轻量级锁（乐观锁）重量级锁（悲观锁）

- 通过 synchronized 加锁，第一个线程获取的锁为偏向锁，这时有其他线程参与锁竞争，升级为轻量级锁，其他线程通过循环的方式尝试获得锁，称自旋锁。若果自旋的次数达到一定的阈值，则升级为重量级锁。
- 需要注意的是，在第二个线程获取锁时，会先判断第一个线程是否仍然存活，如果不存活，不会升级为轻量级锁。

![image-20210318145724987](/Users/lv/Library/Application Support/typora-user-images/image-20210318145724987.png)

### AQS（一个用来构建锁和同步器的框架）

- 结构
  - 用 volatile 修饰的整数类型的 state 状态（持有锁的次数），用于表示同步状态，提供 getState 和 setState 来操作同步状态；
  - 提供了一个 FIFO 等待队列，实现线程间的竞争和等待，这是 AQS 的核心；
  - AQS 内部提供了各种基于 CAS 原子操作方法，如 compareAndSetState 方法，并且提供了锁操作的acquire和release方法。
- 独占锁模式
  - 用 state 值表示锁并且 0 表示无锁状态，0 -> 1 表示从无锁到有锁，
  - 仅允许一条线程持有锁，其余的线程会被包装成一个 Node 节点放到队列中进行挂起
  - 队列中的头节点表示当前正在执行的线程，当头节点释放后会唤醒后继节点
- 共享锁模式
  - 当有一个线程获取到锁之后，那么它就会依次唤醒等待队列中可以跟它共享的节点

### ReentrantLock

- 基于 AQS （AbstractQueuedSynchronizer）实现，主要有 state (资源) + FIFO (线程等待队列) 组成。
- 公平锁与非公平锁：区别在于在获取锁时，公平锁会判断当前队列是否有正在等待的线程，如果有则进行排队。
- 使用 lock() 和 unLock() 方法来加锁解锁。
- 非公平锁吞吐量高
  在获取锁的阶段来分析，当某一线程要获取锁时，非公平锁可以直接尝试获取锁，而不是判断当前队列中是否有线程在等待。一定情况下可以避免线程频繁的上下文切换，这样，活跃的线程有可能获得锁，而在队列中的锁还要进行唤醒才能继续尝试获取锁，而且线程的执行顺序一般来说不影响程序的运行。

### 线程池

- 分类
  - FixThreadPool 固定数量的线程池，适用于对线程管理，高负载的系统
  - SingleThreadPool 只有一个线程的线程池，适用于保证任务顺序执行
  - CacheThreadPool 创建一个不限制线程数量的线程池，适用于执行短期异步任务的小程序，低负载系统
  - ScheduledThreadPool 定时任务使用的线程池，适用于定时任务

- 重要参数
  - int corePoolSize, 核心线程数
  - int maximumPoolSize, 最大线程数
  - long keepAliveTime, TimeUnit unit, 超过 corePoolSize 的线程的存活时长，超过这个时间，多余的线程会被回收。
  - BlockingQueue<Runnable> workQueue, 任务的排队队列
  - ThreadFactory threadFactory, 新线程的产生方式
  - RejectedExecutionHandler handler) 拒绝策略

- 线程池线程工作过程

  corePoolSize -> 任务队列 -> maximumPoolSize -> 拒绝策略

> 核心线程在线程池中一直存活，当有任务需要执行时，直接使用核心线程执行任务。当任务数量大于核心线程数时，加入等待队列。当任务队列数量达到队列最大长度时，继续创建线程，最多达到最大线程数。当设置回收时间时，核心线程以外的空闲线程会被回收。如果达到了最大线程数还不能够满足任务执行需求，则根据拒绝策略做拒绝处理。

### 反射

**反射就是在运行时才知道要操作的类是什么，并且可以在运行时获取类的完整构造，并调用对应的方法**

#### 常用方法

- 获取反射中的Class对象`Class clz`
  - 使用 Class.forName 静态方法`Class.forName("java.lang.String")`
  - 使用 .class 方法`String.class`
  - 使用类对象的 getClass() 方法`new String("Hello").getClass()`
- 通过反射创建类对象(通过 Constructor 对象创建类对象可以选择特定构造方法，通过 Class 对象则只能使用默认的无参数构造方法)
  - 通过 Class 对象的 newInstance() 方法`(Apple)clz.newInstance()`
  - 通过 Constructor 对象的 newInstance() 方法`Constructor constructor = clz.getConstructor(); Apple apple = (Apple)constructor.newInstance();`
- 通过反射获取类属性、方法、构造器
  - Class 对象的 getFields() 方法可以获取 Class 类的属性（无法获取私有属性）
  - Class 对象的 getDeclaredFields() 方法则可以获取包括私有属性在内的所有属性

### 注解

#### 注解的作用

- 由编译器使用的注解：不会被编译进入`.class`文件，在编译后就被编译器扔掉（@Override、@SuppressWarnings）
- 由工具处理.class文件使用的注解：会被编译进入`.class`文件，但加载结束后并不会存在于内存中
- 在程序运行期能够读取的注解：在加载后一直存在于JVM中

#### 配置参数

可以有默认值；大部分注解会有一个名为`value`的配置参数，可以省略value参数

- 所有基本类型；
- String；
- 枚举类型；
- 基本类型、String、Class以及枚举的数组

#### 定义方式

- 使用`@interface`语法来定义注解
- 用`default`设定一个默认值（强烈推荐）

#### 元注解

- 修饰其他注解的注解
- Java标准库定义
- 常用
  - @Target：定义`Annotation`能够被应用于源码的哪些位置（数组）
    - 类或接口：`ElementType.TYPE`；
    - 字段：`ElementType.FIELD`；
    - 方法：`ElementType.METHOD`；
    - 构造方法：`ElementType.CONSTRUCTOR`；
    - 方法参数：`ElementType.PARAMETER`
  - @Retention：定义`Annotation`的生命周期（默认值CLASS）
    - `RetentionPolicy.SOURCE`：在编译期就被丢掉（由编译器使用）
    - `RetentionPolicy.CLASS`：仅保存在class文件中，它们不会被加载进JVM（主要由底层工具库使用）
    - RetentionPolicy.RUNTIME`：会被加载进JVM，并且在运行期可以被程序读取
  - @Repeatabl：定义`Annotation`是否可重复
  - @Inherited：定义子类是否可继承父类定义的`Annotation`

#### 使用方式

注解定义后也是一种`class`，所有的注解都继承自`java.lang.annotation.Annotation`。读取注解，需要使用反射API

- `Class.isAnnotationPresent(Class)`
- `Field.isAnnotationPresent(Class)`
- `Method.isAnnotationPresent(Class)`
- `Constructor.isAnnotationPresent(Class)`

## MySQL

### 数据类型

- 整型：TINYINT, SMALLINT, MEDIUMINT, INT, BIGINT 分别使用 8, 16, 24, 32, 64 位存储空间
- 浮点数：FLOAT 和 DOUBLE 为浮点类型，DECIMAL 为高精度小数类型
- 字符串： CHAR（定长） 和 VARCHAR（变长的）
- 时间日期：date、datetime、timestamp（比DATETIME 空间效率更高）

### 主从复制

- **主**：binlog线程——记录下所有改变了数据库数据的语句，放进master上的binlog中
- **从**：io线程——在使用start slave 之后，负责从master上拉取 binlog 内容，放进自己的relay log中
- **从**：sql执行线程——执行relay log中的语句

### 索引类型

	- 普通索引
	- 唯一索引：索引列的值必须唯一，但允许有空值
	- 主键索引：特殊的唯一索引，一个表只能有一个主键，不允许有空值
	- 组合索引：在查询条件中使用了创建索引时的第一个字段，索引才会被使用。遵循最左前缀集合
	- 全文索引：主要用来查找文本中的关键字（MATCH AGAINST）
	- Mysql8新特性降序索引

### 聚集索引（主键索引）和非聚集索引

-  MyISAM索引文件和数据文件是分离的，索引文件仅保存数据记录的地址
- innodb中，表数据文件本身就是按B+Tree组织的一个索引结构，这棵树的叶节点data域保存了完整的数据记录。这个索引的key是数据表的主键，因此InnoDB表数据文件本身就是主索引
- innodb的非聚集索引的叶子节点上的data是主键。（为什么存放的主键，而不是记录所在地址呢，理由相当简单，因为记录所在地址并不能保证一定不会变，但主键可以保证）

### 存储引擎

- MyISAM： 
  - 拥有较高的插入，查询速度
  - 不支持事务
  - 支持表级锁
  - 不支持MVCC
  - 不支持外键
  - 支持全文索引
  - 内部维护了一个计数器，selectcount更快
- InnoDB ：插入缓冲（insert buffer)、二次写(double write)、自适应哈希索引(ahi)、预读(read ahead)
  - 5.5版本后Mysql的默认数据库
  - 支持ACID事务
  - 支持行级锁定
  - 支持MVCC
  - 支持外键
  - 不支持全文索引
  - 不建议使用过长的字段作为主键：因为所有辅助索引都引用主索引，过长的主索引会令辅助索引变得过大。
  - 不建议用非单调的字段作为主键：因为InnoDB数据文件本身是一颗B+Tree，非单调的主键会造成在插入新记录时数据文件为了维持B+Tree的特性而频繁的分裂调整，十分低效，而使用自增字段作为主键则是一个很好的选择。
  - 特殊的功能“自适应哈希索引”：当某个索引值被使用的非常频繁时，会在 B+Tree 索引之上再创建一个哈希索引（B+Tree 索引具有哈希索引的一些优点）

### 索引数据结构

#### B+Tree 索引

- MySQL 存储引擎的默认索引类型
- BTREE 索引需要从根节点到枝节点，最后才能访问到页节点这样多次的IO访问
- B-tree 索引可以用于使用 =, >, >=, <, <= 或者 BETWEEN 运算符的列比较
- B+ Tree 的有序性，可以用于排序和分组
- InnoDB 的 B+Tree 索引分为主索引和辅助索引
  - 主索引的叶子节点 data 域记录着完整的数据记录，这种索引方式被称为聚簇索引（一个表只有一个：数据行不能存放个）
  - 辅助索引的叶子节点的 data 域记录着主键的值。使用辅助索引进行查找，先查找主键值，再到主索引中进行查找
- MyISAM的 B+Tree 索引分为主索引和辅助索引
  - 和InnoDB不同，data域保存数据记录的地址
  - 主索引和辅助索引在结构上没有任何区别，只是主索引要求key是唯一的，而辅助索引的key可以重复

#### Hash 索引

- 检索效率非常高，索引的检索可以一次定位
- 仅仅能满足"=","IN"和"<=>"查询，不能使用范围查询。
- 无法用于排序与分组
- Hash 索引不能利用部分索引键查询。
- Hash 索引在任何时候都不能避免表扫描。
- Hash 索引遇到大量Hash值相等的情况后性能并不一定就会比B-Tree索引高。

### 索引优化

- 独立的列：索引列不能是表达式的一部分，也不能是函数的参数
- 多列索引：在需要使用多个列作为条件进行查询时，使用多列索引比使用多个单列索引性能更好
- 索引列的顺序：让选择性（不重复的索引值和记录总数的比值）最强的索引列放在前面
- 前缀索引：对于 BLOB、TEXT 和 VARCHAR 类型的列，必须使用前缀索引，只索引开始的部分字符
- 覆盖索引：索引包含所有需要查询的字段的值

### 事务的实现

- 事务的**原子性**是通过 undo log（回滚日志） 来实现的
- 事务的**持久性**是通过 redo log（重做日志） 来实现的
- 事务的**隔离性**是通过 (读写锁+MVCC)来实现的
- 事务的**一致性**是通过原子性，持久性，隔离性来实现的

![image-20210315163259110](/Users/lv/Library/Application Support/typora-user-images/image-20210315163259110.png)

### AUTOCOMMIT

MySQL 默认采用自动提交模式。也就是说，如果不显式使用`START TRANSACTION`语句来开始一个事务，那么每个查询操作都会被当做一个事务并自动提交。

### mysql锁技术

- 读写锁
- 共享锁(shared lock),又叫做"读锁
- 排他锁(exclusive lock),又叫做"写锁"

### MVCC基础

MVCC (MultiVersion Concurrency Control) 叫做多版本并发控制

```
InnoDB的 MVCC ，是通过在每行记录的后面保存两个隐藏的列来实现的。这两个列， 一个保存了行的创建时间，一个保存了行的过期时间， 当然存储的并不是实际的时间值，而是系统版本号。
```

通过**数据多版本**来做到**读写分离**。从而实现不加锁读进而做到读写并行

### 并发一致性问题

- 丢失修改：一个事务的更新操作被另外一个事务的更新操作替换
- 脏读：在不同的事务下，当前事务可以读到另外事务未提交的数据
- 不可重复读：一个事务内多次读取同一数据集合
- 幻读：针对插入语句，一个update，一个insert，update之后发现有未更新数据

### 事务的隔离级别（级别由低到高）

- **READ UNCOMMITED** (未提交读) ：事务中的修改，即使没有提交，对其它事务也是可见的（读的过程中写，脏读，**读写并行**）
- **READ COMMITED** (提交读)：一个事务只能读取已经提交的事务所做的修改（排它锁，**读写分离机制**，产生**不可重读**以及**幻读**问题）
- **REPEATABLE READ** (可重复读)（默认级别）：保证在同一个事务中多次读取同一数据的结果是一样的（**读写锁实现**or**MVCC实现**）
- **SERIALIZABLE** (串行)

![image-20210315164122553](/Users/lv/Library/Application Support/typora-user-images/image-20210315164122553.png)

## 查询性能优化

- 使用 Explain分析SELECT语句
  - select_type : 查询类型，有简单查询、联合查询、子查询等
  - key : 使用的索引
  - rows : 扫描的行数
- 优化数据访问
  - 减少请求的数据量
    - 只返回必要的列：最好不要使用 SELECT * 语句。
    - 只返回必要的行：使用 LIMIT 语句来限制返回的数据。
    - 缓存重复查询的数据
  - 减少服务器端扫描的行数：索引
- 重构查询方式
  - 切分大查询
  - 分解大连接查询：将一个大连接查询分解成对每一个表进行一次单表查询，然后在应用程序中进行关联

## 缓存淘汰策略LRU( Least Recently Used)

- 如果一个数据在最近一段时间没有被访问到，那么在将来它被访问的可能性也很小。也就是说，当限定的空间已存满数据时，应当把最久没有被访问到的数据淘汰。
- 哈希表+双向链表实现
- 使用哈希表存储 **key**，值为链表中的节点，节点中存储值，双向链表来记录节点的顺序，头部为最近访问节点。
- **`LRU`**算法中有两种基本操作
  - **`get(key)`**：查询key对应的节点，如果key存在，将节点移动至链表头部。
  - **`set(key, value)`**： 设置key对应的节点的值。如果key不存在，则新建节点，置于链表开头。如果链表长度超标，则将处于尾部的最后一个节点去掉。如果节点存在，更新节点的值，同时将节点置于链表头部。

## 高并发架构

关键字：分布式、高可用、集群、负载均衡、正/反代理

### 演进

1. 应用与数据库分离：增加服务器资源，提高性能
2. 本地缓存和分布式缓存：使用memcached作为本地缓存，使用Redis作为分布式缓存，减小数据库的压力
3. 反向代理（Nginx）实现负载均衡
4. 数据库的读写分离
5. 数据分库（按业务）
6. 把大表拆分为小表
7. 使用LVS或F5来使多个Nginx负载均衡(四层的负载均衡解决方案)
8. 通过DNS轮询实现机房间的负载均衡
9. 引入NoSQL数据库和搜索引擎等技术
10. 大应用拆分为小应用
11. 复用的功能抽离成微服务
12. 引入企业服务总线ESB屏蔽服务接口的访问差异
13. 引入容器化技术实现运行环境隔离与动态服务管理
14. 以云平台承载系统

## 数据库分库分表

### 方式

- 垂直分表（大表拆小表）：将不经常使用或者长度较大的字段拆分出去放到“扩展表”中（设计阶段考虑）
- 垂直分库：按照业务模块来划分出不同的数据库
- 水平分表（横向分表）：降低单表数据量，优化查询性能（主键hash或取模）
- 水平分库分表：水平分表+分库

### 产生的问题和解决思路

- 垂直分库->跨库Join
  - 全局表
  - 字段冗余（数据一致性的问题）
  - 数据同步
  - 系统层组装
- 水平分库
  - 分布式全局唯一ID
  - 分片规则
    - 随机分片和连续分片
  - 数据迁移，容量规划，扩容等问题
  - 跨分片的排序分页（分别排序之后汇总再排序）
  - 跨分片的函数处理
  - 夸分片join

## 服务治理

### 熔断

被调用方故障，调用方会主动停止调用

### 限流

请求数量超出服务的处理能力时，会自动丢弃新来的请求。

### 降级

通过开关配置将某些不重要的业务功能屏蔽掉，以提高服务处理能力

## 计算机网络网络

![image-20210315154739460](/Users/lv/Library/Application Support/typora-user-images/image-20210315154739460.png)



- IP协议：一种分组交换传输协议；
- TCP协议：一种面向连接，可靠传输的协议；
- UDP协议：一种无连接，不可靠传输的协议。
- 操作系统抽象出Socket接口，每个应用程序需要各自对应到不同的Socket，数据包才能根据Socket正确地发到对应的应用程序
- 一个Socket由IP地址和端口号
- 小于1024的端口属于*特权端口*，需要管理员权限
- 使用Socket进行网络编程时，本质上就是两个进程之间的网络通信
- 服务器端的Socket是指定的IP地址和指定的端口号；客户端的Socket是它所在计算机的IP地址和一个由操作系统分配的随机端口号
- 三次握手
  - TCP客户端最后还要发送一次确认的原因：主要防止已经失效的连接请求报文突然又传送到了服务器，从而产生错误
- 四次挥手
  - A 发送连接释放报文，FIN=1。
  - B 收到之后发出确认，此时 TCP 属于半关闭状态，B 能向 A 发送数据但是 A 不能向 B 发送数据。
  - 当 B 不再需要连接时，发送连接释放报文，FIN=1。
  - A 收到后发出确认，进入 TIME-WAIT 状态，等待 2 MSL（最大报文存活时间）后释放连接。
  - B 收到 A 的确认后释放连接。
- underlay就是底层承载网，overlay就是基于底层网络互联互通的基础加上隧道技术去构建一个虚拟的网络。overlay的核心其实就是打隧道（tunnel）

## HTTP

### URL

- HTTP 使用 URL（ **U** niform **R**esource **L**ocator，统一资源定位符）来定位资源，它是 URI（**U**niform **R**esource **I**dentifier，统一资源标识符）的子集，URL 在 URI 的基础上增加了定位能力。

### HTTP状态码

![image-20210315160509284](/Users/lv/Library/Application Support/typora-user-images/image-20210315160509284.png)

### 短连接与长连接

当浏览器访问一个包含多张图片的 HTML 页面时，除了请求访问的 HTML 页面资源，还会请求图片资源。如果每进行一次 HTTP 通信就要新建一个 TCP 连接，那么开销会很大。

长连接只需要建立一次 TCP 连接就能进行多次 HTTP 通信。

- 从 HTTP/1.1 开始默认是长连接的，如果要断开连接，需要由客户端或者服务器端提出断开，使用 `Connection : close`；
- 在 HTTP/1.1 之前默认是短连接的，如果需要使用长连接，则使用 `Connection : Keep-Alive`。

### Cookie

Cookie 是服务器发送到用户浏览器并保存在本地的一小块数据，它会在浏览器之后向同一服务器再次发起请求时被携带上，用于告知服务端两个请求是否来自同一浏览器。由于之后每次请求都会需要携带 Cookie 数据，因此会带来额外的性能开销（尤其是在移动环境下）

#### 用途

- 会话状态管理（如用户登录状态、购物车、游戏分数或其它需要记录的信息）
- 个性化设置（如用户自定义设置、主题等）
- 浏览器行为跟踪（如跟踪分析用户行为等）

#### 创建过程

- 服务器发送的响应报文包含 Set-Cookie 首部字段，客户端得到响应报文后把 Cookie 内容保存到浏览器中。
- 客户端之后对同一个服务器发送请求时，会从浏览器中取出 Cookie 信息并通过 Cookie 请求首部字段发送给服务器。

#### 分类

- 会话期 Cookie：浏览器关闭之后它会被自动删除，也就是说它仅在会话期内有效。
- 持久性 Cookie：指定过期时间（Expires）或有效期（max-age）之后就成为了持久性的 Cookie。

### Session

Session 可以存储在服务器上的文件、数据库或者内存中。也可以将 Session 存储在 Redis 这种内存型数据库中，效率会更高。

使用 Session 维护用户登录状态的过程如下：

- 用户进行登录时，用户提交包含用户名和密码的表单，放入 HTTP 请求报文中；
- 服务器验证该用户名和密码，如果正确则把用户信息存储到 Redis 中，它在 Redis 中的 Key 称为 Session ID；
- 服务器返回的响应报文的 Set-Cookie 首部字段包含了这个 Session ID，客户端收到响应报文之后将该 Cookie 值存入浏览器中；
- 客户端之后对同一个服务器进行请求时会包含该 Cookie 值，服务器收到之后提取出 Session ID，从 Redis 中取出用户信息，继续之前的业务操作。

## HTTPS

HTTP 有以下安全性问题：

- 使用明文进行通信，内容可能会被窃听；
- 不验证通信方的身份，通信方的身份有可能遭遇伪装；
- 无法证明报文的完整性，报文有可能遭篡改。

HTTPS 并不是新协议，而是让 HTTP 先和 SSL（Secure Sockets Layer）通信，再由 SSL 和 TCP 通信，也就是说 HTTPS 使用了隧道进行通信。

通过使用 SSL，HTTPS 具有了加密（防窃听）、认证（防伪装）和完整性保护（防篡改）。

![image-20210315162007751](/Users/lv/Library/Application Support/typora-user-images/image-20210315162007751.png)

### HTTPS 的缺点

- 因为需要进行加密解密等过程，因此速度会更慢；
- 需要支付证书授权的高额费用。

## Redis

### 数据类型

- 键的类型只能为字符串
- 值支持五种数据类型：
  - 字符串：
    - `set <key> <value>`
    - `get <key>`
    - `del <key>`
  - 列表
    - `rpush <key> <item>`
    - `lrange <key> i j`（j可填-1）
    - `rindex <key> i`
    - `lpop <key>`
  - 无序集合
    - `sadd <key> <item>`
    - `smembers <key>`
    - `sismember <key> <item>`
    - `srem <key> <item>`
  - 散列表
    - `hset <key> <sub_key> <value>`
    - `hgetall <key>`（每条数据sub_key和value各占一行）
    - `hdel <key> <sub_key>`
  - 有序集合
    - `zadd <key> <score> <item>`
    - `zrange <key> i j withscores`
    - `zrangebyscore <key> <score1> <score2>  withscores`
    - `zrem <key> <item>`

![image-20210317103340705](/Users/lv/Library/Application Support/typora-user-images/image-20210317103340705.png)

### 使用场景

- 计数器：对 String 进行自增自减运算，从而实现计数器功能（Redis 这种内存型数据库的读写性能非常高）
- 缓存：将热点数据放到内存中，设置内存的最大使用量以及淘汰策略来保证缓存的命中率
- 查找表：查找表的内容不能失效（DNS）
- 消息队列：List 是一个双向链表
- 会话缓存
- 分布式锁实现
  - SETNX
  - RedLock
- 其他
  - SET可以实现交集、并集等操作
  - ZSet 可以实现有序性操作

### 分布式锁实现

#### SETNX（set if not exists）(redis单例)

- SETNX lock.foo <current Unix time + lock timeout + 1>
- 如果 SETNX 返回1，说明该进程获得锁，SETNX将键 lock.foo 的值设置为锁的超时时间（当前时间 + 锁的有效时间）
- 如果 SETNX 返回0，说明其他进程已经获得了锁，进程不能进入临界区。进程可以在一个循环中不断地尝试 SETNX 操作，以获得锁
- 解决死锁问题
  - SETNX lock.foo 返回0，获取锁失败
  - GET lock.foo 来检测锁是否已超时
  - GETSET lock.foo <current Unix timestamp + lock timeout + 1>
  - 设置键的值的同时，还会返回键的旧值
  - 通过比较键 lock.foo 的旧值是否小于当前时间，可以判断进程是否已获得锁

#### RedLock

- 客户端获取当前的时间戳。
- 对 N 个 Redis 实例进行获取锁的操作，具体的操作同单机分布式锁。对 Redis 实例的操作时间需要远小于分布式锁的超时时间，这样可以保证在少数 Redis 节点 Down 掉的时候仍可快速对下一个节点进行操作。
- 客户端会记录所有实例返回加锁成功的时间，只有从多半的实例（在这里例子中 >= 3）获取到了锁，且操作的时间远小于分布式锁的超时时间，锁才被人为是正确获取。
- 如果锁被成功获取了，当前分布式锁的合法时间为初始设定的合法时间减去上锁所花的时间。
- 若分布式锁获取失败，会强制对所有实例进行锁释放的操作，即使这个实例上不存在相应的键值

### Redis 与 Memcached

- 两者都是非关系型内存键值数据库
- 差异
  - 数据类型：
    - Memcached 仅支持字符串类型
    - Redis 支持五种不同的数据类型
  - 数据持久化
    - Redis 支持两种持久化策略：RDB 快照和 AOF 日志
    -  Memcached 不支持持久化
  - 分布式
    - Memcached 不支持分布式，只能通过在客户端使用一致性哈希来实现分布式存储，这种方式在存储和查询时都需要先在客户端计算一次数据所在的节点。
    - Redis Cluster 实现了分布式的支持
  - 内存管理机制
    - 在 Redis 中，并不是所有数据都一直存储在内存中，可以将一些很久没用的 value 交换到磁盘，而 Memcached 的数据则会一直在内存中
    - Memcached 将内存分割成特定长度的块来存储数据，以完全解决内存碎片的问题。但是这种方式会使得内存的利用率不高，例如块的大小为 128 bytes，只存储 100 bytes 的数据，那么剩下的 28 bytes 就浪费掉了

### 数据淘汰策略

![image-20210317143713858](/Users/lv/Library/Application Support/typora-user-images/image-20210317143713858.png)

### 缓存穿透与缓存雪崩

- 缓存穿透：用户想要查询一个数据，发现redis内存数据库没有，也就是缓存没有命中，于是向持久层数据库查询
  - 布隆过滤器：对所有可能查询的参数以hash形式存储，当用户想要查询的时候，使用布隆过滤器发现不在集合中，就直接丢弃，不再对持久层查询
  - 缓存空对象：当存储层不命中后，即使返回的空对象也将其缓存起来，同时会设置一个过期时间，之后再访问这个数据将会从缓存中获取，保护了后端数据源
- 缓存雪崩：大量key同一时间点失效，同时又有大量请求打进来，导致流量直接打在DB上，造成DB不可用
  - 设置key永不失效（热点数据）；
  - 设置key缓存失效时候尽可能错开；
  - 使用多级缓存机制，比如同时使用redsi和memcache缓存，请求->redis->memcache->db；
  - redis高可用

## Docker

#### 网络模式

Docker使用Linux的Namespaces技术来进行资源隔离

- host模式：容器将不会获得一个独立的Network Namespace，而是和宿主机共用一个Network Namespace。容器将不会虚拟出自己的网卡，配置自己的IP等，而是使用宿主机的IP和端口
- container模式：指定新创建的容器和已经存在的一个容器共享一个Network Namespace，新创建的容器不会创建自己的网卡，配置自己的IP，而是和一个指定的容器共享IP、端口范围等
- none模式：Docker容器拥有自己的Network Namespace，但不为Docker容器进行任何网络配置，没有网卡、IP、路由等信息
- bridge模式：默认模式，为每一个容器分配Network Namespace、设置IP等，并将一个主机上的Docker容器连接到一个虚拟网桥上
  - 当Docker server启动时，会在主机上创建一个名为docker0的虚拟网桥
  - 选择一个和宿主机不同的IP地址和子网分配给docker0，连接到docker0的容器就从这个子网中选择一个未占用的IP使用

![image-20210317145603531](/Users/lv/Library/Application Support/typora-user-images/image-20210317145603531.png)

## k8s

### 组件

- 主节点（Master）：kube-controller-manager，kube-apiserver，kube-scheduler
- 工作节点（Node）：kubelet和kube-proxy
- 只有apiserver使用etcd

### 滚动升级

- Deployment已经内置了RollingUpdate strategy
- 升级的过程是先创建新版的pod将流量导入到新pod上后销毁原来的旧的pod
- StatefulSet
  - 默认方式
    - 从序号最大的 Pod 开始，逐个删除和更新每一个 Pod，直到序号最小的 Pod 被更新
    - 当正在更新的 Pod 达到了 Running 和 Ready 的状态之后，才继续更新其前序 Pod
  - 指定 `.spec.updateStrategy.rollingUpdate.partition` 字段，可以分片（partitioned）执行RollingUpdate 更新策略
    - 序号大于或等于 .spec.updateStrategy.rollingUpdate.partition 的 Pod 将被删除重建
    - 序号小于 .spec.updateStrategy.rollingUpdate.partition 的 Pod 将不会更新，及时手工删除该 Pod，kubernetes 也会使用前一个版本的 .spec.template 重建该 Pod
    - 如果 .spec.updateStrategy.rollingUpdate.partition 大于 .spec.replicas，更新 .spec.tempalte 将不会影响到任何 Pod
  - partition适用场景
    - 预发布
    - 金丝雀更新
    - 按阶段的更新

### 亲和、反亲和

- 亲和性：应用A与应用B两个应用频繁交互，所以有必要利用亲和性让两个应用的尽可能的靠近，甚至在一个node上，以减少因网络通信而带来的性能损耗。
- 反亲和性：当应用的采用多副本部署时，有必要采用反亲和性让各个应用实例打散分布在各个node上，以提高HA。
- node亲和性可以约束调度器基于node labels调度pod
  - requiredDuringSchedulingIgnoredDuringExecution：严格执行，满足规则调度，否则不调度
  - preferredDuringSchedulingIgnoredDuringExecution：尽力执行，优先满足规则调度