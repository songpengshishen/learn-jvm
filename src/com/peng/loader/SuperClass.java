package com.peng.loader;

/**
 * 父类(被动引用的例子)
 */
public class SuperClass {

  static {
      System.out.println("supper class!");
  }

  public static String name = "hello!";
}
