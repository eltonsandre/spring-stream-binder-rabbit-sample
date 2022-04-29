package com.github.eltonsandre.sample

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty
import kotlin.reflect.full.companionObject

@EnableRabbit
@SpringBootApplication
class SampleApplication

fun main(args: Array<String>) {
	runApplication<SampleApplication>(*args)
}

class LoggerDelegate<in R : Any> : ReadOnlyProperty<R, Logger> {
	override fun getValue(thisRef: R, property: KProperty<*>): Logger = LoggerFactory.getLogger(getClassForLogging(thisRef.javaClass))
}

fun <T : Any> getClassForLogging(javaClass: Class<T>): Class<*> {
	return javaClass.enclosingClass?.takeIf { it.kotlin.companionObject?.java == javaClass } ?: javaClass
}