package click.erudosaba.erudo.etwitchalert.util

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.JsonAdapter
import com.sun.xml.internal.fastinfoset.util.StringArray

data class JsonContent(
    @JsonProperty("data") val data : Data,
    @JsonProperty("pagination") val pagination : Pagination
    )

data class Data(
    val content : Content
    )

data class Pagination(
    val cursor : String
    )

data class Content(
    val lang : String,
    val displayName : String,
    val gameID : String,
    val id : String,
    val title : String,
    val thumbnailURL : String,
    val isLive : Boolean,
    val startedAt : String,
    val tagIds : String
    )