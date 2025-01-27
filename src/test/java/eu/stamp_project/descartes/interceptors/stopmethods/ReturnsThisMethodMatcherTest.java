package eu.stamp_project.descartes.interceptors.stopmethods;

import eu.stamp_project.test.input.Calculator;
import eu.stamp_project.test.input.StopMethods;

import java.lang.reflect.Method;
import java.util.stream.Stream;

import static eu.stamp_project.test.MethodStreamBuilder.fromClass;

class ReturnsThisMethodMatcherTest extends MethodMatcherTest {

    @Override
    Stream<Method> toIntercept() throws NoSuchMethodException {
        return Stream.of(StopMethods.class.getDeclaredMethod("onlyReturnsThis"));
    }

    @Override
    Stream<Method> toAllow() throws NoSuchMethodException {
        return Stream.of(Calculator.class.getDeclaredMethod("getConditionalClone", boolean.class));
    }

    @Override
    StopMethodMatcher getMatcher() {
        return StopMethodMatchers.returnsThis();
    }
}
