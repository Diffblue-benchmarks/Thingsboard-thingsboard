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
package org.thingsboard.server.common.transport.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.ResourceType;
import org.thingsboard.server.common.data.TbResource;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.transport.TransportProtos;

class DefaultTransportResourceCacheDiffblueTest {
  /**
   * Method under test:
   * {@link DefaultTransportResourceCache#get(TenantId, ResourceType, String)}
   */
  @Test
  void testGet() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    when(transportService.getResource(Mockito.<TransportProtos.GetResourceRequestMsg>any()))
        .thenReturn(TransportProtos.GetResourceResponseMsg.getDefaultInstance());
    DefaultTransportResourceCache defaultTransportResourceCache = new DefaultTransportResourceCache(transportService);

    // Act
    Optional<TbResource> actualGetResult = defaultTransportResourceCache.get(new TenantId(UUID.randomUUID()),
        ResourceType.LWM2M_MODEL, "Resource Key");

    // Assert
    verify(transportService).getResource(isA(TransportProtos.GetResourceRequestMsg.class));
    assertFalse(actualGetResult.isPresent());
  }
}
