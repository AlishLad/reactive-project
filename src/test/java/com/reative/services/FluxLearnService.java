package com.reative.services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@Service
public class FluxLearnService {

   public Flux<String> fluxTesting(){
      return Flux.just("alish","lad","helo","world");
    }

    public Flux<String> fruitflux(){
        List<String> fruits= List.of("mango","apple");
        return Flux.fromIterable(fruits);
    }

    public Flux<Object> emptyFlux(){
       return Flux.empty().log();
    }
    public Flux<String> mapFlux(){
        return fluxTesting().map(f->f.toUpperCase());
    }

    public Flux<String> filterFlux(){
        return fluxTesting().filter(f->f.length()>4).log();
    }

    public Flux<String> flatMapFlux(){
        return fluxTesting().flatMap(data->Flux.just(data.split(""))).log();
    }

    public Flux<String> FluxLengthTest(int length){
        return fluxTesting().filter(d->d.length()>length).log().defaultIfEmpty("is empty");
    }

    public Flux<String> fluxConcatTest() {
        return Flux.concat(fluxTesting().delayElements(Duration.ofSeconds(2)), fruitflux()).log();
    }

    public Flux<String> fluxMergeTest() {
        return Flux.merge(fluxTesting().delayElements(Duration.ofSeconds(2)), fruitflux()).log();
    }
}
