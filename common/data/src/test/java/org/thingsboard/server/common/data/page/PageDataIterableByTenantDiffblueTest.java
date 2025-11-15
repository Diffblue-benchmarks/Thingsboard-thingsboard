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
package org.thingsboard.server.common.data.page;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.TenantId;

class PageDataIterableByTenantDiffblueTest {
  /**
   * Method under test: {@link PageDataIterableByTenant#fetchPageData(PageLink)}
   */
  @Test
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

  /**
   * Method under test:
   * {@link PageDataIterableByTenant#PageDataIterableByTenant(PageDataIterableByTenant.FetchFunction, TenantId, int)}
   */
  @Test
  void testNewPageDataIterableByTenant() {
    // Arrange and Act
    PageDataIterableByTenant<Object> actualPageDataIterableByTenant = new PageDataIterableByTenant<>(
        mock(PageDataIterableByTenant.FetchFunction.class), TenantId.SYS_TENANT_ID, 3);

    // Assert
    assertFalse(actualPageDataIterableByTenant.hasNext());
  }
}
