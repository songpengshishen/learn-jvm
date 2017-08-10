package single;

/**
 * java中单例模式之双重锁懒加载volatile--不会有重排序问题,但是需要在JDK1.5 jsr-133新内存模型中,因为1.5后volatile具有避免重排序问题
 * @author wsp
 * @since 2017/08/08
 */
public class SingleCase_volatile {

    private volatile static SingleCase_volatile singleCase = null;
    private  final  static  Object lock = new Object();

    private SingleCase_volatile(){

    }

    public synchronized static SingleCase_volatile getSingleCase(){

        if(singleCase == null){
            synchronized (lock){
                if(singleCase == null){
                    /**
                     * 这里使用volatile生成内存屏障保证不会出现重排序,也就是说总是先执行1:分配内存,2:调用构造器创建对象,3:移动指针指向内存,
                     * 不会出现线程拿到不为空但是没有调用构造器的对象,因为没构造完成指针一直是空
                     */
                    singleCase = new SingleCase_volatile();
                }
            }

        }
        return singleCase;
    }

}
