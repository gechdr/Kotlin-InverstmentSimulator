package com.example.tugasm2_6958

// KRITERIA KHUSUS INHERITANCE
class PasarUang(name:String, price:Int, quantity:Int = 0,var rate:Int = 5): Reksadana(name = name, price = price, quantity = quantity) {

    var state: Int = -1

    fun updatePrice(state:Int){
        if (state == 0){
            price += (price * rate) / 100
        } else if (state == 1){
            price -= (price * rate) / 100
        }
    }

    override fun toString(): String {
        return "PasarUang(name='$name', price=$price, quantity=$quantity, rate=$rate)"
    }
}