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
package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.TenantInfo;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class TenantInfoEntityDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantInfoEntity.equals(Object)", "int TenantInfoEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantInfoEntity tenantInfoEntity = new TenantInfoEntity();
    TenantInfoEntity tenantInfoEntity2 = new TenantInfoEntity();

    // Act and Assert
    assertEquals(tenantInfoEntity, tenantInfoEntity2);
    assertEquals(tenantInfoEntity.hashCode(), tenantInfoEntity2.hashCode());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantInfoEntity.equals(Object)", "int TenantInfoEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantEntity.setAddress("42 Main St");
    tenantEntity.setAddress2("42 Main St");
    tenantEntity.setCity("Oxford");
    tenantEntity.setCountry("GB");
    tenantEntity.setCreatedTime(1L);
    tenantEntity.setEmail("jane.doe@example.org");
    tenantEntity.setId(ModelConstants.NULL_UUID);
    tenantEntity.setPhone("6625550144");
    tenantEntity.setRegion("us-east-2");
    tenantEntity.setState("MD");
    tenantEntity.setTenantProfileId(ModelConstants.NULL_UUID);
    tenantEntity.setTitle("Dr");
    tenantEntity.setUuid(ModelConstants.NULL_UUID);
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
    tenantEntity2.setId(ModelConstants.NULL_UUID);
    tenantEntity2.setPhone("6625550144");
    tenantEntity2.setRegion("us-east-2");
    tenantEntity2.setState("MD");
    tenantEntity2.setTenantProfileId(ModelConstants.NULL_UUID);
    tenantEntity2.setTitle("Dr");
    tenantEntity2.setUuid(ModelConstants.NULL_UUID);
    tenantEntity2.setVersion(1L);
    tenantEntity2.setZip("21654");
    TenantInfoEntity tenantInfoEntity2 = new TenantInfoEntity(tenantEntity2, "foo.txt");

    // Act and Assert
    assertEquals(tenantInfoEntity, tenantInfoEntity2);
    assertEquals(tenantInfoEntity.hashCode(), tenantInfoEntity2.hashCode());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantInfoEntity.equals(Object)", "int TenantInfoEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantInfoEntity.equals(Object)", "int TenantInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantEntity.setAddress("42 Main St");
    tenantEntity.setAddress2("42 Main St");
    tenantEntity.setCity("Oxford");
    tenantEntity.setCountry("GB");
    tenantEntity.setCreatedTime(1L);
    tenantEntity.setEmail("jane.doe@example.org");
    tenantEntity.setId(ModelConstants.NULL_UUID);
    tenantEntity.setPhone("6625550144");
    tenantEntity.setRegion("us-east-2");
    tenantEntity.setState("MD");
    tenantEntity.setTenantProfileId(ModelConstants.NULL_UUID);
    tenantEntity.setTitle("Dr");
    tenantEntity.setUuid(ModelConstants.NULL_UUID);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantInfoEntity.equals(Object)", "int TenantInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantInfoEntity.equals(Object)", "int TenantInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantInfoEntity.equals(Object)", "int TenantInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantInfoEntity.equals(Object)", "int TenantInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TenantInfoEntity.<init>()",
    "String TenantInfoEntity.getTenantProfileName()",
    "void TenantInfoEntity.setTenantProfileName(String)",
    "String TenantInfoEntity.toString()"
  })
  public void testGettersAndSetters() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantInfoEntity.<init>(TenantEntity, String)"})
  public void testNewTenantInfoEntity() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantEntity.setAddress("42 Main St");
    tenantEntity.setAddress2("42 Main St");
    tenantEntity.setCity("Oxford");
    tenantEntity.setCountry("GB");
    tenantEntity.setCreatedTime(1L);
    tenantEntity.setEmail("jane.doe@example.org");
    tenantEntity.setId(ModelConstants.NULL_UUID);
    tenantEntity.setPhone("6625550144");
    tenantEntity.setRegion("us-east-2");
    tenantEntity.setState("MD");
    tenantEntity.setTenantProfileId(ModelConstants.NULL_UUID);
    tenantEntity.setTitle("Dr");
    tenantEntity.setUuid(ModelConstants.NULL_UUID);
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
  }

  /**
   * Test {@link TenantInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link TenantEntity#TenantEntity()} Uuid is {@link ModelConstants#NULL_UUID}.
   *   <li>Then AdditionalInfo return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link TenantInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantInfo TenantInfoEntity.toData()"})
  public void testToData_givenTenantEntityUuidIsNull_uuid_thenAdditionalInfoReturnObjectNode() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantEntity.setAddress("42 Main St");
    tenantEntity.setAddress2("42 Main St");
    tenantEntity.setCity("Oxford");
    tenantEntity.setCountry("GB");
    tenantEntity.setCreatedTime(1L);
    tenantEntity.setEmail("jane.doe@example.org");
    tenantEntity.setId(ModelConstants.NULL_UUID);
    tenantEntity.setPhone("6625550144");
    tenantEntity.setRegion("us-east-2");
    tenantEntity.setState("MD");
    tenantEntity.setTenantProfileId(ModelConstants.NULL_UUID);
    tenantEntity.setTitle("Dr");
    tenantEntity.setUuid(ModelConstants.NULL_UUID);
    tenantEntity.setVersion(1L);
    tenantEntity.setZip("21654");

    TenantInfoEntity tenantInfoEntity = new TenantInfoEntity(tenantEntity, "foo.txt");
    tenantInfoEntity.setTenantProfileId(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantInfo TenantInfoEntity.toData()"})
  public void testToData_givenTenantEntityUuidIsRandomUUID_thenReturnUuidIdIsRandomUUID() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantEntity.setAddress("42 Main St");
    tenantEntity.setAddress2("42 Main St");
    tenantEntity.setCity("Oxford");
    tenantEntity.setCountry("GB");
    tenantEntity.setCreatedTime(1L);
    tenantEntity.setEmail("jane.doe@example.org");
    tenantEntity.setId(ModelConstants.NULL_UUID);
    tenantEntity.setPhone("6625550144");
    tenantEntity.setRegion("us-east-2");
    tenantEntity.setState("MD");
    tenantEntity.setTenantProfileId(ModelConstants.NULL_UUID);
    tenantEntity.setTitle("Dr");
    UUID id = UUID.randomUUID();
    tenantEntity.setUuid(id);
    tenantEntity.setVersion(1L);
    tenantEntity.setZip("21654");

    TenantInfoEntity tenantInfoEntity = new TenantInfoEntity(tenantEntity, "foo.txt");
    tenantInfoEntity.setTenantProfileId(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantInfo TenantInfoEntity.toData()"})
  public void testToData_givenTenantInfoEntity_thenAdditionalInfoReturnNullNode() {
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
