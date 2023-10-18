package com.example.stock.service;

import com.example.stock.StockRepository.StockRepository;
import com.example.stock.domain.Stock;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional
    public void decrease(Long id, Long quantity){
        // Stock 조회
        // 재고를 감소한뒤
        // 갱신된 값을 저장하도록 함

        Stock stock = (Stock) stockRepository.findById(id).orElseThrow();
        stock.decrease(quantity);

        stockRepository.saveAndFlush(stock);

    }
}
