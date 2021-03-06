package com.blogspot.toomuchcoding.spock.subjcollabs

import com.blogspot.toomuchcoding.spock.subjcollabs.Subject
import spock.lang.Specification

class SettersInjectionNoCollaboratorsWithGenericsSpec extends Specification {

    public static final String TEST_METHOD_1 = "Test method 1"

    public static final String TEST_METHOD_2 = "Test method 2"

    List<Integer> listNotToBeInjected = Mock()

    List<SomeOtherClass> someOtherClassNotToBeInjected = Mock()

    List<SomeOtherClass> someOtherClassToBeInjected = Mock()

    List<SomeOtherClass> someOtherClass = Mock()

	@Subject
	SomeClass systemUnderTest

    def "should inject parameters into subject via setters"() {
        expect:
        systemUnderTest.someOtherClass == someOtherClass

        and:
        systemUnderTest.someOtherClassToBeInjected == someOtherClassToBeInjected
    }


    class SomeClass {
        List<SomeOtherClass> someOtherClass
        List<SomeOtherClass> someOtherClassToBeInjected
    }

    class SomeOtherClass {
        String someMethod() {
            "Some other class"
        }
    }

}


