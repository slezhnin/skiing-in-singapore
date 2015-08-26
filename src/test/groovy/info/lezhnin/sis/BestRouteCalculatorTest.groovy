package info.lezhnin.sis

/**
 * Test calculator.
 *
 * @author SBT-Lezhnin-SA
 * @since 2015.08.26
 */
class BestRouteCalculatorTest extends GroovyTestCase {
    Integer[][] map
    static final TEST_INPUT = '''4 4
4 8 7 3
2 5 9 3
6 3 2 5
4 4 1 6'''

    void setUp() {
        super.setUp()
        map = IntegerXYArrayDecoder.decode(new ByteArrayInputStream(TEST_INPUT.bytes))
    }

    void testPosition() {
        assert new MapPosition<Integer>(map, 0, 0).value == 4
        assert new MapPosition<Integer>(map, 0, 0).nearest.size() == 2
        assert new MapPosition<Integer>(map, 0, 3).nearest.size() == 2
        assert new MapPosition<Integer>(map, 3, 0).nearest.size() == 2
        assert new MapPosition<Integer>(map, 3, 3).nearest.size() == 2
        assert new MapPosition<Integer>(map, 1, 0).nearest.size() == 3
        assert new MapPosition<Integer>(map, 1, 1).nearest.size() == 4
    }

    void testRoute() {
        def position = new MapPosition<Integer>(map, 0, 0)
        assert position.nearest.size() == 2
        def result = new Route<Integer>(position).calculate()
        assert result.asString == '22'
    }

    void testCall() {
        def result = new BestRouteCalculator<Integer>(map)()
        assert result.asString == '58'
    }
}
