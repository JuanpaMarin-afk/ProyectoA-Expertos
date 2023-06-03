package com.example.proyectoa_expertos

object Constants {

    const val USER_NAME: String = "user_name"
    const val INTELLIGENCE: String = "intelligence_user_name"
    const val SCORE: String = "1"

    fun getPoints(): Array<Array<Int>> {
        val array = arrayOf(
        // Inteligencias        Que_Id:    1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12
        /*Lingüística Verbal    */arrayOf( 0,-3,-4,-3,-3,-2,-3,-2,-1,-1,-2,-2),
        /*Logica-Matematica     */arrayOf(-3, 0,-3,-3,-3,-2,-2,-2,-1,-1,-2,-2),
        /*Espacial              */arrayOf(-4,-3, 0,-4,-3,-2,-2,-1,-1,-1,-2,-2),
        /*Musical               */arrayOf(-3,-3,-4, 0,-3,-2,-1,-1,-1,-1,-2,-2),
        /*Corporal-Cinestésica  */arrayOf(-3,-3,-3,-3, 0,-2,-2,-1,-1,-1,-2,-2),
        /*Intrapersonal         */arrayOf(-2,-2,-2,-2,-2, 0,-5,-1,-1,-1,-2,-5),
        /*Interpersonal         */arrayOf(-2,-2,-2,-2,-2,-5, 0,-1,-1,-1,-2,-5),
        /*Naturalista           */arrayOf(-2,-2,-1,-1,-1,-1,-1, 0,-1,-1,-1,-1),
        /*Existencial           */arrayOf(-1,-1, 1,-1,-1,-1,-1,-1, 0,-1,-1,-1),
        /*Creativa              */arrayOf(-1,-1,-1, 1,-1,-1,-1,-1,-1, 0,-1,-1),
        /*Emocional             */arrayOf(-2,-2,-2,-2,-2,-2,-2,-1,-1,-1, 0,-2),
        /*Colaborativa          */arrayOf(-2,-2,-2,-2,-2,-5,-5,-1,-1,-1,-2, 0)
)


return array
}

fun getIntelligences(): ArrayList<IntelligenceScore> {
val i1 = IntelligenceScore( 0, "Lingüística Verbal")
val i2 = IntelligenceScore( 0, "Logica-Matematica")
val i3 = IntelligenceScore( 0, "Espacial")
val i4 = IntelligenceScore( 0, "Musical")
val i5 = IntelligenceScore( 0, "Corporal-Cinestésica")
val i6 = IntelligenceScore( 0, "Intrapersonal")
val i7 = IntelligenceScore( 0, "Interpersonal")
val i8 = IntelligenceScore( 0, "Naturalista")
val i9 = IntelligenceScore( 0, "Existencial")
val i10 = IntelligenceScore( 0, "Creativa")
val i11 = IntelligenceScore( 0, "Emocional")
val i12 = IntelligenceScore( 0, "Colaborativa")

var intelligencesList = ArrayList<IntelligenceScore>()
intelligencesList.add(i1)
intelligencesList.add(i2)
intelligencesList.add(i3)
intelligencesList.add(i4)
intelligencesList.add(i5)
intelligencesList.add(i6)
intelligencesList.add(i7)
intelligencesList.add(i8)
intelligencesList.add(i9)
intelligencesList.add(i10)
intelligencesList.add(i11)
intelligencesList.add(i12)

return intelligencesList
}

fun getQuestions(): ArrayList<Question> {
val questionsList = ArrayList<Question>()

// Question 1
val que1 = Question(
    1, "¿Qué puntuación te darías en habilidad para leer y analizar libros y artículos?",0
)
questionsList.add(que1)
// Question 2
val que2 = Question(
    2, "¿Qué puntuación te darías en habilidad para resolver problemas matemáticos complejos?",0
)
questionsList.add(que2)
// Question 3
val que3 = Question(
    3, "¿Qué puntuación te darías en habilidad para encontrar tu camino en entornos desconocidos o seguir direcciones utilizando mapas?",0
)
questionsList.add(que3)
// Question 4
val que4 = Question(
    4, "¿Qué puntuación te darías en habilidad para componer o improvisar música?",0
)
questionsList.add(que4)
// Question 5
val que5 = Question(
    5, "¿Qué puntuación te darías en habilidad para aprender y ejecutar nuevas habilidades físicas o deportivas?",0
)
questionsList.add(que5)
// Question 6
val que6 = Question(
    6, "¿Qué puntuación te darías en habilidad para comprender tus propias emociones y expresarlas de manera saludable?",0
)
questionsList.add(que6)
// Question 7
val que7 = Question(
    7, "¿Qué puntuación te darías en habilidad para comunicarte de manera efectiva, tanto verbal como no verbalmente?",0
)
questionsList.add(que7)
// Question 8
val que8 = Question(
    8, "¿Qué puntuación te darías en habilidad para observar y reconocer patrones naturales, como el ciclo de las estaciones o las migraciones de aves?",0
)
questionsList.add(que8)
// Question 9
val que9 = Question(
    9, "¿Qué puntuación te darías en cuanto a tu reflexión sobre el propósito y significado de la vida?",0
)
questionsList.add(que9)
// Question 10
val que10 = Question(
    10, "¿Qué puntuación te darías en habilidad para generar ideas originales y creativas?",0
)
questionsList.add(que10)
// Question 11
val que11 = Question(
    11, "¿Qué puntuación te darías en habilidad para empatizar y comprender las emociones de los demás?",0
)
questionsList.add(que11)
// Question 12
val que12 = Question(
    12, "¿Qué puntuación te darías en habilidad para trabajar en equipo y colaborar de manera productiva con otros?",0
)
questionsList.add(que12)
// Question 13
val que13 = Question(
    13, "¿Qué puntuación te darías en habilidad para escribir ensayos o historias?",0
)
questionsList.add(que13)
// Question 14
val que14 = Question(
    14, "¿Qué puntuación te darías en habilidad para identificar patrones y relaciones en conjuntos de datos?",0
)
questionsList.add(que14)
// Question 15
val que15 = Question(
    15, "¿Qué puntuación te darías en habilidad para visualizar objetos y formas en tres dimensiones?",0
)
questionsList.add(que15)
// Question 16
val que16 = Question(
    16, "¿Qué puntuación te darías en habilidad para entender y analizar la estructura musical, como tonalidad, ritmo y armonía?",0
)
questionsList.add(que16)
// Question 17
val que17 = Question(
    17, "¿Qué puntuación te darías en habilidad para expresar emociones y transmitir mensajes a través de movimientos corporales?",0
)
questionsList.add(que17)
// Question 18
val que18 = Question(
    18, "¿Qué puntuación te darías en habilidad para establecer metas personales realistas y trabajar hacia su logro?",0
)
questionsList.add(que18)
// Question 19
val que19 = Question(
    19, "¿Qué puntuación te darías en habilidad para resolver conflictos y llegar a acuerdos satisfactorios con los demás?",0
)
questionsList.add(que19)
// Question 20
val que20 = Question(
    20, "¿Qué puntuación te darías en habilidad para comprender y describir los diferentes ecosistemas y su funcionamiento?",0
)
questionsList.add(que20)
// Question 21
val que21 = Question(
    21, "¿Qué puntuación te darías en cuanto a tu capacidad para encontrar y apreciar belleza y significado en las experiencias cotidianas?",0
)
questionsList.add(que21)
// Question 22
val que22 = Question(
    22, "¿Qué puntuación te darías en habilidad para pensar de manera flexible y encontrar soluciones innovadoras a los problemas?",0
)
questionsList.add(que22)
// Question 23
val que23 = Question(
    23, "¿Qué puntuación te darías en habilidad para regular tus emociones y manejar el estrés de manera efectiva?",0
)
questionsList.add(que23)
// Question 24
val que24 = Question(
    24, "¿Qué puntuación te darías en habilidad para resolver conflictos y llegar a acuerdos satisfactorios en situaciones de colaboración?",0
)
questionsList.add(que24)
// Question 25
val que25 = Question(
    25, "¿Qué puntuación te darías en habilidad para participar en debates o discusiones grupales?",0
)
questionsList.add(que25)
// Question 26
val que26 = Question(
    26, "¿Qué puntuación te darías en habilidad para aplicar principios lógicos en situaciones cotidianas y tomar decisiones basadas en el razonamiento deductivo?",0
)
questionsList.add(que26)
// Question 27
val que27 = Question(
    27, "¿Qué puntuación te darías en habilidad para apreciar y crear arte visualmente atractivo?",0
)
questionsList.add(que27)
// Question 28
val que28 = Question(
    28, "¿Qué puntuación te darías en habilidad para apreciar y disfrutar de la música en términos de su impacto emocional y estético?",0
)
questionsList.add(que28)
// Question 29
val que29 = Question(
    29, "¿Qué puntuación te darías en habilidad para mantener el equilibrio y tener una buena postura corporal?",0
)
questionsList.add(que29)
// Question 30
val que30 = Question(
    30, "¿Qué puntuación te darías en habilidad para tomar decisiones basadas en tus valores y creencias personales?",0
)
questionsList.add(que30)
// Question 31
val que31 = Question(
    31, "¿Qué puntuación te darías en habilidad para liderar y motivar a otros en situaciones grupales o de equipo?",0
)
questionsList.add(que31)
// Question 32
val que32 = Question(
    32, "¿Qué puntuación te darías en habilidad para aplicar conocimientos científicos en la conservación y protección del medio ambiente?",0
)
questionsList.add(que32)
// Question 33
val que33 = Question(
    33, "¿Qué puntuación te darías en cuanto a tu exploración y búsqueda de respuestas a las grandes preguntas filosóficas y existenciales?",0
)
questionsList.add(que33)
// Question 34
val que34 = Question(
    34, "¿Qué puntuación te darías en habilidad para aprovechar la imaginación y la curiosidad para generar ideas y explorar nuevos enfoques?",0
)
questionsList.add(que34)
// Question 35
val que35 = Question(
    35, "¿Qué puntuación te darías en habilidad para establecer y mantener relaciones saludables y satisfactorias con los demás?",0
)
questionsList.add(que35)
// Question 36
val que36 = Question(
    36, "¿Qué puntuación te darías en habilidad para adaptarte a diferentes estilos de trabajo y contribuir de manera constructiva en grupos y equipos?",0
)
questionsList.add(que36)


return questionsList
}
}
