package com.cundy.work.interview.subject;

/**
 * java中常用的集合框架
 * Collection接口 和 Map接口
 *
 * Collection接口定义了一个包含一批对象的集合。接口方法主要包括：
 *      size()
 *      add(E)/addAll(c）
 *      remove(o)/removeAll(c)
 *      contains(o)/containsAll(c)
 *      toArray()
 *
 * Map接口
 * Map接口在Collection的基础上，为其中的每个对象指定了一个key,并使用Entry保存每个key-value
 * ,以实现通过key快速定位到对象value.Map的接口主要方法包括：
 *      size()
 *      put(K,V)/putAll(map)
 *      get(K)
 *      remove(K)
 *      keySet()
 *      values()
 *      entrySet()
 *      containsKey(K)/containsValue(V)
 *
 * List类集合
 * list接口继承了Collection，用于定义以列表形式存储的集合，List接口为集合中的每个对象分配了一个索引（index），标记该对象在List中的位置，并可以通过index定位到指定位置的对象。
 * List在Collection基础上增加的主要方法包括
 *     get(int)
 *     add(E)/add(int,E)
 *     set(int,E)
 *     indexOf(o)
 *     subList(int,int)
 *
 * List接口的常用实现类：
 * ArrayList
 * ArrayList基于数组来实现集合的功能，其内部维护了一个可变长的对象数组，集合内所有对象存储于这个数组中，并实现该数组长度的动态伸缩
 *
 *LinkedList基于链表来实现集合的功能，其实现了静态类Node,集合中的每个对象都由一个Node保存，每个Node
 * 都拥有到自己的前一个后一个node的引用
 *
 * ArrayList和LinkedList比较
 * ArrayList的随机访问更高，基于数组实现的ArrayList可直接定位到目标对象，而LinkedList需要从头Node或尾Node开始向后/向前遍历若干次才能定位到目标对象。
 * LinkedList在头/尾节点执行插入/删除操作的效率比ArrayList更高
 * 由于ArrayList每次扩容的容量是当前1.5倍，所以LinkedList所占的内存空间要更小一些
 * 二者的遍历效率接近，但需要注意，便利LinkedList时应用iterator方式，不要用get(int)方式，否则效率会很低
 *
 * Vector
 * Vector和ArrayList很像，都是基于数组实现的集合，它和ArrayList的主要区别在于
 * Vector是线程安全的，而ArrayList不是
 * 由于Vector中的方法基本都是synchronized,其性能低于ArrayList
 * Vector可以定义数组长度扩容的因子，ArrayList不能
 *
 *
 */
public class day04 {
}
