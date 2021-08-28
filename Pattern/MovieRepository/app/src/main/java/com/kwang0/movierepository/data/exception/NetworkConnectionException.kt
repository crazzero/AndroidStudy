package com.kwang0.movierepository.data.exception

class NetworkConnectionException(errorMessage: String = "The connection has failed"):
    Exception(errorMessage)
