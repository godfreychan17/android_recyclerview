package com.godfery.recyclerviewsample.util

data class Resource <out T> (val status: Status, val data:T?, val msg: String?) {

    companion object {
        fun <T> success( data : T?) : Resource<T>{
            return Resource(Status.Success, data, null)
        }

        fun <T> loading( ) : Resource<T>{
            return Resource(Status.Loading, null, null)
        }

        fun <T> fail( msg : String?) : Resource<T>{
            return Resource(Status.Error, null, msg)
        }
    }
}