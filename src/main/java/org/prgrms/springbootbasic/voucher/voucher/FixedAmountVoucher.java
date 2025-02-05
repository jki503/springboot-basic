package org.prgrms.springbootbasic.voucher.voucher;

import java.util.UUID;

public class FixedAmountVoucher extends Voucher {
  private final UUID voucherId;
  private final long amount;

  public FixedAmountVoucher(UUID voucherId, long amount) {
    this.voucherId = voucherId;
    this.amount = amount;
  }

  @Override
  public UUID getVoucherID() {
    return voucherId;
  }

  public long discount(long beforeDiscount) {
    return beforeDiscount - amount;
  }

  @Override
  public String toString() {
    return "FixedAmountVoucher{" +
      "voucherId=" + voucherId +
      ", amount=" + amount +
      '}';
  }
}
