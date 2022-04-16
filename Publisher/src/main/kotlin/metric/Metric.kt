package metric

import java.math.BigDecimal
import java.time.LocalDateTime

class Metric(
    override val nameSpace: String,
    override val time: LocalDateTime,
    override val value: BigDecimal,
    override val details: Map<String, String>,
    override val tags: List<String>,
    override val type: MetricType,
) : IMetric {

    override fun toString(): String {
        return "Metric(nameSpace='$nameSpace', time=$time, value=$value, details=$details, tags=$tags, type=$type)"
    }
}