package com.rcl.base.screenone

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class ScreenAComponent: IScreenA {
    private val _counter = MutableValue(0)
    override var counter: Value<Int> = _counter

    override fun increment() {
        _counter.value++
    }

    override fun decrement() {
        _counter.value--
    }
}