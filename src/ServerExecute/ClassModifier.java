package ServerExecute;

/**
 * class文件修改
 */
public class ClassModifier {
    /**
     * CLASS文件中常量池的起始偏移
     */
    private static final int CONSTANT_POOL_INDEX  = 8;

    /**
     * 常量表constant_utf8_info的常量的tag
     */
    private static final int CONSTANT_UTF8_TAG = 1;

    /**
     * 常量池中11种常量所占的长度,constant_utf8_info常量表的长度是变长的故此除外
     */
    private static final int[] CONTANT_ITEM_LENGTH = {-1,-1,-1,5,5,9,9,3,3,5,5,5,5};

    /*class文件中u1 u2无符号基本类型所占用字节*/
    private static final int u1 = 1;
    private static final int u2 = 2;

    private byte[] classByte;

    public ClassModifier(byte[] classByte){
        this.classByte = classByte;
    }

    /**
     * 修改class文件中指定utf8常量的内容
     * @param oldStr 修改前字符串
     * @param newStr 修改后字符串
     * @return
     */
    public byte[] modifyUTF8Constant(String oldStr,String newStr){
        int cpl = getConstantPoolCount();
        int offset = CONSTANT_POOL_INDEX+u2;//这里跨过常量池计数值,指向第一个常量
        for(int i = 0;i<cpl;i++){
            int tag = ByteUtils.byteToInt(classByte,offset,u1);//获取每一个常量标志
            if(tag == CONSTANT_UTF8_TAG){
                int  len = ByteUtils.byteToInt(classByte,offset+u1,u2);//得到utf8常量的长度
                offset+=(u1+u2);//跨过标志位和长度位指向utf8值
                String str = ByteUtils.bytesToString(classByte,offset,len);//得到utf8的字符串值
                if(str.equalsIgnoreCase(oldStr)){
                     byte[] strBytes = ByteUtils.stringToByte(newStr);//转换新字符串为字节数组
                     byte[] strlen = ByteUtils.intToBytes(newStr.length(),u2);//得到新字符串的长度并转换为u2类型的字节
                     classByte = ByteUtils.bytesReplace(classByte,offset-u2,u2,strlen);//替换utf8常量长度
                     classByte = ByteUtils.bytesReplace(classByte,offset,len,strBytes);//替换utf8的值
                     return classByte;
                }else{
                    offset+=len;//这里直接指向下一个常量
                }
            }else {
                offset+=CONTANT_ITEM_LENGTH[tag];//这里指向下一个常量
            }
        }
        return classByte;
    }


    /**
     * 获取常量池长度,常量的数量
     * @return
     */
    public int getConstantPoolCount(){
        return ByteUtils.byteToInt(classByte,CONSTANT_POOL_INDEX,u2);
    }

}
