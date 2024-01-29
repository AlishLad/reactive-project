package com.reative;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.util.Arrays;

@SpringBootTest
class ReactiveProjectApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void workingWithMono() {
//		Mono<String> error = Mono.error(new RuntimeException("Run Error by User!"));
//
//		Mono<String> m1 = Mono.just("learning mono").log().then(error);
//
//		m1.subscribe(data->{
//			System.out.println("data is "+data);
//		});

//		error.subscribe(System.out::println);
		Mono<String> m1 = Mono.just("hello i am alish");
		Mono<String> m2 = Mono.just("World");
		Mono<Integer> m3 = Mono.just(1234);

//		Mono<Tuple2<String, String>> zip = Mono.zip(m1, m2);
//
//		zip.subscribe(data->{
//			System.out.println(data.getT1());
//			System.out.println(data.getT2());
//		});
//
//		Mono<Tuple2<String, String>> zipWith = m1.zipWith(m2);
//
//		zipWith.subscribe(data->{
//			System.out.println(data);
//
//		});

		Mono<String> map = m1.map(a -> a.toUpperCase());
		map.subscribe(System.out::println);

//		Mono<String[]> m4 = map.flatMap(valueM1 -> Mono.just(valueM1.split(" ")));
//		m4.subscribe(s->{
//			for (String s1:s
//				 ) {
//				System.out.println(s1);
//			}
//		});

		Flux<String> stringFlux = map.flatMapMany(val -> Flux.just(val.split(" "))).log();
		stringFlux.subscribe(System.out::println);

		System.out.println("******************");
		Flux<String> stringFlux1 = map.concatWith(m2).log();
		stringFlux1.subscribe(System.out::println);
	}
	}




