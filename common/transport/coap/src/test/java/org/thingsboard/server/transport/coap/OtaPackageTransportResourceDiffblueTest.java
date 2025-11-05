package org.thingsboard.server.transport.coap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.eclipse.californium.core.server.resources.Resource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.ota.OtaPackageType;

class OtaPackageTransportResourceDiffblueTest {
  /**
   * Test {@link OtaPackageTransportResource#OtaPackageTransportResource(CoapTransportContext,
   * OtaPackageType)}.
   *
   * <ul>
   *   <li>Then return Path is empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * OtaPackageTransportResource#OtaPackageTransportResource(CoapTransportContext, OtaPackageType)}
   */
  @Test
  @DisplayName(
      "Test new OtaPackageTransportResource(CoapTransportContext, OtaPackageType); then return Path is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OtaPackageTransportResource.<init>(CoapTransportContext, OtaPackageType)"
  })
  void testNewOtaPackageTransportResource_thenReturnPathIsEmptyString() {
    // Arrange and Act
    OtaPackageTransportResource actualOtaPackageTransportResource =
        new OtaPackageTransportResource(new CoapTransportContext(), OtaPackageType.FIRMWARE);

    // Assert
    assertEquals("", actualOtaPackageTransportResource.getPath());
    assertEquals("fw", actualOtaPackageTransportResource.getName());
    assertEquals("fw", actualOtaPackageTransportResource.getURI());
    assertNull(actualOtaPackageTransportResource.getExecutor());
    assertNull(actualOtaPackageTransportResource.getObserveType());
    assertNull(actualOtaPackageTransportResource.getParent());
    assertNull(actualOtaPackageTransportResource.transportService);
    assertEquals(0, actualOtaPackageTransportResource.getNotificationSequenceNumber());
    assertEquals(0, actualOtaPackageTransportResource.getObserverCount());
    assertTrue(actualOtaPackageTransportResource.getChildren().isEmpty());
    assertTrue(actualOtaPackageTransportResource.isCachable());
    assertTrue(actualOtaPackageTransportResource.isObservable());
    assertTrue(actualOtaPackageTransportResource.isVisible());
  }

  /**
   * Test {@link OtaPackageTransportResource#getChild(String)}.
   *
   * <p>Method under test: {@link OtaPackageTransportResource#getChild(String)}
   */
  @Test
  @DisplayName("Test getChild(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource OtaPackageTransportResource.getChild(String)"})
  void testGetChild() {
    // Arrange
    OtaPackageTransportResource otaPackageTransportResource =
        new OtaPackageTransportResource(new CoapTransportContext(), OtaPackageType.FIRMWARE);

    // Act
    Resource actualChild = otaPackageTransportResource.getChild("Name");

    // Assert
    assertSame(otaPackageTransportResource, actualChild);
  }
}
