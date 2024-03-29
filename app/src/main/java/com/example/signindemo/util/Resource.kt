package com.example.signindemo.util

sealed class Resource<out T>{
    class Loading<out T>: Resource<T>()
    class Success<out T> (val data: T): Resource<T>()
    class Error<out T> (val message: String): Resource<T>()

}