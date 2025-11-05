package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.NullNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class TenantInfoDiffblueTest {
  /**
   * Test {@link TenantInfo#equals(Object)}, and {@link TenantInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantInfo#equals(Object)}
   *   <li>{@link TenantInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantInfo.equals(Object)", "int TenantInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantInfo tenantInfo = new TenantInfo();
    TenantInfo tenantInfo2 = new TenantInfo();

    // Act and Assert
    assertEquals(tenantInfo, tenantInfo2);
    assertEquals(tenantInfo.hashCode(), tenantInfo2.hashCode());
  }

  /**
   * Test {@link TenantInfo#equals(Object)}, and {@link TenantInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantInfo#equals(Object)}
   *   <li>{@link TenantInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantInfo.equals(Object)", "int TenantInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TenantInfo tenantInfo = new TenantInfo(new Tenant(), "foo.txt");
    TenantInfo tenantInfo2 = new TenantInfo(new Tenant(), "foo.txt");

    // Act and Assert
    assertEquals(tenantInfo, tenantInfo2);
    assertEquals(tenantInfo.hashCode(), tenantInfo2.hashCode());
  }

  /**
   * Test {@link TenantInfo#equals(Object)}, and {@link TenantInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantInfo#equals(Object)}
   *   <li>{@link TenantInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantInfo.equals(Object)", "int TenantInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantInfo tenantInfo = new TenantInfo();

    // Act and Assert
    assertEquals(tenantInfo, tenantInfo);
    int expectedHashCodeResult = tenantInfo.hashCode();
    assertEquals(expectedHashCodeResult, tenantInfo.hashCode());
  }

  /**
   * Test {@link TenantInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantInfo.equals(Object)", "int TenantInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantInfo tenantInfo = new TenantInfo(new Tenant(), "foo.txt");

    // Act and Assert
    assertNotEquals(tenantInfo, new TenantInfo());
  }

  /**
   * Test {@link TenantInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantInfo.equals(Object)", "int TenantInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantInfo tenantInfo = new TenantInfo();

    // Act and Assert
    assertNotEquals(tenantInfo, new TenantInfo(new Tenant(), "foo.txt"));
  }

  /**
   * Test {@link TenantInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantInfo.equals(Object)", "int TenantInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantInfo(), null);
  }

  /**
   * Test {@link TenantInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantInfo.equals(Object)", "int TenantInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantInfo(), "Different type to TenantInfo");
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Id is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantInfo#TenantInfo()}
   *   <li>{@link TenantInfo#setTenantProfileName(String)}
   *   <li>{@link TenantInfo#toString()}
   *   <li>{@link TenantInfo#getTenantProfileName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Id is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TenantInfo.<init>()",
    "void TenantInfo.<init>(TenantId)",
    "String TenantInfo.getTenantProfileName()",
    "void TenantInfo.setTenantProfileName(String)",
    "String TenantInfo.toString()"
  })
  void testGettersAndSetters_thenReturnIdIsNull() {
    // Arrange and Act
    TenantInfo actualTenantInfo = new TenantInfo();
    actualTenantInfo.setTenantProfileName("foo.txt");
    String actualToStringResult = actualTenantInfo.toString();

    // Assert
    assertEquals("TenantInfo(tenantProfileName=foo.txt)", actualToStringResult);
    assertEquals("foo.txt", actualTenantInfo.getTenantProfileName());
    assertNull(actualTenantInfo.getVersion());
    assertNull(actualTenantInfo.getName());
    assertNull(actualTenantInfo.getRegion());
    assertNull(actualTenantInfo.getTitle());
    assertNull(actualTenantInfo.getId());
    assertNull(actualTenantInfo.getTenantProfileId());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link TenantId#SYS_TENANT_ID}.
   *   <li>Then return Id is {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantInfo#TenantInfo(TenantId)}
   *   <li>{@link TenantInfo#setTenantProfileName(String)}
   *   <li>{@link TenantInfo#toString()}
   *   <li>{@link TenantInfo#getTenantProfileName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when SYS_TENANT_ID; then return Id is SYS_TENANT_ID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TenantInfo.<init>()",
    "void TenantInfo.<init>(TenantId)",
    "String TenantInfo.getTenantProfileName()",
    "void TenantInfo.setTenantProfileName(String)",
    "String TenantInfo.toString()"
  })
  void testGettersAndSetters_whenSys_tenant_id_thenReturnIdIsSys_tenant_id() {
    // Arrange and Act
    TenantInfo actualTenantInfo = new TenantInfo(TenantId.SYS_TENANT_ID);
    actualTenantInfo.setTenantProfileName("foo.txt");
    String actualToStringResult = actualTenantInfo.toString();

    // Assert
    assertEquals("TenantInfo(tenantProfileName=foo.txt)", actualToStringResult);
    assertEquals("foo.txt", actualTenantInfo.getTenantProfileName());
    assertNull(actualTenantInfo.getVersion());
    assertNull(actualTenantInfo.getName());
    assertNull(actualTenantInfo.getRegion());
    assertNull(actualTenantInfo.getTitle());
    assertNull(actualTenantInfo.getTenantProfileId());
    assertSame(TenantId.SYS_TENANT_ID, actualTenantInfo.getId());
  }

  /**
   * Test {@link TenantInfo#TenantInfo(Tenant, String)}.
   *
   * <p>Method under test: {@link TenantInfo#TenantInfo(Tenant, String)}
   */
  @Test
  @DisplayName("Test new TenantInfo(Tenant, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantInfo.<init>(Tenant, String)"})
  void testNewTenantInfo() {
    // Arrange and Act
    TenantInfo actualTenantInfo = new TenantInfo(new Tenant(), "foo.txt");

    // Assert
    assertTrue(actualTenantInfo.getAdditionalInfo() instanceof NullNode);
    assertEquals("foo.txt", actualTenantInfo.getTenantProfileName());
    assertNull(actualTenantInfo.getVersion());
    assertNull(actualTenantInfo.getAddress());
    assertNull(actualTenantInfo.getAddress2());
    assertNull(actualTenantInfo.getCity());
    assertNull(actualTenantInfo.getCountry());
    assertNull(actualTenantInfo.getEmail());
    assertNull(actualTenantInfo.getName());
    assertNull(actualTenantInfo.getPhone());
    assertNull(actualTenantInfo.getRegion());
    assertNull(actualTenantInfo.getState());
    assertNull(actualTenantInfo.getTitle());
    assertNull(actualTenantInfo.getZip());
    assertNull(actualTenantInfo.address);
    assertNull(actualTenantInfo.address2);
    assertNull(actualTenantInfo.city);
    assertNull(actualTenantInfo.country);
    assertNull(actualTenantInfo.email);
    assertNull(actualTenantInfo.phone);
    assertNull(actualTenantInfo.state);
    assertNull(actualTenantInfo.zip);
    assertNull(actualTenantInfo.getUuidId());
    assertNull(actualTenantInfo.getId());
    assertNull(actualTenantInfo.getTenantId());
    assertNull(actualTenantInfo.getTenantProfileId());
    assertEquals(0L, actualTenantInfo.getCreatedTime());
    assertEquals(0L, actualTenantInfo.createdTime);
  }
}
