package com.example.lista1

import kotlin.reflect.typeOf

fun wspolne(zbior1: MutableList<Any>, zbior2: MutableList<Any>): List<Any> {
    require(zbior1 != typeOf<MutableList<Any>>() || zbior2 != typeOf<MutableList<Any>>()){
        "Argumenty wejsciowe powinny byc listami."
    }
    var wspol: MutableList<Any> = mutableListOf()
    val i = zbior1.size - 1
    val j = zbior2.size - 1
    for (k in 0..i){
        for(l in 0..j){
            if(zbior1[k] == zbior2[l]){
                zbior2[l]?.let { wspol.add(it) }
            }
        }
    }
    return wspol.distinct()
}
fun main(){
    val lista1 = mutableListOf<Any>(1,2,2,3,6,5,6,635)
    val lista2 = mutableListOf<Any>(6,5,3,2,5,72,4,6,2)
    println("${wspolne(lista1, lista2)}")
}