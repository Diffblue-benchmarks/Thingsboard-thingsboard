/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.common.data.domain;

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

class DomainDiffblueTest {
  /**
   * Test {@link Domain#Domain(Domain)}.
   *
   * <p>Method under test: {@link Domain#Domain(Domain)}
   */
  @Test
  @DisplayName("Test new Domain(Domain)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Domain.<init>(Domain)"})
  void testNewDomain() {
    // Arrange
    Domain domain = new Domain();

    // Act
    Domain actualDomain = new Domain(domain);

    // Assert
    assertEquals(domain, actualDomain);
  }

  /**
   * Test {@link Domain#equals(Object)}, and {@link Domain#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Domain#equals(Object)}
   *   <li>{@link Domain#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Domain.equals(Object)", "int Domain.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Domain domain = new Domain();
    Domain domain2 = new Domain();

    // Act and Assert
    assertEquals(domain, domain2);
    assertEquals(domain.hashCode(), domain2.hashCode());
  }

  /**
   * Test {@link Domain#equals(Object)}, and {@link Domain#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Domain#equals(Object)}
   *   <li>{@link Domain#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Domain.equals(Object)", "int Domain.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Domain domain = new Domain();

    // Act and Assert
    assertEquals(domain, domain);
    int expectedHashCodeResult = domain.hashCode();
    assertEquals(expectedHashCodeResult, domain.hashCode());
  }

  /**
   * Test {@link Domain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Domain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Domain.equals(Object)", "int Domain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DomainInfo domainInfo = new DomainInfo();

    // Act and Assert
    assertNotEquals(domainInfo, new Domain());
  }

  /**
   * Test {@link Domain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Domain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Domain.equals(Object)", "int Domain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Domain domain = new Domain();

    // Act and Assert
    assertNotEquals(domain, new DomainInfo());
  }

  /**
   * Test {@link Domain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Domain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Domain.equals(Object)", "int Domain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Domain domain = new Domain();

    DomainInfo domainInfo = mock(DomainInfo.class);
    when(domainInfo.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(domain, domainInfo);
  }

  /**
   * Test {@link Domain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Domain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Domain.equals(Object)", "int Domain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DomainInfo domainInfo = new DomainInfo();

    DomainInfo domainInfo2 = mock(DomainInfo.class);
    when(domainInfo2.isOauth2Enabled()).thenReturn(true);
    when(domainInfo2.isPropagateToEdge()).thenReturn(true);
    when(domainInfo2.getName()).thenReturn("Name");
    when(domainInfo2.getOauth2ClientInfos()).thenReturn(new ArrayList<>());
    when(domainInfo2.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(domainInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(domainInfo, domainInfo2);
  }

  /**
   * Test {@link Domain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Domain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Domain.equals(Object)", "int Domain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DomainInfo domainInfo = new DomainInfo();
    domainInfo.setOauth2Enabled(true);

    DomainInfo domainInfo2 = mock(DomainInfo.class);
    when(domainInfo2.isOauth2Enabled()).thenReturn(true);
    when(domainInfo2.isPropagateToEdge()).thenReturn(true);
    when(domainInfo2.getName()).thenReturn("Name");
    when(domainInfo2.getOauth2ClientInfos()).thenReturn(new ArrayList<>());
    when(domainInfo2.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(domainInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(domainInfo, domainInfo2);
  }

  /**
   * Test {@link Domain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Domain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Domain.equals(Object)", "int Domain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DomainInfo domainInfo = new DomainInfo();
    domainInfo.setOauth2Enabled(true);

    DomainInfo domainInfo2 = mock(DomainInfo.class);
    when(domainInfo2.isOauth2Enabled()).thenReturn(true);
    when(domainInfo2.isPropagateToEdge()).thenReturn(false);
    when(domainInfo2.getName()).thenReturn("Name");
    when(domainInfo2.getOauth2ClientInfos()).thenReturn(new ArrayList<>());
    when(domainInfo2.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(domainInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(domainInfo, domainInfo2);
  }

  /**
   * Test {@link Domain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Domain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Domain.equals(Object)", "int Domain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DomainInfo domainInfo = new DomainInfo();
    domainInfo.setTenantId(TenantId.SYS_TENANT_ID);
    domainInfo.setOauth2Enabled(true);

    DomainInfo domainInfo2 = mock(DomainInfo.class);
    when(domainInfo2.isOauth2Enabled()).thenReturn(true);
    when(domainInfo2.isPropagateToEdge()).thenReturn(false);
    when(domainInfo2.getName()).thenReturn("Name");
    when(domainInfo2.getOauth2ClientInfos()).thenReturn(new ArrayList<>());
    when(domainInfo2.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(domainInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(domainInfo, domainInfo2);
  }

  /**
   * Test {@link Domain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Domain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Domain.equals(Object)", "int Domain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DomainInfo domainInfo = new DomainInfo();
    domainInfo.setTenantId(mock(TenantId.class));
    domainInfo.setOauth2Enabled(true);

    DomainInfo domainInfo2 = mock(DomainInfo.class);
    when(domainInfo2.isOauth2Enabled()).thenReturn(true);
    when(domainInfo2.isPropagateToEdge()).thenReturn(false);
    when(domainInfo2.getName()).thenReturn("Name");
    when(domainInfo2.getOauth2ClientInfos()).thenReturn(new ArrayList<>());
    when(domainInfo2.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(domainInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(domainInfo, domainInfo2);
  }

  /**
   * Test {@link Domain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Domain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Domain.equals(Object)", "int Domain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DomainInfo domainInfo = new DomainInfo();
    domainInfo.setName("Name");
    domainInfo.setTenantId(TenantId.SYS_TENANT_ID);
    domainInfo.setOauth2Enabled(true);

    DomainInfo domainInfo2 = mock(DomainInfo.class);
    when(domainInfo2.isOauth2Enabled()).thenReturn(true);
    when(domainInfo2.isPropagateToEdge()).thenReturn(false);
    when(domainInfo2.getName()).thenReturn("Name");
    when(domainInfo2.getOauth2ClientInfos()).thenReturn(new ArrayList<>());
    when(domainInfo2.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(domainInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(domainInfo, domainInfo2);
  }

  /**
   * Test {@link Domain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Domain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Domain.equals(Object)", "int Domain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DomainInfo domainInfo = new DomainInfo();
    domainInfo.setName("org.thingsboard.server.common.data.domain.Domain");
    domainInfo.setTenantId(TenantId.SYS_TENANT_ID);
    domainInfo.setOauth2Enabled(true);

    DomainInfo domainInfo2 = mock(DomainInfo.class);
    when(domainInfo2.isOauth2Enabled()).thenReturn(true);
    when(domainInfo2.isPropagateToEdge()).thenReturn(false);
    when(domainInfo2.getName()).thenReturn("Name");
    when(domainInfo2.getOauth2ClientInfos()).thenReturn(new ArrayList<>());
    when(domainInfo2.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(domainInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(domainInfo, domainInfo2);
  }

  /**
   * Test {@link Domain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Domain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Domain.equals(Object)", "int Domain.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Domain(), null);
  }

  /**
   * Test {@link Domain#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Domain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Domain.equals(Object)", "int Domain.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Domain(), "Different type to Domain");
  }
}
