package org.thingsboard.server.common.data.domain;

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

class DomainInfoDiffblueTest {
  /**
   * Test {@link DomainInfo#DomainInfo(Domain, List)}.
   * <ul>
   *   <li>Given {@link OAuth2ClientInfo#OAuth2ClientInfo()}.</li>
   *   <li>Then return Oauth2ClientInfos is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainInfo#DomainInfo(Domain, List)}
   */
  @Test
  @DisplayName("Test new DomainInfo(Domain, List); given OAuth2ClientInfo(); then return Oauth2ClientInfos is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DomainInfo.<init>(Domain, List)"})
  void testNewDomainInfo_givenOAuth2ClientInfo_thenReturnOauth2ClientInfosIsArrayList() {
    // Arrange
    Domain domain = new Domain();

    ArrayList<OAuth2ClientInfo> oauth2ClientInfos = new ArrayList<>();
    oauth2ClientInfos.add(new OAuth2ClientInfo());

    // Act and Assert
    assertSame(oauth2ClientInfos, (new DomainInfo(domain, oauth2ClientInfos)).getOauth2ClientInfos());
  }

  /**
   * Test {@link DomainInfo#DomainInfo(Domain, List)}.
   * <ul>
   *   <li>Given {@link OAuth2ClientInfo#OAuth2ClientInfo()}.</li>
   *   <li>Then return Oauth2ClientInfos size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainInfo#DomainInfo(Domain, List)}
   */
  @Test
  @DisplayName("Test new DomainInfo(Domain, List); given OAuth2ClientInfo(); then return Oauth2ClientInfos size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DomainInfo.<init>(Domain, List)"})
  void testNewDomainInfo_givenOAuth2ClientInfo_thenReturnOauth2ClientInfosSizeIsTwo() {
    // Arrange
    Domain domain = new Domain();

    ArrayList<OAuth2ClientInfo> oauth2ClientInfos = new ArrayList<>();
    oauth2ClientInfos.add(new OAuth2ClientInfo());
    OAuth2ClientInfo oAuth2ClientInfo = new OAuth2ClientInfo();
    oauth2ClientInfos.add(oAuth2ClientInfo);

    // Act and Assert
    List<OAuth2ClientInfo> oauth2ClientInfos2 = (new DomainInfo(domain, oauth2ClientInfos)).getOauth2ClientInfos();
    assertEquals(2, oauth2ClientInfos2.size());
    assertSame(oAuth2ClientInfo, oauth2ClientInfos2.get(1));
  }

  /**
   * Test {@link DomainInfo#DomainInfo(Domain, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainInfo#DomainInfo(Domain, List)}
   */
  @Test
  @DisplayName("Test new DomainInfo(Domain, List); when ArrayList(); then return Name is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DomainInfo.<init>(Domain, List)"})
  void testNewDomainInfo_whenArrayList_thenReturnNameIsNull() {
    // Arrange
    Domain domain = new Domain();

    // Act
    DomainInfo actualDomainInfo = new DomainInfo(domain, new ArrayList<>());

    // Assert
    assertNull(actualDomainInfo.getName());
    assertNull(actualDomainInfo.getUuidId());
    assertNull(actualDomainInfo.getId());
    assertNull(actualDomainInfo.getTenantId());
    assertEquals(0L, actualDomainInfo.getCreatedTime());
    assertFalse(actualDomainInfo.isOauth2Enabled());
    assertFalse(actualDomainInfo.isPropagateToEdge());
    assertTrue(actualDomainInfo.getOauth2ClientInfos().isEmpty());
  }

  /**
   * Test {@link DomainInfo#equals(Object)}, and {@link DomainInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DomainInfo#equals(Object)}
   *   <li>{@link DomainInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DomainInfo.equals(Object)", "int DomainInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DomainInfo domainInfo = new DomainInfo();
    DomainInfo domainInfo2 = new DomainInfo();

    // Act and Assert
    assertEquals(domainInfo, domainInfo2);
    int expectedHashCodeResult = domainInfo.hashCode();
    assertEquals(expectedHashCodeResult, domainInfo2.hashCode());
  }

  /**
   * Test {@link DomainInfo#equals(Object)}, and {@link DomainInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DomainInfo#equals(Object)}
   *   <li>{@link DomainInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DomainInfo.equals(Object)", "int DomainInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Domain domain = new Domain();
    DomainInfo domainInfo = new DomainInfo(domain, new ArrayList<>());
    Domain domain2 = new Domain();
    DomainInfo domainInfo2 = new DomainInfo(domain2, new ArrayList<>());

    // Act and Assert
    assertEquals(domainInfo, domainInfo2);
    int expectedHashCodeResult = domainInfo.hashCode();
    assertEquals(expectedHashCodeResult, domainInfo2.hashCode());
  }

  /**
   * Test {@link DomainInfo#equals(Object)}, and {@link DomainInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DomainInfo#equals(Object)}
   *   <li>{@link DomainInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DomainInfo.equals(Object)", "int DomainInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DomainInfo domainInfo = new DomainInfo();

    // Act and Assert
    assertEquals(domainInfo, domainInfo);
    int expectedHashCodeResult = domainInfo.hashCode();
    assertEquals(expectedHashCodeResult, domainInfo.hashCode());
  }

  /**
   * Test {@link DomainInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DomainInfo.equals(Object)", "int DomainInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Domain domain = new Domain();
    DomainInfo domainInfo = new DomainInfo(domain, new ArrayList<>());

    // Act and Assert
    assertNotEquals(domainInfo, new DomainInfo());
  }

  /**
   * Test {@link DomainInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DomainInfo.equals(Object)", "int DomainInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DomainInfo domainInfo = new DomainInfo();
    Domain domain = new Domain();

    // Act and Assert
    assertNotEquals(domainInfo, new DomainInfo(domain, new ArrayList<>()));
  }

  /**
   * Test {@link DomainInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DomainInfo.equals(Object)", "int DomainInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DomainInfo domainInfo = new DomainInfo();
    domainInfo.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(domainInfo, new DomainInfo());
  }

  /**
   * Test {@link DomainInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DomainInfo.equals(Object)", "int DomainInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DomainInfo(), null);
  }

  /**
   * Test {@link DomainInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DomainInfo.equals(Object)", "int DomainInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DomainInfo(), "Different type to DomainInfo");
  }
}
