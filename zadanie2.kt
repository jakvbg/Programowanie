package com.example.lista1

import kotlin.reflect.typeOf

/*
@Author: Jakub Główka
Funkcja zwraca część wspólną dwóch multizbiorów.
Args:
    zbior1, zbior2 (List) - zbiory, które są porównywane
Returns:
    wspol (List) - lista ze wspólnymi elementami zbiorów
 */
fun wspolne(zbior1: List<Any>, zbior2: List<Any>): List<Any> {
    require(zbior1 != typeOf<List<Any>>() || zbior2 != typeOf<List<Any>>()){
        "Argumenty wejsciowe powinny byc listami."
    }
    //Funkcja wykorzystuje mapy, ktore kazdej wartosci przypisuja ich liczbę wystąpienia w danym
    //multizbiorze (key - element; value - liczba wystapienia w zbiorze)
    val wspol: MutableList<Any> = mutableListOf()
    val zbior1map = zbior1.groupingBy { it }.eachCount()
    val zbior2map = zbior2.groupingBy { it }.eachCount()
    for ((k, v) in zbior1map){
        val wspolelem = zbior2map[k]?: 0 //zwrocenie elementu drugiej mapy
        val wystapienia = minOf(v, wspolelem)//Porownanie wystapienia liczby elementow w dwoch zbiorach
        for (i in 0..< wystapienia){ //Dodanie do listy wynikowej powtarzajacych sie elementow
            // w odpowiednich ilosciach
            wspol.add(k)
        }

    }
    return wspol
}
fun main(){
    val lista1 = mutableListOf<Any>(1,2,2,3,6,5,6,635)
    val lista2 = mutableListOf<Any>(6,5,3,2,5,72,4,6,2)
    println("${wspolne(lista1, lista2)}")
}