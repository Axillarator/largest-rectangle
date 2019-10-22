import java.util.*

class Matrix(private val height: Int, private val length: Int) {

    private val values = setValues()

    private fun setValues(): Array<Point>{
        val booleans = Array<Point>(height * length) {Point(true)}
        for (i in booleans.indices) {
            booleans[i] = Point(Random().nextBoolean())
        }
        return booleans
    }

    override fun toString(): String {
        var resultString = ""
        for (i in values.indices){
            if(i % this.length == 0) {
                resultString += "\n"
            }
            resultString += values[i].toString() + "\t"
        }
        return resultString
    }
}