val arr1 = Array(6){it+1}
val arr_asc2 = arr1.sorted()
fun main() {
    for (n in arr1) print("$n ")
    println()
    for (n in arr_asc2) print("$n ")
    println(arr_asc2[arr_asc2.size-2])
}