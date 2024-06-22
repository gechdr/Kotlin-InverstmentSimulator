package com.example.tugasm2_6958

open class Reksadana(var name: String, var price: Int, var quantity: Int) {

    var boughtPrice: Int = price

    override fun toString(): String {
        return "Reksadana(name='$name', price=$price, quantity=$quantity)"
    }
}