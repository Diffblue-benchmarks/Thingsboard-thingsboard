package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractTenantEntityDiffblueTest {
  /**
   * Test {@link AbstractTenantEntity#equals(Object)}, and {@link AbstractTenantEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractTenantEntity.equals(Object)", "int AbstractTenantEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    TenantEntity tenantEntity2 = new TenantEntity();

    // Act and Assert
    assertEquals(tenantEntity, tenantEntity2);
    int expectedHashCodeResult = tenantEntity.hashCode();
    assertEquals(expectedHashCodeResult, tenantEntity2.hashCode());
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}, and {@link AbstractTenantEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractTenantEntity.equals(Object)", "int AbstractTenantEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    // Act and Assert
    assertEquals(tenantEntity, tenantEntity);
    int expectedHashCodeResult = tenantEntity.hashCode();
    assertEquals(expectedHashCodeResult, tenantEntity.hashCode());
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractTenantEntity.equals(Object)", "int AbstractTenantEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantEntity(), null);
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractTenantEntity.equals(Object)", "int AbstractTenantEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantEntity(), "Different type to AbstractTenantEntity");
  }
}
