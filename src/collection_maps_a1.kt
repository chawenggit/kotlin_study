package collection_maps_a1

/*
    book Kotlin illustrated Guide
    Kotlin Map = Python dict — same concept, different syntax.
    mapOf and mutableMapOf
    key -> value  : each pair called entry
 */

fun main() {
    //---------mapOf()------------
    val toolbox = mapOf( // read only table lookup
//        key -> value
        "Nail" to "Hammer",
        "Hex Nut" to "Wrench",
        "Hex Bolt" to "Wrench",
        "Slotted Screw" to "Slotted Screwdriver",
        "Phillips Screw" to "Phillips Screwdriver",
    )
    println(toolbox)
    println("toolbox = ${toolbox}")
        // forEach() --------------------
    toolbox.forEach {i -> println("key=${i.key} => ${i.value}") }

        // filtering --------------------
            // filtering with value ----
    val screwdrivers = toolbox.filter { entry ->
        entry.value.contains("Screwdriver")
    }
    println("screwdrivers = ${screwdrivers}")
                // filtering with key ----
    val hexKey = toolbox.filter { entry ->
        entry.key.contains("Hex")
    }
    println("hexKey = ${hexKey}")

        // mapping --------------------
    val tool_mapping = toolbox
        .mapKeys { entry -> entry.key.replace("Hex", "Flange") }
        .mapValues { entry -> entry.value.replace("Wrench", "Ratchet") }
    println("tool_mapping = ${tool_mapping}")
        // Setting Default Value (when no key found)
    val tool1 = toolbox.getOrDefault("Hanger Bolt", "Hand")
    val tool2 = toolbox.getOrDefault("Nail", "Hand")
    val tool3 = toolbox.getOrDefault("Eye Bolt", "Hand")
    println("tool1 = ${tool1}") // not found key so Hand
    println("tool2 = ${tool2}") // found key
    val toolbox1 = toolbox.withDefault { key -> "Hand" }
    println("toolbox1 = ${toolbox1}")
    println("toolx = ${toolbox1["x"]}") // why it return null not "Hand"
    println("tooly = ${toolbox1.getValue("x")}") // only getValue return default value

    //---------mutableMapOf()------------
    val toolbox_mu = mutableMapOf(
        "Nail" to "Hammer",
        "Hex Nut" to "Wrench",
        "Hex Bolt" to "Wrench",
        "Slotted Screw" to "Slotted Screwdriver",
        "Phillips Screw" to "Phillips Screwdriver",
    )
    println(toolbox_mu)
        // ---- modify -------
    println("key0 -> ${toolbox_mu["Nail"]}")
    toolbox_mu.put("Nail", "Hammer1")
    println("key1 -> ${toolbox_mu["Nail"]}")
    toolbox_mu["Nail"] = "1"
    println("key2 -> ${toolbox_mu["Nail"]}")
    toolbox_mu.remove("Lumber")
    println(toolbox_mu)

}