package eu.stamp_project.descartes.interceptors.stopmethods;

import java.lang.reflect.Method;
import java.util.stream.Stream;

public class IsKotlinGeneratedSetterMatcherTest extends MethodMatcherTest {

    @Override
    Stream<Method> toIntercept() throws NoSuchMethodException {
        // Generated setter with null checks
        return Stream.of(tests.Person.class.getDeclaredMethod("setName", String.class));
    }

    @Override
    Stream<Method> toAllow() throws NoSuchMethodException {
        // This is also generated by the Kotlin compiler but it is a regular setter
        return Stream.of(tests.Person.class.getDeclaredMethod("setAge", int.class));
    }

    @Override
    StopMethodMatcher getMatcher() {
        return StopMethodMatchers.isKotlinGeneratedSetter();
    }
}
