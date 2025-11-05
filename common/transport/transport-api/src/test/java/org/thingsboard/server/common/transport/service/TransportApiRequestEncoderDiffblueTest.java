package org.thingsboard.server.common.transport.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.TransportApiRequestMsg;

class TransportApiRequestEncoderDiffblueTest {
  /**
   * Test {@link TransportApiRequestEncoder#encode(TransportApiRequestMsg)} with {@code
   * TransportApiRequestMsg}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TransportApiRequestEncoder#encode(TransportApiRequestMsg)}
   */
  @Test
  @DisplayName(
      "Test encode(TransportApiRequestMsg) with 'TransportApiRequestMsg'; then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TransportApiRequestEncoder.encode(TransportApiRequestMsg)"})
  void testEncodeWithTransportApiRequestMsg_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {},
        new TransportApiRequestEncoder().encode(TransportApiRequestMsg.getDefaultInstance()));
  }
}
