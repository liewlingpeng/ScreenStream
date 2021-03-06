package info.dvkr.screenstream.data.presenter.settings

import android.support.annotation.Keep
import rx.Observable

interface SettingsView {
    // From SettingsActivity to SettingsPresenter
    @Keep sealed class FromEvent {
        @Keep data class MinimizeOnStream(val value: Boolean) : FromEvent()
        @Keep data class StopOnSleep(val value: Boolean) : FromEvent()
        @Keep data class StartOnBoot(val value: Boolean) : FromEvent()
        @Keep data class DisableMjpegCheck(val value: Boolean) : FromEvent()
        @Keep data class HtmlBackColor(val value: Int) : FromEvent()
        @Keep data class ResizeFactor(val value: Int) : FromEvent()
        @Keep data class JpegQuality(val value: Int) : FromEvent()
        @Keep data class EnablePin(val value: Boolean) : FromEvent()
        @Keep data class HidePinOnStart(val value: Boolean) : FromEvent()
        @Keep data class NewPinOnAppStart(val value: Boolean) : FromEvent()
        @Keep data class AutoChangePin(val value: Boolean) : FromEvent()
        @Keep data class SetPin(val value: String) : FromEvent()
        @Keep data class UseWiFiOnly(val value: Boolean) : FromEvent()
        @Keep data class ServerPort(val value: Int) : FromEvent()
    }

    // Events from SettingsActivity to SettingsPresenter
    fun fromEvent(): Observable<FromEvent>

    // To SettingsActivity from SettingsPresenter
    @Keep sealed class ToEvent {
        @Keep data class MinimizeOnStream(val value: Boolean) : ToEvent()
        @Keep data class StopOnSleep(val value: Boolean) : ToEvent()
        @Keep data class StartOnBoot(val value: Boolean) : ToEvent()
        @Keep data class DisableMjpegCheck(val value: Boolean) : ToEvent()
        @Keep data class HtmlBackColor(val value: Int) : ToEvent()
        @Keep data class ResizeFactor(val value: Int) : ToEvent()
        @Keep data class JpegQuality(val value: Int) : ToEvent()
        @Keep data class EnablePin(val value: Boolean) : ToEvent()
        @Keep data class HidePinOnStart(val value: Boolean) : ToEvent()
        @Keep data class NewPinOnAppStart(val value: Boolean) : ToEvent()
        @Keep data class AutoChangePin(val value: Boolean) : ToEvent()
        @Keep data class SetPin(val value: String) : ToEvent()
        @Keep data class UseWiFiOnly(val value: Boolean) : ToEvent()
        @Keep data class ServerPort(val value: Int) : ToEvent()

        // Error message
        @Keep
        class ErrorServerPortBusy : ToEvent()
    }

    // Events to SettingsActivity from SettingsPresenter
    fun toEvent(toEvent: ToEvent)
}