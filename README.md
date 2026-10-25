# Exercícios de Kotlin e Android

Repositório destinado às atividades da disciplina de Desenvolvimento Mobile do curso de Análise e Desenvolvimento de Sistemas do IFSP - Campus Araraquara, sob orientação do professor Henrique Galati.

## Descrição

Este projeto reúne os exercícios desenvolvidos ao longo das aulas, utilizando Kotlin para praticar conceitos fundamentais de programação e, depois, para desenvolver aplicativos Android.

Os exercícios são organizados por aula. A pasta `kotlin/` é um único projeto com os exercícios de linguagem, e a pasta `android/` tem um projeto do Android Studio para cada atividade.

## Estrutura

```text
kotlin/
└──src/
   └── main/
      └── kotlin/
          ├── aula01/
          │   ├── Aula1_Atividade1.kt
          │   ├── ConvertendoTeclado.kt
          │   └── Exemplo1.kt
          │
          └── aula04/
              └── Aula04_Ex_POO_Loja.kt

android/
├── aula06/
│   └── ConversorMoeda/
└── aula09/
    └── GuiaDeTurismo/

```

Novas pastas serão adicionadas conforme o desenvolvimento das próximas aulas.

## Tecnologias Utilizadas

* Kotlin
* Gradle
* IntelliJ IDEA
* JDK
* AndroidStudio

## Conteúdos

Entre os conceitos praticados no projeto estão:

* Variáveis e tipos de dados
* Entrada e saída de dados
* Operadores
* Estruturas condicionais
* Estruturas de repetição
* Funções
* Tratamento de entradas inválidas
* Programação orientada a objetos
* Organização de projetos Kotlin
* Activities e layouts em XML
* ListView com Adapter personalizado
* Intents para abrir outras telas e outros aplicativos (discador, mapa e e-mail)
* Uso do strings.xml para os textos do aplicativo

## Execução

Clone o repositório:

```bash
git clone https://github.com/rodrigomtav/mobile.git
```

### Exercícios de Kotlin

Entre na pasta `kotlin`:

```bash
cd mobile/kotlin
```

O projeto pode ser aberto no IntelliJ IDEA e executado através das funções `main()` presentes nos arquivos de cada aula.

Também é possível utilizar o Gradle Wrapper:

```bash
./gradlew build
```

No Windows:

```bash
gradlew.bat build
```

### Projetos Android

Cada pasta dentro de `android/` é um projeto separado. No Android Studio, use **File > Open** e selecione a pasta do projeto desejado, por exemplo `android/aula09/GuiaDeTurismo`. Depois é só executar em um emulador ou celular.

## Status

Em desenvolvimento.

O repositório será atualizado ao longo do semestre com os exercícios e conteúdos desenvolvidos nas próximas aulas.

## Aprendizados

O projeto tem como objetivo consolidar os fundamentos da linguagem Kotlin e desenvolver familiaridade com ferramentas de desenvolvimento, organização de código e controle de versão utilizando Git e GitHub.

## Autor

**Rodrigo Taveira**

Estudante de Análise e Desenvolvimento de Sistemas
IFSP - Campus Araraquara

## Professor

**Henrique Galati**

Professor do IFSP - Campus Araraquara

---

Projeto acadêmico desenvolvido para fins de estudo e aprendizado.
