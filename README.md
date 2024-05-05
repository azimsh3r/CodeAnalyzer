### Code Analyzer

This is a simple code analysis tool written in Kotlin. It analyzes Kotlin source code files to calculate complexity and style statistics.

#### Instructions for Use

1. **Import `java.io.File`**:

   Before using the `CodeAnalyzer` class, ensure that you have imported the `java.io.File` class. This is necessary for file operations within the code analyzer.

   ```kotlin
   import java.io.File
   ```

2. **Instantiate `CodeAnalyzer`**:

   Create an instance of the `CodeAnalyzer` class to use its methods for analyzing Kotlin source code files.

   ```kotlin
   val analyzer = CodeAnalyzer()
   ```

3. **Load File**:

   Before performing analysis, load the Kotlin source code file you want to analyze using the `load` method. Provide the file path and name as arguments.

   ```kotlin
   analyzer.load("/path/to/your/file", "filename.kt")
   ```

4. **Analyze Complexity**:

   To calculate the complexity of functions/methods in the loaded file, call the `getComplexity` method.

   ```kotlin
   analyzer.getComplexity()
   ```

   This method prints functions/methods with the highest complexity scores.

5. **Analyze Style**:

   To analyze naming style conformity of functions/methods in the loaded file, call the `getStyleStats` method.

   ```kotlin
   analyzer.getStyleStats()
   ```

   This method prints the percentage of functions that do not conform to the naming style (not camel case).

#### Notes

- Ensure that the file path provided to the `load` method is correct and accessible.
- The `getComplexity` method provides information about functions/methods with the highest complexity scores.
- The `getStyleStats` method provides information about the percentage of functions/methods that do not conform to the naming style.

### Example

```kotlin
import java.io.File

fun main() {
    val analyzer = CodeAnalyzer()
    analyzer.load("/path/to/your/file", "filename.kt")
    analyzer.getComplexity()
    analyzer.getStyleStats()
}
```

Replace `"/path/to/your/file"` with the actual file path and `"filename.kt"` with the name of the Kotlin source code file you want to analyze.
