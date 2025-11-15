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
package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.exception.TenantNotFoundException;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.gen.transport.TransportProtos;

@DisabledInAotMode
@ContextConfiguration(classes = {HashPartitionService.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class HashPartitionServiceDiffblueTest {
  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @MockBean
  private QueueRoutingInfoService queueRoutingInfoService;

  @MockBean
  private TbServiceInfoProvider tbServiceInfoProvider;

  @MockBean
  private TenantRoutingInfoService tenantRoutingInfoService;

  @MockBean
  private TopicService topicService;

  @Autowired
  private HashPartitionService hashPartitionService;

  /**
   * Method under test: {@link HashPartitionService#getMyPartitions(QueueKey)}
   */
  @Test
  void testGetMyPartitions() {
    // Arrange, Act and Assert
    assertNull(hashPartitionService.getMyPartitions(new QueueKey(ServiceType.TB_CORE)));
    assertNull(hashPartitionService.getMyPartitions(new QueueKey(ServiceType.TB_CORE, new Queue())));
    assertNull(hashPartitionService.getMyPartitions(mock(QueueKey.class)));
  }

  /**
   * Method under test:
   * {@link HashPartitionService#resolve(ServiceType, TenantId, EntityId)}
   */
  @Test
  void testResolve() {
    // Arrange
    when(tenantRoutingInfoService.getRoutingInfo(Mockito.<TenantId>any())).thenReturn(null);

    // Act and Assert
    assertThrows(TenantNotFoundException.class,
        () -> hashPartitionService.resolve(ServiceType.TB_CORE, new TenantId(UUID.randomUUID()), null));
    verify(tenantRoutingInfoService).getRoutingInfo(isA(TenantId.class));
  }

  /**
   * Method under test:
   * {@link HashPartitionService#recalculatePartitions(TransportProtos.ServiceInfo, List)}
   */
  @Test
  void testRecalculatePartitions() {
    // Arrange
    when(tbServiceInfoProvider.isService(Mockito.<ServiceType>any())).thenReturn(true);
    TransportProtos.ServiceInfo currentService = TransportProtos.ServiceInfo.getDefaultInstance();

    // Act
    hashPartitionService.recalculatePartitions(currentService, new ArrayList<>());

    // Assert
    verify(tbServiceInfoProvider).isService(eq(ServiceType.TB_RULE_ENGINE));
  }

  /**
   * Method under test:
   * {@link HashPartitionService#resolvePartitionIndex(UUID, int)}
   */
  @Test
  void testResolvePartitionIndex() {
    // Arrange, Act and Assert
    assertEquals(0, hashPartitionService.resolvePartitionIndex(UUID.randomUUID(), 1));
  }

  /**
   * Method under test:
   * {@link HashPartitionService#resolveByPartitionIdx(List, QueueKey, int, Map)}
   */
  @Test
  void testResolveByPartitionIdx() {
    // Arrange
    ArrayList<TransportProtos.ServiceInfo> servers = new ArrayList<>();
    TransportProtos.ServiceInfo defaultInstance = TransportProtos.ServiceInfo.getDefaultInstance();
    servers.add(defaultInstance);
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE);

    // Act and Assert
    assertSame(defaultInstance, hashPartitionService.resolveByPartitionIdx(servers, queueKey, 1, new HashMap<>()));
  }

  /**
   * Method under test: {@link HashPartitionService#forName(String)}
   */
  @Test
  void testForName() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> HashPartitionService.forName("Name"));
  }
}
