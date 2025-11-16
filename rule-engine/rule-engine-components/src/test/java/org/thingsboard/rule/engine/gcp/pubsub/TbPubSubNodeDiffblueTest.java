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
package org.thingsboard.rule.engine.gcp.pubsub;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.POJONode;
import com.google.cloud.pubsub.v1.Publisher;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;

@ExtendWith(MockitoExtension.class)
class TbPubSubNodeDiffblueTest {
  @Mock private Publisher publisher;

  @InjectMocks private TbPubSubNode tbPubSubNode;

  /**
   * Test {@link TbPubSubNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Given {@code 3}.
   * </ul>
   *
   * <p>Method under test: {@link TbPubSubNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given '3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbPubSubNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_given3() throws TbNodeException {
    // Arrange
    TbPubSubNode tbPubSubNode = new TbPubSubNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbPubSubNodeConfiguration tbPubSubNodeConfiguration = new TbPubSubNodeConfiguration();
    tbPubSubNodeConfiguration.setServiceAccountKey("3");
    tbPubSubNodeConfiguration.setTopicName("Topic Name");
    tbPubSubNodeConfiguration.setProjectId("myproject");

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbPubSubNode.init(
                ctx, new TbNodeConfiguration(new POJONode(tbPubSubNodeConfiguration))));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbPubSubNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbPubSubNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbPubSubNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_givenEmptyString() throws TbNodeException {
    // Arrange
    TbPubSubNode tbPubSubNode = new TbPubSubNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbPubSubNodeConfiguration tbPubSubNodeConfiguration = new TbPubSubNodeConfiguration();
    tbPubSubNodeConfiguration.setServiceAccountKey("");
    tbPubSubNodeConfiguration.setTopicName("Topic Name");
    tbPubSubNodeConfiguration.setProjectId("myproject");

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbPubSubNode.init(
                ctx, new TbNodeConfiguration(new POJONode(tbPubSubNodeConfiguration))));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbPubSubNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbPubSubNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbPubSubNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_givenRuntimeException_thenThrowRuntimeException()
      throws TbNodeException {
    // Arrange
    TbPubSubNode tbPubSubNode = new TbPubSubNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenThrow(new RuntimeException());
    DoubleNode data = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbPubSubNode.init(ctx, new TbNodeConfiguration(data)));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbPubSubNode#destroy()}.
   *
   * <ul>
   *   <li>Given {@link Publisher} {@link Publisher#awaitTermination(long, TimeUnit)} return {@code
   *       true}.
   *   <li>Then calls {@link Publisher#awaitTermination(long, TimeUnit)}.
   * </ul>
   *
   * <p>Method under test: {@link TbPubSubNode#destroy()}
   */
  @Test
  @DisplayName(
      "Test destroy(); given Publisher awaitTermination(long, TimeUnit) return 'true'; then calls awaitTermination(long, TimeUnit)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbPubSubNode.destroy()"})
  void testDestroy_givenPublisherAwaitTerminationReturnTrue_thenCallsAwaitTermination()
      throws InterruptedException {
    // Arrange
    when(publisher.awaitTermination(anyLong(), Mockito.<TimeUnit>any())).thenReturn(true);
    doNothing().when(publisher).shutdown();

    // Act
    tbPubSubNode.destroy();

    // Assert
    verify(publisher).awaitTermination(1L, TimeUnit.SECONDS);
    verify(publisher).shutdown();
  }

  /**
   * Test {@link TbPubSubNode#destroy()}.
   *
   * <ul>
   *   <li>Given {@link Publisher} {@link Publisher#shutdown()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbPubSubNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy(); given Publisher shutdown() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbPubSubNode.destroy()"})
  void testDestroy_givenPublisherShutdownThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException()).when(publisher).shutdown();

    // Act
    tbPubSubNode.destroy();

    // Assert
    verify(publisher).shutdown();
  }
}
