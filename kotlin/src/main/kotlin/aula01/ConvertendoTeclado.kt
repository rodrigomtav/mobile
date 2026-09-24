package Ex1

fun main() {
    print("Digite sua idade: ")
    val idade = readLine()?.toIntOrNull()
    if (idade != null) {
        println("Ano que vem você terá ${idade + 1} anos.")
    } else {
        println("Idade inválida!")
    }
}