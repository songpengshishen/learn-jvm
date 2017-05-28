package com.peng.loader;

/**
 * 子类(被动引用的例子)
 */
public class SubClass extends SuperClass{

  static {
      System.out.println("sub class!");
  }

}
