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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.ServiceInfo;

class ServiceListChangedEventDiffblueTest {
  /**
   * Test {@link ServiceListChangedEvent#ServiceListChangedEvent(List, ServiceInfo)}.
   *
   * <ul>
   *   <li>Then return OtherServices is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ServiceListChangedEvent#ServiceListChangedEvent(List,
   * ServiceInfo)}
   */
  @Test
  @DisplayName(
      "Test new ServiceListChangedEvent(List, ServiceInfo); then return OtherServices is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ServiceListChangedEvent.<init>(List, ServiceInfo)"})
  void testNewServiceListChangedEvent_thenReturnOtherServicesIsArrayList() {
    // Arrange
    ArrayList<ServiceInfo> otherServices = new ArrayList<>();
    otherServices.add(ServiceInfo.getDefaultInstance());

    // Act and Assert
    assertSame(
        otherServices,
        new ServiceListChangedEvent(otherServices, ServiceInfo.getDefaultInstance())
            .getOtherServices());
  }

  /**
   * Test {@link ServiceListChangedEvent#ServiceListChangedEvent(List, ServiceInfo)}.
   *
   * <ul>
   *   <li>Then return OtherServices is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ServiceListChangedEvent#ServiceListChangedEvent(List,
   * ServiceInfo)}
   */
  @Test
  @DisplayName(
      "Test new ServiceListChangedEvent(List, ServiceInfo); then return OtherServices is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ServiceListChangedEvent.<init>(List, ServiceInfo)"})
  void testNewServiceListChangedEvent_thenReturnOtherServicesIsArrayList2() {
    // Arrange
    ArrayList<ServiceInfo> otherServices = new ArrayList<>();
    otherServices.add(ServiceInfo.getDefaultInstance());
    otherServices.add(ServiceInfo.getDefaultInstance());

    // Act and Assert
    assertSame(
        otherServices,
        new ServiceListChangedEvent(otherServices, ServiceInfo.getDefaultInstance())
            .getOtherServices());
  }

  /**
   * Test {@link ServiceListChangedEvent#ServiceListChangedEvent(List, ServiceInfo)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return OtherServices Empty.
   * </ul>
   *
   * <p>Method under test: {@link ServiceListChangedEvent#ServiceListChangedEvent(List,
   * ServiceInfo)}
   */
  @Test
  @DisplayName(
      "Test new ServiceListChangedEvent(List, ServiceInfo); when ArrayList(); then return OtherServices Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ServiceListChangedEvent.<init>(List, ServiceInfo)"})
  void testNewServiceListChangedEvent_whenArrayList_thenReturnOtherServicesEmpty() {
    // Arrange
    ArrayList<ServiceInfo> otherServices = new ArrayList<>();

    // Act
    ServiceListChangedEvent actualServiceListChangedEvent =
        new ServiceListChangedEvent(otherServices, ServiceInfo.getDefaultInstance());

    // Assert
    assertTrue(actualServiceListChangedEvent.getOtherServices().isEmpty());
    assertEquals(
        otherServices,
        actualServiceListChangedEvent.getCurrentService().getAssignedTenantProfilesList());
  }
}
