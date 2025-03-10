package com.yunseo_33.mytest

// lateinit var data1: Int
// lateinit val data2: String
lateinit var data3: String

var data2 = 10

// lambda expression : 값을 초기화시킬 경우만 할당
val data4: Int by lazy{
   println("in lazy........")
   10
}

fun solution(){
   var data1: Int = 10
   var data2: Int? = null

   data1 = data1 + 10
   data2 = data1.plus(10)

   println(data1)
   println(data2)
}

fun main(){
   solution()

   // println("I'm in Main Function!")
   // println(data4 + 50)
   // println(data4 + 10)
}