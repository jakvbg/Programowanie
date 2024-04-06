package com.example.lista1
/*
@Author: Jakub Główka
Funkcja zwraca elementy ciągu Collatza.
Args:
    n (Int) - element wejściowy ciągu
Returns:
    cycle (List) - lista z elementami ciągu
 */
fun collatz(n: Int): List<Int> {
    require(n >= 0) {"Podaj jako argument liczbe naturalna." }
    val koniec = listOf(4,2,1)
    var cycle = mutableListOf<Int>()
    cycle += n
    while (cycle.takeLast(3) != koniec){ //Porownanie 3 ostatnich elementow listy z petla
        if (cycle.last() % 2 == 0){//Sprawdzenie czy ostatni element jest podzielny przez 2 oraz
            //dopisanie nowego elementu do konca listy.
            cycle.add((0.5*cycle.last()).toInt())
    }else{
        cycle.add(3*cycle.last() + 1)
        }
    }
    return cycle
}

fun main(){
    val n = 1000
    println(collatz(n).toString())
    println("Maksymalna wartosc ciągu colatza dla zadanego n wynosi:" +
            "${collatz(n).max()} oraz dlugosc ciągu przed wpadnieciem w cykl wynosi:" +
            "${collatz(n).size}.")
}