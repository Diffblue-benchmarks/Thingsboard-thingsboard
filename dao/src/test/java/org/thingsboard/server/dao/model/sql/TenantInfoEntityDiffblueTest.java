package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TenantInfoEntityDiffblueTest {
  /**
   * Test {@link TenantInfoEntity#equals(Object)}, and {@link TenantInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantInfoEntity#equals(Object)}
   *   <li>{@link TenantInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TenantInfoEntity.equals(Object)", "int TenantInfoEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantInfoEntity#equals(Object)}
   *   <li>{@link TenantInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TenantInfoEntity.equals(Object)", "int TenantInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantInfoEntity(), null);
  }

  /**
   * Test {@link TenantInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TenantInfoEntity.equals(Object)", "int TenantInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantInfoEntity(), "Different type to TenantInfoEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantInfoEntity#TenantInfoEntity()}
   *   <li>{@link TenantInfoEntity#setTenantProfileName(String)}
   *   <li>{@link TenantInfoEntity#toString()}
   *   <li>{@link TenantInfoEntity#getTenantProfileName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TenantInfoEntity.<init>()", "String TenantInfoEntity.getTenantProfileName()",
      "void TenantInfoEntity.setTenantProfileName(String)", "String TenantInfoEntity.toString()"})
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
}
