# **UI Automation (Playwright Framework)**

Este módulo forma parte del repositorio **KadreeTech-QA-Automation**, y contiene la automatización de pruebas UI utilizando **Playwright** bajo un diseño escalable basado en **Page Object Model (POM)**.

Su propósito dentro de la arquitectura de automatización es:

- Validar las funcionalidades críticas de la interfaz de usuario  
- Probar flujos end-to-end  
- Garantizar la integración entre Frontend + BFF + Microservicios  
- Ofrecer un framework moderno, rápido y estable  
- Facilitar ejecución en paralelo y CI/CD

---

## **Tecnologías utilizadas**

- Playwright (JS/TS)
- Node.js 18+
- Page Object Model (POM)
- Mochawesome / Allure (opcional)
- VS Code (recomendado)

---

## **Estructura del Proyecto**

```
Playwright/
│
├─ src/
│   ├─ resource/
│   │   └─ data/
│   │       └─ challenge.xlsx
│   │
│   ├─ features/
│   │   └─ challenge.feature
│   │
│   ├─ test/
│       ├─ hook/
│       │   ├─ Config.py
│       │   ├─ DataReader.py
│       │   └─ Page.py
│       │
│       ├─ pages/
│       │   └─ LoginPageUI.py
│       │
│       ├─ tests/
│       │   ├─ Conftest.py
│       │   └─ Test_challenge.py
│       │
│       └─ utils/
│
├─ playwright.config.js
├─ package.json
├─ .gitignore
└─ README.md
```

---

##  **Clonar el repositorio**

```bash
git clone https://github.com/hmalave17/KadreeTech-QA-Automation.git
cd KadreeTech-QA-Automation/Playwright
```

---

## **Instalar dependencias**

> Importante: Node.js 18+ es obligatorio.

Ejecutar:

```bash
npm install
```

Instalar Playwright y sus navegadores:

```bash
npx playwright install
```

Si deseas instalar todos los componentes adicionales:

```bash
npx playwright install --with-deps
```

---

##  **Ejecutar las pruebas**

###  **1. Modo headless (rápido)**

```bash
npx playwright test
```

### **2. Modo headed (mostrando el navegador)**

```bash
npx playwright test --headed
```

### **3. Ejecutar un archivo específico**

```bash
npx playwright test src/test/tests/Test_challenge.py
```

### **4. Ejecutar con UI Mode (ideal para debugging)**

```bash
npx playwright test --ui
```

---

## **Reportes**

Playwright genera reportes en:

```
playwright-report/
```

Abrirlo manualmente:

```bash
npx playwright show-report
```

---

## **Patrón de diseño utilizado: Page Object Model (POM)**

Tu arquitectura está basada en:

- **pages/** → representación de cada página  
- **tests/** → casos de prueba  
- **hook/** → configuración, drivers y hooks  
- **resource/** → datos externos  
- **features/** → escenarios BDD o documentación  
- **utils/** → funciones reutilizables  

Este diseño permite:

- Alta escalabilidad  
- Separación de responsabilidades  
- Fácil mantenimiento  
- Reusabilidad entre proyectos  

---

## **Propósito dentro del ecosistema KadreeTec**

Este módulo Playwright cumple con:

- Ser la **capa de pruebas end-to-end (Frontend UI)**  
- Validar la funcionalidad real que experimenta el usuario  
- Servir como capa superior sobre BFF + Microservicios  
- Detectar errores de integración antes que lleguen a producción  
- Asegurar compatibilidad multi-navegador  

---

## **Autor**

Hernán J Malavé  
Senior QA Automation Engineer

---
