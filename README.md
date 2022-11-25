# GraphQL - Observability issue

Uses java 17.
```
./gradlew bootRun 
```

Endpoint `http://localhost:8080/dummy` can be called, results in a trace-id.

When opening `http://localhost:8080/graphiql` an exception is thrown:

```
2022-11-25 16:11:17.504 ERROR 64991 [] --- [nio-8080-exec-2] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] threw exception

java.lang.NullPointerException: Cannot invoke "Object.toString()" because the return value of "java.util.Map.get(Object)" is null
	at org.springframework.graphql.observation.ExecutionRequestObservationContext.lambda$new$0(ExecutionRequestObservationContext.java:35)
	at io.micrometer.tracing.handler.PropagatingReceiverTracingObservationHandler.lambda$onStart$0(PropagatingReceiverTracingObservationHandler.java:59)
	at io.micrometer.tracing.brave.bridge.W3CPropagation.lambda$extractor$1(W3CPropagation.java:249)
	at io.micrometer.tracing.brave.bridge.BravePropagator.extract(BravePropagator.java:59)
	at io.micrometer.tracing.handler.PropagatingReceiverTracingObservationHandler.onStart(PropagatingReceiverTracingObservationHandler.java:58)
	at io.micrometer.tracing.handler.PropagatingReceiverTracingObservationHandler.onStart(PropagatingReceiverTracingObservationHandler.java:35)
	at io.micrometer.observation.ObservationHandler$FirstMatchingCompositeObservationHandler.lambda$onStart$1(ObservationHandler.java:134)
	at java.base/java.util.Optional.ifPresent(Optional.java:178)
	at io.micrometer.observation.ObservationHandler$FirstMatchingCompositeObservationHandler.onStart(ObservationHandler.java:134)
	at io.micrometer.observation.SimpleObservation.lambda$notifyOnObservationStarted$2(SimpleObservation.java:188)
	at java.base/java.util.ArrayDeque.forEach(ArrayDeque.java:888)
	at io.micrometer.observation.SimpleObservation.notifyOnObservationStarted(SimpleObservation.java:188)
	at io.micrometer.observation.SimpleObservation.start(SimpleObservation.java:143)
	at org.springframework.graphql.observation.GraphQlObservationInstrumentation.beginExecution(GraphQlObservationInstrumentation.java:105)
	at graphql.execution.instrumentation.ChainedInstrumentation.lambda$beginExecution$0(ChainedInstrumentation.java:85)
	at graphql.collect.ImmutableKit.mapAndDropNulls(ImmutableKit.java:107)
	at graphql.execution.instrumentation.ChainedInstrumentation.beginExecution(ChainedInstrumentation.java:83)
	at graphql.GraphQL.executeAsync(GraphQL.java:522)
	at org.springframework.graphql.execution.DefaultExecutionGraphQlService.lambda$execute$2(DefaultExecutionGraphQlService.java:82)
	...
```
