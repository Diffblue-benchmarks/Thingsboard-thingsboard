package org.thingsboard.server.queue.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbQueueRemoteJsInvokeSettingsDiffblueTest {
  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#getRequestTopic()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueRemoteJsInvokeSettings#getRequestTopic()}
   */
  @Test
  @DisplayName("Test getRequestTopic(); then return 'null'")
  void testGetRequestTopic_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setPrefix("");

    // Act and Assert
    assertNull(tbQueueRemoteJsInvokeSettings.getRequestTopic());
  }

  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#getRequestTopic()}.
   * <ul>
   *   <li>Then return {@code Prefix.null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueRemoteJsInvokeSettings#getRequestTopic()}
   */
  @Test
  @DisplayName("Test getRequestTopic(); then return 'Prefix.null'")
  void testGetRequestTopic_thenReturnPrefixNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setPrefix("Prefix");

    // Act and Assert
    assertEquals("Prefix.null", tbQueueRemoteJsInvokeSettings.getRequestTopic());
  }

  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#getResponseTopic()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueRemoteJsInvokeSettings#getResponseTopic()}
   */
  @Test
  @DisplayName("Test getResponseTopic(); then return 'null'")
  void testGetResponseTopic_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setPrefix("");

    // Act and Assert
    assertNull(tbQueueRemoteJsInvokeSettings.getResponseTopic());
  }

  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#getResponseTopic()}.
   * <ul>
   *   <li>Then return {@code Prefix.null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueRemoteJsInvokeSettings#getResponseTopic()}
   */
  @Test
  @DisplayName("Test getResponseTopic(); then return 'Prefix.null'")
  void testGetResponseTopic_thenReturnPrefixNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setPrefix("Prefix");

    // Act and Assert
    assertEquals("Prefix.null", tbQueueRemoteJsInvokeSettings.getResponseTopic());
  }

  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#equals(Object)}, and
   * {@link TbQueueRemoteJsInvokeSettings#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   *   <li>{@link TbQueueRemoteJsInvokeSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setPrefix("Prefix");

    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings2 = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings2.setPrefix("Prefix");

    // Act and Assert
    assertEquals(tbQueueRemoteJsInvokeSettings, tbQueueRemoteJsInvokeSettings2);
    int expectedHashCodeResult = tbQueueRemoteJsInvokeSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueRemoteJsInvokeSettings2.hashCode());
  }

  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setPrefix("Prefix");

    // Act and Assert
    assertNotEquals(tbQueueRemoteJsInvokeSettings, new TbQueueRemoteJsInvokeSettings());
  }

  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings = new TbQueueRemoteJsInvokeSettings();

    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings2 = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings2.setPrefix("Prefix");

    // Act and Assert
    assertNotEquals(tbQueueRemoteJsInvokeSettings, tbQueueRemoteJsInvokeSettings2);
  }

  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setMaxPendingRequests(1L);

    // Act and Assert
    assertNotEquals(tbQueueRemoteJsInvokeSettings, new TbQueueRemoteJsInvokeSettings());
  }

  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setResponsePollInterval(42);

    // Act and Assert
    assertNotEquals(tbQueueRemoteJsInvokeSettings, new TbQueueRemoteJsInvokeSettings());
  }

  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setMaxRequestsTimeout(1L);

    // Act and Assert
    assertNotEquals(tbQueueRemoteJsInvokeSettings, new TbQueueRemoteJsInvokeSettings());
  }

  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setRequestTopic("Prefix");
    tbQueueRemoteJsInvokeSettings.setPrefix("Prefix");

    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings2 = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings2.setPrefix("Prefix");

    // Act and Assert
    assertNotEquals(tbQueueRemoteJsInvokeSettings, tbQueueRemoteJsInvokeSettings2);
  }

  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setResponseTopic("Prefix");
    tbQueueRemoteJsInvokeSettings.setPrefix("Prefix");

    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings2 = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings2.setPrefix("Prefix");

    // Act and Assert
    assertNotEquals(tbQueueRemoteJsInvokeSettings, tbQueueRemoteJsInvokeSettings2);
  }

  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then throw exception.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then throw exception")
  @Disabled("TODO: Complete this test")
  void testEquals_whenOtherIsDifferent_thenThrowException() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException: Cannot invoke "String.isBlank()" because "this.prefix" is null
    //       at org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings.getRequestTopic(TbQueueRemoteJsInvokeSettings.java:46)
    //       at org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings.equals(TbQueueRemoteJsInvokeSettings.java:24)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings = new TbQueueRemoteJsInvokeSettings();

    // Act and Assert
    assertThrows(NullPointerException.class,
        () -> tbQueueRemoteJsInvokeSettings.equals(new TbQueueRemoteJsInvokeSettings()));
  }

  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueRemoteJsInvokeSettings(), null);
  }

  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#equals(Object)}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is same; then return equal")
  void testEquals_whenOtherIsSame_thenReturnEqual() {
    // Arrange, Act and Assert
    assertEquals(new TbQueueRemoteJsInvokeSettings(), new TbQueueRemoteJsInvokeSettings());
  }

  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueRemoteJsInvokeSettings(), "Different type to TbQueueRemoteJsInvokeSettings");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueRemoteJsInvokeSettings#setMaxPendingRequests(long)}
   *   <li>{@link TbQueueRemoteJsInvokeSettings#setMaxRequestsTimeout(long)}
   *   <li>{@link TbQueueRemoteJsInvokeSettings#setPrefix(String)}
   *   <li>{@link TbQueueRemoteJsInvokeSettings#setRequestTopic(String)}
   *   <li>{@link TbQueueRemoteJsInvokeSettings#setResponsePollInterval(int)}
   *   <li>{@link TbQueueRemoteJsInvokeSettings#setResponseTopic(String)}
   *   <li>{@link TbQueueRemoteJsInvokeSettings#toString()}
   *   <li>{@link TbQueueRemoteJsInvokeSettings#getMaxPendingRequests()}
   *   <li>{@link TbQueueRemoteJsInvokeSettings#getMaxRequestsTimeout()}
   *   <li>{@link TbQueueRemoteJsInvokeSettings#getPrefix()}
   *   <li>{@link TbQueueRemoteJsInvokeSettings#getResponsePollInterval()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings = new TbQueueRemoteJsInvokeSettings();

    // Act
    tbQueueRemoteJsInvokeSettings.setMaxPendingRequests(1L);
    tbQueueRemoteJsInvokeSettings.setMaxRequestsTimeout(1L);
    tbQueueRemoteJsInvokeSettings.setPrefix("Prefix");
    tbQueueRemoteJsInvokeSettings.setRequestTopic("Request Topic");
    tbQueueRemoteJsInvokeSettings.setResponsePollInterval(42);
    tbQueueRemoteJsInvokeSettings.setResponseTopic("Response Topic");
    String actualToStringResult = tbQueueRemoteJsInvokeSettings.toString();
    long actualMaxPendingRequests = tbQueueRemoteJsInvokeSettings.getMaxPendingRequests();
    long actualMaxRequestsTimeout = tbQueueRemoteJsInvokeSettings.getMaxRequestsTimeout();
    String actualPrefix = tbQueueRemoteJsInvokeSettings.getPrefix();

    // Assert that nothing has changed
    assertEquals("Prefix", actualPrefix);
    assertEquals(
        "TbQueueRemoteJsInvokeSettings(prefix=Prefix, requestTopic=Prefix.Request Topic, responseTopic=Prefix.Response"
            + " Topic, maxPendingRequests=1, responsePollInterval=42, maxRequestsTimeout=1)",
        actualToStringResult);
    assertEquals(1L, actualMaxPendingRequests);
    assertEquals(1L, actualMaxRequestsTimeout);
    assertEquals(42, tbQueueRemoteJsInvokeSettings.getResponsePollInterval());
  }
}
