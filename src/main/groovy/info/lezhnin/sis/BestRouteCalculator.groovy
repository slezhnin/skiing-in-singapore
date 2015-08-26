package info.lezhnin.sis

import java.util.concurrent.Callable

/**
 * Calculates the best longest route from highest point to the lowest point.
 *
 * @author SBT-Lezhnin-SA
 * @since 2015.08.26
 */
class BestRouteCalculator<T extends Number> implements Callable<Route> {
    final T[][] map

    BestRouteCalculator(T[][] map) {
        this.map = map
    }

    @Override
    Route<T> call() throws Exception {
        new MapPositionIterator<T>(map).inject(null) { Route<T> route, position ->
            def nextRoute = new Route<T>(position).calculate()
            nextRoute > route ? nextRoute : route
        } as Route<T>
    }
}
