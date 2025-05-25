package org.thingsboard.server.common.data.mobile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.mobile.IosConfig.IosConfigBuilder;

@ContextConfiguration(classes = {IosConfigBuilder.class})
@ExtendWith(SpringExtension.class)
class IosConfigDiffblueTest {
  @Autowired
  private IosConfigBuilder iosConfigBuilder;

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean IosConfig.equals(Object)", "int IosConfig.hashCode()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean IosConfig.equals(Object)", "int IosConfig.hashCode()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean IosConfig.equals(Object)", "int IosConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    IosConfigBuilder iosConfigBuilder = mock(IosConfigBuilder.class);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean IosConfig.equals(Object)", "int IosConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    IosConfigBuilder iosConfigBuilder = mock(IosConfigBuilder.class);
    when(iosConfigBuilder.enabled(anyBoolean())).thenReturn(IosConfig.builder());
    IosConfigBuilder iosConfigBuilder2 = mock(IosConfigBuilder.class);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean IosConfig.equals(Object)", "int IosConfig.hashCode()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean IosConfig.equals(Object)", "int IosConfig.hashCode()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IosConfig.<init>()", "void IosConfig.<init>(boolean, String, String)",
      "String IosConfig.getAppId()", "String IosConfig.getStoreLink()", "boolean IosConfig.isEnabled()",
      "void IosConfig.setAppId(String)", "void IosConfig.setEnabled(boolean)", "void IosConfig.setStoreLink(String)",
      "String IosConfig.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    IosConfig actualIosConfig = new IosConfig();
    actualIosConfig.setAppId("42");
    actualIosConfig.setEnabled(true);
    actualIosConfig.setStoreLink("Store Link");
    String actualToStringResult = actualIosConfig.toString();
    String actualAppId = actualIosConfig.getAppId();
    String actualStoreLink = actualIosConfig.getStoreLink();

    // Assert
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IosConfig.<init>()", "void IosConfig.<init>(boolean, String, String)",
      "String IosConfig.getAppId()", "String IosConfig.getStoreLink()", "boolean IosConfig.isEnabled()",
      "void IosConfig.setAppId(String)", "void IosConfig.setEnabled(boolean)", "void IosConfig.setStoreLink(String)",
      "String IosConfig.toString()"})
  void testGettersAndSetters_whenTrue() {
    // Arrange and Act
    IosConfig actualIosConfig = new IosConfig(true, "42", "Store Link");
    actualIosConfig.setAppId("42");
    actualIosConfig.setEnabled(true);
    actualIosConfig.setStoreLink("Store Link");
    String actualToStringResult = actualIosConfig.toString();
    String actualAppId = actualIosConfig.getAppId();
    String actualStoreLink = actualIosConfig.getStoreLink();

    // Assert
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
   *   <li>{@link IosConfigBuilder#build()}
   *   <li>{@link IosConfigBuilder#appId(String)}
   *   <li>{@link IosConfigBuilder#enabled(boolean)}
   *   <li>{@link IosConfigBuilder#storeLink(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test IosConfigBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IosConfigBuilder.<init>()", "IosConfigBuilder IosConfigBuilder.appId(String)",
      "IosConfig IosConfigBuilder.build()", "IosConfigBuilder IosConfigBuilder.enabled(boolean)",
      "IosConfigBuilder IosConfigBuilder.storeLink(String)", "String IosConfigBuilder.toString()"})
  void testIosConfigBuilderBuild() {
    // Arrange and Act
    IosConfig actualBuildResult = IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build();

    // Assert
    assertEquals("42", actualBuildResult.getAppId());
    assertEquals("Store Link", actualBuildResult.getStoreLink());
    assertTrue(actualBuildResult.isEnabled());
  }
}
