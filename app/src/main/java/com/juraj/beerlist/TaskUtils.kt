package com.juraj.beerlist


const val vowels = "aeiouAEIOU"

fun safeDivide(a: Int?, b: Int?) = b?.let { a?.div(b) }

fun String.countVowels() = count { it in vowels }