package id.amalmu.app.data

import id.amalmu.app.external.isDebug
import id.amalmu.app.external.logError
import id.amalmu.app.external.logInfo
import okhttp3.Interceptor
import okhttp3.RequestBody
import okhttp3.Response
import okio.Buffer
import okio.GzipSource
import java.io.IOException
import java.nio.charset.Charset

/**
 * Created by Iqbal Fauzi at 05/12/21
 * iqbal.fauzi.if99@gmail.com
 */
class TokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        val token: String? = null

        if (token.isNullOrEmpty())

        request = request.newBuilder()
//            .addHeader("Authorization", ServerConstants.TOKEN)
            .method(request.method, request.body)
            .build()

        isDebug {
            repeat(request.headers.count()) {
                logInfo("Header ${request.headers.name(it)} = ${request.headers.value(it)}")
            }
        }

        val response = chain.proceed(request)
        val param = response.request.body?.bodyToString()
        val code = response.code
        if (code in 400..500) {
            responseBody(response)?.also { errorString ->
                // error string here is a body of server error
//                crashLytics.recordError(Throwable("url = ${response.request.url}\nparams = ${response.request.body?.bodyToString()}\nresponse = $errorString"))
                logError("url = ${response.request.url}\nparams = ${param}\nresponse = $errorString")
            }
        }

        return response
    }

    private fun RequestBody.bodyToString(): String {
        return try {
            val copy: RequestBody = this
            val buffer = Buffer()
            copy.writeTo(buffer)
            buffer.readUtf8()
        } catch (e: IOException) {
            "did not work"
        }
    }

    private fun responseBody(response: Response): String? {
        val responseBody = response.body ?: return null
        val contentLength = responseBody.contentLength()

        if (contentLength == 0L) {
            return null
        }

        val source = responseBody.source()
        source.request(Long.MAX_VALUE) // Buffer the entire body.
        var buffer = source.buffer
        val headers = response.headers

        if ("gzip".equals(headers["Content-Encoding"], ignoreCase = true)) {
            var gzippedResponseBody: GzipSource? = null
            try {
                gzippedResponseBody = GzipSource(buffer.clone())
                buffer = Buffer()
                buffer.writeAll(gzippedResponseBody)
            } finally {
                gzippedResponseBody?.close()
            }
        }

        val charset: Charset = responseBody.contentType()?.charset(UTF8) ?: UTF8
        return buffer.clone().readString(charset)
    }

    companion object {
        val UTF8: Charset = Charset.forName("UTF-8")
    }

}