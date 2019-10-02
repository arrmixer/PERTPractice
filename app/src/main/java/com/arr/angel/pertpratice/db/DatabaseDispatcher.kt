package com.arr.angel.pertpratice.db

import kotlinx.coroutines.asCoroutineDispatcher
import java.util.concurrent.Executors

val DB = Executors.newSingleThreadExecutor().asCoroutineDispatcher()