package org.thingsboard.server.common.transport.auth;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidateDeviceCredentialsResponse.hasDeviceInfo()"})
  void testHasDeviceInfo_thenReturnFalse() {
    // Arrange
    ValidateDeviceCredentialsResponse validateDeviceCredentialsResponse =
        new ValidateDeviceCredentialsResponse(null, new DeviceProfile(), "Credentials");

    // Act and Assert
    assertFalse(validateDeviceCredentialsResponse.hasDeviceInfo());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidateDeviceCredentialsResponse.hasDeviceInfo()"})
  void testHasDeviceInfo_thenReturnTrue() {
    // Arrange
    TransportDeviceInfo deviceInfo = new TransportDeviceInfo();
    ValidateDeviceCredentialsResponse validateDeviceCredentialsResponse =
        new ValidateDeviceCredentialsResponse(deviceInfo, new DeviceProfile(), "Credentials");

    // Act and Assert
    assertTrue(validateDeviceCredentialsResponse.hasDeviceInfo());
  }
}
