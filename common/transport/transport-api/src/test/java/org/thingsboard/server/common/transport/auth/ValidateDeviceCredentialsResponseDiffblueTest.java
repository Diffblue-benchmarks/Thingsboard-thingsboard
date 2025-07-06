package org.thingsboard.server.common.transport.auth;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceProfile;

class ValidateDeviceCredentialsResponseDiffblueTest {
  /**
   * Test {@link ValidateDeviceCredentialsResponse#hasDeviceInfo()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateDeviceCredentialsResponse#hasDeviceInfo()}
   */
  @Test
  @DisplayName("Test hasDeviceInfo(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ValidateDeviceCredentialsResponse.hasDeviceInfo()"})
  void testHasDeviceInfo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new ValidateDeviceCredentialsResponse(null, new DeviceProfile(), "Credentials")
            .hasDeviceInfo());
  }

  /**
   * Test {@link ValidateDeviceCredentialsResponse#hasDeviceInfo()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateDeviceCredentialsResponse#hasDeviceInfo()}
   */
  @Test
  @DisplayName("Test hasDeviceInfo(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ValidateDeviceCredentialsResponse.hasDeviceInfo()"})
  void testHasDeviceInfo_thenReturnTrue() {
    // Arrange
    TransportDeviceInfo deviceInfo = new TransportDeviceInfo();

    // Act and Assert
    assertTrue(
        new ValidateDeviceCredentialsResponse(deviceInfo, new DeviceProfile(), "Credentials")
            .hasDeviceInfo());
  }
}
