package com.example.tugasm2_6958

fun main(args: Array<String>) {
    println("Tugas M2 - 221116958")

    // ======================================================================================================================================

    val arrAccount: ArrayList<Account> = arrayListOf()

    // KRITERIA KHUSUS POLYMORPHISM
    val arrReksadana: ArrayList<Reksadana> = arrayListOf()

    var day = 1

    // DUMMY
    arrAccount.add(Account("user1", "123", "1234567", "User A", "L", 1000000))
    arrAccount.add(Account("user2", "123", "7654321", "User B", "P", 500000))

    // KRITERIA KHUSUS COMPANION OBJECT
    Account.addBulkCount(2)

    arrReksadana.add(PasarUang("Sucorinvest Money Market Fund", 10000))
    arrReksadana.add(PasarUang("Dana Pensiun", 20000))
    arrReksadana.add(Obligasi("Obligasi Negara", 30000, "1 Tahun"))
    arrReksadana.add(Obligasi("Sucorinvest Stable Fund", 7500, "12 Bulan"))
    arrReksadana.add(Saham("BNI IDX30", 15000, "BNI"))

    do {
        println("")
        println("=============")
        println("|   BIBIT   |")
        println("=============")
        println("1. Login")
        println("2. Register")
        println("3. Exit")
        print(">> ")

        val log = readln()

        when (log) {
            "1" -> {
                println("=== Login ===")
                print("Username: ")
                val username = readln()
                print("Password: ")
                val password = readln()

                if (username == "admin" && password == "admin") {
                    println("")
                    do {
                        println("Welcome, Admin")
                        println("1. Tambah Reksadana")
                        println("2. List Reksadana")
                        println("3. Ganti Hari")
                        println("4. Logout")
                        print(">> ")

                        val inptAdmin = readln()

                        when(inptAdmin) {
                            "1" -> {
                                println("=== Tambah Reksadana ===")
                                println("1. Pasar Uang")
                                println("2. Obligasi")
                                println("3. Saham")
                                print(">> ")

                                val inptAdd = readln()

                                when (inptAdd) {
                                    "1" -> {
                                        // Pasar Uang
                                        println("=== Tambah Pasar Uang ===")

                                        print("Nama : ")
                                        val name = readln()
                                        if (name == ""){
                                            println("Nama tidak boleh kosong!")
                                            continue
                                        } else if (arrReksadana.any { it.name == name }){
                                            println("Reksadana $name sudah ada!")
                                            continue
                                        }

                                        print("Harga saat ini : ")
                                        val price = readln()
                                        if (price == ""){
                                            println("Harga tidak boleh kosong!")
                                            continue
                                        } else if (price.toIntOrNull() == null){
                                            println("Harga harus berupa angka!")
                                            continue
                                        }

                                        arrReksadana.add(PasarUang(name, price.toInt()))

                                        println("Berhasil tambah pasar uang!")

                                    }
                                    "2" -> {
                                        // Obligasi
                                        println("=== Tambah Obligasi ===")

                                        print("Nama : ")
                                        val name = readln()
                                        if (name == ""){
                                            println("Nama tidak boleh kosong!")
                                            continue
                                        } else if (arrReksadana.any { it.name == name }){
                                            println("Reksadana $name sudah ada!")
                                            continue
                                        }

                                        print("Harga saat ini : ")
                                        val price = readln()
                                        if (price == ""){
                                            println("Harga tidak boleh kosong!")
                                            continue
                                        } else if (price.toIntOrNull() == null){
                                            println("Harga harus berupa angka!")
                                            continue
                                        }

                                        print("Jatuh tempo dalam : ")
                                        val due = readln()
                                        if (due == ""){
                                            println("Jatuh tempo tidak boleh kosong!")
                                            continue
                                        }

                                        arrReksadana.add(Obligasi(name, price.toInt(), due))

                                        println("Berhasil tambah obligasi!")
                                    }
                                    "3" -> {
                                        // Saham
                                        println("=== Tambah Saham ===)")

                                        print("Nama : ")
                                        val name = readln()
                                        if (name == ""){
                                            println("Nama tidak boleh kosong!")
                                            continue
                                        } else if (arrReksadana.any { it.name == name }){
                                            println("Reksadana $name sudah ada!")
                                            continue
                                        }

                                        print("Harga saat ini : ")
                                        val price = readln()
                                        if (price == ""){
                                            println("Harga tidak boleh kosong!")
                                            continue
                                        } else if (price.toIntOrNull() == null){
                                            println("Harga harus berupa angka!")
                                            continue
                                        }

                                        print("Nama Perusahaan : ")
                                        val companyName = readln()
                                        if (companyName == ""){
                                            println("Nama perusahaan tidak boleh kosong!")
                                            continue
                                        }

                                        arrReksadana.add(Saham(name, price.toInt(), companyName))

                                        println("Berhasil tambah saham!")
                                    }
                                    else -> {
                                        println("Invalid Input")
                                    }
                                }
                            }
                            "2" -> {
                                println("=== Daftar Reksadana ===")

                                val tempPasarUang = arrReksadana.filterIsInstance<PasarUang>()
                                val tempObligasi = arrReksadana.filterIsInstance<Obligasi>()
                                val tempSaham = arrReksadana.filterIsInstance<Saham>()

                                var index = 1

                                for (reksadana in tempPasarUang.sortedBy { it.price }) {
                                    println("$index. [Pasar Uang] ${reksadana.name} - Rp. ${reksadana.price}")
                                    index++
                                }
                                for (reksadana in tempObligasi.sortedBy { it.price }) {
                                    println("$index. [Obligasi] ${reksadana.name} - Rp. ${reksadana.price}")
                                    index++
                                }
                                for (reksadana in tempSaham.sortedBy { it.price }) {
                                    println("$index. [Saham] ${reksadana.name} - Rp. ${reksadana.price}")
                                    index++
                                }
                            }
                            "3" -> {
                                println("Ganti Hari")

                                val rndPasar = (0..1).random()
                                val rndObligasi = (0..1).random()
                                val rndSaham = (0..1).random()

                                // List Reksadana
                                for (reksadana in arrReksadana) {
                                    when (reksadana) {
                                        is PasarUang -> {
                                            reksadana.updatePrice(rndPasar)
                                            reksadana.state = rndPasar
                                        }

                                        is Obligasi -> {
                                            reksadana.updatePrice(rndObligasi)
                                            reksadana.state = rndObligasi
                                        }

                                        is Saham -> {
                                            reksadana.updatePrice(rndSaham)
                                            reksadana.state = rndSaham
                                        }
                                    }
                                }

                                // Update Stock Users
                                for (user in arrAccount) {
                                    for (stock in user.stocks) {
                                        when (stock) {
                                            is PasarUang -> {
                                                stock.updatePrice(rndPasar)
                                            }

                                            is Obligasi -> {
                                                stock.updatePrice(rndObligasi)
                                            }

                                            is Saham -> {
                                                stock.updatePrice(rndSaham)
                                            }
                                        }
                                    }
                                }
                                day++
                            }
                            "4" -> {
                                println("Logout")
                            }
                            else -> {
                                println("Invalid Input")
                            }
                        }
                        println("")
                    } while (inptAdmin != "4")
                } else {
                    val user = arrAccount.find { it.username == username && it.password == password }
                    if (user != null) {
                        println("")
                        do {
                            println("Welcome, " + user.name)
                            println("Uang anda di hari $day : Rp " + user.balance)
                            println("Mau investasi apa hari ini?")
                            println("1. Beli Reksadana")
                            println("2. Jual Reksadana")
                            println("3. Top up")
                            println("4. Laporan pergerakan harga")
                            println("5. Logout")
                            print(">> ")

                            val inptUser = readln()

                            when(inptUser) {
                                "1" -> {
                                    println("=== Daftar Reksadana ===")

                                    val sortedList = sortListReksadana(arrReksadana)

                                    for (reksadana in sortedList.withIndex()) {
                                        println("${reksadana.index + 1}. ${reksadana.value.name} - Rp. ${reksadana.value.price}")
                                    }

                                    print(">> ")

                                    val inptBuy = readln()

                                    if (inptBuy.toIntOrNull() == null){
                                        println("Invalid Input")
                                        continue
                                    } else if (inptBuy.toInt() < 1 || inptBuy.toInt() > sortedList.size){
                                        println("Invalid Input")
                                        continue
                                    }

                                    val selectedReksadana = sortedList[inptBuy.toInt() - 1]

                                    print("Jumlah : ")
                                    val quantity = readln()

                                    if (quantity.toIntOrNull() == null){
                                        println("Jumlah harus berupa angka!")
                                        continue
                                    } else if (quantity.toInt() < 1){
                                        println("Jumlah minimal harus 1!")
                                        continue
                                    }

                                    println("Total Rp. " + (selectedReksadana.price * quantity.toInt()))

                                    if (user.balance < (selectedReksadana.price * quantity.toInt())){
                                        println("Saldo tidak cukup!")
                                        continue
                                    }

                                    user.addBalance(-(selectedReksadana.price * quantity.toInt()))

                                    when (selectedReksadana) {
                                        is PasarUang -> {
                                            user.addStock(PasarUang(selectedReksadana.name, selectedReksadana.price, quantity.toInt()))
                                        }

                                        is Obligasi -> {
                                            user.addStock(Obligasi(selectedReksadana.name, selectedReksadana.price, selectedReksadana.due, quantity.toInt()))
                                        }

                                        is Saham -> {
                                            user.addStock(Saham(selectedReksadana.name, selectedReksadana.price, selectedReksadana.companyName, quantity.toInt()))
                                        }
                                    }

                                    println("Berhasil beli!")
                                }
                                "2" -> {
                                    println("=== Portofolio Saya ===")

                                    val sortedList = sortListReksadana(user.stocks)

                                    for (reksadana in sortedList.withIndex()) {
                                        when (reksadana.value) {
                                            is PasarUang -> {
                                                println("${reksadana.index + 1}. [Pasar Uang] ${reksadana.value.name} - Rp. ${reksadana.value.price} - ${reksadana.value.quantity}x")
                                            }

                                            is Obligasi -> {
                                                println("${reksadana.index + 1}. [Obligasi] ${reksadana.value.name} - Rp. ${reksadana.value.price} - ${reksadana.value.quantity}x")
                                            }

                                            is Saham -> {
                                                println("${reksadana.index + 1}. [Saham] ${reksadana.value.name} - Rp. ${reksadana.value.price} - ${reksadana.value.quantity}x")
                                            }
                                        }
                                    }

                                    print(">> ")

                                    val inptSell = readln()

                                    if (inptSell.toIntOrNull() == null){
                                        println("Invalid Input")
                                        continue
                                    } else if (inptSell.toInt() < 1 || inptSell.toInt() > sortedList.size){
                                        println("Invalid Input")
                                        continue
                                    }

                                    val selectedReksadana = sortedList[inptSell.toInt() - 1]

                                    val index = user.stocks.indexOf(selectedReksadana)

                                    val laba = (selectedReksadana.price*selectedReksadana.quantity) - (selectedReksadana.boughtPrice*selectedReksadana.quantity)

                                    user.addBalance(selectedReksadana.price*selectedReksadana.quantity)

                                    user.stocks.removeAt(index)

                                    if (laba < 0){
                                        println("Berhasil jual ${selectedReksadana.name}, rugi sebesar Rp. $laba!")
                                    } else if (laba > 0) {
                                        println("Berhasil jual ${selectedReksadana.name}, untung sebesar Rp. $laba!")
                                    } else {
                                        println("Berhasil jual ${selectedReksadana.name}, tidak untung dan tidak rugi!")
                                    }
                                }
                                "3" -> {
                                    println("=== Top Up ===")

                                    print("Jumlah : Rp. ")
                                    val topUp = readln()
                                    if (topUp == ""){
                                        println("Jumlah tidak boleh kosong!")
                                        continue
                                    } else if (topUp.toIntOrNull() == null){
                                        println("Jumlah harus berupa angka!")
                                        continue
                                    } else if (topUp.toInt() < 1000){
                                        println("Jumlah minimal harus melebihi 1000!")
                                        continue
                                    }

                                    print("Bank : ")
                                    val bank = readln()
                                    if (bank == ""){
                                        println("Bank tidak boleh kosong!")
                                        continue
                                    }

                                    print("No. Rekening : ")
                                    val noRekening = readln()
                                    if (noRekening == ""){
                                        println("No. Rekening tidak boleh kosong!")
                                        continue
                                    } else if (noRekening.toIntOrNull() == null){
                                        println("No. Rekening harus berupa angka!")
                                        continue
                                    } else if (noRekening.length != 5){
                                        println("No. Rekening harus 5 digit!")
                                        continue
                                    }

                                    user.addBalance(topUp.toInt())

                                    println("Berhasil top up!")
                                }
                                "4" -> {
                                    println("=== Portofolio Saya ===")

                                    val sortedList = sortListReksadana(user.stocks)

                                    for (reksadana in sortedList.withIndex()) {
                                        when (reksadana.value) {
                                            is PasarUang -> {
                                                println("${reksadana.index + 1}. [Pasar Uang] ${reksadana.value.name} - Rp. ${reksadana.value.price} - ${reksadana.value.quantity}x")
                                            }

                                            is Obligasi -> {
                                                println("${reksadana.index + 1}. [Obligasi] ${reksadana.value.name} - Rp. ${reksadana.value.price} - ${reksadana.value.quantity}x")
                                            }

                                            is Saham -> {
                                                println("${reksadana.index + 1}. [Saham] ${reksadana.value.name} - Rp. ${reksadana.value.price} - ${reksadana.value.quantity}x")
                                            }
                                        }
                                    }

                                    var statePasar = -1
                                    var stateObligasi = -1
                                    var stateSaham = -1

                                    for (reksadana in arrReksadana) {
                                        when (reksadana) {
                                            is PasarUang -> {
                                                statePasar = reksadana.state
                                            }

                                            is Obligasi -> {
                                                stateObligasi = reksadana.state
                                            }

                                            is Saham -> {
                                                stateSaham = reksadana.state
                                            }
                                        }
                                    }

                                    if (statePasar == 0){
                                        println("Kategori pasar uang mengalami kenaikan harga 5%")
                                    } else if (statePasar == 1){
                                        println("Kategori pasar uang mengalami penurunan harga 5%")
                                    }

                                    if (stateObligasi == 0){
                                        println("Kategori obligasi mengalami kenaikan harga 10%")
                                    } else if (stateObligasi == 1){
                                        println("Kategori obligasi mengalami penurunan harga 10%")
                                    }

                                    if (stateSaham == 0){
                                        println("Kategori saham mengalami kenaikan harga 15%")
                                    } else if (stateSaham == 1){
                                        println("Kategori saham mengalami penurunan harga 15%")
                                    }

                                }
                                "5" -> {
                                    println("Logout")
                                }
                                else -> {
                                    println("Invalid Input")
                                }
                            }
                            println("")
                        } while (inptUser != "5")
                    } else {
                        println("Invalid Username or Password.")
                    }
                }
            }
            "2" -> {
                println("=== Register ===")
                print("Username: ")
                val username = readln()
                if (username == ""){
                    println("Username cannot be empty!")
                    continue
                } else if (arrAccount.any { it.username == username }){
                    println("Username already exists!")
                    continue
                }

                print("Password: ")
                val password = readln()
                if (password == ""){
                    println("Password cannot be empty!")
                    continue
                }

                print("Confirm Password: ")
                val confirmPassword = readln()
                if (confirmPassword == ""){
                    println("Confirm Password cannot be empty!")
                    continue
                } else if (confirmPassword != password){
                    println("Password and Confirm Password must be the same!")
                    continue
                }

                print("ID Card Number: ")
                val idCardNumber = readln()
                if (idCardNumber == ""){
                    println("ID Card Number cannot be empty!")
                    continue
                } else if (idCardNumber.length != 7){
                    println("ID Card Number must be 7 characters!")
                    continue
                } else if (idCardNumber.toIntOrNull() == null){
                    println("ID Card Number must be a number!")
                    continue
                }

                print("Name: ")
                val name = readln()
                if (name == ""){
                    println("Name cannot be empty!")
                    continue
                }

                print("Gender (L/P): ")

                // KRITERIA KHUSUS NULL SAFETY
                val gender: String? = readlnOrNull()
                if (gender == ""){
                    println("Gender cannot be empty!")
                    continue
                    // KRITERIA KHUSUS NULL SAFETY
                } else if ((gender?.length != 1) && (gender != "L") && (gender != "P")){
                    println("The only available inputs are L and P.")
                    continue
                }

                arrAccount.add(Account(username, password, idCardNumber, name, gender))

                // KRITERIA KHUSUS COMPANION OBJECT
                Account.addCount()

                println("Registration Success!")
            }
            "3" -> {
                println("")
                println("Sekian. Terima Kasih.")
            }
            "list" -> {
                println("List Account:")
                var index = 1
                for (acc in arrAccount) {
                    println("Account $index")
                    println("Username: " + acc.username)
                    println("Password: " + acc.password)
                    println("ID Card Number: " + acc.idCardNumber)
                    println("Name: " + acc.name)
                    println("Gender: " + acc.gender)
                    println("Balance: Rp." + acc.balance)
                    println("Stocks: ")
                    acc.stocks.withIndex().map { (index, stock) ->
                        {
                            print((index + 1).toString() + ". ")
                            print("Name: " + stock.name + " ")
                            print("Price: Rp." + stock.price + " ")
                            print("Quantity: " + stock.quantity + "x ")
                        }
                    }
                    println("====================")
                    index++
                }
            }
            else -> {
                println("Invalid Input")
            }
        }
    } while (log != "3")
}

fun sortListReksadana(tempArr: ArrayList<Reksadana>): ArrayList<Reksadana> {

    val newReksadana: ArrayList<Reksadana> = arrayListOf()

    val tempPasarUang = tempArr.filterIsInstance<PasarUang>()
    val tempObligasi = tempArr.filterIsInstance<Obligasi>()
    val tempSaham = tempArr.filterIsInstance<Saham>()

    for (reksadana in tempPasarUang.sortedBy { it.price }) {
        newReksadana.add(reksadana)
    }
    for (reksadana in tempObligasi.sortedBy { it.price }) {
        newReksadana.add(reksadana)
    }
    for (reksadana in tempSaham.sortedBy { it.price }) {
        newReksadana.add(reksadana)
    }

    return newReksadana
}

