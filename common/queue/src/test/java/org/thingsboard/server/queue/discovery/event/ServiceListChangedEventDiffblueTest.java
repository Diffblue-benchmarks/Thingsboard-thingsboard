package org.thingsboard.server.queue.discovery.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.google.protobuf.Descriptors;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.TransportProtos;

class ServiceListChangedEventDiffblueTest {
  /**
   * Test
   * {@link ServiceListChangedEvent#ServiceListChangedEvent(List, ServiceInfo)}.
   * <ul>
   *   <li>Then return OtherServices is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServiceListChangedEvent#ServiceListChangedEvent(List, TransportProtos.ServiceInfo)}
   */
  @Test
  @DisplayName("Test new ServiceListChangedEvent(List, ServiceInfo); then return OtherServices is ArrayList()")
  void testNewServiceListChangedEvent_thenReturnOtherServicesIsArrayList() {
    // Arrange
    ArrayList<TransportProtos.ServiceInfo> otherServices = new ArrayList<>();
    otherServices.add(TransportProtos.ServiceInfo.getDefaultInstance());

    // Act
    ServiceListChangedEvent actualServiceListChangedEvent = new ServiceListChangedEvent(otherServices,
        TransportProtos.ServiceInfo.getDefaultInstance());

    // Assert
    Descriptors.Descriptor descriptorForType = actualServiceListChangedEvent.getCurrentService().getDescriptorForType();
    assertEquals(180, descriptorForType.getFile().getMessageTypes().size());
    assertEquals(5, descriptorForType.getFields().size());
    assertSame(otherServices, actualServiceListChangedEvent.getOtherServices());
  }

  /**
   * Test
   * {@link ServiceListChangedEvent#ServiceListChangedEvent(List, ServiceInfo)}.
   * <ul>
   *   <li>Then return OtherServices size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServiceListChangedEvent#ServiceListChangedEvent(List, TransportProtos.ServiceInfo)}
   */
  @Test
  @DisplayName("Test new ServiceListChangedEvent(List, ServiceInfo); then return OtherServices size is two")
  void testNewServiceListChangedEvent_thenReturnOtherServicesSizeIsTwo() {
    // Arrange
    ArrayList<TransportProtos.ServiceInfo> otherServices = new ArrayList<>();
    otherServices.add(TransportProtos.ServiceInfo.getDefaultInstance());
    otherServices.add(TransportProtos.ServiceInfo.getDefaultInstance());
    TransportProtos.ServiceInfo currentService = TransportProtos.ServiceInfo.getDefaultInstance();

    // Act and Assert
    List<TransportProtos.ServiceInfo> otherServices2 = (new ServiceListChangedEvent(otherServices, currentService))
        .getOtherServices();
    assertEquals(2, otherServices2.size());
    assertSame(currentService, otherServices2.get(1));
  }

  /**
   * Test
   * {@link ServiceListChangedEvent#ServiceListChangedEvent(List, ServiceInfo)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return OtherServices Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServiceListChangedEvent#ServiceListChangedEvent(List, TransportProtos.ServiceInfo)}
   */
  @Test
  @DisplayName("Test new ServiceListChangedEvent(List, ServiceInfo); when ArrayList(); then return OtherServices Empty")
  void testNewServiceListChangedEvent_whenArrayList_thenReturnOtherServicesEmpty() {
    // Arrange
    ArrayList<TransportProtos.ServiceInfo> otherServices = new ArrayList<>();

    // Act
    ServiceListChangedEvent actualServiceListChangedEvent = new ServiceListChangedEvent(otherServices,
        TransportProtos.ServiceInfo.getDefaultInstance());

    // Assert
    TransportProtos.ServiceInfo currentService = actualServiceListChangedEvent.getCurrentService();
    Descriptors.Descriptor descriptorForType = currentService.getDescriptorForType();
    assertEquals(180, descriptorForType.getFile().getMessageTypes().size());
    assertEquals(5, descriptorForType.getFields().size());
    assertTrue(actualServiceListChangedEvent.getOtherServices().isEmpty());
    assertEquals(otherServices, currentService.getAssignedTenantProfilesList());
  }
}
