package com.example.lista1

import kotlin.math.pow
/*
@Author: Jakub Główka, na podstawie rozwiązania Mikołaja Kikolskiego
Funkcja zwraca wszystkie podzbiory podanego zbioru elementów
Args:
    zbior (Set) - lista podanych elementów z ktorych tworzone sa podzbiory
Returns:
    zbiory (Set(Set)) - lista podzbiorów
 */
fun podzbiory(zbior: Set<Int>): Set<Set<Int>>{
    val zbiory = mutableSetOf<MutableSet<Int>>()
    val i = 2.0.pow(zbior.size).toInt() - 1 // podzbiory mozemy traktowac jako funkcje potegową, tzn.
    // dla danej liczby elementow wejsciowych powstanie n^2 - 1 podzbiorow. Metodę 2.0.pow.
    // (druga potęga [Double] wykorzystujemy aby uzyskac parametr zwiazany z iloscia elementow
    // w wynikowym zbiorze.
    for (elem in 0..i){
        val podzbior = mutableSetOf<Int>() //Tworzenie kolejnych podzbiorow
        for (j in zbior.indices){ //indices jest to metoda w kotlinie zwracajaca liczbę indeksow
            //danego obiektu, w tym przypadku setu. Zwieksza ona czytelnosc kodu.
            if ((elem and (1 shl j)) > 0){ //operacja shl związana jest z bitowym przesunieciem w lewo.
                //Kazdemu elementowi zbioru wejsciowego przypisywany jest bit np. element 3 moze miec
                // wartosc 0010. Nastepnie iterujac metoda tworzy i dodaje podzbiory z bitowymi elementami
                //do zbioru wyjsciowego za pomocą metody elementAt.
                podzbior.add(zbior.elementAt(j))
            }
        }
        zbiory.add(podzbior)
    }
    return zbiory
}

fun main(){
   val n = setOf<Int>(1,2,3)
    println("${podzbiory(n)}")
}