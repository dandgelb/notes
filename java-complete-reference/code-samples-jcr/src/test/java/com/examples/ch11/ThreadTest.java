package com.examples.ch11;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

class DemoRunner implements Runnable {
	@Override
	public void run() {		
		for(int i = 0; i < 5; i++) {
			try {
				System.out.println("Runnable Thread: " + Thread.currentThread().getName() + " : " + i);
				Thread.sleep(new Random().nextInt(1000));				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class DemoThread extends Thread {
	public void run() {
		IntStream.range(0, 5).forEach((i) -> {
			try {
				System.out.println("Demo Thread: " + Thread.currentThread().getName() + ", " + i);				
				Thread.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
}


public class ThreadTest {
	@Test
	public void noTest() {
		
	}
	
	@Test
	public void threadNameTest() {
		Thread t = new Thread();
		t = Thread.currentThread();
		t.setName("Main Thread");
		Assert.assertEquals("Main Thread", t.getName());
	}
	
	@Test
	public void testRunnableThread() {
		Thread t = new Thread(new DemoRunner());
		t.start();
		try {
			t.join();//test thread is exiting instantly
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRunnableThreads() throws InterruptedException {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				Integer[] ints = { 1, 2, 3, 4, 5 };
				Stream.of(ints).forEach(System.out::println);
			}
		});
		t.start();
		t.join();

		t = new Thread(() -> {
			IntStream.range(0, 5).forEach((i) -> {
				try {
					System.out.println("T : " + i);
					Thread.sleep(new Random().nextInt(1000));

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}, "Lambda Thead");
		t.start();
		t.join();
	}
	
	@Test
	public void testThreadExtend() throws InterruptedException {
		DemoThread t = new DemoThread();
		t.start();
		t.join();
	}
	
	@Test
	public void testThreadArray(){
		DemoThread[] threads = new DemoThread[5];
		IntStream.range(0, 3).forEach((i) -> {
			threads[i] = new DemoThread();
			threads[i].start();
		});

		IntStream.range(0, 3).forEach((i) -> {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});		
	}
	
	@Test
	public void testRandomIntegerStream() {
		Random r = new Random();
		r.ints(1, 100).forEach(System.out::println);
	}
}
