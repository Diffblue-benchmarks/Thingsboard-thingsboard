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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;

class TenantDiffblueTest {
  /**
   * Test {@link Tenant#equals(Object)}, and {@link Tenant#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Tenant#equals(Object)}
   *   <li>{@link Tenant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Tenant.equals(Object)", "int Tenant.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Tenant tenant = new Tenant();
    Tenant tenant2 = new Tenant();

    // Act and Assert
    assertEquals(tenant, tenant2);
    int expectedHashCodeResult = tenant.hashCode();
    assertEquals(expectedHashCodeResult, tenant2.hashCode());
  }

  /**
   * Test {@link Tenant#equals(Object)}, and {@link Tenant#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Tenant#equals(Object)}
   *   <li>{@link Tenant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Tenant.equals(Object)", "int Tenant.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Tenant tenant = new Tenant();

    // Act and Assert
    assertEquals(tenant, tenant);
    int expectedHashCodeResult = tenant.hashCode();
    assertEquals(expectedHashCodeResult, tenant.hashCode());
  }

  /**
   * Test {@link Tenant#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tenant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Tenant.equals(Object)", "int Tenant.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Tenant tenant = new Tenant(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(tenant, new Tenant());
  }

  /**
   * Test {@link Tenant#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tenant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Tenant.equals(Object)", "int Tenant.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Tenant tenant = new Tenant();

    // Act and Assert
    assertNotEquals(tenant, new TenantInfo());
  }

  /**
   * Test {@link Tenant#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tenant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Tenant.equals(Object)", "int Tenant.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Tenant tenant = new Tenant();
    TenantInfo tenantInfo = mock(TenantInfo.class);
    when(tenantInfo.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tenant, tenantInfo);
  }

  /**
   * Test {@link Tenant#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tenant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Tenant.equals(Object)", "int Tenant.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Tenant(), null);
  }

  /**
   * Test {@link Tenant#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tenant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Tenant.equals(Object)", "int Tenant.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Tenant(), "Different type to Tenant");
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return Id is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Tenant#Tenant()}
   *   <li>{@link Tenant#setRegion(String)}
   *   <li>{@link Tenant#setTitle(String)}
   *   <li>{@link Tenant#setVersion(Long)}
   *   <li>{@link Tenant#toString()}
   *   <li>{@link Tenant#getName()}
   *   <li>{@link Tenant#getRegion()}
   *   <li>{@link Tenant#getTenantProfileId()}
   *   <li>{@link Tenant#getTitle()}
   *   <li>{@link Tenant#getVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Id is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Tenant.<init>()", "void Tenant.<init>(TenantId)", "String Tenant.getName()",
      "String Tenant.getRegion()", "TenantProfileId Tenant.getTenantProfileId()", "String Tenant.getTitle()",
      "Long Tenant.getVersion()", "void Tenant.setRegion(String)", "void Tenant.setTenantProfileId(TenantProfileId)",
      "void Tenant.setTitle(String)", "void Tenant.setVersion(Long)", "String Tenant.toString()"})
  void testGettersAndSetters_thenReturnIdIsNull() {
    // Arrange and Act
    Tenant actualTenant = new Tenant();
    actualTenant.setRegion("us-east-2");
    actualTenant.setTitle("Dr");
    actualTenant.setVersion(1L);
    String actualToStringResult = actualTenant.toString();
    String actualName = actualTenant.getName();
    String actualRegion = actualTenant.getRegion();
    TenantProfileId actualTenantProfileId = actualTenant.getTenantProfileId();
    String actualTitle = actualTenant.getTitle();
    Long actualVersion = actualTenant.getVersion();

    // Assert
    assertEquals("Dr", actualName);
    assertEquals("Dr", actualTitle);
    assertEquals("Tenant [title=Dr, region=us-east-2, tenantProfileId=null, additionalInfo=null, country=null,"
        + " state=null, city=null, address=null, address2=null, zip=null, phone=null, email=null, createdTime=0,"
        + " id=null]", actualToStringResult);
    assertEquals("us-east-2", actualRegion);
    assertNull(actualTenant.getAddress());
    assertNull(actualTenant.getAddress2());
    assertNull(actualTenant.getCity());
    assertNull(actualTenant.getCountry());
    assertNull(actualTenant.getEmail());
    assertNull(actualTenant.getPhone());
    assertNull(actualTenant.getState());
    assertNull(actualTenant.getZip());
    assertNull(actualTenant.getId());
    assertNull(actualTenantProfileId);
    assertEquals(0L, actualTenant.getCreatedTime());
    assertEquals(1L, actualVersion.longValue());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link TenantId#SYS_TENANT_ID}.</li>
   *   <li>Then return Id is {@link TenantId#SYS_TENANT_ID} {@link TenantId#SYS_TENANT_ID}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Tenant#Tenant(TenantId)}
   *   <li>{@link Tenant#setRegion(String)}
   *   <li>{@link Tenant#setTitle(String)}
   *   <li>{@link Tenant#setVersion(Long)}
   *   <li>{@link Tenant#toString()}
   *   <li>{@link Tenant#getName()}
   *   <li>{@link Tenant#getRegion()}
   *   <li>{@link Tenant#getTenantProfileId()}
   *   <li>{@link Tenant#getTitle()}
   *   <li>{@link Tenant#getVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when SYS_TENANT_ID; then return Id is SYS_TENANT_ID SYS_TENANT_ID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Tenant.<init>()", "void Tenant.<init>(TenantId)", "String Tenant.getName()",
      "String Tenant.getRegion()", "TenantProfileId Tenant.getTenantProfileId()", "String Tenant.getTitle()",
      "Long Tenant.getVersion()", "void Tenant.setRegion(String)", "void Tenant.setTenantProfileId(TenantProfileId)",
      "void Tenant.setTitle(String)", "void Tenant.setVersion(Long)", "String Tenant.toString()"})
  void testGettersAndSetters_whenSys_tenant_id_thenReturnIdIsSys_tenant_idSys_tenant_id() {
    // Arrange
    TenantId id = TenantId.SYS_TENANT_ID;

    // Act
    Tenant actualTenant = new Tenant(id);
    actualTenant.setRegion("us-east-2");
    actualTenant.setTitle("Dr");
    actualTenant.setVersion(1L);
    String actualToStringResult = actualTenant.toString();
    String actualName = actualTenant.getName();
    String actualRegion = actualTenant.getRegion();
    TenantProfileId actualTenantProfileId = actualTenant.getTenantProfileId();
    String actualTitle = actualTenant.getTitle();
    Long actualVersion = actualTenant.getVersion();

    // Assert
    assertEquals("Dr", actualName);
    assertEquals("Dr", actualTitle);
    assertEquals(
        "Tenant [title=Dr, region=us-east-2, tenantProfileId=null, additionalInfo=null, country=null, state=null,"
            + " city=null, address=null, address2=null, zip=null, phone=null, email=null, createdTime=0, id=13814000"
            + "-1dd2-11b2-8080-808080808080]",
        actualToStringResult);
    assertEquals("us-east-2", actualRegion);
    assertNull(actualTenant.getAddress());
    assertNull(actualTenant.getAddress2());
    assertNull(actualTenant.getCity());
    assertNull(actualTenant.getCountry());
    assertNull(actualTenant.getEmail());
    assertNull(actualTenant.getPhone());
    assertNull(actualTenant.getState());
    assertNull(actualTenant.getZip());
    assertNull(actualTenantProfileId);
    assertEquals(0L, actualTenant.getCreatedTime());
    assertEquals(1L, actualVersion.longValue());
    TenantId expectedId = id.SYS_TENANT_ID;
    assertSame(expectedId, actualTenant.getId());
  }

  /**
   * Test {@link Tenant#Tenant(Tenant)}.
   * <ul>
   *   <li>When {@link Tenant#Tenant()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tenant#Tenant(Tenant)}
   */
  @Test
  @DisplayName("Test new Tenant(Tenant); when Tenant()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Tenant.<init>(Tenant)"})
  void testNewTenant_whenTenant() {
    // Arrange and Act
    Tenant actualTenant = new Tenant(new Tenant());

    // Assert
    assertTrue(actualTenant.getAdditionalInfo() instanceof NullNode);
    assertNull(actualTenant.getVersion());
    assertNull(actualTenant.getAddress());
    assertNull(actualTenant.getAddress2());
    assertNull(actualTenant.getCity());
    assertNull(actualTenant.getCountry());
    assertNull(actualTenant.getEmail());
    assertNull(actualTenant.getName());
    assertNull(actualTenant.getPhone());
    assertNull(actualTenant.getRegion());
    assertNull(actualTenant.getState());
    assertNull(actualTenant.getTitle());
    assertNull(actualTenant.getZip());
    assertNull(actualTenant.getUuidId());
    assertNull(actualTenant.getId());
    assertNull(actualTenant.getTenantId());
    assertNull(actualTenant.getTenantProfileId());
    assertEquals(0L, actualTenant.getCreatedTime());
  }

  /**
   * Test {@link Tenant#Tenant(Tenant)}.
   * <ul>
   *   <li>When {@link Tenant#Tenant(Tenant)} with tenant is {@link Tenant#Tenant()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tenant#Tenant(Tenant)}
   */
  @Test
  @DisplayName("Test new Tenant(Tenant); when Tenant(Tenant) with tenant is Tenant()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Tenant.<init>(Tenant)"})
  void testNewTenant_whenTenantWithTenantIsTenant() {
    // Arrange and Act
    Tenant actualTenant = new Tenant(new Tenant(new Tenant()));

    // Assert
    assertTrue(actualTenant.getAdditionalInfo() instanceof NullNode);
    assertNull(actualTenant.getVersion());
    assertNull(actualTenant.getAddress());
    assertNull(actualTenant.getAddress2());
    assertNull(actualTenant.getCity());
    assertNull(actualTenant.getCountry());
    assertNull(actualTenant.getEmail());
    assertNull(actualTenant.getName());
    assertNull(actualTenant.getPhone());
    assertNull(actualTenant.getRegion());
    assertNull(actualTenant.getState());
    assertNull(actualTenant.getTitle());
    assertNull(actualTenant.getZip());
    assertNull(actualTenant.getUuidId());
    assertNull(actualTenant.getId());
    assertNull(actualTenant.getTenantId());
    assertNull(actualTenant.getTenantProfileId());
    assertEquals(0L, actualTenant.getCreatedTime());
  }

  /**
   * Test {@link Tenant#Tenant(Tenant)}.
   * <ul>
   *   <li>When {@link Tenant#Tenant(Tenant)} with tenant is {@link Tenant#Tenant(Tenant)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tenant#Tenant(Tenant)}
   */
  @Test
  @DisplayName("Test new Tenant(Tenant); when Tenant(Tenant) with tenant is Tenant(Tenant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Tenant.<init>(Tenant)"})
  void testNewTenant_whenTenantWithTenantIsTenant2() {
    // Arrange and Act
    Tenant actualTenant = new Tenant(new Tenant(new Tenant(new Tenant())));

    // Assert
    assertTrue(actualTenant.getAdditionalInfo() instanceof NullNode);
    assertNull(actualTenant.getVersion());
    assertNull(actualTenant.getAddress());
    assertNull(actualTenant.getAddress2());
    assertNull(actualTenant.getCity());
    assertNull(actualTenant.getCountry());
    assertNull(actualTenant.getEmail());
    assertNull(actualTenant.getName());
    assertNull(actualTenant.getPhone());
    assertNull(actualTenant.getRegion());
    assertNull(actualTenant.getState());
    assertNull(actualTenant.getTitle());
    assertNull(actualTenant.getZip());
    assertNull(actualTenant.getUuidId());
    assertNull(actualTenant.getId());
    assertNull(actualTenant.getTenantId());
    assertNull(actualTenant.getTenantProfileId());
    assertEquals(0L, actualTenant.getCreatedTime());
  }

  /**
   * Test {@link Tenant#getTenantId()}.
   * <p>
   * Method under test: {@link Tenant#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantId Tenant.getTenantId()"})
  void testGetTenantId() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getTenantId());
  }

  /**
   * Test {@link Tenant#getId()}.
   * <p>
   * Method under test: {@link Tenant#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantId Tenant.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getId());
  }

  /**
   * Test {@link Tenant#getCreatedTime()}.
   * <p>
   * Method under test: {@link Tenant#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Tenant.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new Tenant()).getCreatedTime());
  }

  /**
   * Test {@link Tenant#getCountry()}.
   * <p>
   * Method under test: {@link Tenant#getCountry()}
   */
  @Test
  @DisplayName("Test getCountry()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Tenant.getCountry()"})
  void testGetCountry() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getCountry());
  }

  /**
   * Test {@link Tenant#getState()}.
   * <p>
   * Method under test: {@link Tenant#getState()}
   */
  @Test
  @DisplayName("Test getState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Tenant.getState()"})
  void testGetState() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getState());
  }

  /**
   * Test {@link Tenant#getCity()}.
   * <p>
   * Method under test: {@link Tenant#getCity()}
   */
  @Test
  @DisplayName("Test getCity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Tenant.getCity()"})
  void testGetCity() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getCity());
  }

  /**
   * Test {@link Tenant#getAddress()}.
   * <p>
   * Method under test: {@link Tenant#getAddress()}
   */
  @Test
  @DisplayName("Test getAddress()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Tenant.getAddress()"})
  void testGetAddress() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getAddress());
  }

  /**
   * Test {@link Tenant#getAddress2()}.
   * <p>
   * Method under test: {@link Tenant#getAddress2()}
   */
  @Test
  @DisplayName("Test getAddress2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Tenant.getAddress2()"})
  void testGetAddress2() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getAddress2());
  }

  /**
   * Test {@link Tenant#getZip()}.
   * <p>
   * Method under test: {@link Tenant#getZip()}
   */
  @Test
  @DisplayName("Test getZip()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Tenant.getZip()"})
  void testGetZip() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getZip());
  }

  /**
   * Test {@link Tenant#getPhone()}.
   * <p>
   * Method under test: {@link Tenant#getPhone()}
   */
  @Test
  @DisplayName("Test getPhone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Tenant.getPhone()"})
  void testGetPhone() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getPhone());
  }

  /**
   * Test {@link Tenant#getEmail()}.
   * <p>
   * Method under test: {@link Tenant#getEmail()}
   */
  @Test
  @DisplayName("Test getEmail()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Tenant.getEmail()"})
  void testGetEmail() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getEmail());
  }

  /**
   * Test {@link Tenant#getAdditionalInfo()}.
   * <ul>
   *   <li>Given {@link Tenant#Tenant(Tenant)} with tenant is {@link Tenant#Tenant()}.</li>
   *   <li>Then return {@link NullNode#instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tenant#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); given Tenant(Tenant) with tenant is Tenant(); then return instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode Tenant.getAdditionalInfo()"})
  void testGetAdditionalInfo_givenTenantWithTenantIsTenant_thenReturnInstance() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = (new Tenant(new Tenant())).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Test {@link Tenant#getAdditionalInfo()}.
   * <ul>
   *   <li>Given {@link Tenant#Tenant(Tenant)} with tenant is {@link Tenant#Tenant(Tenant)}.</li>
   *   <li>Then return {@link NullNode#instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tenant#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); given Tenant(Tenant) with tenant is Tenant(Tenant); then return instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode Tenant.getAdditionalInfo()"})
  void testGetAdditionalInfo_givenTenantWithTenantIsTenant_thenReturnInstance2() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = (new Tenant(new Tenant(new Tenant()))).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Test {@link Tenant#getAdditionalInfo()}.
   * <ul>
   *   <li>Given {@link Tenant#Tenant()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tenant#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); given Tenant(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode Tenant.getAdditionalInfo()"})
  void testGetAdditionalInfo_givenTenant_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getAdditionalInfo());
  }
}
