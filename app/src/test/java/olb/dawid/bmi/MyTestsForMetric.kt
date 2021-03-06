package olb.dawid.bmi

import io.kotlintest.shouldThrow
import io.kotlintest.specs.StringSpec
import olb.dawid.bmi.logic.BmiForKgCm
import org.junit.Assert

class MyTestsForMetric : StringSpec() {

    init{

        "for valid mass and height" {
            val bmi = BmiForKgCm(65,170)
            bmi.countBmi() shouldBeAround 22.491
        }
        "for valid mass and height sec" {
            val bmi = BmiForKgCm(20,50)
            bmi.countBmi() shouldBeAround 80.000
        }


        "when mass and height is invalid"{
            val bmi = BmiForKgCm(-1,0)
            shouldThrow<IllegalArgumentException> {bmi.countBmi() }
        }


        "for invalid mass and valid data"{
            val bmi = BmiForKgCm(-1, 160)
            shouldThrow<java.lang.IllegalArgumentException> {bmi.countBmi()  }
        }

        "for valid mass and invalid height"{
            val bmi = BmiForKgCm(60, -8)
            shouldThrow<java.lang.IllegalArgumentException> {bmi.countBmi()  }
        }

    }

    infix fun Double.shouldBeAround(value: Double){
        Assert.assertEquals(value, this, 0.001)
    }

}