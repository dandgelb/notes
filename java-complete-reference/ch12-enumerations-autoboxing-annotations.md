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