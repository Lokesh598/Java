package org.java.learning.webflux;

import reactor.core.publisher.Flux;

public class BackPressure {

    public static void main(String[] args1) {
        Flux<Integer> dataSource = Flux.range(1, Integer.MAX_VALUE);

        dataSource.limitRate(10)
                .doOnNext( data -> {
                    try { // Simulating a slow consumer
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(data);
                }).subscribe();
    }
}

// // create a class and method for creating 2 different streams

class StreamCreator {

    public Flux<Integer> createStream1() {
        return Flux.range(1, 50);
    }
//    public Flux<Integer> createStream2() {
//        return Flux.range(51, 100);
//    }
    public Flux<String> createStream2() {
        return Flux.just("A", "B", "C", "D", "E");
    }

    public static void main(String[] args) {
        StreamCreator streamCreator = new StreamCreator();
        streamCreator.createStream1().all(i->i*2 == 0).doOnNext(System.out::println).subscribe();
        streamCreator.createStream1().zipWith(streamCreator.createStream2()).subscribe(System.out::println);
    }
}

