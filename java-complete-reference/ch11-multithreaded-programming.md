
#### Multi-tasking
- process based - run two or more programs concurrently
- thread based - a single program can perform two or more tasks simultaneously

#### Java Thread Model
- enable the entire environment to be asynchronous
- single thread systems
- event loop or polling(a single event queue) based mechanism
- one thread can pause without stopping other parts of your system
- fork/join framework - for mutli core environments - part of Java's support for parallel programming
- Thread states
  - running, ready to run, suspended, resumed, blocked, terminated

#### Thred priorities
- relative
- used to decide when to switch from one running thread to the next
- context switch
  - a thread can voluntarily relinquish control - explicitly yielding, sleeping or blocking on pending I/O
  - a thread can be preempted by a higher-priority thread - preemptive multitasking

#### Synchronization
- monitor -C. A. R. Hoare

#### Messaging

#### The Thread Class and Runnable Interface
- Thread class methods:
```java
public final String getName();
final void setName(String threadName);
public final int getPriority();
public final native boolean isAlive();
public final void join();
public void run();
public static native void sleep(long millis) throws InterruptedException;
public static void sleep(long millis, int nanoseconds);
public synchronized void start();
public static native Thread currentThread();
//Thread priorities
final void setPriority(int level);
final int getPriority();
//variables
Thread.MIN_PRIORITY;
Thread.MAX_PRIORITY;
Thread.NORM_PRIORITY;
```

#### Synchronization
- _monitor_ is an object that is used as a mutually exclusive lock
- only one thread can _own_ a monitor at a given time.

#### Using synchronized methods
```java
synchronized(objRef) {
  //
}
```
#### Interthread Communication
- multithreading
  - replaces event loop programming by dividing tasks into discrete, logical units.
  - do away with polling - e.g. in classic queuing problem consumer would waste CPU cycles while it waited producer to produce and vice versa.

```java
public final native void wait(long timeout) throws InterruptedException;
public final native void notify();
public final native void notifyAll();
```
- __wait( )__ tells the calling thread to give up the monitor and go to sleep until some other thread enters the same monitor and calls __notify( )__ or __notifyAll( )__.
- __notify( )__ wakes up a thread that called __wait( )__ on the same object.
- __notifyAll( )__ wakes up all the threads that called __wait( )__ on the same object. One of the threads will be granted access.
