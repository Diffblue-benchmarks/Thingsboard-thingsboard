package org.thingsboard.rule.engine.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbSendRestApiCallReplyNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbSendRestApiCallReplyNodeConfiguration#defaultConfiguration()}.
   * <p>
   * Method under test:
   * {@link TbSendRestApiCallReplyNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  void testDefaultConfiguration() {
    // Arrange
    TbSendRestApiCallReplyNodeConfiguration tbSendRestApiCallReplyNodeConfiguration = new TbSendRestApiCallReplyNodeConfiguration();

    // Act and Assert
    assertEquals(tbSendRestApiCallReplyNodeConfiguration,
        tbSendRestApiCallReplyNodeConfiguration.defaultConfiguration());
  }

  /**
   * Test
   * {@link TbSendRestApiCallReplyNodeConfiguration#getServiceIdMetaDataAttribute()}.
   * <p>
   * Method under test:
   * {@link TbSendRestApiCallReplyNodeConfiguration#getServiceIdMetaDataAttribute()}
   */
  @Test
  @DisplayName("Test getServiceIdMetaDataAttribute()")
  void testGetServiceIdMetaDataAttribute() {
    // Arrange
    TbSendRestApiCallReplyNodeConfiguration tbSendRestApiCallReplyNodeConfiguration = new TbSendRestApiCallReplyNodeConfiguration();
    tbSendRestApiCallReplyNodeConfiguration.setServiceIdMetaDataAttribute("");

    // Act and Assert
    assertEquals(TbSendRestApiCallReplyNodeConfiguration.SERVICE_ID,
        tbSendRestApiCallReplyNodeConfiguration.getServiceIdMetaDataAttribute());
  }

  /**
   * Test
   * {@link TbSendRestApiCallReplyNodeConfiguration#getServiceIdMetaDataAttribute()}.
   * <ul>
   *   <li>Given {@link TbSendRestApiCallReplyNodeConfiguration} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSendRestApiCallReplyNodeConfiguration#getServiceIdMetaDataAttribute()}
   */
  @Test
  @DisplayName("Test getServiceIdMetaDataAttribute(); given TbSendRestApiCallReplyNodeConfiguration (default constructor)")
  void testGetServiceIdMetaDataAttribute_givenTbSendRestApiCallReplyNodeConfiguration() {
    // Arrange, Act and Assert
    assertEquals(TbSendRestApiCallReplyNodeConfiguration.SERVICE_ID,
        (new TbSendRestApiCallReplyNodeConfiguration()).getServiceIdMetaDataAttribute());
  }

  /**
   * Test
   * {@link TbSendRestApiCallReplyNodeConfiguration#getServiceIdMetaDataAttribute()}.
   * <ul>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSendRestApiCallReplyNodeConfiguration#getServiceIdMetaDataAttribute()}
   */
  @Test
  @DisplayName("Test getServiceIdMetaDataAttribute(); then return 'foo'")
  void testGetServiceIdMetaDataAttribute_thenReturnFoo() {
    // Arrange
    TbSendRestApiCallReplyNodeConfiguration tbSendRestApiCallReplyNodeConfiguration = new TbSendRestApiCallReplyNodeConfiguration();
    tbSendRestApiCallReplyNodeConfiguration.setServiceIdMetaDataAttribute("foo");

    // Act and Assert
    assertEquals("foo", tbSendRestApiCallReplyNodeConfiguration.getServiceIdMetaDataAttribute());
  }

  /**
   * Test
   * {@link TbSendRestApiCallReplyNodeConfiguration#getRequestIdMetaDataAttribute()}.
   * <p>
   * Method under test:
   * {@link TbSendRestApiCallReplyNodeConfiguration#getRequestIdMetaDataAttribute()}
   */
  @Test
  @DisplayName("Test getRequestIdMetaDataAttribute()")
  void testGetRequestIdMetaDataAttribute() {
    // Arrange
    TbSendRestApiCallReplyNodeConfiguration tbSendRestApiCallReplyNodeConfiguration = new TbSendRestApiCallReplyNodeConfiguration();
    tbSendRestApiCallReplyNodeConfiguration.setRequestIdMetaDataAttribute("");

    // Act and Assert
    assertEquals(TbSendRestApiCallReplyNodeConfiguration.REQUEST_UUID,
        tbSendRestApiCallReplyNodeConfiguration.getRequestIdMetaDataAttribute());
  }

  /**
   * Test
   * {@link TbSendRestApiCallReplyNodeConfiguration#getRequestIdMetaDataAttribute()}.
   * <ul>
   *   <li>Given {@link TbSendRestApiCallReplyNodeConfiguration} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSendRestApiCallReplyNodeConfiguration#getRequestIdMetaDataAttribute()}
   */
  @Test
  @DisplayName("Test getRequestIdMetaDataAttribute(); given TbSendRestApiCallReplyNodeConfiguration (default constructor)")
  void testGetRequestIdMetaDataAttribute_givenTbSendRestApiCallReplyNodeConfiguration() {
    // Arrange, Act and Assert
    assertEquals(TbSendRestApiCallReplyNodeConfiguration.REQUEST_UUID,
        (new TbSendRestApiCallReplyNodeConfiguration()).getRequestIdMetaDataAttribute());
  }

  /**
   * Test
   * {@link TbSendRestApiCallReplyNodeConfiguration#getRequestIdMetaDataAttribute()}.
   * <ul>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSendRestApiCallReplyNodeConfiguration#getRequestIdMetaDataAttribute()}
   */
  @Test
  @DisplayName("Test getRequestIdMetaDataAttribute(); then return 'foo'")
  void testGetRequestIdMetaDataAttribute_thenReturnFoo() {
    // Arrange
    TbSendRestApiCallReplyNodeConfiguration tbSendRestApiCallReplyNodeConfiguration = new TbSendRestApiCallReplyNodeConfiguration();
    tbSendRestApiCallReplyNodeConfiguration.setRequestIdMetaDataAttribute("foo");

    // Act and Assert
    assertEquals("foo", tbSendRestApiCallReplyNodeConfiguration.getRequestIdMetaDataAttribute());
  }

  /**
   * Test {@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}, and
   * {@link TbSendRestApiCallReplyNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendRestApiCallReplyNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbSendRestApiCallReplyNodeConfiguration tbSendRestApiCallReplyNodeConfiguration = new TbSendRestApiCallReplyNodeConfiguration();
    TbSendRestApiCallReplyNodeConfiguration tbSendRestApiCallReplyNodeConfiguration2 = new TbSendRestApiCallReplyNodeConfiguration();

    // Act and Assert
    assertEquals(tbSendRestApiCallReplyNodeConfiguration, tbSendRestApiCallReplyNodeConfiguration2);
    int expectedHashCodeResult = tbSendRestApiCallReplyNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSendRestApiCallReplyNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}, and
   * {@link TbSendRestApiCallReplyNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendRestApiCallReplyNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbSendRestApiCallReplyNodeConfiguration tbSendRestApiCallReplyNodeConfiguration = new TbSendRestApiCallReplyNodeConfiguration();
    tbSendRestApiCallReplyNodeConfiguration
        .setServiceIdMetaDataAttribute(TbSendRestApiCallReplyNodeConfiguration.SERVICE_ID);
    TbSendRestApiCallReplyNodeConfiguration tbSendRestApiCallReplyNodeConfiguration2 = new TbSendRestApiCallReplyNodeConfiguration();

    // Act and Assert
    assertEquals(tbSendRestApiCallReplyNodeConfiguration, tbSendRestApiCallReplyNodeConfiguration2);
    int expectedHashCodeResult = tbSendRestApiCallReplyNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSendRestApiCallReplyNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}, and
   * {@link TbSendRestApiCallReplyNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendRestApiCallReplyNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbSendRestApiCallReplyNodeConfiguration tbSendRestApiCallReplyNodeConfiguration = new TbSendRestApiCallReplyNodeConfiguration();

    // Act and Assert
    assertEquals(tbSendRestApiCallReplyNodeConfiguration, tbSendRestApiCallReplyNodeConfiguration);
    int expectedHashCodeResult = tbSendRestApiCallReplyNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSendRestApiCallReplyNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSendRestApiCallReplyNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbSendRestApiCallReplyNodeConfiguration tbSendRestApiCallReplyNodeConfiguration = new TbSendRestApiCallReplyNodeConfiguration();
    tbSendRestApiCallReplyNodeConfiguration
        .setRequestIdMetaDataAttribute(TbSendRestApiCallReplyNodeConfiguration.SERVICE_ID);

    // Act and Assert
    assertNotEquals(tbSendRestApiCallReplyNodeConfiguration, new TbSendRestApiCallReplyNodeConfiguration());
  }

  /**
   * Test {@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbSendRestApiCallReplyNodeConfiguration tbSendRestApiCallReplyNodeConfiguration = new TbSendRestApiCallReplyNodeConfiguration();
    tbSendRestApiCallReplyNodeConfiguration
        .setServiceIdMetaDataAttribute(TbSendRestApiCallReplyNodeConfiguration.REQUEST_UUID);

    // Act and Assert
    assertNotEquals(tbSendRestApiCallReplyNodeConfiguration, new TbSendRestApiCallReplyNodeConfiguration());
  }

  /**
   * Test {@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSendRestApiCallReplyNodeConfiguration(), null);
  }

  /**
   * Test {@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSendRestApiCallReplyNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSendRestApiCallReplyNodeConfiguration(),
        "Different type to TbSendRestApiCallReplyNodeConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TbSendRestApiCallReplyNodeConfiguration}
   *   <li>
   * {@link TbSendRestApiCallReplyNodeConfiguration#setRequestIdMetaDataAttribute(String)}
   *   <li>
   * {@link TbSendRestApiCallReplyNodeConfiguration#setServiceIdMetaDataAttribute(String)}
   *   <li>{@link TbSendRestApiCallReplyNodeConfiguration#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TbSendRestApiCallReplyNodeConfiguration actualTbSendRestApiCallReplyNodeConfiguration = new TbSendRestApiCallReplyNodeConfiguration();
    actualTbSendRestApiCallReplyNodeConfiguration.setRequestIdMetaDataAttribute("Request Id Meta Data Attribute");
    actualTbSendRestApiCallReplyNodeConfiguration.setServiceIdMetaDataAttribute("Service Id Meta Data Attribute");

    // Assert that nothing has changed
    assertEquals(
        "TbSendRestApiCallReplyNodeConfiguration(serviceIdMetaDataAttribute=Service Id Meta Data Attribute,"
            + " requestIdMetaDataAttribute=Request Id Meta Data Attribute)",
        actualTbSendRestApiCallReplyNodeConfiguration.toString());
  }
}
