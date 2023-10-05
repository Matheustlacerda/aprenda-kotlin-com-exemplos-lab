enum class Nivel { BÁSICO, INTERMEDIARIO, AVANÇADO }

class Usuario(val nome: String, val id: Int)

data class ConteudoEducacional(var nome: String, val duracao: Int, var level: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, var level: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun show_user(){
        for(user in inscritos){
            println("Id: ${user.id} - ${user.nome}")
        }
    }

    fun show_content(){
        for(content in conteudos){
            println("Nome da linguagem de programação: ${content.nome}, Carga Horária: ${content.duracao}, Dificuldade: ${content.level}")
        }
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Python",50,Nivel.BÁSICO)
    val conteudo2 = ConteudoEducacional("Kotlin",100,Nivel.AVANÇADO)
    val conteudo3 = ConteudoEducacional("Ruby",80,Nivel.INTERMEDIARIO)
    val usuario1 = Usuario("Matheus",1)
    val usuario2 = Usuario("Eduardo",2)

    val grade = mutableListOf<ConteudoEducacional>()
        grade.add(conteudo1)
        grade.add(conteudo2)
        grade.add(conteudo3)

    
    val escola = Formacao("Escola de Programação",grade,Nivel.AVANÇADO )

    escola.matricular(usuario1)
    escola.matricular(usuario2)

    println("\nAlunos Matriculados:")
    escola.show_user()
   
    println("\nLinguagens de Programação disponíveis:")
    escola.show_content()
}