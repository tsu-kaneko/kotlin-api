package com.example.kotlinapi.service

import org.springframework.stereotype.Service

@Service
class HelloService {

    // voidに該当するのがUnit
    fun basic(): Unit {
//        // valはjavaでいうfinal
//         val hoge = "aaa"
//         hoge = "bbb" 再代入できない

//        // これはOK
//        var hoge = "aaa"
//        hoge = "bbb"

//        // 初期化
//        val hoge: Int
//        hoge = 1

//        // read only list
//        val hoges = listOf(1, 2, 3)

//        // changeable list
//        val hoges: MutableList<Int> = mutableListOf(1, 2, 3)

//        // null許容型
//        var hoge: String? = null
//        // 安全呼び出し。nullだったらnullを返す
//        val length: Int? = hoge?.length
//        // Elvis演算子 nullならデフォルト返す
//        val length2: Int = hoge?.length ?: 0
//        println(length2)

        // step
        for (i in 1..10 step 2) {
            println(i)
        }
        // 出力: 1, 3, 5, 7, 9
    }

    /**
     * https://karino2.github.io/kotlin-web-site-ja/docs/lambdas.html#%E3%83%A9%E3%83%A0%E3%83%80%E5%BC%8F%E3%81%A8%E7%84%A1%E5%90%8D%E9%96%A2%E6%95%B0
     */
    fun lambda() {
        println({ string: String -> string.uppercase() }("hello"))

        // もうちょい省略
        println("hello".uppercase())

        // こんなこともできる
        val upperCaseString = { string: String -> string.uppercase() }
        println(upperCaseString("hello"))

        // 型指定もできる
        val upperCaseString2: (String) -> Int = { string -> string.length }

        // 関数の方を返してる
        // min2secの型は(Int) -> Int
        val timesInMinutes = listOf(2, 10, 15, 1)
        fun toSeconds(time: String): (Int) -> Int = when (time) {
            "hour" -> { value -> value * 60 * 60 }
            "minute" -> { value -> value * 60 }
            "second" -> { value -> value }
            else -> { value -> value }
        }
        val min2sec = toSeconds("minute") // val min2sec: (Int) -> Int = toSeconds("minute")
        val totalTimeInSeconds = timesInMinutes.map(min2sec).sum()
        println("トータルの時間は $totalTimeInSeconds 秒")
        // トータルの時間は 1680 秒

        // 単独でも呼び出せる
        println({ string: String -> string.uppercase() }("hello"))
    }

    fun lambda2() {
//        // トレーリングラムダ
//        // 演算としては初期値を、各要素に対して累積的に和を取る。
//        // xに累積値が入る
//        // 動き的には0+1, 1+2, 3+3
//        println(listOf(1, 2, 3).fold(0, { x, item -> x + item })) // 6
//
//        // トレーリングラムダを使ってこうも書く事が出来る。
//        println(listOf(1, 2, 3).fold(0) { x, item -> x + item })  // 6
//
//        // パラメータ一個だったら暗黙的にitで書ける
//        listOf(1, 2, 3).filter { it > 0 }
//
//        val piyo: List<Int> = listOf(1, 2, 3).filter {
//            val shouldFilter = it > 0
//            shouldFilter
//        }
//        println(piyo)
//
//        // 上と同じ結果
//        val fuga: List<Int> = listOf(1, 2, 3).filter {
//            val shouldFilter = it > 0
//            return@filter shouldFilter // filterから抜け出してる
//        }
//        println(fuga)

        // 3の時にループ終わらせたい場合
        run loop@{
            listOf(1, 2, 3, 4, 5).forEach {
                if (it == 3) return@loop // runに渡されたラムダからのnon-localなreturn
                print(it)
            }
        }

        // LINQスタイル
        listOf("aaa", "bbb", "ccc").filter { it.length == 5 }.sortedBy { it }.map { it.uppercase() }

        // ラムダのパラメータが使われない時は、名前の代わりにアンダースコアを使う事が出来ます
        val capitals = mapOf(
            "Japan" to "Tokyo",
            "USA" to "Washington D.C.",
            "UK" to "London"
        )
        capitals.forEach { (_, value) -> println("$value!") }


        // レシーバ付き関数リテラル
        // クラスに高階関数追加する感じ
        // https://qiita.com/ist-sa-o/items/e7598ba27d2276ac707f

    }

    fun elvis() {
        data class Employee (val name: String, var salary: Int)

        fun employeeById(id: Int) = when(id) {
            1 -> Employee("Mary", 20)
            2 -> null
            3 -> Employee("John", 21)
            4 -> Employee("Ann", 23)
            else -> null
        }

        // ?.でヌルセーフ
        // ?:でデフォルト値
        fun salaryById(id: Int): Int = employeeById(id)?.salary ?: 0

        println((1..5).sumOf { id -> salaryById(id) })
    }

    fun structuralEqual() {
        data class DataClass(val data: String)

        val d1 = DataClass("data")
        val d2 = DataClass("data")
        val d3 = d1

        println(d1 == d2)  // true - 内容が等しい
        println(d1 === d2) // false - 異なるインスタンス
        println(d1 === d3) // true - 同じインスタンスを指している

    }
}