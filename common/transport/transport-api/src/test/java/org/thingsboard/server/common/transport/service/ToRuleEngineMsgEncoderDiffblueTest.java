package org.thingsboard.server.common.transport.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.ToRuleEngineMsg;

class ToRuleEngineMsgEncoderDiffblueTest {
  /**
   * Test {@link ToRuleEngineMsgEncoder#encode(ToRuleEngineMsg)} with {@code ToRuleEngineMsg}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ToRuleEngineMsgEncoder#encode(TransportProtos.ToRuleEngineMsg)}
   */
  @Test
  @DisplayName(
      "Test encode(ToRuleEngineMsg) with 'ToRuleEngineMsg'; when DefaultInstance; then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ToRuleEngineMsgEncoder.encode(TransportProtos.ToRuleEngineMsg)"})
  void testEncodeWithToRuleEngineMsg_whenDefaultInstance_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {}, new ToRuleEngineMsgEncoder().encode(ToRuleEngineMsg.getDefaultInstance()));
  }
}
