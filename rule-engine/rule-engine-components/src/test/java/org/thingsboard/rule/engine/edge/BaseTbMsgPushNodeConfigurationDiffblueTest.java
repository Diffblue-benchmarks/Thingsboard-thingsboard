package org.thingsboard.rule.engine.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BaseTbMsgPushNodeConfigurationDiffblueTest {
  /**
   * Test {@link BaseTbMsgPushNodeConfiguration#defaultConfiguration()}.
   * <ul>
   *   <li>Given {@link BaseTbMsgPushNodeConfiguration} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTbMsgPushNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration(); given BaseTbMsgPushNodeConfiguration (default constructor)")
  void testDefaultConfiguration_givenBaseTbMsgPushNodeConfiguration() {
    // Arrange, Act and Assert
    assertEquals("SERVER_SCOPE", (new BaseTbMsgPushNodeConfiguration()).defaultConfiguration().getScope());
  }

  /**
   * Test {@link BaseTbMsgPushNodeConfiguration#defaultConfiguration()}.
   * <ul>
   *   <li>Then return {@link TbMsgPushToCloudNodeConfiguration}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTbMsgPushNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration(); then return TbMsgPushToCloudNodeConfiguration")
  void testDefaultConfiguration_thenReturnTbMsgPushToCloudNodeConfiguration() {
    // Arrange and Act
    TbMsgPushToCloudNodeConfiguration actualDefaultConfigurationResult = (new TbMsgPushToCloudNodeConfiguration())
        .defaultConfiguration();

    // Assert
    assertTrue(actualDefaultConfigurationResult instanceof TbMsgPushToCloudNodeConfiguration);
    assertEquals("SERVER_SCOPE", actualDefaultConfigurationResult.getScope());
  }

  /**
   * Test {@link BaseTbMsgPushNodeConfiguration#equals(Object)}, and
   * {@link BaseTbMsgPushNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BaseTbMsgPushNodeConfiguration#equals(Object)}
   *   <li>{@link BaseTbMsgPushNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BaseTbMsgPushNodeConfiguration baseTbMsgPushNodeConfiguration = new BaseTbMsgPushNodeConfiguration();
    BaseTbMsgPushNodeConfiguration baseTbMsgPushNodeConfiguration2 = new BaseTbMsgPushNodeConfiguration();

    // Act and Assert
    assertEquals(baseTbMsgPushNodeConfiguration, baseTbMsgPushNodeConfiguration2);
    int expectedHashCodeResult = baseTbMsgPushNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, baseTbMsgPushNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link BaseTbMsgPushNodeConfiguration#equals(Object)}, and
   * {@link BaseTbMsgPushNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BaseTbMsgPushNodeConfiguration#equals(Object)}
   *   <li>{@link BaseTbMsgPushNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    BaseTbMsgPushNodeConfiguration baseTbMsgPushNodeConfiguration = new BaseTbMsgPushNodeConfiguration();
    baseTbMsgPushNodeConfiguration.setScope("Scope");
    TbMsgPushToCloudNodeConfiguration tbMsgPushToCloudNodeConfiguration = mock(TbMsgPushToCloudNodeConfiguration.class);
    when(tbMsgPushToCloudNodeConfiguration.getScope()).thenReturn("Scope");
    when(tbMsgPushToCloudNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(baseTbMsgPushNodeConfiguration, tbMsgPushToCloudNodeConfiguration);
    int notExpectedHashCodeResult = baseTbMsgPushNodeConfiguration.hashCode();
    assertNotEquals(notExpectedHashCodeResult, tbMsgPushToCloudNodeConfiguration.hashCode());
  }

  /**
   * Test {@link BaseTbMsgPushNodeConfiguration#equals(Object)}, and
   * {@link BaseTbMsgPushNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BaseTbMsgPushNodeConfiguration#equals(Object)}
   *   <li>{@link BaseTbMsgPushNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BaseTbMsgPushNodeConfiguration baseTbMsgPushNodeConfiguration = new BaseTbMsgPushNodeConfiguration();

    // Act and Assert
    assertEquals(baseTbMsgPushNodeConfiguration, baseTbMsgPushNodeConfiguration);
    int expectedHashCodeResult = baseTbMsgPushNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, baseTbMsgPushNodeConfiguration.hashCode());
  }

  /**
   * Test {@link BaseTbMsgPushNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseTbMsgPushNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbMsgPushToCloudNodeConfiguration tbMsgPushToCloudNodeConfiguration = new TbMsgPushToCloudNodeConfiguration();

    // Act and Assert
    assertNotEquals(tbMsgPushToCloudNodeConfiguration, new BaseTbMsgPushNodeConfiguration());
  }

  /**
   * Test {@link BaseTbMsgPushNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseTbMsgPushNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BaseTbMsgPushNodeConfiguration baseTbMsgPushNodeConfiguration = new BaseTbMsgPushNodeConfiguration();

    // Act and Assert
    assertNotEquals(baseTbMsgPushNodeConfiguration, new TbMsgPushToCloudNodeConfiguration());
  }

  /**
   * Test {@link BaseTbMsgPushNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseTbMsgPushNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BaseTbMsgPushNodeConfiguration baseTbMsgPushNodeConfiguration = new BaseTbMsgPushNodeConfiguration();
    TbMsgPushToCloudNodeConfiguration tbMsgPushToCloudNodeConfiguration = mock(TbMsgPushToCloudNodeConfiguration.class);
    when(tbMsgPushToCloudNodeConfiguration.getScope()).thenReturn("Scope");
    when(tbMsgPushToCloudNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(baseTbMsgPushNodeConfiguration, tbMsgPushToCloudNodeConfiguration);
  }

  /**
   * Test {@link BaseTbMsgPushNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseTbMsgPushNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    BaseTbMsgPushNodeConfiguration baseTbMsgPushNodeConfiguration = new BaseTbMsgPushNodeConfiguration();
    baseTbMsgPushNodeConfiguration.setScope("org.thingsboard.rule.engine.edge.BaseTbMsgPushNodeConfiguration");
    TbMsgPushToCloudNodeConfiguration tbMsgPushToCloudNodeConfiguration = mock(TbMsgPushToCloudNodeConfiguration.class);
    when(tbMsgPushToCloudNodeConfiguration.getScope()).thenReturn("Scope");
    when(tbMsgPushToCloudNodeConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(baseTbMsgPushNodeConfiguration, tbMsgPushToCloudNodeConfiguration);
  }

  /**
   * Test {@link BaseTbMsgPushNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseTbMsgPushNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseTbMsgPushNodeConfiguration(), null);
  }

  /**
   * Test {@link BaseTbMsgPushNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseTbMsgPushNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseTbMsgPushNodeConfiguration(), "Different type to BaseTbMsgPushNodeConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link BaseTbMsgPushNodeConfiguration}
   *   <li>{@link BaseTbMsgPushNodeConfiguration#setScope(String)}
   *   <li>{@link BaseTbMsgPushNodeConfiguration#toString()}
   *   <li>{@link BaseTbMsgPushNodeConfiguration#getScope()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    BaseTbMsgPushNodeConfiguration actualBaseTbMsgPushNodeConfiguration = new BaseTbMsgPushNodeConfiguration();
    actualBaseTbMsgPushNodeConfiguration.setScope("Scope");
    String actualToStringResult = actualBaseTbMsgPushNodeConfiguration.toString();

    // Assert that nothing has changed
    assertEquals("BaseTbMsgPushNodeConfiguration(scope=Scope)", actualToStringResult);
    assertEquals("Scope", actualBaseTbMsgPushNodeConfiguration.getScope());
  }
}
