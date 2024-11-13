package org.thingsboard.server.service.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RpcSubmitStrategyDiffblueTest {
  /**
   * Test {@link RpcSubmitStrategy#parse(String)}.
   * <ul>
   *   <li>When {@code BURST}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcSubmitStrategy#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String); when 'BURST'")
  void testParse_whenBurst() {
    // Arrange, Act and Assert
    assertEquals(RpcSubmitStrategy.BURST, RpcSubmitStrategy.parse("BURST"));
  }

  /**
   * Test {@link RpcSubmitStrategy#parse(String)}.
   * <ul>
   *   <li>When {@code Strategy Str}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcSubmitStrategy#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String); when 'Strategy Str'")
  void testParse_whenStrategyStr() {
    // Arrange, Act and Assert
    assertEquals(RpcSubmitStrategy.BURST, RpcSubmitStrategy.parse("Strategy Str"));
  }
}
