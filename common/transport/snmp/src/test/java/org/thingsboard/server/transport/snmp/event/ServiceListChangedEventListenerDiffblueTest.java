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
package org.thingsboard.server.transport.snmp.event;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.discovery.event.ServiceListChangedEvent;
import org.thingsboard.server.transport.snmp.service.SnmpTransportBalancingService;

class ServiceListChangedEventListenerDiffblueTest {
  /**
   * Method under test:
   * {@link ServiceListChangedEventListener#onTbApplicationEvent(ServiceListChangedEvent)}
   */
  @Test
  void testOnTbApplicationEvent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SnmpTransportBalancingService snmpTransportBalancingService = mock(SnmpTransportBalancingService.class);
    doNothing().when(snmpTransportBalancingService).onServiceListChanged(Mockito.<ServiceListChangedEvent>any());
    ServiceListChangedEventListener serviceListChangedEventListener = new ServiceListChangedEventListener(
        snmpTransportBalancingService);
    ArrayList<TransportProtos.ServiceInfo> otherServices = new ArrayList<>();

    // Act
    serviceListChangedEventListener.onTbApplicationEvent(
        new ServiceListChangedEvent(otherServices, TransportProtos.ServiceInfo.getDefaultInstance()));

    // Assert that nothing has changed
    verify(snmpTransportBalancingService).onServiceListChanged(isA(ServiceListChangedEvent.class));
  }
}
