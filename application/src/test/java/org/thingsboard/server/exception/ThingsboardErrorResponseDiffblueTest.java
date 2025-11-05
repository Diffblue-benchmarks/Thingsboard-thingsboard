package org.thingsboard.server.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.thingsboard.server.common.data.exception.ThingsboardErrorCode;

class ThingsboardErrorResponseDiffblueTest {
  /**
   * Test {@link ThingsboardErrorResponse#ThingsboardErrorResponse(String, ThingsboardErrorCode,
   * HttpStatus)}.
   *
   * <p>Method under test: {@link ThingsboardErrorResponse#ThingsboardErrorResponse(String,
   * ThingsboardErrorCode, HttpStatus)}
   */
  @Test
  @DisplayName("Test new ThingsboardErrorResponse(String, ThingsboardErrorCode, HttpStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ThingsboardErrorResponse.<init>(String, ThingsboardErrorCode, HttpStatus)"
  })
  void testNewThingsboardErrorResponse() {
    // Arrange and Act
    ThingsboardErrorResponse actualThingsboardErrorResponse =
        new ThingsboardErrorResponse(
            "Not all who wander are lost", ThingsboardErrorCode.GENERAL, HttpStatus.OK);

    // Assert
    assertEquals("Not all who wander are lost", actualThingsboardErrorResponse.getMessage());
    assertEquals(200, actualThingsboardErrorResponse.getStatus().intValue());
    assertEquals(ThingsboardErrorCode.GENERAL, actualThingsboardErrorResponse.getErrorCode());
  }

  /**
   * Test {@link ThingsboardErrorResponse#of(String, ThingsboardErrorCode, HttpStatus)}.
   *
   * <p>Method under test: {@link ThingsboardErrorResponse#of(String, ThingsboardErrorCode,
   * HttpStatus)}
   */
  @Test
  @DisplayName("Test of(String, ThingsboardErrorCode, HttpStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ThingsboardErrorResponse ThingsboardErrorResponse.of(String, ThingsboardErrorCode, HttpStatus)"
  })
  void testOf() {
    // Arrange and Act
    ThingsboardErrorResponse actualOfResult =
        ThingsboardErrorResponse.of(
            "Not all who wander are lost", ThingsboardErrorCode.GENERAL, HttpStatus.OK);

    // Assert
    assertEquals("Not all who wander are lost", actualOfResult.getMessage());
    assertEquals(200, actualOfResult.getStatus().intValue());
    assertEquals(ThingsboardErrorCode.GENERAL, actualOfResult.getErrorCode());
  }

  /**
   * Test {@link ThingsboardErrorResponse#getStatus()}.
   *
   * <p>Method under test: {@link ThingsboardErrorResponse#getStatus()}
   */
  @Test
  @DisplayName("Test getStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer ThingsboardErrorResponse.getStatus()"})
  void testGetStatus() {
    // Arrange, Act and Assert
    assertEquals(
        200,
        ThingsboardErrorResponse.of(
                "Not all who wander are lost", ThingsboardErrorCode.GENERAL, HttpStatus.OK)
            .getStatus()
            .intValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ThingsboardErrorResponse#getErrorCode()}
   *   <li>{@link ThingsboardErrorResponse#getMessage()}
   *   <li>{@link ThingsboardErrorResponse#getTimestamp()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ThingsboardErrorCode ThingsboardErrorResponse.getErrorCode()",
    "String ThingsboardErrorResponse.getMessage()",
    "long ThingsboardErrorResponse.getTimestamp()"
  })
  void testGettersAndSetters() {
    // Arrange
    ThingsboardErrorResponse ofResult =
        ThingsboardErrorResponse.of(
            "Not all who wander are lost", ThingsboardErrorCode.GENERAL, HttpStatus.OK);

    // Act
    ThingsboardErrorCode actualErrorCode = ofResult.getErrorCode();
    String actualMessage = ofResult.getMessage();
    ofResult.getTimestamp();

    // Assert
    assertEquals("Not all who wander are lost", actualMessage);
    assertEquals(ThingsboardErrorCode.GENERAL, actualErrorCode);
  }
}
