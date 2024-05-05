fun main(args: Array<String>) {
    val codeAnalyzer = CodeAnalyzer()

    codeAnalyzer.load("path/to/file", "file.kt")
    codeAnalyzer.getComplexity()

    codeAnalyzer.getStyleStats()
}