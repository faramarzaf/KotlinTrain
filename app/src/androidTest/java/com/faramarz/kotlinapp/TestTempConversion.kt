package com.faramarz.kotlinapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.faramarz.kotlinapp.utils.TempConversion
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TestTempConversion {
    @Test
    fun testCToF() {
        Assert.assertEquals(32f, TempConversion.CToF.convert(0f))
    }

    @Test
    fun testCToK() {
        Assert.assertEquals(273.15f, TempConversion.CToK.convert(0f))
    }

    @Test
    fun testFToC() {
        Assert.assertEquals(-17.777779f, TempConversion.FToC.convert(0f))
    }

    @Test
    fun testFToK() {
        Assert.assertEquals(255.3722222222f, TempConversion.FToK.convert(0f))
    }

    @Test
    fun testKToC() {
        Assert.assertEquals(-273.15f, TempConversion.KToC.convert(0f))
    }

    @Test
    fun testKToF() {
        Assert.assertEquals(-459.67f, TempConversion.KToF.convert(0f))
    }
}