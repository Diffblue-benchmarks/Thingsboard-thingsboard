package org.thingsboard.server.common.transport.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.common.DefaultTbQueueMsg;
import org.thingsboard.server.queue.common.TbProtoQueueMsg;

class TransportApiResponseDecoderDiffblueTest {
  /**
   * Test {@link TransportApiResponseDecoder#decode(TbQueueMsg)}.
   *
   * <ul>
   *   <li>Then return SerializedSize is four.
   * </ul>
   *
   * <p>Method under test: {@link TransportApiResponseDecoder#decode(TbQueueMsg)}
   */
  @Test
  @DisplayName("Test decode(TbQueueMsg); then return SerializedSize is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.gen.transport.TransportProtos.TransportApiResponseMsg TransportApiResponseDecoder.decode(TbQueueMsg)"
  })
  void testDecode_thenReturnSerializedSizeIsFour() throws IOException {
    // Arrange
    TransportApiResponseDecoder transportApiResponseDecoder = new TransportApiResponseDecoder();

    // Act and Assert
    assertEquals(
        4,
        transportApiResponseDecoder
            .decode(
                new DefaultTbQueueMsg(
                    new TbProtoQueueMsg<>(
                        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
                        TransportActivityManager.SESSION_EVENT_MSG_CLOSED)))
            .getSerializedSize());
  }
}
