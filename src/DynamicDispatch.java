/**
 * 动态分派
 * 在JVM运行期间根据实际类型确定方法调用版本的分派过程是动态分派.动态分派的典型应用是方法重写
 * invokeVirtual(调用虚方法字节码指令):找到元素所属对象的实际类型,通过该类在方法区中方法表集合中查找与调用的方法
 * 符号引用一致的(简单名称和描述符)来调用
 * @author wangsongpeng
 */
public class DynamicDispatch {
    static abstract class Human{
        protected abstract void sayHello();
    }
    static class Man extends Human{
        @Override
        protected void sayHello() {
            System.out.println("man say hello!");
        }
    }
    static class Woman extends Human{
        @Override
        protected void sayHello() {
            System.out.println("Woman say hello!");
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
        man = new Woman();
        man.sayHello();
    }
}
