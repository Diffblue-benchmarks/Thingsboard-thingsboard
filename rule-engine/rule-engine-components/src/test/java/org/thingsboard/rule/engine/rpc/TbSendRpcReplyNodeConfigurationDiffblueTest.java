package org.thingsboard.rule.engine.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbSendRpcReplyNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#defaultConfiguration()}.
   * <p>
   * Method under test:
   * {@link TbSendRpcReplyNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  void testDefaultConfiguration() {
    // Arrange
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration = new TbSendRpcReplyNodeConfiguration();

    // Act and Assert
    assertEquals(tbSendRpcReplyNodeConfiguration, tbSendRpcReplyNodeConfiguration.defaultConfiguration());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#getServiceIdMetaDataAttribute()}.
   * <p>
   * Method under test:
   * {@link TbSendRpcReplyNodeConfiguration#getServiceIdMetaDataAttribute()}
   */
  @Test
  @DisplayName("Test getServiceIdMetaDataAttribute()")
  void testGetServiceIdMetaDataAttribute() {
    // Arrange
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration = new TbSendRpcReplyNodeConfiguration();
    tbSendRpcReplyNodeConfiguration.setServiceIdMetaDataAttribute("");

    // Act and Assert
    assertEquals(TbSendRpcReplyNodeConfiguration.SERVICE_ID,
        tbSendRpcReplyNodeConfiguration.getServiceIdMetaDataAttribute());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#getServiceIdMetaDataAttribute()}.
   * <ul>
   *   <li>Given {@link TbSendRpcReplyNodeConfiguration} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSendRpcReplyNodeConfiguration#getServiceIdMetaDataAttribute()}
   */
  @Test
  @DisplayName("Test getServiceIdMetaDataAttribute(); given TbSendRpcReplyNodeConfiguration (default constructor)")
  void testGetServiceIdMetaDataAttribute_givenTbSendRpcReplyNodeConfiguration() {
    // Arrange, Act and Assert
    assertEquals(TbSendRpcReplyNodeConfiguration.SERVICE_ID,
        (new TbSendRpcReplyNodeConfiguration()).getServiceIdMetaDataAttribute());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#getServiceIdMetaDataAttribute()}.
   * <ul>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSendRpcReplyNodeConfiguration#getServiceIdMetaDataAttribute()}
   */
  @Test
  @DisplayName("Test getServiceIdMetaDataAttribute(); then return 'foo'")
  void testGetServiceIdMetaDataAttribute_thenReturnFoo() {
    // Arrange
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration = new TbSendRpcReplyNodeConfiguration();
    tbSendRpcReplyNodeConfiguration.setServiceIdMetaDataAttribute("foo");

    // Act and Assert
    assertEquals("foo", tbSendRpcReplyNodeConfiguration.getServiceIdMetaDataAttribute());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#getSessionIdMetaDataAttribute()}.
   * <p>
   * Method under test:
   * {@link TbSendRpcReplyNodeConfiguration#getSessionIdMetaDataAttribute()}
   */
  @Test
  @DisplayName("Test getSessionIdMetaDataAttribute()")
  void testGetSessionIdMetaDataAttribute() {
    // Arrange
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration = new TbSendRpcReplyNodeConfiguration();
    tbSendRpcReplyNodeConfiguration.setSessionIdMetaDataAttribute("");

    // Act and Assert
    assertEquals(TbSendRpcReplyNodeConfiguration.SESSION_ID,
        tbSendRpcReplyNodeConfiguration.getSessionIdMetaDataAttribute());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#getSessionIdMetaDataAttribute()}.
   * <ul>
   *   <li>Given {@link TbSendRpcReplyNodeConfiguration} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSendRpcReplyNodeConfiguration#getSessionIdMetaDataAttribute()}
   */
  @Test
  @DisplayName("Test getSessionIdMetaDataAttribute(); given TbSendRpcReplyNodeConfiguration (default constructor)")
  void testGetSessionIdMetaDataAttribute_givenTbSendRpcReplyNodeConfiguration() {
    // Arrange, Act and Assert
    assertEquals(TbSendRpcReplyNodeConfiguration.SESSION_ID,
        (new TbSendRpcReplyNodeConfiguration()).getSessionIdMetaDataAttribute());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#getSessionIdMetaDataAttribute()}.
   * <ul>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSendRpcReplyNodeConfiguration#getSessionIdMetaDataAttribute()}
   */
  @Test
  @DisplayName("Test getSessionIdMetaDataAttribute(); then return 'foo'")
  void testGetSessionIdMetaDataAttribute_thenReturnFoo() {
    // Arrange
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration = new TbSendRpcReplyNodeConfiguration();
    tbSendRpcReplyNodeConfiguration.setSessionIdMetaDataAttribute("foo");

    // Act and Assert
    assertEquals("foo", tbSendRpcReplyNodeConfiguration.getSessionIdMetaDataAttribute());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#getRequestIdMetaDataAttribute()}.
   * <p>
   * Method under test:
   * {@link TbSendRpcReplyNodeConfiguration#getRequestIdMetaDataAttribute()}
   */
  @Test
  @DisplayName("Test getRequestIdMetaDataAttribute()")
  void testGetRequestIdMetaDataAttribute() {
    // Arrange
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration = new TbSendRpcReplyNodeConfiguration();
    tbSendRpcReplyNodeConfiguration.setRequestIdMetaDataAttribute("");

    // Act and Assert
    assertEquals(TbSendRpcReplyNodeConfiguration.REQUEST_ID,
        tbSendRpcReplyNodeConfiguration.getRequestIdMetaDataAttribute());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#getRequestIdMetaDataAttribute()}.
   * <ul>
   *   <li>Given {@link TbSendRpcReplyNodeConfiguration} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSendRpcReplyNodeConfiguration#getRequestIdMetaDataAttribute()}
   */
  @Test
  @DisplayName("Test getRequestIdMetaDataAttribute(); given TbSendRpcReplyNodeConfiguration (default constructor)")
  void testGetRequestIdMetaDataAttribute_givenTbSendRpcReplyNodeConfiguration() {
    // Arrange, Act and Assert
    assertEquals(TbSendRpcReplyNodeConfiguration.REQUEST_ID,
        (new TbSendRpcReplyNodeConfiguration()).getRequestIdMetaDataAttribute());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#getRequestIdMetaDataAttribute()}.
   * <ul>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSendRpcReplyNodeConfiguration#getRequestIdMetaDataAttribute()}
   */
  @Test
  @DisplayName("Test getRequestIdMetaDataAttribute(); then return 'foo'")
  void testGetRequestIdMetaDataAttribute_thenReturnFoo() {
    // Arrange
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration = new TbSendRpcReplyNodeConfiguration();
    tbSendRpcReplyNodeConfiguration.setRequestIdMetaDataAttribute("foo");

    // Act and Assert
    assertEquals("foo", tbSendRpcReplyNodeConfiguration.getRequestIdMetaDataAttribute());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#equals(Object)}, and
   * {@link TbSendRpcReplyNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSendRpcReplyNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendRpcReplyNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration = new TbSendRpcReplyNodeConfiguration();
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration2 = new TbSendRpcReplyNodeConfiguration();

    // Act and Assert
    assertEquals(tbSendRpcReplyNodeConfiguration, tbSendRpcReplyNodeConfiguration2);
    int expectedHashCodeResult = tbSendRpcReplyNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSendRpcReplyNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#equals(Object)}, and
   * {@link TbSendRpcReplyNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSendRpcReplyNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendRpcReplyNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration = new TbSendRpcReplyNodeConfiguration();
    tbSendRpcReplyNodeConfiguration.setServiceIdMetaDataAttribute(TbSendRpcReplyNodeConfiguration.SERVICE_ID);
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration2 = new TbSendRpcReplyNodeConfiguration();

    // Act and Assert
    assertEquals(tbSendRpcReplyNodeConfiguration, tbSendRpcReplyNodeConfiguration2);
    int expectedHashCodeResult = tbSendRpcReplyNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSendRpcReplyNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#equals(Object)}, and
   * {@link TbSendRpcReplyNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSendRpcReplyNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendRpcReplyNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration = new TbSendRpcReplyNodeConfiguration();

    // Act and Assert
    assertEquals(tbSendRpcReplyNodeConfiguration, tbSendRpcReplyNodeConfiguration);
    int expectedHashCodeResult = tbSendRpcReplyNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSendRpcReplyNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendRpcReplyNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSendRpcReplyNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendRpcReplyNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration = new TbSendRpcReplyNodeConfiguration();
    tbSendRpcReplyNodeConfiguration.setSessionIdMetaDataAttribute(TbSendRpcReplyNodeConfiguration.SERVICE_ID);

    // Act and Assert
    assertNotEquals(tbSendRpcReplyNodeConfiguration, new TbSendRpcReplyNodeConfiguration());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendRpcReplyNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration = new TbSendRpcReplyNodeConfiguration();
    tbSendRpcReplyNodeConfiguration.setRequestIdMetaDataAttribute(TbSendRpcReplyNodeConfiguration.SERVICE_ID);

    // Act and Assert
    assertNotEquals(tbSendRpcReplyNodeConfiguration, new TbSendRpcReplyNodeConfiguration());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendRpcReplyNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbSendRpcReplyNodeConfiguration tbSendRpcReplyNodeConfiguration = new TbSendRpcReplyNodeConfiguration();
    tbSendRpcReplyNodeConfiguration.setServiceIdMetaDataAttribute(TbSendRpcReplyNodeConfiguration.SESSION_ID);

    // Act and Assert
    assertNotEquals(tbSendRpcReplyNodeConfiguration, new TbSendRpcReplyNodeConfiguration());
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendRpcReplyNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSendRpcReplyNodeConfiguration(), null);
  }

  /**
   * Test {@link TbSendRpcReplyNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendRpcReplyNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSendRpcReplyNodeConfiguration(), "Different type to TbSendRpcReplyNodeConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TbSendRpcReplyNodeConfiguration}
   *   <li>
   * {@link TbSendRpcReplyNodeConfiguration#setRequestIdMetaDataAttribute(String)}
   *   <li>
   * {@link TbSendRpcReplyNodeConfiguration#setServiceIdMetaDataAttribute(String)}
   *   <li>
   * {@link TbSendRpcReplyNodeConfiguration#setSessionIdMetaDataAttribute(String)}
   *   <li>{@link TbSendRpcReplyNodeConfiguration#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TbSendRpcReplyNodeConfiguration actualTbSendRpcReplyNodeConfiguration = new TbSendRpcReplyNodeConfiguration();
    actualTbSendRpcReplyNodeConfiguration.setRequestIdMetaDataAttribute("Request Id Meta Data Attribute");
    actualTbSendRpcReplyNodeConfiguration.setServiceIdMetaDataAttribute("Service Id Meta Data Attribute");
    actualTbSendRpcReplyNodeConfiguration.setSessionIdMetaDataAttribute("Session Id Meta Data Attribute");

    // Assert that nothing has changed
    assertEquals("TbSendRpcReplyNodeConfiguration(serviceIdMetaDataAttribute=Service Id Meta Data Attribute,"
        + " sessionIdMetaDataAttribute=Session Id Meta Data Attribute, requestIdMetaDataAttribute=Request Id"
        + " Meta Data Attribute)", actualTbSendRpcReplyNodeConfiguration.toString());
  }
}
