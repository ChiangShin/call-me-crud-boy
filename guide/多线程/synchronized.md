**Synchronized 关键字**

Synchronized 是一种独占锁。在修饰静态方法时，锁的是类对象，如 Object.class。修饰非静态方法时，锁的是对象，即 this。修饰方法块时，锁的是括号里的对象。 每个对象有一个锁和一个等待队列，锁只能被一个线程持有，其他需要锁的线程需要阻塞等待。锁被释放后，对象会从队列中取出一个并唤醒，唤醒哪个线程是不确定的，不保证公平性。

## **类锁与对象锁**

synchronized 修饰静态方法时，锁的是类对象,如 Object.class。修饰非静态方法时，锁的是对象，即 this。 多个线程是可以同时执行同一个synchronized实例方法的，只要它们访问的对象是不同的。

synchronized 锁住的是对象而非代码，只要访问的是同一个对象的 synchronized 方法，即使是不同的代码，也会被同步顺序访问。

此外，需要说明的，synchronized方法不能防止非synchronized方法被同时执行，所以，一般在保护变量时，需要在所有访问该变量的方法上加上synchronized。

### **实现原理**

synchronized 是基于 Java 对象头和 Monitor 机制来实现的。

#### **Java 对象头**

一个对象在内存中包含三部分：对象头，实例数据和对齐填充。其中 Java 对象头包含两部分：

- Class Metadata     Address （类型指针）。存储类的元数据的指针。虚拟机通过这个指针找到它是哪个类的实例。
- Mark     Word（标记字段）。存出一些对象自身运行时的数据。包括哈希码，GC 分代年龄，锁状态标志等。

#### **Monitor**

Mark Word 有一个字段指向 monitor 对象。monitor 中记录了锁的持有线程，等待的线程队列等信息。前面说的每个对象都有一个锁和一个等待队列，就是在这里实现的。 monitor 对象由 C++ 实现。其中有三个关键字段：

- _owner 记录当前持有锁的线程
- _EntryList     是一个队列，记录所有阻塞等待锁的线程
- _WaitSet     也是一个队列，记录调用 wait() 方法并还未被通知的线程。

Monitor的操作机制如下：

1. 多个线程竞争锁时，会先进入     EntryList 队列。竞争成功的线程被标记为 Owner。其他线程继续在此队列中阻塞等待。
2. 如果 Owner 线程调用     wait() 方法，则其释放对象锁并进入 WaitSet 中等待被唤醒。Owner 被置空，EntryList 中的线程再次竞争锁。
3. 如果 Owner     线程执行完了，便会释放锁，Owner 被置空，EntryList 中的线程再次竞争锁。

### **JVM 对 synchronized 的处理**

上面了解了 monitor 的机制，那虚拟机是如何将 synchronized 和 monitor 关联起来的呢？分两种情况：

- 如果同步的是代码块，编译时会直接在同步代码块前加上     monitorenter 指令，代码块后加上 monitorexit 指令。这称为显示同步。
- 如果同步的是方法，虚拟机会为方法设置     ACC_SYNCHRONIZED 标志。调用的时候 JVM 根据这个标志判断是否是同步方法。