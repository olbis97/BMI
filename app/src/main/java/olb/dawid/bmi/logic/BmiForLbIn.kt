package olb.dawid.bmi.logic

class BmiForLbIn (var mass: Int, var height: Int) : Bmi {
    private val massRange = 44..440
    private val heightRange = 20..100

    override fun countBmi():Double{
        require(mass in massRange ) {"invalid mass (should be:44..max)"}
        require(height in heightRange) {"invalid height (should be:20..max)"}
        val bmi = mass * 703.0/ (height*height)
        return bmi
    }
}