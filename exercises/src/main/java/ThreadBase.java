import reactor.core.publisher.Mono;

public class ThreadBase {

  public static void main(String[] args) throws InterruptedException {
    System.out.println("thread " + Thread.currentThread().getName());
    final Mono<String> mono = Mono.just("hello ");

    Thread t = new Thread(() -> mono
            .map(msg -> msg + "thread ")
            .subscribe(v ->
            System.out.println(v + Thread.currentThread().getName())
        )
    );

    t.start();
    t.join();
  }
}
