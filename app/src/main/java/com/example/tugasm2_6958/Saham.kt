package com.example.tugasm2_6958

// KRITERIA KHUSUS INHERITANCE
class Saham(name:String, price:Int, var companyName:String, quantity:Int = 0, var rate:Int = 15): Reksadana(name = name, price = price, quantity = quantity){

    var state: Int = -1

    fun updatePrice(state:Int){
        if (state == 0){
            price += (price * rate) / 100
        } else if (state == 1){
            price -= (price * rate) / 100
        }
    }

    override fun toString(): String {
        return "Saham(name='$name', price=$price, quantity=$quantity, companyName='$companyName', rate=$rate)"
    }
}