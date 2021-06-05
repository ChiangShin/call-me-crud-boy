# Java中的移位运算符

来源：知乎-Java那些事儿-Java中的移位运算符 https://zhuanlan.zhihu.com/p/30108890

计算机是以0和1来处理数据的，在阅读源码的过程中，经常会看到这些符号<< ，>>，>>>，这些符号在Java中叫移位运算符，在写代码的过程中，虽然我们基本上不会去写这些符号，但需要明白这些符号的运算原理，比如HashMap中有以下代码：

```java
static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;//左移
static final int hash(Object key) {
     int h;
     return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);//无符号右移
}
```

上段代码中就包含左移运算符<<，无符号右移运算符>>>。这篇文章详细说一下这三个符号：

**1、左移运算符：<<**

先随便定义一个int类型的数int，十进制的value = 733183670，转换成二进制在计算机中的表示如下：

![img](.\img\v2-20435c47cd9edba5421abf91947141e6_720w.jpg)

value << 1，左移1位

![img](.\img\v2-e2c197a26575ee3b068e4f5c45e8c438_720w.jpg)

左移1位后换算成十进制的值为：1466367340，刚好是733183670的两倍， 有些人在乘2操作时喜欢用左移运算符来替代。

value << 8，左移8位看一下：

![img](.\img\v2-f3df959bbf54d0c7fdfedd522d3b389d_720w.jpg)

左移8位后变成了十进制的值为：-1283541504，移动8位后，由于首位变成了1，也就是说成了负数，在使用中要考虑变成负数的情况。

根据这个规则，左移32位后，右边补上32个0值是不是就变成了十进制的0了？**答案是NO，**当int类型进行左移操作时，**左移位数大于等于32位操作时，会先求余（%）后再进行左移操作。**也就是说左移32位相当于不进行移位操作，左移40位相当于左移8位（40%32=8）。当long类型进行左移操作时，long类型在二进制中的体现是64位的，因此求余操作的基数也变成了64，也就是说左移64位相当于没有移位，左移72位相当于左移8位（72%64=8），写一段代码来测试一下

```java
int intValue = 733183670;//随意写一个数	
System.out.println("intValue：" + (intValue));//打印intValue
System.out.println("intValue左移1位：" + (intValue << 1));//左移1位
System.out.println("intValue左移8位：" + (intValue << 8));//左移8位
//当int类型左移位数大于等于32位操作时，会先求余后再进行移位操作
System.out.println("intValue左移32位：" + (intValue << 32));//求余为32%32=0，相当于左移0位（不移位）
System.out.println("intValue左移40位：" + (intValue << 40));//求余为40%32=8，相当于左移8位
System.out.println("intValue左移64位：" + (intValue << 64));//求余为64%32=0，相当于左移0位（不移位）
		
long longValue = 733183670L;
System.out.println("longValue：" + (longValue));//打印longValue
System.out.println("longValue左移1位：" + (longValue << 1));//左移1位
System.out.println("longValue左移8位：" + (longValue << 8));//左移8位
//当long类型左移位数大于等于64位操作时，会先求余后再进行移位操作
System.out.println("longValue左移64位：" + (longValue << 64));//求余为64%64=0，相当于左移0位（不移位）
System.out.println("longValue左移72位：" + (longValue << 72));//求余为72%64=8，相当于左移8位
System.out.println("longValue左移128位：" + (longValue << 128));//求余为128%64=0，相当于左移0位（不移位）
```

看一下结果：

![img](.\img\v2-1b9abfb28fa6df7f24435f67c07a58c0_720w.jpg)

由于double，float在二进制中的表现比较特殊，因此不能来进行移位操作，报错，编译不过，如下图：

![img](.\img\v2-3bb380f0d6d02940f881e23a6d0a40ed_720w.jpg)

注意：其它几种整形byte，short移位前会先转换为int类型（32位）再进行移位，这里就不写代码测试了，大家有兴趣可自行测试。

综上所述：左移 << 其实很简单，也就是说**丢弃左边指定位数，右边补0。**

**2、右移运算符：>>**

还是这个数：**733183670**

![img](.\img\v2-79f1822698ccf0cd8ff3f01c47563e2d_720w.jpg)

value >> 1，右移1位

![img](.\img\v2-1d486928138576e4c9e8bc8cc9cd32a8_720w.jpg)

右移1位后换算成十进制的值为：366591835，刚好是733183670的1半， 有些人在除2操作时喜欢用右移运算符来替代

value >> 8，右移8位看一下

![img](.\img\v2-cfec4fd211f71a1508b47be0af91ff59_720w.jpg)

写一段代码测试一下

```java
int intValue = 733183670;//随意写一个数
System.out.println("intValue：" + (intValue));//打印intValue
System.out.println("intValue右移1位：" + (intValue >> 1));//右移1位
System.out.println("intValue右移8位：" + (intValue >> 8));//右移8位
//当int类型右移位数大于等于32位操作时，会先求余后再进行移位操作
System.out.println("intValue右移32位：" + (intValue >> 32));//求余为32%32=0，相当于右移0位（不移位）
System.out.println("intValue右移40位：" + (intValue >> 40));//求余为40%32=8，相当于右移8位
System.out.println("intValue右移64位：" + (intValue >> 64));//求余为64%32=0，相当于右移0位（不移位）
		
long longValue = 733183670L;
System.out.println("longValue：" + (longValue));//打印longValue
System.out.println("longValue右移1位：" + (longValue >> 1));//右移1位
System.out.println("longValue右移8位：" + (longValue >> 8));//右移8位
//当long类型右移位数大于等于64位操作时，会先求余后再进行移位操作
System.out.println("longValue右移64位：" + (longValue >> 64));//求余为64%64=0，相当于右移0位（不移位）
System.out.println("longValue右移72位：" + (longValue >> 72));//求余为72%64=8，相当于右移8位
System.out.println("longValue右移128位：" + (longValue >> 128));//求余为128%64=0，相当于右移0位（不移位）
```

结果：

![img](.\img\v2-c6d40540206b1c6226cd274ab84ddfaf_720w.jpg)

和左移一样，int类型移位大于等于32位时，long类型大于等于64位时，会先做求余处理再位移处理，byte，short移位前会先转换为int类型（32位）再进行移位。以上是正数的位移，我们再来看看负数的右移运算，如图，负数intValue：-733183670的二进制表现如下图：

![img](.\img\v2-101d3af5378adbffa1cdbe4ce3ab305d_720w.jpg)

右移8位，intValue >> 8

![img](.\img\v2-6b1405fb7c545ac5f48a8113ec370fe4_720w.jpg)

综上所述：右移运算符>>的运算规则也很简单，**丢弃右边指定位数，左边补上符号位。**

**3、无符号右移运算符：>>>**

无符号右移运算符>>>和右移运算符>>是一样的，只不过右移时左边是补上符号位，而无符号右移运算符是补上0，也就是说，对于正数移位来说等同于：>>，负数通过此移位运算符能移位成正数。以-733183670>>>8为例来画一下图

![img](.\img\v2-5f04c1742597fa88030212c3b1fbfa54_720w.jpg)

无符号右移运算符>>的运算规则也很简单，**丢弃右边指定位数，左边补上0。**





###  把一个整数减去1之后再和原来的整数做位与运算，得到的结果相当于把整数的二进制表示中的最右边的1变成0