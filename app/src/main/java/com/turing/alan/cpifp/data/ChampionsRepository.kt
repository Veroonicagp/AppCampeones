package com.turing.alan.cpifp.data

interface ChampionsRepository {

    fun getChampions(): List<Champion>
    fun getOneChampion(id: Int): Champion

}