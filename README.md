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
Mapping by hand | 2 044 000 | simple code write by hand 
MapStruct | 1 885 000 | Compile time code generation
Selma | 1 836 000 | Compile time code generation
JMapper | 1 822 000 | byte code manipulation (javassist)
Orika | 110 000 | byte code generation (API java compiler)
ModelMapper | 10 400 | introspection
Dozer | 3 720 | introspection

## 05 toString

see the examples in the following the link :
https://antoniogoncalves.org/2015/06/30/who-cares-about-tostring-performance/

Framework | Performance (op/s) | Code Example 
--- | --- | ---
Manual toString() | 1 105 000 | "MyObject{att1=" + att1 + ", att2=" + att2 + ", att3=" + att3 + "}";
Project lombok | 1 077 000 | Nothing
Manual toString() with Object | 1 073 000 | "MyObjectWithObjectsToString{att1=" + Objects.toString(att1) +...
Manual toString() with StringBuilder | 452 000 | new StringBuilder("...).append(...
Guava | 180 000 | MoreObjects.toStringHelper(this).add("att1", att1) ...
CommonsLang3 reflexion | 54 400 | ReflectionToStringBuilder.toString(this);

