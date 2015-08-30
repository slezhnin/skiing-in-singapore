package info.lezhnin.sis

/**
 * Represents position in the map.
 *
 * @author SBT-Lezhnin-SA
 * @since 2015.08.26
 */
class MapPosition<T> {
    final private T[][] map
    final int x
    final int y

    MapPosition(T[][] map, int x, int y) {
        this.map = map
        this.x = x
        this.y = y
        assert x >= 0 && x < map.length
        assert y >= 0 && y < map[0].length
    }

    T getValue() {
        map[x][y]
    }

    MapPosition<T> getNorth() {
        x > 0 ? new MapPosition<T>(map, x - 1, y) : null
    }

    MapPosition<T> getSouth() {
        x < map.length - 1 ? new MapPosition<T>(map, x + 1, y) : null
    }

    MapPosition<T> getEast() {
        y > 0 ? new MapPosition<T>(map, x, y - 1) : null
    }

    MapPosition<T> getWest() {
        y < map[x].length - 1 ? new MapPosition<T>(map, x, y + 1) : null
    }

    List<MapPosition<T>> getNearest() {
        [north, south, east, west].findAll { it != null }
    }

    @Override
    public String toString() {
        "MapPosition{x=$x,y=$y,value=$value}"
    }
}
