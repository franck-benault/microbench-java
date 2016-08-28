# microbench-java
example with JMH tool for micro bechn in java

# Examples
## 04  mapper frameworks
Example (in French) here 
http://javaetmoi.com/2015/09/benchmark-frameworks-javas-mapping-objet/

For the following result, be careful with the cost of the initialization of the object.
So we have to cache some object to avoid useless and costly initialization.
You can see that the frameworks using introspection are less efficient. 

Framework | Performance (op/s) | % with Fill input  |  Comment
--- | --- | --- | ---
Fill input (no mapping done) | 939 000 | 100  | reference if the mapping costs nothing
Fill by hand | 714 000 |  76  | simple code write by hand 
Selma | 746 000 | 79 | Compile time code generation
MapStruct | 727 000 | 77 | Compile time code generation
JMapper | 637 000 | 68 | byte code manipulation (javassist)
Orika | 93 400 | 9.9 | byte code generation (API java compiler)
ModelMapper | 10 200 | 1.1 | introspection
Dozer | 3 400 | 0.37 | introspection
