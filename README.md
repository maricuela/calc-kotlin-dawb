# calc-kotlin-dawb

## Descripción del Ejercicio: Evaluación de Conocimientos en Git y GitHub (Versión Modularizada)

Este ejercicio está diseñado para evaluar tus habilidades en el uso de Git y GitHub. A continuación, se detallan los pasos que debes seguir, con un enfoque en la modularización del código.

> RESPETA LOS MENSAJES DE LOS COMMITS, LAS RAMAS SOLICITADAS, ASI COMO EL CÓDIGO (EN GENERAL TODO EL TEXTO). TEN EN CUENTA MAYÚSCULAS Y MINÚSCULAS, TILDES, ETC. NO SE EVALUARÁN, O SE EVALUARÁN NEGATIVAMENTE, AQUELLOS QUE NO CUMPLAN CON ESTOS REQUISITOS. PARA EVITAR PROBLEMAS, SE RECOMIENDA COPIAR Y PEGAR LOS MENSAJES DE LOS COMMITS, NOMBRES DE LAS RAMAS Y CÓDIGO PROPORCIONADO.

### **1. Creación del Repositorio**
- Debes crear un repositorio en **GitHub** con el nombre `calc-kotlin-dawb`.
- Inicializar el repositorio localmente y vincularlo (con acceso ssh) con el repositorio remoto. Ojo, debes tener configurado el acceso SSH a GitHub.
- Renombra la rama a `main`, si es `master` la que tienes por defecto en tu repositorio local y en GitHub tienes `main`.

### **2. Commit Inicial**
- Los alumnos deben crear un archivo `Calc.kt` en Kotlin con la siguiente estructura modularizada:
  ```kotlin
  fun main(args: Array) {
      val (operation, num1, num2) = parseArguments(args)
      val result = when (operation) {
          "multiplica" -> multiplica(num1, num2)
          else -> throw IllegalArgumentException("Operación no soportada")
      }
      showResult(operation, result)
  }

  fun parseArguments(args: Array): Triple {
      if (args.size != 3) {
          throw IllegalArgumentException("Número incorrecto de argumentos")
      }
      val operation = args[0]
      val num1 = args[1].toInt()
      val num2 = args[2].toInt()
      return Triple(operation, num1, num2)
  }

  fun multiplica(num1: Int, num2: Int): Int {
      return num1 * num2
  }

  fun showResult(operation: String, result: Int) {
      println("El resultado de la operación \"$operation\" es: $result")
  }
  ```
- Realizar un commit con el mensaje `"Commit inicial"`.
- Subir los cambios al repositorio remoto.

### **3. Creación de la Rama `feature/division`**
- Crear una nueva rama llamada `feature/division` a patir del punto en el que se encuentra la rama `main`.
- Añadir la funcionalidad de división en la rama `feature/division`:
  ```kotlin
  fun divideE(num1: Int, num2: Int): Int {
      return num1 / num2
  }
  ```
- Modificar la función `main` para incluir la nueva operación, añadiendo `"divide" -> divideE(num1, num2)`:
  ```kotlin
  fun main(args: Array) {
      val (operation, num1, num2) = parseArguments(args)
      val result = when (operation) {
          "multiplica" -> multiplica(num1, num2)
          "divide" -> divideE(num1, num2)
          else -> throw IllegalArgumentException("Operación no soportada")
      }
      showResult(operation, result)
  }
  ```
- Realizar un commit con el mensaje `"Función división con error"`.

### **4. Merge de la Rama `feature/division`**
- Fusionar la rama `feature/division` en la rama principal (`main`), es decir, ve a la rama `main` y realiza un merge de la rama `feature/division`.

### **5. Revocación del Merge y del Commit**
- Revocar el merge de la rama `feature/division` en la rama `main`. Desde la rama `main`, ejecutar, elimina el último commit.
- Revocar el commit en la rama `feature/division` que añadió la división sin control de errores. Desde la rama `feature/division`, elimina el último commit.

### **6. Corrección de la División**
- Añade a la rama `feature/division` una versión mejorada para controlar la división por cero:
  ```kotlin
  fun divide(num1: Int, num2: Int): Int {
      if (num2 == 0) {
          throw IllegalArgumentException("Error: No se puede dividir por cero")
      }
      return num1 / num2
  }
  ```

- Modificar la función `main`, añadiendo `"divide" -> divide(num1, num2)`:
  ```kotlin
     fun main(args: Array) {
         val (operation, num1, num2) = parseArguments(args)
         val result = when (operation) {
             "multiplica" -> multiplica(num1, num2)
             "divide" -> divide(num1, num2)
             else -> throw IllegalArgumentException("Operación no soportada")
         }
         showResult(operation, result)
     }
  ```  
- Realizar un commit con el mensaje `"Función división sin error"`.

### **7. Merge Final de la Rama `feature/division`**
- Fusionar la rama `feature/division` en la rama principal (`main`).

### **8. Creación de Ramas `feature/suma` y `feature/resta`**
- Crear dos ramas nuevas: `feature/suma` y `feature/resta`, ambas a partir del commit que tiene por mensaje "Commit inicial". Revisa el paso 2. 
- Añadir la funcionalidad de suma en la rama `feature/suma`:
  ```kotlin
  fun suma(num1: Int, num2: Int): Int {
      return num1 + num2
  }
  ```
- Modificar la función `main` en la rama `feature/suma`:
  ```kotlin
  fun main(args: Array) {
      val (operation, num1, num2) = parseArguments(args)
      val result = when (operation) {
          "multiplica" -> multiplica(num1, num2)
          "suma" -> suma(num1, num2)
          else -> throw IllegalArgumentException("Operación no soportada")
      }
      showResult(operation, result)
  }
  ```

- Realizar un commit en la rama `feature/suma` con el mensaje `"Función suma"`.

- Añadir la funcionalidad de resta en la rama `feature/resta`:
  ```kotlin
  fun resta(num1: Int, num2: Int): Int {
      return num1 - num2
  }
  ```
- Modificar la función `main` en la rama `feature/resta`:
  ```kotlin
  fun main(args: Array) {
      val (operation, num1, num2) = parseArguments(args)
      val result = when (operation) {
          "multiplica" -> multiplica(num1, num2)
          "resta" -> resta(num1, num2)
          else -> throw IllegalArgumentException("Operación no soportada")
      }
      showResult(operation, result)
  }
  ```

- Realizar un commit en la rama `feature/resta` con el mensaje `"Función resta"`.

### **9. Merge de las Ramas `feature/suma` y `feature/resta`**
- Fusionar ambas ramas en la rama principal (`main`), lo que generará conflictos.
- Resolver el conflicto manualmente y realizar un commit con el mensaje `"Conflicto suma resuelto"` para el merge de la rama `feature/suma` en la rama `main`.
- Resolver el conflicto manualmente y realizar un commit con el mensaje `"Conflicto resta resuelto"` para el merge de la rama `feature/resta` en la rama `main`.

### **10. Sube los cambios a Github**
- Asegurate de que el programa funcione correctamente, o por lo menos que no falle al compilar.
- Sube los cambios **de todas las ramas** a GitHub.

### **11. Entrega**
- Entrega la URL de tu repositorio en la plataforma habilitada. Asegúrate de que el repositorio **sea público** para poder ser evaluado.
---
