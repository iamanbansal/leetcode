fun main() {

    val map = HashMap<String, Any>().apply {
        put("key","1")
        val foo = HashMap<String, Any>().apply {
            put("a", "2")
            val bar = HashMap<String, Any>().apply {
                put("b", "3")
            }
            put("bar",bar)
        }
        put("foo",foo)
    }

    val result= hashMapOf<String,String>()

    for ((k, v) in map) {
        flatten(map, result, k, v)
    }

    result.forEach {
        println("${it.key}  ${it.value}")
    }
}

private fun flatten(map: HashMap<String, Any>, result: HashMap<String, String>, key: String, value: Any) {

    if (value is String) {
        result[key] = value
    } else if (value is HashMap<*, *>) {
        val keyMap = value as HashMap<String, Any>
        for ((k, v) in keyMap) {
            flatten(value, result, "$key.$k", v)
        }
    }
}