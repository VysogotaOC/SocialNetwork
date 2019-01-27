package deusvult.petrkamaev.homework_5.Info

sealed class Feed {
    data class news(
        val title: String,
        val body: String
    ) : Feed()

    data class notifications(
        //val logoId: Int,
        val title: String
    ) : Feed()
}