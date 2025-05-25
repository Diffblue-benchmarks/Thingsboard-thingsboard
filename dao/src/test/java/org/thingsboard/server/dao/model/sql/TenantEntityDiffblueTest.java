package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TenantEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantEntity#TenantEntity()}
   *   <li>{@link TenantEntity#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TenantEntity.<init>()", "java.lang.String TenantEntity.toString()"})
  public void testGettersAndSetters() {
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
}
