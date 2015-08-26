package info.lezhnin.sis

/**
 * Test decoder.
 *
 * @author Sergey Lezhnin
 * @since 2015.08.25
 */
class IntegerXYArrayDecoderTest extends GroovyTestCase {

    static final TEST_INPUT = '''4 4
4 8 7 3
2 5 9 3
6 3 2 5
4 4 1 6'''

    void testDecode() {
        def stream = new ByteArrayInputStream(TEST_INPUT.bytes)
        def result = IntegerXYArrayDecoder.decode(stream)
        assert result.length == 4
        assert result*.length == [4, 4, 4, 4]
        assert  result[0] == [4, 8, 7, 3] as int[]
        assert  result[1] == [2, 5, 9, 3] as int[]
        assert  result[2] == [6, 3, 2, 5] as int[]
        assert  result[3] == [4, 4, 1, 6] as int[]
    }
}
