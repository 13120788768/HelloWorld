package com.dell.emc.basic.io.serializable;


/**
 * 序列化 & 反序列化
 * 在讲解之前，我们还是先去理解这两个概念性的东西~
 *
 * 「序列化」 字面意思,将对象存转为字节序列
 * 「饭序列化」 将字节序列转为原来的标准对象
 *
 * 为什么要进行对象序列化？
 * 如果程序一关闭数据就会从内存中消失, 现在需要把对象存储到磁盘中，那你就需要进行序列化操作，因为文件操作涉及到字节操作。
 * 再或者你要把对象进行传输到其它的地方执行，通常是通过网络传输，这也引申了一个小知识点 「rpc」 远程调用
 *
 * 在Java中实现序列化主要通过两个接口:
 *
 * Serializable 接口
 * Externalizable 接口
 *
 * Serializable
 * 一个对象想要被序列化，那么它的类就要实现此接口或者它的子接口。
 *  这个对象的所有属性（包括private属性、包括其引用的对象）都可以被序列化和反序列化来保存、传递。
 *  不想序列化的字段可以使用transient修饰。
 *  由于Serializable对象完全以它存储的二进制位为基础来构造，因此并不会调用任何构造函数，
 *      因此Serializable类无需默认构造函数，但是当Serializable类的父类没有实现Serializable接口时，
 *      反序列化过程会调用父类的默认构造函数，因此该父类必需有默认构造函数，否则会抛异常。
 *  使用transient关键字阻止序列化虽然简单方便，但被它修饰的属性被完全隔离在序列化机制之外，
 *      导致了在反序列化时无法获取该属性的值，而通过在需要序列化的对象的Java类里加入writeObject()方法与readObject()方法可以控制如何序列化各属性，
 *      甚至完全不序列化某些属性或者加密序列化某些属性。
 *
 * Externalizable
 * Serializable接口的子类，用户要实现的writeExternal()和readExternal() 方法，用来决定如何序列化和反序列化。
 * 因为序列化和反序列化方法需要自己实现，因此可以指定序列化哪些属性，而transient在这里无效。
 * 对Externalizable对象反序列化时，会先调用类的无参构造方法，这是有别于默认反序列方式的。
 * 如果把类的不带参数的构造方法删除，或者把该构造方法的访问权限设置为private、默认或protected级别，
 * 会抛出java.io.InvalidException: no valid constructor异常，
 *  因此Externalizable对象必须有默认构造函数，而且必需是public的。
 */