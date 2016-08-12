package net.franckbenault.microbench;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.Date;

import org.openjdk.jmh.annotations.Benchmark;

public class MyBenchmark {

	  @Benchmark
	  public void empty() {

	  }
	  
	  private static final Field birthDate;
		private static final Field firstName;
		private static final Field lastName;


		static {
			try {
				Class<? extends Person> clazz = Person.class;
				firstName = clazz.getDeclaredField("firstName");
				lastName = clazz.getDeclaredField("lastName");
				birthDate = clazz.getDeclaredField("birthDate");
				Field.setAccessible(new AccessibleObject[] { firstName, lastName, birthDate }, true);

			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		@Benchmark
		public Object[] Immutable_DirectCall() {
			return directCall(newImmutablePerson());
		}

	

		@Benchmark
		public Object[] Immutable_With_Reflection() throws Exception {
			return _Reflection(newImmutablePerson());
		}


		private Person newImmutablePerson() {
			return new Person("John", "Doe", new Date());
		}



		private Object[] directCall(Person person) {
			String o = person.getFirstName();
			String o1 = person.getLastName();
			Date o2 = person.getBirthDate();
			return new Object[] { o, o1, o2 };

		}

		private Object[] _Reflection(Person person) throws Exception {
			Object o = firstName.get(person);
			Object o1 = lastName.get(person);
			Object o2 = birthDate.get(person);

			return new Object[] { o, o1, o2 };
		}



}
