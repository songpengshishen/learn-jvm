/**
 * 操作数栈
 * @author wsp
 */
public class OperationStack extends StackFrame{
    public int calc(){
       {
            int a = 100;//java编译器和jvm执行时为了减少内存使用,对局部变量slot做了优化.局部变量(除了参数)可以
             //重用slot,只要过了变量的作用域,并且还有其他变量需要初始化,就会将过了作用域的变量从slot中删除,并把
             //新声明的变量放到这个solt中.
       }
       int b = 200;
       int c = 300;
       return b+c;
    }

    public static void main(String[] args) {
        new OperationStack().calc();
    }
}
