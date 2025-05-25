package org.thingsboard.server.queue.discovery.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
   * <ul>
   *   <li>Then return OtherServices is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServiceListChangedEvent#ServiceListChangedEvent(List, ServiceInfo)}
   */
  @Test
  @DisplayName("Test new ServiceListChangedEvent(List, ServiceInfo); then return OtherServices is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ServiceListChangedEvent.<init>(List, ServiceInfo)"})
  void testNewServiceListChangedEvent_thenReturnOtherServicesIsArrayList() {
    // Arrange
    ArrayList<ServiceInfo> otherServices = new ArrayList<>();
    otherServices.add(ServiceInfo.getDefaultInstance());

    // Act and Assert
    assertSame(otherServices,
        (new ServiceListChangedEvent(otherServices, ServiceInfo.getDefaultInstance())).getOtherServices());
  }

  /**
   * Test {@link ServiceListChangedEvent#ServiceListChangedEvent(List, ServiceInfo)}.
   * <ul>
   *   <li>Then return OtherServices is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServiceListChangedEvent#ServiceListChangedEvent(List, ServiceInfo)}
   */
  @Test
  @DisplayName("Test new ServiceListChangedEvent(List, ServiceInfo); then return OtherServices is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ServiceListChangedEvent.<init>(List, ServiceInfo)"})
  void testNewServiceListChangedEvent_thenReturnOtherServicesIsArrayList2() {
    // Arrange
    ArrayList<ServiceInfo> otherServices = new ArrayList<>();
    otherServices.add(ServiceInfo.getDefaultInstance());
    otherServices.add(ServiceInfo.getDefaultInstance());

    // Act and Assert
    assertSame(otherServices,
        (new ServiceListChangedEvent(otherServices, ServiceInfo.getDefaultInstance())).getOtherServices());
  }

  /**
   * Test {@link ServiceListChangedEvent#ServiceListChangedEvent(List, ServiceInfo)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return OtherServices Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServiceListChangedEvent#ServiceListChangedEvent(List, ServiceInfo)}
   */
  @Test
  @DisplayName("Test new ServiceListChangedEvent(List, ServiceInfo); when ArrayList(); then return OtherServices Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ServiceListChangedEvent.<init>(List, ServiceInfo)"})
  void testNewServiceListChangedEvent_whenArrayList_thenReturnOtherServicesEmpty() {
    // Arrange
    ArrayList<ServiceInfo> otherServices = new ArrayList<>();

    // Act
    ServiceListChangedEvent actualServiceListChangedEvent = new ServiceListChangedEvent(otherServices,
        ServiceInfo.getDefaultInstance());

    // Assert
    assertTrue(actualServiceListChangedEvent.getOtherServices().isEmpty());
    assertEquals(otherServices, actualServiceListChangedEvent.getCurrentService().getAssignedTenantProfilesList());
  }
}
