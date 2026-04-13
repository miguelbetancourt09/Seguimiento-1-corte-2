# CRUD Empleados - Java Swing, SQLite y SOLID

Esta es una aplicación de escritorio CRUD (Crear, Leer, Actualizar, Borrar) escrita en Java utilizando la interfaz gráfica **Swing** con un diseño moderno proporcionado por **FlatLaf**.
Utiliza **SQLite** para persistir los datos localmente, haciendo que la aplicación sea portátil y fácil de probar sin requerir instalaciones de bases de datos externas como MySQL o PostgreSQL.

La arquitectura sigue los principios **SOLID** y está estructurada en múltiples capas:
- **Model**: Entidad `Employee`.
- **Repository**: Define cómo los datos son persistidos de manera abstracta. Incluye la implementación `EmployeeRepositorySQLiteImpl`.
- **Service**: Manejo de validaciones de reglas de negocio (`EmployeeServiceImpl`).
- **Controller**: Coordula eventos entre la UI y el Servicio.
- **View / UI**: La interfaz gráfica (`MainFrame`).

## Requisitos
- **Java JDK 17** o superior instalado.
- **Maven** (O puedes importar el proyecto a un IDE que traiga integración Maven nativamente como IntelliJ IDEA, Eclipse, NetBeans, o VS Code).

## Cómo Ejecutarlo

**Opción 1: Desde el IDE (Recomendado)**
1. Abre tu IDE favorito (IntelliJ IDEA es especialmente bueno para Java).
2. Selecciona "Abrir Proyecto" y elige la carpeta `crud_empleados` (donde está el archivo `pom.xml`).
3. El IDE descargará automáticamente SQLite JDBC y FlatLaf.
4. Navega a `src/main/java/com/crud/Main.java` y dale click a **Run**.

**Opción 2: Usando Maven desde la consola**
Si tienes Apache Maven instalado en tus variables de entorno, puedes ejecutarlo usando la consola:
```bash
# Navegar a la carpeta
cd "c:\Users\Usuario\programacion 1\crud_ejercicios\crud_empleados"

# Compilar proyecto
mvn clean compile

# Ejecutar Main con el plugin de Maven
mvn exec:java
```

## Características
- **Zero Config**: La base de datos es inicializada automáticamente de forma interna y los datos se guardan en un archivo local llamado `empleados.db`.
- **Patrón Inyección de Dependencias**: El código en `Main` inicializa e inyecta las dependencias necesarias.
- **Validación**: La lógica de validación restringe que no haya salarios negativos, etc.
- **Estilo Moderno**: FlatLaf Light UI te da una interfaz que no luce nativa de los 90s, si no contemporánea y estilizada.
