# HashMap

容量：数组的个数，也就是桶的个数，默认为16

负载因子：键值对个数/容量

HashMap在java1.7版本使用了数组+链表的结构，即数组中的元素就是链表，链表中存放了hash值、数据值、下一个链表节点，当put数据时，首先会对key值进行hash运算，获取到这个key在数组中的位置，然后通过遍历链表，一个个对应hash值，判断这个key值是否存在，如果存在，则替换key值，如果不存在，则添加到末尾。

随着hashmap中的值越来越多，hash碰撞也变多，对于超长的链表，需要通过遍历来查找对应的数据，效率会越来越低。在java1.8中，对hashmap有了优化，在链表长度大于8时，会将链表转化为红黑树(将链表转换成红黑树前会判断，如果当前数组的长度小于 64，那么会选择先进行数组扩容，而不是转换为红黑树），以减少搜索时间。 

# LinkedHashMap

LinkedHashMap的数据存储和HashMap的结构一样采用(数组+单向链表)的形式，只是在每次节点Entry中增加了用于维护顺序的before和after变量维护了一个双向链表来保存LinkedHashMap的存储顺序，当调用迭代器的时候不再使用HashMap的的迭代器，而是自己写迭代器来遍历这个双向链表即可。 

# ConcurrentHashMap


### 1.7版本

ConcurrentHashMap 采用了分段锁技术，其中 Segment 继承于 ReentrantLock。不会像 HashTable 那样不管是 put 还是 get 操作都需要做同步处理，理论上 ConcurrentHashMap 支持 CurrencyLevel (Segment 数组数量)的线程并发。每当一个线程占用锁访问一个 Segment 时，不会影响到其他的 Segment。 

### 1.8版本

CAS+synchronized

根据 key 计算出      hashcode 。
  判断是否需要进行初始化。
  f 即为当前 key      定位出的 Node，如果为空表示当前位置可以写入数据，利用 CAS 尝试写入，失败则自旋保证成功。
  如果当前位置的 hashcode      == MOVED == -1,则需要进行扩容。
  如果都不满足，则利用      synchronized 锁写入数据。
  如果数量大于 TREEIFY_THRESHOLD 则要转换为红黑树。 

# ArrayList

底层是数组队列，相当于动态数组，与java中的数组相比，他的容量能动态增长。初始容量为10，

ArrayList 与 LinkedList比较

1.ArrayList是实现了基于动态数组的数据结构，LinkedList基于链表的数据结构。

2.对于随机访问get和set，ArrayList觉得优于LinkedList，因为LinkedList要移动指针。

3.对于新增和删除操作add和remove，LinedList比较占优势，因为ArrayList要移动数据。 

# 并发容器

ConcurrentHashMap：并发版HashMap

JAVA 7中采用分段锁来减少锁的竞争，JAVA 8中放弃了分段锁，采用CAS（一种乐观锁），同时为了防止哈希冲突严重时退化成链表（冲突时会在该位置生成一个链表，哈希值相同的对象就链在一起），会在链表长度达到阈值（8）后转换成红黑树（比起链表，树的查询效率更稳定）。

CopyOnWriteArrayList：并发版ArrayList

并发版ArrayList，底层结构也是数组，和ArrayList不同之处在于：当新增和删除元素时会创建一个新的数组，在新的数组中增加或者排除指定对象，最后用新增数组替换原来的数组。

适用场景：由于读操作不加锁，写（增、删、改）操作加锁，因此适用于读多写少的场景。

局限：由于读的时候不会加锁（读的效率高，就和普通ArrayList一样），读取的当前副本，因此可能读取到脏数据。如果介意，建议不用。

CopyOnWriteArraySet：并发Set
  ConcurrentLinkedQueue：并发队列(基于链表)
  ConcurrentLinkedDeque：并发队列(基于双向链表)
  ConcurrentSkipListMap：基于跳表的并发Map
  ConcurrentSkipListSet：基于跳表的并发Set
  ArrayBlockingQueue：阻塞队列(基于数组)
  LinkedBlockingQueue：阻塞队列(基于链表)
  LinkedBlockingDeque：阻塞队列(基于双向链表)
  PriorityBlockingQueue：线程安全的优先队列
  SynchronousQueue：读写成对的队列
  LinkedTransferQueue：基于链表的数据交换队列
  DelayQueue：延时队列

 