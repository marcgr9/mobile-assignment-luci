package ro.marc.meditation

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module
import org.koin.dsl.module


class Application: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin()
    }

    private fun vmMoudles() = module {
        viewModel {
            MainActivityVM()
        }
    }

    private fun startKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@Application)
            modules(vmMoudles())
        }
    }

}
