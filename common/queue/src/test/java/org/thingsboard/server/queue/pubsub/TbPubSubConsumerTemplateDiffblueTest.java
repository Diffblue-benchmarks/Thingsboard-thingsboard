/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.queue.pubsub;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.FixedExecutorProvider;
import com.google.protobuf.InvalidProtocolBufferException;
import io.grpc.netty.shaded.io.netty.channel.DefaultEventLoop;
import java.io.IOException;
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
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbPubSubConsumerTemplate#TbPubSubConsumerTemplate(TbQueueAdmin,
   * TbPubSubSettings, String, TbQueueMsgDecoder)}
   */
  @Test
  @DisplayName(
      "Test new TbPubSubConsumerTemplate(TbQueueAdmin, TbPubSubSettings, String, TbQueueMsgDecoder); given RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbPubSubConsumerTemplate.<init>(TbQueueAdmin, TbPubSubSettings, String, TbQueueMsgDecoder)"
  })
  void testNewTbPubSubConsumerTemplate_givenRuntimeException() {
    // Arrange
    TbPubSubSettings pubSubSettings = mock(TbPubSubSettings.class);
    when(pubSubSettings.getMaxMsgSize()).thenThrow(new RuntimeException());
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

  /**
   * Test {@link TbPubSubConsumerTemplate#TbPubSubConsumerTemplate(TbQueueAdmin, TbPubSubSettings,
   * String, TbQueueMsgDecoder)}.
   *
   * <ul>
   *   <li>Then calls {@link CredentialsProvider#getCredentials()}.
   * </ul>
   *
   * <p>Method under test: {@link TbPubSubConsumerTemplate#TbPubSubConsumerTemplate(TbQueueAdmin,
   * TbPubSubSettings, String, TbQueueMsgDecoder)}
   */
  @Test
  @DisplayName(
      "Test new TbPubSubConsumerTemplate(TbQueueAdmin, TbPubSubSettings, String, TbQueueMsgDecoder); then calls getCredentials()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbPubSubConsumerTemplate.<init>(TbQueueAdmin, TbPubSubSettings, String, TbQueueMsgDecoder)"
  })
  void testNewTbPubSubConsumerTemplate_thenCallsGetCredentials() throws IOException {
    // Arrange
    CredentialsProvider credentialsProvider = mock(CredentialsProvider.class);
    when(credentialsProvider.getCredentials())
        .thenThrow(
            new InvalidProtocolBufferException("The characteristics of someone or something"));

    FixedExecutorProvider fixedExecutorProvider = mock(FixedExecutorProvider.class);
    when(fixedExecutorProvider.getExecutor()).thenReturn(new DefaultEventLoop());

    TbPubSubSettings pubSubSettings = mock(TbPubSubSettings.class);
    when(pubSubSettings.getExecutorProvider()).thenReturn(fixedExecutorProvider);
    when(pubSubSettings.getMaxMsgSize()).thenReturn(3);
    when(pubSubSettings.getCredentialsProvider()).thenReturn(credentialsProvider);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new TbPubSubConsumerTemplate<>(
                null, pubSubSettings, "Topic", mock(TbQueueMsgDecoder.class)));
    verify(credentialsProvider).getCredentials();
    verify(fixedExecutorProvider).getExecutor();
    verify(pubSubSettings).getCredentialsProvider();
    verify(pubSubSettings).getExecutorProvider();
    verify(pubSubSettings).getMaxMsgSize();
  }
}
