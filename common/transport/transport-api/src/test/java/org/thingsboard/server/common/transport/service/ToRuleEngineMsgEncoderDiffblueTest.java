package org.thingsboard.server.common.transport.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.TransportProtos;

class ToRuleEngineMsgEncoderDiffblueTest {
  /**
   * Test {@link ToRuleEngineMsgEncoder#encode(ToRuleEngineMsg)} with
   * {@code ToRuleEngineMsg}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ToRuleEngineMsgEncoder#encode(TransportProtos.ToRuleEngineMsg)}
   */
  @Test
  @DisplayName("Test encode(ToRuleEngineMsg) with 'ToRuleEngineMsg'; when DefaultInstance; then return array length is zero")
  void testEncodeWithToRuleEngineMsg_whenDefaultInstance_thenReturnArrayLengthIsZero() {
    // Arrange
    ToRuleEngineMsgEncoder toRuleEngineMsgEncoder = new ToRuleEngineMsgEncoder();

    // Act and Assert
    assertEquals(0, toRuleEngineMsgEncoder.encode(TransportProtos.ToRuleEngineMsg.getDefaultInstance()).length);
  }
}
