class Point(private val value: Boolean, private val indexLocation: Int){

    var potentialRectangleSize: Int = 1
    var x: Int = 0
    var y: Int = 0

    fun setCoordinates(height: Int, length: Int) {
        x = indexLocation % length
        y = indexLocation / length
    }

    fun calculatePotentialRectangleSize(height: Int, length: Int) {
        setCoordinates(height, length)
        this.potentialRectangleSize = (height-y)*(length-x)
    }

    override fun toString(): String {
        return value.toString();
    }
}