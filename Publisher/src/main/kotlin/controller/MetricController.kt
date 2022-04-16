package controller

import io.javalin.apibuilder.ApiBuilder
import metric.Metric
import metric.MetricType
import service.MetricService
import java.math.BigDecimal
import java.time.LocalDateTime

class MetricController {

    private val metricService = MetricService()

    fun postMetricValue() {
        ApiBuilder.get("/metric/A") {

            for (n in 1 .. 5) {
                metricService.postMetric(Metric(
                    nameSpace = "",
                    time = LocalDateTime.now(),
                    value = BigDecimal(n),
                    details = mapOf("keyA" to "valueA", "keyB" to "valueB"),
                    tags = listOf("tagA", "tagB"),
                    type = MetricType.Value
                ))
            }
        }
    }

    fun postMetricSummary() {
        ApiBuilder.get("/metric/B") {

            for (n in 1 .. 5) {
                metricService.postMetric(Metric(
                    nameSpace = "",
                    time = LocalDateTime.now(),
                    value = BigDecimal(n),
                    details = mapOf("keyA" to "valueA", "keyB" to "valueB"),
                    tags = listOf("tagA", "tagB"),
                    type = MetricType.Summary
                ))
            }
        }
    }

    fun postMetricCounter() {
        ApiBuilder.get("/metric/C") {

            for (n in 1 .. 5) {
                metricService.postMetric(Metric(
                    nameSpace = "",
                    time = LocalDateTime.now(),
                    value = BigDecimal(n),
                    details = mapOf("keyA" to "valueA", "keyB" to "valueB"),
                    tags = listOf("tagA", "tagB"),
                    type = MetricType.Counter
                ))
            }
        }
    }

    fun postMetricInterval() {
        ApiBuilder.get("/metric/D") {

            for (n in 1 .. 5) {
                metricService.postMetric(Metric(
                    nameSpace = "",
                    time = LocalDateTime.now(),
                    value = BigDecimal(n),
                    details = mapOf("keyA" to "valueA", "keyB" to "valueB"),
                    tags = listOf("tagA", "tagB"),
                    type = MetricType.Interval
                ))
            }
        }
    }

}