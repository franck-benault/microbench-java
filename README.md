# microbench-java
example with JMH tool for micro bechn in java

# Examples
## 02 logging

Framework | Performance (op/s) | Code Example 
--- | --- | ---
concatenation | 157 000 | logger.debug("Concatenating strings " + a + b + b);
Variable arguments | 1 482 000 | logger.debug("Variable arguments {} {} {}", a , b , c);
Variable arguments and isDebugEnabled | 1 678 000 | if (logger.isDebugEnabled()) logger.debug("Variable arguments {} {} {}", a , b , c);
 

## 04  mapper frameworks
Example (in French) here 
http://javaetmoi.com/2015/09/benchmark-frameworks-javas-mapping-objet/

For the following result, be careful with the cost of the initialization of the object.
So we have to cache some object to avoid useless and costly initialization.
You can see that the frameworks using introspection are less efficient. 

Framework | Performance (op/s) |  Comment
--- | --- | ---
Mapping by hand | 1 874 000 | simple code write by hand 
Selma | 1 804 000 | Compile time code generation
MapStruct | 1 786 000 | Compile time code generation
JMapper | 1 721 000 | byte code manipulation (javassist)
Orika | 115 000 | byte code generation (API java compiler)
ModelMapper | 9 870 | introspection
Dozer | 3 660 | introspection

## 05 toString

see the examples in the following the link :
https://antoniogoncalves.org/2015/06/30/who-cares-about-tostring-performance/

Framework | Performance (op/s) | Code Example 
--- | --- | ---
Manual toString() | 1 040 000 | "MyObject{att1=" + att1 + ", att2=" + att2 + ", att3=" + att3 + "}";
Manual toString() with Object | 1 079 000 | "MyObjectWithObjectsToString{att1=" + Objects.toString(att1) +...
Project lombok | 1 040 000 | Nothing
Manual toString() with StringBuilder | 430 000 | new StringBuilder("...).append(...
Guava | 177 000 | MoreObjects.toStringHelper(this).add("att1", att1) ...
CommonsLang3 reflexion | 53 500 | ReflectionToStringBuilder.toString(this);

