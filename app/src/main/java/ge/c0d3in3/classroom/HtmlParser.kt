package ge.c0d3in3.classroom

import org.jsoup.Jsoup

class HtmlParser {

    fun parse(html: String): List<Item> {
        val parsed = Jsoup.parse(html)
        val list = mutableListOf<Item>()
        parsed.allElements.forEach {
            if (it.tagName() == "span") {
                if(list.size > 0 && list.last().type == Type.HEADER) {
                    list.last().text = list.last().text + it.text()
                }
                else{
                    list.add(Item(text = it.text(), type = Type.HEADER))
                }
            }
            if (it.tagName() == "p" && (it.childrenSize() == 0))
                list.add(Item(text = it.text(), type = Type.TEXT))
        }
        return list
    }
}