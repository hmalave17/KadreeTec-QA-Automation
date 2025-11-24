# **Frontend Automation (Cypress + Cucumber)**

Este módulo forma parte del repositorio **KadreeTech-QA-Automation** y contiene la automatización de pruebas **end-to-end del Frontend**, utilizando **Cypress** con integración **Cucumber (BDD)** para lograr escenarios legibles, robustos y fáciles de mantener.

Este proyecto se diseñó como una **prueba de concepto (POC)** para validar Cypress como framework de automatización frontend, evaluando su rapidez, estabilidad y facilidad de integración con pipelines CI/CD.

---

## **Tecnologías utilizadas**

- **Cypress 15+**  
- **JavaScript / Node.js**  
- **Cucumber + Gherkin (BDD)**  
- **Cypress Cucumber Preprocessor**  
- **Page Object Model (POM)**  
- **NPM / Node 22+**

---

## **Estructura del Proyecto**

```
Cypress/
│
├─ cypress/
│   ├─ e2e/
│   │   ├─ features/
│   │   │   └─ login/
│   │   │       ├─ login.feature
│   │   │       └─ login.js
│   │   └─ steps/       
│   │
│   ├─ fixtures/
│   │   └─ loginData.json
│   │
│   ├─ pages/
│   │   └─ LoginPage.js
│   │
│   ├─ screenshots/
│   │
│   └─ support/
│       ├─ commands.js
│       └─ e2e.js
│
├─ package.json
├─ .gitignore
└─ README.md
```

---

##  **Descripción de carpetas**

### **cypress/e2e/features/**
Contiene los escenarios escritos en Gherkin utilizando Cucumber:  
Ejemplo: `login.feature`

### **cypress/e2e/login.js**
Archivo donde se conectan los escenarios BDD con las definiciones de paso mediante Cucumber.

### **cypress/pages/**
Implementación del patrón **Page Object Model (POM)**  
Ejemplo: `LoginPage.js` (manejo de selectores + acciones)

### **cypress/fixtures/**
Datos estáticos usados para pruebas, como usuarios de login.

### **cypress/support/**
Inicialización global de Cypress:

- `commands.js`: comandos custom
- `e2e.js`: hooks, imports y configuración BDD

### **screenshots/**
Carpeta donde Cypress guarda capturas en caso de errores.

---

## **Clonar el repositorio**

```bash
git clone https://github.com/hmalave17/KadreeTec-QA-Automation.git
cd KadreeTec-QA-Automation/Cypress
```

---

## **Instalar dependencias**

Antes de correr las pruebas, instala los módulos:

```bash
npm install
```

---

## **Ejecutar las pruebas**

###  Abrir Cypress en modo interactivo

```bash
npx cypress open
```

### Ejecutar todas las pruebas en modo headless

```bash
npx cypress run
```

### Ejecutar en modo headed (con navegador visible)

```bash
npx cypress run --headed --browser chrome
```

---

## **BDD con Cucumber**

Este proyecto integra:

- Scenarios en Gherkin  
- Definiciones de paso con JavaScript  
- Conexión mediante el preprocesador Cucumber

Formato esperado:

```
Feature: Login functionality

  Scenario: login success
    Given the user is on login page
    When the user enters valid credentials
    Then the user should be logged in
```

---

## **Propósito dentro de KadreeTech-QA-Automation**

Este módulo demuestra el uso de **Cypress como alternativa de E2E para Frontend**, resaltando:

- Rapidez en ejecución  
- Excelente DX (Developer Experience)  
- Fácil depuración  
- BDD integrado  
- Soporte nativo para testing visual, UI y XHR  

Sin embargo, también sirve como contraste frente a **Playwright**, evaluando cuál se ajusta mejor a los objetivos de KadreeTec.

---

## **Reportes**

Cypress genera automáticamente:

- Capturas en `cypress/screenshots/`
- Videos (si habilitados) en `cypress/videos/`

---

## **Autor**

Hernán J Malavé  
Senior QA Automation Engineer
