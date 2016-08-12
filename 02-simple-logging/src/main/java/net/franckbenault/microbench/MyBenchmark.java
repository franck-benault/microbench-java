package net.franckbenault.microbench;

import org.openjdk.jmh.annotations.Benchmark;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyBenchmark {

  private static final Logger logger = LoggerFactory.getLogger(MyBenchmark.class);

  @Benchmark
  public void empty() {

  }
  
  @Benchmark
  public void testConcatenatingStrings() {
      String x = "", y = "", z = "";

      for (int i = 0; i < 100; i++) {
          x += i; y += i; z += i;

          logger.debug("Concatenating strings " + x + y + z);
      }
  }

  @Benchmark
  public void testVariableArguments() {

      String x = "", y = "", z = "";

      for (int i = 0; i < 100; i++) {
          x += i; y += i; z += i;
          logger.debug("Variable arguments {} {} {}", x, y, z);
      }
  }

  @Benchmark
  public void testIfDebugEnabled() {

      String x = "", y = "", z = "";

      for (int i = 0; i < 100; i++) {
          x += i; y += i; z += i;

          if (logger.isDebugEnabled())
              logger.debug("If debug enabled {} {} {}", x, y, z);
      }
  }
}
