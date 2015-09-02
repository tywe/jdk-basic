package org.teng.jdk.problems.instance;

/**
 * description:instanceof判断问题.
 * <p/>
 * 如果实例是类型实例或子类实例，instanceof为true；
 * 如果实例是类型父类实例，instanceof为false；
 *
 * @author:baichuan
 * @date:2015/8/31
 */
public class InstanceTest {

    public static void testInstance() {
        A ab = new B();
        A ac = new C();
        B bc = new C();
        B bb = new B();
        C cc = new C();
        //对象实现一个接口，用这个对象和这个接口进行instanceof判断，都为true。
        System.out.println("ab instanceof A=" + (ab instanceof A));
        System.out.println("ac instanceof A=" + (ac instanceof A));
        System.out.println("bc instanceof A=" + (bc instanceof A));
        System.out.println("bb instanceof A=" + (bb instanceof A));
        System.out.println("cc instanceof A=" + (cc instanceof A));

        //对象和父类进行instanceof判断，都为true
        System.out.println("ab instanceof B=" + (ab instanceof B));
        System.out.println("ac instanceof B=" + (ac instanceof B));
        System.out.println("bc instanceof B=" + (bc instanceof B));
        System.out.println("bb instanceof B=" + (bb instanceof B));
        System.out.println("cc instanceof B=" + (cc instanceof B));

        //对象和他的子类进行instanceof判断为false
        System.out.println("ab instanceof C=" + (ab instanceof C));
        System.out.println("ac instanceof C=" + (ac instanceof C));
        System.out.println("bc instanceof C=" + (bc instanceof C));
        System.out.println("bb instanceof C=" + (bb instanceof C));
        System.out.println("cc instanceof C=" + (cc instanceof C));

        //cc is instance of B，true;else false
        System.out.println("A可以由B类型赋值：" + A.class.isAssignableFrom(B.class));
        System.out.println("cc是B的实例:" + B.class.isInstance(cc));
        System.out.println("ab是C的实例:" + C.class.isInstance(ab));
    }

    public static void main(String[] args) {
        testInstance();

    }
}

interface A {

}

class B implements A {

}

class C extends B {

}