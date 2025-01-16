package org.thingsboard.server.common.data.page;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.TenantId;

class PageDataIterableByTenantDiffblueTest {
  /**
   * Test
   * {@link PageDataIterableByTenant#PageDataIterableByTenant(FetchFunction, TenantId, int)}.
   * <p>
   * Method under test:
   * {@link PageDataIterableByTenant#PageDataIterableByTenant(PageDataIterableByTenant.FetchFunction, TenantId, int)}
   */
  @Test
  @DisplayName("Test new PageDataIterableByTenant(FetchFunction, TenantId, int)")
  void testNewPageDataIterableByTenant() {
    // Arrange and Act
    PageDataIterableByTenant<Object> actualPageDataIterableByTenant = new PageDataIterableByTenant<>(
        mock(PageDataIterableByTenant.FetchFunction.class), TenantId.SYS_TENANT_ID, 3);

    // Assert
    assertFalse(actualPageDataIterableByTenant.hasNext());
  }

  /**
   * Test {@link PageDataIterableByTenant#fetchPageData(PageLink)}.
   * <p>
   * Method under test: {@link PageDataIterableByTenant#fetchPageData(PageLink)}
   */
  @Test
  @DisplayName("Test fetchPageData(PageLink)")
  void testFetchPageData() {
    // Arrange
    PageDataIterableByTenant.FetchFunction<Object> function = mock(PageDataIterableByTenant.FetchFunction.class);
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();
    when(function.fetch(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageDataIterableByTenant<Object> pageDataIterableByTenant = new PageDataIterableByTenant<>(function,
        TenantId.SYS_TENANT_ID, 3);

    // Act
    PageData<Object> actualFetchPageDataResult = pageDataIterableByTenant.fetchPageData(new PageLink(3));

    // Assert
    verify(function).fetch(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFetchPageDataResult.EMPTY_PAGE_DATA, actualFetchPageDataResult);
  }
}
