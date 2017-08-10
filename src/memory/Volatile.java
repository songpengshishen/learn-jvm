package memory;

/**
 * Volatile的作用与好处:volatile保证在多线程环境下对同一个变量进行单次读写操作时（复合的非原子操作volatile不行）,让多个线程之间通过主内存进行通信/通知,让多个线程之间具有可见性,从而解决了线程不安全的问题,
 * 也避免了加锁导致的资源开销和性能降低.并且可以避免重排序
 */
public class Volatile {
}
