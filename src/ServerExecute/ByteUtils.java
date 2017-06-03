package ServerExecute;

import sun.tools.java.BinaryCode;

/**
 * Byte数组处理
 */
public class ByteUtils {

    public static int byteToInt(byte[] b,int start,int len){
        int sum = 0;
        int end = start+len;
        for(int i = start ; i<end ;i++){
            int n = ((int)b[i])&0xFF;//这里字节转int会导致32位的高位补位导致数据错误,与OXFF做逻辑与运算
            //因0xff是前24位为0后8位为11111111,所以就将b[i]整型的24个高位清零,低位不变
            n<<=(--len)*8;
            sum = n+sum;
        }
        return sum;
    }

    public static byte[] intToBytes(int value,int len){
        byte[] b = new byte[len];
        for(int i = 0 ;i<len;i++){
            b[len - i - 1] = (byte)((value>>8*i)&0xff);
        }
        return b;
    }

    public static String bytesToString(byte[] b , int start,int len){
      return new String(b,start,len);
    }

    public static byte[] stringToByte(String str){
        return str.getBytes();
    }

    /**
     * 通过systemArrayCoppy完成字节数组的替换
     * @param originalBytes 原字节数组
     * @param offset 替换的字节的起始下标
     * @param len 被替换原有字节的长度
     * @param targetBytes 替换的字节数组
     * @return
     */
    public static byte[] bytesReplace(byte[] originalBytes,int offset,int len,byte[] targetBytes){
        byte[] newBytes = new byte[originalBytes.length+(targetBytes.length-len)];
        System.arraycopy(originalBytes,0,newBytes,0,offset);
        System.arraycopy(targetBytes,0,newBytes,offset,targetBytes.length);
        System.arraycopy(originalBytes,offset+len,newBytes,offset+targetBytes.length,originalBytes.length-offset-len);
        return newBytes;
    }
}
