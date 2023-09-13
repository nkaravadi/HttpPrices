package org.demo.cop.priceservice.controller;

import org.demo.cop.priceservice.domain.PriceDetail;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PriceRestContoller {
    private final static String sourceId = UUID.randomUUID().toString();
    private final PriceGenerator priceGenerator = new PriceGenerator();

    @GetMapping("/price")
    public PriceDetail getPrice(@RequestParam(value = "ticker", defaultValue = "WFC") String ticker) {
        return new PriceDetail(ticker, priceGenerator.getPrice(ticker), sourceId);
    }

}
