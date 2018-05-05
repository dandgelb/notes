### Enumerations, Autoboxing, and Annotations(Metadata)

#### Enumerations

```java
enum Role {
  Admin, Anonymous, Author, Publisher
}
```
- _enumeration constants_ - __Admin__, __Author__ of type __Role__ -> _self-typed_
- _implicitly declared as_: public, static, final
- are of class type - do not instantiate __enum__ using __new__
```java
Role role;
role = Role.Admin;
if(role == Role.Author) {
  //grant author access
}
switch(role) {
  case Admin:
    // admin
  case Anonymous:
    //guest access
  case Author:
  case Publisher:
}
System.out.println(role);
//prints: 'Admin'
```
#### values() and valuesOf() methods
- all enumerations contain two pre-defined methods

```java
public static enum-type [] values();
public static enum-type valueOf(String str);
```
#### Java Enumerations Are Class type
- can give them constructors, add instance variables and methods, and even implement interfaces.

```java
enum Role {
  Admin(1), Anonymous(0), Author(5), Publisher(6);
  private int roleId;
  Role(int r) { roleId = r ; }
  int getRoleId() { return roleId ; }
}

```
#### Enumerations inherit Enum
- can't inherit superclass when declaring an enum.
- all enumerations automatically inherit: __java.lang.Enum__
couple of more methods:
```java
final int ordial(); //constant's position
final int compareTo(enume-type e); //difference between two enums of same enumeration type.
final boolean equals(Object o); // true if both refer to same constant within same enumeration
```

#### Type Wrappers
- Double, Float, Long, Integer, Short, Byte, Character, and Boolean
- Character
```java
Character(char ch);
char charValue();
```
- Boolean
```java
Boolean(boolean boolValue);
Boolean(String boolString);
boolean booleanValue();
```
- The Numeric Type Wrappers - Byte, Short, Integer, Long, Float, Double
  - inherits abstract class __Number__

  ```java
  byte byteValue();
  double doubleValue();
  float floatValue();
  int intValue();
  long longValue();
  short shortValue();
  Integer(int num);
  Integer(String str);
  ```

#### Annotations
- supplimental information to the source file
- leaves the semantics of the program unchanged.
- aka _metadata_

```java
@interface MyAnnotation {
  String str();
  int val();
}
```
- only method declaration in annotation, Java implements these methods - acts like fields
- cannot include __extends__ clause.
- __Annotation__ is the super-interface of all Annotations.
  - overrides:
  ```java
  int hashCode();
  boolean equals(Object obj);
  String toString();
  Class<? extends Annotation> annotationType(); //additional
  ```
- can be associated with any type: classes, methods, fields, parameters, and enum constants, even annotations;
```java
@MyAnnotation(str = "Annotation Example", value = 100)
public static void myMethod() {
  //
}
```
#### Specifying a Retention Policy
- at what point an annotation is discarded
- __SOURCE__: retained only in source file, discarded during compilation
- __CLASS__: stored in .class file during compilation
- __RUNTIME__: stored in .class file and is available through the JVM during run time.

```Java
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
  String str();
  int val();
}
```

#### Obtaining Annotations at Run Time by Use of Reflection
- Reflection API: __java.lang.reflect__ package
- Steps:
  - obtain a __Class__ object that represents the class whose annotations you want to obtain
  - use __Class__'s methods to obtain information about the various items declared by the class
