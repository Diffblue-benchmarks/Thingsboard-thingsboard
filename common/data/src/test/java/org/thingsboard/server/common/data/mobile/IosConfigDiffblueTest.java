package org.thingsboard.server.common.data.mobile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.mobile.IosConfig.IosConfigBuilder;

class IosConfigDiffblueTest {
  /**
   * Test {@link IosConfig#equals(Object)}, and {@link IosConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IosConfig#equals(Object)}
   *   <li>{@link IosConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    IosConfig buildResult = IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build();
    IosConfig buildResult2 = IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link IosConfig#equals(Object)}, and {@link IosConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IosConfig#equals(Object)}
   *   <li>{@link IosConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    IosConfig buildResult = IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link IosConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IosConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    IosConfig.IosConfigBuilder iosConfigBuilder = mock(IosConfig.IosConfigBuilder.class);
    when(iosConfigBuilder.appId(Mockito.<String>any())).thenReturn(IosConfig.builder());
    IosConfig buildResult = iosConfigBuilder.appId("42").enabled(true).storeLink("Store Link").build();
    IosConfig buildResult2 = IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link IosConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IosConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    IosConfig.IosConfigBuilder iosConfigBuilder = mock(IosConfig.IosConfigBuilder.class);
    when(iosConfigBuilder.enabled(anyBoolean())).thenReturn(IosConfig.builder());
    IosConfig.IosConfigBuilder iosConfigBuilder2 = mock(IosConfig.IosConfigBuilder.class);
    when(iosConfigBuilder2.appId(Mockito.<String>any())).thenReturn(iosConfigBuilder);
    IosConfig buildResult = iosConfigBuilder2.appId("42").enabled(true).storeLink("Store Link").build();
    IosConfig buildResult2 = IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link IosConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IosConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    IosConfig buildResult = IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link IosConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IosConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    IosConfig buildResult = IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to IosConfig");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IosConfig#IosConfig()}
   *   <li>{@link IosConfig#setAppId(String)}
   *   <li>{@link IosConfig#setEnabled(boolean)}
   *   <li>{@link IosConfig#setStoreLink(String)}
   *   <li>{@link IosConfig#toString()}
   *   <li>{@link IosConfig#getAppId()}
   *   <li>{@link IosConfig#getStoreLink()}
   *   <li>{@link IosConfig#isEnabled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    IosConfig actualIosConfig = new IosConfig();
    actualIosConfig.setAppId("42");
    actualIosConfig.setEnabled(true);
    actualIosConfig.setStoreLink("Store Link");
    String actualToStringResult = actualIosConfig.toString();
    String actualAppId = actualIosConfig.getAppId();
    String actualStoreLink = actualIosConfig.getStoreLink();

    // Assert that nothing has changed
    assertEquals("42", actualAppId);
    assertEquals("IosConfig(enabled=true, appId=42, storeLink=Store Link)", actualToStringResult);
    assertEquals("Store Link", actualStoreLink);
    assertTrue(actualIosConfig.isEnabled());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IosConfig#IosConfig(boolean, String, String)}
   *   <li>{@link IosConfig#setAppId(String)}
   *   <li>{@link IosConfig#setEnabled(boolean)}
   *   <li>{@link IosConfig#setStoreLink(String)}
   *   <li>{@link IosConfig#toString()}
   *   <li>{@link IosConfig#getAppId()}
   *   <li>{@link IosConfig#getStoreLink()}
   *   <li>{@link IosConfig#isEnabled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'true'")
  void testGettersAndSetters_whenTrue() {
    // Arrange and Act
    IosConfig actualIosConfig = new IosConfig(true, "42", "Store Link");
    actualIosConfig.setAppId("42");
    actualIosConfig.setEnabled(true);
    actualIosConfig.setStoreLink("Store Link");
    String actualToStringResult = actualIosConfig.toString();
    String actualAppId = actualIosConfig.getAppId();
    String actualStoreLink = actualIosConfig.getStoreLink();

    // Assert that nothing has changed
    assertEquals("42", actualAppId);
    assertEquals("IosConfig(enabled=true, appId=42, storeLink=Store Link)", actualToStringResult);
    assertEquals("Store Link", actualStoreLink);
    assertTrue(actualIosConfig.isEnabled());
  }

  /**
   * Test IosConfigBuilder {@link IosConfigBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IosConfig.IosConfigBuilder#build()}
   *   <li>{@link IosConfig.IosConfigBuilder#appId(String)}
   *   <li>{@link IosConfig.IosConfigBuilder#enabled(boolean)}
   *   <li>{@link IosConfig.IosConfigBuilder#storeLink(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test IosConfigBuilder build()")
  void testIosConfigBuilderBuild() {
    // Arrange and Act
    IosConfig actualBuildResult = IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build();

    // Assert
    assertEquals("42", actualBuildResult.getAppId());
    assertEquals("Store Link", actualBuildResult.getStoreLink());
    assertTrue(actualBuildResult.isEnabled());
  }
}
