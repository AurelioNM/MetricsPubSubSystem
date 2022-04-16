Uma API que publica Métrica { PostMetric(IMetric metric); } numa fila e
outra que consome a fila e guarda a Métrica em algum lugar

```bash
IMetric()
{
timestamp GetTime()
string GetNamespace()
decimal GetValue()
IDictionaty<string,string> GetDetails()
IList<string> GetTags()
MetricType GetType()
}

enum MetricType
{
Value,
Summary,
Counter,
Interval
}


Método:
PostMetric(IMetric metric);

- Put em uma Queue<IMetric>
- Outra thread consumindo a fila

Requisitos:
- Processamento Async
- Grave isso em um TSDB (timeseries/Graphite?)
- Exibir em um grafana
- Log de atividades
- Log de performance:
eventos/s,
tempo médio por evento,
tamanho médido do dado recebido -> Tempo de processamento da entrada,
tempo de processametno da gravação,
latência (intervalo entre o recebimento e a gravação)