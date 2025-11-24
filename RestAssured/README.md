# RestAssured (QA Automation)

## Proyecto: POC RestAssured — KadreeTech

Este proyecto es una **Prueba de Concepto (POC)** para la capa de servicios (microservicios / API) del stack de pruebas de **KadreeTech**.  
El objetivo es validar el comportamiento del framework de automatización en los consumos de los endpoints con una arquitectura escalable y facil de mantener. 

> **Autor:** Hernán José Malave Montero  
> **Propósito:** Evaluar viabilidad del framework automatización de pruebas para APIs usando RestAssured + Java + Gradle.

---

## Tecnologías y dependencias principales

- Lenguaje: **Java 11+**
- Framework HTTP/API: **RestAssured**
- Framework de pruebas: **JUnit 5**
- Build / Wrapper: **Gradle**
- IDE recomendado: IntelliJ IDEA (Community/Ultimate)
- OS: Windows / macOS / Linux (el proyecto está preparado para correr en Windows)

---
## Estructura del proyecto 

<h2>Estructura del proyecto</h2>

<p>El proyecto de automatización está construido utilizando Serenity BDD, RestAssured, Java y el patrón de diseño Screenplay. A continuación se detalla la estructura del proyecto y la responsabilidad de cada carpeta:</p>

<ul>

  <li><strong>src/test/java/co/com/kadreeTech/certification/interactions</strong>:
    Este paquete contiene todas las interacciones reutilizables que permiten manipular o transformar información durante la ejecución de las pruebas. Incluye acciones como construir headers, preparar requests o manipular respuestas.</li>

  <li><strong>src/test/java/co/com/kadreeTech/certification/models</strong>:
    Aquí se encuentran los modelos (POJOs) necesarios para mapear la data utilizada en los requests y en las validaciones. Permiten mantener una estructura clara y desacoplada.</li>

  <li><strong>src/test/java/co/com/kadreeTech/certification/tasks</strong>:
    Este paquete contiene todas las tareas del patrón Screenplay. Cada tarea representa una acción del negocio, como crear una reserva, consultar información o actualizar un booking.</li>

  <li><strong>src/test/java/co/com/kadreeTech/certification/questions</strong>:
    Este paquete contiene las preguntas del patrón Screenplay, responsables de validar el response recibido. Incluye validación de status codes, cuerpo del response, valores específicos del JSON, entre otros.</li>

  <li><strong>src/test/java/co/com/kadreeTech/certification/utils</strong>:
    En este paquete se alojan todas las utilidades y funciones de apoyo, tales como lectura de archivos JSON, generación de datos, constantes y métodos auxiliares para Serenity o RestAssured.</li>

  <li><strong>src/test/java/co/com/kadreeTech/certification/exceptions</strong>:
    Este paquete contiene clases de excepciones personalizadas, utilizadas para manejar errores específicos dentro del flujo de automatización, como fallas de servicio, validaciones inesperadas o datos inválidos.</li>

  <li><strong>src/test/java/co/com/kadreeTech/certification/enums</strong>:
    Este paquete contiene enumeraciones utilizadas para estandarizar valores constantes dentro del proyecto (por ejemplo: códigos HTTP esperados, tipos de contenido, etc.).</li>

  <li><strong>src/test/java/co/com/kadreeTech/certification/runners</strong>:
    Incluye los runners de JUnit que permiten ejecutar los escenarios definidos en los archivos feature. Cada runner carga la configuración, define los tags y controla el ciclo de ejecución.</li>

  <li><strong>src/test/resources/features</strong>:
    Aquí se encuentran los archivos Feature escritos en Gherkin, que describen los escenarios de prueba según el enfoque BDD.</li>

  <li><strong>src/test/resources/data</strong>:
    Contiene la data externa requerida para las pruebas. Normalmente en formato JSON para requests parciales o completos.</li>

  <li><strong>src/test/resources/serenity.conf</strong>:
    Archivo de configuración para Serenity BDD. Define la URL base del servicio, ajustes del framework y parámetros adicionales del proyecto.</li>

  <li><strong>build.gradle</strong>:
    Archivo principal del proyecto para la administración de dependencias, plugins, versiones y configuración de Gradle.</li>

  <li><strong>.gitignore</strong>:
    Archivo usado para excluir carpetas generadas automáticamente como <em>target/</em>, <em>.gradle/</em>, reportes temporales, configuraciones locales del IDE y otros archivos no requeridos en el repositorio.</li>

</ul>

<h2>Pasos para obtener el proyecto</h2>

<ul>
  <li>Clonar el repositorio usando el siguiente comando:</li>
</ul>

<pre><code>git clone https://github.com/hmalave17/KadreeTech-QA-Automation.git
</code></pre>

<ul>
  <li>Ingresar en la carpeta del proyecto RestAssured:</li>
</ul>

<pre><code>cd KadreeTech-QA-Automation/RestAssured
</code></pre>

<hr>

<h2>Pasos para ejecutar el proyecto</h2>

<p>El proyecto está configurado con Gradle, por lo que no requiere instalación adicional de dependencias en el IDE.</p>

<ul>
  <li>Ejecutar todos los escenarios automatizados:</li>
</ul>

<pre><code>gradlew clean test aggregate
</code></pre>

<ul>
  <li>Ejecutar un runner específico (por ejemplo, CreateBookingRequestRunner):</li>
</ul>

<pre><code>gradlew clean test --tests "co.com.kadreeTech.certification.runners.CreateBookingRequestRunner"
</code></pre>

<ul>
  <li>El reporte de Serenity se generará en:</li>
</ul>

<pre><code>target/site/serenity/index.html
</code></pre>

## **Autor**

Hernán J Malavé  
Senior QA Automation Engineer

---
