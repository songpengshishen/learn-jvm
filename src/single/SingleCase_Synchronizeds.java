package single;

/**
 * java中单例模式之同步懒加载--会有性能问题
 * @author wsp
 * @since 2017/08/08
 */
public class SingleCase_Synchronizeds {

    private  static SingleCase_Synchronizeds singleCase = null;

    private SingleCase_Synchronizeds(){

    }

    public synchronized static SingleCase_Synchronizeds getSingleCase(){
        //每次进来线程都需要加锁等待,大并发下性能太低
        if(singleCase == null){
            singleCase = new SingleCase_Synchronizeds();
        }
        return singleCase;
    }

}
