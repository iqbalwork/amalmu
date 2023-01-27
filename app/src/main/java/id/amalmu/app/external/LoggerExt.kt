package id.amalmu.app.external

import com.orhanobut.logger.Logger
import timber.log.Timber

/**
 * Created by Iqbal Fauzi at 04/11/21
 * iqbal.fauzi.if99@gmail.com
 */
fun timberInitialization() {
    isDebug {

        Timber.plant(object : Timber.DebugTree() {

            private val CRASHLYTICS_KEY_PRIORITY = "priority"
            private val CRASHLYTICS_KEY_TAG = "tag"
            private val CRASHLYTICS_KEY_MESSAGE = "message"
//            private val crashlytics = Crashlytics()

            override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
//                if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO) {
//                    return
//                }
                Logger.log(priority, tag, message, t)
//                crashlytics.run {
//                    setKey(CRASHLYTICS_KEY_PRIORITY, priority)
//                    tag?.let { setKey(CRASHLYTICS_KEY_TAG, it) }
//                    setKey(CRASHLYTICS_KEY_MESSAGE, message)
//                    t?.let { recordError(it) }
//                }
            }
        })
    }
}

fun logInfo(s: String, vararg objects: Any) {
    Timber.i(s, *objects)
}

fun logInfo(throwable: Throwable, s: String, vararg objects: Any) {
    Timber.i(throwable, s, *objects)
}

fun logDebug(s: String, vararg objects: Any) {
    Timber.d(s, *objects)
}

fun logDebug(throwable: Throwable, s: String, vararg objects: Any) {
    Timber.d(throwable, s, *objects)
}

fun logWarning(s: String, vararg objects: Any) {
    Timber.d(s, *objects)
}

fun logWarning(throwable: Throwable, s: String, vararg objects: Any) {
    Timber.w(throwable, s, *objects)
}

fun logVerbose(s: String, vararg objects: Any) {
    Timber.v(s, *objects)
}

fun logVerbose(throwable: Throwable, s: String, vararg objects: Any) {
    Timber.v(throwable, s, *objects)
}

fun logError(s: String, vararg objects: Any) {
    Timber.e(s, *objects)
}

fun logError(throwable: Throwable, s: String, vararg objects: Any) {
    Timber.e(throwable, s, *objects)
}

fun logException(ex: Exception) {
    Timber.e(ex)
}