package org.prgrms.kdt.voucher;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by yhh1056
 * Date: 2021/08/30 Time: 6:28 오후
 */
public class Voucher {

    private final UUID voucherId;

    private String name;

    private final Long discount;

    private final VoucherType voucherType;

    private final LocalDateTime createdAt;

    public Voucher(UUID voucherId, String name, Long discount, VoucherType voucherType, LocalDateTime createdAt) {
        this.voucherId = voucherId;
        this.name = name;
        this.discount = discount;
        this.voucherType = voucherType;
        this.createdAt = createdAt;
    }

    public static Voucher of(String name, Long discount, VoucherType voucherType) {
        return new Voucher(UUID.randomUUID(), name, discount, voucherType, LocalDateTime.now());
    }

    public UUID getVoucherId() {
        return voucherId;
    }

    public String getName() {
        return name;
    }

    public Long getDiscount() {
        return discount;
    }

    public VoucherType getVoucherType() {
        return voucherType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void changeName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Voucher)) {
            return false;
        }
        Voucher voucher = (Voucher) o;
        return Objects.equals(voucherId, voucher.voucherId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voucherId);
    }
}
