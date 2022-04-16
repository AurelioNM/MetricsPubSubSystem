package metric

import java.math.BigDecimal
import java.time.LocalDateTime

interface IMetric {
    val nameSpace: String
    val time: LocalDateTime
    val value: BigDecimal
    val details: Map<String, String>
    val tags: List<String>
    val type: MetricType
}