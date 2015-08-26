package info.lezhnin.sis

/**
 * Route iterator from MapPositionIterator.
 *
 * @author SBT-Lezhnin-SA
 * @since 2015.08.26
 */
class RouteIterator<T extends Number> implements Iterator<Route<T>> {
    private final MapPositionIterator<T> mapPositionIterator

    RouteIterator(MapPositionIterator<T> mapPositionIterator) {
        this.mapPositionIterator = mapPositionIterator
    }

    @Override
    boolean hasNext() {
        return mapPositionIterator.hasNext()
    }

    @Override
    Route<T> next() {
        return new Route<T>(mapPositionIterator.next())
    }
}
