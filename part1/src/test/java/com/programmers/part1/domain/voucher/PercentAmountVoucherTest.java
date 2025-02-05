package com.programmers.part1.domain.voucher;

import com.programmers.part1.exception.voucher.PercentErrorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PercentAmountVoucherTest {

    @Test
    @DisplayName("percent voucher의 amount는 0보다 크고 100이하로 생성 되어야한다.")
    void testCreation(){
        assertAll( "incorrect percent amount...",
                () -> assertThrows(PercentErrorException.class,() -> new PercentAmountVoucher(UUID.randomUUID(),0, LocalDateTime.now())),
                () -> assertThrows(PercentErrorException.class,() -> new PercentAmountVoucher(UUID.randomUUID(),-1, LocalDateTime.now())),
                () -> assertThrows(PercentErrorException.class,() -> new PercentAmountVoucher(UUID.randomUUID(),10, LocalDateTime.now()))
        );

        UUID id = UUID.randomUUID();

        Voucher voucher  = new PercentAmountVoucher(id,100, LocalDateTime.now());
        assertEquals(id, voucher.getVoucherId());
    }

    @Test
    @DisplayName("올바른 할인 금액 테스트")
    void testDiscount() {
        Voucher voucher  = new PercentAmountVoucher(UUID.randomUUID(),20, LocalDateTime.now());
        assertEquals(800, voucher.discount(1000));
    }
}