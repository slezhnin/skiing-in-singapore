package info.lezhnin.sis

/**
 * Description...
 *
 * @author SBT-Lezhnin-SA
 * @since 2015.08.26
 */
class MapPositionIterator<T> implements Iterator<MapPosition<T>> {
    private final T[][] map
    private int x
    private int y

    MapPositionIterator(T[][] map) {
        this.map = map
        assert map.length
    }

    @Override
    boolean hasNext() {
        return x < map.length
    }

    @Override
    MapPosition next() {
        def result = new MapPosition(map, x, y)
        if (++y >= map[x].length) {
            y = 0
            ++x
        }
        result
    }
}
