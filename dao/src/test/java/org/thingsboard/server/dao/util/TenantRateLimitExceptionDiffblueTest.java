package org.thingsboard.server.dao.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TenantRateLimitExceptionDiffblueTest {
  /**
   * Test new {@link TenantRateLimitException} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link TenantRateLimitException}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TenantRateLimitException.<init>()"})
  public void testNewTenantRateLimitException() {
    // Arrange and Act
    TenantRateLimitException actualTenantRateLimitException = new TenantRateLimitException();

    // Assert
    assertNull(actualTenantRateLimitException.getMessage());
    assertNull(actualTenantRateLimitException.getCause());
    assertEquals(0, actualTenantRateLimitException.getSuppressed().length);
  }
}
