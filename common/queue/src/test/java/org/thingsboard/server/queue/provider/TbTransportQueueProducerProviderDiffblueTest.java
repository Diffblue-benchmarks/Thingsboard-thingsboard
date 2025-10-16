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

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.ToCoreMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToCoreNotificationMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToHousekeeperServiceMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToRuleEngineMsg;
import org.thingsboard.server.queue.TbQueueProducer;
import org.thingsboard.server.queue.common.TbProtoQueueMsg;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.memory.DefaultInMemoryStorage;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;

class TbTransportQueueProducerProviderDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbTransportQueueProducerProvider#getHousekeeperMsgProducer()}
   *   <li>{@link TbTransportQueueProducerProvider#getRuleEngineMsgProducer()}
   *   <li>{@link TbTransportQueueProducerProvider#getTbCoreMsgProducer()}
   *   <li>{@link TbTransportQueueProducerProvider#getTbCoreNotificationsMsgProducer()}
   *   <li>{@link TbTransportQueueProducerProvider#getTbUsageStatsMsgProducer()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueProducer TbTransportQueueProducerProvider.getHousekeeperMsgProducer()",
    "TbQueueProducer TbTransportQueueProducerProvider.getRuleEngineMsgProducer()",
    "TbQueueProducer TbTransportQueueProducerProvider.getTbCoreMsgProducer()",
    "TbQueueProducer TbTransportQueueProducerProvider.getTbCoreNotificationsMsgProducer()",
    "TbQueueProducer TbTransportQueueProducerProvider.getTbUsageStatsMsgProducer()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryTbTransportQueueFactory tbQueueProvider =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings,
            transportNotificationSettings,
            serviceInfoProvider,
            coreSettings,
            storage,
            new TopicService());
    TbTransportQueueProducerProvider tbTransportQueueProducerProvider =
        new TbTransportQueueProducerProvider(tbQueueProvider);

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToHousekeeperServiceMsg>> actualHousekeeperMsgProducer =
        tbTransportQueueProducerProvider.getHousekeeperMsgProducer();
    TbQueueProducer<TbProtoQueueMsg<ToRuleEngineMsg>> actualRuleEngineMsgProducer =
        tbTransportQueueProducerProvider.getRuleEngineMsgProducer();
    TbQueueProducer<TbProtoQueueMsg<ToCoreMsg>> actualTbCoreMsgProducer =
        tbTransportQueueProducerProvider.getTbCoreMsgProducer();
    TbQueueProducer<TbProtoQueueMsg<ToCoreNotificationMsg>> actualTbCoreNotificationsMsgProducer =
        tbTransportQueueProducerProvider.getTbCoreNotificationsMsgProducer();

    // Assert
    assertNull(actualTbCoreMsgProducer);
    assertNull(actualTbCoreNotificationsMsgProducer);
    assertNull(actualHousekeeperMsgProducer);
    assertNull(actualRuleEngineMsgProducer);
    assertNull(tbTransportQueueProducerProvider.getTbUsageStatsMsgProducer());
  }
}
