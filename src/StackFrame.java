/**
 * <h2>栈帧</h2>
 * <p>JVM虚拟机运行时线程调用方法时的数据结构.</p>
 * <tt>栈帧保存了一个方法的局部变量(方法入参形参),操作数栈,动态链接,返回地址</tt>
 * 1:局部变量表:用来存放方法的参数和定义的局部变量的.局部变量表的单位为slot,一个slot至少可以存放32位数据,64位
 * 按照顺序占用俩个slot.虚拟机使用索引来访问局部变量表,一个索引访问一个slot.其中对于实例方法第0个slot默认是调用
 * 该方法的对象this
 * 2:局部变量表:在局部变量表中对于基本类型存放的就是值,对于引用类型存放的是引用地址.
 * @author wangsongpeng
 * @since 2017/5/13
 */
public class StackFrame {
    public static void main(String[] args) {
        boolean flag;
        System.out.println();
        {

            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        int a = 0;
        System.gc();
        override("a");
    }

    public static  void override(String a){
        System.out.println("haha!");
    }


}
