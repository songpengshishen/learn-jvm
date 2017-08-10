package single;

/**
 * java中单例模式之懒加载--会有线程问题
 * @author wsp
 * @since 2017/08/08
 */
public class SingleCase_Lazyload {

    private  static SingleCase_Lazyload singleCase = null;

    private SingleCase_Lazyload(){

    }

    public static SingleCase_Lazyload getSingleCase(){
        //这里如果多个线程一起使用会导致每个线程本地内存的对象不一致,虽然最终主内存是一个对象,但是已经打破了单例的规则.
        if(singleCase == null){
            singleCase = new SingleCase_Lazyload();
        }
        return singleCase;
    }

}
