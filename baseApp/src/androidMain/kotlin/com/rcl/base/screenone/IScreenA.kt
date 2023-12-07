package com.rcl.base.screenone

import com.arkivanov.decompose.value.Value

interface IScreenA {
    var counter: Value<Int>
    fun increment()
    fun decrement()
}