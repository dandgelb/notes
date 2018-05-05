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
