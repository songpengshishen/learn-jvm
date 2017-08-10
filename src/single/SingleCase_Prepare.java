package single;

/**
 * java中单例模式之预先加载--没有线程问题
 * @author wsp
 * @since 2017/08/08
 */
public class SingleCase_Prepare {

    private final static SingleCase_Prepare singleCase = new SingleCase_Prepare();

    private SingleCase_Prepare(){

    }

    public static SingleCase_Prepare getSingleCase(){
        return singleCase;
    }


}
