package memory;

/**
 * JAVA(JVM)内存模型--JMM
 * 内存模型概念:JAVA(JVM)内存模型是JAVA抽象出的一套,一致的、跨平台的内存模型.屏蔽并封装了硬件平台和操作系统对于线程读写内存变量及一些缓存等存储的细节
 * ,并定义了多个线程在对变量进行读写时的规则.通过几个语言级别的关键字，包括：volatile, final以及synchronized 定义一些内存模型的操作.
 * JAVA线程通信:JAVA基于共享内存模型进行线程通信.由JMM来控制线程通信.
 * 工作内存和主内存:JMM将共享变量所在的堆内存抽象为主内存,将每个线程的私有内存,寄存器和cpu高速缓存抽象为工作内存.线程工作内存存放了该线程读写主内存
 * 的共享变量副本.
 * JMM内存模型的目的是为了更好的满足多个线程读写变量时的三个特性:原子性,可见性,顺序一致性
 */
public class Jsr133MemoryModel {

    int x = 0, y = 0;

    //未重排序的正常情况下y可能为0x为1,但是如果写线程下的指令序列被编译器或cpu重排序了结果会相反

    //写线程
    public void writer() {
        x = 1;
        y = 2;
    }
    //读线程
    public void reader() {
        System.out.println(y);
        System.out.println(x);
    }


    class WriteThread implements  Runnable{
        @Override
        public void run() {
            Jsr133MemoryModel.this.writer();
        }
    }


    class readThread implements  Runnable{
        @Override
        public void run() {
            Jsr133MemoryModel.this.reader();
        }
    }


    public void start() {
        Thread read = new Thread(new readThread());
        Thread write = new Thread(new WriteThread());
        read.start();
        write.start();
    }

    public static void main(String[] args) {
        Jsr133MemoryModel memoryModel = new Jsr133MemoryModel();
        memoryModel.start();
    }
}

