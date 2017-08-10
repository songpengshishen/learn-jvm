package single;

/**
 * java中单例模式之静态成员内部类--不会有任何问题
 * @author wsp
 * @since 2017/08/08
 */
public class SingleCase_Inside_Class {

    public static class SingleCaseInstance{

        private static final  SingleCase_Inside_Class singleCase_inside_class = new SingleCase_Inside_Class();
    }

    private SingleCase_Inside_Class(){

    }

    /**
     * 这里依然保证了懒加载模式的好处,只有调用了这个方法的时候才会去加载这个成员内部类SingleCaseInstance,所以singleCase_inside_class依然是调用时才初始化
     * 并且只有在加载这个成员内部类的时候,才初始化,因为jvm保证类加载初始化是原子的,所以不用加锁.
     * @return
     */
    public  static SingleCase_Inside_Class getSingleCase(){
       return SingleCaseInstance.singleCase_inside_class;
    }

}
