package com.examples.ch12;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Test;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
	String str();
	int value();
}

class Meta {
	@MyAnnotation(str= "My Annotation", value=123)
	public void method0() {
		
	}
}


public class AnnotationTest {
	@Test
	public void noTest() {
		System.out.println("noTest()");
	}
	
	@Test
	public void testMethodAnnotations() {
		Meta meta;
		Class<?> claz;
		Method method;
		MyAnnotation annotations;
		try {
			meta = new Meta();
			claz = meta.getClass();
			method = claz.getMethod("method0");
			annotations = method.getAnnotation(MyAnnotation.class);
			Assert.assertEquals(123, annotations.value());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} 
	}
	

}
