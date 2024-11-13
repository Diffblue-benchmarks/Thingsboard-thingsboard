package org.thingsboard.server.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.exception.ThingsboardErrorCode;

@ContextConfiguration(classes = {ThingsboardCredentialsViolationResponse.class, String.class})
@ExtendWith(SpringExtension.class)
class ThingsboardCredentialsViolationResponseDiffblueTest {
  @Autowired
  private ThingsboardCredentialsViolationResponse thingsboardCredentialsViolationResponse;

  /**
   * Test
   * {@link ThingsboardCredentialsViolationResponse#ThingsboardCredentialsViolationResponse(String)}.
   * <p>
   * Method under test:
   * {@link ThingsboardCredentialsViolationResponse#ThingsboardCredentialsViolationResponse(String)}
   */
  @Test
  @DisplayName("Test new ThingsboardCredentialsViolationResponse(String)")
  void testNewThingsboardCredentialsViolationResponse() {
    // Arrange and Act
    ThingsboardCredentialsViolationResponse actualThingsboardCredentialsViolationResponse = new ThingsboardCredentialsViolationResponse(
        "Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualThingsboardCredentialsViolationResponse.getMessage());
    assertEquals(401, actualThingsboardCredentialsViolationResponse.getStatus().intValue());
    assertEquals(ThingsboardErrorCode.PASSWORD_VIOLATION, actualThingsboardCredentialsViolationResponse.getErrorCode());
  }

  /**
   * Test {@link ThingsboardCredentialsViolationResponse#of(String)} with
   * {@code message}.
   * <p>
   * Method under test: {@link ThingsboardCredentialsViolationResponse#of(String)}
   */
  @Test
  @DisplayName("Test of(String) with 'message'")
  void testOfWithMessage() {
    // Arrange and Act
    ThingsboardCredentialsViolationResponse actualOfResult = ThingsboardCredentialsViolationResponse
        .of("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualOfResult.getMessage());
    assertEquals(401, actualOfResult.getStatus().intValue());
    assertEquals(ThingsboardErrorCode.PASSWORD_VIOLATION, actualOfResult.getErrorCode());
  }
}
