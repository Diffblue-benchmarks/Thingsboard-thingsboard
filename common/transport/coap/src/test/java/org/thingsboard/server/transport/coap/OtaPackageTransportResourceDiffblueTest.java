package org.thingsboard.server.transport.coap;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.ota.OtaPackageType;

class OtaPackageTransportResourceDiffblueTest {
  /**
   * Test {@link OtaPackageTransportResource#getChild(String)}.
   * <p>
   * Method under test: {@link OtaPackageTransportResource#getChild(String)}
   */
  @Test
  @DisplayName("Test getChild(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.eclipse.californium.core.server.resources.Resource OtaPackageTransportResource.getChild(String)"})
  void testGetChild() {
    // Arrange
    OtaPackageTransportResource otaPackageTransportResource = new OtaPackageTransportResource(
        new CoapTransportContext(), OtaPackageType.FIRMWARE);

    // Act and Assert
    assertSame(otaPackageTransportResource, otaPackageTransportResource.getChild("Name"));
  }
}
