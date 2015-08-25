package info.lezhnin.sis

/**
 * Array decoder from URL content.
 * Format:
 * SizeX SizeY
 * N0..0 N0..SizeY
 * ..
 * NSizeX..0 NSizeX..SizeY
 *
 * @author Sergey Lezhnin
 * @since 2015.08.25
 */
class IntegerArrayFromURLDecoder {
    static int[][] decode(URL url) {
        url.withReader { reader ->
            def size = reader.readLine().split().collect { Integer.valueOf(it) }
            def result = new int[size[0]][size[1]]
            def index = 0
            reader.eachLine { line ->
                line.split().eachWithIndex { String number, int i ->
                    result[index][i] = Integer.valueOf(number)
                }
                ++index
            }
            result
        }
    }
}
