/**
 * class文件结构
 * 1:class文件以字节为单位存储,每个数据项按着严格顺序紧凑排列在Class文件中,没有分隔符和其他符合,对于跨字节(多字节)以上的数据项
 * 按照大端法来存储.
 * 2:class文件中一共有2种数据类型:
 * 无符号数.u1(单字节),u2(双字节),u4(四字节)...的基本类型
 * 由无符号数和其他表类型组成的复合数据类型表.
 * class文件可以看成是是一个表.
 * 3:class文件中把多个相同类型的数据项通常是表按照顺序放在一起组成一个表集合.通过索引来访问这个表集合.表集合之前
 * 会放一个表集合长度的基本类型.常量池比较特殊索引通过1为起始.0索引作为特殊使用来表示没有引用常量池的常量表
 * 3:jvm没有使用跳转指令来实现异常而是使用异常表的方式来实现异常.
 * 4:符合引用主要指3点.1:类和接口的全限定名称.2:字段的简单名称和描述符3:方法的简单名称和描述符
 * @author wangsongpeng
 * @since 2017/05/13
 */
public class ClassStruct {
    static int aa = 1;

    static {
        System.out.println(aa);
    }
    public static void main(String[] args) {
        /*int i =  new ClassStruct().inc();
        System.out.printf(String.valueOf(i));*/
        int i = 1/0;
    }

   public int inc(){
       int x;
       try {
           x = 1;
           return x;
       }catch (Exception e){
           x = 2;
           return x;
       }finally {
           x = 3;
       }
   }

}

