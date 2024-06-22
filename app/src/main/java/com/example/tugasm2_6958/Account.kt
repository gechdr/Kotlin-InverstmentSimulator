package com.example.tugasm2_6958

class Account(var username:String, var password:String, var idCardNumber:String, var name:String, var gender:String, var balance:Int = 0){

    // KRITERIA KHUSUS POLYMORPHISM
    var stocks: ArrayList<Reksadana> = arrayListOf()

    fun addBalance(amount:Int){
        balance += amount
    }

    fun addStock(stock:Reksadana){
        stocks.add(stock)
    }

    companion object {

        var count: Int = 1;

        fun addCount(){
            count++
        }

        fun addBulkCount(amount:Int){
            count += amount
        }
    }
}