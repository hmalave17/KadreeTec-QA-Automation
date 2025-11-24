# 🚀 KadreeTec – QA Automation Framework Suite

Este repositorio contiene una **suite completa de automatización QA**, diseñada como una **prueba de concepto (POC)** para evaluar diferentes frameworks y herramientas en los distintos niveles de testing de una arquitectura moderna.

Cada módulo representa una posible solución para una capa específica del ecosistema KadreeTec:

| Capa | Tecnología | Propósito |
|------|------------|-----------|
| **Frontend (UI Web)** | Playwright / Cypress | Pruebas E2E del front web |
| **BFF (Backend For Frontend)** | Karate | Validación de lógica intermedia y transformación de datos |
| **Microservicios (REST APIs)** | RestAssured + Java | Pruebas robustas y escalables sobre APIs nativas |

El objetivo es comparar tecnologías, validar arquitectura, aplicar buenas prácticas y definir una base sólida para un framework de automatización empresarial.

---

# Estructura del Repositorio

```
KadreeTec-QA-Automation/
│
├─ Cypress/
│ ├─ cypress/
│ ├─ package.json
│ ├─ .gitignore
│ └─ README.md
│
├─ Playwright/
│ ├─ src/
│ ├─ package.json
│ ├─ .gitignore
│ └─ README.md
│
├─ Karate/
│ ├─ src/
│ ├─ pom.xml or build.gradle
│ ├─ .gitignore
│ └─ README.md
│
├─ RestAssured/
│ ├─ src/
│ ├─ build.gradle
│ ├─ .gitignore
│ └─ README.md
│
└─ README.md

```


Cada carpeta contiene un **proyecto independiente**, listo para clonarse y ejecutarse por separado, además de su propio README interno con detalles, instalación y ejecución.

---

#  Objetivo general del repositorio

El propósito de este repositorio es:

- Evaluar **cuál framework es más adecuado para cada capa** de testing.
- Comparar Playwright vs Cypress en UI.
- Comparar Karate vs RestAssured en backend y BFF.
- Demostrar arquitectura limpia para automatización modular.
- Implementar buenas prácticas:
  - Page Object Model (POM)
  - BDD con Gherkin
  - Data-Driven
  - Independencia entre capas
  - Reusabilidad y mantenibilidad
- Servir como base para un futuro framework unificado de KadreeTec.

---

# Frameworks incluidos

### ✔ **RestAssured (Microservicios con Java)**
Automatización de pruebas API REST usando:
- Java
- RestAssured
- Serenity BDD (opcional según arquitectura)
- Gradle

➡ Ubicación: `/RestAssured/`  
➡ Propósito: pruebas robustas para microservicios internos.

---

### ✔ **Karate (BFF / Integración)**
Framework ideal para la capa intermedia (BFF), con:

- DSL simple para pruebas API
- JSON, assertions, data-driven nativo
- Capacidad de automatizar servicios intermedios
- Permite validar transformaciones entre backend y frontend

➡ Ubicación: `/Karate/`  
➡ Propósito: validar reglas de negocio ubicadas en BFF.

---

### ✔ **Playwright (Frontend Web)**
Automatización moderna de UI con:

- Soporte multiplataforma y multinavegador
- Excelente performance
- Soporte para trazas, videos y capturas
- Ideal para pipelines modernos

➡ Ubicación: `/Playwright/`  
➡ Propósito: pruebas E2E del frontend de forma estable.

---

### ✔ **Cypress (Frontend Web Alternativo)**
Framework de mayor adopción en la industria, fácil de usar:

- Excelente Developer Experience
- Integración con Cucumber
- Rápido para prototipos o validaciones rápidas

➡ Ubicación: `/Cypress/`  
➡ Propósito: evaluación comparativa con Playwright.

---

# ¿Cómo clonar este repositorio?

Ejecuta:

```bash
git clone https://github.com/hmalave17/KadreeTec-QA-Automation.git
cd KadreeTec-QA-Automation

