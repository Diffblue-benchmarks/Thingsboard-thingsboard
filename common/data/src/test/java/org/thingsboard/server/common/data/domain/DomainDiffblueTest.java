package org.thingsboard.server.common.data.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Domain.<init>(Domain)"})
  void testNewDomain() {
    // Arrange
    Domain domain = new Domain();

    // Act and Assert
    assertEquals(domain, new Domain(domain));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Domain.equals(Object)", "int Domain.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Domain domain = new Domain();
    Domain domain2 = new Domain();

    // Act and Assert
    assertEquals(domain, domain2);
    int expectedHashCodeResult = domain.hashCode();
    assertEquals(expectedHashCodeResult, domain2.hashCode());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Domain.equals(Object)", "int Domain.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Domain domain = new Domain();
    domain.setTenantId(TenantId.SYS_TENANT_ID);

    Domain domain2 = new Domain();
    domain2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(domain, domain2);
    int expectedHashCodeResult = domain.hashCode();
    assertEquals(expectedHashCodeResult, domain2.hashCode());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Domain.equals(Object)", "int Domain.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Domain domain = new Domain();
    domain.setName("Name");

    Domain domain2 = new Domain();
    domain2.setName("Name");

    // Act and Assert
    assertEquals(domain, domain2);
    int expectedHashCodeResult = domain.hashCode();
    assertEquals(expectedHashCodeResult, domain2.hashCode());
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Domain.equals(Object)", "int Domain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Domain domain = new Domain();
    domain.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(domain, new Domain());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Domain.equals(Object)", "int Domain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Domain domain = new Domain();
    domain.setName("Name");

    // Act and Assert
    assertNotEquals(domain, new Domain());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Domain.equals(Object)", "int Domain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Domain domain = new Domain();
    domain.setOauth2Enabled(true);

    // Act and Assert
    assertNotEquals(domain, new Domain());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Domain.equals(Object)", "int Domain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Domain domain = new Domain();
    domain.setPropagateToEdge(true);

    // Act and Assert
    assertNotEquals(domain, new Domain());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Domain.equals(Object)", "int Domain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Domain domain = new Domain();

    Domain domain2 = new Domain();
    domain2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(domain, domain2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Domain.equals(Object)", "int Domain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Domain domain = new Domain();

    Domain domain2 = new Domain();
    domain2.setName("Name");

    // Act and Assert
    assertNotEquals(domain, domain2);
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Domain.equals(Object)", "int Domain.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Domain(), "Different type to Domain");
  }
}
