package Ex1

fun main() {
    menu()
}

fun menu() {

    while (true) {

        println()
        println("===== MENU DE ATIVIDADES =====")
        println("1 - Atividade 1 - Maiúsculas e minúsculas")
        println("2 - Atividade 2 - Soma de dois números")
        println("3 - Atividade 3 - Par ou ímpar")
        println("4 - Atividade 4 - Média do aluno")
        println("5 - Atividade 5 - Conversão de temperatura")
        println("0 - Sair")
        print("Escolha uma atividade: ")

        when (readln()) {

            "1" -> atividade1()

            "2" -> atividade2()

            "3" -> atividade3()

            "4" -> atividade4()

            "5" -> atividade5()

            "0" -> {
                println("Programa encerrado.")
                break
            }

            else -> {
                println("Opção inválida! Escolha uma opção de 0 a 5.")
            }
        }

        println()
        println("Pressione ENTER para voltar ao menu...")
        readln()
    }
}

fun atividade1() {

    println("Digite sua palavra")
    val palavra = readLine().toString()

    if (palavra != "" && palavra != null) {
        println("Maiúsculas: " + palavra.uppercase() + " | Minúsculas: " + palavra)
    } else {
        println("Não pode ser nulo ou vazio")
    }
}

fun atividade2() {

    println("Digite o 1o numero")
    val n1 = readLine()!!.toInt()

    println("Digite o 2o numero")
    val n2 = readLine()!!.toInt()

    val n3 = n1 + n2

    println("A soma é " + n3)
}

fun atividade3() {

    println("Digite o numero")
    val numero = readLine()?.toIntOrNull()

    if (numero?.rem(2) == 0) {
        println("par")
    } else {
        println("impar")
    }
}

fun atividade4() {

    print("Digite a primeira nota: ")
    val nota1 = readln().toDouble()

    print("Digite a segunda nota: ")
    val nota2 = readln().toDouble()

    print("Digite a terceira nota: ")
    val nota3 = readln().toDouble()

    val media = (nota1 + nota2 + nota3) / 3

    println("Média: $media")

    if (media >= 6) {
        println("Aprovado")
    } else if (media >= 4) {
        println("Recuperação")
    } else {
        println("Reprovado")
    }
}

fun atividade5() {

    print("Digite a temperatura em Celsius: ")
    val celsius = readln().toDoubleOrNull()

    if (celsius == null) {
        println("Erro: digite um valor numérico válido.")
        return
    }

    println("Escolha a conversão:")
    println("1 - Fahrenheit")
    println("2 - Kelvin")
    print("Opção: ")

    val opcao = readln()

    when (opcao) {

        "1" -> {
            val fahrenheit = celsius * 9 / 5 + 32
            println("$celsius °C = $fahrenheit °F")
        }

        "2" -> {
            val kelvin = celsius + 273.15
            println("$celsius °C = $kelvin K")
        }

        else -> {
            println("Erro: opção inválida.")
        }
    }
}