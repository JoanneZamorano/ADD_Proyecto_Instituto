# Gestión de Inventario Escolar - Sistema CRUD Multiplataforma

Este proyecto es una aplicación de consola desarrollada en **Java** para la gestión integral de un centro educativo. Permite administrar Profesores, Alumnos, Módulos y Matrículas, utilizando una base de datos relacional **PostgreSQL** para la persistencia de los datos.

## 🚀 Características y Funcionalidades

El sistema implementa un ciclo de vida completo de datos (**CRUD**) y funciones avanzadas de consulta:

* **Gestión de Profesores:** Registro, edición, eliminación y búsqueda por nombre.
* **Gestión de Alumnos:** Administración de fichas personales con validación de DNI.
* **Gestión de Módulos:** Asignación de carga horaria y vinculación directa con el profesorado.
* **Gestión de Matrículas:** Relación muchos a muchos entre alumnos y módulos, incluyendo control de fechas y calificaciones.
* **Funcionalidad Adicional:** Informe de rendimiento académico con un **Top 5 de mejores notas** mediante consultas SQL optimizadas.

## 🛠️ Arquitectura del Proyecto

Para garantizar un código limpio y escalable, el proyecto se ha organizado siguiendo patrones de diseño estándar:

1.  **Modelo (Domain):** Clases que representan las entidades del sistema (`Alumno`, `Profesor`, `Modulo`, `Matricula`).
2.  **DAO (Data Access Object):** Capa encargada de la comunicación con la base de datos PostgreSQL, separando la lógica de negocio del lenguaje SQL.
3.  **UI (User Interface):** Paquete independiente que gestiona la interacción con el usuario mediante menús especializados, manteniendo el `Main` limpio y organizado.
4.  **Database:** Gestión centralizada de la conexión JDBC.

## 🛡️ Robustez y Control de Errores

Se ha puesto especial énfasis en la experiencia de usuario y la estabilidad del sistema:
* **Validación de Entradas:** El sistema está protegido contra errores comunes. Si el usuario introduce texto en un campo numérico, el programa captura la excepción (`try-catch`) y solicita de nuevo el dato sin cerrarse.
* **Consultas Avanzadas (JOINs):** Se utilizan cruces de tablas para recuperar objetos complejos. Esto permite mostrar nombres reales y descripciones en lugar de simples IDs numéricos, haciendo la interfaz mucho más humana.

## 📊 Ejemplo de Visualización

La aplicación utiliza un diseño de consola desglosado para facilitar la lectura:

```text
--- DETALLES DE MATRÍCULA ---
ALUMNO: Joanne
	 >> MÓDULO: Acceso a datos
	 >> NOTA: 10.0
-----------------------------
```
```text
--- DETALLES DE MÓDULOS ---
Modulo: ACCESO A DATOS
	ID Modulo: 1	| horas Semanales: 5
Profesor:JORGE
	ID: 2	| dni: 11111111P
	email: jorge@ies.com
-----------------------------
```

## 💻 Tecnologías Utilizadas
* **Lenguaje:** Java 17+
* **Base de Datos:** PostgreSQL
* **Conector:** JDBC (Java Database Connectivity)
* **Entorno:** IntelliJ IDEA / Maven

----

Desarrollado como parte del módulo de Acceso a Datos. El código completo y la evolución de los commits se pueden consultar en este repositorio.

**Autor:** Joanne M Zamorano  
**Asignatura:** Acceso a Datos - 2º DAM