package com.reative;

import com.reative.services.FluxLearnService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class FluxLearnTest {


    @Autowired
   private FluxLearnService fluxLearnService;

    int count=1;
    @Test
    void testing(){
        fluxLearnService.fluxTesting().subscribe(data->{
            System.out.println(data);
            System.out.println("count"+count);
            count++;
        });
    }

    @Test
    void testingIterable(){
        fluxLearnService.fruitflux().subscribe(d->{
            System.out.println(d);
        });
    }

    @Test
    void testingEmpty(){
        fluxLearnService.emptyFlux().subscribe(e->{
            System.out.println(e);
        });
    }

    @Test
    void testingMapFlux(){
        fluxLearnService.mapFlux().subscribe(e->{
            System.out.println(e);
        });
    }

//    @Test
//    void testingMapFluxExpect(){
//        Flux<String> stringFlux = fluxLearnService.mapFlux();
//        StepVerifier.create(stringFlux).expectNext("alish","lad".toUpperCase(),"helo".toUpperCase(),"world".toUpperCase()).verifyComplete();
//    }
//
//
//    @Test
//    void filterFlux() {
//        Flux<String> stringFlux = fluxLearnService.filterFlux();
//        StepVerifier.create(stringFlux).expectNext("alish","world","lad").verifyComplete();
//
//    }

    @Test
    void flatMapFlux() {
        Flux<String> stringFlux = fluxLearnService.flatMapFlux();
        StepVerifier.create(stringFlux).expectNextCount(17).verifyComplete();

    }

    @Test
    void fluxLengthTest() {
        Flux<String> stringFlux = fluxLearnService.FluxLengthTest(10);
        StepVerifier.create(stringFlux).expectNextCount(1).verifyComplete();
        stringFlux.subscribe(d->{
            System.out.println(d);
        }
        );
    }

    @Test
    void fluxConcatTest() {
        Flux<String> stringFlux = fluxLearnService.fluxConcatTest();
        StepVerifier.create(stringFlux).expectNextCount(6).verifyComplete();
    }

    @Test
    void fluxMergeTest() {
        Flux<String> stringFlux = fluxLearnService.fluxMergeTest();
        StepVerifier.create(stringFlux).expectNextCount(6).verifyComplete();
    }
}
