package metric

import kotlinx.datetime.Instant

sealed interface IMetric {
    val nameSpace: String
    val time: Instant
    val value: Int
    val details: Map<String, String>
    val tags: List<String>
    val type: MetricType
}