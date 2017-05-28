/**
 * 静态分派
 * 1:在编译器期间依赖静态类型来定位调用的方法版本的分派动作称作静态分派,静态分派的典型应用是方法重载.
 * @author wangsongpeng
 */
public class StaticDispatch {
  static abstract class Human{

  }
  static class Man extends Human{

  }
  static class WoMan extends Human{

  }
  public void sayHello(Human guy){
      System.out.println("hello,guy!");
  }
  public void sayHello(Man guy){
      System.out.println("hello,gentleman!");
  }
  public void sayHello(WoMan guy){
      System.out.println("hello,lady!");
  }

  public static void main(String[] args) {
     Human man = new Man();//Human是静态类型,Man是实际类型.静态类型在编译时就可以确认.
     Human women = new WoMan();
     StaticDispatch sd = new StaticDispatch();
     sd.sayHello(man);
     sd.sayHello(women);
  }

}
