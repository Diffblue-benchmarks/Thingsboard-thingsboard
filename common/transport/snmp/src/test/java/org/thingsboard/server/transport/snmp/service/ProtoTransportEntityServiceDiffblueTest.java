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
package org.thingsboard.server.transport.snmp.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.transport.service.DefaultTransportService;
import org.thingsboard.server.gen.transport.TransportProtos;

class ProtoTransportEntityServiceDiffblueTest {
  /**
   * Method under test:
   * {@link ProtoTransportEntityService#getSnmpDevicesIds(int, int)}
   */
  @Test
  void testGetSnmpDevicesIds() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    TransportProtos.GetSnmpDevicesResponseMsg defaultInstance = TransportProtos.GetSnmpDevicesResponseMsg
        .getDefaultInstance();
    when(transportService.getSnmpDevicesIds(Mockito.<TransportProtos.GetSnmpDevicesRequestMsg>any()))
        .thenReturn(defaultInstance);

    // Act
    TransportProtos.GetSnmpDevicesResponseMsg actualSnmpDevicesIds = (new ProtoTransportEntityService(transportService))
        .getSnmpDevicesIds(1, 3);

    // Assert
    verify(transportService).getSnmpDevicesIds(isA(TransportProtos.GetSnmpDevicesRequestMsg.class));
    assertSame(defaultInstance, actualSnmpDevicesIds);
  }
}
