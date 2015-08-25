package info.lezhnin.sis

/**
 * Test decoder.
 *
 * @author Sergey Lezhnin
 * @since 2015.08.25
 */
class IntegerArrayFromURLDecoderTest extends GroovyTestCase {

    public static
    final String INPUT_URL = 'http://s3-ap-southeast-1.amazonaws.com/geeks.redmart.com/coding-problems/map.txt'

    void testDecode() {
        log.info "Max. memory: ${(Runtime.runtime.maxMemory() / 1024 / 1024) as int} Mb"
        log.info "Free memory: ${(Runtime.runtime.freeMemory() / 1024 / 1024) as int} Mb"
        log.info "Loading from URL: $INPUT_URL"
        def result = IntegerArrayFromURLDecoder.decode(new URL(INPUT_URL))
        log.info "Free memory: ${(Runtime.runtime.freeMemory() / 1024 / 1024) as int} Mb"
        assert result.length > 0
        assert result[0].length > 0
        log.info "Array[$result.length][${result[0].length}]"
    }
}
