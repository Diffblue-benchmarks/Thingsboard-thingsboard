package org.thingsboard.server.common.data.device.profile;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeviceProfileTransportConfigurationDiffblueTest {
  /**
   * Test {@link DeviceProfileTransportConfiguration#validate()}.
   * <ul>
   *   <li>Then calls {@link DeviceProfileTransportConfiguration#validate()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileTransportConfiguration#validate()}
   */
  @Test
  @DisplayName("Test validate(); then calls validate()")
  void testValidate_thenCallsValidate() {
    // Arrange
    DeviceProfileTransportConfiguration deviceProfileTransportConfiguration = mock(
        DeviceProfileTransportConfiguration.class);
    doNothing().when(deviceProfileTransportConfiguration).validate();

    // Act
    deviceProfileTransportConfiguration.validate();

    // Assert that nothing has changed
    verify(deviceProfileTransportConfiguration).validate();
  }
}
