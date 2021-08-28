package com.kwang0.movierepository.data.exception

class ServiceException(errorMessage: String = "An error has occurred with the server"):
    Exception(errorMessage)
