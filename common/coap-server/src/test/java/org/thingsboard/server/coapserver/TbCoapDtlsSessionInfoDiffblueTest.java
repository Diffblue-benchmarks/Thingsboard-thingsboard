package org.thingsboard.server.coapserver;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.transport.auth.ValidateDeviceCredentialsResponse;

class TbCoapDtlsSessionInfoDiffblueTest {
  /**
   * Test {@link TbCoapDtlsSessionInfo#TbCoapDtlsSessionInfo(ValidateDeviceCredentialsResponse,
   * DeviceProfile)}.
   *
   * <p>Method under test: {@link
   * TbCoapDtlsSessionInfo#TbCoapDtlsSessionInfo(ValidateDeviceCredentialsResponse, DeviceProfile)}
   */
  @Test
  @DisplayName("Test new TbCoapDtlsSessionInfo(ValidateDeviceCredentialsResponse, DeviceProfile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbCoapDtlsSessionInfo.<init>(ValidateDeviceCredentialsResponse, DeviceProfile)"
  })
  void testNewTbCoapDtlsSessionInfo() {
    // Arrange
    ValidateDeviceCredentialsResponse msg = mock(ValidateDeviceCredentialsResponse.class);
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act
    TbCoapDtlsSessionInfo actualTbCoapDtlsSessionInfo =
        new TbCoapDtlsSessionInfo(msg, deviceProfile);

    // Assert
    assertSame(deviceProfile, actualTbCoapDtlsSessionInfo.getDeviceProfile());
    assertSame(msg, actualTbCoapDtlsSessionInfo.getMsg());
  }
}
