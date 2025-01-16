package org.thingsboard.server.common.data.mobile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.TenantId;

class MobileAppDiffblueTest {
  /**
   * Test {@link MobileApp#MobileApp(MobileApp)}.
   * <p>
   * Method under test: {@link MobileApp#MobileApp(MobileApp)}
   */
  @Test
  @DisplayName("Test new MobileApp(MobileApp)")
  void testNewMobileApp() {
    // Arrange
    MobileApp mobile = new MobileApp();

    // Act and Assert
    assertEquals(mobile, new MobileApp(mobile));
  }

  /**
   * Test {@link MobileApp#equals(Object)}, and {@link MobileApp#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileApp#equals(Object)}
   *   <li>{@link MobileApp#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    MobileApp mobileApp2 = new MobileApp();

    // Act and Assert
    assertEquals(mobileApp, mobileApp2);
    int expectedHashCodeResult = mobileApp.hashCode();
    assertEquals(expectedHashCodeResult, mobileApp2.hashCode());
  }

  /**
   * Test {@link MobileApp#equals(Object)}, and {@link MobileApp#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileApp#equals(Object)}
   *   <li>{@link MobileApp#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    mobileApp.setTenantId(TenantId.SYS_TENANT_ID);

    MobileApp mobileApp2 = new MobileApp();
    mobileApp2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(mobileApp, mobileApp2);
    int expectedHashCodeResult = mobileApp.hashCode();
    assertEquals(expectedHashCodeResult, mobileApp2.hashCode());
  }

  /**
   * Test {@link MobileApp#equals(Object)}, and {@link MobileApp#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileApp#equals(Object)}
   *   <li>{@link MobileApp#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    mobileApp.setPkgName("Pkg Name");

    MobileApp mobileApp2 = new MobileApp();
    mobileApp2.setPkgName("Pkg Name");

    // Act and Assert
    assertEquals(mobileApp, mobileApp2);
    int expectedHashCodeResult = mobileApp.hashCode();
    assertEquals(expectedHashCodeResult, mobileApp2.hashCode());
  }

  /**
   * Test {@link MobileApp#equals(Object)}, and {@link MobileApp#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileApp#equals(Object)}
   *   <li>{@link MobileApp#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    mobileApp.setAppSecret("App Secret");

    MobileApp mobileApp2 = new MobileApp();
    mobileApp2.setAppSecret("App Secret");

    // Act and Assert
    assertEquals(mobileApp, mobileApp2);
    int expectedHashCodeResult = mobileApp.hashCode();
    assertEquals(expectedHashCodeResult, mobileApp2.hashCode());
  }

  /**
   * Test {@link MobileApp#equals(Object)}, and {@link MobileApp#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileApp#equals(Object)}
   *   <li>{@link MobileApp#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MobileApp mobileApp = new MobileApp();

    // Act and Assert
    assertEquals(mobileApp, mobileApp);
    int expectedHashCodeResult = mobileApp.hashCode();
    assertEquals(expectedHashCodeResult, mobileApp.hashCode());
  }

  /**
   * Test {@link MobileApp#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MobileAppInfo mobileAppInfo = new MobileAppInfo();

    // Act and Assert
    assertNotEquals(mobileAppInfo, new MobileApp());
  }

  /**
   * Test {@link MobileApp#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MobileApp mobileApp = new MobileApp();

    // Act and Assert
    assertNotEquals(mobileApp, new MobileAppInfo());
  }

  /**
   * Test {@link MobileApp#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    MobileAppInfo mobileAppInfo = mock(MobileAppInfo.class);
    when(mobileAppInfo.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(mobileApp, mobileAppInfo);
  }

  /**
   * Test {@link MobileApp#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    mobileApp.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(mobileApp, new MobileApp());
  }

  /**
   * Test {@link MobileApp#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    mobileApp.setPkgName("Pkg Name");

    // Act and Assert
    assertNotEquals(mobileApp, new MobileApp());
  }

  /**
   * Test {@link MobileApp#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    mobileApp.setAppSecret("App Secret");

    // Act and Assert
    assertNotEquals(mobileApp, new MobileApp());
  }

  /**
   * Test {@link MobileApp#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    mobileApp.setOauth2Enabled(true);

    // Act and Assert
    assertNotEquals(mobileApp, new MobileApp());
  }

  /**
   * Test {@link MobileApp#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    MobileApp mobileApp = new MobileApp();

    MobileApp mobileApp2 = new MobileApp();
    mobileApp2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(mobileApp, mobileApp2);
  }

  /**
   * Test {@link MobileApp#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    MobileApp mobileApp = new MobileApp();

    MobileApp mobileApp2 = new MobileApp();
    mobileApp2.setPkgName("Pkg Name");

    // Act and Assert
    assertNotEquals(mobileApp, mobileApp2);
  }

  /**
   * Test {@link MobileApp#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    MobileApp mobileApp = new MobileApp();

    MobileApp mobileApp2 = new MobileApp();
    mobileApp2.setAppSecret("App Secret");

    // Act and Assert
    assertNotEquals(mobileApp, mobileApp2);
  }

  /**
   * Test {@link MobileApp#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileApp(), null);
  }

  /**
   * Test {@link MobileApp#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileApp(), "Different type to MobileApp");
  }
}
