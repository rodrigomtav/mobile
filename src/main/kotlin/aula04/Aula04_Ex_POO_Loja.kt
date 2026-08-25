package aula04

//ENUM do tipo de joog
enum class TipoJogo {
    FISICO,
    DIGITAL,
    TABULEIRO
}

//INTERFACES
//interface compravel feita somente com o intuito de estruturar melhor o exercicio
interface Compravel {
    fun comprar()
}

//para envio fisico
interface Enviavel {
    fun enviar(){}
}
//para envio digital
interface EntregavelDigital{
    fun entregarDigital(){}
}

// OBJETOS
class Pedido(
    val cliente: Cliente
) {
    var itensPedido = mutableListOf<Produto>()

    var cupom = 0.0
    var subtotal = 0.0
    var desconto = 0.0
    var frete = 0.0
    var total = 0.0

    fun adicionarItem(produto: Produto) {
        if (itensPedido.add(produto)) {
            println("Produto ${produto.nome} adicionado ao carrinho!")
        } else {
            println("Erro ao adicionar produto ao pedido!")
        }
    }

    fun calcularSubtotal(){
        this.subtotal = 0.0

        for (produto in itensPedido){
            subtotal += produto.preco
        }
        println(subtotal)
    }

    fun aplicarCupom() {
        desconto = subtotal * (cupom / 100.0)
    }

    fun calcularFrete() {
        for (produto in itensPedido) {
            if (!produto.isDigital){
                frete += 5 * (produto.peso ?: 0.0)
            }

        }
    }

    fun calcularTotal(){
        total = subtotal + frete - desconto
    }

    fun exibirResumo() {
        println("========== PEDIDO ==========")
        println("Cliente: ${cliente.nome}")

        println("\nItens:")

        for (produto in itensPedido) {
            println("${produto.nome} - R$ %.2f".format(produto.preco))
        }

        println("\nSubtotal: R$ %.2f".format(subtotal))
        println("Desconto: R$ %.2f".format(desconto))
        println("Frete: R$ %.2f".format(frete))
        println("TOTAL: R$ %.2f".format(total))

        println("============================")
    }

    fun finalizarPedido() {
        calcularSubtotal()
        aplicarCupom()
        calcularFrete()
        calcularTotal()
        exibirResumo()
    }
}

class Cliente(
    val nome: String
)

//OBJETOS PRODUTOS
open class Produto(var nome: String,
                   var isDigital: Boolean,
                   var preco: Double,
                   var peso: Double?)
    : Compravel {
    override fun comprar() {
        TODO("Not yet implemented")
    }
}

open class Livro(nome: String,
                 isDigital: Boolean,
                 preco: Double,
                 peso: Double?)
    : Produto(nome, isDigital, preco, peso){
    override fun comprar() {
        TODO("Not yet implemented")
    }
}

open class Console(nome: String,
                   peso: Double,
                   preco: Double)
    : Produto (nome, false, preco, peso ){
    override fun comprar() {
        TODO("Not yet implemented")
    }

}

open class Filme(nome: String,
                 preco: Double)
    : Produto (nome, true, preco, peso = null) {
    override fun comprar() {

    }

}

open class Jogo(nome: String,
                val tipo: TipoJogo,
                preco: Double,
                peso: Double?)
                : Produto(nome, tipo == TipoJogo.DIGITAL, preco, peso) {
}


fun main() {
    val produtos = mutableListOf<Produto>()

    //populate livros físicos
    produtos.add(Livro("Harry Potter 1", false, 40.0, 0.5))
    produtos.add(Livro("Harry Potter 2", false, 40.0, 0.5))
    produtos.add(Livro("Harry Potter 3", false, 40.0, 0.5))

    //populate livros digitais
    produtos.add(Livro("Harry Potter 1", true, 25.0, null))
    produtos.add(Livro("Harry Potter 2", true, 25.0, null))
    produtos.add(Livro("Harry Potter 3", true, 25.0, null))

    //populate consoles
    produtos.add(Console("Super Nintendo", 2.5, 500.0))
    produtos.add(Console("SEGA Saturn", 2.5, 450.0))
    produtos.add(Console("PlayStation 1", 2.0, 600.0))

    //populate filmes
    produtos.add(Filme("O Diabo Veste Prada", 30.0))
    produtos.add(Filme("O Diabo Veste Riachuelo", 30.0))
    produtos.add(Filme("O Diabo Veste Marisa", 30.0))

    //populate jogos
    //DIGITAIS
    produtos.add(Jogo("Crash Bandicoot", TipoJogo.DIGITAL, 50.0, null))
    produtos.add(Jogo("Minecraft", TipoJogo.DIGITAL, 80.0, null))
    produtos.add(Jogo("Baldur's Gate III", TipoJogo.DIGITAL, 100.0, null))

    //FISICOS
    produtos.add(Jogo("Ratchet & Clank", TipoJogo.FISICO, 100.0, 0.2))
    produtos.add(Jogo("Left 4 Dead", TipoJogo.FISICO, 80.0, 0.2))
    produtos.add(Jogo("HALO 4", TipoJogo.FISICO, 90.0, 0.2))

    //TABULEIRO
    produtos.add(Jogo("Xadrez", TipoJogo.TABULEIRO, 100.0, 1.5))
    produtos.add(Jogo("Dama", TipoJogo.TABULEIRO, 50.0, 1.0))
    produtos.add(Jogo("Ludo", TipoJogo.TABULEIRO, 60.0, 0.8))

    val cliente = Cliente("Rodrigo")
    val pedido = Pedido(cliente)

    pedido.adicionarItem(produtos[0])
    pedido.adicionarItem(produtos[3])
    pedido.adicionarItem(produtos[5])
    pedido.adicionarItem(produtos[6])
    pedido.adicionarItem(produtos[9])
    pedido.adicionarItem(produtos[1])
    pedido.adicionarItem(produtos[11])
    pedido.cupom = 10.0

    pedido.finalizarPedido()
}

