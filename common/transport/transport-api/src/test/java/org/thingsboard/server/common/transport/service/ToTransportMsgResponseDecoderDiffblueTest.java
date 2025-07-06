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

class ToTransportMsgResponseDecoderDiffblueTest {
  /**
   * Test {@link ToTransportMsgResponseDecoder#decode(TbQueueMsg)}.
   *
   * <ul>
   *   <li>Then return SessionIdLSB is one.
   * </ul>
   *
   * <p>Method under test: {@link ToTransportMsgResponseDecoder#decode(TbQueueMsg)}
   */
  @Test
  @DisplayName("Test decode(TbQueueMsg); then return SessionIdLSB is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.gen.transport.TransportProtos.ToTransportMsg ToTransportMsgResponseDecoder.decode(TbQueueMsg)"
  })
  void testDecode_thenReturnSessionIdLSBIsOne() throws IOException {
    // Arrange
    ToTransportMsgResponseDecoder toTransportMsgResponseDecoder =
        new ToTransportMsgResponseDecoder();

    // Act and Assert
    assertEquals(
        1L,
        toTransportMsgResponseDecoder
            .decode(
                new DefaultTbQueueMsg(
                    new TbProtoQueueMsg<>(
                        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
                        DefaultTransportService.SUBSCRIBE_TO_ATTRIBUTE_UPDATES_ASYNC_MSG)))
            .getSessionIdLSB());
  }
}
