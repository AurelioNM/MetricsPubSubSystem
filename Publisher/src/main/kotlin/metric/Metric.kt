package metric

import kotlinx.datetime.Instant
import kotlinx.serialization.*

@Serializable
class Metric(
    override val nameSpace: String,
    override val time: Instant,
    override val value: Int,
    override val details: Map<String, String>,
    override val tags: List<String>,
    override val type: MetricType,
) : IMetric {

}