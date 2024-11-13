package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.exception.ThingsboardException;

class UiSettingsControllerDiffblueTest {
  /**
   * Test {@link UiSettingsController#getHelpBaseUrl()}.
   * <p>
   * Method under test: {@link UiSettingsController#getHelpBaseUrl()}
   */
  @Test
  @DisplayName("Test getHelpBaseUrl()")
  void testGetHelpBaseUrl() throws ThingsboardException {
    // Arrange, Act and Assert
    assertNull((new UiSettingsController()).getHelpBaseUrl());
  }
}
