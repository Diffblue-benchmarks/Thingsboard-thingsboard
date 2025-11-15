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
package org.thingsboard.server.queue.discovery.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.TransportProtos;

class ServiceListChangedEventDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ServiceListChangedEvent#toString()}
   *   <li>{@link ServiceListChangedEvent#getCurrentService()}
   *   <li>{@link ServiceListChangedEvent#getOtherServices()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    ArrayList<TransportProtos.ServiceInfo> otherServices = new ArrayList<>();
    TransportProtos.ServiceInfo currentService = TransportProtos.ServiceInfo.getDefaultInstance();
    ServiceListChangedEvent serviceListChangedEvent = new ServiceListChangedEvent(otherServices, currentService);

    // Act
    String actualToStringResult = serviceListChangedEvent.toString();
    TransportProtos.ServiceInfo actualCurrentService = serviceListChangedEvent.getCurrentService();

    // Assert
    assertEquals("ServiceListChangedEvent(otherServices=[], currentService=)", actualToStringResult);
    assertSame(otherServices, serviceListChangedEvent.getOtherServices());
    assertSame(currentService, actualCurrentService);
  }

  /**
   * Method under test:
   * {@link ServiceListChangedEvent#ServiceListChangedEvent(List, TransportProtos.ServiceInfo)}
   */
  @Test
  void testNewServiceListChangedEvent() {
    // Arrange
    ArrayList<TransportProtos.ServiceInfo> otherServices = new ArrayList<>();
    TransportProtos.ServiceInfo currentService = TransportProtos.ServiceInfo.getDefaultInstance();

    // Act
    ServiceListChangedEvent actualServiceListChangedEvent = new ServiceListChangedEvent(otherServices, currentService);

    // Assert
    List<TransportProtos.ServiceInfo> otherServices2 = actualServiceListChangedEvent.getOtherServices();
    assertTrue(otherServices2.isEmpty());
    assertSame(otherServices, actualServiceListChangedEvent.getSource());
    assertSame(otherServices, otherServices2);
    assertSame(currentService, actualServiceListChangedEvent.getCurrentService());
  }

  /**
   * Method under test:
   * {@link ServiceListChangedEvent#ServiceListChangedEvent(List, TransportProtos.ServiceInfo)}
   */
  @Test
  void testNewServiceListChangedEvent2() {
    // Arrange
    ArrayList<TransportProtos.ServiceInfo> otherServices = new ArrayList<>();
    otherServices.add(TransportProtos.ServiceInfo.getDefaultInstance());
    TransportProtos.ServiceInfo currentService = TransportProtos.ServiceInfo.getDefaultInstance();

    // Act
    ServiceListChangedEvent actualServiceListChangedEvent = new ServiceListChangedEvent(otherServices, currentService);

    // Assert
    assertSame(otherServices, actualServiceListChangedEvent.getSource());
    assertSame(otherServices, actualServiceListChangedEvent.getOtherServices());
    assertSame(currentService, actualServiceListChangedEvent.getCurrentService());
  }

  /**
   * Method under test:
   * {@link ServiceListChangedEvent#ServiceListChangedEvent(List, TransportProtos.ServiceInfo)}
   */
  @Test
  void testNewServiceListChangedEvent3() {
    // Arrange
    ArrayList<TransportProtos.ServiceInfo> otherServices = new ArrayList<>();
    otherServices.add(TransportProtos.ServiceInfo.getDefaultInstance());
    otherServices.add(TransportProtos.ServiceInfo.getDefaultInstance());
    TransportProtos.ServiceInfo currentService = TransportProtos.ServiceInfo.getDefaultInstance();

    // Act
    ServiceListChangedEvent actualServiceListChangedEvent = new ServiceListChangedEvent(otherServices, currentService);

    // Assert
    assertSame(otherServices, actualServiceListChangedEvent.getSource());
    assertSame(otherServices, actualServiceListChangedEvent.getOtherServices());
    assertSame(currentService, actualServiceListChangedEvent.getCurrentService());
  }
}
