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
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class PageDataIterableByTenantIdEntityIdDiffblueTest {
  /**
   * Method under test:
   * {@link PageDataIterableByTenantIdEntityId#fetchPageData(PageLink)}
   */
  @Test
  void testFetchPageData() {
    // Arrange
    PageDataIterableByTenantIdEntityId.FetchFunction<Object> function = mock(
        PageDataIterableByTenantIdEntityId.FetchFunction.class);
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();
    when(function.fetch(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageDataIterableByTenantIdEntityId<Object> pageDataIterableByTenantIdEntityId = new PageDataIterableByTenantIdEntityId<>(
        function, TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, 3);

    // Act
    PageData<Object> actualFetchPageDataResult = pageDataIterableByTenantIdEntityId.fetchPageData(new PageLink(3));

    // Assert
    verify(function).fetch(isA(TenantId.class), isA(EntityId.class), isA(PageLink.class));
    assertSame(actualFetchPageDataResult.EMPTY_PAGE_DATA, actualFetchPageDataResult);
  }

  /**
   * Method under test:
   * {@link PageDataIterableByTenantIdEntityId#PageDataIterableByTenantIdEntityId(PageDataIterableByTenantIdEntityId.FetchFunction, TenantId, EntityId, int)}
   */
  @Test
  void testNewPageDataIterableByTenantIdEntityId() {
    // Arrange and Act
    PageDataIterableByTenantIdEntityId<Object> actualPageDataIterableByTenantIdEntityId = new PageDataIterableByTenantIdEntityId<>(
        mock(PageDataIterableByTenantIdEntityId.FetchFunction.class), TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID,
        3);

    // Assert
    assertFalse(actualPageDataIterableByTenantIdEntityId.hasNext());
  }
}
