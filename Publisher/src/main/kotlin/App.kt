import controller.MetricController
import io.javalin.Javalin

fun main(args: Array<String>) {

    val app = Javalin.create().start(8085)

    val metricController = MetricController()
    app.routes {
        metricController.postMetricValue()
        metricController.postMetricSummary()
        metricController.postMetricCounter()
        metricController.postMetricInterval()
    }
}