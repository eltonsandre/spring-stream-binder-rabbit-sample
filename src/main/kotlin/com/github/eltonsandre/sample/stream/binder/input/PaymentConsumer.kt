package com.github.eltonsandre.sample.stream.binder.input

import com.github.eltonsandre.sample.LoggerDelegate
import org.springframework.messaging.Message
import org.springframework.stereotype.Component
import java.util.function.Consumer

@Component
class PaymentConsumer: Consumer<Message<String>> {

    private val log by LoggerDelegate()

    override fun accept(paymentMessage: Message<String>) {
        log.info("PaymentConsumer: $paymentMessage")
    }

}