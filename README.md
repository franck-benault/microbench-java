# microbench-java
example with JMH tool for micro bechn in java

# Examples
## 04  mapper frameworks
Example (in French) here 
http://javaetmoi.com/2015/09/benchmark-frameworks-javas-mapping-objet/



Framework | Performance (op/s) | % with Fill input  |  Comment
--- | --- | --- | ---
Fill input (no mapping done) | 939 000 | 100  | reference if the mapping costs nothing
Fill by hand | 714 000 |  76  | simple code write by hand 
JMapper | 637 000 | 68 | byte code manipulation (javassist)
