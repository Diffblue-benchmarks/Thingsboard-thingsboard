package org.thingsboard.server.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.exception.ThingsboardErrorCode;

@ContextConfiguration(classes = {ThingsboardCredentialsExpiredResponse.class, String.class})
@ExtendWith(SpringExtension.class)
class ThingsboardCredentialsExpiredResponseDiffblueTest {
  @Autowired private ThingsboardCredentialsExpiredResponse thingsboardCredentialsExpiredResponse;

  /**
   * Test {@link ThingsboardCredentialsExpiredResponse#ThingsboardCredentialsExpiredResponse(String,
   * String)}.
   *
   * <p>Method under test: {@link
   * ThingsboardCredentialsExpiredResponse#ThingsboardCredentialsExpiredResponse(String, String)}
   */
  @Test
  @DisplayName("Test new ThingsboardCredentialsExpiredResponse(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ThingsboardCredentialsExpiredResponse.<init>(String, String)"})
  void testNewThingsboardCredentialsExpiredResponse() {
    // Arrange and Act
    ThingsboardCredentialsExpiredResponse actualThingsboardCredentialsExpiredResponse =
        new ThingsboardCredentialsExpiredResponse("Not all who wander are lost", "ABC123");

    // Assert
    assertEquals("ABC123", actualThingsboardCredentialsExpiredResponse.getResetToken());
    assertEquals(
        "Not all who wander are lost", actualThingsboardCredentialsExpiredResponse.getMessage());
    assertEquals(401, actualThingsboardCredentialsExpiredResponse.getStatus().intValue());
    assertEquals(
        ThingsboardErrorCode.CREDENTIALS_EXPIRED,
        actualThingsboardCredentialsExpiredResponse.getErrorCode());
  }

  /**
   * Test {@link ThingsboardCredentialsExpiredResponse#of(String, String)} with {@code message},
   * {@code resetToken}.
   *
   * <p>Method under test: {@link ThingsboardCredentialsExpiredResponse#of(String, String)}
   */
  @Test
  @DisplayName("Test of(String, String) with 'message', 'resetToken'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ThingsboardCredentialsExpiredResponse ThingsboardCredentialsExpiredResponse.of(String, String)"
  })
  void testOfWithMessageResetToken() {
    // Arrange and Act
    ThingsboardCredentialsExpiredResponse actualOfResult =
        ThingsboardCredentialsExpiredResponse.of("Not all who wander are lost", "ABC123");

    // Assert
    assertEquals("ABC123", actualOfResult.getResetToken());
    assertEquals("Not all who wander are lost", actualOfResult.getMessage());
    assertEquals(401, actualOfResult.getStatus().intValue());
    assertEquals(ThingsboardErrorCode.CREDENTIALS_EXPIRED, actualOfResult.getErrorCode());
  }

  /**
   * Test {@link ThingsboardCredentialsExpiredResponse#getResetToken()}.
   *
   * <p>Method under test: {@link ThingsboardCredentialsExpiredResponse#getResetToken()}
   */
  @Test
  @DisplayName("Test getResetToken()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ThingsboardCredentialsExpiredResponse.getResetToken()"})
  void testGetResetToken() {
    // Arrange, Act and Assert
    assertEquals(
        "ABC123",
        ThingsboardCredentialsExpiredResponse.of("Not all who wander are lost", "ABC123")
            .getResetToken());
  }
}
