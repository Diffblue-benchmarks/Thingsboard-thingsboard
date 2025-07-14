package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

class TenantEntityDiffblueTest {
  /**
   * Test {@link TenantEntity#equals(Object)}, and {@link TenantEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantEntity#equals(Object)}
   *   <li>{@link TenantEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantEntity.equals(Object)", "int TenantEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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

    // Act and Assert
    assertEquals(tenantEntity, tenantEntity2);
    int expectedHashCodeResult = tenantEntity.hashCode();
    assertEquals(expectedHashCodeResult, tenantEntity2.hashCode());
  }

  /**
   * Test {@link TenantEntity#equals(Object)}, and {@link TenantEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantEntity#equals(Object)}
   *   <li>{@link TenantEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantEntity.equals(Object)", "int TenantEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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

    // Act and Assert
    assertEquals(tenantEntity, tenantEntity);
    int expectedHashCodeResult = tenantEntity.hashCode();
    assertEquals(expectedHashCodeResult, tenantEntity.hashCode());
  }

  /**
   * Test {@link TenantEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantEntity.equals(Object)", "int TenantEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAdditionalInfo(DoubleNode.valueOf(10.0d));
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

    // Act and Assert
    assertNotEquals(tenantEntity, tenantEntity2);
  }

  /**
   * Test {@link TenantEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantEntity.equals(Object)", "int TenantEntity.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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

    // Act and Assert
    assertNotEquals(tenantEntity, null);
  }

  /**
   * Test {@link TenantEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantEntity.equals(Object)", "int TenantEntity.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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

    // Act and Assert
    assertNotEquals(tenantEntity, "Different type to TenantEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantEntity#TenantEntity()}
   *   <li>{@link TenantEntity#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TenantEntity.<init>()", "java.lang.String TenantEntity.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    TenantEntity actualTenantEntity = new TenantEntity();

    // Assert
    assertEquals("TenantEntity()", actualTenantEntity.toString());
    assertNull(actualTenantEntity.getAdditionalInfo());
    assertNull(actualTenantEntity.getVersion());
    assertNull(actualTenantEntity.getAddress());
    assertNull(actualTenantEntity.getAddress2());
    assertNull(actualTenantEntity.getCity());
    assertNull(actualTenantEntity.getCountry());
    assertNull(actualTenantEntity.getEmail());
    assertNull(actualTenantEntity.getPhone());
    assertNull(actualTenantEntity.getRegion());
    assertNull(actualTenantEntity.getState());
    assertNull(actualTenantEntity.getTitle());
    assertNull(actualTenantEntity.getZip());
    assertNull(actualTenantEntity.getId());
    assertNull(actualTenantEntity.getUuid());
    assertNull(actualTenantEntity.getTenantProfileId());
    assertEquals(0L, actualTenantEntity.getCreatedTime());
  }

  /**
   * Test {@link TenantEntity#TenantEntity(Tenant)}.
   *
   * <p>Method under test: {@link TenantEntity#TenantEntity(Tenant)}
   */
  @Test
  @DisplayName("Test new TenantEntity(Tenant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TenantEntity.<init>(Tenant)"})
  void testNewTenantEntity() {
    // Arrange
    Tenant tenant = new Tenant();
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    TenantProfileId tenantProfileId = new TenantProfileId(id);
    tenant.setTenantProfileId(tenantProfileId);

    // Act
    TenantEntity actualTenantEntity = new TenantEntity(tenant);

    // Assert
    UUID tenantProfileId2 = actualTenantEntity.getTenantProfileId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantProfileId2.toString());
    assertEquals(tenantProfileId, actualTenantEntity.toData().getTenantProfileId());
    assertSame(id, tenantProfileId2);
  }

  /**
   * Test {@link TenantEntity#TenantEntity(Tenant)}.
   *
   * <ul>
   *   <li>When {@link Tenant#Tenant()}.
   *   <li>Then return AdditionalInfo is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TenantEntity#TenantEntity(Tenant)}
   */
  @Test
  @DisplayName("Test new TenantEntity(Tenant); when Tenant(); then return AdditionalInfo is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TenantEntity.<init>(Tenant)"})
  void testNewTenantEntity_whenTenant_thenReturnAdditionalInfoIsNull() {
    // Arrange and Act
    TenantEntity actualTenantEntity = new TenantEntity(new Tenant());

    // Assert
    assertNull(actualTenantEntity.getAdditionalInfo());
    assertNull(actualTenantEntity.getVersion());
    assertNull(actualTenantEntity.getAddress());
    assertNull(actualTenantEntity.getAddress2());
    assertNull(actualTenantEntity.getCity());
    assertNull(actualTenantEntity.getCountry());
    assertNull(actualTenantEntity.getEmail());
    assertNull(actualTenantEntity.getPhone());
    assertNull(actualTenantEntity.getRegion());
    assertNull(actualTenantEntity.getState());
    assertNull(actualTenantEntity.getTitle());
    assertNull(actualTenantEntity.getZip());
    assertNull(actualTenantEntity.getId());
    assertNull(actualTenantEntity.getUuid());
    assertNull(actualTenantEntity.getTenantProfileId());
    assertEquals(0L, actualTenantEntity.getCreatedTime());
  }

  /**
   * Test {@link TenantEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link TenantEntity#TenantEntity()} Uuid is fromString {@code
   *       784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link TenantEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given TenantEntity() Uuid is fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tenant TenantEntity.toData()"})
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
    tenantEntity.setTitle("Dr");
    tenantEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantEntity.setVersion(1L);
    tenantEntity.setZip("21654");
    tenantEntity.setTenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    Tenant actualToDataResult = tenantEntity.toData();

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
    assertEquals("jane.doe@example.org", actualToDataResult.getEmail());
    assertEquals("us-east-2", actualToDataResult.getRegion());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
  }

  /**
   * Test {@link TenantEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link TenantEntity#TenantEntity()} Uuid is randomUUID.
   *   <li>Then return UuidId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TenantEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given TenantEntity() Uuid is randomUUID; then return UuidId is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tenant TenantEntity.toData()"})
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
    tenantEntity.setTitle("Dr");
    UUID id = UUID.randomUUID();
    tenantEntity.setUuid(id);
    tenantEntity.setVersion(1L);
    tenantEntity.setZip("21654");
    tenantEntity.setTenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    Tenant actualToDataResult = tenantEntity.toData();

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
    assertEquals("jane.doe@example.org", actualToDataResult.getEmail());
    assertEquals("us-east-2", actualToDataResult.getRegion());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertSame(id, actualToDataResult.getUuidId());
  }

  /**
   * Test {@link TenantEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link TenantEntity#TenantEntity()}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link TenantEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given TenantEntity(); then AdditionalInfo return NullNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Tenant TenantEntity.toData()"})
  void testToData_givenTenantEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    Tenant actualToDataResult = new TenantEntity().toData();

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
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getTenantProfileId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
  }
}
