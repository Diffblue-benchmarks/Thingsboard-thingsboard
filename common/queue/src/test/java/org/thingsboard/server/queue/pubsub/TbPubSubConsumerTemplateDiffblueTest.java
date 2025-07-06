package org.thingsboard.server.queue.pubsub;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.gax.core.CredentialsProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.TbQueueAdmin;
import org.thingsboard.server.queue.TbQueueMsgDecoder;

class TbPubSubConsumerTemplateDiffblueTest {
  /**
   * Test {@link TbPubSubConsumerTemplate#TbPubSubConsumerTemplate(TbQueueAdmin, TbPubSubSettings,
   * String, TbQueueMsgDecoder)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbPubSubConsumerTemplate#TbPubSubConsumerTemplate(TbQueueAdmin,
   * TbPubSubSettings, String, TbQueueMsgDecoder)}
   */
  @Test
  @DisplayName(
      "Test new TbPubSubConsumerTemplate(TbQueueAdmin, TbPubSubSettings, String, TbQueueMsgDecoder); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbPubSubConsumerTemplate.<init>(TbQueueAdmin, TbPubSubSettings, String, TbQueueMsgDecoder)"
  })
  void testNewTbPubSubConsumerTemplate_thenThrowRuntimeException() {
    // Arrange
    TbPubSubSettings pubSubSettings = mock(TbPubSubSettings.class);
    when(pubSubSettings.getMaxMsgSize()).thenThrow(new RuntimeException("foo"));
    when(pubSubSettings.getCredentialsProvider()).thenReturn(mock(CredentialsProvider.class));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new TbPubSubConsumerTemplate<>(
                null, pubSubSettings, "Topic", mock(TbQueueMsgDecoder.class)));

    verify(pubSubSettings).getCredentialsProvider();
    verify(pubSubSettings).getMaxMsgSize();
  }
}
