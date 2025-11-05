package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.ServiceInfo;

@ExtendWith(MockitoExtension.class)
class DefaultTbServiceInfoProviderDiffblueTest {
  @InjectMocks private DefaultTbServiceInfoProvider defaultTbServiceInfoProvider;

  @Mock private List<ServiceType> list;

  /**
   * Test {@link DefaultTbServiceInfoProvider#isService(ServiceType)}.
   *
   * <ul>
   *   <li>Given {@link List} {@link List#contains(Object)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbServiceInfoProvider#isService(ServiceType)}
   */
  @Test
  @DisplayName(
      "Test isService(ServiceType); given List contains(Object) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultTbServiceInfoProvider.isService(ServiceType)"})
  void testIsService_givenListContainsReturnFalse_thenReturnFalse() {
    // Arrange
    when(list.contains(Mockito.<Object>any())).thenReturn(false);

    // Act
    boolean actualIsServiceResult = defaultTbServiceInfoProvider.isService(ServiceType.TB_CORE);

    // Assert
    verify(list).contains(isA(Object.class));
    assertFalse(actualIsServiceResult);
  }

  /**
   * Test {@link DefaultTbServiceInfoProvider#isService(ServiceType)}.
   *
   * <ul>
   *   <li>Given {@link List} {@link List#contains(Object)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbServiceInfoProvider#isService(ServiceType)}
   */
  @Test
  @DisplayName(
      "Test isService(ServiceType); given List contains(Object) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultTbServiceInfoProvider.isService(ServiceType)"})
  void testIsService_givenListContainsReturnTrue_thenReturnTrue() {
    // Arrange
    when(list.contains(Mockito.<Object>any())).thenReturn(true);

    // Act
    boolean actualIsServiceResult = defaultTbServiceInfoProvider.isService(ServiceType.TB_CORE);

    // Assert
    verify(list).contains(isA(Object.class));
    assertTrue(actualIsServiceResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultTbServiceInfoProvider#getAssignedTenantProfiles()}
   *   <li>{@link DefaultTbServiceInfoProvider#getServiceId()}
   *   <li>{@link DefaultTbServiceInfoProvider#getServiceInfo()}
   *   <li>{@link DefaultTbServiceInfoProvider#getServiceType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set DefaultTbServiceInfoProvider.getAssignedTenantProfiles()",
    "String DefaultTbServiceInfoProvider.getServiceId()",
    "TransportProtos.ServiceInfo DefaultTbServiceInfoProvider.getServiceInfo()",
    "String DefaultTbServiceInfoProvider.getServiceType()"
  })
  void testGettersAndSetters() {
    // Arrange
    DefaultTbServiceInfoProvider defaultTbServiceInfoProvider = new DefaultTbServiceInfoProvider();

    // Act
    Set<UUID> actualAssignedTenantProfiles =
        defaultTbServiceInfoProvider.getAssignedTenantProfiles();
    String actualServiceId = defaultTbServiceInfoProvider.getServiceId();
    ServiceInfo actualServiceInfo = defaultTbServiceInfoProvider.getServiceInfo();

    // Assert
    assertNull(actualServiceId);
    assertNull(defaultTbServiceInfoProvider.getServiceType());
    assertNull(actualAssignedTenantProfiles);
    assertNull(actualServiceInfo);
  }
}
