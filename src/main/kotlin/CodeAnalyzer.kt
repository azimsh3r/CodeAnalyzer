import java.io.File

class CodeAnalyzer {
    private var filePath: String? = null
    private var fileName: String? = null
    private var scores: MutableMap<String, Int> = mutableMapOf()
    private var stylePercentage: Double? = null

    private fun getContent (): List<String>
            = File("$filePath/$fileName").bufferedReader().readLines()

    // Calculates the complexity
    private fun findComplexity () {
        var lastFunName: String = ""
        var lastFunCount: Int = 0
        val lines = getContent()

        for (line in lines) {
            if (line.contains(Regex("fun\\s+(\\w+)\\s*\\("))) {
                val funName = line.substringAfterLast("fun ").substringBeforeLast(" (")
                scores[funName] = 0
                lastFunName = funName
                lastFunCount = 0
            }
            if (line.contains(Regex("\\b(for|while|if|switch)\\b"))) {
                scores[lastFunName] = ++lastFunCount
            }
        }
    }

    // Loads data about file
    fun load(path: String, name: String) {
        this.filePath = path
        this.fileName = name
    }

    // Calculates and prints functions/methods with the highest complexity scores
    fun getComplexity () {
        findComplexity()

        println("Functions/Methods with the highest complexity scores!")
        var count : Int = 0
        for (entry in scores.toList().sortedByDescending { it.second }.toMap()) {
            if (count > 2){
                break
            }
            println("${entry.key} : ${entry.value}")
            count++
        }
    }

    fun getStyleStats () {
        val lines = getContent()
        var notCamelCase = 0
        var totalCount = 0
        val regexCamelCase = Regex("\\b[a-z][a-zA-Z0-9]*([A-Z][a-zA-Z0-9]*)+\\b")

        for (line in lines) {
            if (line.contains(Regex("fun\\s+(\\w+)\\s*\\("))) {
                totalCount++
                if (!line.substringAfterLast("fun ").substringBeforeLast(" (").contains(regexCamelCase)) {
                    notCamelCase++
                }
            }
        }
        stylePercentage = notCamelCase.toDouble() / totalCount * 100
        println("The percentage of functions that do not comform to naming style: $stylePercentage%")
    }
}
