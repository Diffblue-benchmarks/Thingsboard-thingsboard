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
package org.thingsboard.server.queue.provider;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TbVersionControlProducerProviderDiffblueTest {
  @InjectMocks private TbVersionControlProducerProvider tbVersionControlProducerProvider;

  @Mock private TbVersionControlQueueFactory tbVersionControlQueueFactory;

  /**
   * Test {@link TbVersionControlProducerProvider#init()}.
   *
   * <p>Method under test: {@link TbVersionControlProducerProvider#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbVersionControlProducerProvider.init()"})
  void testInit() {
    // Arrange
    when(tbVersionControlQueueFactory.createTbCoreNotificationsMsgProducer())
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbVersionControlProducerProvider.init());
    verify(tbVersionControlQueueFactory).createTbCoreNotificationsMsgProducer();
  }

  /**
   * Test {@link TbVersionControlProducerProvider#getTransportNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link
   * TbVersionControlProducerProvider#getTransportNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test getTransportNotificationsMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer TbVersionControlProducerProvider.getTransportNotificationsMsgProducer()"
  })
  void testGetTransportNotificationsMsgProducer() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbVersionControlProducerProvider.getTransportNotificationsMsgProducer());
  }

  /**
   * Test {@link TbVersionControlProducerProvider#getRuleEngineMsgProducer()}.
   *
   * <p>Method under test: {@link TbVersionControlProducerProvider#getRuleEngineMsgProducer()}
   */
  @Test
  @DisplayName("Test getRuleEngineMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer TbVersionControlProducerProvider.getRuleEngineMsgProducer()"
  })
  void testGetRuleEngineMsgProducer() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbVersionControlProducerProvider.getRuleEngineMsgProducer());
  }

  /**
   * Test {@link TbVersionControlProducerProvider#getTbCoreMsgProducer()}.
   *
   * <p>Method under test: {@link TbVersionControlProducerProvider#getTbCoreMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbCoreMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer TbVersionControlProducerProvider.getTbCoreMsgProducer()"
  })
  void testGetTbCoreMsgProducer() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbVersionControlProducerProvider.getTbCoreMsgProducer());
  }

  /**
   * Test {@link TbVersionControlProducerProvider#getRuleEngineNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link
   * TbVersionControlProducerProvider#getRuleEngineNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test getRuleEngineNotificationsMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer TbVersionControlProducerProvider.getRuleEngineNotificationsMsgProducer()"
  })
  void testGetRuleEngineNotificationsMsgProducer() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbVersionControlProducerProvider.getRuleEngineNotificationsMsgProducer());
  }

  /**
   * Test {@link TbVersionControlProducerProvider#getTbEdgeMsgProducer()}.
   *
   * <p>Method under test: {@link TbVersionControlProducerProvider#getTbEdgeMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbEdgeMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer TbVersionControlProducerProvider.getTbEdgeMsgProducer()"
  })
  void testGetTbEdgeMsgProducer() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbVersionControlProducerProvider.getTbEdgeMsgProducer());
  }

  /**
   * Test {@link TbVersionControlProducerProvider#getTbEdgeNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link
   * TbVersionControlProducerProvider#getTbEdgeNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbEdgeNotificationsMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer TbVersionControlProducerProvider.getTbEdgeNotificationsMsgProducer()"
  })
  void testGetTbEdgeNotificationsMsgProducer() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbVersionControlProducerProvider.getTbEdgeNotificationsMsgProducer());
  }

  /**
   * Test {@link TbVersionControlProducerProvider#getTbVersionControlMsgProducer()}.
   *
   * <p>Method under test: {@link TbVersionControlProducerProvider#getTbVersionControlMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbVersionControlMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer TbVersionControlProducerProvider.getTbVersionControlMsgProducer()"
  })
  void testGetTbVersionControlMsgProducer() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbVersionControlProducerProvider.getTbVersionControlMsgProducer());
  }
}
