package Ex1

fun main(){
    val nome = "Maria"
    var idade = 25
    val altura: Double = 1.68
    println("Nome: $nome, Idade: $idade, Altura: $altura metros")
    idade += 1
    println("Ano que vem, $nome terá $idade anos.")
    println("Comparação: ${idade.compareTo(26)}")
}