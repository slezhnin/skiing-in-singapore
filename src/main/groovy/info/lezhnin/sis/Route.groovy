package info.lezhnin.sis

/**
 * Represents the route by height list on the map.
 *
 * @author SBT-Lezhnin-SA
 * @since 2015.08.26
 */
class Route<T extends Number> implements Comparable<Route> {
    private final heights = new LinkedList<T>()
    final MapPosition<T> position

    Route(MapPosition<T> position) {
        this.position = position
    }

    Route leftShift(T height) {
        addHeight height
        this
    }

    void addHeight(T height) {
        heights << height
    }

    T getElevation() {
        heights.size() ? heights.first() - heights.last() : 0
    }

    int getLength() {
        return heights.size()
    }

    String getAsString() {
        "$length$elevation"
    }

    Route<T> calculate() {
        heights.clear()
        heights << position.value
        def nextHeights = position.nearest.findAll {
            it.value < position.value
        }.collect {
            new Route<T>(it).calculate()
        }.max()?.heights
        if (nextHeights) heights.addAll nextHeights
        this
    }

    @Override
    public String toString() {
        return """\
Route{
    heights=$heights,
    length=$length,
    elevation=$elevation,
    position=$position,
    asString=$asString
}"""
    }

    @Override
    int compareTo(Route o) {
        if (o == null || length > o.length || (length == o.length && elevation > o.elevation)) return 1
        if (length == o.length && elevation == o.elevation) return 0
        return -1
    }
}
