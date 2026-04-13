# Simulador de Carrera de Caballos

Este es un simulador básico en Java aplicando:
1. **Concurrencia (Threads)**: Cada caballo (`Caballo.java`) implementa `Runnable` y actualiza una barra de progreso de manera asíncrona.
2. **Sincronización**: La clase `GestorCarrera.java` utiliza `synchronized` para asegurar que el primer caballo en llegar a 100 gane de manera unívoca y atómica.
3. **Persistencia**: La clase `ResultadoRepository` guarda el ganador junto con la fecha en la base de datos `SQLite` (`carreras.db`).
4. **Interfaz Gráfica (Swing)**: Actualiza los elementos mediante `SwingUtilities.invokeLater()` para ser thread-safe en el entorno Swing (Event Dispatch Thread).

## Cómo Ejecutar

### Método 1: Usar el script .bat (Recomendado)
Haz doble clic sobre el archivo `run.bat` que se encuentra en esta misma carpeta, o ejecútalo desde tu consola.

### Método 2: Desde la consola manualmente (PowerShell o CMD)
```cmd
java -cp "bin;lib/sqlite-jdbc-3.45.1.0.jar" Main
```

*(Nota: el proyecto ya fue compilado y el controlador de SQLite descargado en la carpeta `lib`).*
