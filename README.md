![icon](.idea/icon.png) 
## Spring-stream-binder-rabbit
Connecting to multiple vhosts and/or RabbitMQ brokers with the help of Spring stream binder and function

## Requisites
* Run [docker-compose](/docker-compose.yml);
* Create 2 virtualhosts on RabbitMQ: sales and payment;
* Create queues: payment.queue (payment) and sales.queue (sales);
* Binding queues to exchange amq.topic;

## Consumer:
* [SalesConsumer](src/main/kotlin/com/github/eltonsandre/sample/stream/binder/input/SalesConsumer.kt)
* [PaymentConsumer](src/main/kotlin/com/github/eltonsandre/sample/stream/binder/input/PaymentConsumer.kt)
