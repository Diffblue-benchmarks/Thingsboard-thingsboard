package org.thingsboard.server.common.data.mobile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.oauth2.OAuth2ClientInfo;

class MobileAppInfoDiffblueTest {
  /**
   * Test {@link MobileAppInfo#MobileAppInfo(MobileApp, List)}.
   *
   * <ul>
   *   <li>Given {@link OAuth2ClientInfo#OAuth2ClientInfo()}.
   *   <li>Then return Oauth2ClientInfos size is two.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppInfo#MobileAppInfo(MobileApp, List)}
   */
  @Test
  @DisplayName(
      "Test new MobileAppInfo(MobileApp, List); given OAuth2ClientInfo(); then return Oauth2ClientInfos size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MobileAppInfo.<init>(MobileApp, List)"})
  void testNewMobileAppInfo_givenOAuth2ClientInfo_thenReturnOauth2ClientInfosSizeIsTwo() {
    // Arrange
    MobileApp mobileApp = new MobileApp();

    ArrayList<OAuth2ClientInfo> oauth2ClientInfos = new ArrayList<>();
    oauth2ClientInfos.add(new OAuth2ClientInfo());
    OAuth2ClientInfo oAuth2ClientInfo = new OAuth2ClientInfo();
    oauth2ClientInfos.add(oAuth2ClientInfo);

    // Act and Assert
    List<OAuth2ClientInfo> oauth2ClientInfos2 =
        new MobileAppInfo(mobileApp, oauth2ClientInfos).getOauth2ClientInfos();
    assertEquals(2, oauth2ClientInfos2.size());
    assertSame(oAuth2ClientInfo, oauth2ClientInfos2.get(1));
  }

  /**
   * Test {@link MobileAppInfo#MobileAppInfo(MobileApp, List)}.
   *
   * <ul>
   *   <li>Then return Oauth2ClientInfos is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppInfo#MobileAppInfo(MobileApp, List)}
   */
  @Test
  @DisplayName(
      "Test new MobileAppInfo(MobileApp, List); then return Oauth2ClientInfos is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MobileAppInfo.<init>(MobileApp, List)"})
  void testNewMobileAppInfo_thenReturnOauth2ClientInfosIsArrayList() {
    // Arrange
    MobileApp mobileApp = new MobileApp();

    ArrayList<OAuth2ClientInfo> oauth2ClientInfos = new ArrayList<>();
    oauth2ClientInfos.add(new OAuth2ClientInfo());

    // Act and Assert
    assertSame(
        oauth2ClientInfos, new MobileAppInfo(mobileApp, oauth2ClientInfos).getOauth2ClientInfos());
  }

  /**
   * Test {@link MobileAppInfo#MobileAppInfo(MobileApp, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return AppSecret is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppInfo#MobileAppInfo(MobileApp, List)}
   */
  @Test
  @DisplayName(
      "Test new MobileAppInfo(MobileApp, List); when ArrayList(); then return AppSecret is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MobileAppInfo.<init>(MobileApp, List)"})
  void testNewMobileAppInfo_whenArrayList_thenReturnAppSecretIsNull() {
    // Arrange
    MobileApp mobileApp = new MobileApp();

    // Act
    MobileAppInfo actualMobileAppInfo = new MobileAppInfo(mobileApp, new ArrayList<>());

    // Assert
    assertNull(actualMobileAppInfo.getAppSecret());
    assertNull(actualMobileAppInfo.getName());
    assertNull(actualMobileAppInfo.getPkgName());
    assertNull(actualMobileAppInfo.getUuidId());
    assertNull(actualMobileAppInfo.getId());
    assertNull(actualMobileAppInfo.getTenantId());
    assertEquals(0L, actualMobileAppInfo.getCreatedTime());
    assertFalse(actualMobileAppInfo.isOauth2Enabled());
    assertTrue(actualMobileAppInfo.getOauth2ClientInfos().isEmpty());
  }

  /**
   * Test {@link MobileAppInfo#equals(Object)}, and {@link MobileAppInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppInfo#equals(Object)}
   *   <li>{@link MobileAppInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppInfo.equals(Object)", "int MobileAppInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MobileAppInfo mobileAppInfo = new MobileAppInfo();
    MobileAppInfo mobileAppInfo2 = new MobileAppInfo();

    // Act and Assert
    assertEquals(mobileAppInfo, mobileAppInfo2);
    int expectedHashCodeResult = mobileAppInfo.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppInfo2.hashCode());
  }

  /**
   * Test {@link MobileAppInfo#equals(Object)}, and {@link MobileAppInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppInfo#equals(Object)}
   *   <li>{@link MobileAppInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppInfo.equals(Object)", "int MobileAppInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    MobileAppInfo mobileAppInfo = new MobileAppInfo(mobileApp, new ArrayList<>());
    MobileApp mobileApp2 = new MobileApp();
    MobileAppInfo mobileAppInfo2 = new MobileAppInfo(mobileApp2, new ArrayList<>());

    // Act and Assert
    assertEquals(mobileAppInfo, mobileAppInfo2);
    int expectedHashCodeResult = mobileAppInfo.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppInfo2.hashCode());
  }

  /**
   * Test {@link MobileAppInfo#equals(Object)}, and {@link MobileAppInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppInfo#equals(Object)}
   *   <li>{@link MobileAppInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppInfo.equals(Object)", "int MobileAppInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MobileAppInfo mobileAppInfo = new MobileAppInfo();

    // Act and Assert
    assertEquals(mobileAppInfo, mobileAppInfo);
    int expectedHashCodeResult = mobileAppInfo.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppInfo.hashCode());
  }

  /**
   * Test {@link MobileAppInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppInfo.equals(Object)", "int MobileAppInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MobileApp mobileApp = new MobileApp();
    MobileAppInfo mobileAppInfo = new MobileAppInfo(mobileApp, new ArrayList<>());

    // Act and Assert
    assertNotEquals(mobileAppInfo, new MobileAppInfo());
  }

  /**
   * Test {@link MobileAppInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppInfo.equals(Object)", "int MobileAppInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MobileAppInfo mobileAppInfo = new MobileAppInfo();
    MobileApp mobileApp = new MobileApp();

    // Act and Assert
    assertNotEquals(mobileAppInfo, new MobileAppInfo(mobileApp, new ArrayList<>()));
  }

  /**
   * Test {@link MobileAppInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppInfo.equals(Object)", "int MobileAppInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MobileAppInfo mobileAppInfo = new MobileAppInfo();
    mobileAppInfo.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(mobileAppInfo, new MobileAppInfo());
  }

  /**
   * Test {@link MobileAppInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppInfo.equals(Object)", "int MobileAppInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppInfo(), null);
  }

  /**
   * Test {@link MobileAppInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppInfo.equals(Object)", "int MobileAppInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppInfo(), "Different type to MobileAppInfo");
  }
}
