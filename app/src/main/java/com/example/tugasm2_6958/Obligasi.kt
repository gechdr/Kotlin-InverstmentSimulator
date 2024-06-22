package com.example.tugasm2_6958

// KRITERIA KHUSUS INHERITANCE
class Obligasi(name:String, price:Int, var due:String, quantity:Int = 0, var rate:Int = 10): Reksadana(name = name, price = price, quantity = quantity){

    var state: Int = -1

    fun updatePrice(state:Int){
        if (state == 0){
            price += (price * rate) / 100
        } else if (state == 1){
            price -= (price * rate) / 100
        }
    }

    override fun toString(): String {
        return "Obligasi(name='$name', price=$price, quantity=$quantity, due='$due', rate=$rate)"
    }
}