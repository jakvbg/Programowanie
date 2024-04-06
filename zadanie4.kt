package com.example.lista1

/*
@Author: Jakub Główka
Funkcje w sposób iteracyjny oraz rekurencyjny zwracaja ciąg Fibonacciego dla danej liczby elementów
ciągu.
Args:
    n (Int) - liczba elementow ciągu Fibonacciego.
Returns:
    fibo (List) - lista z elementami ciągu
    (Int) - dany element ciągu
 */
fun FibbonaciIter(n: Int): List<Int> {
    require(n >= 0) {"Podaj jako argument liczbe naturalna." }
    val fibo = mutableListOf<Int>()
    //kazdy ciag zaczyna sie od elementow 0 i 1 dlatego dla tych wartosci metoda zwraca inny wynik.
    fibo += 0
    when (n) {
        0 -> {
            return fibo
        }
        1 -> {
            fibo += 1
            return fibo
        }
        else -> {
            fibo += 1
            for (k in 0..n-2){ //n-2 poniewaz dwa pierwsze elementy ciagu sa juz dodane (0 i 1)
                fibo.add(fibo[k] + fibo[k+1])
            }
        }
    }
    return fibo
}

fun FibonacciRekur(n: Int): Int{
    //Wywolanie rekurencyjne funkcji odbywa się w programie (fun main)
    require(n >= 0){"Podaj jako argument liczbe naturalna."}
    return if (n <= 1) {
        n
    } else {
        FibonacciRekur(n - 1) + FibonacciRekur(n - 2)
    }
}

fun main(){
    val test1 = FibbonaciIter(8)
    val n = 8
    println(test1)
    //Wywolanie wszystkich elementow dla metody rekursyjnej.
    for (i in 1..n)
        println(FibonacciRekur(i).toString())
}