package click.erudosaba.erudo.etwitchalert.util

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class HTTPManager(query : String) {

    val endPointURL = "https://api.twitch.tv/helix/search/channels"
    val clientId = "pypx3juv6uy129wkdsmblhje7cfhda"
    var actualURL = "${endPointURL}${query}"

    fun getResultString(): String {
        var result = ""

        try {
            var url = URL(actualURL)
            var connect : HttpURLConnection = url.openConnection() as HttpURLConnection
            connect.doOutput = true
            connect.doInput = true
            connect.useCaches = true
            connect.requestMethod = "GET"
            connect.setRequestProperty("Client-ID", clientId)
            connect.connect()

            var inputStream = connect.inputStream

            if(connect.responseCode >= 400) {
                inputStream = connect.errorStream
            } else {
                inputStream = connect.inputStream
            }

            var br = BufferedReader(InputStreamReader(inputStream,"UTF-8"))
            var temp = br.readLine()
            var builder = StringBuilder()

            while(temp != null) {
                builder.append("$temp\n")
                temp = br.readLine()
            }

            result = builder.toString()
            br.close()
            connect.disconnect()

        } catch (e : Exception) {
            e.printStackTrace()
        }

        return result
    }

    fun getJsonContent(json : String) : JsonContent {
        val mapper = jacksonObjectMapper()

        return mapper.readValue(json)
    }

}