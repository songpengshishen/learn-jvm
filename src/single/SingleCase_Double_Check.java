package single;

/**
 * java中单例模式之双重锁懒加载--会有重排序问题
 * @author wsp
 * @since 2017/08/08
 */
public class SingleCase_Double_Check {

    private  static SingleCase_Double_Check singleCase = null;
    private  final  static  Object lock = new Object();

    private SingleCase_Double_Check(){

    }

    public synchronized static SingleCase_Double_Check getSingleCase(){

        if(singleCase == null){
            synchronized (lock){
                if(singleCase == null){
                    /**
                     * 由于new对象操作是非原子操作分为 1:分配内存,2:调用构造器创建对象,3:移动指针指向内存,
                     * 并且jit和cpu会对这3个操作重排序,如果1-3-2这种排序,就会出现一个线程没完全创建好这个对象只执行到了第2步,时间片到了切换到另一个线程
                     * 另一个线程判断singleCase不为空,于是直接返回用了一个残缺的对象.
                     */
                    singleCase = new SingleCase_Double_Check();
                }
            }

        }
        return singleCase;
    }

}
