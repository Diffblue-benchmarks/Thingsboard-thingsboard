package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.domain.Domain;
import org.thingsboard.server.common.data.id.DomainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

public class DomainEntityDiffblueTest {
  /**
   * Test {@link DomainEntity#equals(Object)}, and
   * {@link DomainEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DomainEntity#equals(Object)}
   *   <li>{@link DomainEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DomainEntity domainEntity = new DomainEntity();
    domainEntity.setCreatedTime(1L);
    domainEntity.setId(ModelConstants.NULL_UUID);
    domainEntity.setName("Name");
    domainEntity.setOauth2Enabled(true);
    domainEntity.setPropagateToEdge(true);
    domainEntity.setTenantId(ModelConstants.NULL_UUID);
    domainEntity.setUuid(ModelConstants.NULL_UUID);

    DomainEntity domainEntity2 = new DomainEntity();
    domainEntity2.setCreatedTime(1L);
    domainEntity2.setId(ModelConstants.NULL_UUID);
    domainEntity2.setName("Name");
    domainEntity2.setOauth2Enabled(true);
    domainEntity2.setPropagateToEdge(true);
    domainEntity2.setTenantId(ModelConstants.NULL_UUID);
    domainEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(domainEntity, domainEntity2);
    int expectedHashCodeResult = domainEntity.hashCode();
    assertEquals(expectedHashCodeResult, domainEntity2.hashCode());
  }

  /**
   * Test {@link DomainEntity#equals(Object)}, and
   * {@link DomainEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DomainEntity#equals(Object)}
   *   <li>{@link DomainEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DomainEntity domainEntity = new DomainEntity();
    domainEntity.setCreatedTime(1L);
    domainEntity.setId(ModelConstants.NULL_UUID);
    domainEntity.setName("Name");
    domainEntity.setOauth2Enabled(true);
    domainEntity.setPropagateToEdge(true);
    domainEntity.setTenantId(ModelConstants.NULL_UUID);
    domainEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(domainEntity, domainEntity);
    int expectedHashCodeResult = domainEntity.hashCode();
    assertEquals(expectedHashCodeResult, domainEntity.hashCode());
  }

  /**
   * Test {@link DomainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DomainEntity domainEntity = new DomainEntity();
    domainEntity.setCreatedTime(3L);
    domainEntity.setId(ModelConstants.NULL_UUID);
    domainEntity.setName("Name");
    domainEntity.setOauth2Enabled(true);
    domainEntity.setPropagateToEdge(true);
    domainEntity.setTenantId(ModelConstants.NULL_UUID);
    domainEntity.setUuid(ModelConstants.NULL_UUID);

    DomainEntity domainEntity2 = new DomainEntity();
    domainEntity2.setCreatedTime(1L);
    domainEntity2.setId(ModelConstants.NULL_UUID);
    domainEntity2.setName("Name");
    domainEntity2.setOauth2Enabled(true);
    domainEntity2.setPropagateToEdge(true);
    domainEntity2.setTenantId(ModelConstants.NULL_UUID);
    domainEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainEntity, domainEntity2);
  }

  /**
   * Test {@link DomainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DomainEntity domainEntity = new DomainEntity();
    domainEntity.setCreatedTime(1L);
    domainEntity.setId(ModelConstants.NULL_UUID);
    domainEntity.setName(null);
    domainEntity.setOauth2Enabled(true);
    domainEntity.setPropagateToEdge(true);
    domainEntity.setTenantId(ModelConstants.NULL_UUID);
    domainEntity.setUuid(ModelConstants.NULL_UUID);

    DomainEntity domainEntity2 = new DomainEntity();
    domainEntity2.setCreatedTime(1L);
    domainEntity2.setId(ModelConstants.NULL_UUID);
    domainEntity2.setName("Name");
    domainEntity2.setOauth2Enabled(true);
    domainEntity2.setPropagateToEdge(true);
    domainEntity2.setTenantId(ModelConstants.NULL_UUID);
    domainEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainEntity, domainEntity2);
  }

  /**
   * Test {@link DomainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DomainEntity domainEntity = new DomainEntity();
    domainEntity.setCreatedTime(1L);
    domainEntity.setId(ModelConstants.NULL_UUID);
    domainEntity.setName("org.thingsboard.server.dao.model.sql.DomainEntity");
    domainEntity.setOauth2Enabled(true);
    domainEntity.setPropagateToEdge(true);
    domainEntity.setTenantId(ModelConstants.NULL_UUID);
    domainEntity.setUuid(ModelConstants.NULL_UUID);

    DomainEntity domainEntity2 = new DomainEntity();
    domainEntity2.setCreatedTime(1L);
    domainEntity2.setId(ModelConstants.NULL_UUID);
    domainEntity2.setName("Name");
    domainEntity2.setOauth2Enabled(true);
    domainEntity2.setPropagateToEdge(true);
    domainEntity2.setTenantId(ModelConstants.NULL_UUID);
    domainEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainEntity, domainEntity2);
  }

  /**
   * Test {@link DomainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DomainEntity domainEntity = new DomainEntity();
    domainEntity.setCreatedTime(1L);
    domainEntity.setId(ModelConstants.NULL_UUID);
    domainEntity.setName("Name");
    domainEntity.setOauth2Enabled(false);
    domainEntity.setPropagateToEdge(true);
    domainEntity.setTenantId(ModelConstants.NULL_UUID);
    domainEntity.setUuid(ModelConstants.NULL_UUID);

    DomainEntity domainEntity2 = new DomainEntity();
    domainEntity2.setCreatedTime(1L);
    domainEntity2.setId(ModelConstants.NULL_UUID);
    domainEntity2.setName("Name");
    domainEntity2.setOauth2Enabled(true);
    domainEntity2.setPropagateToEdge(true);
    domainEntity2.setTenantId(ModelConstants.NULL_UUID);
    domainEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainEntity, domainEntity2);
  }

  /**
   * Test {@link DomainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DomainEntity domainEntity = new DomainEntity();
    domainEntity.setCreatedTime(1L);
    domainEntity.setId(ModelConstants.NULL_UUID);
    domainEntity.setName("Name");
    domainEntity.setOauth2Enabled(null);
    domainEntity.setPropagateToEdge(true);
    domainEntity.setTenantId(ModelConstants.NULL_UUID);
    domainEntity.setUuid(ModelConstants.NULL_UUID);

    DomainEntity domainEntity2 = new DomainEntity();
    domainEntity2.setCreatedTime(1L);
    domainEntity2.setId(ModelConstants.NULL_UUID);
    domainEntity2.setName("Name");
    domainEntity2.setOauth2Enabled(true);
    domainEntity2.setPropagateToEdge(true);
    domainEntity2.setTenantId(ModelConstants.NULL_UUID);
    domainEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainEntity, domainEntity2);
  }

  /**
   * Test {@link DomainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DomainEntity domainEntity = new DomainEntity();
    domainEntity.setCreatedTime(1L);
    domainEntity.setId(ModelConstants.NULL_UUID);
    domainEntity.setName("Name");
    domainEntity.setOauth2Enabled(true);
    domainEntity.setPropagateToEdge(false);
    domainEntity.setTenantId(ModelConstants.NULL_UUID);
    domainEntity.setUuid(ModelConstants.NULL_UUID);

    DomainEntity domainEntity2 = new DomainEntity();
    domainEntity2.setCreatedTime(1L);
    domainEntity2.setId(ModelConstants.NULL_UUID);
    domainEntity2.setName("Name");
    domainEntity2.setOauth2Enabled(true);
    domainEntity2.setPropagateToEdge(true);
    domainEntity2.setTenantId(ModelConstants.NULL_UUID);
    domainEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainEntity, domainEntity2);
  }

  /**
   * Test {@link DomainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DomainEntity domainEntity = new DomainEntity();
    domainEntity.setCreatedTime(1L);
    domainEntity.setId(ModelConstants.NULL_UUID);
    domainEntity.setName("Name");
    domainEntity.setOauth2Enabled(true);
    domainEntity.setPropagateToEdge(null);
    domainEntity.setTenantId(ModelConstants.NULL_UUID);
    domainEntity.setUuid(ModelConstants.NULL_UUID);

    DomainEntity domainEntity2 = new DomainEntity();
    domainEntity2.setCreatedTime(1L);
    domainEntity2.setId(ModelConstants.NULL_UUID);
    domainEntity2.setName("Name");
    domainEntity2.setOauth2Enabled(true);
    domainEntity2.setPropagateToEdge(true);
    domainEntity2.setTenantId(ModelConstants.NULL_UUID);
    domainEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainEntity, domainEntity2);
  }

  /**
   * Test {@link DomainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DomainEntity domainEntity = new DomainEntity();
    domainEntity.setCreatedTime(1L);
    domainEntity.setId(ModelConstants.NULL_UUID);
    domainEntity.setName("Name");
    domainEntity.setOauth2Enabled(true);
    domainEntity.setPropagateToEdge(true);
    domainEntity.setTenantId(UUID.randomUUID());
    domainEntity.setUuid(ModelConstants.NULL_UUID);

    DomainEntity domainEntity2 = new DomainEntity();
    domainEntity2.setCreatedTime(1L);
    domainEntity2.setId(ModelConstants.NULL_UUID);
    domainEntity2.setName("Name");
    domainEntity2.setOauth2Enabled(true);
    domainEntity2.setPropagateToEdge(true);
    domainEntity2.setTenantId(ModelConstants.NULL_UUID);
    domainEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainEntity, domainEntity2);
  }

  /**
   * Test {@link DomainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DomainEntity domainEntity = new DomainEntity();
    domainEntity.setCreatedTime(1L);
    domainEntity.setId(ModelConstants.NULL_UUID);
    domainEntity.setName("Name");
    domainEntity.setOauth2Enabled(true);
    domainEntity.setPropagateToEdge(true);
    domainEntity.setTenantId(null);
    domainEntity.setUuid(ModelConstants.NULL_UUID);

    DomainEntity domainEntity2 = new DomainEntity();
    domainEntity2.setCreatedTime(1L);
    domainEntity2.setId(ModelConstants.NULL_UUID);
    domainEntity2.setName("Name");
    domainEntity2.setOauth2Enabled(true);
    domainEntity2.setPropagateToEdge(true);
    domainEntity2.setTenantId(ModelConstants.NULL_UUID);
    domainEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainEntity, domainEntity2);
  }

  /**
   * Test {@link DomainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DomainEntity domainEntity = new DomainEntity();
    domainEntity.setCreatedTime(1L);
    domainEntity.setId(ModelConstants.NULL_UUID);
    domainEntity.setName("Name");
    domainEntity.setOauth2Enabled(true);
    domainEntity.setPropagateToEdge(true);
    domainEntity.setTenantId(ModelConstants.NULL_UUID);
    domainEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainEntity, null);
  }

  /**
   * Test {@link DomainEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DomainEntity domainEntity = new DomainEntity();
    domainEntity.setCreatedTime(1L);
    domainEntity.setId(ModelConstants.NULL_UUID);
    domainEntity.setName("Name");
    domainEntity.setOauth2Enabled(true);
    domainEntity.setPropagateToEdge(true);
    domainEntity.setTenantId(ModelConstants.NULL_UUID);
    domainEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainEntity, "Different type to DomainEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DomainEntity#DomainEntity()}
   *   <li>{@link DomainEntity#setName(String)}
   *   <li>{@link DomainEntity#setOauth2Enabled(Boolean)}
   *   <li>{@link DomainEntity#setPropagateToEdge(Boolean)}
   *   <li>{@link DomainEntity#setTenantId(UUID)}
   *   <li>{@link DomainEntity#toString()}
   *   <li>{@link DomainEntity#getName()}
   *   <li>{@link DomainEntity#getOauth2Enabled()}
   *   <li>{@link DomainEntity#getPropagateToEdge()}
   *   <li>{@link DomainEntity#getTenantId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DomainEntity actualDomainEntity = new DomainEntity();
    actualDomainEntity.setName("Name");
    actualDomainEntity.setOauth2Enabled(true);
    actualDomainEntity.setPropagateToEdge(true);
    UUID tenantId = ModelConstants.NULL_UUID;
    actualDomainEntity.setTenantId(tenantId);
    String actualToStringResult = actualDomainEntity.toString();
    String actualName = actualDomainEntity.getName();
    Boolean actualOauth2Enabled = actualDomainEntity.getOauth2Enabled();
    Boolean actualPropagateToEdge = actualDomainEntity.getPropagateToEdge();
    UUID actualTenantId = actualDomainEntity.getTenantId();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTenantId.toString());
    assertEquals(
        "DomainEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, name=Name, oauth2Enabled=true, propagateToEdge"
            + "=true)",
        actualToStringResult);
    assertEquals("Name", actualName);
    assertEquals(0L, actualDomainEntity.getCreatedTime());
    assertTrue(actualOauth2Enabled);
    assertTrue(actualPropagateToEdge);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link DomainEntity#DomainEntity(Domain)}.
   * <ul>
   *   <li>Then return TenantId toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainEntity#DomainEntity(Domain)}
   */
  @Test
  public void testNewDomainEntity_thenReturnTenantIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    Domain domain = new Domain();
    domain.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    DomainEntity actualDomainEntity = new DomainEntity(domain);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualDomainEntity.getTenantId().toString());
    assertNull(actualDomainEntity.getName());
    assertNull(actualDomainEntity.getId());
    assertNull(actualDomainEntity.getUuid());
    assertEquals(0L, actualDomainEntity.getCreatedTime());
    assertFalse(actualDomainEntity.getOauth2Enabled());
    assertFalse(actualDomainEntity.getPropagateToEdge());
  }

  /**
   * Test {@link DomainEntity#DomainEntity(Domain)}.
   * <ul>
   *   <li>When {@link Domain#Domain()}.</li>
   *   <li>Then return TenantId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainEntity#DomainEntity(Domain)}
   */
  @Test
  public void testNewDomainEntity_whenDomain_thenReturnTenantIdIsNull() {
    // Arrange and Act
    DomainEntity actualDomainEntity = new DomainEntity(new Domain());

    // Assert
    assertNull(actualDomainEntity.getName());
    assertNull(actualDomainEntity.getId());
    assertNull(actualDomainEntity.getUuid());
    assertNull(actualDomainEntity.getTenantId());
    assertEquals(0L, actualDomainEntity.getCreatedTime());
    assertFalse(actualDomainEntity.getOauth2Enabled());
    assertFalse(actualDomainEntity.getPropagateToEdge());
  }

  /**
   * Test {@link DomainEntity#toData()}.
   * <ul>
   *   <li>Given {@link DomainEntity#DomainEntity()} TenantId is randomUUID.</li>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainEntity#toData()}
   */
  @Test
  public void testToData_givenDomainEntityTenantIdIsRandomUUID_thenReturnNotTenantIdNullUid() {
    // Arrange
    DomainEntity domainEntity = new DomainEntity();
    domainEntity.setCreatedTime(1L);
    domainEntity.setId(ModelConstants.NULL_UUID);
    domainEntity.setName("Name");
    domainEntity.setOauth2Enabled(true);
    domainEntity.setPropagateToEdge(true);
    domainEntity.setUuid(ModelConstants.NULL_UUID);
    UUID tenantId = UUID.randomUUID();
    domainEntity.setTenantId(tenantId);

    // Act and Assert
    TenantId tenantId2 = domainEntity.toData().getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link DomainEntity#toData()}.
   * <ul>
   *   <li>Then return TenantId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainEntity#toData()}
   */
  @Test
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    DomainEntity domainEntity = new DomainEntity();
    domainEntity.setCreatedTime(1L);
    domainEntity.setId(ModelConstants.NULL_UUID);
    domainEntity.setName("Name");
    domainEntity.setOauth2Enabled(true);
    domainEntity.setPropagateToEdge(true);
    domainEntity.setUuid(ModelConstants.NULL_UUID);
    domainEntity.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    TenantId tenantId = domainEntity.toData().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link DomainEntity#toData()}.
   * <ul>
   *   <li>Then return UuidId toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainEntity#toData()}
   */
  @Test
  public void testToData_thenReturnUuidIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    DomainEntity domainEntity = new DomainEntity();
    domainEntity.setCreatedTime(1L);
    domainEntity.setId(ModelConstants.NULL_UUID);
    domainEntity.setName("Name");
    domainEntity.setOauth2Enabled(true);
    domainEntity.setPropagateToEdge(true);
    domainEntity.setUuid(ModelConstants.NULL_UUID);
    domainEntity.setTenantId(null);

    // Act
    Domain actualToDataResult = domainEntity.toData();

    // Assert
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("Name", actualToDataResult.getName());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    DomainId id = actualToDataResult.getId();
    assertEquals(EntityType.DOMAIN, id.getEntityType());
    assertTrue(actualToDataResult.isOauth2Enabled());
    assertTrue(actualToDataResult.isPropagateToEdge());
    assertTrue(id.isNullUid());
    assertSame(uuidId, id.getId());
  }
}
