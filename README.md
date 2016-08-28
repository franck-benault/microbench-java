# microbench-java
example with JMH tool for micro bechn in java

# Examples
## 04  mapper frameworks
Example (in French) here 
http://javaetmoi.com/2015/09/benchmark-frameworks-javas-mapping-objet/

For the following result, be careful with the cost of the initialization of the object.
So we have to cache some object to avoid useless and costly initialization.

Framework | Performance (op/s) | % with Fill input  |  Comment
--- | --- | --- | ---
Fill input (no mapping done) | 939 000 | 100  | reference if the mapping costs nothing
Fill by hand | 714 000 |  76  | simple code write by hand 
MapStruct | 727 000 | 77 | compile time code generation
JMapper | 637 000 | 68 | byte code manipulation (javassist)
