package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class TenantProfileEntityDiffblueTest {
  /**
   * Test {@link TenantProfileEntity#equals(Object)}, and
   * {@link TenantProfileEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantProfileEntity#equals(Object)}
   *   <li>{@link TenantProfileEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(tenantProfileEntity, tenantProfileEntity2);
    int expectedHashCodeResult = tenantProfileEntity.hashCode();
    assertEquals(expectedHashCodeResult, tenantProfileEntity2.hashCode());
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}, and
   * {@link TenantProfileEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantProfileEntity#equals(Object)}
   *   <li>{@link TenantProfileEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(tenantProfileEntity, tenantProfileEntity);
    int expectedHashCodeResult = tenantProfileEntity.hashCode();
    assertEquals(expectedHashCodeResult, tenantProfileEntity.hashCode());
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(3L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tenantProfileEntity, tenantProfileEntity2);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(false);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tenantProfileEntity, tenantProfileEntity2);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("Name");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tenantProfileEntity, tenantProfileEntity2);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription(null);
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tenantProfileEntity, tenantProfileEntity2);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(false);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tenantProfileEntity, tenantProfileEntity2);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("The characteristics of someone or something");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tenantProfileEntity, tenantProfileEntity2);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName(null);
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tenantProfileEntity, tenantProfileEntity2);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(MissingNode.getInstance());
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tenantProfileEntity, tenantProfileEntity2);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(null);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tenantProfileEntity, tenantProfileEntity2);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(mock(JsonNode.class));
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    TenantProfileEntity tenantProfileEntity2 = new TenantProfileEntity();
    tenantProfileEntity2.setCreatedTime(1L);
    tenantProfileEntity2.setDefault(true);
    tenantProfileEntity2.setDescription("The characteristics of someone or something");
    tenantProfileEntity2.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity2.setIsolatedTbRuleEngine(true);
    tenantProfileEntity2.setName("Name");
    tenantProfileEntity2.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tenantProfileEntity, tenantProfileEntity2);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tenantProfileEntity, null);
  }

  /**
   * Test {@link TenantProfileEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tenantProfileEntity, "Different type to TenantProfileEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantProfileEntity#TenantProfileEntity()}
   *   <li>{@link TenantProfileEntity#setDefault(boolean)}
   *   <li>{@link TenantProfileEntity#setDescription(String)}
   *   <li>{@link TenantProfileEntity#setIsolatedTbRuleEngine(boolean)}
   *   <li>{@link TenantProfileEntity#setName(String)}
   *   <li>{@link TenantProfileEntity#setProfileData(JsonNode)}
   *   <li>{@link TenantProfileEntity#toString()}
   *   <li>{@link TenantProfileEntity#getDescription()}
   *   <li>{@link TenantProfileEntity#getName()}
   *   <li>{@link TenantProfileEntity#getProfileData()}
   *   <li>{@link TenantProfileEntity#isDefault()}
   *   <li>{@link TenantProfileEntity#isIsolatedTbRuleEngine()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    TenantProfileEntity actualTenantProfileEntity = new TenantProfileEntity();
    actualTenantProfileEntity.setDefault(true);
    actualTenantProfileEntity.setDescription("The characteristics of someone or something");
    actualTenantProfileEntity.setIsolatedTbRuleEngine(true);
    actualTenantProfileEntity.setName("Name");
    JsonNode profileData = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualTenantProfileEntity.setProfileData(profileData);
    String actualToStringResult = actualTenantProfileEntity.toString();
    String actualDescription = actualTenantProfileEntity.getDescription();
    String actualName = actualTenantProfileEntity.getName();
    JsonNode actualProfileData = actualTenantProfileEntity.getProfileData();
    boolean actualIsDefaultResult = actualTenantProfileEntity.isDefault();
    boolean actualIsIsolatedTbRuleEngineResult = actualTenantProfileEntity.isIsolatedTbRuleEngine();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals(
        "TenantProfileEntity(name=Name, description=The characteristics of someone or something, isDefault=true,"
            + " isolatedTbRuleEngine=true, profileData={\"isPublic\":true})",
        actualToStringResult);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(0L, actualTenantProfileEntity.getCreatedTime());
    assertTrue(actualIsDefaultResult);
    assertTrue(actualIsIsolatedTbRuleEngineResult);
    assertSame(profileData, actualProfileData);
  }

  /**
   * Test {@link TenantProfileEntity#toData()}.
   * <ul>
   *   <li>Given {@link TenantProfileEntity#TenantProfileEntity(TenantProfile)} with
   * tenantProfile is {@link TenantProfile#TenantProfile()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileEntity#toData()}
   */
  @Test
  public void testToData_givenTenantProfileEntityWithTenantProfileIsTenantProfile() {
    // Arrange, Act and Assert
    byte[] profileDataBytes = (new TenantProfileEntity(new TenantProfile())).toData().getProfileDataBytes();
    assertEquals(1905, profileDataBytes.length);
    assertEquals(':', profileDataBytes[1899]);
    assertEquals(':', profileDataBytes[24]);
    assertEquals(':', profileDataBytes[Short.SIZE]);
    assertEquals('C', profileDataBytes[1885]);
    assertEquals('"', profileDataBytes[1]);
    assertEquals('"', profileDataBytes[15]);
    assertEquals('"', profileDataBytes[18]);
    assertEquals('"', profileDataBytes[1898]);
    assertEquals('"', profileDataBytes[23]);
    assertEquals('a', profileDataBytes[10]);
    assertEquals('a', profileDataBytes[1893]);
    assertEquals('c', profileDataBytes[2]);
    assertEquals('e', profileDataBytes[1882]);
    assertEquals('e', profileDataBytes[1884]);
    assertEquals('e', profileDataBytes[22]);
    assertEquals('f', profileDataBytes[1888]);
    assertEquals('f', profileDataBytes[5]);
    assertEquals('g', profileDataBytes[1890]);
    assertEquals('g', profileDataBytes[7]);
    assertEquals('i', profileDataBytes[12]);
    assertEquals('i', profileDataBytes[1889]);
    assertEquals('i', profileDataBytes[1895]);
    assertEquals('i', profileDataBytes[6]);
    assertEquals('l', profileDataBytes[1902]);
    assertEquals('l', profileDataBytes[1903]);
    assertEquals('n', profileDataBytes[14]);
    assertEquals('n', profileDataBytes[1887]);
    assertEquals('n', profileDataBytes[1897]);
    assertEquals('n', profileDataBytes[1900]);
    assertEquals('n', profileDataBytes[4]);
    assertEquals('o', profileDataBytes[13]);
    assertEquals('o', profileDataBytes[1886]);
    assertEquals('o', profileDataBytes[1896]);
    assertEquals('o', profileDataBytes[3]);
    assertEquals('p', profileDataBytes[21]);
    assertEquals('q', profileDataBytes[1880]);
    assertEquals('r', profileDataBytes[1892]);
    assertEquals('r', profileDataBytes[9]);
    assertEquals('t', profileDataBytes[11]);
    assertEquals('t', profileDataBytes[1894]);
    assertEquals('t', profileDataBytes[19]);
    assertEquals('u', profileDataBytes[1881]);
    assertEquals('u', profileDataBytes[1883]);
    assertEquals('u', profileDataBytes[1891]);
    assertEquals('u', profileDataBytes[1901]);
    assertEquals('u', profileDataBytes[8]);
    assertEquals('y', profileDataBytes[20]);
    assertEquals('{', profileDataBytes[0]);
    assertEquals('{', profileDataBytes[17]);
    assertEquals('}', profileDataBytes[1904]);
  }

  /**
   * Test {@link TenantProfileEntity#toData()}.
   * <ul>
   *   <li>Given {@link TenantProfileEntity#TenantProfileEntity()}.</li>
   *   <li>Then return ProfileDataBytes is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileEntity#toData()}
   */
  @Test
  public void testToData_givenTenantProfileEntity_thenReturnProfileDataBytesIsNull() {
    // Arrange and Act
    TenantProfile actualToDataResult = (new TenantProfileEntity()).toData();

    // Assert
    assertNull(actualToDataResult.getProfileDataBytes());
    assertNull(actualToDataResult.getDescription());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getUuidId());
    TenantProfileId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(actualToDataResult.isDefault());
    assertFalse(actualToDataResult.isIsolatedTbRuleEngine());
    assertFalse(id.isNullUid());
  }

  /**
   * Test {@link TenantProfileEntity#toData()}.
   * <ul>
   *   <li>Given {@link TenantProfile#TenantProfile(TenantProfile)} with
   * tenantProfile is {@link TenantProfile#TenantProfile()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileEntity#toData()}
   */
  @Test
  public void testToData_givenTenantProfileWithTenantProfileIsTenantProfile() {
    // Arrange, Act and Assert
    byte[] profileDataBytes = (new TenantProfileEntity(new TenantProfile(new TenantProfile()))).toData()
        .getProfileDataBytes();
    assertEquals(1905, profileDataBytes.length);
    assertEquals(':', profileDataBytes[1899]);
    assertEquals(':', profileDataBytes[24]);
    assertEquals(':', profileDataBytes[Short.SIZE]);
    assertEquals('C', profileDataBytes[1885]);
    assertEquals('"', profileDataBytes[1]);
    assertEquals('"', profileDataBytes[15]);
    assertEquals('"', profileDataBytes[18]);
    assertEquals('"', profileDataBytes[1898]);
    assertEquals('"', profileDataBytes[23]);
    assertEquals('a', profileDataBytes[10]);
    assertEquals('a', profileDataBytes[1893]);
    assertEquals('c', profileDataBytes[2]);
    assertEquals('e', profileDataBytes[1882]);
    assertEquals('e', profileDataBytes[1884]);
    assertEquals('e', profileDataBytes[22]);
    assertEquals('f', profileDataBytes[1888]);
    assertEquals('f', profileDataBytes[5]);
    assertEquals('g', profileDataBytes[1890]);
    assertEquals('g', profileDataBytes[7]);
    assertEquals('i', profileDataBytes[12]);
    assertEquals('i', profileDataBytes[1889]);
    assertEquals('i', profileDataBytes[1895]);
    assertEquals('i', profileDataBytes[6]);
    assertEquals('l', profileDataBytes[1902]);
    assertEquals('l', profileDataBytes[1903]);
    assertEquals('n', profileDataBytes[14]);
    assertEquals('n', profileDataBytes[1887]);
    assertEquals('n', profileDataBytes[1897]);
    assertEquals('n', profileDataBytes[1900]);
    assertEquals('n', profileDataBytes[4]);
    assertEquals('o', profileDataBytes[13]);
    assertEquals('o', profileDataBytes[1886]);
    assertEquals('o', profileDataBytes[1896]);
    assertEquals('o', profileDataBytes[3]);
    assertEquals('p', profileDataBytes[21]);
    assertEquals('q', profileDataBytes[1880]);
    assertEquals('r', profileDataBytes[1892]);
    assertEquals('r', profileDataBytes[9]);
    assertEquals('t', profileDataBytes[11]);
    assertEquals('t', profileDataBytes[1894]);
    assertEquals('t', profileDataBytes[19]);
    assertEquals('u', profileDataBytes[1881]);
    assertEquals('u', profileDataBytes[1883]);
    assertEquals('u', profileDataBytes[1891]);
    assertEquals('u', profileDataBytes[1901]);
    assertEquals('u', profileDataBytes[8]);
    assertEquals('y', profileDataBytes[20]);
    assertEquals('{', profileDataBytes[0]);
    assertEquals('{', profileDataBytes[17]);
    assertEquals('}', profileDataBytes[1904]);
  }

  /**
   * Test {@link TenantProfileEntity#toData()}.
   * <ul>
   *   <li>Then return UuidId toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileEntity#toData()}
   */
  @Test
  public void testToData_thenReturnUuidIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(ModelConstants.NULL_UUID);
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setUuid(ModelConstants.NULL_UUID);
    tenantProfileEntity.setProfileData(MissingNode.getInstance());

    // Act
    TenantProfile actualToDataResult = tenantProfileEntity.toData();

    // Assert
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("Name", actualToDataResult.getName());
    assertEquals("The characteristics of someone or something", actualToDataResult.getDescription());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertTrue(actualToDataResult.isDefault());
    assertTrue(actualToDataResult.isIsolatedTbRuleEngine());
    TenantProfileId id = actualToDataResult.getId();
    assertTrue(id.isNullUid());
    assertSame(uuidId, id.getId());
  }
}
