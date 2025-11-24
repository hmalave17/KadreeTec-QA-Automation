# **KadreeTec – API Automation (Karate Framework)**

Este módulo forma parte del repositorio **KadreeTec-QA-Automation**, y contiene la automatización de pruebas API utilizando **Karate DSL**.

Su propósito es servir como framework de automatización para la **capa intermedia (BFF Test Layer)**, validando los servicios REST expuestos hacia frontend, permitiendo:

- Validación funcional de endpoints
- Validación de contratos (JSON Schema)
- Pruebas parciales y completas de recursos
- Pruebas rápidas sin necesidad de navegador
- Ejecución paralela y fácil integración con CI/CD

---

## 🚀 **Tecnologías utilizadas**

- Java 11+
- Karate DSL
- Maven
- JUnit 5
- JSON Schema Validation
- IntelliJ IDEA (recomendado)

---

## **Estructura del Proyecto**

```
Karate/
│
├─ pom.xml
├─ README.md
├─ .gitignore
│
└─ src/
    ├─ main/
    │   └─ java/
    │       └─ utils/
    │           └─ (clases utilitarias)
    │
    └─ test/
        ├─ java/
        │   ├─ runners/
        │   │   ├─ CreateBookingRunner.java
        │   │   └─ UpdateBookingRunner.java
        │   │
        │   └─ utils/
        │       └─ (clases adicionales si aplican)
        │
        └─ resources/
            ├─ karate-config.js
            │
            ├─ data/
            │   ├─ create_token_request.json
            │   ├─ update_booking.json
            │   ├─ update_booking_partial.json
            │   └─ update_booking.json
            │
            ├─ features/
            │   └─ booking/
            │       └─ update_booking.feature
            │
            ├─ helpers/
            │   ├─ create_token_helper.feature
            │   └─ update_helper.feature
            │
            └─ schemas/
                └─ update_booking_schema.json
```

---

## **Clonar el repositorio**

```bash
git clone https://github.com/hmalave17/KadreeTec-QA-Automation.git
cd KadreeTec-QA-Automation/Karate
```

---

## ️ **Ejecutar las pruebas**

### **1. Desde IntelliJ (por Runner)**

Abrir:
```
src/test/java/runners/CreateBookingRunner.java
```

Click derecho → **Run 'CreateBookingRunner'**

Lo mismo para:
```
UpdateBookingRunner.java
```

---

###  **2. Desde consola usando Maven**

Ejecutar todas las pruebas:

```bash
mvn clean test
```

Ejecutar solo un runner:

```bash
mvn -Dtest=CreateBookingRunner test
```

Ejecutar pruebas con tags:

```bash
mvn test -Dkarate.options="--tags @booking"
```

---

## ⚙️ **Configuración principal (karate-config.js)**

Karate carga automáticamente el archivo:

```
src/test/resources/karate-config.js
```

Ejemplo:

```js
function fn() {
  var config = {
    baseUrl: 'https://restful-booker.herokuapp.com'
  };
  return config;
}
```

Desde aquí se pueden manejar:

- Ambientes (qa, dev, stage)
- Headers globales
- Tokens dinámicos
- Variables compartidas

---

## **Reportes**

Después de la ejecución, Karate genera reportes en:

```
target/karate-reports/
```

Archivo principal:

```
karate-summary.html
```

---

##  **Autor**

Hernán J Malavé  
Senior QA Automation Engineer

---

