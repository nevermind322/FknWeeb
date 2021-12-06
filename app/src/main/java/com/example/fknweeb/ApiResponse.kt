package com.example.fknweeb


sealed class ApiResponse{

    data class Success<T>(val data : List<T>)  : ApiResponse()

    data class Failure(val error : ApiError) : ApiResponse()


}

sealed class ApiError{



    object ServerError : ApiError() {
        override fun toString(): String = "Server Error"
    }

    object NotFound  :ApiError(){
        override fun toString(): String = "Not Found"
    }

    object UnknownError : ApiError(){override fun toString(): String = "UnknownError"
    }

}

