package Models

import java.sql.Struct

class Food {
    var name: String? = null
    var ingredients: String? = null
    var preparationOrder: String? = null

    constructor(name: String?, ingredients: String?, preparationOrder: String?) {
        this.name = name
        this.ingredients = ingredients
        this.preparationOrder = preparationOrder
    }
}