package service

import com.rabbitmq.client.ConnectionFactory
import metric.IMetric
import java.nio.charset.StandardCharsets

class MetricService {

    private val factory = ConnectionFactory()

    fun postMetric(metric: IMetric) {

        factory.newConnection("amqp://guest:guest@localhost:5672/").use { connection ->
            connection.createChannel().use { channel ->
                channel.queueDeclare("metric_queue", false, false, false, null)

                channel.basicPublish(
                    "",
                    "metric_queue",
                    null,
                    metric.toString().toByteArray(StandardCharsets.UTF_8)
                )
            }
        }

    }

}