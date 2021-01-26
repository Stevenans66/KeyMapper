package io.github.sds100.keymapper

import android.net.Uri
import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication
import io.github.sds100.keymapper.data.AppPreferences
import io.github.sds100.keymapper.data.darkThemeMode
import io.github.sds100.keymapper.util.IContentResolver
import io.github.sds100.keymapper.util.result.FileAccessDenied
import io.github.sds100.keymapper.util.result.GenericFailure
import io.github.sds100.keymapper.util.result.Result
import io.github.sds100.keymapper.util.result.Success
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import timber.log.Timber
import java.io.OutputStream

/**
 * Created by sds100 on 19/05/2020.
 */
class MyApplication : MultiDexApplication(), IContentResolver{
    val appCoroutineScope = MainScope()

    override fun onCreate() {
        runBlocking {
            ServiceLocator.globalPreferences(this@MyApplication)
                .darkThemeMode()
                .first()
                .let { AppCompatDelegate.setDefaultNightMode(it) }
        }

        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun openOutputStream(uriString: String): Result<OutputStream> {
        val uri = Uri.parse(AppPreferences.automaticBackupLocation)

        return try {
            val outputStream = contentResolver.openOutputStream(uri)!!

            Success(outputStream)
        } catch (e: Exception) {
            when (e) {
                is SecurityException -> FileAccessDenied()
                else -> GenericFailure(e)
            }
        }
    }
}