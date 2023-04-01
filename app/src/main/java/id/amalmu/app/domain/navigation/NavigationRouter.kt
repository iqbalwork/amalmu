package id.amalmu.app.domain.navigation

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Iqbal Fauzi at 30/01/23
 * iqbal.fauzi.if99@gmail.com
 */
class NavigationRouter {

    fun openActivity(
        context: Context,
        activityName: String,
        bundle: Bundle? = null,
        isFinish: Boolean = false,
        isClearStack: Boolean = false,
    ) {
        try {
            with(context) {
                val intent = Intent(this, Class.forName(activityName))
                bundle?.let { intent.putExtras(it) }
                if (isClearStack) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                }
                startActivity(intent)
                if (isFinish && context is AppCompatActivity) {
                    context.finish()
                }
            }
        } catch (ex: ClassNotFoundException) {
            ex.printStackTrace()
        }
    }

}