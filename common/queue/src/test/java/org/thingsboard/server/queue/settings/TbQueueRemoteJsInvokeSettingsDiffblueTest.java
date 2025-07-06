package org.thingsboard.server.queue.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class TbQueueRemoteJsInvokeSettingsDiffblueTest {
  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#getRequestTopic()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueRemoteJsInvokeSettings#getRequestTopic()}
   */
  @Test
  @DisplayName("Test getRequestTopic(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TbQueueRemoteJsInvokeSettings.getRequestTopic()"})
  void testGetRequestTopic_thenReturnNull() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings =
        new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setPrefix(" ");

    // Act and Assert
    assertNull(tbQueueRemoteJsInvokeSettings.getRequestTopic());
  }

  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#getRequestTopic()}.
   *
   * <ul>
   *   <li>Then return {@code Prefix.null}.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueRemoteJsInvokeSettings#getRequestTopic()}
   */
  @Test
  @DisplayName("Test getRequestTopic(); then return 'Prefix.null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TbQueueRemoteJsInvokeSettings.getRequestTopic()"})
  void testGetRequestTopic_thenReturnPrefixNull() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings =
        new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setPrefix("Prefix");

    // Act and Assert
    assertEquals("Prefix.null", tbQueueRemoteJsInvokeSettings.getRequestTopic());
  }

  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#getResponseTopic()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueRemoteJsInvokeSettings#getResponseTopic()}
   */
  @Test
  @DisplayName("Test getResponseTopic(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TbQueueRemoteJsInvokeSettings.getResponseTopic()"})
  void testGetResponseTopic_thenReturnNull() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings =
        new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setPrefix(" ");

    // Act and Assert
    assertNull(tbQueueRemoteJsInvokeSettings.getResponseTopic());
  }

  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#getResponseTopic()}.
   *
   * <ul>
   *   <li>Then return {@code Prefix.null}.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueRemoteJsInvokeSettings#getResponseTopic()}
   */
  @Test
  @DisplayName("Test getResponseTopic(); then return 'Prefix.null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TbQueueRemoteJsInvokeSettings.getResponseTopic()"})
  void testGetResponseTopic_thenReturnPrefixNull() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings =
        new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setPrefix("Prefix");

    // Act and Assert
    assertEquals("Prefix.null", tbQueueRemoteJsInvokeSettings.getResponseTopic());
  }

  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#equals(Object)}, and {@link
   * TbQueueRemoteJsInvokeSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   *   <li>{@link TbQueueRemoteJsInvokeSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueRemoteJsInvokeSettings.equals(Object)",
    "int TbQueueRemoteJsInvokeSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings =
        new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setPrefix("Prefix");

    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings2 =
        new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings2.setPrefix("Prefix");

    // Act and Assert
    assertEquals(tbQueueRemoteJsInvokeSettings, tbQueueRemoteJsInvokeSettings2);
    int expectedHashCodeResult = tbQueueRemoteJsInvokeSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueRemoteJsInvokeSettings2.hashCode());
  }

  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueRemoteJsInvokeSettings.equals(Object)",
    "int TbQueueRemoteJsInvokeSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings =
        new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setPrefix("Prefix");

    // Act and Assert
    assertNotEquals(tbQueueRemoteJsInvokeSettings, new TbQueueRemoteJsInvokeSettings());
  }

  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueRemoteJsInvokeSettings.equals(Object)",
    "int TbQueueRemoteJsInvokeSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings =
        new TbQueueRemoteJsInvokeSettings();

    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings2 =
        new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings2.setPrefix("Prefix");

    // Act and Assert
    assertNotEquals(tbQueueRemoteJsInvokeSettings, tbQueueRemoteJsInvokeSettings2);
  }

  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueRemoteJsInvokeSettings.equals(Object)",
    "int TbQueueRemoteJsInvokeSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings =
        new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setMaxPendingRequests(1L);

    // Act and Assert
    assertNotEquals(tbQueueRemoteJsInvokeSettings, new TbQueueRemoteJsInvokeSettings());
  }

  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueRemoteJsInvokeSettings.equals(Object)",
    "int TbQueueRemoteJsInvokeSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings =
        new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setResponsePollInterval(42);

    // Act and Assert
    assertNotEquals(tbQueueRemoteJsInvokeSettings, new TbQueueRemoteJsInvokeSettings());
  }

  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueRemoteJsInvokeSettings.equals(Object)",
    "int TbQueueRemoteJsInvokeSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings =
        new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setMaxRequestsTimeout(1L);

    // Act and Assert
    assertNotEquals(tbQueueRemoteJsInvokeSettings, new TbQueueRemoteJsInvokeSettings());
  }

  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueRemoteJsInvokeSettings.equals(Object)",
    "int TbQueueRemoteJsInvokeSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings =
        new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setRequestTopic("Prefix");
    tbQueueRemoteJsInvokeSettings.setPrefix("Prefix");

    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings2 =
        new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings2.setPrefix("Prefix");

    // Act and Assert
    assertNotEquals(tbQueueRemoteJsInvokeSettings, tbQueueRemoteJsInvokeSettings2);
  }

  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueRemoteJsInvokeSettings.equals(Object)",
    "int TbQueueRemoteJsInvokeSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings =
        new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setResponseTopic("Prefix");
    tbQueueRemoteJsInvokeSettings.setPrefix("Prefix");

    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings2 =
        new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings2.setPrefix("Prefix");

    // Act and Assert
    assertNotEquals(tbQueueRemoteJsInvokeSettings, tbQueueRemoteJsInvokeSettings2);
  }

  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueRemoteJsInvokeSettings.equals(Object)",
    "int TbQueueRemoteJsInvokeSettings.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueRemoteJsInvokeSettings(), null);
  }

  /**
   * Test {@link TbQueueRemoteJsInvokeSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbQueueRemoteJsInvokeSettings.equals(Object)",
    "int TbQueueRemoteJsInvokeSettings.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbQueueRemoteJsInvokeSettings(), "Different type to TbQueueRemoteJsInvokeSettings");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "long TbQueueRemoteJsInvokeSettings.getMaxPendingRequests()",
    "long TbQueueRemoteJsInvokeSettings.getMaxRequestsTimeout()",
    "String TbQueueRemoteJsInvokeSettings.getPrefix()",
    "int TbQueueRemoteJsInvokeSettings.getResponsePollInterval()",
    "void TbQueueRemoteJsInvokeSettings.setMaxPendingRequests(long)",
    "void TbQueueRemoteJsInvokeSettings.setMaxRequestsTimeout(long)",
    "void TbQueueRemoteJsInvokeSettings.setPrefix(String)",
    "void TbQueueRemoteJsInvokeSettings.setRequestTopic(String)",
    "void TbQueueRemoteJsInvokeSettings.setResponsePollInterval(int)",
    "void TbQueueRemoteJsInvokeSettings.setResponseTopic(String)",
    "String TbQueueRemoteJsInvokeSettings.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings =
        new TbQueueRemoteJsInvokeSettings();

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

    // Assert
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
