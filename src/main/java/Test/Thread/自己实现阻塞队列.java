package Test.Thread;

import java.util.Stack;

public class 自己实现阻塞队列<T> {

    // push的锁,stack的数量超过MAX_SIZE后，继续添加数据将使得线程等待在pushLock
    private final static Object pushLock = new Object();
    // pop的锁
    private final static Object popLock = new Object();
    // 存储数据
    private Stack<T> stack;

    private int MAX_SIZE = 3;

    public 自己实现阻塞队列() {
        stack = new Stack<>();
    }

    public synchronized void push(T t) {
        if (stack.size() >= MAX_SIZE) {
            // 超过了最大长度，那么就等待
            pushLock();
        }
        stack.push(t);
        // 解开pop的锁
        popUnlock();
    }

    public T pop() {
        if (stack.size() == 0) {
            // 不能pop，那么就等待
            popLock();
        }
        T t = stack.pop();
        // 解开push的锁
        pushUnlock();
        return t;
    }

    // push锁
    private void pushLock() {
        synchronized (pushLock) {
            try {
                pushLock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 解开push锁
    private void pushUnlock() {
        synchronized (pushLock) {
            pushLock.notify();
        }
    }

    // pop锁
    private void popLock() {
        synchronized (popLock) {
            try {
                popLock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 解开pop锁
    private void popUnlock() {
        synchronized (popLock) {
            popLock.notify();
        }
    }
}