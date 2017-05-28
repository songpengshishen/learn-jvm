package com.peng.loader;
/**
 * 执行者
 */
public class Executor {
    public static void main(String[] args) {
        System.out.println(SubClass.name);//这里子类使用父类类变量,出现getStatic字节码指令,为了使用
        //正确的类变量值,需要对类变量所在的类进行初始化,所以子类是不会进行初始化的.
        //在设置或读取一个类变量时,只会对这个类变量所在的类进行初始化
    }
}
