package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.TenantInfo;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

class TenantInfoEntityDiffblueTest {
  /**
   * Test {@link TenantInfoEntity#equals(Object)}, and {@link TenantInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantInfoEntity#equals(Object)}
   *   <li>{@link TenantInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantInfoEntity.equals(Object)", "int TenantInfoEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantInfoEntity tenantInfoEntity = new TenantInfoEntity();
    TenantInfoEntity tenantInfoEntity2 = new TenantInfoEntity();

    // Act and Assert
    assertEquals(tenantInfoEntity, tenantInfoEntity2);
    int expectedHashCodeResult = tenantInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, tenantInfoEntity2.hashCode());
  }

  /**
   * Test {@link TenantInfoEntity#equals(Object)}, and {@link TenantInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantInfoEntity#equals(Object)}
   *   <li>{@link TenantInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantInfoEntity.equals(Object)", "int TenantInfoEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantEntity.setAddress("42 Main St");
    tenantEntity.setAddress2("42 Main St");
    tenantEntity.setCity("Oxford");
    tenantEntity.setCountry("GB");
    tenantEntity.setCreatedTime(1L);
    tenantEntity.setEmail("jane.doe@example.org");
    tenantEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantEntity.setPhone("6625550144");
    tenantEntity.setRegion("us-east-2");
    tenantEntity.setState("MD");
    tenantEntity.setTenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantEntity.setTitle("Dr");
    tenantEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantEntity.setVersion(1L);
    tenantEntity.setZip("21654");
    TenantInfoEntity tenantInfoEntity = new TenantInfoEntity(tenantEntity, "foo.txt");

    TenantEntity tenantEntity2 = new TenantEntity();
    tenantEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantEntity2.setAddress("42 Main St");
    tenantEntity2.setAddress2("42 Main St");
    tenantEntity2.setCity("Oxford");
    tenantEntity2.setCountry("GB");
    tenantEntity2.setCreatedTime(1L);
    tenantEntity2.setEmail("jane.doe@example.org");
    tenantEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantEntity2.setPhone("6625550144");
    tenantEntity2.setRegion("us-east-2");
    tenantEntity2.setState("MD");
    tenantEntity2.setTenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantEntity2.setTitle("Dr");
    tenantEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantEntity2.setVersion(1L);
    tenantEntity2.setZip("21654");
    TenantInfoEntity tenantInfoEntity2 = new TenantInfoEntity(tenantEntity2, "foo.txt");

    // Act and Assert
    assertEquals(tenantInfoEntity, tenantInfoEntity2);
    int expectedHashCodeResult = tenantInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, tenantInfoEntity2.hashCode());
  }

  /**
   * Test {@link TenantInfoEntity#equals(Object)}, and {@link TenantInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantInfoEntity#equals(Object)}
   *   <li>{@link TenantInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantInfoEntity.equals(Object)", "int TenantInfoEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantInfoEntity tenantInfoEntity = new TenantInfoEntity();

    // Act and Assert
    assertEquals(tenantInfoEntity, tenantInfoEntity);
    int expectedHashCodeResult = tenantInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, tenantInfoEntity.hashCode());
  }

  /**
   * Test {@link TenantInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantInfoEntity.equals(Object)", "int TenantInfoEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantEntity.setAddress("42 Main St");
    tenantEntity.setAddress2("42 Main St");
    tenantEntity.setCity("Oxford");
    tenantEntity.setCountry("GB");
    tenantEntity.setCreatedTime(1L);
    tenantEntity.setEmail("jane.doe@example.org");
    tenantEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantEntity.setPhone("6625550144");
    tenantEntity.setRegion("us-east-2");
    tenantEntity.setState("MD");
    tenantEntity.setTenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantEntity.setTitle("Dr");
    tenantEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantEntity.setVersion(1L);
    tenantEntity.setZip("21654");
    TenantInfoEntity tenantInfoEntity = new TenantInfoEntity(tenantEntity, "foo.txt");

    // Act and Assert
    assertNotEquals(tenantInfoEntity, new TenantInfoEntity());
  }

  /**
   * Test {@link TenantInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantInfoEntity.equals(Object)", "int TenantInfoEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantInfoEntity tenantInfoEntity = new TenantInfoEntity();
    tenantInfoEntity.setTenantProfileName("foo.txt");

    // Act and Assert
    assertNotEquals(tenantInfoEntity, new TenantInfoEntity());
  }

  /**
   * Test {@link TenantInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantInfoEntity.equals(Object)", "int TenantInfoEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantInfoEntity tenantInfoEntity = new TenantInfoEntity();

    TenantInfoEntity tenantInfoEntity2 = new TenantInfoEntity();
    tenantInfoEntity2.setTenantProfileName("foo.txt");

    // Act and Assert
    assertNotEquals(tenantInfoEntity, tenantInfoEntity2);
  }

  /**
   * Test {@link TenantInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantInfoEntity.equals(Object)", "int TenantInfoEntity.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantInfoEntity(), null);
  }

  /**
   * Test {@link TenantInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantInfoEntity.equals(Object)", "int TenantInfoEntity.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantInfoEntity(), "Different type to TenantInfoEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantInfoEntity#TenantInfoEntity()}
   *   <li>{@link TenantInfoEntity#setTenantProfileName(String)}
   *   <li>{@link TenantInfoEntity#toString()}
   *   <li>{@link TenantInfoEntity#getTenantProfileName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TenantInfoEntity.<init>()",
    "String TenantInfoEntity.getTenantProfileName()",
    "void TenantInfoEntity.setTenantProfileName(String)",
    "String TenantInfoEntity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TenantInfoEntity actualTenantInfoEntity = new TenantInfoEntity();
    actualTenantInfoEntity.setTenantProfileName("foo.txt");
    String actualToStringResult = actualTenantInfoEntity.toString();

    // Assert
    assertEquals("TenantInfoEntity(tenantProfileName=foo.txt)", actualToStringResult);
    assertEquals("foo.txt", actualTenantInfoEntity.getTenantProfileName());
    assertNull(actualTenantInfoEntity.getAdditionalInfo());
    assertNull(actualTenantInfoEntity.getVersion());
    assertNull(actualTenantInfoEntity.getAddress());
    assertNull(actualTenantInfoEntity.getAddress2());
    assertNull(actualTenantInfoEntity.getCity());
    assertNull(actualTenantInfoEntity.getCountry());
    assertNull(actualTenantInfoEntity.getEmail());
    assertNull(actualTenantInfoEntity.getPhone());
    assertNull(actualTenantInfoEntity.getRegion());
    assertNull(actualTenantInfoEntity.getState());
    assertNull(actualTenantInfoEntity.getTitle());
    assertNull(actualTenantInfoEntity.getZip());
    assertNull(actualTenantInfoEntity.getId());
    assertNull(actualTenantInfoEntity.getUuid());
    assertNull(actualTenantInfoEntity.getTenantProfileId());
    assertEquals(0L, actualTenantInfoEntity.getCreatedTime());
  }

  /**
   * Test {@link TenantInfoEntity#TenantInfoEntity(TenantEntity, String)}.
   *
   * <p>Method under test: {@link TenantInfoEntity#TenantInfoEntity(TenantEntity, String)}
   */
  @Test
  @DisplayName("Test new TenantInfoEntity(TenantEntity, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TenantInfoEntity.<init>(TenantEntity, String)"})
  void testNewTenantInfoEntity() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantEntity.setAddress("42 Main St");
    tenantEntity.setAddress2("42 Main St");
    tenantEntity.setCity("Oxford");
    tenantEntity.setCountry("GB");
    tenantEntity.setCreatedTime(1L);
    tenantEntity.setEmail("jane.doe@example.org");
    tenantEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantEntity.setPhone("6625550144");
    tenantEntity.setRegion("us-east-2");
    tenantEntity.setState("MD");
    UUID tenantProfileId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    tenantEntity.setTenantProfileId(tenantProfileId);
    tenantEntity.setTitle("Dr");
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    tenantEntity.setUuid(id);
    tenantEntity.setVersion(1L);
    tenantEntity.setZip("21654");

    // Act
    TenantInfoEntity actualTenantInfoEntity = new TenantInfoEntity(tenantEntity, "foo.txt");

    // Assert
    assertTrue(actualTenantInfoEntity.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("21654", actualTenantInfoEntity.getZip());
    assertEquals("42 Main St", actualTenantInfoEntity.getAddress());
    assertEquals("42 Main St", actualTenantInfoEntity.getAddress2());
    assertEquals("6625550144", actualTenantInfoEntity.getPhone());
    assertEquals("Dr", actualTenantInfoEntity.getTitle());
    assertEquals("GB", actualTenantInfoEntity.getCountry());
    assertEquals("MD", actualTenantInfoEntity.getState());
    assertEquals("Oxford", actualTenantInfoEntity.getCity());
    assertEquals("foo.txt", actualTenantInfoEntity.getTenantProfileName());
    assertEquals("jane.doe@example.org", actualTenantInfoEntity.getEmail());
    assertEquals("us-east-2", actualTenantInfoEntity.getRegion());
    assertEquals(1L, actualTenantInfoEntity.getVersion().longValue());
    assertEquals(1L, actualTenantInfoEntity.getCreatedTime());
    assertSame(id, actualTenantInfoEntity.getId());
    assertSame(id, actualTenantInfoEntity.getUuid());
    assertSame(tenantProfileId, actualTenantInfoEntity.getTenantProfileId());
  }

  /**
   * Test {@link TenantInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link TenantEntity#TenantEntity()} Uuid is fromString {@code
   *       784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link TenantInfoEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given TenantEntity() Uuid is fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantInfo TenantInfoEntity.toData()"})
  void testToData_givenTenantEntityUuidIsFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantEntity.setAddress("42 Main St");
    tenantEntity.setAddress2("42 Main St");
    tenantEntity.setCity("Oxford");
    tenantEntity.setCountry("GB");
    tenantEntity.setCreatedTime(1L);
    tenantEntity.setEmail("jane.doe@example.org");
    tenantEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantEntity.setPhone("6625550144");
    tenantEntity.setRegion("us-east-2");
    tenantEntity.setState("MD");
    tenantEntity.setTenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantEntity.setTitle("Dr");
    tenantEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantEntity.setVersion(1L);
    tenantEntity.setZip("21654");

    TenantInfoEntity tenantInfoEntity = new TenantInfoEntity(tenantEntity, "foo.txt");
    tenantInfoEntity.setTenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TenantInfo actualToDataResult = tenantInfoEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("21654", actualToDataResult.getZip());
    assertEquals("42 Main St", actualToDataResult.getAddress());
    assertEquals("42 Main St", actualToDataResult.getAddress2());
    assertEquals("6625550144", actualToDataResult.getPhone());
    assertEquals("Dr", actualToDataResult.getName());
    assertEquals("Dr", actualToDataResult.getTitle());
    assertEquals("GB", actualToDataResult.getCountry());
    assertEquals("MD", actualToDataResult.getState());
    assertEquals("Oxford", actualToDataResult.getCity());
    assertEquals("foo.txt", actualToDataResult.getTenantProfileName());
    assertEquals("jane.doe@example.org", actualToDataResult.getEmail());
    assertEquals("us-east-2", actualToDataResult.getRegion());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
  }

  /**
   * Test {@link TenantInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link TenantEntity#TenantEntity()} Uuid is randomUUID.
   *   <li>Then return UuidId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TenantInfoEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given TenantEntity() Uuid is randomUUID; then return UuidId is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantInfo TenantInfoEntity.toData()"})
  void testToData_givenTenantEntityUuidIsRandomUUID_thenReturnUuidIdIsRandomUUID() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantEntity.setAddress("42 Main St");
    tenantEntity.setAddress2("42 Main St");
    tenantEntity.setCity("Oxford");
    tenantEntity.setCountry("GB");
    tenantEntity.setCreatedTime(1L);
    tenantEntity.setEmail("jane.doe@example.org");
    tenantEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantEntity.setPhone("6625550144");
    tenantEntity.setRegion("us-east-2");
    tenantEntity.setState("MD");
    tenantEntity.setTenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantEntity.setTitle("Dr");
    UUID id = UUID.randomUUID();
    tenantEntity.setUuid(id);
    tenantEntity.setVersion(1L);
    tenantEntity.setZip("21654");

    TenantInfoEntity tenantInfoEntity = new TenantInfoEntity(tenantEntity, "foo.txt");
    tenantInfoEntity.setTenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TenantInfo actualToDataResult = tenantInfoEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("21654", actualToDataResult.getZip());
    assertEquals("42 Main St", actualToDataResult.getAddress());
    assertEquals("42 Main St", actualToDataResult.getAddress2());
    assertEquals("6625550144", actualToDataResult.getPhone());
    assertEquals("Dr", actualToDataResult.getName());
    assertEquals("Dr", actualToDataResult.getTitle());
    assertEquals("GB", actualToDataResult.getCountry());
    assertEquals("MD", actualToDataResult.getState());
    assertEquals("Oxford", actualToDataResult.getCity());
    assertEquals("foo.txt", actualToDataResult.getTenantProfileName());
    assertEquals("jane.doe@example.org", actualToDataResult.getEmail());
    assertEquals("us-east-2", actualToDataResult.getRegion());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertSame(id, actualToDataResult.getUuidId());
  }

  /**
   * Test {@link TenantInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link TenantInfoEntity#TenantInfoEntity()}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link TenantInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given TenantInfoEntity(); then AdditionalInfo return NullNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantInfo TenantInfoEntity.toData()"})
  void testToData_givenTenantInfoEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    TenantInfo actualToDataResult = new TenantInfoEntity().toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getAddress());
    assertNull(actualToDataResult.getAddress2());
    assertNull(actualToDataResult.getCity());
    assertNull(actualToDataResult.getCountry());
    assertNull(actualToDataResult.getEmail());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getPhone());
    assertNull(actualToDataResult.getRegion());
    assertNull(actualToDataResult.getState());
    assertNull(actualToDataResult.getTitle());
    assertNull(actualToDataResult.getZip());
    assertNull(actualToDataResult.getTenantProfileName());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getTenantProfileId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
  }
}
