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
