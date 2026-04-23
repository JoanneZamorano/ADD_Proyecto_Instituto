# Sistema de Gestión Educativa - Acceso a Datos (DAM)

Este proyecto consiste en el desarrollo de una aplicación completa que gestiona datos mediante el acceso a bases de datos relacionales, aplicando técnicas avanzadas de persistencia y organización del código en capas.

## 1. Diseño de la Base de Datos
Se ha diseñado una base de datos relacional en **PostgreSQL** compuesta por 4 tablas principales con sus respectivas Claves Primarias (PK) y Foráneas (FK):
* **Profesores**: Datos del equipo docente.
* **Módulos**: Asignaturas vinculadas a profesores (1:N).
* **Alumnos**: Registro de estudiantes.
* **Matrículas**: Tabla intermedia para la relación N:M entre Alumnos y Módulos.

## 2. Conexión y Acceso a Datos
La aplicación implementa una gestión de conexiones eficiente y segura:
* **Conexión JDBC**: Uso de la interfaz `Connection` para comunicar la app con PostgreSQL.
* **Patrón DAO**: Se han creado clases específicas (Data Access Object) para centralizar el acceso a los datos, separándolos de la lógica del programa.
* **Seguridad**: Uso de `PreparedStatement` para todas las consultas, evitando ataques de SQL Injection.

## 3. Operaciones CRUD Avanzadas
Se han implementado las cuatro operaciones básicas de persistencia con validaciones adicionales:

* **Inserción (Create)**: Alta de registros con validación de tipos de datos y restricciones (ej. DNI único).
* **Consulta (Read)**: Búsquedas con filtros específicos y listados generales utilizando `ResultSet`.
* **Modificación (Update)**: Actualización de registros existentes asegurando la integridad de las claves.
* **Eliminación (Delete)**: Borrado controlado para evitar errores de integridad referencial.

## 4. Consultas Avanzadas
El sistema utiliza consultas SQL complejas para la generación de informes:
* **Uso de JOINs**: Combinación de las 4 tablas para mostrar qué alumnos tiene cada profesor.
* **Cláusulas**: Aplicación de `WHERE`, `ORDER BY` y `GROUP BY` para organizar la información de salida.

## 5. Gestión desde la Aplicación
La interacción con el usuario se realiza mediante un **Menú Funcional** por consola que incluye:
* Navegación fluida entre las opciones de gestión.
* **Control de errores**: Captura de excepciones (`try-catch`) para evitar cierres inesperados.
* **Validación de entradas**: Comprobación de que los datos introducidos por el usuario son correctos antes de enviarlos a la BD.

## 6. Organización del Código (Arquitectura en Capas)
Para cumplir con los estándares de desarrollo profesional, el código se ha organizado en las siguientes capas:

1.  **Capa de Acceso a Datos (DAO)**: Contiene la lógica puramente SQL y la interacción con la base de datos.
2.  **Capa de Lógica de Aplicación**: Gestiona las reglas de negocio y procesa los datos antes de ser guardados o mostrados.
3.  **Capa de Modelo (POJOs)**: Clases que representan las entidades (Alumno, Profesor, etc.).
4.  **Capa de Presentación**: Interfaz de usuario (Menú) que captura las acciones del usuario.

## 7. Funcionalidad Adicional
Se ha implementado un sistema de **Búsqueda Avanzada** que permite filtrar alumnos por múltiples criterios combinados (nombre y módulo) y la generación de un **Informe de notas** ordenado por rendimiento académico.

---
**Autor:** Joanne M Zamorano  
**Asignatura:** Acceso a Datos - 2º DAM