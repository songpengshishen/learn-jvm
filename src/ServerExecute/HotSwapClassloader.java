package ServerExecute;
/**
 * 热部署类加载器
 * 为了多次载入执行类而加入的加载器
 */
public class HotSwapClassloader extends ClassLoader{

    public HotSwapClassloader() {
        super(HotSwapClassloader.class.getClassLoader());
    }

    public Class loadByte(byte[] classByte){
        return defineClass(null,classByte,0,classByte.length);
    }
}
