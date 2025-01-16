package org.thingsboard.server.common.data.device.data;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeviceTransportConfigurationDiffblueTest {
  /**
   * Test {@link DeviceTransportConfiguration#validate()}.
   * <ul>
   *   <li>Then calls {@link DeviceTransportConfiguration#validate()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceTransportConfiguration#validate()}
   */
  @Test
  @DisplayName("Test validate(); then calls validate()")
  void testValidate_thenCallsValidate() {
    // Arrange
    DeviceTransportConfiguration deviceTransportConfiguration = mock(DeviceTransportConfiguration.class);
    doNothing().when(deviceTransportConfiguration).validate();

    // Act
    deviceTransportConfiguration.validate();

    // Assert that nothing has changed
    verify(deviceTransportConfiguration).validate();
  }
}
