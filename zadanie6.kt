package com.example.lista1

import java.lang.IllegalArgumentException

/*
@Author: Jakub Główka
Funkcja komplement zwraca sekwencje matrycową nici kodującej DNA. Funkcja transkrybuj zwraca
sekwencje RNA dla nici kodującej DNA. Dla niepoprawnych danych wejsciowych funkcja zwraca błąd.
Args:
    dna (String) - nić kodująca DNA
Returns:
    matrix (String) - matrycowa nić DNA
    rna (String) - nić kodująca RNA
 */
fun komplement(dna: String): String{
    var matrix = ""
    for (elem in dna) {
        matrix += when (elem.toString()){ //Przypisanie zasadom DNA zasad im odpowiadających.
            //wzięto pod uwagę małe i duże litery.
            'A'.toString() -> 'T'
            'C'.toString() -> 'G'
            'G'.toString() -> 'C'
            'T'.toString() -> 'A'
            'a'.toString() -> 'T'
            'c'.toString() -> 'G'
            'g'.toString() -> 'C'
            't'.toString() -> 'A'
            //zwrócenie błędu gdy podano inne litery lub niepowraną sekwencję typu String
            else -> throw IllegalArgumentException("Wprowadź symbole opisujące zasady DNA.")
        }
    }
    return matrix.reversed() //Ustawienie odpowiadających zasad w kierunku przeciwnym.
}
fun transkrybuj(dna: String): String{
    var rna = ""
    for (elem in dna) {
        rna += when (elem.toString()){
            'A'.toString() -> 'U'
            'C'.toString() -> 'G'
            'G'.toString() -> 'C'
            'T'.toString() -> 'A'
            'a'.toString() -> 'U'
            'c'.toString() -> 'G'
            'g'.toString() -> 'C'
            't'.toString() -> 'A'
            else -> throw IllegalArgumentException("Wprowadź symbole opisujące zasady DNA.")
        }
    }
    return rna.reversed()
}

fun main(){
    println(komplement("AgcTAcgccaTGTGT"))
    println(transkrybuj("AgcTAcgccaTGTGT"))
    println(komplement("22222222"))
}


