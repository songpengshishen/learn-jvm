/**
 * JVM字节码指令
 * 1:JVM中支持和使用的数据类型和JAVA中是不一致的.boolean,byte,short,char java支持JVM不支持会把它们转换成int类型
 * 操作.
 */
public class ByteCode {

    public void  test(){
        synchronized (this){
            System.out.println("aa");
        }
    }
}
