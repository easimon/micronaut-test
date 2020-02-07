package io.micronaut.test.junit5;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.inject.Singleton;

import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
public class NestedMicronautTest {

    @Inject
    Dependency dependency;

    @Test
    void executedTest() { // passes
        assertTrue(dependency.isTrue());
    }

    @Nested
//    @Singleton
    class WhenNotAuthenticated {

//        @Inject
//        Dependency dependency;

        @Test
        void ignoredTest() { // never run
            assertTrue(dependency.isTrue());
        }

    }

    @Singleton
    static class Dependency {
        boolean isTrue() {
            return true;
        }
    }

}