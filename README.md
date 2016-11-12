# microbench-java
example with JMH tool for micro bechn in java

# Examples
## 02 logging

Framework | Performance (op/s) | Code Example 
--- | --- | ---
concatenation | 76 084 | logger.debug("Concatenating strings " + a + b + b);
Variable arguments | 1 519 000 | logger.debug("Variable arguments {} {} {}", a , b , c);
Variable arguments and isDebugEnabled | 1 831 000 | if (logger.isDebugEnabled()) logger.debug("Variable arguments {} {} {}", a , b , c);
 

## 04  mapper frameworks
Example (in French) here 
http://javaetmoi.com/2015/09/benchmark-frameworks-javas-mapping-objet/

For the following result, be careful with the cost of the initialization of the object.
So we have to cache some object to avoid useless and costly initialization.
You can see that the frameworks using introspection are less efficient. 

Framework | Performance (op/s) | % with Fill input  |  Comment
--- | --- | --- | ---
Fill input (no mapping done) | 939 000 | 100  | reference if the mapping costs nothing
Mapping by hand | 714 000 |  76  | simple code write by hand 
Selma | 746 000 | 79 | Compile time code generation
MapStruct | 727 000 | 77 | Compile time code generation
JMapper | 637 000 | 68 | byte code manipulation (javassist)
Orika | 93 400 | 9.9 | byte code generation (API java compiler)
ModelMapper | 10 200 | 1.1 | introspection
Dozer | 3 400 | 0.37 | introspection

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

