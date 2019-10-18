import java.util.*

class Matrix(private val height: Int, private val length: Int) {

    val values = setValues()

    private fun setValues(): BooleanArray{

        val booleans = BooleanArray(height * length)

        for (i in booleans.indices) {
            booleans[i] = Random().nextBoolean()
        }
        return booleans
    }

    override fun toString(): String {
        var result = ""
        for (i in values.indices){
            if(i % this.length == 0) {
                result += "\n"
            }
            result += values[i].toString() + "\t"
        }
        return result
    }
}