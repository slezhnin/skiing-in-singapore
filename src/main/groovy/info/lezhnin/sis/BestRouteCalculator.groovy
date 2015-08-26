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
        new RouteIterator<T>(new MapPositionIterator<T>(map)).inject(null) { Route<T> route, next ->
            next.calculate() > route ? next : route
        } as Route<T>
    }

    public static void main(String[] args) {
        println "BestRouteCaculator is calculating from URL: ${args[0]}"
        def start = System.currentTimeMillis()
        new URL(args[0]).withInputStream { stream ->
            println new BestRouteCalculator<Integer>(IntegerXYArrayDecoder.decode(stream))()
        }
        def duration = ((System.currentTimeMillis() - start) / 1000) as Integer
        println "Duration: $duration seconds"
    }
}
