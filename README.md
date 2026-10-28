# Tres en Raya

Proyecto en Java para practicar pruebas unitarias con JUnit 4.

**Autora:** Luciana Yahuita

## Requisitos

- JDK instalado.
- Visual Studio Code con Extension Pack for Java.
- JUnit 4.13.2 y Hamcrest Core 1.3 disponibles para el proyecto.

El proyecto usa `src` para el código fuente, `lib` para dependencias y `bin` para las clases compiladas. La configuración de VS Code está en `.vscode/settings.json`.

## Ejecutar los tests en VS Code

1. Abre la carpeta del proyecto en VS Code.
2. Espera a que Java termine de importar y descubrir los tests.
3. Abre la vista **Testing** (icono de matraz).
4. Selecciona **Run All Tests** para ejecutar todas las pruebas, o usa **Run Test** sobre una clase o método para ejecutar solo esa prueba.

Las clases de prueba son:

- `com.ucb.tdd.TresEnRayaTest`
- `com.ucb.tdd.TresEnRayaIaTest`

También puedes usar los enlaces **Run Test** que aparecen sobre cada clase o método de prueba.

## Ejecutar desde PowerShell

Si los archivos `junit-4.13.2.jar` y `hamcrest-core-1.3.jar` están dentro de `lib`, ejecuta estos comandos desde la carpeta del proyecto:

```powershell
javac -cp "lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" -d bin src\com\ucb\tdd\TresEnRaya.java src\com\ucb\tdd\TresEnRayaTest.java src\com\ucb\tdd\TresEnRayaIaTest.java
java -cp "bin;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" org.junit.runner.JUnitCore com.ucb.tdd.TresEnRayaTest com.ucb.tdd.TresEnRayaIaTest
```

Si las dependencias están en otra ubicación, cambia las rutas de los `.jar` en los comandos o configúralas en `.vscode/settings.json`.
