package com.aquidigital.techtestcv

sealed class Stub {
    object Success : Stub()
    object GenericError : Stub()
}