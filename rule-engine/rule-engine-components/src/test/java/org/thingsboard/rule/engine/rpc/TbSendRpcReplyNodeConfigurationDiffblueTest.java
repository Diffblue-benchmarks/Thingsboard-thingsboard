package org.thingsboard.rule.engine.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbSendRpcReplyNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbSendRpcReplyNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbSendRpcReplyNodeConfiguration TbSendRpcReplyNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration =
        new TbSendRpcReplyNodeConfiguration();

    // Act
    TbSendRpcReplyNodeConfiguration actualDefaultConfigurationResult =
        tbSendRpcReplyNodeConfiguration.defaultConfiguration();

    // Assert
    assertEquals(tbSendRpcReplyNodeConfiguration, actualDefaultConfigurationResult);
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#getServiceIdMetaDataAttribute()}.
   *
   * <p>Method under test: {@link TbSendRpcReplyNodeConfiguration#getServiceIdMetaDataAttribute()}
   */
  @Test
  @DisplayName("Test getServiceIdMetaDataAttribute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbSendRpcReplyNodeConfiguration.getServiceIdMetaDataAttribute()"})
  void testGetServiceIdMetaDataAttribute() {
    // Arrange
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration =
        new TbSendRpcReplyNodeConfiguration();
    tbSendRpcReplyNodeConfiguration.setServiceIdMetaDataAttribute("");

    // Act and Assert
    assertEquals(
        TbSendRpcReplyNodeConfiguration.SERVICE_ID,
        tbSendRpcReplyNodeConfiguration.getServiceIdMetaDataAttribute());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#getServiceIdMetaDataAttribute()}.
   *
   * <p>Method under test: {@link TbSendRpcReplyNodeConfiguration#getServiceIdMetaDataAttribute()}
   */
  @Test
  @DisplayName("Test getServiceIdMetaDataAttribute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbSendRpcReplyNodeConfiguration.getServiceIdMetaDataAttribute()"})
  void testGetServiceIdMetaDataAttribute2() {
    // Arrange
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration =
        new TbSendRpcReplyNodeConfiguration();
    tbSendRpcReplyNodeConfiguration.setServiceIdMetaDataAttribute(
        TbSendRpcReplyNodeConfiguration.SERVICE_ID);

    // Act and Assert
    assertEquals(
        TbSendRpcReplyNodeConfiguration.SERVICE_ID,
        tbSendRpcReplyNodeConfiguration.getServiceIdMetaDataAttribute());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#getServiceIdMetaDataAttribute()}.
   *
   * <ul>
   *   <li>Given {@link TbSendRpcReplyNodeConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbSendRpcReplyNodeConfiguration#getServiceIdMetaDataAttribute()}
   */
  @Test
  @DisplayName(
      "Test getServiceIdMetaDataAttribute(); given TbSendRpcReplyNodeConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbSendRpcReplyNodeConfiguration.getServiceIdMetaDataAttribute()"})
  void testGetServiceIdMetaDataAttribute_givenTbSendRpcReplyNodeConfiguration() {
    // Arrange, Act and Assert
    assertEquals(
        TbSendRpcReplyNodeConfiguration.SERVICE_ID,
        new TbSendRpcReplyNodeConfiguration().getServiceIdMetaDataAttribute());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#getSessionIdMetaDataAttribute()}.
   *
   * <p>Method under test: {@link TbSendRpcReplyNodeConfiguration#getSessionIdMetaDataAttribute()}
   */
  @Test
  @DisplayName("Test getSessionIdMetaDataAttribute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbSendRpcReplyNodeConfiguration.getSessionIdMetaDataAttribute()"})
  void testGetSessionIdMetaDataAttribute() {
    // Arrange
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration =
        new TbSendRpcReplyNodeConfiguration();
    tbSendRpcReplyNodeConfiguration.setSessionIdMetaDataAttribute("");

    // Act and Assert
    assertEquals(
        TbSendRpcReplyNodeConfiguration.SESSION_ID,
        tbSendRpcReplyNodeConfiguration.getSessionIdMetaDataAttribute());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#getSessionIdMetaDataAttribute()}.
   *
   * <p>Method under test: {@link TbSendRpcReplyNodeConfiguration#getSessionIdMetaDataAttribute()}
   */
  @Test
  @DisplayName("Test getSessionIdMetaDataAttribute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbSendRpcReplyNodeConfiguration.getSessionIdMetaDataAttribute()"})
  void testGetSessionIdMetaDataAttribute2() {
    // Arrange
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration =
        new TbSendRpcReplyNodeConfiguration();
    tbSendRpcReplyNodeConfiguration.setSessionIdMetaDataAttribute(
        TbSendRpcReplyNodeConfiguration.SESSION_ID);

    // Act and Assert
    assertEquals(
        TbSendRpcReplyNodeConfiguration.SESSION_ID,
        tbSendRpcReplyNodeConfiguration.getSessionIdMetaDataAttribute());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#getSessionIdMetaDataAttribute()}.
   *
   * <ul>
   *   <li>Given {@link TbSendRpcReplyNodeConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbSendRpcReplyNodeConfiguration#getSessionIdMetaDataAttribute()}
   */
  @Test
  @DisplayName(
      "Test getSessionIdMetaDataAttribute(); given TbSendRpcReplyNodeConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbSendRpcReplyNodeConfiguration.getSessionIdMetaDataAttribute()"})
  void testGetSessionIdMetaDataAttribute_givenTbSendRpcReplyNodeConfiguration() {
    // Arrange, Act and Assert
    assertEquals(
        TbSendRpcReplyNodeConfiguration.SESSION_ID,
        new TbSendRpcReplyNodeConfiguration().getSessionIdMetaDataAttribute());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#getRequestIdMetaDataAttribute()}.
   *
   * <p>Method under test: {@link TbSendRpcReplyNodeConfiguration#getRequestIdMetaDataAttribute()}
   */
  @Test
  @DisplayName("Test getRequestIdMetaDataAttribute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbSendRpcReplyNodeConfiguration.getRequestIdMetaDataAttribute()"})
  void testGetRequestIdMetaDataAttribute() {
    // Arrange
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration =
        new TbSendRpcReplyNodeConfiguration();
    tbSendRpcReplyNodeConfiguration.setRequestIdMetaDataAttribute("");

    // Act and Assert
    assertEquals(
        TbSendRpcReplyNodeConfiguration.REQUEST_ID,
        tbSendRpcReplyNodeConfiguration.getRequestIdMetaDataAttribute());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#getRequestIdMetaDataAttribute()}.
   *
   * <p>Method under test: {@link TbSendRpcReplyNodeConfiguration#getRequestIdMetaDataAttribute()}
   */
  @Test
  @DisplayName("Test getRequestIdMetaDataAttribute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbSendRpcReplyNodeConfiguration.getRequestIdMetaDataAttribute()"})
  void testGetRequestIdMetaDataAttribute2() {
    // Arrange
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration =
        new TbSendRpcReplyNodeConfiguration();
    tbSendRpcReplyNodeConfiguration.setRequestIdMetaDataAttribute(
        TbSendRpcReplyNodeConfiguration.REQUEST_ID);

    // Act and Assert
    assertEquals(
        TbSendRpcReplyNodeConfiguration.REQUEST_ID,
        tbSendRpcReplyNodeConfiguration.getRequestIdMetaDataAttribute());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#getRequestIdMetaDataAttribute()}.
   *
   * <ul>
   *   <li>Given {@link TbSendRpcReplyNodeConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbSendRpcReplyNodeConfiguration#getRequestIdMetaDataAttribute()}
   */
  @Test
  @DisplayName(
      "Test getRequestIdMetaDataAttribute(); given TbSendRpcReplyNodeConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbSendRpcReplyNodeConfiguration.getRequestIdMetaDataAttribute()"})
  void testGetRequestIdMetaDataAttribute_givenTbSendRpcReplyNodeConfiguration() {
    // Arrange, Act and Assert
    assertEquals(
        TbSendRpcReplyNodeConfiguration.REQUEST_ID,
        new TbSendRpcReplyNodeConfiguration().getRequestIdMetaDataAttribute());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#equals(Object)}, and {@link
   * TbSendRpcReplyNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSendRpcReplyNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendRpcReplyNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendRpcReplyNodeConfiguration.equals(Object)",
    "int TbSendRpcReplyNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration =
        new TbSendRpcReplyNodeConfiguration();
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration2 =
        new TbSendRpcReplyNodeConfiguration();

    // Act and Assert
    assertEquals(tbSendRpcReplyNodeConfiguration, tbSendRpcReplyNodeConfiguration2);
    assertEquals(
        tbSendRpcReplyNodeConfiguration.hashCode(), tbSendRpcReplyNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#equals(Object)}, and {@link
   * TbSendRpcReplyNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSendRpcReplyNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendRpcReplyNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendRpcReplyNodeConfiguration.equals(Object)",
    "int TbSendRpcReplyNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration =
        new TbSendRpcReplyNodeConfiguration();
    tbSendRpcReplyNodeConfiguration.setServiceIdMetaDataAttribute(
        TbSendRpcReplyNodeConfiguration.SERVICE_ID);
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration2 =
        new TbSendRpcReplyNodeConfiguration();

    // Act and Assert
    assertEquals(tbSendRpcReplyNodeConfiguration, tbSendRpcReplyNodeConfiguration2);
    assertEquals(
        tbSendRpcReplyNodeConfiguration.hashCode(), tbSendRpcReplyNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#equals(Object)}, and {@link
   * TbSendRpcReplyNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSendRpcReplyNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendRpcReplyNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendRpcReplyNodeConfiguration.equals(Object)",
    "int TbSendRpcReplyNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration =
        new TbSendRpcReplyNodeConfiguration();

    // Act and Assert
    assertEquals(tbSendRpcReplyNodeConfiguration, tbSendRpcReplyNodeConfiguration);
    int expectedHashCodeResult = tbSendRpcReplyNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSendRpcReplyNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSendRpcReplyNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendRpcReplyNodeConfiguration.equals(Object)",
    "int TbSendRpcReplyNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSendRpcReplyNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSendRpcReplyNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendRpcReplyNodeConfiguration.equals(Object)",
    "int TbSendRpcReplyNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration =
        new TbSendRpcReplyNodeConfiguration();
    tbSendRpcReplyNodeConfiguration.setSessionIdMetaDataAttribute(
        TbSendRpcReplyNodeConfiguration.SERVICE_ID);

    // Act and Assert
    assertNotEquals(tbSendRpcReplyNodeConfiguration, new TbSendRpcReplyNodeConfiguration());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSendRpcReplyNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendRpcReplyNodeConfiguration.equals(Object)",
    "int TbSendRpcReplyNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration =
        new TbSendRpcReplyNodeConfiguration();
    tbSendRpcReplyNodeConfiguration.setRequestIdMetaDataAttribute(
        TbSendRpcReplyNodeConfiguration.SERVICE_ID);

    // Act and Assert
    assertNotEquals(tbSendRpcReplyNodeConfiguration, new TbSendRpcReplyNodeConfiguration());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSendRpcReplyNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendRpcReplyNodeConfiguration.equals(Object)",
    "int TbSendRpcReplyNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration =
        new TbSendRpcReplyNodeConfiguration();
    tbSendRpcReplyNodeConfiguration.setServiceIdMetaDataAttribute(
        TbSendRpcReplyNodeConfiguration.SESSION_ID);

    // Act and Assert
    assertNotEquals(tbSendRpcReplyNodeConfiguration, new TbSendRpcReplyNodeConfiguration());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSendRpcReplyNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendRpcReplyNodeConfiguration.equals(Object)",
    "int TbSendRpcReplyNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSendRpcReplyNodeConfiguration(), null);
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSendRpcReplyNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendRpcReplyNodeConfiguration.equals(Object)",
    "int TbSendRpcReplyNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbSendRpcReplyNodeConfiguration(), "Different type to TbSendRpcReplyNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbSendRpcReplyNodeConfiguration}
   *   <li>{@link TbSendRpcReplyNodeConfiguration#setRequestIdMetaDataAttribute(String)}
   *   <li>{@link TbSendRpcReplyNodeConfiguration#setServiceIdMetaDataAttribute(String)}
   *   <li>{@link TbSendRpcReplyNodeConfiguration#setSessionIdMetaDataAttribute(String)}
   *   <li>{@link TbSendRpcReplyNodeConfiguration#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbSendRpcReplyNodeConfiguration.<init>()",
    "void TbSendRpcReplyNodeConfiguration.setRequestIdMetaDataAttribute(String)",
    "void TbSendRpcReplyNodeConfiguration.setServiceIdMetaDataAttribute(String)",
    "void TbSendRpcReplyNodeConfiguration.setSessionIdMetaDataAttribute(String)",
    "String TbSendRpcReplyNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbSendRpcReplyNodeConfiguration actualTbSendRpcReplyNodeConfiguration =
        new TbSendRpcReplyNodeConfiguration();
    actualTbSendRpcReplyNodeConfiguration.setRequestIdMetaDataAttribute(
        "Request Id Meta Data Attribute");
    actualTbSendRpcReplyNodeConfiguration.setServiceIdMetaDataAttribute(
        "Service Id Meta Data Attribute");
    actualTbSendRpcReplyNodeConfiguration.setSessionIdMetaDataAttribute(
        "Session Id Meta Data Attribute");

    // Assert
    assertEquals(
        "TbSendRpcReplyNodeConfiguration(serviceIdMetaDataAttribute=Service Id Meta Data Attribute,"
            + " sessionIdMetaDataAttribute=Session Id Meta Data Attribute, requestIdMetaDataAttribute=Request Id"
            + " Meta Data Attribute)",
        actualTbSendRpcReplyNodeConfiguration.toString());
  }
}
