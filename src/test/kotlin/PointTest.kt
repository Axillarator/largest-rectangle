import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class PointTest{

    companion object {
        @JvmStatic
        fun argumentsForCoordinateTest(): Stream<Arguments> =
            Stream.of(
                Arguments.of(0, 1, 1, 0, 0),
                Arguments.of(1, 1, 2, 0, 1),
                Arguments.of(2, 2, 2, 0, 1),
                Arguments.of(5, 8, 4, 5, 0),
                Arguments.of(11, 8, 4, 3, 1)
            )
    }

    @ParameterizedTest
    @MethodSource("argumentsForCoordinateTest")
    fun `set coordinates test`(location: Int, length: Int, height: Int, x: Int, y: Int){
        val somePoint = Point(true, location)
        somePoint.setCoordinates(height, length)
        assertEquals(x, somePoint.x)
        assertEquals(y, somePoint.y)
    }

    @Test
    fun `calculate potential rectangle size test`(){
        val somePoint5 = Point(true, 5)
        somePoint5.calculatePotentialRectangleSize(4,8)
        assertEquals(12, somePoint5.potentialRectangleSize)

        val somePoint15 = Point(true, 15)
        somePoint15.calculatePotentialRectangleSize(4,8)
        assertEquals(3, somePoint15.potentialRectangleSize)

        val somePoint16 = Point(true, 16)
        somePoint16.calculatePotentialRectangleSize(4,8)
        assertEquals(16, somePoint16.potentialRectangleSize)
    }
}
