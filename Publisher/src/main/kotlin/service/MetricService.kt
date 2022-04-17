package service

import com.rabbitmq.client.ConnectionFactory
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import metric.IMetric
import metric.Metric
import java.nio.charset.StandardCharsets

class MetricService {

    private val factory = ConnectionFactory()
    private val queueName = "metric_queue"

    fun postMetric(metric: Metric) {

        factory.newConnection("amqp://guest:guest@localhost:5672/").use { connection ->
            connection.createChannel().use { channel ->
                channel.queueDeclare(queueName, true, false, false, null)

                channel.basicPublish(
                    "",
                    queueName,
                    null,
                    Json.encodeToString(metric).toByteArray(StandardCharsets.UTF_8)
                )
            }
        }

    }

}