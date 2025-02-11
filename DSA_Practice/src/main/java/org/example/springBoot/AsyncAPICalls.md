In Spring Boot, asynchronous API calls can be implemented using the `@Async` annotation and Spring’s `AsyncRestTemplate` or modern approaches like `WebClient` (from Spring WebFlux) for non-blocking calls. Here's a step-by-step guide:

---

### 1. **Enable Asynchronous Processing**

Add the `@EnableAsync` annotation to a configuration class or your main application class to enable asynchronous method execution:

```java
@SpringBootApplication
@EnableAsync
public class AsyncApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(AsyncApiApplication.class, args);
    }
}
```

---

### 2. **Add an Async Method**

Use the `@Async` annotation to execute a method asynchronously. The method should return `CompletableFuture`, `ListenableFuture`, or `void` (if you don't care about the result).

```java
@Service
public class AsyncService {

    @Async
    public CompletableFuture<String> fetchDataFromApi() throws InterruptedException {
        // Simulate API call
        Thread.sleep(2000); // Simulating delay
        return CompletableFuture.completedFuture("Data from API");
    }
}
```

- **Important Notes**:
    - The method must be public.
    - Calls to `@Async` methods must be made from another class or bean to work correctly (not from the same class instance).

---

### 3. **Call the Asynchronous Method**

Invoke the async method and handle the result using `CompletableFuture`.

```java
@RestController
@RequestMapping("/api")
public class ApiController {

    private final AsyncService asyncService;

    public ApiController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @GetMapping("/async-call")
    public ResponseEntity<String> makeAsyncCall() throws Exception {
        CompletableFuture<String> dataFuture = asyncService.fetchDataFromApi();
        
        // Process other tasks here while the async task executes
        return ResponseEntity.ok(dataFuture.get()); // Wait for the result
    }
}
```

---

### 4. **Non-blocking API Calls**

For non-blocking HTTP calls to other APIs, prefer **WebClient** (part of Spring WebFlux):

#### Using WebClient

```java
@Service
public class AsyncApiService {

    private final WebClient webClient;

    public AsyncApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.example.com").build();
    }

    public Mono<String> fetchAsyncData() {
        return webClient.get()
                .uri("/data")
                .retrieve()
                .bodyToMono(String.class); // Returns Mono for reactive streams
    }
}
```

#### Controller

```java
@RestController
@RequestMapping("/api")
public class ApiController {

    private final AsyncApiService asyncApiService;

    public ApiController(AsyncApiService asyncApiService) {
        this.asyncApiService = asyncApiService;
    }

    @GetMapping("/async-webclient")
    public Mono<String> fetchData() {
        return asyncApiService.fetchAsyncData();
    }
}
```

---

### 5. **Configuration for Thread Pool**

Spring Boot uses a default thread pool for async tasks. You can customize it by defining a `TaskExecutor` bean:

```java
@Configuration
public class AsyncConfig {

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(25);
        executor.setThreadNamePrefix("AsyncThread-");
        executor.initialize();
        return executor;
    }
}
```

Use the `@Async("taskExecutor")` annotation to specify the executor.

---

### Summary

#### Option 1: Using `@Async`
- Use `@Async` to make methods asynchronous.
- Return `CompletableFuture` or similar for result handling.

#### Option 2: Using `WebClient`
- Use `WebClient` for non-blocking, reactive HTTP calls.
- Return `Mono` or `Flux` for reactive streams.

Asynchronous APIs improve responsiveness by freeing up threads for other tasks while waiting for external API responses or long-running operations. Choose the approach that fits your application’s requirements (blocking vs. non-blocking).

### 1. **`CompletableFuture`**

`CompletableFuture` is a class introduced in Java 8 as part of the `java.util.concurrent` package. It is used for handling asynchronous computations in Java. It represents a future result of a computation and provides a wide range of methods to combine, transform, or compose results without blocking the calling thread.

#### Key Features:
- **Asynchronous Execution**: Run tasks asynchronously in a non-blocking way.
- **Chaining and Composition**: Chain multiple dependent tasks together.
- **Callback Handling**: Execute callbacks upon task completion.
- **Exception Handling**: Handle exceptions in asynchronous flows.

#### Common Methods:
- `supplyAsync(Supplier)`: Runs a task asynchronously that returns a result.
- `runAsync(Runnable)`: Runs a task asynchronously that doesn't return a result.
- `thenApply(Function)`: Transforms the result of a computation.
- `thenAccept(Consumer)`: Consumes the result without returning anything.
- `exceptionally(Function)`: Handles exceptions in the computation.

#### Example:
```java
CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
    // Simulate a long-running task
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        throw new IllegalStateException(e);
    }
    return "Hello from CompletableFuture!";
});

future.thenAccept(result -> System.out.println(result)); // Callback after completion
```

---

### 2. **`ListenableFuture`**

`ListenableFuture` is part of the **Guava** library (by Google). It extends Java's standard `Future` and allows registering callbacks that are invoked upon task completion, making it easier to handle asynchronous programming compared to plain `Future`.

#### Key Features:
- **Callbacks**: Add listeners that execute when the computation is complete.
- **Thread Execution**: Specify the thread or executor for callback execution.

#### Common Methods:
- `addListener(Runnable, Executor)`: Adds a listener that runs upon task completion.

#### Example:
```java
ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

ListenableFuture<String> listenableFuture = service.submit(() -> {
    Thread.sleep(1000);
    return "Hello from ListenableFuture!";
});

listenableFuture.addListener(() -> {
    try {
        System.out.println(listenableFuture.get());
    } catch (Exception e) {
        e.printStackTrace();
    }
}, Executors.newSingleThreadExecutor());
```

---

### Comparison of `CompletableFuture` and `ListenableFuture`

| Feature                | CompletableFuture                     | ListenableFuture                          |
|------------------------|---------------------------------------|------------------------------------------|
| **Origin**            | Java 8 (`java.util.concurrent`)       | Google Guava library                     |
| **Callback Support**  | Built-in with methods like `thenApply`, `thenAccept`, `exceptionally` | Requires manually adding listeners       |
| **Thread Control**    | Built-in via `thenAsync` variants      | Callback thread specified manually       |
| **Integration**       | Standard in Java, no external library | Requires Guava dependency                |
| **Flexibility**       | Rich API for chaining and composing tasks | Simpler API, less flexible               |

---

### When to Use?

- **Use `CompletableFuture`** if:
    - You are working with Java 8 or above.
    - You need advanced chaining and composition of tasks.
    - You want to avoid external dependencies.

- **Use `ListenableFuture`** if:
    - You are already using Google Guava in your project.
    - Your project is not using Java 8 or higher.
    - You need lightweight callbacks without the additional functionality of `CompletableFuture`.

In modern applications, `CompletableFuture` is preferred for its richer API and native support in Java.


In the context of `ThreadPoolTaskExecutor`, these configurations are used to manage how threads are allocated and utilized in a thread pool. Here's what each parameter means:

---

### 1. **`corePoolSize`**

- **Definition**: The number of threads that are always kept alive in the pool, even if they are idle.
- **Purpose**: It defines the baseline capacity of the thread pool. If there are fewer than `corePoolSize` threads running, the thread pool will create new threads to handle incoming tasks.

#### Key Points:
- If tasks come in and there are fewer than `corePoolSize` threads running, new threads will be created until `corePoolSize` is reached.
- If the pool size is greater than `corePoolSize`, idle threads will be terminated only if the total number exceeds `corePoolSize`.

---

### 2. **`maxPoolSize`**

- **Definition**: The maximum number of threads that can be created in the pool.
- **Purpose**: It limits the total number of threads that the pool can create, even under heavy load.

#### Key Points:
- If the pool has reached `corePoolSize` and the task queue is full (`queueCapacity` is exhausted), new threads will be created up to `maxPoolSize`.
- If the number of threads reaches `maxPoolSize` and the queue is also full, the task will be rejected (depending on the rejection policy).

---

### 3. **`queueCapacity`**

- **Definition**: The number of tasks that can be queued for execution when all core threads are busy.
- **Purpose**: It determines the buffer size for tasks waiting to be executed.

#### Key Points:
- When all `corePoolSize` threads are busy, incoming tasks are stored in the queue up to `queueCapacity`.
- If the queue is full and `maxPoolSize` has not been reached, new threads will be created until `maxPoolSize` is reached.
- If both `maxPoolSize` is reached and the queue is full, tasks will be rejected.

---

### How These Parameters Work Together

1. **Incoming Tasks**:
    - Tasks are first handled by available threads up to `corePoolSize`.

2. **When All Core Threads Are Busy**:
    - New tasks are placed in the queue up to `queueCapacity`.

3. **When the Queue Is Full**:
    - Additional threads are created up to `maxPoolSize`.

4. **When Both Max Threads and Queue Are Full**:
    - The task is rejected (depending on the rejection policy, e.g., it might throw an exception).

---

### Example:

```java
executor.setCorePoolSize(5);
executor.setMaxPoolSize(10);
executor.setQueueCapacity(25);
```

- **Scenario 1**: If you receive 3 tasks, 3 threads are created to handle them because it's below `corePoolSize`.
- **Scenario 2**: If you receive 10 tasks:
    - 5 tasks are handled by the `corePoolSize` threads.
    - 5 tasks are added to the queue.
- **Scenario 3**: If you receive 35 tasks:
    - 5 tasks are handled by `corePoolSize`.
    - 25 tasks are added to the queue (`queueCapacity`).
    - 5 more threads are created to handle the remaining tasks (`maxPoolSize` is 10).
- **Scenario 4**: If you receive more than 35 tasks:
    - Any additional tasks will be rejected, as both the queue and thread pool are at capacity.

---

### Choosing Values

- **`corePoolSize`**: Should be set based on the baseline expected workload.
- **`maxPoolSize`**: Should be set based on peak workload, keeping system resources (CPU, memory) in mind.
- **`queueCapacity`**: Should be large enough to handle short bursts of tasks but not too large to avoid memory issues.

By tuning these values, you can balance performance and resource utilization in your application.