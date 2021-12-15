package ge.c0d3in3.classroom

data class Item(var text: String, val type: Type)

enum class Type {
    HEADER,
    TEXT
}