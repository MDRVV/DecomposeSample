package com.rcl.base.screenthree

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class ScreenCComponent : IScreenC {
    private val _text = MutableValue("")
    override var text: Value<String> = _text

    fun onSearchChanged(str: String) {
        _text.value = str
    }
}