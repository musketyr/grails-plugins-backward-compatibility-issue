package hasinterceptor


import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(TesterInterceptor)
class TesterInterceptorSpec extends Specification {

    def setup() {
    }

    def cleanup() {

    }

    void "Test tester interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"tester")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
