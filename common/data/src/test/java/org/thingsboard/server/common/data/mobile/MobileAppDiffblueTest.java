package org.thingsboard.server.common.data.mobile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.TenantId;

class MobileAppDiffblueTest {
  /**
   * Test {@link MobileApp#MobileApp(MobileApp)}.
   *
   * <p>Method under test: {@link MobileApp#MobileApp(MobileApp)}
   */
  @Test
  @DisplayName("Test new MobileApp(MobileApp)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MobileApp.<init>(MobileApp)"})
  void testNewMobileApp() {
    // Arrange
    MobileApp mobile = new MobileApp();

    // Act
    MobileApp actualMobileApp = new MobileApp(mobile);

    // Assert
    assertEquals(mobile, actualMobileApp);
  }

  /**
   * Test {@link MobileApp#equals(Object)}, and {@link MobileApp#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileApp#equals(Object)}
   *   <li>{@link MobileApp#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileApp.equals(Object)", "int MobileApp.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    MobileApp mobileApp2 = new MobileApp();

    // Act and Assert
    assertEquals(mobileApp, mobileApp2);
    assertEquals(mobileApp.hashCode(), mobileApp2.hashCode());
  }

  /**
   * Test {@link MobileApp#equals(Object)}, and {@link MobileApp#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileApp#equals(Object)}
   *   <li>{@link MobileApp#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileApp.equals(Object)", "int MobileApp.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileApp.equals(Object)", "int MobileApp.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MobileAppInfo mobileAppInfo = new MobileAppInfo();

    // Act and Assert
    assertNotEquals(mobileAppInfo, new MobileApp());
  }

  /**
   * Test {@link MobileApp#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileApp.equals(Object)", "int MobileApp.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MobileApp mobileApp = new MobileApp();

    // Act and Assert
    assertNotEquals(mobileApp, new MobileAppInfo());
  }

  /**
   * Test {@link MobileApp#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileApp.equals(Object)", "int MobileApp.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileApp.equals(Object)", "int MobileApp.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MobileAppInfo mobileAppInfo = new MobileAppInfo();

    MobileAppInfo mobileAppInfo2 = mock(MobileAppInfo.class);
    when(mobileAppInfo2.isOauth2Enabled()).thenReturn(true);
    when(mobileAppInfo2.getAppSecret()).thenReturn("App Secret");
    when(mobileAppInfo2.getPkgName()).thenReturn("Pkg Name");
    when(mobileAppInfo2.getOauth2ClientInfos()).thenReturn(new ArrayList<>());
    when(mobileAppInfo2.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(mobileAppInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(mobileAppInfo, mobileAppInfo2);
  }

  /**
   * Test {@link MobileApp#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileApp.equals(Object)", "int MobileApp.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MobileAppInfo mobileAppInfo = new MobileAppInfo();
    mobileAppInfo.setOauth2Enabled(true);

    MobileAppInfo mobileAppInfo2 = mock(MobileAppInfo.class);
    when(mobileAppInfo2.isOauth2Enabled()).thenReturn(true);
    when(mobileAppInfo2.getAppSecret()).thenReturn("App Secret");
    when(mobileAppInfo2.getPkgName()).thenReturn("Pkg Name");
    when(mobileAppInfo2.getOauth2ClientInfos()).thenReturn(new ArrayList<>());
    when(mobileAppInfo2.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(mobileAppInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(mobileAppInfo, mobileAppInfo2);
  }

  /**
   * Test {@link MobileApp#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileApp.equals(Object)", "int MobileApp.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    MobileAppInfo mobileAppInfo = new MobileAppInfo();
    mobileAppInfo.setOauth2Enabled(true);

    MobileAppInfo mobileAppInfo2 = mock(MobileAppInfo.class);
    when(mobileAppInfo2.isOauth2Enabled()).thenReturn(true);
    when(mobileAppInfo2.getAppSecret()).thenReturn("App Secret");
    when(mobileAppInfo2.getPkgName()).thenReturn("Pkg Name");
    when(mobileAppInfo2.getOauth2ClientInfos()).thenReturn(new ArrayList<>());
    when(mobileAppInfo2.getTenantId()).thenReturn(null);
    when(mobileAppInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(mobileAppInfo, mobileAppInfo2);
  }

  /**
   * Test {@link MobileApp#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileApp.equals(Object)", "int MobileApp.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    MobileAppInfo mobileAppInfo = new MobileAppInfo();
    mobileAppInfo.setTenantId(TenantId.SYS_TENANT_ID);
    mobileAppInfo.setOauth2Enabled(true);

    MobileAppInfo mobileAppInfo2 = mock(MobileAppInfo.class);
    when(mobileAppInfo2.isOauth2Enabled()).thenReturn(true);
    when(mobileAppInfo2.getAppSecret()).thenReturn("App Secret");
    when(mobileAppInfo2.getPkgName()).thenReturn("Pkg Name");
    when(mobileAppInfo2.getOauth2ClientInfos()).thenReturn(new ArrayList<>());
    when(mobileAppInfo2.getTenantId()).thenReturn(null);
    when(mobileAppInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(mobileAppInfo, mobileAppInfo2);
  }

  /**
   * Test {@link MobileApp#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileApp.equals(Object)", "int MobileApp.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    MobileAppInfo mobileAppInfo = new MobileAppInfo();
    mobileAppInfo.setPkgName("Pkg Name");
    mobileAppInfo.setOauth2Enabled(true);

    MobileAppInfo mobileAppInfo2 = mock(MobileAppInfo.class);
    when(mobileAppInfo2.isOauth2Enabled()).thenReturn(true);
    when(mobileAppInfo2.getAppSecret()).thenReturn("App Secret");
    when(mobileAppInfo2.getPkgName()).thenReturn("Pkg Name");
    when(mobileAppInfo2.getOauth2ClientInfos()).thenReturn(new ArrayList<>());
    when(mobileAppInfo2.getTenantId()).thenReturn(null);
    when(mobileAppInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(mobileAppInfo, mobileAppInfo2);
  }

  /**
   * Test {@link MobileApp#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileApp.equals(Object)", "int MobileApp.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    MobileAppInfo mobileAppInfo = new MobileAppInfo();
    mobileAppInfo.setPkgName("org.thingsboard.server.common.data.mobile.MobileApp");
    mobileAppInfo.setOauth2Enabled(true);

    MobileAppInfo mobileAppInfo2 = mock(MobileAppInfo.class);
    when(mobileAppInfo2.isOauth2Enabled()).thenReturn(true);
    when(mobileAppInfo2.getAppSecret()).thenReturn("App Secret");
    when(mobileAppInfo2.getPkgName()).thenReturn("Pkg Name");
    when(mobileAppInfo2.getOauth2ClientInfos()).thenReturn(new ArrayList<>());
    when(mobileAppInfo2.getTenantId()).thenReturn(null);
    when(mobileAppInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(mobileAppInfo, mobileAppInfo2);
  }

  /**
   * Test {@link MobileApp#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileApp.equals(Object)", "int MobileApp.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    MobileAppInfo mobileAppInfo = new MobileAppInfo();
    mobileAppInfo.setTenantId(TenantId.SYS_TENANT_ID);
    mobileAppInfo.setOauth2Enabled(true);

    MobileAppInfo mobileAppInfo2 = mock(MobileAppInfo.class);
    when(mobileAppInfo2.isOauth2Enabled()).thenReturn(true);
    when(mobileAppInfo2.getAppSecret()).thenReturn("App Secret");
    when(mobileAppInfo2.getPkgName()).thenReturn("Pkg Name");
    when(mobileAppInfo2.getOauth2ClientInfos()).thenReturn(new ArrayList<>());
    when(mobileAppInfo2.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(mobileAppInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(mobileAppInfo, mobileAppInfo2);
  }

  /**
   * Test {@link MobileApp#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileApp.equals(Object)", "int MobileApp.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    MobileAppInfo mobileAppInfo = new MobileAppInfo();
    mobileAppInfo.setAppSecret("Pkg Name");
    mobileAppInfo.setPkgName("Pkg Name");
    mobileAppInfo.setOauth2Enabled(true);

    MobileAppInfo mobileAppInfo2 = mock(MobileAppInfo.class);
    when(mobileAppInfo2.isOauth2Enabled()).thenReturn(true);
    when(mobileAppInfo2.getAppSecret()).thenReturn("App Secret");
    when(mobileAppInfo2.getPkgName()).thenReturn("Pkg Name");
    when(mobileAppInfo2.getOauth2ClientInfos()).thenReturn(new ArrayList<>());
    when(mobileAppInfo2.getTenantId()).thenReturn(null);
    when(mobileAppInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(mobileAppInfo, mobileAppInfo2);
  }

  /**
   * Test {@link MobileApp#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileApp.equals(Object)", "int MobileApp.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    MobileAppInfo mobileAppInfo = new MobileAppInfo();
    mobileAppInfo.setAppSecret("App Secret");
    mobileAppInfo.setPkgName("Pkg Name");
    mobileAppInfo.setOauth2Enabled(true);

    MobileAppInfo mobileAppInfo2 = mock(MobileAppInfo.class);
    when(mobileAppInfo2.isOauth2Enabled()).thenReturn(true);
    when(mobileAppInfo2.getAppSecret()).thenReturn("App Secret");
    when(mobileAppInfo2.getPkgName()).thenReturn("Pkg Name");
    when(mobileAppInfo2.getOauth2ClientInfos()).thenReturn(new ArrayList<>());
    when(mobileAppInfo2.getTenantId()).thenReturn(null);
    when(mobileAppInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(mobileAppInfo, mobileAppInfo2);
  }

  /**
   * Test {@link MobileApp#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileApp.equals(Object)", "int MobileApp.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileApp(), null);
  }

  /**
   * Test {@link MobileApp#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileApp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MobileApp.equals(Object)", "int MobileApp.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileApp(), "Different type to MobileApp");
  }
}
