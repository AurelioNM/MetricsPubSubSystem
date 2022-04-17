import com.rabbitmq.client.CancelCallback
import com.rabbitmq.client.ConnectionFactory
import com.rabbitmq.client.DeliverCallback
import com.rabbitmq.client.Delivery
import java.nio.charset.StandardCharsets

fun main() {
    val factory = ConnectionFactory()
    val connection = factory.newConnection("amqp://guest:guest@localhost:5672/")
    val channel = connection.createChannel()
    val consumerTag = "MetricConsumer"

    channel.queueDeclare("metric_queue", true, false, false, null)

    println("[$consumerTag] Waiting for messages...")

    val deliverCallback = DeliverCallback { tag: String?, delivery: Delivery ->
        val message = String(delivery.body, StandardCharsets.UTF_8)
        println("[$tag] Received message: '$message'")
    }

    val cancelCallback = CancelCallback { tag: String? ->
        println("[$tag] was canceled")
    }

    channel.basicConsume("metric_queue", true, consumerTag, deliverCallback, cancelCallback)
}