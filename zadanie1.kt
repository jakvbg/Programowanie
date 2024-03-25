package com.example.lista1

import kotlin.math.sqrt

fun heron(a: Int, b: Int, c: Int): Double {
    require(a > 0 && b > 0 && c > 0){"Podaj dlugosci bokow wieksze niz zero."}
    if (a + b < c || b + c < a || c + a < b){
        println("Trojkat o podanych bokach nie istnieje.")
    }
    else{
    }
    val p = (a + b + c)*0.5
    return sqrt(p*(p - a)*(p - b)*(p - c))
}

fun main(){
    println("${heron(5, 5, 5)}")
    println("${heron(20, 5, 5)}")
    println("${heron(-5, 5, 5)}")
}
