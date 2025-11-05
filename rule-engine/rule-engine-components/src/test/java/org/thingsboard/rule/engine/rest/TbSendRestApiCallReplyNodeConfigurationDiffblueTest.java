package org.thingsboard.rule.engine.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbSendRestApiCallReplyNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbSendRestApiCallReplyNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbSendRestApiCallReplyNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbSendRestApiCallReplyNodeConfiguration TbSendRestApiCallReplyNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange
    TbSendRestApiCallReplyNodeConfiguration tbSendRestApiCallReplyNodeConfiguration =
        new TbSendRestApiCallReplyNodeConfiguration();

    // Act
    TbSendRestApiCallReplyNodeConfiguration actualDefaultConfigurationResult =
        tbSendRestApiCallReplyNodeConfiguration.defaultConfiguration();

    // Assert
    assertEquals(tbSendRestApiCallReplyNodeConfiguration, actualDefaultConfigurationResult);
  }

  /**
   * Test {@link TbSendRestApiCallReplyNodeConfiguration#getServiceIdMetaDataAttribute()}.
   *
   * <p>Method under test: {@link
   * TbSendRestApiCallReplyNodeConfiguration#getServiceIdMetaDataAttribute()}
   */
  @Test
  @DisplayName("Test getServiceIdMetaDataAttribute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TbSendRestApiCallReplyNodeConfiguration.getServiceIdMetaDataAttribute()"
  })
  void testGetServiceIdMetaDataAttribute() {
    // Arrange
    TbSendRestApiCallReplyNodeConfiguration tbSendRestApiCallReplyNodeConfiguration =
        new TbSendRestApiCallReplyNodeConfiguration();
    tbSendRestApiCallReplyNodeConfiguration.setServiceIdMetaDataAttribute("");

    // Act and Assert
    assertEquals(
        TbSendRestApiCallReplyNodeConfiguration.SERVICE_ID,
        tbSendRestApiCallReplyNodeConfiguration.getServiceIdMetaDataAttribute());
  }

  /**
   * Test {@link TbSendRestApiCallReplyNodeConfiguration#getServiceIdMetaDataAttribute()}.
   *
   * <p>Method under test: {@link
   * TbSendRestApiCallReplyNodeConfiguration#getServiceIdMetaDataAttribute()}
   */
  @Test
  @DisplayName("Test getServiceIdMetaDataAttribute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TbSendRestApiCallReplyNodeConfiguration.getServiceIdMetaDataAttribute()"
  })
  void testGetServiceIdMetaDataAttribute2() {
    // Arrange
    TbSendRestApiCallReplyNodeConfiguration tbSendRestApiCallReplyNodeConfiguration =
        new TbSendRestApiCallReplyNodeConfiguration();
    tbSendRestApiCallReplyNodeConfiguration.setServiceIdMetaDataAttribute(
        TbSendRestApiCallReplyNodeConfiguration.SERVICE_ID);

    // Act and Assert
    assertEquals(
        TbSendRestApiCallReplyNodeConfiguration.SERVICE_ID,
        tbSendRestApiCallReplyNodeConfiguration.getServiceIdMetaDataAttribute());
  }

  /**
   * Test {@link TbSendRestApiCallReplyNodeConfiguration#getServiceIdMetaDataAttribute()}.
   *
   * <ul>
   *   <li>Given {@link TbSendRestApiCallReplyNodeConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * TbSendRestApiCallReplyNodeConfiguration#getServiceIdMetaDataAttribute()}
   */
  @Test
  @DisplayName(
      "Test getServiceIdMetaDataAttribute(); given TbSendRestApiCallReplyNodeConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TbSendRestApiCallReplyNodeConfiguration.getServiceIdMetaDataAttribute()"
  })
  void testGetServiceIdMetaDataAttribute_givenTbSendRestApiCallReplyNodeConfiguration() {
    // Arrange, Act and Assert
    assertEquals(
        TbSendRestApiCallReplyNodeConfiguration.SERVICE_ID,
        new TbSendRestApiCallReplyNodeConfiguration().getServiceIdMetaDataAttribute());
  }

  /**
   * Test {@link TbSendRestApiCallReplyNodeConfiguration#getRequestIdMetaDataAttribute()}.
   *
   * <p>Method under test: {@link
   * TbSendRestApiCallReplyNodeConfiguration#getRequestIdMetaDataAttribute()}
   */
  @Test
  @DisplayName("Test getRequestIdMetaDataAttribute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TbSendRestApiCallReplyNodeConfiguration.getRequestIdMetaDataAttribute()"
  })
  void testGetRequestIdMetaDataAttribute() {
    // Arrange
    TbSendRestApiCallReplyNodeConfiguration tbSendRestApiCallReplyNodeConfiguration =
        new TbSendRestApiCallReplyNodeConfiguration();
    tbSendRestApiCallReplyNodeConfiguration.setRequestIdMetaDataAttribute("");

    // Act and Assert
    assertEquals(
        TbSendRestApiCallReplyNodeConfiguration.REQUEST_UUID,
        tbSendRestApiCallReplyNodeConfiguration.getRequestIdMetaDataAttribute());
  }

  /**
   * Test {@link TbSendRestApiCallReplyNodeConfiguration#getRequestIdMetaDataAttribute()}.
   *
   * <p>Method under test: {@link
   * TbSendRestApiCallReplyNodeConfiguration#getRequestIdMetaDataAttribute()}
   */
  @Test
  @DisplayName("Test getRequestIdMetaDataAttribute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TbSendRestApiCallReplyNodeConfiguration.getRequestIdMetaDataAttribute()"
  })
  void testGetRequestIdMetaDataAttribute2() {
    // Arrange
    TbSendRestApiCallReplyNodeConfiguration tbSendRestApiCallReplyNodeConfiguration =
        new TbSendRestApiCallReplyNodeConfiguration();
    tbSendRestApiCallReplyNodeConfiguration.setRequestIdMetaDataAttribute(
        TbSendRestApiCallReplyNodeConfiguration.REQUEST_UUID);

    // Act and Assert
    assertEquals(
        TbSendRestApiCallReplyNodeConfiguration.REQUEST_UUID,
        tbSendRestApiCallReplyNodeConfiguration.getRequestIdMetaDataAttribute());
  }

  /**
   * Test {@link TbSendRestApiCallReplyNodeConfiguration#getRequestIdMetaDataAttribute()}.
   *
   * <ul>
   *   <li>Given {@link TbSendRestApiCallReplyNodeConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * TbSendRestApiCallReplyNodeConfiguration#getRequestIdMetaDataAttribute()}
   */
  @Test
  @DisplayName(
      "Test getRequestIdMetaDataAttribute(); given TbSendRestApiCallReplyNodeConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TbSendRestApiCallReplyNodeConfiguration.getRequestIdMetaDataAttribute()"
  })
  void testGetRequestIdMetaDataAttribute_givenTbSendRestApiCallReplyNodeConfiguration() {
    // Arrange, Act and Assert
    assertEquals(
        TbSendRestApiCallReplyNodeConfiguration.REQUEST_UUID,
        new TbSendRestApiCallReplyNodeConfiguration().getRequestIdMetaDataAttribute());
  }

  /**
   * Test {@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}, and {@link
   * TbSendRestApiCallReplyNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendRestApiCallReplyNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendRestApiCallReplyNodeConfiguration.equals(Object)",
    "int TbSendRestApiCallReplyNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbSendRestApiCallReplyNodeConfiguration tbSendRestApiCallReplyNodeConfiguration =
        new TbSendRestApiCallReplyNodeConfiguration();
    TbSendRestApiCallReplyNodeConfiguration tbSendRestApiCallReplyNodeConfiguration2 =
        new TbSendRestApiCallReplyNodeConfiguration();

    // Act and Assert
    assertEquals(tbSendRestApiCallReplyNodeConfiguration, tbSendRestApiCallReplyNodeConfiguration2);
    assertEquals(
        tbSendRestApiCallReplyNodeConfiguration.hashCode(),
        tbSendRestApiCallReplyNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}, and {@link
   * TbSendRestApiCallReplyNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendRestApiCallReplyNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendRestApiCallReplyNodeConfiguration.equals(Object)",
    "int TbSendRestApiCallReplyNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbSendRestApiCallReplyNodeConfiguration tbSendRestApiCallReplyNodeConfiguration =
        new TbSendRestApiCallReplyNodeConfiguration();
    tbSendRestApiCallReplyNodeConfiguration.setServiceIdMetaDataAttribute(
        TbSendRestApiCallReplyNodeConfiguration.SERVICE_ID);
    TbSendRestApiCallReplyNodeConfiguration tbSendRestApiCallReplyNodeConfiguration2 =
        new TbSendRestApiCallReplyNodeConfiguration();

    // Act and Assert
    assertEquals(tbSendRestApiCallReplyNodeConfiguration, tbSendRestApiCallReplyNodeConfiguration2);
    assertEquals(
        tbSendRestApiCallReplyNodeConfiguration.hashCode(),
        tbSendRestApiCallReplyNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}, and {@link
   * TbSendRestApiCallReplyNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendRestApiCallReplyNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendRestApiCallReplyNodeConfiguration.equals(Object)",
    "int TbSendRestApiCallReplyNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbSendRestApiCallReplyNodeConfiguration tbSendRestApiCallReplyNodeConfiguration =
        new TbSendRestApiCallReplyNodeConfiguration();

    // Act and Assert
    assertEquals(tbSendRestApiCallReplyNodeConfiguration, tbSendRestApiCallReplyNodeConfiguration);
    int expectedHashCodeResult = tbSendRestApiCallReplyNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSendRestApiCallReplyNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendRestApiCallReplyNodeConfiguration.equals(Object)",
    "int TbSendRestApiCallReplyNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSendRestApiCallReplyNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendRestApiCallReplyNodeConfiguration.equals(Object)",
    "int TbSendRestApiCallReplyNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbSendRestApiCallReplyNodeConfiguration tbSendRestApiCallReplyNodeConfiguration =
        new TbSendRestApiCallReplyNodeConfiguration();
    tbSendRestApiCallReplyNodeConfiguration.setRequestIdMetaDataAttribute(
        TbSendRestApiCallReplyNodeConfiguration.SERVICE_ID);

    // Act and Assert
    assertNotEquals(
        tbSendRestApiCallReplyNodeConfiguration, new TbSendRestApiCallReplyNodeConfiguration());
  }

  /**
   * Test {@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendRestApiCallReplyNodeConfiguration.equals(Object)",
    "int TbSendRestApiCallReplyNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbSendRestApiCallReplyNodeConfiguration tbSendRestApiCallReplyNodeConfiguration =
        new TbSendRestApiCallReplyNodeConfiguration();
    tbSendRestApiCallReplyNodeConfiguration.setServiceIdMetaDataAttribute(
        TbSendRestApiCallReplyNodeConfiguration.REQUEST_UUID);

    // Act and Assert
    assertNotEquals(
        tbSendRestApiCallReplyNodeConfiguration, new TbSendRestApiCallReplyNodeConfiguration());
  }

  /**
   * Test {@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendRestApiCallReplyNodeConfiguration.equals(Object)",
    "int TbSendRestApiCallReplyNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSendRestApiCallReplyNodeConfiguration(), null);
  }

  /**
   * Test {@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendRestApiCallReplyNodeConfiguration.equals(Object)",
    "int TbSendRestApiCallReplyNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbSendRestApiCallReplyNodeConfiguration(),
        "Different type to TbSendRestApiCallReplyNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbSendRestApiCallReplyNodeConfiguration}
   *   <li>{@link TbSendRestApiCallReplyNodeConfiguration#setRequestIdMetaDataAttribute(String)}
   *   <li>{@link TbSendRestApiCallReplyNodeConfiguration#setServiceIdMetaDataAttribute(String)}
   *   <li>{@link TbSendRestApiCallReplyNodeConfiguration#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbSendRestApiCallReplyNodeConfiguration.<init>()",
    "void TbSendRestApiCallReplyNodeConfiguration.setRequestIdMetaDataAttribute(String)",
    "void TbSendRestApiCallReplyNodeConfiguration.setServiceIdMetaDataAttribute(String)",
    "String TbSendRestApiCallReplyNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbSendRestApiCallReplyNodeConfiguration actualTbSendRestApiCallReplyNodeConfiguration =
        new TbSendRestApiCallReplyNodeConfiguration();
    actualTbSendRestApiCallReplyNodeConfiguration.setRequestIdMetaDataAttribute(
        "Request Id Meta Data Attribute");
    actualTbSendRestApiCallReplyNodeConfiguration.setServiceIdMetaDataAttribute(
        "Service Id Meta Data Attribute");

    // Assert
    assertEquals(
        "TbSendRestApiCallReplyNodeConfiguration(serviceIdMetaDataAttribute=Service Id Meta Data Attribute,"
            + " requestIdMetaDataAttribute=Request Id Meta Data Attribute)",
        actualTbSendRestApiCallReplyNodeConfiguration.toString());
  }
}
