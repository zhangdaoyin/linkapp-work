package com.cundy.work.interview.subject;

/**
 * JVM内存结构
 *
 * 1.程序计数器 Program Counter Register
 * 程序计数器是一块较小的内存空间，可以看作是当前线程所执行字节码的行号指示器，指向下一个将要执行的指令代码，由执行引擎来读取下一条指令。更确切的说，一个线程的执行，是通过字节码解释器改变当前线程的计数器的值，来获取下一条需要执行的字节码指令，从而确保线程的正确执行。
 *
 * 为了确保线程切换后（上下文切换）能恢复到正确的执行位置，每个线程都有一个独立的程序计数器，各个线程的计数器互不影响，独立存储。也就是说程序计数器是线程私有的内存。
 *
 * 如果线程执行java方法，这个计数器记录的是正在执行的虚拟机字节码指令的地址；如果执行的是native方法，计数器值为undefined。
 *
 * 程序计数器不会发生内存溢出（OOM）问题
 *
 * 2.栈
 * jvm中的栈包括java虚拟机栈和本地方法栈。两者的区别就是，java虚拟机栈为jvm执行java方法服务，本地方法栈则为jvm使用到的native方法服务。两者作用是极其相似的，以下主要介绍java虚拟机栈，以下简称栈。
 *
 * native方法是什么？
 * jdk中有很多方法是使用native修饰的。native方法不是以java语言实现的，而是以本地语言实现的（比如C或C++）.个人理解Native方法是与操作系统直接交互的。比如通知垃圾收集器进行垃圾回收的代码System.gc(),就是使用native修饰的。
 *
 * 什么是栈？
 * 定义：限定仅在表头进行插入和删除操作的线性表。即压栈（入栈）和弹栈（出栈）都是对栈顶元素进行操作的。所以栈是后进先出的。栈是线程私有的，他的生命周期与线程相同。每个线程都会分配一个栈的空间，即每个线程拥有独立的栈空间。
 *
 *栈中存储的是什么？
 * 栈帧是栈的 元素。每个方法在执行时都会创建一个栈帧。栈帧中存储了局部变量表，操作数栈，动态连接和方法出口等信息。每个方法从调用到运行结束的过程，就是对应着一个栈帧在栈中压栈到出栈的过程。
 *
 *      2.1局部变量表
 *      栈帧中，由一个局部变量表存储数据。局部变量表中存储了基本数据类型（boolean，byte，char,short,int,float,long,double）的局部变量（包括参数）、和对象的引用（String、数组、对象等），但是不存储对象的内容。局部变量表所需要的内存空间在编译期间完成分配，在方法运行期间不会改变局部变量表的大小。
 *      局部变量的容量以变量槽（variable Slot）为最小单位，每个变量槽最大存储32位的数据类型。对于64为的数据类型（long,double）jvm会为其分配两个连续的变量槽来存储。以下简称slot。
 *      JVM通过索引定位的方式使用局部变量表，索引的范围从0开始到局部变量表中最大的slot数量。普通方法与static方法在第0个槽位的存储有所不同。非static方法的第0个槽位存储方法所属对象实例的引用。
 *      Slot复用？
 *      为了尽可能的节省栈帧空间，局部变量表中的slot是可以复用的。方法中定义的局部变量，其作用域不一定会覆盖整个方法。当方法运行时，如果已经超出了某个变量的作用域，即变量失效了，那这个变量对应的slot就可以交给其他变量使用，也就是所谓的slot复用。
 *      凡事有利弊，Slot复用虽然节省了栈帧空间，但是伴随一些额外的副作用。比如，slot的复用会直接影响到系统的垃圾收集行为。
 *      public static void main(String[] args) {
 *         {
 *             byte[] ss = new byte[64 * 1024 * 1024];
 *         }
 *         int a = 0;
 *         System.gc();
 *     }
 *     2.2操作数栈
 *     操作数栈是一个后进先出栈。操作数栈的元素可以是任意的java数据类型。方法刚开始执行时，操作数栈是空的，在方法执行过程中，通过字节码指令对操作数栈进行压栈和出栈的操作。通常进行算数运算的时候是通过操作数栈进行的，又或者是在调用其他方法的时候通过操作数栈进行参数传递。操作数栈可以理解为栈帧中用于计算的临时数据存储区。
 *
 *     栈中可能出现哪些异常？
 *     stackOverflowError:栈溢出错误
 *     如果一个线程在计算时所需要用到栈大小>配置允许最大的栈大小，那么java虚拟机将抛出stackOverFlowError
 *     OutOfMemoryError:内存不足
 *     栈进行动态扩展时如果无法申请到足够内存，会抛出OutOfMemoryError异常
 *
 *     如何设置栈参数？
 *     使用-Xss设置栈大小，通常几百K就够了。由于栈是线程私有的，线程数越多，占用栈空间越大。
 *      栈决定了函数调用的深度。这也是慎用递归调用的原因。递归调用时，每次调用方法都会创建栈帧并压栈。当调用一定次数之后，所需栈的大小已经超过了虚拟机运行配置的最大栈参数，就会抛出stackOverFlowError异常。
 *
 * 3.java堆
 * 堆是java虚拟机所管理的内存中最大的一块存储区域。堆内存被所有线程共享。主要存放使用new关键字创建的对象。所有对象实例以及数组都要在堆分配。垃圾收集器就是根据GC算法，收集堆上对象所占用的内存空间（收集的对象占用的空间而不是对象本身）。
 * java堆分为年轻代和老年代；年轻代又分为eden(伊甸园)和survivor(幸存区)；幸存区又分为From Survivor空间和To Survivor空间。
 * 年轻代存储“新生对象”，我们新创建的对象存储在年轻代中。当年轻内存占满后，会触发Minor GC；清理年轻代内存空间。
 * 老年代存储长期存活的对象和大对象。年轻代中存储的对象，经过多次GC后仍然存活的对象会移动到老年代中进行存储。老年代空间占满后会触发Full GC.
 *
 * 注：Full GC是清理整个堆空间，包括年轻代和老年代。如果Full GC之后，堆中仍然无法存储对象，就会抛出OutOfMemoryError异常。
 *
 * 4.方法区（Method Area）
 * 方法区同java堆一样是被所有线程共享的区间，用于存储已被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码。更具体的说，静态变量+常量+类信息（版本，方法。字段等）+运行时常量池存在方法区中。常量池是方法区的一部分。
 *
 * 注：jdk1.8使用元空间metaSpace替代方法区，元空间并不在jvm中，而是使用本地内存。元空间两个参数：
 *      1. MetaSpaceSize:初始化元空间大小，控制发生GC阈值
 *      2.MaxMetaSpaceSize:限制元空间大小上限，防止异常占用过多物理内存
 *常量池中存储编译器生成的各种字面量和符号引用。字面量就是java中常量的意思。比如文本字符串，final修饰的常量等。方法引用则包括类和接口的全限定名，方法名和描述符，字段名和描述符等。
 *
 *  常量池有什么用？
 *
 *  优点：常量池避免了频繁的创建和销毁对象而影响系统性能，其实现了对象的共享。
 *  举个例子：Integer常量池（缓存池），和字符串常量池
 *  我们知道==基本数据类型比较的是数值，而引用数据类型比较的是内存地址。
 *   public static void main(String[] args) {
 *         Integer i1 = new Integer(66);
 *         Integer i2 = new Integer(66);
 *         Integer i3 = 66;
 *         Integer i4 = 66;
 *         Integer i5 = 150;
 *         Integer i6 = 150;
 *         System.out.println(i1==i2);//false
 *         System.out.println(i3==i4);//true
 *         System.out.println(i5==i6);//false
 *     }
 *      IntegerCache 的最小值（-128）和最大值（127）之间
 *
 *      String常量池：
 *      String 是由final修饰的类，是不可以被继承的。通常有两种方式创建对象。
 *      String str = new String("ss");
 *      String str = "sss";
 *
 *      第一种方式使用new创建对象，存放在堆中。每次调用都会创建一个新的对象。
 *      第二种先在栈上创建一个String类的对象引用变量Str,然后通过符号引用去字符串常量池中找有没有sss,如果没有，则将sss存放到字符串常量池中
 *      String Str3 = new String("abcd");
 *         String Str4 = new String("abcd");
 *         String Str1 = "abcd";
 *         String Str2 = "abcd";
 *
 *         System.out.println(Str1 == Str2);//true
 *         System.out.println(Str1 == Str3);//false
 *         System.out.println(Str3 == Str4);//false
 *         System.out.println(Str2 == Str4);//false
 *
 *         String Str5 = "ab";
 *         String Str6 = "cd";
 *         String Str7 = "ab" + "cd";
 *         System.out.println(Str1 == Str7);//true
 *
 *         String Str8 = Str5 +"cd";
 *         System.out.println(Str8 == Str4);//false
 *     关于字符串+号连接问题
 *     对于字符串常量的+号连接，在程序编译期，jvm就会将其优化为+号连接后的值。所以在编译期其字符串常量的值就确定了。
 *
 *     关于字符串引用+号连接问题
 *     对于字符串引用的+号连接问题，由于字符串引用在编译期无法确定下来，在程序的运行期动态分配并创建新的地址存储对象。
 *
 *     使用final修饰的字符串
 *     在编译期就能确定其值。
 *
 *      String 对象的intern方法
 *      调用intern方法，返回的是内容在常量池中的地址值。
 *
 *
 *
 *
 */
public class day05 {
//    //1.局部变量表中 变量槽
//    public static void main(String[] args) {
//        {
//            byte[] ss = new byte[64 * 1024 * 1024];
//        }
//        int a = 0;
//        System.gc();
//    }

//    public static void main(String[] args) {
//        Integer i1 = new Integer(66);
//        Integer i2 = new Integer(66);
//        Integer i3 = 66;
//        Integer i4 = 66;
//        Integer i5 = 150;
//        Integer i6 = 150;
//        System.out.println(i1==i2);//false
//        System.out.println(i3==i4);//true
//        System.out.println(i5==i6);//false
//    }
    public static void main(String[] args) {

        String Str3 = new String("abcd");
        String Str4 = new String("abcd");
        String Str1 = "abcd";
        String Str2 = "abcd";

        System.out.println(Str1 == Str2);//true
        System.out.println(Str1 == Str3);//false
        System.out.println(Str3 == Str4);//false
        System.out.println(Str2 == Str4);//false

        String Str5 = "ab";
        String Str6 = "cd";
        String Str7 = "ab" + "cd";
        System.out.println(Str1 == Str7);//true

        String Str8 = Str5 +"cd";
        System.out.println(Str8 == Str4);//false
        System.out.println(Str8.intern() == Str2);//true

    }

}
