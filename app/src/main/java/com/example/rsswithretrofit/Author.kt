package com.example.rsswithretrofit

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.Serializable


@Root(name = "author", strict = false)
class Author constructor(): Serializable {
    @field:Element
    var name: String? = null
}