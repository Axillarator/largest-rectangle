import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class PointTest{

    @ParameterizedTest
    @MethodSource("argumentsForCoordinateTest")
    fun `set coordinates test`(location: Int, length: Int, height: Int, x: Int, y: Int){
        val somePoint = Point(true, location)
        somePoint.setCoordinates(height, length)
        assertEquals(x, somePoint.x)
        assertEquals(y, somePoint.y)
    }

    @ParameterizedTest
    @MethodSource("argumentsForPotentialRectangleSize")
    fun `calculate potential rectangle size test`(data: TestData){
        val somePoint5 = Point(true, data.indexLocation)
        somePoint5.calculatePotentialRectangleSize(data.height,data.length)
        assertEquals(data.potentialRectangleSize, somePoint5.potentialRectangleSize)
    }
    data class TestData(
        val indexLocation: Int,
        val height: Int,
        val length: Int,
        val potentialRectangleSize: Int) {
    }

    companion object {
        @JvmStatic
        private fun argumentsForCoordinateTest(): Stream<Arguments> =
            Stream.of(
                Arguments.of(0, 1, 1, 0, 0),
                Arguments.of(1, 1, 2, 0, 1),
                Arguments.of(2, 2, 2, 0, 1),
                Arguments.of(5, 8, 4, 5, 0),
                Arguments.of(11, 8, 4, 3, 1)
            )

        @JvmStatic
        private fun argumentsForPotentialRectangleSize() = Stream.of(
            TestData(5,4,8,12),
            TestData(15,4,8,3),
            TestData(16,4,8,16)
        )
    }
}