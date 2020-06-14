package com.faramarz.kotlinapp

class ConversionUtil {

    object CToF {
        fun convert(temp: Float): Float {
            return (temp * 9) / 5 + 32
        }
    }

    object FToC {
        fun convert(temp: Float): Float {
            return (temp - 32) * 5 / 9
        }
    }

    object KToC {
        fun convert(temp: Float): Float {
            return temp - 273.15f
        }
    }

}