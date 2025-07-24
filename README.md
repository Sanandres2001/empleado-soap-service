# 🧼 Empleado SOAP Service

Este proyecto es un servicio **SOAP** construido con **Spring Boot**, diseñado para gestionar operaciones relacionadas con empleados. Expone un endpoint WSDL para facilitar integraciones con otros sistemas que consumen servicios web SOAP. Para esta prueba en concreto quien se comunicará será un servicio REST.

---

## 🚀 Stack Tecnológico

- Java 17+
- Spring Boot
- Spring Web Services (SOAP)
- JAXB (para marshalling/unmarshalling)
- Maven

---

## 📦 Estructura del Proyecto

```text
src/
├── main/
│   ├── java/
│   │   └── co.parameta.pruebatecnica/
│   │       ├── endpoint/              # Controladores SOAP
│   │       ├── model/                 # Clases generadas desde el XSD
│   │       └── EmpleadoSoapService.java  # Clase principal
│   └── resources/
│       ├── application.properties     # Configuración general
│       └── empleado.xsd               # Esquema XML
└── test/                              # Pruebas unitarias
```
------
